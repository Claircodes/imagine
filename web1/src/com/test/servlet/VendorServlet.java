package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;
import com.test.service.VendorService;

public class VendorServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	private VendorService vs = new VendorService();
    Gson g = new Gson();	
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		request.setCharacterEncoding("UTF-8");
		String resultStr = "";
		doProcess(response, resultStr);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
	    Vendor vendor = g.fromJson(request.getReader(), Vendor.class);
	    System.out.println(vendor);
	    String command = vendor.getCommand();
    	Page page = vendor.getPage();
    	
	    if(command.equals("list")){
	    	int totalCnt = vs.getTotalCount(vendor);
	    	page.setTotalCnt(totalCnt);
	    	
	    	List<Vendor> vendorList = vs.selectVendorList(vendor);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("page", page);
	    	resultMap.put("list", vendorList);
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    }else if(command.equals("insert")){
	    	int result = vs.insertVendor(vendor);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("page", page);
	    	resultMap.put("msg", "등록이 완료 되었습니다.");
	    	resultMap.put("url", "/goods/vendor_list.jsp");
	    	if(result!=1){
		    	resultMap.put("msg", "등록이 실패하였습니다.");
		    	resultMap.put("url", "");
	    	}
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    }else if(command.equals("delete")){
	    	int result = vs.deleteVendor(vendor);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("page", page);
	    	resultMap.put("msg", "삭제가 완료 되었습니다.");
	    	resultMap.put("url", "/goods/vendor_list.jsp");
	    	if(result!=1){
		    	resultMap.put("msg", "삭제가 실패하였습니다.");
		    	resultMap.put("url", "");
	    	}
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    }else if(command.equals("view")){
	    	Vendor resultVendor = vs.selectVendor(vendor);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("page", page);
	    	resultMap.put("vendor", resultVendor);
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    }else if(command.equals("update")){
	    	int result = vs.updateVendor(vendor);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("page", page);
	    	resultMap.put("msg", "수정이 완료되었습니다.");
	    	resultMap.put("url", "/goods/vendor_list.jsp");
	    	if(result!=1){
	    		resultMap.put("msg", "등록이 실패하였습니다.");
	    		resultMap.put("url", "");
	    	}
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    }else if(command.equals("delete")){
	    	
	    }
	}
	
	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}
}