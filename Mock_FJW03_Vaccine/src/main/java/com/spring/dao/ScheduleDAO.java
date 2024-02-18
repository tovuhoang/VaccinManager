package com.spring.dao;

import java.util.List;

import com.spring.entities.Schedule;

public interface ScheduleDAO {
	Schedule create(Schedule schedule);
	Schedule update(Schedule schedule);
	Schedule delete(Integer id);
	List<Schedule> findAll(Integer pageNum, Integer pageSize);
	Schedule findById(Integer injectionSchedule);
}
