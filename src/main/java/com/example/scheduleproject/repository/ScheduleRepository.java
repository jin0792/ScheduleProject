package com.example.scheduleproject.repository;

import com.example.scheduleproject.dto.ScheduleResponseDto;
import com.example.scheduleproject.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {

    Schedule saveSchedule(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedules();

    Schedule findScheduleById(Long id);

    void deleteSchedule(Long id);

}
