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

	</select>
	<input type="text" id="gnum" />
	<input type="button" id="gbtn" value="버튼" />
</body>
<script>
var thispage=0;
var totalPageCnt=0;
var blockCnt=0;
function callback(results){
	var vendorList = results.vendorList;
	var goodsList = results.goodsList;
	var pageInfo = results.pageInfo;

	blockCnt = new Number(pageInfo.blockCnt);
	var np = new Number(pageInfo.nowPage);    	
	var startnp = (Math.floor((np-1)/blockCnt))*10 +1;
	var endnp = startnp+blockCnt-1;
	totalPageCnt = new Number(pageInfo.totalPageCnt);
	
	var nowBlock = (Math.floor((np-1)/blockCnt));
	var endBlock = (Math.floor((totalPageCnt-1)/blockCnt));
	
	if(endnp>totalPageCnt){
		endnp = totalPageCnt;
	}
	
	makePageStr(startnp,endnp,pageInfo.nowPage,nowBlock,endBlock,"page");
	$("#s_vendor").html("<option value='선택'>회사선택</option>");	
	for(var i=0, max=vendorList.length;i<max;i++){
		$("#s_vendor").append("<option value='" + vendorList[i].vinum + "'>"+vendorList[i].viname +"</option>")
		}  
	$('#table').bootstrapTable('destroy');
    $('#table').bootstrapTable({
        data: goodsList
    }); 
    thispage=np;
    setEvent();
}
$(document).ready(function(){
	var params = {};
	params["nowPage"] = "1";
	goPage(params, "/test/car_ok.jsp", callback);
});
function setEvent(){
	$("ul[class='pagination']>li>a").click(function(){
		var params = {};
		var num=this.innerHTML;
			if (num=="◀◀"){
				params["nowPage"]="1";
			}else if (num=="◀"){
				params["nowPage"]=(thispage-1)+"";
			}else if(num=="▶"){
				params["nowPage"]=(thispage+1)+"";
			}else if(num=="▶▶"){
				params["nowPage"]=totalPageCnt+"";
			}else {
				params["nowPage"]=num;
			}
		goPage(params, "/test/car_ok.jsp", callback);
	})
}

</script>
</html>