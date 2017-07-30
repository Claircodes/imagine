<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%
    boolean login = Boolean.parseBoolean(request.getParameter("login"));
    String loginStr = "로그인";
    if(login){
    	loginStr ="로그아웃";
    }
    String m ="";
    if (request.getParameter("menu")!=null){
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
          <a  class="navbar-brand" href="/main.jsp">HOME</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li id="m1"> <a href= "/board/board_main.jsp">게시판가기</a></li>
            <li id="m2"><a href="/user/user_info.jsp" >유저정보가기</a></li>
            <li id="m3"><a href="/role/role_select.jsp" >권한정보가기</a></li>
            <li id="m4"><a href="/user/logout_ok.jsp" ><%=loginStr%></a></li>
          </ul>

        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <script>
    var m = "<%=m%>";
    if (m!=""){
    	document.getElementById(m).className ="active";
    }
    </script>
