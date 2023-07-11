package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.exception.DatabaseException;

import com.gcu.model.OrderModel;

@Service
public class OrdersDataService implements DataAccessInterface<OrderModel> {

	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * This method instantiates the OrdersDataService
	 * 
	 * @param dataSource
	 */
	public OrdersDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/**
	 * This method returns all Orders from the database into a List
	 */
	public List<OrderModel> findAll() {
		String sql = "SELECT * FROM ORDERS";
		List<OrderModel> orders = new ArrayList<OrderModel>();
		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while (srs.next()) {
				orders.add(new OrderModel(srs.getLong("ID"), srs.getLong("products_ID"), srs.getLong("users_ID"),
						srs.getFloat("TOTAL"), srs.getInt("QUANTITY")));
			}
		}
		// catches any exception and throws our custom exception
		catch (Exception e) {
			throw new DatabaseException("The Database Crashed", e);
		}
		return orders;
	}

	/**
	 * This method takes the id parameter and searches the database for an Order with a matching id and returns the order
	 * @param id
	 */
	@Override
	public OrderModel findById(long id) {
		return null;
	}

	/**
	 * This method creates a new Order within the database with the data passed in through the parameter
	 * @param order
	 */
	@Override
	public boolean create(OrderModel order) {
		String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES (?, ?, ?, ?))";
		try {
			int rows = jdbcTemplateObject.update(sql, order.getProductId(), order.getUserId(), order.getTotal(),
					order.getQuantity());
			return rows == 1 ? true : false;
		}
		// catches any exception and throws our custom exception
		catch (Exception e) {
			throw new DatabaseException("The Database Crashed", e);
		}
	}

	/**
	 * This method updates an Order within the database with the data passed in through the parameter
	 * @param order
	 */
	@Override
	public boolean update(OrderModel order) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * This method deletes an Order within the database with the data passed in through the parameter
	 * @param order
	 */
	@Override
	public boolean delete(OrderModel order) {
		// TODO Auto-generated method stub
		return true;
	}

}
