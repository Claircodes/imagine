package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn;

public class CommentService {

	public boolean insertComment(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "insert into comment_info(b_num, ui_num, content, reg_date)";
			sql += " values (?,?,?,now())";
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("comBoardNum"));
			ps.setString(2, hm.get("comUserNum"));
			ps.setString(3, hm.get("comContent"));

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
			String sql = "delete from comment_info where Num= ?";
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
			String sql = "update comment_info set content=? where Num= ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, hm.get("comContent"));
			ps.setString(2, hm.get("comNum"));

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

	@SuppressWarnings("rawtypes")
	public List<Map> searchComment(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "select ui_num, b_num, content, reg_date from comment_info ";
			if (!hm.get("searchComNum").equals("")) {
				sql += " WHERE Num like ?";
			}
			ps = con.prepareStatement(sql);
			if (!hm.get("searchComNum").equals("")) {
				ps.setString(1, hm.get("searchComNum"));
			}
			ResultSet rs = ps.executeQuery();
			List<Map> list = new ArrayList<Map>();
			while (rs.next()) {
				HashMap<String,String> hm1 = new HashMap<String,String>();
				hm1.put("ui_num", rs.getString("ui_num"));
				hm1.put("b_num", rs.getString("b_num"));
				hm1.put("content", rs.getString("content"));
				hm1.put("reg_date", rs.getString("reg_date"));		
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
