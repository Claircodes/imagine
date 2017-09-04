<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ui/signin.css" />
</head>
<body>
	<div class="container">
		<form class="form-signin" action="${pageContext.request.contextPath}/user/login_ok.jsp">
			<h2 class="form-signin-heading">Please login</h2>
			<label for="inputEmail" class="sr-only">ID</label> 
			<input type="text" id="id" name="id" class="form-control" placeholder="ID" required	autofocus> 
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" name="pwd" id="pwd" class="form-control"	placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button id="btn2" class="btn btn-lg btn-primary btn-block" type="button">Login</button>
		</form>
	</div>
	
<script>
	$("#btn2").click(function(){
		var paramIds = "userId,userPwd";
		var au = new AjaxUtil("/user/login",paramIds);
		au.setCallbackSuccess(test);
		au.send();
	});
</script>
</body>
</html>