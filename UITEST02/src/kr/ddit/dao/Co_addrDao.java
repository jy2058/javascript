package kr.ddit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import kr.ddit.vo.Co_addrVO;

public class Co_addrDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String password = "q1w2e3r4";
	
	public Co_addrVO select(Co_addrVO vo) throws Exception{
		String query ="";
		query += "select ";
		query += "	zipcode, ";
		query += "	city, ";
		query += "	gu, ";
		query += "	street, ";
		query += "	street_num, ";
		query += "	in_user, ";
		query += "	in_time, ";
		query += "	up_user, ";
		query += "	up_time ";
		query += "from ";
		query += "	co_addr ";
		query += "where ";
		query += "	zipcode = '"+vo.getZipcode()+"' ";
		
		System.out.println(query);
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		Co_addrVO resultVo = null;
		
		while (rs.next()) {
			String zipcode = rs.getString(1);
			String city = rs.getString(2);
			String gu = rs.getString(3);
			String street = rs.getString(4);
			String street_num = rs.getString(5);
			String in_user = rs.getString(6);
			String in_time = rs.getString(7);
			String up_user = rs.getString(8);
			String up_time = rs.getString(9);

			resultVo = new Co_addrVO();
			resultVo.setZipcode(zipcode);
			resultVo.setCity(city);
			resultVo.setGu(gu);
			resultVo.setStreet(street);
			resultVo.setStreet_num(street_num);
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
	
	public ArrayList<Co_addrVO> selectList(Co_addrVO vo) throws Exception{
		String query ="";
		query += "select ";
		query += "	zipcode, ";
		query += "	city, ";
		query += "	gu, ";
		query += "	street, ";
		query += "	street_num, ";
		query += "	in_user, ";
		query += "	in_time, ";
		query += "	up_user, ";
		query += "	up_time ";
		query += "from ";
		query += "	co_addr ";
		query += "where ";
		query += "	street like '%"+vo.getStreet()+"%' ";
		
		System.out.println(query);
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<Co_addrVO> list = new ArrayList<Co_addrVO>();
		
		while (rs.next()) {
			String zipcode = rs.getString(1);
			String city = rs.getString(2);
			String gu = rs.getString(3);
			String street = rs.getString(4);
			String street_num = rs.getString(5);
			String in_user = rs.getString(6);
			String in_time = rs.getString(7);
			String up_user = rs.getString(8);
			String up_time = rs.getString(9);
			
			Co_addrVO addrVo = new Co_addrVO();

			addrVo = new Co_addrVO();
			
			addrVo.setZipcode(zipcode);
			addrVo.setCity(city);
			addrVo.setGu(gu);
			addrVo.setStreet(street);
			addrVo.setStreet_num(street_num);
			addrVo.setIn_user(in_user);
			addrVo.setIn_time(in_time);
			addrVo.setUp_user(up_user);
			addrVo.setUp_time(up_time);
			
			list.add(addrVo);

		}

		rs.close();
		stmt.close();
		con.close();

		return list;
	}
	public static void main(String[] args) throws Exception {
		Co_addrVO vo = new Co_addrVO();
		vo.setStreet("대청");
		Co_addrDao dao = new Co_addrDao();
		 ArrayList<Co_addrVO> rVO = dao.selectList(vo);
		 System.out.println(rVO.get(0).getZipcode());
	}
	
}
