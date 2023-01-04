package com.spring.jpa.repository;

import com.spring.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByEmailAndPassword(String id, String password);

}
