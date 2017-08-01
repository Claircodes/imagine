<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.BoardInfo"%>

	<div class="container">
		<div class="starter-template">
			<table border="1" class='table table-bordered table-hover'>
				<tr>
					<td>제목 :</td>
					<td><input type="text" name="bititle" id="bititle" /></td>
				</tr>
				<tr>
					<td>비밀번호 :</td>
					<td><input type="password" name="bipwd" id="bipwd" /></td>
				</tr>
				<tr>
					<td>내용 :</td>	<td><textarea name="bicontent" id="bicontent"></textarea></td>
				</tr>
			</table>
			<input type="button" value="취소" onclick="doMovePage('board')"/>
			<input type="button" value="확인" onclick="doInsert()" />
		</div>
	</div>
	<script>
	document.getElementById("m1").className = "active";
		function doInsert() {
			var bt = document.getElementById("bititle").value;
			var pwd = document.getElementById("bipwd").value;
			var c = document.getElementById("bicontent").value;
			location.href = rootPath + "/board/board_ok.jsp?command=insert&bititle= " + bt + "&bipwd=" + pwd + "&bicontent= " + c + "&";
		}
	</script>
