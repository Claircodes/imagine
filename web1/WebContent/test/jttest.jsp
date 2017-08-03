<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>테스트를 하거라</title>
</head>
<body>
	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="jtnum"  class="text-center">숫자</th>
					<th data-field="jttext"  class="text-center">텍스트</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
	</div>
<input type="text" id="num" name="num"/>
<input type="text" id="txt" name="txt"/>
<input type="button" id="jtbtn1" value = "추가를 하거라"/><br/>
<input type="text" id="jtnum" name="jtnum"/>
<input type="button" id="jtbtn2" value = "리스트를 보여주거라"/>
<script>
	$("input[id='jtbtn1']").click(function () {
		var command = "insert";
		var jn = $("#num").val();
		var jt = $("#txt").val();

		var param = {};
		param["jtnum"] = jn;
		param["jttext"] = jt;
		param["command"] = command;
		param = JSON.stringify(param);
		
		var btn = {
			type:"POST"
		,	url: "/test/jttest_ok.jsp"
		,	dataType:"json"
		,	beforeSend:function(xhr){
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		}
		,	data: param
		,	success: function(result){	
			if(result.finish=="ok"){
				alert("저장완료");
			}else{
				alert(result.finish);
			    $("input").focus();
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

	$("input[id='jtbtn2']").click(function(){
		var jtnum = $("#jtnum").val();
		var param = {};
		var command = "select";
		var allOrOne ="one";
		
		if (jtnum=="" || jtnum==null){
			allOrOne ="all";
		}
		
		param["jtnum"] = jtnum;
		param["command"] = command;
		param["allOrOne"] = allOrOne;
		
		param = JSON.stringify(param);
		var btn = {
			type: "POST"
		,	url: "/test/jttest_ok.jsp"
		,	dataType: "json" 
		,	beforeSend: function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		}
		,	data: param
		,	success: function(result){	

				$('#table').bootstrapTable({
		           data: result
		        });
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