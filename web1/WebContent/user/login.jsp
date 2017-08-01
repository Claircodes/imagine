<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import=" com.test.dto.UserInfo"%>
<%@ page import=" com.test.common.DBConn"%>
<link rel="stylesheet" href="<%=rootPath%>/ui/signin.css" />

<body>


	<div class="container">
		<div class="starter-template">
					<%if (!login){ 

	%>
			<form class="form-signin" action="<%=rootPath%>/user/login_ok.jsp">
				<h2 class="form-signin-heading">로그인해주세요</h2>
				<label for="inputEmail" class="sr-only">Email address</label> 
				<input	type="text" id="id" name="id" class="form-control" placeholder="ID" required autofocus /> 
				<label for="inputPassword" class="sr-only">Password</label>
				<input type="password" id="pwd" name="pwd" class="form-control" placeholder="PASSWORD" required />
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me">remember	me</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" id="btn2" type="button">Login</button>
			</form>
			<%
			}else {
				%>
				<script>
				location.href = "/main.jsp";
				</script>
				<%
			}
			%>
	
<script>
$("button.btn").click(function(){
	var id = $("#id").val();
	var pwd = $("#pwd").val();
	var param = {};
	param["id"] = id;
	param["pwd"] = pwd;
	param = JSON.stringify(param);
	$.ajax({ 
        type     : "POST"
    ,   url      : "/user/login_ok.jsp"
    ,   dataType : "json" 
    ,   beforeSend: function(xhr) {
        xhr.setRequestHeader("Accept", "application/json");
        xhr.setRequestHeader("Content-Type", "application/json");
    }
    ,   data     : param
    ,   success : function(result){
    	alert(result.msg);
    	if(result.login=="ok"){
    		location.href="/main.jsp"; 
    	}
    }
    ,   error : function(xhr, status, e) {
	    	alert("에러 : "+e);
	},
	done : function(e) {
	}
	});
});
</script>

		</div>
	</div>
			<%@ include file="/common/bottom.jsp"%>