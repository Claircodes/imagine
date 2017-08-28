<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<title>Main</title>
</head>
<script>
$(document).ready(function(){
	$("input[type='button']").click(function(){
		var url = this.getAttribute("data-url");
		if(url){
			location.href=url;
		}
	})
})
</script>
<body>
환영.<br>
<input type="button" value="유저리스트 이동" data-url="${pageContext.request.contextPath}/user/list">
</body>
</html>