package com.spring.jpa.repository;

import com.spring.jpa.entity.Schedule;
import com.spring.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    List<Schedule> findByUser(User user);
}
