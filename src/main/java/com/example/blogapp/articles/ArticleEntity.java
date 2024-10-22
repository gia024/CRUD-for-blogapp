package com.example.blogapp.articles;

import com.example.blogapp.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity(name="articles" )
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
@Setter
@ToString
@RequiredArgsConstructor
public class ArticleEntity {
    @Id
    @GeneratedValue
    @NonNull
    private Long id;
    @NonNull
    private String title;
    @NonNull
    @Column(unique = true)
    private String slug;
    @NonNull
    private String content;
    @NonNull
    private String body;
    @CreatedDate
    private Date CreatedAt;

    @ManyToOne
    @JoinColumn(name = "authorId" , nullable = false)
    private UserEntity author;

}
