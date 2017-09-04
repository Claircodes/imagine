package com.iot1.sql.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iot1.sql.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService us;
	
	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public String login(){
		return "user/login";
	}
	
}
