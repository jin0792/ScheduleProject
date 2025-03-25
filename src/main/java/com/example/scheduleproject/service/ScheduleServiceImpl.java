package com.example.scheduleproject.service;

import com.example.scheduleproject.dto.ScheduleRequestDto;
import com.example.scheduleproject.dto.ScheduleResponseDto;
import com.example.scheduleproject.entity.Schedule;
import com.example.scheduleproject.repository.ScheduleRepository;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository memoRepository) {
        this.scheduleRepository = memoRepository;
    }


    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {

        // 요청받은 데이터로 Memo 객체 생성 ID 없음
        Schedule schedule = new Schedule(dto.getUserName(), dto.getPassword(), dto.getToDo());

        // Inmemory DB에 Memo 저장
        Schedule savedSchedule = scheduleRepository.saveSchedule(schedule);

        return new ScheduleResponseDto(savedSchedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {

        // 전체 조회
        return scheduleRepository.findAllSchedules();
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {

        Schedule schedule = scheduleRepository.findScheduleById(id);

        // NPE 방지
        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        return new ScheduleResponseDto(schedule);
    }

    @Override
    public ScheduleResponseDto update(Long id, String userName, String toDo) {

        Schedule schedule = scheduleRepository.findScheduleById(id);

        // NPE 방지
        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        // 필수값 검증
        if (userName == null || toDo == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title is a required value.");
        }

        schedule.update(userName, toDo);

        return new ScheduleResponseDto(schedule);
    }

    @Override
    public void deleteSchedule(Long id) {
        // schedule 조회
        Schedule schedule = scheduleRepository.findScheduleById(id);

        // NPE 방지
        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        scheduleRepository.deleteSchedule(id);
    }
}