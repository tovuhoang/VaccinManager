package com.spring.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "Result")
public class Result {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "InjectionResultId")
    private Integer injectionResultId;
    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "InjectionDate")
    private Date injectionDate;
    
    @NotNull
    @Column(name = "InjectionPlace")
    private String injectionPlace;
    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "NextInjectionDate")
    private Date nextInjectionDate;
    
    @NotNull
    @Column(name = "NumberOfInjection")
    private String numberOfInjection;
    
    @NotNull
    @Column(name = "Prevention")
    private String prevention;
    
    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "VaccineId")
    private Vaccine vaccine;

	public Integer getInjectionResultId() {
		return injectionResultId;
	}

	public void setInjectionResultId(Integer injectionResultId) {
		this.injectionResultId = injectionResultId;
	}

	public Date getInjectionDate() {
		return injectionDate;
	}

	public void setInjectionDate(Date injectionDate) {
		this.injectionDate = injectionDate;
	}

	public String getInjectionPlace() {
		return injectionPlace;
	}

	public void setInjectionPlace(String injectionPlace) {
		this.injectionPlace = injectionPlace;
	}

	public Date getNextInjectionDate() {
		return nextInjectionDate;
	}

	public void setNextInjectionDate(Date nextInjectionDate) {
		this.nextInjectionDate = nextInjectionDate;
	}

	public String getNumberOfInjection() {
		return numberOfInjection;
	}

	public void setNumberOfInjection(String numberOfInjection) {
		this.numberOfInjection = numberOfInjection;
	}

	public String getPrevention() {
		return prevention;
	}

	public void setPrevention(String prevention) {
		this.prevention = prevention;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	protected Result(Integer injectionResultId, @NotNull Date injectionDate, @NotNull String injectionPlace,
			@NotNull Date nextInjectionDate, @NotNull String numberOfInjection, @NotNull String prevention,
			Customer customer, Vaccine vaccine) {
		super();
		this.injectionResultId = injectionResultId;
		this.injectionDate = injectionDate;
		this.injectionPlace = injectionPlace;
		this.nextInjectionDate = nextInjectionDate;
		this.numberOfInjection = numberOfInjection;
		this.prevention = prevention;
		this.customer = customer;
		this.vaccine = vaccine;
	}

	protected Result() {
		super();
	}
    
    

}
