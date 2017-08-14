<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<%
String nowPage = request.getParameter("nowPage");
String giNum = request.getParameter("giNum");
String giName = request.getParameter("giName");
String giDesc = request.getParameter("giDesc");
String viNum = request.getParameter("viNum");
String viName = request.getParameter("viName");
%>


<div class="container-view">
	<table id="table" data-height="460"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th colspan="2" class="text-center"><h5
						class="form-signin-heading">상품상세 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">상품번호</td>
				<td class="col-md-4" colspan="2"><%=request.getParameter("giNum")%></td>
			<tr>
				<td>상품이름</td>
				<td colspan="2"><%=request.getParameter("giName")%></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td colspan="2"><%=request.getParameter("giDesc")%></td>
			</tr>
			<tr>
				<td>회사번호</td>
				<td colspan="2"><%=request.getParameter("viNum")%></td>
			</tr>
			<tr>
				<td>회사이름</td>
				<td colspan="2"><%=request.getParameter("viName")%></td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="btnUpdate" class="btn btn-lg btn-primary btn-block"
						type="button">수정</button>
					<button id="btnDelete" class="btn btn-lg btn-primary btn-block"
						type="button">삭제</button>
					<button id="btnGoList" class="btn btn-lg btn-primary btn-block"
						type="button">리스트 이동</button>
				</td>
			</tr>
	</table>
</div>
<!-- /container -->
<script>
$("#btnUpdate").click(function(){
	location.href="/goods/goods_update.jsp?nowPage="+"<%=nowPage%>"+"&giNum=" + "<%=giNum%>"+ "&giName="+"<%=giName%>"+"&giDesc="+"<%=giDesc%>"+"&viNum="+"<%=viNum%>"+"&viName="+"<%=viName%>";
});

$("#btnDelete").click(function(){
	var isDelete = confirm("해당 상품을 삭제 하시겠습니까?");
	if(isDelete){
		var params = {};
		params["giNum"] = "<%=request.getParameter("giNum")%>";
		params["command"] = "delete";
		var page = {};
		page["nowPage"] = "<%=request.getParameter("nowPage")%>";
			params["page"] = page;
			movePageWithAjax(params, "/list.goods", callBackView);
		}
	});

	$("#btnGoList").click(
			function() {
				location.href = "/goods/goods_list.jsp?nowPage="+<%=request.getParameter("nowPage")%>;
			});

	function callBackView(result) {
		alert(result.msg);
		if (result.url != "") {
			location.href = result.url + "?nowPage=" + result.page.nowPage;
		}
	}
</script>
</body>
</html>