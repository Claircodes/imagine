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
	<div id="s_vendor">
	</div>
	<input type="text" id="gnum" />
	<input type="button" id="gbtn" value="버튼" />
</body>
<script>
$(document).ready(
	function() {
	var str = "";
		$.ajax({
			type : "POST",
			url : "/test/vendor_option_ok.jsp",
			dataType : "json",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept","application/json");
				xhr.setRequestHeader("Content-Type","application/json");
			},
			data : null,
			success : function(results) {
				
				for (var i = 0, max = results.length; i < max; i++) {
					var result = results[i];
					if(i==0){
					str += "<label><input type='radio' name='company' value='" + result.vinum + "' checked />" + result.viname + "</label>";
					}else{
						str +="<label><input type='radio' name='company' value='" + result.vinum + "' />" + result.viname + "</label>";
					}
				}
				$("#s_vendor").append(str);
			},
			error : function(xhr, status, e) {
				alert("에러 : " + e);
			},
			done : function(e) {
			}
		});
	});

	$("#gbtn").click(function() {
		var ginum = $("#gnum").val();
		
		var opVinum = $(":input:radio[name=company]:checked").val();
		var param = {};
		var allOrOne = "one";
		if (ginum == "" || ginum == null || opVinum == "선택") {
			allOrOne = "all";
		}
		param["ginum"] = ginum;
		param["opVinum"] = opVinum;
		param["command"] = "car_select";
		param["allOrOne"] = allOrOne;

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
			success : function(result) {
				$('#table').bootstrapTable('destroy');
				$('#table').bootstrapTable({
					data : result
				});
			},
			error : function(xhr, status, e) {
				alert("에러 : " + e);
			},
			done : function(e) {
			}
		};
		$.ajax(btn);
	});
</script>
</html>