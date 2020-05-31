package com.tech.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class GenericDao {
	protected DataSource dataSource;
	protected JdbcTemplate jdbcTemplateObject;
	
	public GenericDao () {}
	
	public GenericDao(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
}
