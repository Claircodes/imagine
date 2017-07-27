<%@page import="javax.swing.table.TableStringConverter"%>
<%@ include file="/common/header.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.BoardInfo"%>

<body>

	<%
		String front = userId + "님 ";
		String tableStr = "";
		String searchtxt = "%" + request.getParameter("searchtxt") + "%";

		String searchTarget = request.getParameter("searchTarget");

		front += "<input type='button' value='로그아웃' onclick='doMovePage(\"logout\")'/>";
		front += "<input type='button' value='로그인메인화면으로 돌아가기' onclick='doMovePage(\"main\")'/>";

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "SELECT binum,bititle,bicontent,bipwd,creusr,credat FROM board_info ";
			if (request.getParameter("command") != null && request.getParameter("command").equals("search")) {
				if (searchTarget.equals("bititle")) {
					sql += "where bititle like ?";
				} else if (searchTarget.equals("bicontent")) {
					sql += "where bicontent like ?";
				} else if (searchTarget.equals("creusr")) {
					sql += "where creusr like ?";
				}
				sql += "ORDER BY binum DESC";
			}
			ps = con.prepareStatement(sql);
			if (request.getParameter("command") != null && request.getParameter("command").equals("search")) {
				ps.setString(1, searchtxt);
			}

			ResultSet rs = ps.executeQuery();

			tableStr = "<br/><table border='1'>";
			String[] menu = {"번호", "제목", "아이디", "날짜"};
			tableStr += "<tr>";
			for (int i = 0; i < menu.length; i++) {
				tableStr += "<td>" + menu[i] + "</td>";
			}
			tableStr += "</tr>";
			while (rs.next()) {
				BoardInfo bi = new BoardInfo();
				tableStr += "<tr onclick='clickTr(" + rs.getInt("binum") + ")' style='cursor:pointer'>";
				tableStr += "<td>" + rs.getInt("binum") + "</td>";
				tableStr += "<td>" + rs.getString("bititle") + "</td>";
				tableStr += "<td>" + rs.getString("creusr") + "</td>";
				tableStr += "<td>" + rs.getDate("credat").toString() + "</td>";
				tableStr += "</tr>";
			}
			tableStr += "</table>";
			out.println(front + tableStr);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (ps != null) {
				ps.close();
				ps = null;
			}
			DBConn.closeCon();
		}
	%>

	<script>
		function clickTr(binum) {
			location.href = rootPath + "/board/board_content.jsp?binum="
					+ binum;
		}

		function doSearch() {
			var searchTarget = document.getElementById("searchTarget").value;
			var searchtxt = document.getElementById("searchtxt").value;
			location.href = rootPath
					+ "/board/board_main.jsp?command=search&searchtxt="	+ searchtxt + "&searchTarget=" + checked_value + "&";
		}
	</script>

	<select name='searchTarget' id='searchTarget'>
		<option value='bititle'>제목</option>
		<option value='creusr'>작성자</option>
		<option value='bicontent'>내용</option>
		<option value='bicontitle'>제목 + 내용</option>
	</select>

	<input type="text" id="searchtxt" />
	<input type="button" value="검색" onclick="doSearch()" />
	<input type="button" value="글쓰기" onclick="doMovePage('insert')" />
	<div id="board_insert_div"></div>
</body>
</html>