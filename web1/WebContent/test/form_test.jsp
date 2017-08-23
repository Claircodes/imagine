<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<p>get parameter 방식</p>
<form action="test.formtest" method="get">
아이디 : <input type="text" id="id1"name="id1" ><br>
비밀번호 : <input type="text" id="pwd1"name="pwd1" ><br>
<input type="submit" value="전송">
</form>
<p>POST JSON 방식</p>
<form action="test.formtest" method="post">
아이디 : <input type="text" id="id2" name="id2" ><br>
비밀번호 : <input type="text" id="pwd2" name="pwd2" ><br>
<input type="button" id="btnclick" value="전송">
</form>
</body>
<script>
$("#btnclick").click(function(){
	var param={};
	param["id2"]=$("#id2").val();
	param["pwd2"]=$("#pwd2").val();
	
	var params = JSON.stringify(param);
	$.ajax({ 
    		type     : "POST"
	    ,   url      : "/test.formtest"
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : params
	    ,   success : pCallBackFunc
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
});


function pCallBackFunc(result) {
	var id = result.id;
	var pwd = result.pwd;
	alert("id는 "+id+", pwd는"+pwd);
}
</script>
</html>