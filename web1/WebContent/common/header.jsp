<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>홈페이지</title>
</head>
<%!public void printStr(String str) {
		System.out.println("ajlsjfdljf");
	}%>
<%
	String userId = (String) session.getAttribute("userid");
	String userName = "";
	int age = 0;
	String address = "";
	String hp1 = "";
	String hp2 = "";
	String hp3 = "";
	boolean login = false;


	if (userId != null) {
		userName = (String) session.getAttribute("username");
		age = (int) session.getAttribute("age");
		address = (String) session.getAttribute("address");
		hp1 = (String) session.getAttribute("hp1");
		hp2 = (String) session.getAttribute("hp2");
		hp3 = (String) session.getAttribute("hp3");
		login = true;
	}
	
	String rootPath = request.getContextPath();
	Date toDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	String toDaStr = sdf.format(toDate);
	String init = request.getParameter("init");
	String bn = (String) session.getAttribute("binum");
	String defaultUrl ="";
	if (init==null&&!login){
		defaultUrl = rootPath + "/user/login.jsp?init=1";
		response.sendRedirect(defaultUrl);
	}
	String nowUrl = request.getRequestURI();
	String version = "1.2";
	%>
<script src="<%=rootPath%>/js/jquery-3.2.1.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap.min.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap-table.js?version=<%=version%>"></script>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap-theme.min.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap.min.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap-table.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/common.css?version=<%=version%>"/>

<script>
var rootPath="<%=rootPath%>";
var init="<%=init%>";
$(document).ready(function(){
	var nowUrl = "<%=nowUrl%>";
	var obj = $("a[href='" + nowUrl + "']").parent().attr("class","active");
})
	function doMovePage(pageId) {
		var url = "";
		if (pageId == "board") {
			url = rootPath + "/board/board_main.jsp";
		} else if (pageId == "main") {
			url = rootPath + "/";
		} else if (pageId == "logout") {
			url = rootPath + "/user/login_ok.jsp?logout=1&";
		}else if(pageId=="insert"){
			url = rootPath + "/board/board_insert.jsp";
		}			
		location.href = url;
	}

</script>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span> 
			<span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/main.jsp">HOME</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li id="m1" ><a href="/board/board_main.jsp">게시판</a></li>
				<li id="m2" ><a href="/board/NewFile.jsp">빈페이지</a></li>
			</ul>
				<% 	if (login) {
					%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown" id="m3">
					<a href="#" class="dropdown-toggle"	data-toggle="dropdown" role="button" aria-expanded="false"><%=userId%>님
					<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li ><a href="/user/user_info.jsp" >유저정보</a></li>
						<li ><a href="/role/role_select.jsp" >권한정보</a></li>
						<li role="presentation" class="divider"></li>
						<li><a href="/user/logout_ok.jsp">로그아웃</a></li>
					</ul>
					<% 	}%>
					</li>
			</ul>
			
			
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>
<script>


</script>