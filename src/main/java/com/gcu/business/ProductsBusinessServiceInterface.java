package com.gcu.business;

import java.util.List;

import com.gcu.model.ProductModel;

public interface ProductsBusinessServiceInterface {
	
	/**
	 * returns products from database
	 * @return products
	 */
	public List<ProductModel> getProducts();
	
	/**
	 * returns one product from the database
	 */
	ProductModel getProduct(long id);
	
	/**
	 * make sure service is being initialized
	 */
	public void init();
	
	/**
	 * make sure service is being initialized
	 */
	public void destroy();
}
