package com.jsp.online_food_order.service;

import org.springframework.data.domain.Page;

import com.jsp.online_food_order.entity.Food;

public interface FoodService {



	Food createFood(Food food);

	Food getfoodById(Integer id);

	Page getAll(int pageNum, int pageSize, String sortBy);

	Food updateFood(Integer id, Food food);

	void deleteFood(Integer id);
	
	
}
