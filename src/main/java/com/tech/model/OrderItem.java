package com.tech.model;

/**
 * An order is made up of one or more Order Items. These constitute the purchase of
 * a particular product in a quantity that is one or more.
 *
 */
public class OrderItem {
	private int orderItemId;
	private String listingSku;
	private String listingName;
	private int quantityOrdered;
	private int quantityShipped;
	private double unitPrice;
	private double tax;
	
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	/**
	 * 
	 * @return a unique identifier for the product
	 */
	public String getListingSku() {
		return listingSku;
	}
	public void setListingSku(String listingSku) {
		this.listingSku = listingSku;
	}
	public String getListingName() {
		return listingName;
	}
	public void setListingName(String listingName) {
		this.listingName = listingName;
	}
	/**
	 * 
	 * @return the number ordered of this item
	 */
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	public int getQuantityShipped() {
		return quantityShipped;
	}
	public void setQuantityShipped(int quantityShipped) {
		this.quantityShipped = quantityShipped;
	}
	/**
	 * 
	 * @return the price of one quantity of the given item.
	 */
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * 
	 * @return The total tax for all the quantity of this item
	 */
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
}
