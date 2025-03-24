package com.example.scheduleproject.service;

import com.example.scheduleproject.dto.ScheduleRequestDto;
import com.example.scheduleproject.dto.ScheduleResponseDto;
import com.example.scheduleproject.entity.Schedule;

public interface ScheduleService {

    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);
}
