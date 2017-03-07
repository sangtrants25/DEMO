package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/sangtrants")
	public String hello(@RequestParam("name") String userName, Model model){
		model.addAttribute("message", "Hello, "+userName);
		return "view/resultPage";
	}
}
