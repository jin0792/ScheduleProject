package com.example.scheduleproject.service;

import com.example.scheduleproject.dto.ScheduleRequestDto;
import com.example.scheduleproject.dto.ScheduleResponseDto;
import com.example.scheduleproject.entity.Schedule;
import com.example.scheduleproject.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public abstract class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {

        // 요청받은 데이터로 Schedule 객체 생성 ID 없음
        Schedule schedule = new Schedule(dto.getUserName(), dto.getPassword(), dto.getToDo());

        // Inmemory DB에 Schedule 저장
        return scheduleRepository.saveSchedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {

        // 전체 조회
        return scheduleRepository.findAllSchedules();
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {

        Schedule schedule = scheduleRepository.findScheduleById(id);

        return new ScheduleResponseDto(schedule);
    }


    @Override
    public ScheduleResponseDto update(Long id, String userName, String password, String toDo) {
        // 필수값 검증
        if (userName == null || toDo == null || password == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The userName, toDo, password are a required value.");
        }

        int updatedRow = scheduleRepository.update(id, userName, toDo, password);

        if (updatedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        Schedule schedule = scheduleRepository.findScheduleById(id);

        // 수정된 이름, 일정, 비밀번호 조회
        return new ScheduleResponseDto(schedule);
    }

    @Override
    public void deleteSchedule(Long id, String password) {

        int deletedRow = scheduleRepository.deleteSchedule(id ,password);

        if (deletedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
    }
}