package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn;

public class ClassService {

	public boolean insertClass(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "insert into class_info(class_name)";
			sql += " values (?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("classNameInsert"));

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

	public boolean deleteComment(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn.getCon();
			String sql = "delete from class_info where class_num= ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("deleteComNum"));
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

	public boolean updateComment(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn.getCon();
			String sql = "update class_info set content=? where class_num= ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, hm.get("comContent"));
			ps.setString(2, hm.get("class_num"));

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

	public List<Map> searchComment(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "select content from class_info ";
			if (!hm.get("searchNum").equals("")) {
				sql += " WHERE class_num = ?";
			}
			ps = con.prepareStatement(sql);
			if (!hm.get("searchNum").equals("")) {
				ps.setString(1, hm.get("searchNum"));
			}
			ResultSet rs = ps.executeQuery();
			List<Map> list = new ArrayList<Map>();
			while (rs.next()) {
				HashMap hm1 = new HashMap();
				hm1.put("ui_num", rs.getString("ui_num"));
				hm1.put("b_num", rs.getString("b_num"));
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
