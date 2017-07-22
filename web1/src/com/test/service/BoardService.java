package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.common.DBConn;
import com.test.dto.BoardInfo;

public class BoardService {

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

	public boolean deleteBoard(BoardInfo bi) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn.getCon();
			String sql = "delete from board_info where binum= ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bi.getBinum());
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

	public boolean updateBoard(BoardInfo bi) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn.getCon();
			String sql = "UPDATE board_info SET bititle=?, bicontent=?, credat= NOW() WHERE binum= ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, bi.getBititle());
			ps.setString(2, bi.getBicontent());
			ps.setInt(3, bi.getBinum());

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

	private boolean checkPwd(String dbPwd, String pwd) {
		if (dbPwd.equals(pwd)) {
			return true;
		}
		return false;
	}

	public boolean isUserPwd(BoardInfo bi) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "select bipwd from board_info WHERE creusr=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, bi.getCreusr());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String bipwd = rs.getString("bipwd");
				return checkPwd(bipwd, bi.getBipwd());
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

	public BoardInfo searchUser(int boardNum) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "SELECT bititle,bicontent,bipwd,creusr,credat FROM board_info where binum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNum);
			ResultSet rs = ps.executeQuery();
			BoardInfo bi = new BoardInfo();
			while (rs.next()) {
				bi.setBititle(rs.getString("bititle"));
				bi.setBicontent(rs.getString("bicontent"));
				bi.setBipwd(rs.getString("bipwd"));
				bi.setCreusr(rs.getString("creusr"));
				bi.setDatetime(rs.getDate("credat").toString());
			}
			return bi;
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

	public List<BoardInfo> searchBoard() {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "SELECT binum,bititle,bicontent,bipwd,creusr,credat FROM board_info ORDER BY binum DESC";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<BoardInfo> boardlist = new ArrayList<BoardInfo>();
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
			return boardlist;
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
