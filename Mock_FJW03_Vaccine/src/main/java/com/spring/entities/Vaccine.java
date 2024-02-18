package com.spring.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vaccine")
public class Vaccine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "VaccineId")
    private Integer vaccineId;
    
    @NotNull
    @Column(name = "Contraindication")
    private String contraindication;
    
    @NotNull
    @Column(name = "Indication")
    private String indication;
    
    @NotNull
    @Column(name = "NumberOfInjection")
    private Integer numberOfInjection;
    
    @NotNull
    @Column(name = "Origin")
    private String origin;
    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "TimeBeginNextInjection")
    private Date timeBeginNextInjection;
    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "TimeEndNextInjection")
    private Date timeEndNextInjection;
    
    @NotNull
    @Column(name = "Usage")
    private String usage;
    
    @NotBlank(message = "VaccineName can not empty")
    @Column(name = "VaccineName")
    private String vaccineName;
    
    @OneToMany(mappedBy = "vaccine", cascade = CascadeType.ALL)
    private List<Result> results = new ArrayList<Result>();
    
    @OneToMany(mappedBy = "vaccine", cascade = CascadeType.ALL )
    private List<Schedule> schedules = new ArrayList<Schedule>();
    
    @OneToMany(mappedBy = "vaccine" , cascade = CascadeType.ALL)
    private List<VaccineType> vaccineTypes = new ArrayList<VaccineType>();

	public Integer getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Integer vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getContraindication() {
		return contraindication;
	}

	public void setContraindication(String contraindication) {
		this.contraindication = contraindication;
	}

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public Integer getNumberOfInjection() {
		return numberOfInjection;
	}

	public void setNumberOfInjection(Integer numberOfInjection) {
		this.numberOfInjection = numberOfInjection;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Date getTimeBeginNextInjection() {
		return timeBeginNextInjection;
	}

	public void setTimeBeginNextInjection(Date timeBeginNextInjection) {
		this.timeBeginNextInjection = timeBeginNextInjection;
	}

	public Date getTimeEndNextInjection() {
		return timeEndNextInjection;
	}

	public void setTimeEndNextInjection(Date timeEndNextInjection) {
		this.timeEndNextInjection = timeEndNextInjection;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public List<VaccineType> getVaccineTypes() {
		return vaccineTypes;
	}

	public void setVaccineTypes(List<VaccineType> vaccineTypes) {
		this.vaccineTypes = vaccineTypes;
	}

	public Vaccine(Integer vaccineId, @NotNull String contraindication, @NotNull String indication,
			@NotNull Integer numberOfInjection, @NotNull String origin, @NotNull Date timeBeginNextInjection,
			@NotNull Date timeEndNextInjection, @NotNull String usage, @NotBlank String vaccineName,
			List<Schedule> schedules, List<VaccineType> vaccineTypes) {
		super();
		this.vaccineId = vaccineId;
		this.contraindication = contraindication;
		this.indication = indication;
		this.numberOfInjection = numberOfInjection;
		this.origin = origin;
		this.timeBeginNextInjection = timeBeginNextInjection;
		this.timeEndNextInjection = timeEndNextInjection;
		this.usage = usage;
		this.vaccineName = vaccineName;
		this.schedules = schedules;
		this.vaccineTypes = vaccineTypes;
	}

	public Vaccine() {
		super();
	}

	@Override
	public String toString() {
		return "Vaccine [vaccineId=" + vaccineId + ", contraindication=" + contraindication + ", indication="
				+ indication + ", numberOfInjection=" + numberOfInjection + ", origin=" + origin
				+ ", timeBeginNextInjection=" + timeBeginNextInjection + ", timeEndNextInjection="
				+ timeEndNextInjection + ", usage=" + usage + ", vaccineName=" + vaccineName + ", results=" + results
				+ ", schedules=" +  ", vaccineTypes=" + vaccineTypes + "]";
	}
    
    
}