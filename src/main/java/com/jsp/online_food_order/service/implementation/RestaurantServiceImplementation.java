package com.jsp.online_food_order.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jsp.online_food_order.entity.Food;
import com.jsp.online_food_order.entity.Restaurant;
import com.jsp.online_food_order.repository.FoodRepository;
import com.jsp.online_food_order.repository.RestaurantRepository;
import com.jsp.online_food_order.service.RestaurantService;

@Service
public class RestaurantServiceImplementation implements RestaurantService {

	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return restaurantRepository.save(restaurant);
	}
	
	public Restaurant getById(Integer id) {
		Optional<Restaurant> response = restaurantRepository.findById(id);
		
		
		if(response.isPresent()) {
			return response.get();
		}
		else {
			throw new NoSuchElementException("restaurant with id: "+id+"not found");
		}
		//return restaurantRepository.findById(id).orElseThrow()-> new NoSuchElementException("restaurant with id: "+id+"not found");
	}

//	@Override
//	public List<Restaurant> getAll() {
//		// TODO Auto-generated method stub
//		return restaurantRepository.findAll();
//	}

	@Override
	public Page<Restaurant> getAll(int pageNum, int pageSize, String sortBy) {
		Sort sort =Sort.by(sortBy).descending();
		Pageable pageable =PageRequest.of(pageNum, pageSize,sort);
		Page page =restaurantRepository.findAll(pageable);
		
		// TODO Auto-generated method stub
		return page;
	}

	@Override
	public Restaurant updateRestaurant(Integer id, Restaurant restaurant) {
		
		Restaurant existingRestaurant =restaurantRepository.findById(id)
				.orElseThrow(()-> new NoSuchElementException("restaurant with id "+id+" not found"));
		
		//update only the relevant fields
		existingRestaurant.setName(restaurant.getName());
		existingRestaurant.setLocation(restaurant.getLocation());
		existingRestaurant.setCity(restaurant.getCity());
		existingRestaurant.setState(restaurant.getState());
		existingRestaurant.setCountry(restaurant.getCountry());
		existingRestaurant.setPincode(restaurant.getPincode());
		existingRestaurant.setUpdateAt(java.time.LocalDateTime.now());
		
		return restaurantRepository.save(existingRestaurant);
	}

	@Override
	public void deleteRestaurant(Integer id) {
		Restaurant restaurant =getById(id);
		restaurantRepository.delete(restaurant);
		// TODO Auto-generated method stub
		
	}

	
	// the below code is to assign the food to the restaurant
	@Override
	public Restaurant assignFood(Integer restaurantId, Set<Integer> foodId) {
		Restaurant restaurant =getById(restaurantId);
		
		List<Food> foodItems=new ArrayList();
		
		
		for(Integer id:foodId) {
			Food food = foodRepository.findById(id).orElseThrow(()->new NoSuchElementException("food with id  "+ id+" not found"));
			foodItems.add(food);
		}
		
		restaurant.setFood(foodItems);
		
		return restaurantRepository.save(restaurant);
	}


}

