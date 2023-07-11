package com.exception;

/**
 * @author Chael
 * This class extends from RuntimeException to check for an unchecked exception of the database shutting down while using the website
 */
@SuppressWarnings("serial")
public class DatabaseException extends RuntimeException {
	
	/**
	 * Constructor for custom exception
	 * @param message
	 * @param cause
	 */
	public DatabaseException(String message, Throwable cause) {
		//calls super constructor to create custom exception
		super(message, cause);
	}
}
