package com.tech.dao;

import java.util.List;

import com.tech.model.Order;
import com.tech.model.OrderItem;

public interface OrderItemDaoI {
	/**
	 * Find all Order Items for the input Order
	 * @param order
	 * @return
	 */
	public List<OrderItem> findAll(Order order);
}
