package com.iot.sp.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iot.sp.user.dto.UserInfo;
import com.iot.sp.user.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("id")
public class UserController { 

	@Autowired
	private UserService us;

	
	@RequestMapping("/main")
	public String init(HttpServletRequest request, ModelMap model, HttpSession hs) {
		String id = (String)hs.getAttribute("ID");
		if(id!=null){
			model.addAttribute("userid", id);
			return "/user/main";
		}else{
			return "/user/login";
		} 
	}

	@RequestMapping(value="/{path}", method=RequestMethod.GET)
	public String getBoard(@PathVariable("path") String url){
		return "/user/" + url;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody ModelMap loginTest(HttpServletRequest request, @RequestBody UserInfo pUser,ModelMap model,HttpSession hs) {
		UserInfo user = us.getUser(pUser);
		if(user==null){
			model.put("data", "F");
			model.put("url", "/user/login");
			model.put("msg", "Login Fail");
		}else{
			hs.setAttribute("ID", user.getUserId());
			model.put("data", "S");
			model.put("url", "/user/main");
			model.put("msg", "Login Success");
		}
		return model;
	}

	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody ModelMap getUserList(HttpServletRequest request, @RequestBody Map hm,ModelMap model,HttpSession hs) {

		List<UserInfo> userList = us.getUserList(hm);
		model.put("userList",userList);
		return model;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String goPage(HttpServletRequest request) {
		return "/user/list";
	}
}
