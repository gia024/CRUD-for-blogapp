package com.example.blogapp.user;

import com.example.blogapp.user.dtos.CreateUserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    public UserEntity createUser(CreateUserRequest u) {
        UserEntity userEntity = modelMapper.map(u, UserEntity.class);
        UserEntity newUser = UserEntity.builder()
                .username(u.getUsername())
                .email(u.getEmail())
                .build();

        return usersRepository.save(newUser);
    }

    public UserEntity getUser(String username) {
        return usersRepository.findByUsername(username);
    }
    public UserEntity getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public UserEntity LoginUser(String username, String password) throws UserNotFoundException {
    var userEntity = usersRepository.findByUsername(username);
    if (userEntity == null) {
        throw new UserNotFoundException(username);
    }
    return userEntity;
    }
    public static class UserNotFoundException extends IllegalAccessException{
        public UserNotFoundException(String username) {
            super("User with name "+username+" not found");
        }

    public UserNotFoundException(Long userID){
        super("user with id"+userID+"not found");
    }
    }
}
