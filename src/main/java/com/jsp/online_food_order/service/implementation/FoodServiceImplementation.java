package com.jsp.online_food_order.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.online_food_order.entity.Food;
import com.jsp.online_food_order.repository.FoodRepository;
import com.jsp.online_food_order.service.FoodService;

@Service
public class FoodServiceImplementation implements FoodService {
	
	@Autowired
	private FoodRepository foodRepository;

	@Override
	public Food createFood(Food food) {
		// TODO Auto-generated method stub
		return foodRepository.save(food);
	}
	
	
	
	
	

}
