<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String guCnt = request.getParameter("gucnt");
	
		if (guCnt != "" && guCnt != null) {
			if (Integer.parseInt(guCnt) > 0) {
				out.println(guCnt + "X" + guCnt + "단을 생성");
				int len = Integer.parseInt(guCnt);
				
				String tableStr = "<table border='1'>";
				for (int i = 1; i <= len; i++) {
					tableStr += "<tr>";
					for (int j = 1; j <= len; j++) {
						tableStr += "<td>";
						tableStr += i + " x " + j + "=" + (i * j);
						tableStr += "</td>";
					}
					tableStr += "</tr>";
				}
				tableStr += "</table>";
				out.println(tableStr);
			}
		}
	%>

	<form action="/user/login.jsp">
		구구단 생성 갯수 : <input type="text" name="gucnt"  value="" /><br /> <input type="submit" value="생성!" />
	</form>
</body>
</html>