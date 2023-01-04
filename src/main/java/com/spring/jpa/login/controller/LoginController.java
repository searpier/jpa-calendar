package com.spring.jpa.login.controller;

import com.spring.jpa.dto.UserRequest;
import com.spring.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public String loginUser(UserRequest request, HttpSession session) {
        return userService.loginUsers(request, session);
    }

}
