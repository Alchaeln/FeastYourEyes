package com.gcu.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Model for register to get input from register page
 * @author Chael
 */
public class UserModel {
	
	//initialize variables with validation requirements 
	@NotNull(message="First name is a required field")
	@Size(min=1, max=20, message="First name must be between 1 and 32 characters")
	private String firstname;
	
	@NotNull(message="Last name is a required field")
	@Size(min=1, max=20, message="Last name must be between 1 and 32 characters")
	private String lastname;
	
	@NotNull(message="Address is a required field")
	@Size(min=1, max=30, message="Address must be between 1 and 32 characters")
	private String address;
	
	@NotNull(message="Email is a required field")
	@Size(min=1, max=30, message="Email must be between 1 and 32 characters")
	private String email;
	
	@Valid
	private CredentialsModel credentials;
	
	/**
	 * public getter for credentials
	 * @return credentials
	 */
	public CredentialsModel getCredentials() {
		return credentials;
	}
	/**
	 * public setter for credentials
	 * @param credentials
	 */
	public void setCredentials(CredentialsModel credentials) {
		this.credentials = credentials;
	}
	/**
	 * public getter for address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * public setter for address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * public getter for first name
	 * @return firstName
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * public setter for first name
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * public getter for last name
	 * @return lastName
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * public setter for last name
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * public getter for email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * public setter for email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
