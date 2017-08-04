<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>차차차회사</title>
</head>
<body>
	<div class="container">
		<table id="table" data-height="460" class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="vinum"  class="text-center">숫자</th>
					<th data-field="jttext"  class="text-center">텍스트</th>
					<th data-field="jttext"  class="text-center">텍스트</th>
					<th data-field="jttext"  class="text-center">텍스트</th>
					<th data-field="jttext"  class="text-center">텍스트</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
	</div>
<input type="text" id="vnum"/>
<input type="button" id="vbtn1" value="검색"/>
<br/>
<input type="text" id="viname"/>
<input type="text" id="videsc"/>
<input type="text" id="viaddress"/>
<input type="text" id="viphone"/>
<input type="button" id="vbtn2" value="추가"/>

<script>
$("#vbtn2").click(function(){
	var viname = $("#viname").val();
	var videsc = $("#videsc").val();
	var viaddress = $("#viaddress").val();
	var viphone = $("viphone").val();
	var param = {};
		
	param["viname"] = vinum;
	param["videsc"] = videsc;
	param["viaddress"] = viaddress;
	param["viphone"] = viphone;
	param["command"] = "vinsert";
	
	param = JSON.stringify(param);
	var btn = {
		type: "POST"
	,	url: "/test/car_ok.jsp"
	,	dataType: "json" 
	,	beforeSend: function(xhr) {
		xhr.setRequestHeader("Accept", "application/json");
		xhr.setRequestHeader("Content-Type", "application/json");
	}
	,	data: param
	,	success: function(result){	
		if(result.finish=="ok"){
			alert("저장 완료");
		}else{
			alert(result.finish);
		}
		}
	,	error: function(xhr, status, e) {
			alert("에러 : "+e);
		}
	,	done: function(e) {
		}
	};
	$.ajax(btn);
});
</script>
</body>
</html>