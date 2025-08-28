package com.jsp.online_food_order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItemRequest {

	@NotNull
	private  Integer foodId;
	@Min(1) //this indicates that the the order minimum should be 1
	private int quality;
}
