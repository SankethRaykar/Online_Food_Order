package com.jsp.online_food_order.controller;
import com.jsp.online_food_order.service.implementation.FoodServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.online_food_order.dto.ResponseStructure;
import com.jsp.online_food_order.entity.Food;
import com.jsp.online_food_order.service.FoodService;

@RestController
@RequestMapping("/food/api")
public class FoodController {

    private final FoodServiceImplementation foodServiceImplementation;

	
	@Autowired
	private FoodService foodService;

    FoodController(FoodServiceImplementation foodServiceImplementation) {
        this.foodServiceImplementation = foodServiceImplementation;
    }
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Food>> createFood(@RequestBody Food food){
		Food saved=foodService.createFood(food);
		ResponseStructure<Food> apiResponse=new ResponseStructure<>();
		apiResponse.setData(saved);
		apiResponse.setMessage("food added successfully");
		apiResponse.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getfood/{id}")
	public ResponseEntity<ResponseStructure<Food>> getfoodById(@PathVariable Integer id){
		Food response =foodService.getfoodById(id);
		ResponseStructure  apiResponse=new ResponseStructure<>();
		apiResponse.setData(response);
		apiResponse.setMessage("food object found");
		apiResponse.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
		
	}
	
	@GetMapping("/getallfood")
	public ResponseEntity<ResponseStructure<Page>> getAllFood(
			
			
		@RequestParam(defaultValue = "0",required = false)int pageNum,
		@RequestParam(defaultValue = "5",required = false)int pageSize,
		@RequestParam(defaultValue = "createdAt",required = false)String sortBy){
		
		Page response =foodService.getAll(pageNum,pageSize,sortBy);//service methos call
		ResponseStructure<Page> apiResponse =new ResponseStructure<>();
		apiResponse.setData(response);
		apiResponse.setMessage("api ran successfully");
		apiResponse.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.ok(apiResponse);
		
	}
	
	@PutMapping("/updatefood/{id}")
	public ResponseEntity<ResponseStructure<Food>> updateFood(@PathVariable Integer id,@RequestBody Food food){
		Food updatedFood =foodService.updateFood(id,food);
		ResponseStructure<Food> apiresponse =new ResponseStructure<>();
		apiresponse.setData(updatedFood);
		apiresponse.setMessage("food updated successfully");
		apiresponse.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(apiresponse,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity deleteFood(@PathVariable Integer id) {
		foodService.deleteFood(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	
}
