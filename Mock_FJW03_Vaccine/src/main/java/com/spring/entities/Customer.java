package com.spring.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Customer")
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CustomerId")
    private Integer customerId;
    
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
    @Column(name = "FullName")
    private String fullName;
    
    @NotNull
    @Column(name = "Gender")
    private String gender;
    
    @NotNull
    @Column(name = "IdentityCard")
    private String identityCard;
    
    @NotNull
    @Column(name = "Password")
    private String password;
    
    @NotNull
    @Column(name = "Phone")
    private String phone;
    
    @NotNull
    @Column(name = "Username")
    private String username;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Result> results = new ArrayList<Result>();

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Customer() {
		super();
	}

	public Customer(Integer customerId, @NotNull String address, @NotNull Date dateOfBirth, @NotNull String email,
			@NotNull String fullName, @NotNull String gender, @NotNull String identityCard, @NotNull String password,
			@NotNull String phone, @NotNull String username, List<Result> results) {
		super();
		this.customerId = customerId;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.fullName = fullName;
		this.gender = gender;
		this.identityCard = identityCard;
		this.password = password;
		this.phone = phone;
		this.username = username;
		this.results = results;
	}
    
    
    
}
