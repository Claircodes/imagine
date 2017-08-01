<%@ include file="/common/header.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.BoardInfo"%>

	<div class="container">
		<div class="starter-template">
			<%

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
					String tableStr = "<table border='1' class='table table-bordered table-hover'>";
					while (rs.next()) {
						tableStr += "<tr><td>No : </td><td>" + rs.getInt("binum") + "</td></tr>";
						tableStr += "<tr><td>아이디:</td><td>" + userId+ "</td></tr>";
						tableStr += "<tr><td>날짜 </td><td>" + rs.getDate("credat").toString() + "</td></tr>";
						tableStr += "<tr><td>제목 : </td><td><input type='text' name='bititle' id='bititle' value='" + rs.getString("bititle") + "'/></td></tr>";
						tableStr += "<tr><td>내용 : </td><td><textarea name='bicontent' id='bicontent'/>" + rs.getString("bicontent") + "</textarea></td></tr>";
					}
					tableStr += "</table>";
					out.println(tableStr);
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
	document.getElementById("m1").className = "active";
		function doUpdate() {
			var bn= "<%=binum%>";
			var bt = document.getElementById("bititle").value;
			var bc = document.getElementById("bicontent").value;
			location.href = rootPath + "/board/board_ok.jsp?command=update&binum=" + bn	+ "&bititle=" + bt + "&bicontent=" + bc + "&";
		}
	</script>
	<input type='button' value='목록으로' onclick="doMovePage('board')"  />
	<input type='button' value='확인' onclick='doUpdate()' />
	</div>
	</div>
	</body>
