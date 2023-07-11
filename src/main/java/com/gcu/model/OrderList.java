package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Allows the return of an XML version of orders list
 * @author Chael
 */
@XmlRootElement (name="orders")
public class OrderList {
	private List<OrderModel> orders = new ArrayList<OrderModel>();
	
	/**
	 * getter for orders
	 * @return orders
	 */
	@XmlElement(name="order")
	public List<OrderModel> getOrders()
	{
		return this.orders;
	}
	
	/**
	 * sets this.orders to orders
	 * @param orders
	 */
	public void setOrders(List<OrderModel> orders) 
	{
		this.orders = orders;
	}
}
