package com.spring.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "VaccineType")
public class VaccineType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "VaccineTypeId")
    private Integer vaccineTypeId;
    
    @NotNull
    @Column(name = "Description")
    private String description;
    
    @NotNull
    @Column(name = "VaccineTypeName")
    private String vaccineTypeName;
    
    @ManyToOne
    @JoinColumn(name = "VaccineId")
    private Vaccine vaccine;

	public Integer getVaccineTypeId() {
		return vaccineTypeId;
	}

	public void setVaccineTypeId(Integer vaccineTypeId) {
		this.vaccineTypeId = vaccineTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVaccineTypeName() {
		return vaccineTypeName;
	}

	public void setVaccineTypeName(String vaccineTypeName) {
		this.vaccineTypeName = vaccineTypeName;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	protected VaccineType(Integer vaccineTypeId, @NotNull String description, @NotNull String vaccineTypeName,
			Vaccine vaccine) {
		super();
		this.vaccineTypeId = vaccineTypeId;
		this.description = description;
		this.vaccineTypeName = vaccineTypeName;
		this.vaccine = vaccine;
	}

	protected VaccineType() {
		super();
	}
    
    
}
