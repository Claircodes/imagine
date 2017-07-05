package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn;

public class UserService {

	public boolean insertUser(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "insert into user_info(id, pwd, name,class_num,age)";
			sql += "values (?,?,?,?,?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, hm.get("id"));
			ps.setString(2, hm.get("pwd"));
			ps.setString(3, hm.get("name"));
			ps.setString(4, hm.get("class_num"));
			ps.setString(5, hm.get("age"));
			int result = ps.executeUpdate();
			if (result == 1) {
				con.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn.closeCon();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteUser(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn.getCon();
			String sql = "delete from user_info where num= ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("num"));
			int result = ps.executeUpdate();
			if (result == 1) {
				con.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn.closeCon();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean updateUser(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn.getCon();
			String sql = "update user_info set name=?, class_num=?, age=? where num= ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, hm.get("name"));
			ps.setString(2, hm.get("class_num"));
			ps.setString(3, hm.get("age"));
			ps.setString(4, hm.get("num"));

			int result = ps.executeUpdate();
			if (result == 1) {
				con.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn.closeCon();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<Map> searchUser(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "select id, pwd, name,class_num,age from user_info";
			if (!hm.get("name").equals("")) {
				sql += " WHERE name like ?";
			}
			ps = con.prepareStatement(sql);
			if (!hm.get("name").equals("")) {
				ps.setString(1, hm.get("name"));
			}
			ResultSet rs = ps.executeQuery();
			ArrayList list = new ArrayList();
			while (rs.next()) {
				HashMap hm1 = new HashMap();
				hm1.put("id", rs.getString("id"));
				hm1.put("pwd", rs.getString("pwd"));
				hm1.put("name", rs.getString("name"));
				hm1.put("class_num", rs.getString("class_num"));
				hm1.put("age", rs.getString("age"));
				list.add(hm1);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn.closeCon();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
