<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<body>
	<jsp:include page="/common/top.jsp" flush="fasle">
		<jsp:param value="<%=login%>" name="login" />
		<jsp:param value="m3" name="menu" />
	</jsp:include>
	<div class="container">
		<div class="starter-template">
		권한 정보 입니다. 
		</div>
		</div>
</body>
</html>