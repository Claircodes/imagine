<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="/js/jquery-3.2.1.js"></script>
<table>
<tr>
<td><input type="text" id="n11" name="n11" /></td>
<td>+</td>
<td><input type="text" id="n12" name="n12" /></td>
<td><button id="b1" name="b1">버튼</button></td>
<td><input type="text" id="r1" name="r1" /></td>
</tr>
<tr>
<td><input type="text" id="n21" name="n21" /></td>
<td>-</td>
<td><input type="text" id="n22" name="n22" /></td>
<td><button id="b2" name="b2">버튼</button></td>
<td><input type="text" id="r2" name="r2" /></td>
</tr>

<tr>
<td><input type="text" id="n31" name="n31" /></td>
<td>x</td>
<td><input type="text" id="n32" name="n32" /></td>
<td><button id="b3" name="b3">버튼</button></td>
<td><input type="text" id="r3" name="r3" /></td>
</tr>
<tr>
<td><input type="text" id="n41" name="n41" /></td>
<td>/</td>
<td><input type="text" id="n42" name="n42" /></td>
<td><button id="b4" name="b4">버튼</button></td>
<td><input type="text" id="r4" name="r4" /></td>
</tr>
</table>
			<script>

			$("#b1").click(function(){
				var num1 = $("#n11").val();
				var num2 = $("#n12").val();

				var param = {};
				param["num1"] = num1;
				param["num2"] = num2;
				param = JSON.stringify(param);
				var a = { 
				        type     : "POST"
				    	    ,   url      : "/cal/cal_ok.jsp"
				    	    ,   dataType : "json" 
				    	    ,   beforeSend: function(xhr) {
				    	        xhr.setRequestHeader("Accept", "application/json");
				    	        xhr.setRequestHeader("Content-Type", "application/json");
				    	    }
				    	    ,   data     : param
				    	    ,   success : function(result){
				    	    	if(result.finish=="ok"){
				    	    		var result = (parseInt(result.num1)+parseInt(result.num2));
				    	    		$("#r1").val(result);
				    	    	}
				    	    }
				    	    ,   error : function(xhr, status, e) {
				    		    	alert("에러 : "+e);
				    		},
				    		done : function(e) {
				    		}
				    		};
				$.ajax(a);
			});
			
			$("#b2").click(function(){
				var num1 = $("#n21").val();
				var num2 = $("#n22").val();

				var param = {};
				param["num1"] = num1;
				param["num2"] = num2;
				param = JSON.stringify(param);
				var a = { 
				        type     : "POST"
				    	    ,   url      : "/cal/cal_ok.jsp"
				    	    ,   dataType : "json" 
				    	    ,   beforeSend: function(xhr) {
				    	        xhr.setRequestHeader("Accept", "application/json");
				    	        xhr.setRequestHeader("Content-Type", "application/json");
				    	    }
				    	    ,   data     : param
				    	    ,   success : function(result){
				    	    	if(result.finish=="ok"){
				    	    		var result = (parseInt(result.num1)-parseInt(result.num2));
				    	    		$("#r2").val(result);
				    	    	}
				    	    }
				    	    ,   error : function(xhr, status, e) {
				    		    	alert("에러 : "+e);
				    		},
				    		done : function(e) {
				    		}
				    		};
				$.ajax(a);
			});
			$("#b3").click(function(){
				var num1 = $("#n31").val();
				var num2 = $("#n32").val();

				var param = {};
				param["num1"] = num1;
				param["num2"] = num2;
				param = JSON.stringify(param);
				var a = { 
				        type     : "POST"
				    	    ,   url      : "/cal/cal_ok.jsp"
				    	    ,   dataType : "json" 
				    	    ,   beforeSend: function(xhr) {
				    	        xhr.setRequestHeader("Accept", "application/json");
				    	        xhr.setRequestHeader("Content-Type", "application/json");
				    	    }
				    	    ,   data     : param
				    	    ,   success : function(result){
				    	    	if(result.finish=="ok"){
				    	    		var result = (parseInt(result.num1)*parseInt(result.num2));
				    	    		$("#r3").val(result);
				    	    	}
				    	    }
				    	    ,   error : function(xhr, status, e) {
				    		    	alert("에러 : "+e);
				    		},
				    		done : function(e) {
				    		}
				    		};
				$.ajax(a);
			});
			$("#b4").click(function(){
				var num1 = $("#n41").val();
				var num2 = $("#n42").val();

				var param = {};
				param["num1"] = num1;
				param["num2"] = num2;
				param = JSON.stringify(param);
				var a = { 
				        type     : "POST"
				    	    ,   url      : "/cal/cal_ok.jsp"
				    	    ,   dataType : "json" 
				    	    ,   beforeSend: function(xhr) {
				    	        xhr.setRequestHeader("Accept", "application/json");
				    	        xhr.setRequestHeader("Content-Type", "application/json");
				    	    }
				    	    ,   data     : param
				    	    ,   success : function(result){
				    	    	if(result.finish=="ok"){
				    	    		var result = (parseInt(result.num1)/parseInt(result.num2));
				    	    		$("#r4").val(result);
				    	    	}
				    	    }
				    	    ,   error : function(xhr, status, e) {
				    		    	alert("에러 : "+e);
				    		},
				    		done : function(e) {
				    		}
				    		};
				$.ajax(a);
			});
			</script>
</body>
</html>