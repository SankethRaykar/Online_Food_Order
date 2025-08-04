package com.jsp.online_food_order.entity;


import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
//this is present inside the lombok to get setters and getters
//it maps the class with fields to the db
@AllArgsConstructor
@NoArgsConstructor
@Entity  
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String location;
	private String city;
	private String state;
	private String country;
	private int pincode;
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updateAt;
	
	
	//after creating the food entity
	
	@ManyToMany
	//to have the ownership over the food
	@JoinTable(name="restaurant_food",joinColumns = @JoinColumn(name="id_restaurant"),inverseJoinColumns = @JoinColumn(name="id_food"))
	private List<Food> food;
	

}
