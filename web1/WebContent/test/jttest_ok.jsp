<%@page import="java.util.regex.Pattern"%>
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.*"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="java.sql.*"%>
<%
JSONObject j = new Gson().fromJson(request.getReader(), JSONObject.class);
String command = j.get("command").toString();

if (command.equals("insert")) {
	HashMap hm = new HashMap();

	if (j.get("jtnum").toString()==null || j.get("jtnum").toString().equals("")|| !Pattern.matches("(^[0-9]*$)", j.get("jtnum").toString())){
		hm.put("finish", "숫자 입력해");
	}else if(j.get("jttext").toString()==null || j.get("jttext").toString().equals("")){
		hm.put("finish", "텍스트 입력해");
	}else{
	int jtnum = Integer.parseInt(j.get("jtnum").toString());
	String jttext = j.get("jttext").toString();
	String finish = "fasle";
	
	Connection con = null;
	PreparedStatement ps = null;
	int insertResult = 0;
	try {
		con = DBConn.getCon();
		String sql = "insert into json_test (jtnum, jttext) VALUES (?,?)";
		ps = con.prepareStatement(sql);
		ps.setInt(1, jtnum);
		ps.setString(2, jttext);

		insertResult = ps.executeUpdate();
		if (insertResult == 1) {
			con.commit();
			hm.put("finish", "ok");
		}
	} catch (Exception e) {
		out.println(e);
	} finally {
		ps.close();
		DBConn.closeCon();
	}
	}

	String json = new Gson().toJson(hm);

	out.write(json);

} else if (command.equals("select")) {
	List list = null;
	String allOrOne = j.get("allOrOne").toString();
	
	Connection con = null;
	PreparedStatement ps = null;
	try {
		con = DBConn.getCon();
		String sql = "SELECT jtnum, jttext FROM json_test";
		if (allOrOne.equals("one")) {
			sql += " WHERE jtnum = ?";
		}
		ps = con.prepareStatement(sql);
		if (allOrOne.equals("one")) {
			System.out.println(j.get("jtnum").toString());
			ps.setInt(1, Integer.parseInt(j.get("jtnum").toString()));
		}
		ResultSet rs = ps.executeQuery();
		list = new ArrayList();
		while (rs.next()) {
			HashMap hm = new HashMap();
			hm.put("jtnum", rs.getInt("jtnum"));
			hm.put("jttext", rs.getString("jttext"));
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