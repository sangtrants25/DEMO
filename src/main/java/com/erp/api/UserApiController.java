package com.erp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.model.User;
import com.erp.service.UserService;

@RestController
@RequestMapping("/api")
public class UserApiController {
	@Autowired
	private UserService userService;
	@RequestMapping(value ="/users", method = RequestMethod.GET)
	public List<User> getUsers(Model model){
		List<User> users = userService.findAllUsers();
		return users;
	}
}
