package com.spring.jpa.controller;

import com.spring.jpa.dto.ScheduleResponse;
import com.spring.jpa.service.ScheduleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ScheduleControllerTest {

    private MockMvc mockMvc;
    protected MockHttpSession session;
    @Mock
    private ScheduleService scheduleService;
    @InjectMocks
    private ScheduleController scheduleController;

    @BeforeEach
    void setUp(@Autowired ScheduleController scheduleController) {
        // MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(scheduleController).build();
        session = new MockHttpSession();
        session.setAttribute("email","test03");

    }

    @Test
    @DisplayName("Schedule Controller Select Test")
    void scheduleSelectTest(){
        ScheduleResponse response=new ScheduleResponse("8","study JPA","2023-01-10");
        List<ScheduleResponse> result=new ArrayList<>();
        result.add(response);

        //조건 : 무엇을 호출 하면 무엇을 돌려준다.
        given(scheduleController.scheduleLists(session)).willReturn(result);
        List<ScheduleResponse> testResult=scheduleController.scheduleLists(session);
        Assertions.assertEquals("8",testResult.get(0).getId()); //
    }

    @Test
    @Transactional
    void scheduleDeleteTest() throws Exception {

        mockMvc.perform(delete("/schedules/38")) //호출 url
                .andExpect(status().isOk()) //결과 200(정상) 호출이 되어야함
                .andExpect(content().string("success")) //응답이 "success"로 나와야함
                .andDo(print()); //출력

    }

    @Test
    @Transactional
    void scheduleMockSelectTest() throws Exception {

        mockMvc.perform(get("/schedules")
                        .session(session)
                        .param("","")
                        .param("",""))
                .andExpect(status().isOk()) //200응답
                .andDo(print()); //출력

    }
}