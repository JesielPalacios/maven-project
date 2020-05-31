package com.tech.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dao.CustomerDaoI;
import com.tech.dao.OrderDaoI;
import com.tech.model.Company;
import com.tech.model.Order;
import com.tech.service.CustomerServiceI;

@Service
public class CustomerService implements CustomerServiceI {

	/*
	 * Use one or both DAO objects here to query for customer and order data,
	 * and to return the lists in the format specified by the method. You may
	 * only need one. Review the documentation and Model to decide
	 */
	@Autowired OrderDaoI orderDao;
	
	@Autowired CustomerDaoI customerDao;
	
	public CustomerService() {
	}

	@Override
	public Map<Integer, List<Order>> getOrdersForCustomer(Company company) {
		// TODO Auto-generated method stub
		/*return orderDao.findAll(company)
				.stream()
				.collect(groupingBy(Order::getCustomerId));*/

		Map<Integer, List<Order>> result = new HashMap<>();
		for (Order order: orderDao.findAll(company)){
			if (result.get(order.getCustomerId()) == null) {
				result.put(order.getCustomerId(), new ArrayList<>());
			}
			result.get(order.getCustomerId()).add(order);
		}
		return result;
	}

}
