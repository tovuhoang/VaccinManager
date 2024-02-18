package com.spring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Schedule")
public class Schedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "InjectionSchedule")
    private Integer injectionSchedule;
    
	@NotNull
    @Column(name = "Description")
    private String description;
    
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "EndDate")
    private Date  endDate;
    
    @NotBlank(message = "can not be empty")
    @Column(name = "Place")
    private String place;
    
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "StartDate")
    private Date  startDate;
    
    @ManyToOne
    @JoinColumn(name = "VaccineId")
    private Vaccine vaccine;
    
	public Integer getInjectionSchedule() {
		return injectionSchedule;
	}
	public void setInjectionSchedule(Integer injectionSchedule) {
		this.injectionSchedule = injectionSchedule;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	public Schedule(Integer injectionSchedule, @NotNull String description, @NotNull Date endDate,
			@NotBlank String place, @NotNull Date startDate, Vaccine vaccine) {
		super();
		this.injectionSchedule = injectionSchedule;
		this.description = description;
		this.endDate = endDate;
		this.place = place;
		this.startDate = startDate;
		this.vaccine = vaccine;
	}
	public Schedule() {
		super();
	}
    @Override
	public String toString() {
		return "Schedule [injectionSchedule=" + injectionSchedule + ", description=" + description + ", endDate="
				+ endDate + ", place=" + place + ", startDate=" + startDate + ", vaccine=" + vaccine + "]";
	}

}