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
	<table id="table" data-height="400"	class="table table-bordered table-hover">
		<thead>
			<tr>
				<th colspan="2" class="text-center"><h5 class="form-signin-heading">회사등록 페이지</h5></th>
			</tr>
			<tr>
				<td>회사이름</td>
				<td><input id="viName" type="text" /></td>
			</tr>
			<tr>
				<td>회사설명</td>
				<td><input id="viDesc" type="text" /></td>
			</tr>
			<tr>
				<td>회사주소</td>
				<td><input id="viAddress" type="text" /></td>
			</tr>
			<tr>
				<td>회사전화번호</td>		
				<td><input id="viPhone" type="text" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="vendorInsert" class="btn btn-lg btn-primary btn-block"	type="button">등록</button>
					<button id="vendorCancle" class="btn btn-lg btn-primary btn-block" type="button">취소</button>
				</td>
			</tr>
	</table>
</div>
<!-- /container -->

<script>


	$(document).ready(function(){
	})
	
	$("#vendorInsert").click(function(){
		var params = {};
		params["command"] = "insert";
		
		params["viName"] = $("#viName").val();
		params["viDesc"] = $("#viDesc").val();
		params["viAddress"] = $("#viAddress").val();
		params["viPhone"] = $("#viPhone").val();

		movePageWithAjax(params, "/list.vendor", callBackInsert);
	});
	$("#vendorCancle").click(function(){
		location.href="/goods/vendor_list.jsp?nowPage=<%=nowPage%>";
	});
	function callBackInsert(result) {
		alert(result.msg);
		if (result.url != "") {
			location.href = result.url;
		}
	}

</script>
</body>
</html>