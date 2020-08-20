package com.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
	@GetMapping(value="/hello")
	public String initPage(Model model) {
		model.addAttribute("myName","Nguyen Sanh Trung"); 
		return "hello";
	}
}
