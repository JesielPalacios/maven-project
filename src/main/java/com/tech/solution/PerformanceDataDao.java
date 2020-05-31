package com.tech.solution;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.dao.GenericDao;
import com.tech.dao.PerformanceDataDaoI;
import com.tech.model.Company;

@Repository
public class PerformanceDataDao extends GenericDao implements PerformanceDataDaoI {

	@Override
	public double getTotalSalesAmountForCompany(Company company) {
		//TODO: insert the proper SQL for this task
		String sql = "SELECT SUM((QUANTITY_ORDERED * UNIT_PRICE) + TAX) " +
				"FROM ORDER_ITEMS "+
				"INNER JOIN ORDERS ON ORDERS.ORDER_ID = ORDER_ITEMS.ORDER_ID " +
				"WHERE ORDERS.COMPANY_ID = ? ";

		return jdbcTemplateObject.queryForObject(sql, Double.class, new Object[] {company.getCompanyId()});
	}

	@Override
	public int getTotalItemsOrderedForCompany(Company company) {
		//TODO: insert the proper SQL for this task
		String sql = "SELECT SUM(QUANTITY_ORDERED) "
				+ "FROM ORDER_ITEMS "
				+ "INNER JOIN ORDERS ON ORDERS.ORDER_ID = ORDER_ITEMS.ORDER_ID "
				+ "WHERE ORDERS.COMPANY_ID = ? ";

		return jdbcTemplateObject.queryForObject(sql, Integer.class, new Object[] {company.getCompanyId()});
	}


	public PerformanceDataDao() {
	}

	@Autowired
	public PerformanceDataDao(DataSource dataSource) {
		super(dataSource);
	}

}
