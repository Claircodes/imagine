
<%@ include file = "/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import=" com.test.dto.UserInfo"%>
<%@ page import=" com.test.common.DBConn"%>

<body>
<%

if(userId!=null){
	out.println("현재시간: "+toDaStr);
	out.println("<br/>");
	out.println( userId + "님 환영해요~");
	out.println("<input type='button' value='로그아웃' onclick='doMovePage(\"logout\")'/>");
	out.println("<br/>");
	out.println("<br/>");
	out.println("<input type='button' value='게시판 가기' onclick='doMovePage(\"board\")'/>");

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