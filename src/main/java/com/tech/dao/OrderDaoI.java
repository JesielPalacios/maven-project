package com.tech.dao;

import java.util.List;

import com.tech.model.Company;
import com.tech.model.Order;

public interface OrderDaoI {
	
	public Order find(Company company, int orderId);
	
	public List<Order> findAll(Company company);
	
}
