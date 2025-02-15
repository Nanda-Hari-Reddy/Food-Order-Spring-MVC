package com.jsp.foodapp.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.dto.Admin;


@Repository
public class AdminDao
{
	@Autowired
	EntityManagerFactory emf;
	public void saveAdmin(Admin admin)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(admin);
		et.commit();
	}
	public Admin validate(String email,String password)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select a from Admin a where a.email=?1 and a.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		Admin admin;
		try 
		{
			admin = (Admin)query.getSingleResult();
		} catch (Exception e)
		{
			return null;
		}
		return admin;
	}
}
