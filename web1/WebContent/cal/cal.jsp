
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
<input type="text" id="n11" name="n11" />
+
<input type="text" id="n12" name="n12" />
<input type="button" id="btn1" name="btn1" value="버튼"/>
<input type="text" id="r1" name="r1" />
<br/>

<input type="text" id="n21" name="n21" />
-
<input type="text" id="n22" name="n22" />
<input type="button" id="btn2" name="btn2" value="버튼"/>
<input type="text" id="r2" name="r2" />
<br/>

<input type="text" id="n31" name="n31" />
x
<input type="text" id="n32" name="n32" />
<input type="button" id="btn3" name="btn3" value="버튼"/>
<input type="text" id="r3" name="r3" />
<br/>

<input type="text" id="n41" name="n41" />
/
<input type="text" id="n42" name="n42" />
<input type="button" id="btn4" name="btn4" value="버튼"/>
<input type="text" id="r4" name="r4" />
<br/>

	<script>
	var btnid= "btn";
	$("input[id*='"+btnid+"']").click(function(){
		var command = "insert";
		var op =["","+","-","*","/"];
		var id = this.id;
		var idx = id.split(btnid)[1];
		var num1 = $("#n"+idx+"1").val();
		var num2 = $("#n"+idx+"2").val();
		var param = {};
		param["num1"] = num1;
		param["num2"] = num2;
		param["op"]=op[idx];
		param["command"]=command;
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
				alert(result);
			if(result.finish=="ok"){
				$("#r"+idx).val(result.result);
				}
			}
			,error: function(xhr, status, e) {
			alert("에러 : "+e);
			}
			,complete: function() {
			}
			};
			$.ajax(a);
			});

			</script>
</body>
</html>