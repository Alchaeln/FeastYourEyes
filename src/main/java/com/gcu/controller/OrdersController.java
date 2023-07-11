package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.model.CredentialsModel;

@Controller
@RequestMapping("/order")
public class OrdersController {
	
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@GetMapping("/display")
	public String display(CredentialsModel credentials, BindingResult bindingResult, Model model) {
		// if username or password is invalid, send back to login page
		if (bindingResult.hasErrors()) 
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}

		try
			{
				// gets username and adds title that the user is logged in as "username"
				model.addAttribute("title", "You are logged in!");
				// passes order list that was just made to orders page
				model.addAttribute("orders", service.getOrders());
				return "choose";
			}
		catch (Exception e) 
			{
				e.printStackTrace();
				model.addAttribute("title", "Error Page");
				// passes order list that was just made to orders page
				model.addAttribute("message", "ERROR: You have now entered the error page");
				return "errors";
			}
	
	}
}
