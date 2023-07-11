package com.gcu.data;

import java.util.List;

/**
 * This interface is the basic format for all the Data access services
 * @author Chael
 * @param <T>
 */
public interface DataAccessInterface <T> {
	
	/**
	 * This method will return the full list of items from the database
	 * @return list
	 */
	public List<T> findAll();
	
	/**
	 * This method will return a single item that is found in the database by using the id
	 * @param id
	 * @return item
	 */
	public T findById(long id);
	
	/**
	 * This method creates a new item within the database
	 * @param t
	 * @return true : false
	 */
	public boolean create(T t);
	
	/**
	 * This method updates an item within the database
	 * @param t
	 * @return true : false
	 */
	public boolean update(T t);
	
	/**
	 * This method deletes an item within the database
	 * @param t
	 * @return true : false
	 */
	public boolean delete(T t);
}
