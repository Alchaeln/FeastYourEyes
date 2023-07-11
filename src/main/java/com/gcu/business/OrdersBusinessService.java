package com.gcu.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.OrderModel;

/**
 * OrdersBusinessService has a method to return order list and default init and destroy methods.
 * @author Chael
 */
public class OrdersBusinessService implements OrdersBusinessServiceInterface{
	
	//Autowired DataAccessInterface to be able to return the Order data
	@Autowired
	DataAccessInterface<OrderModel> service;

	/**
	 * returns the order list from data access service
	 * @return orders
	 */
	public List<OrderModel> getOrders() {
		//returns list of orders from the database
		return service.findAll();
	}

	/**
	 * Console output to make sure OrdersBusinessService is being initialized
	 */
	@PostConstruct
	public void init() {
		System.out.println("INIT");
	}

	/**
	 * Console output to make sure OrdersBusinessService is being destroyed
	 */
	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}


}
