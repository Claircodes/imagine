package com.iot.sp.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
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
public class UserController { 

	@Autowired
	private UserService us;
	
	@RequestMapping("/main")
	public String init(HttpServletRequest request, ModelMap model, 
			HttpSession hs, @CookieValue(value="id",required=false)Cookie ck) {
		UserInfo user = (UserInfo)hs.getAttribute("user");
		if(user!=null){
			model.addAttribute("userid", user.getUserId());
			return "/user/main";
		}else{
			String userId="";
			if(ck!=null){
				userId = ck.getValue();
			}
			model.addAttribute("userId", userId);
			return "/user/login";
		} 
	}
//url.jsp 로 간다
	@RequestMapping(value="/{path}", method=RequestMethod.GET)
	public String getBoard(@PathVariable("path") String url){
		return "/user/" + url;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody ModelMap login(HttpServletRequest request, 
			@RequestBody UserInfo pUser,ModelMap model,HttpSession hs,
			HttpServletResponse response, 
			@CookieValue(value="id",required=false)Cookie ck) {
		UserInfo user = us.getUser(pUser);
		if(user==null){
			model.put("data", "F");
			model.put("url", "/user/login");
			model.put("msg", "Login Fail");
		}else{
			if(pUser.isSaveId()){
				if(ck==null){
					ck = new Cookie("id",pUser.getUserId());
					ck.setMaxAge(60*60*24*30);
				}else{
					System.out.println(ck.getMaxAge());
					ck.setMaxAge(60*60*24*30);
				}
				response.addCookie(ck);
				System.out.println(ck); 
			}
			hs.setAttribute("user", user);
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

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession hs) {
		hs.invalidate();
		return "redirect:/user/main";
	}
	
	@RequestMapping(value="/test")
	public String test(HttpServletRequest request,ModelMap model){
		String test = request.getParameter("test");
		if(test==null){
			test = "널입니다.";
		}
		model.addAttribute("test",test);
		return "test";
	}
}
