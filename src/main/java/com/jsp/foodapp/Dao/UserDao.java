package com.jsp.foodapp.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.dto.User;

@Repository
public class UserDao 
{
	@Autowired
	EntityManagerFactory emf;
	
	public void saveUserData(User user)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();
	}
	
	public User loginValidate(String email,String password)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select u from User u where u.email=?1 and u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		User user;
		try 
		{
			user = (User)query.getSingleResult();
		} 
		catch (NoResultException e)
		{
			return null;
		}
		return user;
	}
	
	public void updateUser(User user)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(user);
		et.commit();
	}
}
