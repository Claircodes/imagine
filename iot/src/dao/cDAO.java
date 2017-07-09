
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

public class cDAO {
	Connection con;
	Statement st;

	cDAO() throws Exception {
		con = DBConn.getCon();

	}

	public List<Map> getCommentList(int boardNum) throws Exception {

		String sql = "select num, content, ui_num, b_num, reg_Date from comment_info";
		sql += "where b_num=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNum);
		ResultSet rs = ps.executeQuery();
		ArrayList commentList = new ArrayList();
		
		while (rs.next()) {
			HashMap hm = new HashMap();
			hm.put("num", rs.getString("num"));
			hm.put("content", rs.getString("content"));
			hm.put("ui_num", rs.getString("ui_num"));
			hm.put("b_num", rs.getString("b_num"));
			hm.put("reg_date", rs.getString("reg_date"));
			commentList.add(hm);
		}
		
		rs.close();
		rs = null;
		ps.close();
		ps = null;
		return commentList;
	}

	public void setConnection() {
		try {
			con = DBConn.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean insertComment() {
		try {
			st = con.createStatement();
			String sql = "insert into comment_info (content,ui_num,b_num,reg_date) values ('악성댓글5',1,2,now())";
			int result = st.executeUpdate(sql);
			if (result == 1) {
				con.commit();
				st.close();
				st = null;
				System.out.println("insertComment");
				return true;
			}
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("insertComment(): 이상한거 넣었지 롤백해~");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateComment() {
		try {
			st = con.createStatement();
			String sql = "UPDATE comment_info SET content = '바뀌지롱' WHERE num ='2'";
			int result = st.executeUpdate(sql);
			if (result == 1) {
				con.commit();
				st.close();
				st = null;
				System.out.println("updateComment");
				return true;
			}
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("updateComment(): 이상한거 넣었지 롤백해~");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteComment() {
		try {
			st = con.createStatement();
			String sql = "delete from comment_info where num='8'";
			int result = st.executeUpdate(sql);
			if (result == 1) {
				con.commit();
				st.close();
				st = null;
				System.out.println("deleteComment");
				return true;
			}
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("deleteComment(): 이상한거 넣었지 롤백해~");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}

	public List<Map> selectComment() {
		List<Map> list = new ArrayList<Map>();
		try {
			st = con.createStatement();
			String sql = "select num,content,ui_num,b_num,reg_date from comment_info";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Map hm = new HashMap();
				hm.put("num", rs.getString("num"));
				hm.put("content", rs.getString("content"));
				hm.put("ui_num", rs.getString("ui_num"));
				hm.put("b_num", rs.getString("b_num"));
				hm.put("reg_date", rs.getString("reg_date"));
				list.add(hm);
			}
			return list;
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		CommentDAO cdao;
		try {
			cdao = new CommentDAO();
//			cdao.setConnection();
//			cdao.deleteComment();
//			cdao.insertComment();
//			cdao.updateComment();
//			cdao.selectComment();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
