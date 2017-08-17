<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<div class="container">
	<div class="container"
		style="text-align: center; padding-top: 20px; padding-bottom: 20px;">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<tbody id="result_tbody">
				<tr>
					<td class='text-center'>회사번호</td>
					<td class='text-center'><%=request.getParameter("viNum")%></td>
				</tr>
				<tr>
					<td class='text-center'>회사이름</td>
					<td class='text-center'><input id='viName' type='text' /></td>
				</tr>
				<tr>
					<td class='text-center'>회사정보</td>
					<td class='text-center'><input id='viDesc' type='text' /></td>
				</tr>
				<tr>
					<td class='text-center'>회사주소</td>
					<td class='text-center'><input id='viAddress' type='text' /></td>
				</tr>
				<tr>
					<td class='text-center'>회사번호</td>
					<td class='text-center'><input id='viPhone' type='text' /></td>
				</tr>
			</tbody>
		</table>
		<input type="button" id="vendorUpdate" value="수정 완료" /> <input
			type="button" id="vendorCancel" value="취소" />
	</div>
</div>
<script>
$(document).ready(function() {
	var page = {};
	page["nowPage"] = "<%=request.getParameter("nowPage")%>";
	var params = {};
	params["viNum"] = "<%=request.getParameter("viNum")%>";
	params["page"] = page;
	params["command"] = "view";
	movePageWithAjax(params, "/list.vendor", callback);
});

$("#vendorUpdate").click(function(){
	var params = {};
	params["viNum"] ="<%=request.getParameter("viNum")%>";
	params["viName"] = $("#viName").val();
	params["viDesc"] = $("#viDesc").val();
	params["viAddress"] = $("#viAddress").val();
	params["viPhone"] = $("#viPhone").val();
	params["command"] = "update";
	
	var page = {};
	page["nowPage"] = "<%=request.getParameter("nowPage")%>";
		params["page"] = page;
		movePageWithAjax(params, "/list.vendor", callBackUpdate);
	});
	function callBackUpdate(result) {
		alert(result.msg);
		if (result.url != "") {
			location.href = result.url + "?nowPage=" + result.page.nowPage;
		}
	}
	$("#vendorCancel").click(function() {
		location.href = result.url + "?nowPage=" + result.page.nowPage;
	});
	function callback(result) {
		$("#viName").val(result.vendor.viName);
		$("#viDesc").val(result.vendor.viDesc);
		$("#viAddress").val(result.vendor.viAddress);
		$("#viPhone").val(result.vendor.viPhone);
	}
</script>
</body>
</html>