package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Displays mai menu at root URL
 * @author Chael
 */
@Controller
//Sets up URI for localhost:8080/
@RequestMapping("/")
public class MainMenuController {
	
	/**
	 * adds objects to home model and sets view as home page
	 * @return home page model and view
	 */
	//Sets up URI for localhost:8080/ which is the root URI
	@GetMapping("/")
	public ModelAndView display() 
	{
		//creates model and view object
		ModelAndView mv = new ModelAndView();
		//adds text to be displayed
		mv.addObject("title", new String("H O M E"));
		mv.addObject("message", new String("Welcome to Feast Your Eyes"));
		mv.addObject("message2", new String("The web application to fulfill your eyes hunger"));
		//sets view name to display home.html
		mv.setViewName("home");
		return mv;
	}
	
	@GetMapping("/aboutUs")
	public ModelAndView aboutPage() 
	{
		//creates model and view object
		ModelAndView mv = new ModelAndView();
		//adds text to be displayed
		mv.addObject("message", new String("About us"));
		mv.addObject("message2", new String("The website application is called \"Feast Your Eyes\" and it is a food discovery platform that allows users to choose right or left on different foods based on their location and desired radius. The platform utilizes the user's GPS location to show them a variety of food options within the specified radius, and users can choose right on foods they are interested in trying and left on those they are not.\r\n"
				+ "\r\n"
				+ "Once a user chooses to go right on a food, it is saved to a separate \"Favorites\" page where they can view more information about the place where the food is from, including the name and address of the restaurant, and menu items. The information will include what times the place is open.\r\n"
				+ "\r\n"
				+ "Additionally, Feast also allows users to choose what they are looking for by a filter that distinguishes between fast food, restaurant, and dessert. It will be a fun and easy way to decide by feasting with your eyes."));
		//sets view name to display home.html
		
		mv.addObject("message3", new String("Approach to Implementation"));
		mv.addObject("message4", new String("It all began with creating with Google Maps API and trying to integrate similar aspects from various websites. The application has taken weeks to develop, implementation includes the ability to log in and out, choose if you like the food, add foods to the favorites. This became increasingly difficult, but has since become such a great learning experience."));
		
		mv.addObject("message5", new String("Install Instructions"));
		mv.addObject("message6", new String("In order to run the project, users must ensure to download the files from the github and have SpringToolSuite installed. Once installed, ensure you have MAMP and import the SQL database. Run the program files on SpringToolSuite and start the servers for the Database.  Then the user goes to localhost:8080 and enters the web application."));
		
		
		mv.addObject("message7", new String("Diagrams"));
		
		mv.setViewName("aboutUs");
		return mv;
	}
}
