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
<script>
function doLogout() {
	location.href="/user/login_ok.jsp";
}
function goBoard() {
	location.href="/board/board_main.jsp";
}
</script>
<body>
<%
String userId = (String) session.getAttribute("userid");
if(userId!=null){
	String userName =  (String) session.getAttribute("username");
	int age =  (int) session.getAttribute("age");
	String address =  (String) session.getAttribute("address");
	String hp1 =  (String) session.getAttribute("hp1");
	String hp2 =  (String) session.getAttribute("hp2");
	String hp3 =  (String) session.getAttribute("hp3");
	out.println(userId + "님 환영해요~");
	out.println("<input type='button' value='로그아웃' onclick='doLogout()'/>");
	out.println("<br/>");
	out.println("<br/>");
	out.println("<input type='button' value='게시판으로 가기' onclick='goBoard()'/>");
}else{
	
	%>

	<form action="/user/login_ok.jsp">
	ID : <input type="text" name="id"/><br/>
	PWD : <input type="text" name="pwd"/><br/>
	<input type="submit" value="로그인!!"/>
	</form>
	<%
	}
	%>
	</body>
	</html>