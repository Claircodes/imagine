<%@page import="com.test.dto.BoardInfo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.test.common.DBConn"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ include file = "/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
out.println(userId + "님 ");
out.println("<input type='button' value='로그아웃' onclick='doLogout()'/>");
out.println("<input type='button' value='로그인메인화면으로 돌아가기' onclick='doBackLogin()'/>");
BoardInfo bi = new BoardInfo();
String binum =request.getParameter("binum");
Connection con = null;
PreparedStatement ps = null;
try {
	con = DBConn.getCon();
	String sql = "SELECT binum,bititle,bicontent,bipwd,creusr,credat FROM board_info where binum=?";
	ps = con.prepareStatement(sql);
	ps.setInt(1, Integer.parseInt(binum));
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
		bi.setBinum(rs.getInt("binum"));
		bi.setBititle(rs.getString("bititle"));
		bi.setBicontent(rs.getString("bicontent"));
		bi.setBipwd(rs.getString("bipwd"));
		bi.setCreusr(rs.getString("creusr"));
		bi.setDatetime(rs.getDate("credat").toString());
	}

} catch (Exception e) {
	System.out.println(e);
}
String tableStr = "<table border='1'>";
tableStr += "<tr><td>아이디 : </td><td>"+bi.getCreusr()+"</td></tr>";
tableStr += "<tr><td>제목 : </td><td>"+bi.getBititle()+"</td></tr>";
tableStr += "<tr><td colspan='2'>내용 : </td></tr>";
tableStr += "<tr><td colspan='2'>"+bi.getBicontent()+"</td></tr>";
tableStr += "</table>";
tableStr += "<input type='button' value='목록으로' onclick='doMovePage(\"board\")'/>";
out.println(tableStr);

if (bi.getClass().equals(userId)){
	out.println("<input type='button' value='삭제' onclick='doDelete()' />");
	out.println("<input type='button' value='수정' onclick='doUpdate()' />");
}

%>
<script>
function doDelete() {
	alert("삭제");
}
function doUpdate(){
	alert("수정");
}
</script>
</body>
</html>