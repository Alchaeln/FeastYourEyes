package com.gcu.business;

import org.springframework.stereotype.Service;

/**
 * SecurityBusinessService is used to authenticate users
 * @author Chael
 */
@Service
public class SecurityBusinessService {
	/**
	 * Placeholder authentication for login that returns true
	 * @param username
	 * @param password
	 * @return true
	 */
	 public boolean authenticateLogin(String username, String password) 
	 {
		 System.out.printf("Authenticated %s with password %s", username, password);
		 return true;
	 }
	 
	 /**
		 * Placeholder authentication for register that returns true
		 * @param username
		 * @param password
		 * @param firstName
		 * @param lastName
		 * @param address
		 * @param email
		 * @return true
		 */
	 public boolean authenticateRegister(String username, String password, String firstName, String lastName, String address, String email) 
	 {
		 System.out.printf("Authenticated %s with password %s first name %s  last name %s address %s email %s", username, password, firstName, lastName, address, email);
		 return true;
	 }
}
