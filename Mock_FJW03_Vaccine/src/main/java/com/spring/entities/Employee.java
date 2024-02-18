package com.spring.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Employee")
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EmployeeId")
    private Integer employeeId; 
    
    @NotNull
    @Column(name = "Address")
    private String address;
    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DateOfBirth")
    private Date dateOfBirth;
    
    @NotNull
    @Column(name = "Email")
    private String email;
    
    @NotNull
    @Column(name = "EmployeeName")
    private String employeeName;
    
    @NotNull
    @Column(name = "Gender")
    private int gender;
    
    @NotNull
    @Column(name = "Image")
    private String image;
    
    @NotNull
    @Column(name = "Password")
    private String password;
    
    @NotNull
    @Column(name = "Phone")
    private String phone;
    
    @NotNull
    @Column(name = "Position")
    private String position;
    
    @NotNull
    @Column(name = "Username")
    private String username;
    
    @NotNull
    @Column(name = "WorkingPlace")
    private String workingPlace;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getWorkingPlace() {
		return workingPlace;
	}
	public void setWorkingPlace(String workingPlace) {
		this.workingPlace = workingPlace;
	}
	protected Employee(Integer employeeId, @NotNull String address, @NotNull Date dateOfBirth, @NotNull String email,
			@NotNull String employeeName, @NotNull int gender, @NotNull String image, @NotNull String password,
			@NotNull String phone, @NotNull String position, @NotNull String username, @NotNull String workingPlace) {
		super();
		this.employeeId = employeeId;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.employeeName = employeeName;
		this.gender = gender;
		this.image = image;
		this.password = password;
		this.phone = phone;
		this.position = position;
		this.username = username;
		this.workingPlace = workingPlace;
	}
	protected Employee() {
		super();
	}
    
    
}
