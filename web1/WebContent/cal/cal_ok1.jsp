<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.*"%>
<%@ page import="com.google.gson.*"%>
<%
JSONObject j = new Gson().fromJson(request.getReader(), JSONObject.class);
String num1 = j.get("num1").toString();
String num2 = j.get("num2").toString();

HashMap hm = new HashMap();
hm.put("finish", "ok");
hm.put("num1", num1);
hm.put("num2", num2);
String json = new Gson().toJson(hm);
out.write(json);
%>