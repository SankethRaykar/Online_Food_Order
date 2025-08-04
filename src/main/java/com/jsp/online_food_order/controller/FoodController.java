package com.jsp.online_food_order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.online_food_order.dto.ResponseStructure;
import com.jsp.online_food_order.entity.Food;
import com.jsp.online_food_order.service.FoodService;

@RestController
@RequestMapping("/food/api")
public class FoodController {

	
	@Autowired
	private FoodService foodService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Food>> createFood(@RequestBody Food food){
		Food saved=foodService.createFood(food);
		ResponseStructure<Food> apiResponse=new ResponseStructure<>();
		apiResponse.setData(saved);
		apiResponse.setMessage("food added successfully");
		apiResponse.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
		
	}
}
