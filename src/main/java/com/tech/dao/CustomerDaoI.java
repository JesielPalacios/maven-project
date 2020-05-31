package com.tech.dao;

import java.util.List;

import com.tech.model.Company;
import com.tech.model.Customer;

public interface CustomerDaoI {
	/**
	 * 
	 * @param company
	 * @param customerId
	 * @return Customer for the input customer ID and given company
	 */
	Customer find(Company company, int customerId);
	
	/**
	 * 
	 * @param company
	 * @return a list of all customers that do business with the input company
	 */
	List<Customer> findAll(Company company);
}
