package com.jsp.online_food_order.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;
	private Float price;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "food")
	//to eleminate the duplicate table and give the ownership to the restaurant
	
	List<Restaurant> restaurant;
	
	

}
