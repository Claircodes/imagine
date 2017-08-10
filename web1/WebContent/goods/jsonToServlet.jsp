<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
var testParam = {};
testParam["giNum"] = "22";
testParam["giName"] = "2";
testParam["giDesc"] = "3";
testParam["viNum"] = "2";
testParam["viName"] = "52";

var testParam1 = {};
testParam1["giNum"] = "22";
testParam1["giName"] = "루룰룰라랄";
testParam1["giDesc"] = "testParam1";
testParam1["viNum"] = "2";
testParam1["viName"] = "차";

var testParam2 = {};
testParam2["giNum"] = "22";
testParam2["giName"] = "두빕두바";
testParam2["giDesc"] = "testParam2";
testParam2["viNum"] = "2";
testParam2["viName"] = "차차차";

function callback(results) {
	for(var i=0, max=results.length;i<max; i++){
		var result =results[i];
		alert("result.giDesc="+result.giDesc);
	}
}

goPage(testParam, "/test.goods", callback);
</script>



</body>
</html>