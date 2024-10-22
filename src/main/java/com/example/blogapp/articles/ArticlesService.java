package com.example.blogapp.articles;

import com.example.blogapp.articles.dtos.CreateArticleRequest;
import com.example.blogapp.articles.dtos.UpdateArticleRequest;
import com.example.blogapp.user.UserEntity;
import com.example.blogapp.user.UsersRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;
@Getter
@Service
public class ArticlesService {
    private final ArticlesRepository articlesRepository;
    private UsersRepository usersRepository;
    public ArticlesService(ArticlesRepository articlesRepository, UsersRepository usersRepository) {
        this.articlesRepository = articlesRepository;
        this.usersRepository = usersRepository;
    }
    public Iterable<ArticleEntity> getAllArticles() {
        return articlesRepository.findAll();
    }
    public ArticleEntity getArticleBySlug(String slug) throws ArticleNotFoundException {
        var article = articlesRepository.findBySlug(slug);
        if (article == null) {
            throw new ArticleNotFoundException(slug);
        }
        return article;
    }
    public ArticleEntity createArticle(CreateArticleRequest article, Long authorId, UserEntity author) {
        var user = usersRepository.findById(authorId);

        return articlesRepository.save(ArticleEntity.builder()
                .title(article.getTitle())
                        .body(article.getBody())
                        .author(author)
                        .slug(article.getTitle().toLowerCase())
                .build());
    }
public ArticleEntity updateArticle(Long articleId, UpdateArticleRequest ar) {
        var user = usersRepository.findById(articleId);

    return null;
}
    public static class ArticleNotFoundException extends IllegalAccessException {
        public ArticleNotFoundException(String slug) {
            super("Article with Slug " + slug + " not found");
        }
        public ArticleNotFoundException(Long id) {
            super("Article with id " + id + " not found");
        }
    }

}
