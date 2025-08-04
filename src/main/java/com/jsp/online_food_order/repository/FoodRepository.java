package com.jsp.online_food_order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.online_food_order.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{

}
