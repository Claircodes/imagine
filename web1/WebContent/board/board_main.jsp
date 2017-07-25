<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.BoardInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		List<BoardInfo> boardlist = new ArrayList<BoardInfo>();

		out.println(userId + "님 ");
		out.println("<input type='button' value='로그아웃' onclick='doMovePage(\"logout\")'/>");
		out.println("<input type='button' value='로그인메인화면으로 돌아가기' onclick='doMovePage(\"main\")'/>");

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "SELECT binum,bititle,bicontent,bipwd,creusr,credat FROM board_info ORDER BY binum DESC";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BoardInfo bi = new BoardInfo();
				bi.setBinum(rs.getInt("binum"));
				bi.setBititle(rs.getString("bititle"));
				bi.setBipwd(rs.getString("bipwd"));
				bi.setCreusr(rs.getString("creusr"));
				bi.setDatetime(rs.getDate("credat").toString());
				boardlist.add(bi);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		String tableStr = "<br/><table border='1'>";
		String[] menu = {"번호", "제목", "아이디", "날짜"};
		tableStr += "<tr>";
		for (int i = 0; i < menu.length; i++) {
			tableStr += "<td>" + menu[i] + "</td>";
		}
		tableStr += "</tr>";
		for (BoardInfo bi1 : boardlist) {
			tableStr += "<tr onclick='clickTr(" + bi1.getBinum() + ")' style='cursor:pointer'>";
			tableStr += "<td>" + bi1.getBinum() + "</td><td>" + bi1.getBititle() + "</td><td>" + bi1.getCreusr()
					+ "</td><td>" + bi1.getDatetime() + "</td>";
			tableStr += "</tr>";
		}
		tableStr += "</table>";

		out.println(tableStr);
	%>

	<script>
		function insertFormCancel() {
			document.getElementById("board_insert_div").innerHTML = "";
		}
		function insertForm() {
			var tableStr = "<table border='0'>";
			tableStr += "<tr><td>아이디 : </td><td><input type='text' name='buser' id='creusr' /></td></tr>";
			tableStr += "<tr><td>비밀번호 : </td><td><input type='password' name='bipwd' id='bipwd' /></td></tr>";
			tableStr += "<tr><td>제목 : </td><td><input type='text' name='bititle' id='bititle' /></td></tr>";
			tableStr += "<tr><td colspan='2'>내용 : </td></tr>";
			tableStr += "<tr><td colspan='2'><textarea name='bicontent' id='bicontent'></textarea></td></tr>";
			tableStr += "<tr><td><input type='button' value='취소' onclick='insertFormCancel()'/></td><td><input type='button' value='확인' onclick='doInsert()'/></td></tr>";
			tableStr += "</table>";
			document.getElementById("board_insert_div").innerHTML = tableStr;
		}

		function clickTr(binum) {
			location.href = rootPath + "/board/board_content.jsp?binum="
					+ binum;
		}
	</script>
	<select name='sel' id='sel'>
		<option id='searchname' value='[검색항목]' selected>[검색항목]</option>
		<option id='stitle' value='제목'>제목</option>
		<option id='scontent' value='내용'>내용</option>
		<option id='suser' value='글쓴이'>글쓴이</option>
	</select>
	<input type='text' id='searchstr' onselect='doSelect()' />
	<input type='button' value='검색' />
	<input type='button' value='글쓰기' onclick='insertForm()' />
	<div id="board_insert_div"></div>
</body>
</html>