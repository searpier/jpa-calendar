package com.spring.jpa.controller;

import com.spring.jpa.dto.UserRequest;
import com.spring.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public String insertUsers(UserRequest userRequest) {
        return userService.insertUsers(userRequest);
    }

}
