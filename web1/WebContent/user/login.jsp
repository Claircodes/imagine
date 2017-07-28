<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import=" com.test.dto.UserInfo"%>
<%@ page import=" com.test.common.DBConn"%>
<link rel="stylesheet" href="<%=rootPath%>/ui/signin.css" />
<body>
	<jsp:include page="/common/top.jsp" flush="fasle">
		<jsp:param value="<%=login%>" name="login" />
	</jsp:include>
	<div class="container">
		<div class="starter-template">
			<form class="form-signin" action="<%=rootPath%>/user/login_ok.jsp">
				<h2 class="form-signin-heading">로그인해주세요</h2>
				<label for="inputEmail" class="sr-only">Email address</label> 
				<input	type="text" id="id" name="id" class="form-control" placeholder="ID" required autofocus /> 
				<label for="inputPassword" class="sr-only">Password</label>
				<input type="password" id="pwd" name="pwd" class="form-control" placeholder="PASSWORD" required />
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me">remember	me</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" id="btn2" type="submit">Login</button>
			</form>
		</div>
	</div><!--  /container -->

	<script>

	</script>
</body>

</html>