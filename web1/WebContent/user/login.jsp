<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import=" com.test.dto.UserInfo"%>
<%@ page import=" com.test.common.DBConn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id!=null&&pwd!=null){
			
		}
		
		UserInfo ui = new UserInfo();
		ui.setUserId(id);
		ui.setUserPwd(pwd);
		
		Connection con = null;
		PreparedStatement ps = null;
		String result = "";
		try {
			con = DBConn.getCon();
			String sql = "select userpwd from user_info WHERE userid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUserId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String upwd = rs.getString("userpwd");
				if (upwd.equals(ui.getUserPwd())) {
					result = "로그인 성공";
				}
				result = "로그인 실패";
			}
			out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>


	<form action="/user/login.jsp">
		ID : <input type="text" name="id" value="" /> <br /> PWD : <input
			type="text" name="pwd" value="" /> <br /> <input type="submit"
			value="로그인" />
	</form>
</body>
</html>