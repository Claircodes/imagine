<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	boolean login1 = Boolean.parseBoolean(request.getParameter("login1"));
	String loginStr = "로그인";
	String m = "";
	if (request.getParameter("menu") != null) {
		m = request.getParameter("menu");
	}
%>

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
				<li id="m1"><a href="/board/board_main.jsp">게시판</a></li>
				<li id="m2"><a href="/board/NewFile.jsp">빈페이지</a></li>
			</ul>
				<% 	if (login1) {
		loginStr = (String) session.getAttribute("userid"); %>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"	data-toggle="dropdown" role="button" aria-expanded="false"><%=loginStr%>님
					<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/user/user_info.jsp">유저정보</a></li>
						<li><a href="/role/role_select.jsp">권한정보</a></li>
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
    var m = "<%=m%>";
	if (m != "") {
		document.getElementById(m).className = "active";
	}
</script>
