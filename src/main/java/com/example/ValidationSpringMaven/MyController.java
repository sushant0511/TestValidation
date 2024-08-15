package com.example.ValidationSpringMaven;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.validation.Valid;

@Controller
public class MyController implements WebMvcConfigurer 
{

	public void addViewControllers(ViewControllerRegistry registry) 
	{
		registry.addViewController("/result").setViewName("result");
	}
	
	
	@GetMapping("/")
	public String showForm(Voter voter) {
		
		return "form";
		
	}
	
	@PostMapping("/")
	public String verifyVoterInfo(@Valid Voter voter, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			return "form";
		}
		
		else
			return "redirect:/result";
		
	}
	
	
	
	
	
	
}
