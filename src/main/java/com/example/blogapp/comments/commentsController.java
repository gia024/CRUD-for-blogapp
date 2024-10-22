package com.example.blogapp.comments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles/{article-slug}/comments")
public class commentsController {
    @GetMapping("")
    String getComments() {
        return "comments";
    }
}
