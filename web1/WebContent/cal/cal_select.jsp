
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="calnum"  class="text-center">번호</th>
					<th data-field="num1"  class="text-center">숫자1</th>
					<th data-field="op"  class="text-center">연산자</th>
					<th data-field="num2"  class="text-center">숫자2</th>
					<th data-field="result"  class="text-center">결과값</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
	</div>
<input type="text" id="calnum"/>
<input type="button" id="numbtn" value="버튼"/>
<div id="resultDiv"></div>
</body>
<script>
var str ="";

$("input[id='numbtn']").click(function(){
	var command = "select";
	var calnum = $("#calnum").val();
	if (calnum=="" || calnum==null){
		calnum ="all";
	}
	var param = {};
	param["calnum"] = calnum;
	param["command"] = command;

	param = JSON.stringify(param);
	var a = {
		type: "POST"
		,url: "/cal/cal_ok.jsp"
		,dataType: "json" 
		,beforeSend: function(xhr) {
		xhr.setRequestHeader("Accept", "application/json");
		xhr.setRequestHeader("Content-Type", "application/json");
		}
		,data: param
		,success: function(result){	
	        $('#table').bootstrapTable({
	            data: result
	        });

		}
		,error: function(xhr, status, e) {
		alert("에러 : "+e);
		}
		,done: function(e) {
			}
		};
		$.ajax(a);
		});

</script>
</html>