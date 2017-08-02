<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="/js/jquery-3.2.1.js"></script>
<body>
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
		,success: function(results){	
    		var str ="";
	    	for(var i=0, max=results.length;i<max;i++){
	    		var result = results[i]; 
	    		str += "<table border='1'>";
	    		str += "<tr><td>";
	    		str += result.calnum +"번";
	    		str += "</td><td>";
	    		str += result.num1; 
	    		str += "</td><td>";
	    		str += result.op;
	    		str += "</td><td>" 
	    		str += result.num2;
	    		str += "</td><td>=</td><td>";
	    		str += result.result;
	    		str += "</td></tr>";
	    		str += "</table>";
	    	}
 	    	$("#resultDiv").html(str);

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