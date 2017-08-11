<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
</head>
<body>
<input type="button" id="btn" value = "서블릿이동"/>
<script>
$("#btn").click(function(){
	
	var params = {};
	params["num"]="1";
	params["name"]="홍길동";
	params["command"]="test";
	params["struct"]={"a":"1","b":"2"};
	params = JSON.stringify(params);
	alert(params);
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
})
</script>
</body>
</html>