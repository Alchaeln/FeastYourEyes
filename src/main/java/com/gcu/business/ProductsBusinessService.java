package com.gcu.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.ProductModel;

public class ProductsBusinessService implements ProductsBusinessServiceInterface {

	//DataAccessInterface to be able to connect to database
	@Autowired
	DataAccessInterface<ProductModel> service;
	
	/**
	 * returns all products from the database
	 */
	@Override
	public List<ProductModel> getProducts() {
		return service.findAll();
	}
	
	/**
	 * returns one product from the database
	 */
	@Override
	public ProductModel getProduct(long id) {
		return service.findById(id);
	}

	/**
	 * Prints INIT to console to show initialization
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
