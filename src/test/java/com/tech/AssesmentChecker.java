package com.tech;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tech.dao.CompanyDaoI;
import com.tech.dao.DBInit;
import com.tech.dao.PerformanceDataDaoI;
import com.tech.model.Company;
import com.tech.model.Order;
import com.tech.service.CustomerServiceI;
import com.tech.service.OrderServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class AssesmentChecker {
	@Autowired DBInit dbInit;
	@Autowired CustomerServiceI customerService;
	@Autowired OrderServiceI orderService;
	@Autowired PerformanceDataDaoI performanceDao;

	@Autowired CompanyDaoI companyDao;
	Company company;

	@Before
	public void setUp() throws IOException {
		dbInit.setupDB(true);
		company = companyDao.find(1);
	}

	@Test
	public void performanceDaoTotalItemsTest() {
		int count = performanceDao.getTotalItemsOrderedForCompany(company);
		assertEquals(8, count);
	}

	@Test
	public void performanceDaoSalesTest() {
		assertEquals("Incorrect total", 473.37,
				performanceDao.getTotalSalesAmountForCompany(company), 0.001);
	}

	@Test
	public void orderServiceByStatusTest() {
		List<Order> orders = orderService.getOrdersByStatus(company, 1);
		assertNotNull("Data should be returned.", orders);
		assertEquals("There are three orders with status 1", 3, orders.size());

		orders = orderService.getOrdersByStatus(company, 2);
		assertEquals("There are two orders with status 2", 2, orders.size());
	}

	@Test
	public void orderServiceTotalCostTest() {
		List<Order> orders = orderService.getOrdersByStatus(company, 2);
		double total =
			orderService.getTotalCostOfOrder(orders.get(0)) + orderService.getTotalCostOfOrder(orders.get(1));
		assertEquals("44.27 + 30.25 + 3.10", 77.62, total, 0.001);
	}

	@Test
	public void customerServiceTest() {
		Map<Integer, List<Order>> orderMap = customerService.getOrdersForCustomer(company);

		assertNotNull("Data should be returned", orderMap);
		assertEquals("There should be orders for 3 customers", 3, orderMap.keySet().size());

		//Adam Aaronson's orders
		List<Order> orders = orderMap.get(1);
		assertEquals("1 order expected for Adam Aaronson.", 1, orders.size());

		assertEquals("TESTORDER123", orders.get(0).getOrderNumber());

		assertEquals(100d, orders.get(0).getOrderItems().get(0).getUnitPrice(), 0.00);

		orders = orderMap.get(2);
		assertEquals("2 orders expected for Billy Blanks.", 2, orders.size());

		assertEquals(33.35, orderService.getTotalCostOfOrder(orders.get(0)), 0.00);

		assertEquals("Billy Blanks", orders.get(0).getCustomer().getCustomerName());

		orders = orderMap.get(3);
		assertEquals(1, orders.get(0).getOrderItems().size());
		assertEquals(1, orders.get(1).getOrderItems().size());
	}
}
