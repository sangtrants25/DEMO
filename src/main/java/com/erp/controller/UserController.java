package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.service.UserService;
import com.erp.model.User;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/user")
	public String getUsers(Model model){
		/*List<User> users = userService.findAllUsers();
		System.out.println("users"+users.size());
		model.addAttribute("users", users);*/
		return "view/users";
	}
	@RequestMapping("/base")
	public String getBase(Model model){
		return "layout/base";
	}
}
