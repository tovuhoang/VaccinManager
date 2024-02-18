package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dao.ScheduleDAO;
import com.spring.dao.VaccineDAO;
import com.spring.entities.Schedule;
import com.spring.entities.Vaccine;

@Controller
public class ScheduleController {
	
	@Autowired
	ScheduleDAO scheduleDAO;
	
	@Autowired
	VaccineDAO vaccineDAO;
	
	@GetMapping("/listschedule")
	public String ScheduleList(
			@RequestParam(name = "pageNum" , defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
			ModelMap map
	) {
		map.addAttribute("list", scheduleDAO.findAll(pageNum, pageSize) );
		return"scheduleListPage";
	}
	
	@GetMapping("/createschedule")
	public String createSchedule(ModelMap map) {
		map.addAttribute("listVaccine", vaccineDAO.findAll());
		map.addAttribute("schedule", new Schedule());
		return "createSchedulePage";
	}
	@PostMapping("/createschedule")
	public String saveSchedule(@ModelAttribute("schedule") @Validated Schedule s,BindingResult result, ModelMap map) {
	    // Lưu đối tượng Vaccine trước
	    Vaccine savedVaccine = vaccineDAO.create(s.getVaccine());
	    
	    // Gán đối tượng Vaccine đã lưu vào đối tượng Schedule
	    s.setVaccine(savedVaccine);

	    // Lưu đối tượng Schedule
		if(result.hasErrors()) {
				map.addAttribute("listVaccine", vaccineDAO.findAll());
				map.addAttribute("schedule", s);
				return "createSchedulePage";   
		}
	    scheduleDAO.create(s);

	    return "redirect:/listschedule";
	}
	@GetMapping("/selectedupdateschedule")
	public String redirectToUpdateSelectedSchedule(@RequestParam(name = "id", required = false) Integer injectionSchedule) {
		System.out.println(injectionSchedule);
	    if (injectionSchedule == null) {
	        // Nếu không có ID được chọn, chuyển hướng về trang danh sách lịch trình
	        return "redirect:/listschedule";
	    }

	    // Chuyển hướng với ID lịch trình đã chọn
	    return "redirect:/updateschedule?id=" + injectionSchedule;
	}
	@GetMapping("/updateschedule")
	public String displayUpdateForm(
			@RequestParam(name = "id", required = false) Integer injectionSchedule,
	        ModelMap map
	) {
		if (injectionSchedule == null) {
	        return "redirect:/listschedule";
	    }
		
		// Lấy lịch trình hiện tại dựa trên ID
		Schedule schedulenow = scheduleDAO.findById(injectionSchedule);

		// Kiểm tra xem lịch trình có tồn tại không
		if (schedulenow == null) {
			// Xử lý trường hợp không tìm thấy lịch trình, bạn có thể chuyển hướng hoặc hiển thị thông báo lỗi
			// Ở đây, tôi chuyển hướng về trang danh sách lịch trình
			return "redirect:/listschedule";
		}

		// Đổ dữ liệu lịch trình hiện tại và danh sách vaccine vào model
		map.addAttribute("listVaccine", vaccineDAO.findAll());
		map.addAttribute("schedule", schedulenow);

		// Trả về trang cập nhật lịch trình với dữ liệu của lịch trình hiện tại
		return "updateSchedulePage";
	}

	@PostMapping("/updateschedule")
	public String capNhatLichTrinh(
			@ModelAttribute("schedule") @Validated Schedule schedule,
			BindingResult result,
			ModelMap map
	) {
		if (result.hasErrors()) {
			// Nếu có lỗi hợp lệ, quay lại trang cập nhật lịch trình với thông báo lỗi
			map.addAttribute("listVaccine", vaccineDAO.findAll());
			return "updateSchedulePage";
		}
		
		System.out.println(schedule.toString());

		// Cập nhật lịch trình hiện tại với dữ liệu mới
		scheduleDAO.update(schedule);

		// Chuyển hướng về trang danh sách lịch trình sau khi cập nhật thành công
		return "redirect:/listschedule";
	}

	
}