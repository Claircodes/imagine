<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.test.common.DBConn"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
JSONObject j = new Gson().fromJson(request.getReader(), JSONObject.class);
String command = j.get("command").toString();

if (command.equals("car_select")){
	
	List<Map<String,Object>> list = null;
	String allOrOne = j.get("allOrOne").toString();
	String opVinum = j.get("opVinum").toString();
	Connection con = null;
	PreparedStatement ps = null;
	try {
		con = DBConn.getCon();
		String sql = "SELECT vi.viname,gi.giname,gi.gidesc,gi.gicredat,gi.gicretim FROM goods_info AS gi ";
		sql += "INNER JOIN vendor_info AS vi ON vi.vinum=gi.vinum ";
		if (allOrOne.equals("one")) {		
			sql +="where gi.ginum=?";
		}else if(!opVinum.equals("선택")){
			sql +="where gi.vinum=?";
		}
		ps = con.prepareStatement(sql);
		if (allOrOne.equals("one")) {
			ps.setInt(1, Integer.parseInt(j.get("ginum").toString()));
		}else if(!opVinum.equals("선택")){
			ps.setInt(1, Integer.parseInt(opVinum));
		}
		ResultSet rs = ps.executeQuery();
		list = new ArrayList<>();
		while (rs.next()) {
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("vname", rs.getString("vi.viname"));
			hm.put("cname", rs.getString("gi.giname"));
			hm.put("desc", rs.getString("gi.gidesc"));
			hm.put("credat", rs.getString("gi.gicredat"));
			hm.put("cretim", rs.getString("gi.gicretim"));
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
}
%>