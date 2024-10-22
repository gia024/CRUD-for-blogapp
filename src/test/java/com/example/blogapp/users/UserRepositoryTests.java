package com.example.blogapp.users;

import com.example.blogapp.user.UserEntity;
import com.example.blogapp.user.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTests {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    @Order(1)
    void can_create_user() {
        UserEntity user = UserEntity.builder()
                .username("garimaharjan")
                .email("garima@gmail.com")
                .bio("hi")
                .image("garima.jpg")
                .build();

        usersRepository.save(user);
    }

    @Test
    @Order(2)
    void can_find_users(){
        UserEntity user = UserEntity.builder()
                .username("garimaharjan")
                .email("garima@gmail.com")
                .bio("hi")
                .image("garima.jpg")
                .build();

        usersRepository.save(user);
        List<UserEntity> users = usersRepository.findAll();
        Assertions.assertEquals(1, users.size());
    }
}

