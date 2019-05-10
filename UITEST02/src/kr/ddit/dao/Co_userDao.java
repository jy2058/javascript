package kr.ddit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.ddit.vo.Co_userVO;

public class Co_userDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String password = "q1w2e3r4";
	
	public Co_userVO select(Co_userVO vo) throws Exception{
		String query ="";
		query += "select ";
		query += "	co_id, ";
		query += "	co_name, ";
		query += "	pwd, ";
		query += "	zipcode, ";
		query += "	addr1, ";
		query += "	addr2, ";
		query += "	in_user, ";
		query += "	in_time, ";
		query += "	up_user, ";
		query += "	up_time ";
		query += "from ";
		query += "	co_user ";
		query += "where ";
		query += "	co_id = '"+vo.getCo_id()+"' ";
		
		System.out.println(query);
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		Co_userVO resultVo = null;
		
		while (rs.next()) {
			String co_id = rs.getString(1);
			String co_name = rs.getString(2);
			String pwd = rs.getString(3);
			String zipcode = rs.getString(4);
			String addr1 = rs.getString(5);
			String addr2 = rs.getString(6);
			String in_user = rs.getString(7);
			String in_time = rs.getString(8);
			String up_user = rs.getString(9);
			String up_time = rs.getString(10);

			resultVo = new Co_userVO();
			resultVo.setCo_id(co_id);
			resultVo.setCo_name(co_name);
			resultVo.setPwd(pwd);
			resultVo.setZipcode(zipcode);
			resultVo.setAddr1(addr1);
			resultVo.setAddr2(addr2);
			resultVo.setIn_user(in_user);
			resultVo.setIn_time(in_time);
			resultVo.setUp_user(up_user);
			resultVo.setUp_time(up_time);

		}

		rs.close();
		stmt.close();
		con.close();

		return resultVo;
	}
	public static void main(String[] args) throws Exception {
		Co_userVO vo = new Co_userVO();
		vo.setCo_id("aaa");
		Co_userDao dao = new Co_userDao();
		Co_userVO rVO = dao.select(vo);
		 System.out.println(rVO.getPwd());
	}

}
