package com.example.blogapp.comments;

import com.example.blogapp.articles.ArticleEntity;
import com.example.blogapp.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity(name="comments")
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
@Setter
@ToString
@RequiredArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue

    @NonNull
    private String title;

    @NonNull
        private String body;
    @CreatedDate
    private Date CreatedAt;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private ArticleEntity article;

    @ManyToOne
    @JoinColumn(name = "authorId" , nullable = false)
    private UserEntity author;

}
