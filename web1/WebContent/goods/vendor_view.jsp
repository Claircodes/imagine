<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<%
	String nowPage = request.getParameter("nowPage");
%>

<div class="container"
	style="text-align: center; padding-top: 100px; padding-bottom: 100px;">
	<table id="table" data-height="400"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th colspan="2" class="text-center"><h5
						class="form-signin-heading">상품상세 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">회사번호</td>
				<td class="col-md-4" colspan="2"><%=request.getParameter("viNum")%></td>
			<tr>
				<td>회사이름</td>
				<td colspan="2"><%=request.getParameter("viName")%></td>
			</tr>
			<tr>
				<td>회사설명</td>
				<td colspan="2"><%=request.getParameter("viDesc")%></td>
			</tr>
			<tr>
				<td>회사주소</td>
				<td colspan="2"><%=request.getParameter("viAddress")%></td>
			</tr>

			<tr>
				<td colspan="2">
					<button id="btnUpdate" class="btn btn-lg btn-primary btn-block"	type="button">수정</button>
					<button id="btnDelete" class="btn btn-lg btn-primary btn-block"	type="button">삭제</button>
					<button id="btnGoList" class="btn btn-lg btn-primary btn-block"	type="button">리스트 이동</button>
				</td>
			</tr>
	</table>
</div>
<!-- /container -->
<script>
$("#btnUpdate").click(function(){
	var isUpdate = confirm("해당게시물을 수정하시겠습니까?");
	if(isUpdate){
		var params={};	
	}
});
$("#btnDelete").click(function(){
	location.href = "";
});
$("#btnGoList").click(function(){
	location.href = "/goods/vendor_list.jsp?nowPage="+"<%=nowPage%>";
});

</script>
</body>
</html>