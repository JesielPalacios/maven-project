package com.tech.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.tech.model.Company;

@Repository
public class CompanyDao extends GenericDao implements CompanyDaoI {

	@Autowired
	public CompanyDao(DataSource dataSource) {
		super(dataSource);
	}
	@Override
	public Company find(int companyId) {
		String sql = "select * from companies where company_id = ?";
		Company c = 
			jdbcTemplateObject.queryForObject(sql, new Object[] {companyId}, 
					new BeanPropertyRowMapper<Company>(Company.class));
		return c;
	}

}
