package com.spring.jpa.service;

import com.spring.jpa.dto.UserRequest;

import javax.servlet.http.HttpSession;

public interface UserService {

    String insertUsers(UserRequest userRequest);
    String loginUsers(UserRequest userRequest, HttpSession session);

}
