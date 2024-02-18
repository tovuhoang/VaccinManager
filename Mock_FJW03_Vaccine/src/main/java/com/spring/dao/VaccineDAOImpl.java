package com.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entities.Vaccine;

@Repository
public class VaccineDAOImpl implements VaccineDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Vaccine create(Vaccine vaccine) {
		try(Session session = sessionFactory.openSession()) {
			session.save(vaccine);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return vaccine;
	}

	@Override
	public Vaccine update(Vaccine vaccine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaccine delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public List<Vaccine> findAll() {
		try(Session session = sessionFactory.openSession()) {
			
			TypedQuery<Vaccine> query= session.createQuery("SELECT v FROM Vaccine v ", Vaccine.class);
			
			return query.getResultList();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
