<%@page import="com.test.dto.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>차차차차차!</title>
</head>
<body>
	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="giNum" class="text-center">상품번호</th>
					<th data-field="giName" class="text-center">상품이름</th>
					<th data-field="giDesc" class="text-center">형태</th>
					<th data-field="viNum" class="text-center">회사넘버</th>
					<th data-field="viName" class="text-center">회사이름</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
	</div>
	<div class="jb-center" style="text-align: center">
		<ul class="pagination" id="page">
		</ul>
	</div>
	<select id="s_vendor">

	</select>
	<input type="text" id="gnum" />
	<input type="button" id="gbtn" value="버튼" />
</body>
<script>
var thisBlockCnt = 0;
var thisNowPage = 0;
var thisTotalPage = 0;
function callback(results){
	var goodsList = results;
    $('#table').bootstrapTable('destroy');
    $('#table').bootstrapTable({
        data: goodsList
    });
}
$(document).ready(function(){
	var page = {};
	page["nowPage"] = "1";
	var params = {};
	params["page"] = page;
	params["command"] = "list";
	
	goPage(params, "/list.goods", callback);
});
function setEvent(p){
	$("ul[class='pagination']>li>a").click(function(){
		var params = {};
		var page= {};
		var num=this.innerHTML;
			if (num=="◀◀"){
				page["nowPage"]="1";
			}else if (num=="◀"){
				page["nowPage"]=(thispage-1)+"";
			}else if(num=="▶"){
				page["nowPage"]=(thispage+1)+"";
			}else if(num=="▶▶"){
				page["nowPage"]=totalPageCnt+"";
			}else {
				page["nowPage"]=num;
			}
			params["page"] = page;
			params["command"]= "list";
			
		goPage(params, "/list.goods", callback);
	})
}

</script>
</html>