package com.patagonia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest03_Upd {
	public static void main(String[] args) throws Exception {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "patagonia";
		String password = "q1w2e3r4";
		
		String query = "update pata set col2 = '2', col3 = '3' where col1 = '1'";

		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(query);
		System.out.println("cnt : " + cnt);
	
		stmt.close();
		con.close();
	}
}
