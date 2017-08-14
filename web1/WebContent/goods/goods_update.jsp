<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<%
int giNum = Integer.parseInt(request.getParameter("giNum"));
String nowPage = request.getParameter("nowPage");
%>
	<div class="container-view"> 
		<table id="table"  data-height="460"	class="table table-bordered table-hover">
		<thead>
			<tr> 
				<th colspan="2" class="text-center"><h5 class="form-signin-heading">상품상세 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">상품번호</td>
				<td class="col-md-4"><%=giNum%></td>
			<tr>
				<td>상품이름</td>
				<td><input id="giName" type="text" value=<%=request.getParameter("giName") %> /></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td><input id="giDesc" type="text" value=<%=request.getParameter("giDesc") %> /></td>
			</tr>
			<tr>
				<td>생산자번호</td>
				<td><select id="s_vendor" class="selectpicker"></select> </td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="btnUpdate" class="btn btn-lg btn-primary btn-block" 	type="button">수정 완료</button>
					<button id="btnCancle" class="btn btn-lg btn-primary btn-block" 	type="button">취소</button>
				</td>
			</tr>
		</table>
	</div>
	<!-- /container -->

<script>
	$(document).ready(function(){
		var params = {};
		params["command"] = "vendorList";
		movePageWithAjax(params, "/list.goods", callBack);
	})
	
	$("#btnUpdate").click(function(){
		var params = {};
		params["giNum"] ="<%=giNum%>";
		params["giName"] = $("#giName").val();
		params["giDesc"] = $("#giDesc").val();
		params["viNum"] = $("#viNum").val();
		
		params["command"] = "update";
		var page = {};
		page["nowPage"] = "<%=nowPage%>";
		params["page"] = page;
		movePageWithAjax(params, "/list.goods", callBackUpdate);
	});

	function callBackUpdate(result) {
		alert(result.msg);
		if (result.url != "") {
			location.href = result.url + "?nowPage=" + result.page.nowPage;
		}
	}
	function callBack(results) {
		var selStr = "<option value=''>회사선택</option>";
		for (var i = 0, max = results.length; i < max; i++) {
			var vendor = results[i];
			var selectStr = "";
			if($("option:selected").val("<%=request.getParameter("viNum")%>"")){
				selectStr = "selected";
			}
			<%=request.getParameter("giDesc") %> 
			selStr += "<option value='" + vendor.viNum + "' " + selectStr + ">" + vendor.viName
					+ "</option>";
		
		$("#s_vendor").html(selStr);}
	}
</script>
</body>
</html>