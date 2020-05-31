package com.tech.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.tech.model.Company;
import com.tech.model.Order;

@Repository
public class OrderDao extends GenericDao implements OrderDaoI {
	@Autowired OrderItemDaoI orderItemDao;
	@Autowired CustomerDaoI customerDao;
	
	public OrderDao() {
	}

	@Autowired
	public OrderDao(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public Order find(Company company, int orderId) {
		String sql = "SELECT * FROM orders where company_id = ? and order_id = ? ";
		Order order = jdbcTemplateObject.queryForObject(sql, new Object[] {company.getCompanyId(), orderId}, 
				new BeanPropertyRowMapper<Order>(Order.class));
		order.setOrderItems(orderItemDao.findAll(order));
		order.setCompany(company);
		order.setCustomer(customerDao.find(company, order.getCustomerId()));
		return order;
	}

	@Override
	public List<Order> findAll(Company company) {
		String sql = "SELECT * FROM orders where company_id = ? ";
		List<Order> orders = jdbcTemplateObject.query(sql, new Object[] {company.getCompanyId()}, 
				new BeanPropertyRowMapper<Order>(Order.class));
		for(Order order : orders) {
			order.setCompany(company);
			order.setCustomer(customerDao.find(company, order.getCustomerId()));
			order.setOrderItems(orderItemDao.findAll(order));			
		}
		return orders;
	}

}
