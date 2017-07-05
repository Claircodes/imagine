package com.test.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	private static Connection con;

	public static Connection getCon() throws Exception { // throws ClassNotFoundException,SQLException
		if (con == null) {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/iot_test", "root", "clair89101");
			con.setAutoCommit(false);
		}
		return con;
	}

	public static void closeCon() throws Exception {
		if (con != null) {
			con.close();
			con = null;
		}
	}
}
