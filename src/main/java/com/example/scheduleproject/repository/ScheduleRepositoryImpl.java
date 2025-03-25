package com.example.scheduleproject.repository;

import com.example.scheduleproject.dto.ScheduleResponseDto;
import com.example.scheduleproject.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final Map<Long, Schedule> scheduleList = new HashMap<>(); // 해쉬맵 같은 경우 값을 참조 하는 시간이 O(1),  리스트 같은 경우 참조 시간이 O(n)

    @Override
    public Schedule saveSchedule(Schedule schedule) {

        // schedule 식별자 자동 생성
        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
        schedule.setId(scheduleId);

        scheduleList.put(scheduleId, schedule);

        return schedule;

    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {

        // inti List
        List<ScheduleResponseDto> allSchedules = new ArrayList<>();
        for (Schedule schedule : scheduleList.values()) {
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            allSchedules.add(responseDto);
        }
        return allSchedules;
    }

    @Override
    public Schedule findScheduleById(Long id) {
        return scheduleList.get(id);
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleList.remove(id);
    }
}