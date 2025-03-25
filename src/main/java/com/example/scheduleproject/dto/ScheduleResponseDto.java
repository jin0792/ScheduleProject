package com.example.scheduleproject.dto;

import com.example.scheduleproject.entity.Schedule;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private Long id;
    private String userName;
    private String toDo;


    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.userName = schedule.getUserName();
        this.toDo = schedule.getToDo();
    }

}
