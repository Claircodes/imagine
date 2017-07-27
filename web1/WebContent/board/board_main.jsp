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
		String sql = "";
		String searchtxt = "%" + request.getParameter("searchtxt") + "%";
		String searchTarget = request.getParameter("searchTarget");
		
		String researchtxt = "%" + request.getParameter("researchtxt") + "%";
		String researchTarget = request.getParameter("researchTarget");
		
		front += "<input type='button' value='로그아웃' onclick='doMovePage(\"logout\")'/>";
		front += "<input type='button' value='로그인메인화면으로 돌아가기' onclick='doMovePage(\"main\")'/>";

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			sql = "SELECT binum,bititle,bicontent,bipwd,creusr,credat FROM board_info where 1=1 ";
			if (request.getParameter("command") != null && request.getParameter("command").equals("search")) {
				if (searchTarget.equals("bititle")) {
					sql += " and bititle like ?";
				} else if (searchTarget.equals("bicontent")) {
					sql += " and bicontent like ?";
				} else if (searchTarget.equals("creusr")) {
					sql += " and creusr like ?";
				} else if (searchTarget.equals("bicontitle")) {
					sql += " and bicontent like ? or bititle like ?";
				}
			}else if (request.getParameter("command1") != null && request.getParameter("command1").equals("research")) {
				if (searchTarget.equals("rebititle")) {
					sql += " and bititle like ?";
				} else if (searchTarget.equals("bicontent")) {
					sql += " and bicontent like ?";
				} else if (searchTarget.equals("recreusr")) {
					sql += " and creusr like ?";
				}
			}
			sql += "ORDER BY binum DESC";

			ps = con.prepareStatement(sql);
			if (request.getParameter("command") != null && request.getParameter("command").equals("search")) {
				ps.setString(1, "%" + searchtxt + "%");
				if (searchTarget.equals("bicontitle")) {
					ps.setString(2, "%" + searchtxt + "%");
				}
			}
			if (request.getParameter("command") != null && request.getParameter("command1").equals("research")) {
				ps.setString(1, "%" + searchtxt + "%");
				if (searchTarget.equals("bicontitle")) {
					ps.setString(2, "%" + searchtxt + "%");
				}
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
			tableStr += "<select name='searchTarget' id='searchTarget'>";
			tableStr += "<option value='bititle'>제목</option>";
			tableStr += "<option value='creusr'>작성자</option>";
			tableStr += "<option value='bicontent'>내용</option>";
			tableStr += "<option value='bicontitle'>제목 + 내용</option>";
			tableStr += "</select>";
			tableStr += "<input type='text' id='searchtxt' />";
			tableStr += "<input type='button' value='검색' onclick='doSearch()'/>";
			tableStr += "<input type='button' value='글쓰기' onclick='doMovePage(\"insert\")' />";

			if (request.getParameter("command") != null && request.getParameter("command").equals("search")) {
				tableStr += "<br/><br/>결과내검색 :<select name='researchTarget' id='researchTarget'>";
				tableStr += "<option value='rebititle'>제목</option>";
				tableStr += "<option value='recreusr'>작성자</option>";
				tableStr += "<option value='rebicontent'>내용</option>";
				tableStr += "<option value='rebicontitle'>제목 + 내용</option>";
				tableStr += "</select>";
				tableStr += "<input type='text' id='researchtxt' />";
				tableStr += "<input type='button' value='검색' onclick='doReSearch()' />";
			}
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
		String
		defaultUrl = "";
		if (init == null && !login) {
			defaultUrl = rootPath + "/user/login.jsp?init=1";
			response.sendRedirect(defaultUrl);
		}
		function clickTr(binum) {
			location.href = rootPath + "/board/board_content.jsp?binum="
					+ binum;
		}
		function doSearch() {
			var searchTarget = document.getElementById("searchTarget").value;
			var searchtxt = document.getElementById("searchtxt").value;
			location.href = rootPath
					+ "/board/board_main.jsp?command=search&searchtxt="
					+ searchtxt + "&searchTarget=" + searchTarget + "&";
		}
		function doReSearch() {
			var url = location.href;
			var researchTarget = document.getElementById("researchTarget").value;
			var researchtxt = document.getElementById("researchtxt").value;
			location.href = url + "command1=research&researchtxt="	+ researchtxt + "&researchTarget=" + researchTarget + "&";
		}
	</script>
</body>
</html>