package com.example.scheduleproject.repository;

import com.example.scheduleproject.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

}
