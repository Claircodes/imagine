package com.test.servlet_test;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormServlet extends CommonServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String result ="id는 "+id+", pwd는"+pwd; 
		System.out.println(result);
		doProcess(response, result);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HashMap hm = g.fromJson(request.getReader(), HashMap.class);
		String resulthm = g.toJson(hm);		
    	doProcess(response,resulthm);
	}
}
