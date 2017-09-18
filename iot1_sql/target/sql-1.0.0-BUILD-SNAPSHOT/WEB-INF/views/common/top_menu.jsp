<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
				<li id="m2" ><a href="/goods/goods_list.jsp">상품게시판</a></li>
				<li id="m3" ><a href="/goods/vendor_list.jsp">회사게시판</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown" id="m3">
					 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">정보 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li ><a href="/user/user_info.jsp" >유저정보</a></li>
						<li ><a href="/role/role_select.jsp" >권한정보</a></li>
						<li role="presentation" class="divider"></li>
						<li><a href="/user/logout_ok.jsp">로그아웃</a></li>
					</ul>
					</li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>