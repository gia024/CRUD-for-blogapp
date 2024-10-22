package com.example.blogapp.user;

import com.example.blogapp.user.dtos.CreateUserRequest;
import com.example.blogapp.user.dtos.UserResponse;
import com.example.blogapp.user.dtos.LoginUserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class usersController {
    private final UsersService usersService;
    private final ModelMapper modelMapper;


    public usersController(UsersService usersService, ModelMapper modelMapper) {
        this.usersService = usersService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        UserEntity savedUser = usersService.createUser(createUserRequest);
        return ResponseEntity.created(URI.create("/users/" + savedUser.getId()))
                .body(modelMapper.map(savedUser, UserResponse.class));
    }

    @PostMapping("/login")
        ResponseEntity<UserResponse> loginUser (@RequestBody LoginUserRequest request) throws UsersService.UserNotFoundException {
        UserEntity savedUser = usersService.LoginUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(modelMapper.map(savedUser, UserResponse.class));
    }
}
