package com.tech.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.tech.model.Company;
import com.tech.model.Customer;

@Repository
public class CustomerDao extends GenericDao implements CustomerDaoI {

	public CustomerDao() {
	}

	@Autowired
	public CustomerDao(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public Customer find(Company company, int customerId) {
		String sql = "SELECT * FROM customers where company_id = ? AND customer_id = ? ";
		
		Customer retCustomer = jdbcTemplateObject.queryForObject(sql, new Object[] {company.getCompanyId(), customerId}, 
				new BeanPropertyRowMapper<Customer>(Customer.class));

		retCustomer.setCompany(company);
		return retCustomer;
	}

	@Override
	public List<Customer> findAll(Company company) {
		String sql = "SELECT * FROM customers where company_id = ? ";
		
		List<Customer> retCustomers = jdbcTemplateObject.query(sql, new Object[] {company.getCompanyId()}, 
				new BeanPropertyRowMapper<Customer>(Customer.class));

		for(Customer customer : retCustomers){
			customer.setCompany(company);
		}
		
		return retCustomers;
	}

}
