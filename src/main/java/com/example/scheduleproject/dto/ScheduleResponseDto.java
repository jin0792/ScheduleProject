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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ScheduleResponseDto(Schedule schedule, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = schedule.getId();
        this.userName = schedule.getUserName();
        this.toDo = schedule.getToDo();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
