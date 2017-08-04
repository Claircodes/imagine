<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.test.common.DBConn"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
JSONObject j = new Gson().fromJson(request.getReader(), JSONObject.class);
	
	List<Map<String,Object>> list = null;
	
	Connection con = null;
	PreparedStatement ps = null;
	try {
		con = DBConn.getCon();
		String sql = "select vinum,viname from vendor_info";	
		
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		list = new ArrayList<>();
		while (rs.next()) {
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("vinum", rs.getString("vinum"));
			hm.put("viname", rs.getString("viname"));
			list.add(hm);
		}
	} catch (Exception e) {
		System.out.println(e);
	} finally {
		if (ps != null) {
			ps.close();
			ps = null;
		}
		DBConn.closeCon();
	}
	String json = new Gson().toJson(list);
	out.write(json);

%>