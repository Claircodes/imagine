<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
아이디: <input type="text" id="id" name="pwd" />
비밀번호: <input type="text" id="pwd" name="pwd" />
<input type="button" id="btnSend" value="버튼"/>


</body>

<script>
$("#btnSend").click(function(){
	var param = {};
	param["id"]=$("#id").val();
	param["pwd"]=$("#pwd").val();
	
	var params = JSON.stringify(param);
	
	
	$.ajax({ 
		type     : "POST"
    ,   url      : "/list.goods"
    ,   dataType : "json" 
    ,   beforeSend: function(xhr) {
        xhr.setRequestHeader("Accept", "application/json");
        xhr.setRequestHeader("Content-Type", "application/json");
    }
    ,   data     : params
    ,   success : function (result) {
		alert(result);
	}
    ,   error : function(xhr, status, e) {
	    	alert("에러 : "+e);
	},
	complete  : function() {
	}
	
});

</script>
</html>
