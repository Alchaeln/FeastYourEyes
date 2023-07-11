package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.exception.DatabaseException;
import com.gcu.model.UserModel;

/**
 * This class inmplements the data access interface to get users from the database
 * @author Chael
 */
@Service
public class UsersDataService implements DataAccessInterface<UserModel> {

	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * This method is used to instantiate the UserDataService Class
	 * @param dataSource
	 */
	public UsersDataService(DataSource dataSource) 
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * This method is used to create a new user in the database
	 * @param user
	 */
	@Override
	public boolean create(UserModel user) {
		String sql = "INSERT INTO users( FIRST_NAME, LAST_NAME, ADDRESS, EMAIL, USERNAME, PASSWORD) VALUES (?, ?, ?, ?, ?, ?)";
		try 
		{
			int rows = jdbcTemplateObject.update(sql,
												user.getFirstname(),
												user.getLastname(),
												user.getAddress(),
												user.getEmail(),
												user.getCredentials().getUsername(),
												user.getCredentials().getPassword());
			return rows == 1 ? true : false;
		}
		//catch any exceptions and throw custom exception
		catch(Exception e){
			throw new DatabaseException("The Database Crashed", e);
		}
	}

	/**
	 * This method is used to update a user in the database
	 * @param user
	 */
	@Override
	public boolean update(UserModel user) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * This method is used to delete a user in the database
	 * @param user
	 */
	@Override
	public boolean delete(UserModel user) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * This method returns all users in the database
	 */
	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method returns a specific user in the database found by the user id
	 * @param id
	 */
	@Override
	public UserModel findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
