package com.example.blogapp.user.dtos;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class CreateUserRequest {
    private String username;
    private String password;
    private String email;
    private String bio;

}
