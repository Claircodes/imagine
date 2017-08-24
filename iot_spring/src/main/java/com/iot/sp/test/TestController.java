package com.iot.sp.test;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model map){
		return "test/list";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model map){
		return "test/write";
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model map){
		return "test/modify";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model map){
		return "test/delete";
	}
}
