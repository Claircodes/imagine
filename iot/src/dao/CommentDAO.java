package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.DBConn;

public class CommentDAO {
	Connection con;
	Statement st;

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
			String sql = "";
			int result = st.executeUpdate(sql);
			if (result == 1) {
				con.commit();
				st.close();
				st = null;
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
			String sql = "";
			int result = st.executeUpdate(sql);
			if (result == 1) {
				con.commit();
				st.close();
				st = null;
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
			String sql = "";
			int result = st.executeUpdate(sql);
			if (result == 1) {
				con.commit();
				st.close();
				st = null;
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
			String sql = "";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				Map hm = new HashMap();
				
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
		CommentDAO cdao = new CommentDAO();
		cdao.setConnection();

	}

}
