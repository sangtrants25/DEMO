package com.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.mapper.CustomerMapper;
import com.erp.model.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	public List<Customer> FindAllCustomers(){
		return customerMapper.FindAllCustomer();
	}
	
	public Customer FindCustomer(String id){
		return customerMapper.FindCustomerById(id);
	}
	
	public void UpdateCustomer(Customer cus){
		customerMapper.UpdateCustomer(cus);
	}

}
