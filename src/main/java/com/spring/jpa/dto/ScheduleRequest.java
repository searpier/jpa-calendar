package com.spring.jpa.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ScheduleRequest {

    private String email;
    private String title;
    private String date;

}
