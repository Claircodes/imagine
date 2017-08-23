package com.test.exam;

import java.sql.Connection;
import java.util.*;

import com.test.common.DBConn;

public class exam {
	public static void main(String[] args) {
		Connection con;
		try {
			Properties pro = DBConn.getPro();
			Class.forName(pro.getProperty("db.driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
