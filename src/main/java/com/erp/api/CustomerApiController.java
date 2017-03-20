package com.erp.api;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.model.Customer;
import com.erp.service.CustomerService;

@RestController
@RequestMapping("/api")

public class CustomerApiController {
	@Autowired
	private CustomerService customerService;
	@RequestMapping(value ="/Customers", method = RequestMethod.GET)
	public List<Customer> getCustomers(Model model){
		List<Customer> customers = customerService.FindAllCustomers();
		return customers;
	}
	
	@RequestMapping(value ="/Customers/Detail/{id}", method = RequestMethod.GET)
	public Customer getCustomerDetail(@PathVariable String id){
		Customer customer = customerService.FindCustomer(id);
		return customer;
	}
	
	@RequestMapping(value ="/Customers/Update/{cus}", method = RequestMethod.POST)
	public void updateCustomer(@PathVariable Customer cus){
		customerService.UpdateCustomer(cus);
	}
}