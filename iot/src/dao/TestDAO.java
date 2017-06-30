package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.DBConn;

public class TestDAO {

	Connection con;
	PreparedStatement ps;

	public List<Map> selectTest() {
		List<Map> testList = new ArrayList<Map>();
		try {
			con = DBConn.getCon();
			String sql = "SELECT T.*, UI.ID, UI.NAME FROM TEST AS T, USER_INFO AS UI";
			sql += " WHERE T.WRITER = UI.NUM;";
			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Map hm = new HashMap();
				hm.put("num", rs.getString("num"));
				hm.put("title", rs.getString("title"));
				hm.put("content", rs.getString("content"));
				hm.put("writer", rs.getString("writer"));
				hm.put("reg_date", rs.getString("reg_date"));
				hm.put("id", rs.getString("id"));
				hm.put("name", rs.getString("name"));
				testList.add(hm);
			}
			DBConn.closeCon();
			return testList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertTest() {
		try {
			con = DBConn.getCon();
			String writer = "2";
			String sql = "SELECT * from user_info WHERE NUM=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, writer);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				sql = "INSERT INTO TEST " + "(TITLE, CONTENT, WRITER, REG_DATE) VALUES " + "(?,?,?, NOW())";
				ps = con.prepareStatement(sql);
				ps.setString(1, "게시물4");
				ps.setString(2, "내용4");
				ps.setString(3, writer);
				int result = ps.executeUpdate();

				if (result == 1) {
					return true;
				}
			}
			DBConn.closeCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteTest() {
		try {
			con = DBConn.getCon();
			int num =2;
			String sql = "SELECT * FROM USER WHERE NUM =(SELECT WRITER FROM TEST WHERE NUM ="+num+")";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

				if (!rs.next()) {
					sql = "DELETE FROM TEST WHERE writer = ?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, num);
					int result = ps.executeUpdate();
					DBConn.closeCon();
					System.out.println("delete");
					if (result == 1) {
						return true;
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateTest() {
		try {
			
			String title = null;
			String sql = "SELECT * FROM USER WHERE title =";
			sql += title;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			con = DBConn.getCon();
			sql = "UPDATE test SET TITLE =? WHERE TITLE=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "게시물이다");
			ps.setString(2, "게시물3");
			int result = ps.executeUpdate();
			DBConn.closeCon();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		TestDAO t = new TestDAO();
		// t.insertTest();
		t.deleteTest();
		// t.updateTest();

//		System.out.println(t.selectTest());
	}

}
