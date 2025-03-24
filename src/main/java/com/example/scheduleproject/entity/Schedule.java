package com.example.scheduleproject.entity;

import com.example.scheduleproject.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor // 모든 필드에 생성자를 자동생성
public class Schedule {

    @Setter
    private Long id;
    private String userName;
    private String password;
    private String toDo;
    private LocalDateTime createdAt;  // 날짜, 시간 같이 저장
    private LocalDateTime updatedAt;

    public Schedule(String userName, String password, String toDo, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userName = userName;
        this.password = password;
        this.toDo = toDo;
    }


    public void update(String userName, String password, String toDo) {
        this.userName = userName;
        this.password = password;
        this.toDo = toDo;
    }

}
