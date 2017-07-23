package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn;
import com.test.dto.BoardInfo;

public class BoardService {

	public boolean insertBoard(BoardInfo bi) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "INSERT INTO board_info (bititle,bicontent,bipwd,creusr,credat) ";
			sql += "VALUES (?,?,?,?, NOW())";
			ps = con.prepareStatement(sql);

			ps.setString(1, bi.getBititle());
			ps.setString(2, bi.getBicontent());
			ps.setString(3, bi.getBipwd());
			ps.setString(4, bi.getCreusr());
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
//	public List<BoardInfo> selectUser(BoardInfo bi, String searchname) {
//		Connection con = null;
//		PreparedStatement ps = null;
//		try {
//			String sql = "SELECT bititle,bicontent,bipwd,creusr,credat FROM board_info ";
//			if (searchname != null && !searchname.equals("")){
//				sql += "where ? like ?";
//			}
//			con = DBConn.getCon();
//			ps = con.prepareStatement(sql);
//			if (searchname != null && !searchname.equals("")){
//				ps.setString(1, searchname);
//				if (searchname.equals("bititle")){
//					ps.setString(2, "%"+bi.getBititle()+"%");
//				}else if(searchname.equals("bicontent")) {
//					ps.setString(2, "%"+bi.getBicontent()+"%");
//				}else if(searchname.equals("creusr")){
//					ps.setString(2, "%"+bi.getCreusr()+"%");
//				}
//			}
//			ResultSet rs = ps.executeQuery();
//			List<BoardInfo> boardList = new ArrayList<BoardInfo>();
//			while (rs.next()) {
//				BoardInfo bi1 = new BoardInfo();
//				bi1.setUserNum(rs.getInt("usernum"));
//				bi1.setUserId(rs.getString("userid"));
//				bi1.setUserName(rs.getString("username"));
//				bi1.setUserPwd(rs.getString("userpwd"));
//				bi1.setAge(rs.getInt("age"));
//				bi1.setAddress(rs.getString("address"));
//				bi1.setHp1(rs.getString("hp1"));
//				bi1.setHp2(rs.getString("hp2"));
//				bi1.setHp3(rs.getString("hp3"));
//				boardList.add(bi1);
//			}
//			return boardList;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				ps.close();
//				DBConn.closeCon();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//	function doSelect() {
//		var sel = document.getElementById("sel");
//		var val = sel.options[sel.selectedIndex].id;
//		var str=document.getElementById("searchstr").value;
//		var params = "?";
//		if (val!="searchname"){
//			params += "searchname="+id+"&";
//			params += id+"="+str+"&";
//		}
//			params += "command=SELECT&";
//
//			var au = new AjaxUtil(params);
//			au.changeCallBack(function() {
//						if (au.xhr.readyState == 4) {
//							if (au.xhr.status == 200) {
//								var result = decodeURIComponent(au.xhr.responseText);
//								alert(result);
//							} else {
//								document.getElementById("board_div").innerHTML = au.xhr.responseText;
//							}
//						}
//					});
//			au.send();
//		}

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
