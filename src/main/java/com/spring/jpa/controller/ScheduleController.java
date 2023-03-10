package com.spring.jpa.controller;

import com.spring.jpa.dto.ScheduleRequest;
import com.spring.jpa.dto.ScheduleResponse;
import com.spring.jpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;
    @GetMapping("/schedules")
    public List<ScheduleResponse> scheduleLists(HttpSession session) {
        return scheduleService.scheduleLists(String.valueOf(session.getAttribute("email")));
    }

    @PostMapping("/schedules")
    public String insertSchedules(ScheduleRequest scheduleRequest, HttpSession session) {
        return scheduleService.insertSchedules(scheduleRequest, String.valueOf(session.getAttribute("email")));
    }

    @DeleteMapping("/schedules/{id}")
    public String deleteSchedules(@PathVariable("id") String id) {
        return scheduleService.deleteSchedules(id);
    }

}
