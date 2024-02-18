package com.spring.dao;

import java.util.List;

import com.spring.entities.Vaccine;

public interface VaccineDAO {
	Vaccine create(Vaccine vaccine);
	Vaccine update(Vaccine vaccine);
	Vaccine delete(Integer id);
	List<Vaccine> findAll();

}
