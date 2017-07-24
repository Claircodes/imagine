<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.BoardInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String userId = (String) session.getAttribute("userid");
String userPwd = (String) session.getAttribute("userpwd");
List<BoardInfo> boardlist = new ArrayList<BoardInfo>();

out.println(userId +"님이 로그인 하셨습니다. ");

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
		bi.setBicontent(rs.getString("bicontent"));
		bi.setBipwd(rs.getString("bipwd"));
		bi.setCreusr(rs.getString("creusr"));
		bi.setDatetime(rs.getDate("credat").toString());
		boardlist.add(bi);
	}
	
} catch(Exception e){
	System.out.println(e);
}

String result = "";
String menu = "번호{/}제목{/}내용{/}글쓴이{/}날짜{+}";
result += menu;
result += "dis{/}en{/}en{/}en{/}dis{+}";
for (BoardInfo bi1 : boardlist) {
	result += bi1.getBinum() + "{/}" + bi1.getBititle() + "{/}" + bi1.getBicontent() + "{/}"
			+ bi1.getCreusr() + "{/}" + bi1.getDatetime() + "{+}";
}
result = result.substring(0, result.length() - 3);

String[] rows = result.split("{+}");
String[]  tdEnables = rows[1].split("{/}");
String tableStr = "<br/><table border='1'>";
for (int i = 0; i < rows.length; i++) {
	if (i == 1) {
		continue;
	}
	tableStr += "<tr>";
	String[] columns = rows[i].split("{/}");
	int boardNum;
	for (int j = 0; j < columns.length; j++) {
		if (j == 0) {
			boardNum = Integer.parseInt(columns[j]);
		}
		if (i == 0) {
			tableStr += "<td>" + columns[j] + "</td>";
		} else {
			if (tdEnables[j] == "en") {
				tableStr += "<td><input type='text'";
				if (j == 1) {
					tableStr += " id='boardTitle" + Integer.parseInt(columns[0]) + "' ";
				} else if (j == 2) {
					tableStr += " id='boardContent" + Integer.parseInt(columns[0]) + "' ";
				} else if (j == 3) {
					tableStr += " id='boardUI" + Integer.parseInt(columns[0]) + "' ";
				} else if (j == 4) {
					tableStr += " id='boardDate" + Integer.parseInt(columns[0]) + "' ";
				}
				tableStr += " value='" + columns[j] + "' /></td>";
			} else {
				tableStr += "<td>" + columns[j] + "</td>";
			}
		}
	}
	if (i == 0) {
		tableStr += "<td>삭제</td>";
		tableStr += "<td>수정</td>";
	} else {
			tableStr += "<td><input type='button' value='삭제' onclick='doDelete("	+ Integer.parseInt(columns[0]) + ")'/></td>";
			tableStr += "<td><input type='button' value='수정' onclick='doUpdate("+ Integer.parseInt(columns[0]) + ")'/></td>";
		}
	
	tableStr += "</tr>";
}
tableStr += "</table>";
tableStr += "<select name='sel' id='sel'>";
tableStr +="<option id='searchname' value='[검색항목]' selected>[검색항목]</option>";
tableStr +="<option id='stitle' value='제목'>제목</option>";
tableStr +="<option id='scontent' value='내용'>내용</option>";
tableStr +="<option id='suser' value='글쓴이'>글쓴이</option>";
tableStr += "</select>";
tableStr += "<input type='text' id='searchstr' onselect='doSelect()'/><input type='button' value='검색' onclick='doSelect()'/>";
tableStr += "<input type='button' value='글쓰기' onclick='insertForm()'/>";
out.print(tableStr);
%>
</body>
</html>