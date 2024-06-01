package com.jsp.foodapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import antlr.collections.List;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name="email",unique=true)
	private String email;
	private String password;
	@OneToMany
	@Cascade(CascadeType.ALL)
	private java.util.List<FoodOrder> foodOrder;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public java.util.List<FoodOrder> getFoodOrder() {
		return foodOrder;
	}
	public void setFoodOrder(java.util.List<FoodOrder> foodOrder) {
		this.foodOrder = foodOrder;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", foodOrder="
				+ foodOrder + "]";
	}
	
	

}
