package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.DBConn;

public class BoardDAO {
	Connection con;
	Statement st;

	public void setConnection() {
		try {
			con = DBConn.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean insertBoard() {
		String sql = "INSERT INTO board (title, content, writer, reg_Date) VALUES ('게시판제목3','게시판 제목3',4, NOW())";
		try {
			st = con.createStatement();
			int result = st.executeUpdate(sql);
			if (result == 1) {
				con.commit();
				st.close();
				st = null;
				return true;
			}
		} catch (Exception e) {
			try {
				System.out.println(" insertBoard() :이상한거 넣었지 롤백해~");
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateBoard() {
		try {
			String sql = "UPDATE board SET title = '바뀌지롱' WHERE num ='2'";
			st = con.createStatement();
			int result;
			result = st.executeUpdate(sql);
			if (result == 1) {
				con.commit();
				st.close();
				st = null;
				return true;
			}
		} catch (Exception e) {
			try {
				System.out.println("updateBoard(): 이상한거 넣었지 롤백해~");
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteBoard() {
		try {
			String sql = "delete from board1 where num='9'";
			st = con.createStatement();
			int result = st.executeUpdate(sql);
			if (result == 1) {
				con.commit();
				st.close();
				st = null;
				return true;
			}
		} catch (Exception e) {
			try {
				System.out.println("deleteBoard(): 이상한거 넣었지 롤백해~");
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}

	public List<Map> selectBoard() throws SQLException {
		String sql = "select num, title, content,writer from board";
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		ArrayList boardList = new ArrayList();
		while (rs.next()) {
			HashMap hm = new HashMap();
			hm.put("num", rs.getString("num"));
			hm.put("title", rs.getString("title"));
			hm.put("content", rs.getString("content"));
			hm.put("writer", rs.getString("writer"));
			boardList.add(hm);
		}
		rs.close();
		rs = null;
		ps.close();
		ps = null;
		return boardList;
	}

	public static void main(String[] args) {
		BoardDAO bdao = new BoardDAO();
		try {
			bdao.setConnection();
			List<Map> boardList = bdao.selectBoard();
			CommentDAO dao = new CommentDAO();
			for(Map m : boardList){
				System.out.println(m);
				List<Map> commentList = dao.getCommentList(Integer.parseInt((String)m.get("num")));
				for(Map m2 : commentList){
					System.out.println(m2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}