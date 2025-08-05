package com.jsp.online_food_order.service.implementation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jsp.online_food_order.entity.Food;
import com.jsp.online_food_order.entity.Restaurant;
import com.jsp.online_food_order.repository.FoodRepository;
import com.jsp.online_food_order.repository.RestaurantRepository;
import com.jsp.online_food_order.service.FoodService;

@Service
public class FoodServiceImplementation implements FoodService {

    private final RestaurantRepository restaurantRepository;
	
	@Autowired
	private FoodRepository foodRepository;

    FoodServiceImplementation(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

	@Override
	public Food createFood(Food food) {
		// TODO Auto-generated method stub
		return foodRepository.save(food);
	}

	@Override
	public Food getfoodById(Integer id) {
		Optional<Food> response =foodRepository.findById(id);
		
		if(response.isPresent()) {
		return response.get();
		}
		else
		{
			throw new NoSuchElementException("Food with id: "+id+"not found");
		}
		
	}

	@Override
	public Page<Food> getAll(int pageNum, int pageSize, String sortBy) {
		Sort sort = Sort.by(sortBy).descending();
		Pageable pageable =PageRequest.of(pageNum, pageSize,sort);
		Page page=foodRepository.findAll(pageable);
		return page;//make sure that in the food entity u have created a localtimestamp same as in the restaurant
	}

	@Override
	public Food updateFood(Integer id, Food food) {
		Food existingFood =foodRepository.findById(id)
				.orElseThrow(()-> new NoSuchElementException("food with id "+id +" not found"));
		//update inly the relevant fields
		
		existingFood.setName(food.getName());
		existingFood.setDescription(food.getDescription());
		existingFood.setPrice(food.getPrice());
		existingFood.setUpdateAt(java.time.LocalDateTime.now());
		return foodRepository.save(existingFood);
	}

	@Override
	public void deleteFood(Integer id) {

		Food food =getfoodById(id);
		List<Restaurant> restaurants =food.getRestaurant();
		if(restaurants.size()==0) {
			foodRepository.delete(food);
			return;
			
		}
		for(Restaurant restaurant:restaurants ) {
			restaurant.getFood().remove(food);
		}
		restaurantRepository.saveAll(restaurants);
		foodRepository.delete(food);
		
		
		
	}
	
	
	
	
	
	

}
