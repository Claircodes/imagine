<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>


<div class="container">
	<div class="container" style="text-align: center; padding-top: 20px; padding-bottom: 20px;">
		<select id="s_vendor" class="selectpicker">
			<option value="all" selected="selected">[검색]</option>
			<option value="viNum">번호</option>
			<option value="viName">이름</option>
			<option value="viDesc">정보</option>
			<option value="viAddress">주소</option>
			<option value="viPhone">전번</option>
		</select>
		<input type="text" id="search" /> 
		<input type="button" id="searchBtn" value="검색" /> 
		<table id="table" data-height="460"	class="table table-bordered table-hover">
			<tbody id="result_tbody"></tbody>
		</table>
		<input type="button" id="vendorInsert" value="회사 등록"/>
		<div class="jb-center" style="text-align: center">
			<ul class="pagination" id="page">
			</ul>
		</div>
	</div>
</div>
<script>
var pageInfo = {};
var nowPage = "<%=request.getParameter("nowPage")%>";

	if (nowPage == "null") {
		nowPage = "1";
	}
function callback(results) {
	var vendorList = results.list;
	pageInfo = results.page;
	var params = {};

	makePagination(pageInfo, "page");
	setEvent(pageInfo, params, "/list.vendor");
	$('#table').bootstrapTable('destroy');
	
	var resultStr = "";
	resultStr += "<tr>";
	resultStr += "<td class='text-center'>회사번호</td>";
	resultStr += "<td class='text-center'>회사이름</td>";
	resultStr += "<td class='text-center'>회사정보</td>";
	resultStr += "<td class='text-center'>회사주소</td>";
	resultStr += "<td class='text-center'>회사번호</td>";
	resultStr += "</tr>";
	for (var i = 0, max = vendorList.length; i < max; i++) {
		var vendor = vendorList[i];

		resultStr += "<tr data-view='"+vendor.viNum+"'>";
		resultStr += "<td class='text-center'>" + vendor.viNum + "</td>";
		resultStr += "<td class='text-center'>" + vendor.viName + "</td>";
		resultStr += "<td class='text-center'>" + vendor.viDesc + "</td>";
		resultStr += "<td class='text-center'>" + vendor.viAddress + "</td>";
		resultStr += "<td class='text-center'>" + vendor.viPhone + "</td>";
		resultStr += "</tr>";

	}
	$("#result_tbody").html(resultStr);
	$("tbody[id='result_tbody']>tr[data-view]").click(function() {

		var params = {};
		params["viNum"] = this.getAttribute("data-view");
		params["command"] = "view";
		var page = {};
		page["nowPage"] = pageInfo.nowPage;
		params["page"] = page;
		movePageWithAjax(params, "list.vendor", callBackView);
	})
}
function callBackView(result) {
	var url = "vendor_view.jsp?nowPage=" + result.page.nowPage + "&viNum=" + result.vendor.viNum + "&viName=" + result.vendor.viName + "&viDesc=" + result.vendor.viDesc + "&viAddress="	+ result.vendor.viAddress + "&viPhone=" + result.vendor.viPhone;
	location.href = url;
}
var op = "all";
$("#s_vendor").change(function() {
	op= $("option:selected").val();
});
$("#searchBtn").click(function() {
	location.href = "/goods/vendor_list.jsp?nowPage="+"<%="nowPage"%>"+"?searchOpj="+""+"?searchtxt="+"$";
});
$("#vendorInsert").click(function() {
	location.href = "/goods/vendor_insert.jsp";
});
$(document).ready(function() {
	var page = {};
	page["nowPage"] = nowPage;
	var params = {};
	if (<%=request.getParameter("searchOpj")%>!="all"){
		params["searchOpj"] = page;
		params["searchtxt"] = page;
	}
	params["page"] = page;
	params["command"] = "list";
	movePageWithAjax(params, "/list.vendor", callback);
});
</script>
</body>
</html>