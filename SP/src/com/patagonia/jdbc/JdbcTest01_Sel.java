package com.patagonia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest01_Sel {
	public static void main(String[] args) throws Exception { //select 예제
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "patagonia";
		String password = "q1w2e3r4";
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select col1, col2, col3 from pata");
		
		while(rs.next()){
			String col1 = rs.getString(1);
			String col2 = rs.getString(2);
			String col3 = rs.getString(3);
			
			System.out.println("col1:" + col1);
			System.out.println("col2:" + col2);
			System.out.println("col3:" + col3);
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
