<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import=" com.test.dto.UserInfo"%>
<%@ page import=" com.test.common.DBConn"%>
<link rel="stylesheet" href="<%=rootPath%>/ui/signin.css" />
<body>
	<jsp:include page="/common/top.jsp" flush="fasle"></jsp:include>
	<div class="container">
		<div class="starter-template">
			<form class="form-signin" action="<%=rootPath%>/user/login_ok.jsp">
				<h2 class="form-signin-heading">로그인해주세요</h2>
				<label for="inputEmail" class="sr-only">Email address</label> 
				<input	type="text" id="id" name="id" class="form-control"	placeholder="아이디" required autofocus /> 
				<label for="inputPassword" 	class="sr-only">Password</label> 
				<input type="password" id="pwd"	name="pwd" class="form-control" placeholder="비밀번호" required />
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me">기억하자
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
			</form>
		</div>
	</div>
</body>

</html>