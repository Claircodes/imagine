package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAO {

	public List<HashMap> doSelect(String sql) {

		List<HashMap> userList = new ArrayList<HashMap>();
		try {
			Connection con = DBConn.getCon();
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery(); // 컬럼정보를 처음 읽음, 그래서 가지고 있음요,// 메타데이터
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

	public static void main(String[] args) {

		UserDAO ud = new UserDAO();
		String sql = "select num, id, pwd,name, age from user";
		List<HashMap> userList = ud.doSelect(sql);
		System.out.println("유저 리스트 -> " + userList);
		sql = "select num, id, pwd,name, age from user_info";
		userList = ud.doSelect(sql);
		System.out.println("유저인포 리스트 -> " + userList);
	}

}
