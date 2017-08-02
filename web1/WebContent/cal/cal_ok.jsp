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
	String finish = "fasle";

	if (command.equals("insert")) {
		int num1 = Integer.parseInt(j.get("num1").toString());
		int num2 = Integer.parseInt(j.get("num2").toString());

		String op = j.get("op").toString();

		int result = 0;

		switch (op) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		}
		Connection con = null;
		PreparedStatement ps = null;
		int insertResult = 0;
		try {
			con = DBConn.getCon();
			String sql = "insert into cal (num1, op, num2, result ) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num1);
			ps.setString(2, op);
			ps.setInt(3, num2);
			ps.setInt(4, result);
			insertResult = ps.executeUpdate();
			if (insertResult == 1) {
				con.commit();
				finish = "ok";
			}
		} catch (Exception e) {
			out.println(e);
		} finally {
			ps.close();
			DBConn.closeCon();
		}
		HashMap hm = new HashMap();
		hm.put("finish", finish);
		hm.put("result", result);
		String json = new Gson().toJson(hm);

		out.write(json);

	} else if (command.equals("select")) {
		List list = null;
		String calnum = j.get("calnum").toString();

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "SELECT calnum, num1, op, num2, result FROM cal";
			if (!calnum.equals("all")) {
				sql += " WHERE calnum = ?";
			}
			ps = con.prepareStatement(sql);
			if (!calnum.equals("all")) {
				ps.setInt(1, Integer.parseInt(calnum));
			}
			ResultSet rs = ps.executeQuery();
			list = new ArrayList();
			while (rs.next()) {
				HashMap hm = new HashMap();
				hm.put("calnum", rs.getInt("calnum"));
				hm.put("num1", rs.getInt("num1"));
				hm.put("op", rs.getString("op"));
				hm.put("num2", rs.getInt("num2"));
				hm.put("result", rs.getInt("result"));
				list.add(hm);
			}
			finish = "ok";
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