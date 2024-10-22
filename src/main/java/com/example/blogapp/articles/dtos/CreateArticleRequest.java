package com.example.blogapp.articles.dtos;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class CreateArticleRequest {
    private String title;
    private String body;
    private String author;

}
