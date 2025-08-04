package com.jsp.online_food_order.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.jsp.online_food_order.entity.Restaurant;

public interface RestaurantService {
	
	Restaurant createRestaurant(Restaurant restaurant);

	Restaurant getById(Integer id);

	Page getAll(int pageNum,int pageSize,String sortBy);
	
	Restaurant updateRestaurant(Integer id,Restaurant restaurant);
	
	void deleteRestaurant(Integer id);

	Restaurant assignFood(Integer restaurantId, Set<Integer> foodId);

	
	
}
