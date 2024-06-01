package com.jsp.foodapp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.foodapp.dto.Products;

@Repository
public class ProductDao 
{
	@Autowired
	EntityManagerFactory emf;
	public void saveProduct(Products product)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(product);
		et.commit();
		
	}
	
	public List<Products> getProduct()
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Products p");
		return query.getResultList();
	}
	
	public Products getById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Products p where id=?1");
		query.setParameter(1, id);
		return (Products)query.getSingleResult();
	}
	
	public void updateProduct(Products product)
	{
		EntityManager em = emf.createEntityManager();
//		Query query = em.createQuery("update Products p set p.name=?1, p.type=?2, p.cost=?3 where p.id=?4");
//		query.setParameter(4, product.getId());
//		query.setParameter(1, product.getName());
//		query.setParameter(2, product.getType());
//		query.setParameter(3, product.getCost());
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		Products prod = em.find(Products.class, product.getId()); 
		prod.setName(product.getName());
		prod.setType(product.getType());
		prod.setCost(product.getCost());
		et.commit();
	}
	
	public void deleteProduct(int id)
	{
		Products product = getById(id);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(product);
		et.commit();
	}
	
	public void deleteProductById(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Products product = em.find(Products.class, id) ;
		et.begin();
		em.remove(product);
		et.commit();
		
	}
}
