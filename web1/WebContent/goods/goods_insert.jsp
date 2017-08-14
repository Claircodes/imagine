<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<%
	String nowPage = request.getParameter("nowPage");
%>
	<div class="container" style="text-align: center; padding-top:100px;padding-bottom:100px;">
	<table id="table" data-height="400"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th colspan="2" class="text-center"><h5 class="form-signin-heading">상품상세 페이지</h5></th>
			</tr>
			<tr>
				<td>상품이름</td>
				<td><input id="giName" type="text" /></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td><input id="giDesc" type="text" /></td>
			</tr>
			<tr>
				<td>생산회사</td>
				<td>		
					<select id="s_vendor" class="selectpicker"></select> 
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="btnInsert" class="btn btn-lg btn-primary btn-block"	type="button">등록</button>
					<button id="btnCancle" class="btn btn-lg btn-primary btn-block" type="button">취소</button>
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
	
	$("#btnInsert").click(function(){
		var params = {};
		params["giName"] = $("#giName").val();
		params["giDesc"] = $("#giDesc").val();
		params["viNum"] = $("option:selected").val();
		params["command"] = "insert";
		var page = {};
		page["nowPage"] = "<%=nowPage%>";
		params["page"] = page;
		movePageWithAjax(params, "/list.goods", callBackInsert);
	});

	function callBackInsert(result) {
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

			selStr += "<option value='" + vendor.viNum + "' " + selectStr + ">" + vendor.viName
					+ "</option>";
		
		$("#s_vendor").html(selStr);}
	}
</script>
</body>
</html>