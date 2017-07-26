<%@page import="com.test.dto.BoardInfo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.test.common.DBConn"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ include file="/common/header.jsp"%>
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
		out.println(userId + "님 ");
		out.println("<input type='button' value='로그아웃' onclick='doLogout()'/>");
		out.println("<input type='button' value='로그인메인화면으로 돌아가기' onclick='doBackLogin()'/>");
		BoardInfo bi = new BoardInfo();
		int binum = Integer.parseInt(request.getParameter("binum"));
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "SELECT binum,bititle,bicontent,bipwd,creusr,credat FROM board_info where binum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, binum);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bi.setBinum(rs.getInt("binum"));
				bi.setBititle(rs.getString("bititle"));
				bi.setBicontent(rs.getString("bicontent"));
				bi.setBipwd(rs.getString("bipwd"));
				bi.setCreusr(rs.getString("creusr"));
				bi.setDatetime(rs.getDate("credat").toString());
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (ps != null) {
				ps.close();
				ps = null;
			}
			DBConn.closeCon();
		}
		String tableStr = "<table border='1'>";
		tableStr += "<tr><td>No : </td><td>" + bi.getBinum() + "</td></tr>";
		tableStr += "<tr><td>아이디 : </td><td>" + bi.getCreusr() + "</td></tr>";
		tableStr += "<tr><td>제목 : </td><td>" + bi.getBititle() + "</td></tr>";
		tableStr += "<tr><td colspan='2'>내용 : </td></tr>";
		tableStr += "<tr><td colspan='2'>" + bi.getBicontent() + "</td></tr>";
		tableStr += "</table>";
		tableStr += "<input type='button' value='목록으로' onclick='doMovePage(\"board\")'/>";
		out.println(tableStr);

		if (bi.getBinum() == binum) {
			out.println("<input type='button' value='삭제' onclick='doDeleteForm()' />");
			out.println("<input type='button' value='수정' onclick='doUpdateForm()' />");
		}
	%>
	<script>
function doDeleteForm() {
	alert("비밀번호를 입력해주세요");
	var binum = "<%=binum%>";
			document.getElementById("pwdform").innerHTML = "패스워드를 입력하세요-->><br/><input type='text' id='deletepwd'/><input type='button' value='비번확인' onclick='doDeletePwdOk("
					+ binum + ")' />";
		}
		function doUpdateForm() {
			alert("비밀번호를 입력해주세요");
			document.getElementById("pwdform").innerHTML = "패스워드를 입력하세요-->><br/><input type='text' id='updatepwd'/><input type='button' value='비번확인' onclick='doUpdatePwdOk("
					+ binum + ")'  />";
		}
		function doDeletePwdOk(bn) {
			location.href = rootPath
					+ "/board/board_ok.jsp?command=delete&binum=" + bn + "&";

		}
		function doUpdatePwdOk(bn) {
			location.href = rootPath + "/board/board_update.jsp?"+"binum=" + bn + "&";
		}
	</script>

	<div id="pwdform"></div>
</body>
</html>