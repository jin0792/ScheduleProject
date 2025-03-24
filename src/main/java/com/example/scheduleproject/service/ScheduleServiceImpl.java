package com.example.scheduleproject.service;

import com.example.scheduleproject.dto.ScheduleRequestDto;
import com.example.scheduleproject.dto.ScheduleResponseDto;
import com.example.scheduleproject.entity.Schedule;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {


    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {

        // 요청받은 데이터로 Memo 객체 생성 ID 없음
        Schedule schedule = new Schedule(dto.getUserName(),dto.getPassword(), dto.getToDo(), dto.getCreatedAt(), dto.getUpdatedAt());

        // Inmemory DB에 Memo 저장
        Schedule savedMemo = scheduleRepository.saveMemo(schedule);

        return new ScheduleResponseDto(SavedSchedule);
    }
}
