package com.jsp.online_food_order.controller;

import java.util.List;
import java.util.Set;

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
import com.jsp.online_food_order.entity.Order;
import com.jsp.online_food_order.entity.Restaurant;
import com.jsp.online_food_order.service.RestaurantService;

@RestController
@RequestMapping("/restaurant/api")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Restaurant>> createRestaurant(@RequestBody Restaurant restaurant){
		Restaurant savedRestaurant = restaurantService.createRestaurant(restaurant);
		ResponseStructure apiResponse =new ResponseStructure();
		apiResponse.setStatusCode(201);
		apiResponse.setMessage("restaurant created successfully");
		apiResponse.setData(savedRestaurant);
		return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseStructure<Restaurant>> getById(@PathVariable Integer id){
		Restaurant response = restaurantService.getById(id);
		ResponseStructure apiResponse =new ResponseStructure();
		apiResponse.setData(response);
		apiResponse.setMessage("restaurant object found");
		apiResponse.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
		
	}
	
//	@GetMapping("/getall")
//	public ResponseEntity<ResponseStructure<List<Restaurant>>> getAllRestaurant() {
//		List<Restaurant> restaurant =restaurantService.getAll();//service method
//		ResponseStructure<List<Restaurant>> response = new ResponseStructure<>();
//	    response.setData(restaurant);
//	    response.setMessage("All restaurants retrieved successfully");
//	    response.setStatusCode(HttpStatus.OK.value());
//	    return new ResponseEntity<>(response, HttpStatus.OK);
//		
//	}
	
	@GetMapping("/getall")
	public ResponseEntity<ResponseStructure<Page>> getAllRestaurant(
		
		@RequestParam(defaultValue = "0",required = false)int pageNum,
		@RequestParam(defaultValue = "5",required = false)int pageSize,
		@RequestParam(defaultValue = "createdAt",required = false)String sortBy){
		
		
		Page response =restaurantService.getAll(pageNum,pageSize,sortBy);//service metho+d
		ResponseStructure<Page> apiresponse = new ResponseStructure();
	    apiresponse.setData(response);
	    apiresponse.setMessage("Api ran successfully");
	    apiresponse.setStatusCode(HttpStatus.OK.value());
	    return ResponseEntity.ok(apiresponse);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<Restaurant>> updateRestaurant(@PathVariable Integer id,
															@RequestBody Restaurant restaurant ){
		
		Restaurant updatedRestaurant =restaurantService.updateRestaurant(id, restaurant);
		ResponseStructure<Restaurant> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("restaurant updated successfully");
		response.setData(updatedRestaurant);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}/delete")
	public ResponseEntity deleteRestaurant(@PathVariable Integer id){
		restaurantService.deleteRestaurant(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	//used to assign the food to the particular restaurant
	
	@PostMapping("/{restaurantId}/assignFood")
	public ResponseEntity<ResponseStructure<Restaurant>> assignFood(@PathVariable Integer restaurantId,@RequestBody Set<Integer> food){
		Restaurant restaurant =restaurantService.assignFood(restaurantId, food);
		ResponseStructure<Restaurant> apiResponse=new ResponseStructure<>();
		apiResponse.setData(restaurant);
		apiResponse.setMessage("assigned");
		apiResponse.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.ok(apiResponse);
		
	}
	
	@GetMapping("/{id}/getAll")
	public ResponseEntity<ResponseStructure<List<Food>>> getFoodByRestaurantId(@PathVariable Integer id) {
	    ResponseStructure<List<Food>> apiResponse = new ResponseStructure<>();
	    apiResponse.setData(restaurantService.findFoodByRestaurantId(id));
	    apiResponse.setMessage("food item found");
	    apiResponse.setStatusCode(HttpStatus.OK.value());
	    return ResponseEntity.ok(apiResponse);
	}

	@GetMapping("/{id}/getAllOrders")
	public ResponseEntity<ResponseStructure<List<Order>>> getOrdersByRestaurant(@PathVariable Integer id){
		ResponseStructure<List<Order>> apiResponse = new ResponseStructure();
		apiResponse.setData(restaurantService.findOrdersByRestaurantId(id));
		apiResponse.setMessage("Orders found");
		apiResponse.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.ok(apiResponse);
	}

}
