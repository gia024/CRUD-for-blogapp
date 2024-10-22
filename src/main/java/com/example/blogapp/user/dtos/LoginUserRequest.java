package com.example.blogapp.user.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class LoginUserRequest {
    private String username;
    private String password;
}
