package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn;

public class BoardService1 {

	public boolean insertBoard(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "insert into board (TITLE, CONTENT, WRITER, REG_DATE)";
			sql += "values (?,?,?,now())";
			ps = con.prepareStatement(sql);

			ps.setString(1, hm.get("title"));
			ps.setString(2, hm.get("content"));
			ps.setString(3, hm.get("nserNum"));
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

	public boolean deleteBoard(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn.getCon();
			String sql = "delete from board where Num= ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("boardNum"));
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

	public boolean updateBoard(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn.getCon();
			String sql = "update board set TITLE=?, CONTENT=?, REG_DATE=now() where num= ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, hm.get("boardTitle"));
			ps.setString(2, hm.get("boardContent"));
			ps.setString(3, hm.get("boardNum"));

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
	public List<Map> searchBoard(HashMap<String, String> hm) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "SELECT NUM,TITLE, CONTENT, WRITER, REG_DATE FROM board";
			if (!hm.get("boardNum").equals("")) {
				sql += " WHERE NUM like ?";
			}
			ps = con.prepareStatement(sql);
			if (!hm.get("boardNum").equals("")) {
				ps.setString(1, hm.get("boardNum"));
			}
			ResultSet rs = ps.executeQuery();
			List<Map> list = new ArrayList<Map>();
			while (rs.next()) {
				HashMap<String, String> hm1 = new HashMap<String, String>();
				hm1.put("NUM", rs.getString("NUM"));
				hm1.put("TITLE", rs.getString("TITLE"));
				hm1.put("CONTENT", rs.getString("CONTENT"));
				hm1.put("WRITER", rs.getString("WRITER"));
				hm1.put("REG_DATE", rs.getString("REG_DATE"));
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
