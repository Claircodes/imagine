package com.test.servlet_test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class CommonServlet extends HttpServlet{
	protected Gson g = new Gson();
	
	protected void doProcess(HttpServletResponse resq, String writeStr) throws IOException{
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
	}
	
}
