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
					<th data-field="vname" class="text-center">차회사</th>
					<th data-field="cname" class="text-center">차이름</th>
					<th data-field="desc" class="text-center">소중대</th>
					<th data-field="credat" class="text-center">날짜</th>
					<th data-field="cretim" class="text-center">시간</th>
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
		<option value="선택">회사선택</option>
	</select>
	<input type="text" id="gnum" />
	<input type="button" id="gbtn" value="버튼" />
</body>
<script>
$(document).ready(function() {
	var str = "";
	var params={};
	params["nowPage"]="1";
	params = JSON.stringify(params);
		$.ajax({
			type : "POST",
			url : "/test/car_ok.jsp",
			dataType : "json",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept","application/json");
				xhr.setRequestHeader("Content-Type","application/json");
			},
			data : params,
			success : function(results) {
		    	var vendorList = results.vendorList;
		    	var goodsList = results.goodsList;
		    	var pageInfo = results.pageinfo;
		    	
		    	var pageStr ="<li><a>◀◀</a></li>";
		    	pageStr +="<li><a>◀</a></li>";
		    	var blockCnt = new Number(pageInfo.blockCnt);
		    	var np = new Number(pageInfo.nowPage);    	
		    	var startnp = (Math.floor((np-1)/blockCnt))*10 +1;
		    	var endBlock = startnp+blockCnt-1;
		    	var totalPageCnt = new Number(pageInfo.totalPageCnt);
		    	if(endBlock>totalPageCnt){
		    		endBlock = totalPageCnt;
		    	}
		    	for (var i=startnp; i<=endBlock; i++){
		    		if (i==pageInfo.nowPage){
		    			pageStr += "<li class='active'><a id='pn"+i+"' >"+i+"</a></li>";
		    		}else {
		    			pageStr += "<li ><a id='pn"+i+"'>"+i+"</a></li>";		
		    		}
		    	}
		    	pageStr +="<li><a>▶</a></li>";
		    	pageStr +="<li><a>▶▶</a></li>";
		    	
		    	$("#page").html(pageStr);
		    	for(var i=0, max=vendorList.length;i<max;i++){
		    		$("#s_vendor").append("<option value='" + vendorList[i].vinum + "'>"+vendorList[i].viname +"</option>")
		    	}
		        $('#table').bootstrapTable({
		            data: goodsList
		        });
			},
			error : function(xhr, status, e) {
				alert("에러 : " + e);
			},
			complete  : function() {
			}
		});
	});

$("#page").click(function(){

	alert( $("#page").children().val());
});


	$("#gbtn").click(function() {
		var ginum = $("#gnum").val();
		var opVinum = $("#s_vendor option:selected").val();
		alert(opVinum);
		var param = {};

		if (opVinum==null){
			opVinum="선택";
		}
		param["ginum"] = ginum;
		param["opVinum"] = opVinum;

		param = JSON.stringify(param);
		var btn = {
			type : "POST",
			url : "/test/car_ok.jsp",
			dataType : "json",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			data : param,
			success : function(results) {
				$('#table').bootstrapTable('destroy');
		    	var goodsList = results.goodsList;

		        $('#table').bootstrapTable({
		            data: goodsList
		        });
			},
			error : function(xhr, status, e) {
				alert("에러 : " + e);
			},
			complete  : function() {
			}
		};
		$.ajax(btn);
	});
</script>
</html>