package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Exam {

	private static Scanner s;

	public List<String> getUserIDList(String name) {
		List<String> userlist = new ArrayList<String>();
		try {
			Connection con = DBConn.getCon(); // 디비에게 전화
			String sql = "SELECT id,pwd,name,age FROM USER ";
			if (!name.equals("")) {
				sql += "WHERE name= '" + name + "'";
			}
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {
				userlist.add(
						rs.getString(1) + " , " + rs.getString(2) + " , " + rs.getString(3) + " , " + rs.getInt(4));
			}
			DBConn.closeCon();
			return userlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertUser() {
		try {
			Connection con = DBConn.getCon();
			String sql = "INSERT INTO USER (id , pwd, name, age) VALUES ('blue','blue','청길동', 40)";
			PreparedStatement prestmt = con.prepareStatement(sql); // 쿼리창을 만들어서
																	// 쿼리 창에 적기만
																	// 한것
			int result = prestmt.executeUpdate(); // 실행
			DBConn.closeCon();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertUser(HashMap<String, String> a) {
		try {
			Connection con = DBConn.getCon();
			String sql = "INSERT INTO USER (id , pwd, name, age) VALUES ('" + a.get("id") + "','" + a.get("pwd") + "','"
					+ a.get("name") + "', '" + Integer.parseInt(a.get("age")) + "')";
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn.closeCon();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(int i) {
		try {
			Connection con = DBConn.getCon();
			String sql = "DELETE FROM USER WHERE num=" + i;
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn.closeCon();
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUsername(String name, int i) {
		try {
			Connection con = DBConn.getCon();
			String sql = "UPDATE USER SET name='" + name + "' WHERE num ='" + i + "';";
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
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
		Exam e = new Exam();

		s = new Scanner(System.in);
		// ArrayList<HashMap> al = new ArrayList<HashMap>();
		HashMap<String, String> hm = new HashMap<>();

		hm.put("id", s.nextLine());
		hm.put("pwd", s.nextLine());
		hm.put("name", s.nextLine());
		hm.put("age", s.nextLine());

		e.insertUser(hm);

		List<String> userList = e.getUserIDList("");
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		}
	}
}
