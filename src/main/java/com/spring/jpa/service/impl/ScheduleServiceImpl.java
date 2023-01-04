package com.spring.jpa.service.impl;

import com.spring.jpa.dto.ScheduleRequest;
import com.spring.jpa.dto.ScheduleResponse;
import com.spring.jpa.entity.Schedule;
import com.spring.jpa.entity.User;
import com.spring.jpa.repository.ScheduleRepository;
import com.spring.jpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleResponse> scheduleLists(HttpSession session) {

        return scheduleRepository.findByUser(
                User.builder()
                        .email(String.valueOf(session.getAttribute("email")))
                        .build()).stream()
                .map(schedule -> new ScheduleResponse(schedule))
                .collect(Collectors.toList());
    }

    @Override
    public String insertSchedules(ScheduleRequest scheduleRequest,HttpSession session) {
        try {
            scheduleRepository.save(
                    Schedule.builder()
                            .user(User.builder().email(String.valueOf(session.getAttribute("email"))).build())
                            .title(scheduleRequest.getTitle())
                            .date(scheduleRequest.getDate())
                            .build());
        }catch(Exception e){
            e.printStackTrace();
            return "failed";
        }

        return "success";
    }

    @Override
    public String deleteSchedules(String id) {
        try {
            scheduleRepository.deleteById(Long.valueOf(id));
        }catch(Exception e){
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }
}
