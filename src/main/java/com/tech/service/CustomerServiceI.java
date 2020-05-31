package com.tech.service;

import java.util.List;
import java.util.Map;

import com.tech.model.Company;
import com.tech.model.Order;

public interface CustomerServiceI {
	
	/**
	 * Get all orders for a company's customers
	 * @param company
	 * @return a Map with each key representing the customer ID. The key references a 
	 * list of Orders for that particular customer. If a customer has no orders, they are not added
	 * to the return Map
	 */
	Map<Integer, List<Order>> getOrdersForCustomer(Company company);
}
