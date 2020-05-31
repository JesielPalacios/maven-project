package com.tech.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import com.tech.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dao.OrderDaoI;
import com.tech.model.Company;
import com.tech.model.Order;
import com.tech.service.OrderServiceI;

@Service
public class OrderService implements OrderServiceI {
	/*
	 * Use the orderDao to query for orders in the system. You can then filter
	 * the results here to return the proper value according to the method 
	 */
	@Autowired OrderDaoI orderDao;
	
	public OrderService() {}

	@Override
	/*public List<Order> getOrdersByStatus(Company company, int status) {
		// TODO Auto-generated method stub
		List<Order> orders = orderDao.findAll(company);
		List<Order> ordersToReturn = new ArrayList<>();
		for (Order order: orders) {
			if (order.getOrderStatus() == status) {
				ordersToReturn.add(order);
			}
		}
		return ordersToReturn;
	}*/
	public List<Order> getOrdersByStatus(Company company, int status) {
		// TODO Auto-generated method stub
		return orderDao.findAll(company)
				.stream()
				.filter((order) -> order.getOrderStatus() == status)
				.collect(Collectors.toList());
	}

	@Override
	public double getTotalCostOfOrder(Order order) {
		// TODO Auto-generated method stub
		//ToDoubleFunction<OrderItem> totalCostMapper = (OrderItem) -> (OrderItem.getOrderItemId())
		double total = 0;
		for(OrderItem orderItem: order.getOrderItems()) {
			total += (orderItem.getQuantityOrdered() * orderItem.getUnitPrice()) + orderItem.getTax();
		}
		return total;
		/*
	return order.getOrderItems()
		  .stream()
 		 .mapToDouble((orderItem) -> (orderItem.getQuantityOrdered() * orderItem.getUnitPrice()) + orderItem.getTax())
 		 .sum();
    */

	}

}
