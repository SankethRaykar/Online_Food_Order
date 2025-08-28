package com.jsp.online_food_order.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentDto {
	
	@NotNull
	private List<OrderItemRequest> orderItem;
	@NotNull
	private boolean isPaymentSuccessful;
	@NotNull
	public Integer restaurantId;
}
