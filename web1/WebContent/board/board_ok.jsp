<%@ include file="/common/header.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.BoardInfo"%>

	<%
		String resultStr = "";
		String command = request.getParameter("command");
		
		if (command.equals("insert") && command != null&&command!="") {
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = DBConn.getCon();
				String sql = "INSERT INTO board_info (bititle,bicontent,bipwd,creusr,credat) ";
				sql += "VALUES (?,?,?,?,NOW())";
				ps = con.prepareStatement(sql);

				ps.setString(1, request.getParameter("bititle"));
				ps.setString(2, request.getParameter("bicontent"));
				ps.setString(3, request.getParameter("bipwd"));
				ps.setString(4, userId);
				int result = ps.executeUpdate();
				if (result == 1) {
					con.commit();
					resultStr = "저장 성공";
				}
			} catch (Exception e) {
				e.printStackTrace();
				resultStr = "저장 실패";
			} finally {
				if (ps != null) {
					ps.close();
					ps = null;
				}
				DBConn.closeCon();
			}
		}		if (command.equals("delete") && command != null&&command!="") {
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = DBConn.getCon();
				String sql = "delete from board_info where binum= ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(request.getParameter("binum")));
				int result = ps.executeUpdate();

				if (result == 1) {
					con.commit();
					resultStr = "삭제 성공";
				}
			} catch (Exception e) {
				e.printStackTrace();
				resultStr = "삭제 실패";
			} finally {
				if (ps != null) {
					ps.close();
					ps = null;
				}
				DBConn.closeCon();
			}
		}		if (command.equals("update") && command != null&&command!="") {
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = DBConn.getCon();
				String sql = "UPDATE board_info SET bititle=?, bicontent=?, credat= NOW() WHERE binum= ?";
				ps = con.prepareStatement(sql);

				ps.setString(1, request.getParameter("bititle"));
				ps.setString(2, request.getParameter("bicontent"));
				ps.setInt(3,  Integer.parseInt(request.getParameter("binum")));

				int result = ps.executeUpdate();
				if (result == 1) {
					con.commit();
					resultStr ="수정 성공";
				}
			} catch (Exception e) {
				e.printStackTrace();
				resultStr = "수정 실패";
			} finally {
				if (ps != null) {
					ps.close();
					ps = null;
				}
				DBConn.closeCon();
			}
		}
	%>

	<script>
	var result = "<%=resultStr%>	";
		alert(result);
		location.href = "/board/board_main.jsp";

	</script>
