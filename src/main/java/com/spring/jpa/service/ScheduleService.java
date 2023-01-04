package com.spring.jpa.service;

import com.spring.jpa.dto.ScheduleRequest;
import com.spring.jpa.dto.ScheduleResponse;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ScheduleService {

    List<ScheduleResponse> scheduleLists(HttpSession session);
    String insertSchedules(ScheduleRequest scheduleRequest,HttpSession session);
    String deleteSchedules(String id);

}
