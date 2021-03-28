package com.atul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
	@GetMapping("/home")
	public ModelAndView getHomePage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
}
