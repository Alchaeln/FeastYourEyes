package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.exception.DatabaseException;
import com.gcu.model.ProductModel;

@Service
public class ProductsDataService implements DataAccessInterface<ProductModel> {

	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * This method instantiates the ProductsDataService
	 * 
	 * @param dataSource
	 */
	public ProductsDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/**
	 * This method returns all Products from the database into a List
	 */
	public List<ProductModel> findAll() {
		String sql = "SELECT * FROM PRODUCTS";
		List<ProductModel> products = new ArrayList<ProductModel>();
		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while (srs.next()) {
				products.add(new ProductModel(srs.getLong("ID"), srs.getString("PRODUCT_NAME"), srs.getString("PRICE"),
						srs.getString("QUANTITY")));
			}
		}
		// catches any exception and throws our custom exception
		catch (Exception e) {
			throw new DatabaseException("The Database Crashed", e);
		}
		return products;
	}

	/**
	 * This method creates a new Product within the database with the data passed in through the parameter
	 * @param product
	 */
	@Override
	public boolean create(ProductModel product) {
		String sql = "INSERT INTO products( PRODUCT_NAME, PRICE, QUANTITY) VALUES (?, ?, ?)";
		try {
			/**int rows = jdbcTemplateObject.update(sql, product.getProductName(), product.getPrice(),
				product.getQuantity());
				**/
			int rows = jdbcTemplateObject.update(sql, "Subway", "Yes", "3.8");
			return rows == 1 ? true : false;
		}
		// catches any exception and throws our custom exception
		catch (Exception e) {
			throw new DatabaseException("The Database Crashed", e);
		}
	}

	/**
	 * This method updates a Product within the database with the data passed in through the parameter
	 * @param product
	 */
	@Override
	public boolean update(ProductModel product) {
		String sql = "UPDATE products SET PRODUCT_NAME = '" + product.getProductName() + "', PRICE = '"
				+ product.getPrice() + "', QUANTITY = '" + product.getQuantity() + "' WHERE ID = " + product.getId();
		try {

			int rows = jdbcTemplateObject.update(sql);

			return rows == 1 ? true : false;
		}
		// catches any exception and throws our custom exception
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method deletes a Product within the database with the data passed in through the parameter
	 * @param product
	 */
	@Override
	public boolean delete(ProductModel product) {
		String sql = "DELETE FROM products WHERE ID = " + product.getId();
		try {

			int rows = jdbcTemplateObject.update(sql);

			return rows == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method takes the id parameter and searches the database for a Product with a matching id and returns the order
	 * @param id
	 */
	@Override
	public ProductModel findById(long id) {
		String sql = "SELECT * FROM `products` WHERE `ID` = " + id;
		List<ProductModel> products = new ArrayList<ProductModel>();
		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while (srs.next()) {
				products.add(new ProductModel(srs.getLong("ID"), srs.getString("PRODUCT_NAME"), srs.getString("PRICE"),
						srs.getString("QUANTITY")));
			}
		}
		// catches any exception and throws our custom exception
		catch (Exception e) {
			throw new DatabaseException("The Database Crashed", e);
		}
		return products.get(0);
	}
}
