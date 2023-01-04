package com.spring.jpa.service.impl;

import com.spring.jpa.dto.UserRequest;
import com.spring.jpa.entity.User;
import com.spring.jpa.repository.UserRepository;
import com.spring.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String insertUsers(UserRequest userRequest) {
        try{
            userRepository.save(userRequest.toEntity());

        }catch(Exception e){
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public String loginUsers(UserRequest userRequest, HttpSession session) {
        User loginUser=userRepository.findByEmailAndPassword(userRequest.getEmail(),userRequest.getPassword()).orElse(null);
        session.setAttribute("email",loginUser.getEmail());

        if(loginUser==null){
            return "failed";
        }
        return "success";
    }
}
