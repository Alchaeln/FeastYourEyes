package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MapController {

	
	@GetMapping("/map")
	public String Map(Model model) 
	{
		model.addAttribute("title", "M A P");
		//model.addAttribute("loginModel", new UserModel());
		return "map";
	}
	
	@GetMapping("/exactMap")
	public String exactMap(Model model) 
	{
		model.addAttribute("title", "exact");
		//model.addAttribute("loginModel", new UserModel());
		return "exactMap";
	}
	
	@GetMapping("/searchMap")
	public String searchMap(Model model) 
	{
		model.addAttribute("title", "search");
		//model.addAttribute("loginModel", new UserModel());
		return "searchMap";
	}
	
}