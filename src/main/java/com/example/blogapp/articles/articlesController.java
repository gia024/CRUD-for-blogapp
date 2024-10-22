package com.example.blogapp.articles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class articlesController {
    @GetMapping("")
    String getArticles(){
        return "Articles";
    }
}
