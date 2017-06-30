package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class UserDAO {

	public List<HashMap> doSelect(String sql) {

		List<HashMap> userList = new ArrayList<HashMap>();
		try {

			Connection con = DBConn.getCon();
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery(); // 컬럼정보를 처음 읽음, 그래서 가지고 있음요,
													// 메타데이터
			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				HashMap hm = new HashMap();
				int colCount = rsmd.getColumnCount();

				for (int i = 1; i <= colCount; i++) {
					String colName = rsmd.getColumnName(i);
					hm.put(colName, rs.getString(colName));
				}
				userList.add(hm);
			}

			DBConn.closeCon();
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean doInsert(String sql, HashMap<String, String> hm) {
		try {
			Connection con = DBConn.getCon();
			String[] keys = hm.keySet().toArray(new String[hm.size()]);
			for(int i=0;i<keys.length;i++){
				sql += keys[i] + ",";
			}
			sql = sql.substring(0, sql.length()-1);
			sql += ") values(";

			for(int i=0;i<keys.length;i++){
				sql += "?,";
			}
			sql = sql.substring(0, sql.length()-1);
			sql += ")";
			PreparedStatement prestmt = con.prepareStatement(sql);
			for(int i=0;i<keys.length;i++){
				prestmt.setString(i+1, hm.get(keys[i]));
			}
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

		String s = "";
		UserDAO ud = new UserDAO();
		String sql = "INSERT INTO user_info ";

		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("id", "green");
		hm.put("pwd", "green1");
		hm.put("name", "green2");
		hm.put("age", "30");
		hm.put("class_num", "3");

		ud.doInsert(sql, hm);

		// sql = "select num, id, pwd,name, age from user_info";
		// userList = ud.doSelect(sql);
		// System.out.println("유저인포 리스트 -> " + userList);

		// hm(1, a.get("id"));
		// prestmt.setString(2, a.get("pwd"));
		// prestmt.setString(3, a.get("name"));
		// prestmt.setString(4, a.get("age"));
		//

	}

}
