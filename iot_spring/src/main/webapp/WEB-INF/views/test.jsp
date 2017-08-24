<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello world!</h1><br>
id: <input type="text" id="id"><br>
pwd: <input type="text" id="pwd"><br>
<input type="button" value="버튼" onclick="sendInfo()"><br>
${hm.test}

</body>
<script >
function sendInfo() {
	location.href = "/sp/test/1?test=로그인햇냐능&babo=했잖아&id="+document.getElementById("id").value+"&pwd="+document.getElementById("pwd").value;
}
</script>
</html>
