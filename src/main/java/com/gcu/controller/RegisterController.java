package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.SecurityBusinessService;
import com.gcu.data.UsersDataService;
import com.gcu.model.CredentialsModel;
import com.gcu.model.UserModel;

/**
 * controls all of the register page routes
 * @author Chael
 */
@Controller
//Sets up URI for localhost:8080/register
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private SecurityBusinessService security;
	
	@Autowired
	private UsersDataService userService;

	/**
	 * add attributes to model and returns register view
	 * @param model
	 * @return register view
	 */
	//Sets up URI for localhost:8080/register/
	@GetMapping("/")
	public String display(Model model) 
	{
		//adds title and register model to be displayed
		model.addAttribute("title", "Register Form");
		model.addAttribute("userModel", new UserModel());
		return "register";
	}
	
	/**
	 * verifies inputs and continues to login page if inputs are valid
	 * @param registerModel
	 * @param bindingResult
	 * @param model
	 * @return login view
	 */
	//Sets up URI for localhost:8080/register/doRegister
	@PostMapping("/doRegister")
	//@Valid checks that all inputs are valid
	public String doRegister(@Valid UserModel user, BindingResult bindingResult, Model model) 
	{
		//if an input is invalid, send back to register page
		if(bindingResult.hasErrors()) 
		{
			model.addAttribute("title", "Register Form");
			return "register";
		}
		try {
		//pass in all variables to security service
		security.authenticateRegister(user.getCredentials().getUsername(), 
				user.getCredentials().getPassword(), 
				user.getFirstname(),
				user.getLastname(),
				user.getAddress(),
				user.getEmail());
		
		//creates new user in database
		userService.create(user);
		
		//creates login model
		CredentialsModel userLogin = new CredentialsModel();
		//adds title and login model to model for web page
		model.addAttribute("title", "Login Form");
		model.addAttribute("credentialsModel", userLogin);
		
		//prints inputs into console
		System.out.println(String.format("New User created with %s user name, %s password, %s %s name, %s phone number, %s email",
				user.getCredentials().getUsername(), 
				user.getCredentials().getPassword(), 
				user.getFirstname(), 
				user.getLastname(), 
				user.getAddress(), 
				user.getEmail()));
	
		return "login";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//sends user to error page
			model.addAttribute("title", "Error Page");
			model.addAttribute("message", "ERROR: You have now entered the error page");
			return "errors";
		}
	}
	
}
