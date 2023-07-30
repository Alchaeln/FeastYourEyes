package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.model.UserModel;

@Controller
public class ChooseController {

	
	@GetMapping("/choose")
	public String choose(Model model) 
	{
		model.addAttribute("title", "C H O O S E");
		//model.addAttribute("loginModel", new UserModel());
		return "choose";
	}
	
	@GetMapping("/choose2")
	public String testChoose(Model model) 
	{
		model.addAttribute("title", "C H O O S E");
		//model.addAttribute("loginModel", new UserModel());
		return "choose";
	}
}
