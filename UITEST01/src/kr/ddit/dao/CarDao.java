package kr.ddit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import kr.ddit.vo.CarVO;

public class CarDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String password = "q1w2e3r4";
	
	public CarVO Select(CarVO vo) throws Exception{
		String query = "";  
		query += "select ";
		query += "	c.car_code, ";
		query += "	c.car_name, ";
		query += "	c.maker_code, ";
		query += "	c.fuel_type, ";
		query += "	c.cc, ";
		query += "	c.yunbi, ";
		query += "	c.debut, ";
		query += "	c.in_date, ";
		query += "	c.in_user, ";
		query += "	c.up_date, ";
		query += "	c.up_user, ";
		query += "	m.maker_name ";
		query += "from ";
		query += "	car c, maker m ";
		query += "where ";
		query += "	car_code = '"+vo.getCar_code()+"' ";
		query += "and ";
		query += "	c.maker_code = m.maker_code ";
		
		System.out.println(query);
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		CarVO resultVo = null;
		
		while (rs.next()) {
			String car_code = rs.getString(1);
			String car_name = rs.getString(2);
			String maker_code = rs.getString(3);
			String fuel_type = rs.getString(4);
			String cc = rs.getString(5);
			String yunbi = rs.getString(6);
			String debut = rs.getString(7);
			String in_date = rs.getString(8);
			String in_user = rs.getString(9);
			String up_date = rs.getString(10);
			String up_user = rs.getString(11);
			String maker_name = rs.getString(12);

			resultVo = new CarVO();
			resultVo.setCar_code(car_code);
			resultVo.setCar_name(car_name);
			resultVo.setMaker_code(maker_code);
			resultVo.setFuel_type(fuel_type);
			resultVo.setCc(cc);
			resultVo.setYunbi(yunbi);
			resultVo.setDebut(debut);
			resultVo.setIn_date(in_date);
			resultVo.setIn_user(in_user);
			resultVo.setUp_date(up_date);
			resultVo.setUp_user(up_user);
			resultVo.setMaker_name(maker_name);

		}

		rs.close();
		stmt.close();
		con.close();

		return resultVo;
	}
	
	public ArrayList<CarVO> selectList(CarVO vo) throws Exception{
		String query = "";  
		query += "select ";
		query += "	car_code, ";
		query += "	car_name, ";
		query += "	maker_code, ";
		query += "	fuel_type, ";
		query += "	cc, ";
		query += "	yunbi, ";
		query += "	debut, ";
		query += "	in_date, ";
		query += "	in_user, ";
		query += "	up_date, ";
		query += "	up_user ";
		query += "from ";
		query += "	car ";
		query += "where ";
		query += "	maker_code = '"+vo.getMaker_code()+"' ";
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		
		while (rs.next()) {
			String car_code = rs.getString(1);
			String car_name = rs.getString(2);
			String maker_code = rs.getString(3);
			String fuel_type = rs.getString(4);
			String cc = rs.getString(5);
			
			String yunbi = rs.getString(6);
			String debut = rs.getString(7);
			String in_date = rs.getString(8);
			String in_user = rs.getString(9);
			String up_date = rs.getString(10);
			String up_user = rs.getString(11);
			
			CarVO carvo = new CarVO();

			carvo.setCar_code(car_code);
			carvo.setCar_name(car_name);
			carvo.setMaker_code(maker_code);
			carvo.setFuel_type(fuel_type);
			carvo.setCc(cc);
			carvo.setYunbi(yunbi);
			carvo.setDebut(debut);
			carvo.setIn_date(in_date);
			carvo.setIn_user(in_user);
			carvo.setUp_date(up_date);
			carvo.setUp_user(up_user);

			list.add(carvo);
		}
		
		rs.close();
		stmt.close();
		con.close();
		
		return list;
	}
	
	public static void main(String[] args) throws Exception {
		CarDao dao = new CarDao();
		
		CarVO vo = new CarVO();
		vo.setCar_code("HDAV");
		 CarVO rDao =  dao.Select(vo);
		 rDao.getFuel_type();
		
	}
}
