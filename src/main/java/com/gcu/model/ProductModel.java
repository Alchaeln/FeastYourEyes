package com.gcu.model;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

/**
 * Model for products to be sold
 * @author Chael
 */
public class ProductModel {
	//creates private variables
	@NotNull(message="ID is a required field")
	private long id;
	
	@Size(min=1, max=30, message="productName must be between 1 and 30 characters")
	private String productName;
	
	private String price;
	
	private String quantity;
	
	//new photo connection
	
	private String photoUrl;

	    public String getPhotoUrl() {
	        return photoUrl;
	    }

	    public void setPhotoUrl(String photoUrl) {
	        this.photoUrl = photoUrl;
	    }
	    
	/**
	 * public getter for private variable id
	 * @return id
	 */
	public long getId() {
		return id;
	}
	/**
	 * public setter for private variable id
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * public getter for private variable productName
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * public setter for private variable productName
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * public getter for private variable price
	 * @return price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * public setter for private variable price
	 * @param price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * public getter for private variable quantity
	 * @return quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * public setter for private variable quantity
	 * @param quantity
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public ProductModel(long id, String productName, String price, String quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public ProductModel() {
		// TODO Auto-generated constructor stub
	}
}
