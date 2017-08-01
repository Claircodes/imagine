<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<body>
	<div class="container">
		<div class="starter-template">
			<table border="1" class='table table-bordered table-hover'>
				<tr>
					<td>이름 :</td>
					<td><%=userName%></td>
				</tr>
				<tr>
					<td>나이 :</td>
					<td><%=age%></td>
				</tr>
				<tr>
					<td>주소 :</td>
					<td><%=address%></td>
				</tr>
				<tr>
					<td>핸폰번호 :</td>
					<td><%=hp1%>-<%=hp2%>-<%=hp3%></td>
				</tr>
			</table>

		</div>
	</div>
			<%@ include file="/common/bottom.jsp"%>