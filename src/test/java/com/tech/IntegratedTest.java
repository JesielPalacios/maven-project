package com.tech;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tech.dao.CompanyDaoI;
import com.tech.dao.DBInit;
import com.tech.dao.OrderDaoI;
import com.tech.model.Company;
import com.tech.model.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class IntegratedTest {
	@Autowired DBInit dbInit;
	@Autowired CompanyDaoI companyDao;
	@Autowired OrderDaoI orderDao;

	Company company;
	
	@Before
	public void setUp() throws Exception {
		dbInit.setupDB(true);
		company = companyDao.find(1);
	}

	@Test
	public void testOrdersDao() { 
		List<Order> orders = orderDao.findAll(company);
		assertNotNull(orders);
		assertEquals(5, orders.size());
		Order order = null;
		for(Order orderIter : orders) {
			if(orderIter.getOrderNumber().equals("TESTORDER123")) {
				order = orderIter;
			}
		}
		assertNotNull(order);
		assertEquals(1, order.getOrderStatus());
		assertEquals("Cowboy Boots (Red)", order.getOrderItems().get(0).getListingName());
		assertEquals("CWBB-1", order.getOrderItems().get(0).getListingSku());
		assertEquals("Expected 3", 3, order.getOrderItems().get(0).getQuantityOrdered());
		assertEquals(100d, order.getOrderItems().get(0).getUnitPrice(), 0.001);
		assertEquals(.75d, order.getOrderItems().get(0).getTax(), 0.001);
		
		assertEquals("Test Company", order.getCompany().getCompanyName());
		assertEquals("Johnny Ceo", order.getCompany().getContactName());
		assertEquals("johnny@testcompany.com", order.getCompany().getContactEmail());
	}

}
