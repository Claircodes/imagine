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
		String searchtxt = request.getParameter("searchtxt");
		String selectoption = request.getParameter("selectoption");

		front += "<input type='button' value='로그아웃' onclick='doMovePage(\"logout\")'/>";
		front += "<input type='button' value='로그인메인화면으로 돌아가기' onclick='doMovePage(\"main\")'/>";

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "SELECT binum,bititle,bicontent,bipwd,creusr,credat FROM board_info ORDER BY binum DESC";
			if (searchtxt != null && searchtxt.equals("")) {
				if (selectoption.equals("stitle")) {
					sql +="where bititle like ?";
				} else if (selectoption.equals("scontent")) {
					sql +="where bicontent like ?";
				} else if (selectoption.equals("suser")) {
					sql +="where creusr like ?";
				}
			}
			ps = con.prepareStatement(sql);
			if (searchtxt != null && searchtxt.equals("")) {
				ps.setString(1,"%"+searchtxt+"%");
			}
			
			ResultSet rs = ps.executeQuery();

			String tableStr = "<br/><table border='1'>";
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

		function doSelect(frm) {
			if (frm.sel.options[frm.sel.selectedIndex].value != "searchname") {
				var search = document.getElementById("searchtxt").value;
				location.href = rootPath + "/board/board_main.jsp?searchtxt="
						+ search + "&selectoption="
						+ frm.sel.options[frm.sel.selectedIndex].value + "&";
			} else {
				alert("검색할 항목을 선택해주세요.");
				document.getElementById("sel").focus();
			}

		}
	</script>
	<select name="sel" id="sel" onChange="doSelect(this.form);">
		<option value="searchname" selected>[검색항목]</option>
		<option value="stitle">제목</option>
		<option value="scontent">내용</option>
		<option value="suser">글쓴이</option>
	</select>
	<input type="text" id="searchtxt" onselect="doSelect()" />
	<input type="button" value="검색" onclick="doSearch()" />
	<input type="button" value="글쓰기" onclick="doMovePage('insert')" />
	<div id="board_insert_div"></div>
</body>
</html>