package com.spring.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entities.Schedule;
import com.spring.entities.Vaccine;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public Schedule create(Schedule schedule) {
		try(Session session = sessionFactory.openSession()) {
			
			session.save(schedule);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return schedule;
	}
	@Transactional
	@Override
	public Schedule update(Schedule schedule) {
	    try (Session session = sessionFactory.openSession()) {
	    	
	        // Xác định lịch trình cần cập nhật dựa trên ID
	        Schedule existingSchedule = session.get(Schedule.class, schedule.getInjectionSchedule());
	        System.out.println(existingSchedule);

	        // Kiểm tra xem lịch trình có tồn tại không
	        if (existingSchedule != null) {
	            // Cập nhật thông tin lịch trình
	            existingSchedule.setDescription(schedule.getDescription());
	            existingSchedule.setEndDate(schedule.getEndDate());
	            existingSchedule.setPlace(schedule.getPlace());
	            existingSchedule.setStartDate(schedule.getStartDate());
	            
		        System.out.println(existingSchedule);

	            Vaccine existingVaccine = session.get(Vaccine.class, schedule.getVaccine().getVaccineId());

		        System.out.println(existingVaccine);
	            
	            if (existingVaccine == null) {
	                // Nếu vaccine chưa tồn tại, hãy cập nhật thông tin của nó từ đối tượng schedule
	                existingVaccine = schedule.getVaccine();
	            } else {
	                // Nếu vaccine đã tồn tại, hãy cập nhật thông tin từ đối tượng schedule
	                existingVaccine.setVaccineName(schedule.getVaccine().getVaccineName());
	                // Cập nhật các thuộc tính khác của Vaccine nếu có
	            }

	            // Cập nhật vaccine trong lịch trình
	            existingSchedule.setVaccine(existingVaccine);
	            
	            System.out.println(existingSchedule);

	            // Thực hiện cập nhật trong cơ sở dữ liệu
	            session.update(existingSchedule);
	        } else {
	            // Xử lý trường hợp lịch trình không tồn tại
	            throw new EntityNotFoundException("Lịch trình không tồn tại với ID: " + schedule.getInjectionSchedule());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return schedule;
	}
	@Override
	public Schedule delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public List<Schedule> findAll(Integer pageNum, Integer pageSize) {
		try(Session session = sessionFactory.openSession()) {
			
			TypedQuery<Schedule> query = session.createQuery("SELECT s FROM Schedule s", Schedule.class);
			query.setFirstResult((pageNum - 1)* pageSize);
			query.setMaxResults(pageSize);
			
			return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Transactional
	@Override
	public Schedule findById(Integer injectionSchedule) {
		try (Session session = sessionFactory.openSession()) {
            // Sử dụng phương thức get để lấy đối tượng Schedule dựa trên ID
            return session.get(Schedule.class, injectionSchedule);
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
        return null;
	}

}
