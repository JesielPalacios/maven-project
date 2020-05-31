package com.tech.dao;

import com.tech.model.Company;

public interface PerformanceDataDaoI {

	/**
	 * Calculates the sum of the "order total" across all Orders. The order total
	 * for a single order is defined as the quantity of an order item multiplied by
	 * its unit cost. This is then added to the tax.
	 * @param company
	 * @return the sum order total of all orders for a company
	 */


	public double getTotalSalesAmountForCompany(Company company);

	/**
	 * Calculate the number of items ordered for a company.
	 * @param company
	 * @return the sum of the quantity fields in Order Items across
	 * all orders for a company. For example, if an Order contains one
	 * Order Item with a quantity of 1, and another with a quantity of 2,
	 * the total items ordered is 3.
	 */
	public int getTotalItemsOrderedForCompany(Company company);
}
