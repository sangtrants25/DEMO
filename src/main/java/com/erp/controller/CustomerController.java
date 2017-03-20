package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.service.CustomerService;


@Controller
public class CustomerController {
	/*
	@Autowired
	private CustomerService customerService;*/
	@RequestMapping("/customer")
	public String getCustomer(Model model){
		return "view/customer";
	}
	@RequestMapping("/customerdetail")
	public String getCustomerDetail(Model model){
		return "view/CustomerDetail";
	}
	
}	
