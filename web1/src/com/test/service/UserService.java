package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn;
import com.test.dto.UserInfo;

public class UserService {

	public boolean insertUser(UserInfo ui) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "insert into user_info(userid,userpwd,username,age,address,hp1,hp2,hp3) ";
			sql += "values (?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, ui.getUserId());
			ps.setString(2, ui.getUserPwd());
			ps.setString(3, ui.getUserName());
			ps.setInt(4, ui.getAge());
			ps.setString(5, ui.getAddress());
			ps.setString(6, ui.getHp1());
			ps.setString(7, ui.getHp2());
			ps.setString(8, ui.getHp3());

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

	public boolean deleteUser(UserInfo ui) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn.getCon();
			String sql = "delete from user_info where usernum= ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ui.getUserNum());
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

	public boolean updateUser(UserInfo ui) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConn.getCon();
			String sql = "update user_info set username=?, userid=?, age=? where usernum= ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, ui.getUserName());
			ps.setString(2, ui.getUserId());
			ps.setInt(3, ui.getAge());
			ps.setInt(4, ui.getUserNum());

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

	// public List<Map> searchUser(HashMap<String, String> hm) {
	// Connection con = null;
	// PreparedStatement ps = null;
	// try {
	// con = DBConn.getCon();
	// String sql = "select id, pwd, name,class_num,age from user_info";
	// if (!hm.get("name").equals("")) {
	// sql += " WHERE name like ?";
	// }
	// ps = con.prepareStatement(sql);
	// if (!hm.get("name").equals("")) {
	// ps.setString(1, hm.get("name"));
	// }
	// ResultSet rs = ps.executeQuery();
	// ArrayList list = new ArrayList();
	// while (rs.next()) {
	// HashMap hm1 = new HashMap();
	// hm1.put("id", rs.getString("id"));
	// hm1.put("pwd", rs.getString("pwd"));
	// hm1.put("name", rs.getString("name"));
	// hm1.put("class_num", rs.getString("class_num"));
	// hm1.put("age", rs.getString("age"));
	// list.add(hm1);
	// }
	// return list;
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// ps.close();
	// DBConn.closeCon();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// return null;
	// }

	public String loginUser(UserInfo ui) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "select userid, userpwd from user_info WHERE userid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUserId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("userid");
				String userpwd = rs.getString("userpwd");
				return checkPwd(userpwd, ui.getUserPwd(), userId);
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
		return "아이디가 없습니다.";
	}

	private String checkPwd(String pwd1, String pwd2, String id) {
		if (pwd1.equals(pwd2)) {
			return "아이디" + id + "님이 로그인 하셨습니다.";
		}
		return "비밀번호 틀렸습니다.";
	}

	public List<UserInfo> selectUser(UserInfo ui) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select usernum,userid,username,userpwd,age,address,hp1,hp2,hp3 from user_info";
			if (ui.getUserName() != null && !ui.getUserName().equals("")){
				sql += " where username like ?";
			}
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			if (ui.getUserName() != null && !ui.getUserName().equals("")){
				ps.setString(1, ui.getUserName());
			}
			ResultSet rs = ps.executeQuery();
			List<UserInfo> userList = new ArrayList<UserInfo>();
			while (rs.next()) {
				UserInfo ui1 = new UserInfo();
				ui1.setUserNum(rs.getInt("usernum"));
				ui1.setUserId(rs.getString("userid"));
				ui1.setUserName(rs.getString("username"));
				ui1.setUserPwd(rs.getString("userpwd"));
				ui1.setAge(rs.getInt("age"));
				ui1.setAddress(rs.getString("address"));
				ui1.setHp1(rs.getString("hp1"));
				ui1.setHp2(rs.getString("hp2"));
				ui1.setHp3(rs.getString("hp3"));
				userList.add(ui1);
			}
			return userList;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
