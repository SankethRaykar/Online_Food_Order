package com.jsp.online_food_order.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jsp.online_food_order.dto.BillResponse;
import com.jsp.online_food_order.dto.OrderItemRequest;
import com.jsp.online_food_order.dto.OrderRequest;
import com.jsp.online_food_order.dto.PaymentDto;
import com.jsp.online_food_order.entity.Food;
import com.jsp.online_food_order.entity.Order;
import com.jsp.online_food_order.entity.OrderItem;
import com.jsp.online_food_order.entity.OrderStatus;
import com.jsp.online_food_order.entity.Restaurant;
import com.jsp.online_food_order.exception.PaymentFailedException;
import com.jsp.online_food_order.repository.OrderRepository;
import com.jsp.online_food_order.service.FoodService;
import com.jsp.online_food_order.service.OrderService;
import com.jsp.online_food_order.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImplementation implements OrderService{

    private final OrderRepository orderRepository;
	private final RestaurantService restaurantService;
	private final FoodService foodService;


	
	@Override
	public BillResponse generateBill(OrderRequest orderRequest) {
		Restaurant restaurant = restaurantService.getById(orderRequest.getRestaurantId());
		StringBuilder summary =new StringBuilder();
		
		
		float totalPrice =0;
		
		for(OrderItemRequest orderItem : orderRequest.getOrderItems()) {
			Food food =foodService.getfoodById(orderItem.getFoodId());
			float price =food.getPrice() * orderItem.getQuality();
			totalPrice += price;
			summary.append(food.getName()).append(" X ").append(orderItem.getQuality())
				.append(" = ").append(price).append("\n");
			
			
		}
		
		return new BillResponse(restaurant.getName(),summary.toString(),totalPrice);
		//use of tostring because of string builder
	}
	
	
	@Override
	public String payAndPlaceOrder(PaymentDto payment) {
		//simulate payment
		
		if(payment.isPaymentSuccessful()) {
			Order order=new Order();
			order.setStatus(OrderStatus.PLACED);
			
			Restaurant restaurant = restaurantService.getById(payment.getRestaurantId());
			//set restaurant to order
			
			order.setRestaurant(restaurant);
			
			List<OrderItem> items=new ArrayList();
			double totalPrice=0;
			
			for(OrderItemRequest request:payment.getOrderItem()) {
				Food food=foodService.getfoodById(request.getFoodId());
				
				OrderItem orderItem = new OrderItem();
				orderItem.setFood(food);
				orderItem.setQuantity(request.getQuality());
				
				
				items.add(orderItem);
				
				double price = food.getPrice() * request.getQuality();
				totalPrice += price;
				
			}
			
			order.setTotalPrice(totalPrice);
			order.setOrderItem(items);
			orderRepository.save(order);
			return "order has been placed";
			
		}
		else {
			throw new PaymentFailedException("payment was not successful,hence order cannot be placed");
		}
		
	}
	
	
	@Override
	public void deleteOrder(Integer id) {
		Order order = getOrder(id);
		orderRepository.delete(order);
	}

	@Override
	public Order getOrder(Integer id) {
		Optional<Order> order = orderRepository.findById(id);
		if(order.isPresent()) {
			return order.get();
		}
		throw new NoSuchElementException("Order with ID: "+id+" does not exist");
	}

	@Override
	public Order updateStatusByAdmin(OrderStatus status, Integer id) {
		Order order = getOrder(id);
		order.setStatus(status);
		return orderRepository.save(order);
	}

	@Override
	public String cancelOrder(Integer id) {
		Order order = getOrder(id);
		order.setStatus(OrderStatus.CANCELLED);
		orderRepository.save(order);
		return "Order cancelled, your money will be refunded in 2 business hours";
	}
}
