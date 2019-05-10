package kr.ddit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import kr.ddit.vo.MakerVO;

public class MakerDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String password = "q1w2e3r4";
	
	public MakerVO select(MakerVO vo) throws Exception{
		String query = "";  
		query += "select ";
		query += "	maker_code, ";
		query += "	maker_name, ";
		query += "	in_date, ";
		query += "	in_user, ";
		query += "	up_date, ";
		query += "	up_user, ";
		query += "from ";
		query += "	maker ";
		query += "where ";
		query += "	maker_code = '"+vo.getMaker_code()+"' ";
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		MakerVO resultVo = null;
		
		while (rs.next()) {
			String maker_code = rs.getString(1);
			String maker_name = rs.getString(2);
			String in_date = rs.getString(3);
			String in_user = rs.getString(4);
			String up_date = rs.getString(5);
			String up_user = rs.getString(6);

			resultVo = new MakerVO();
			resultVo.setMaker_code(maker_code);
			resultVo.setMaker_name(maker_name);
			resultVo.setIn_date(in_date);
			resultVo.setIn_user(in_user);
			resultVo.setUp_date(up_date);
			resultVo.setUp_user(up_user);

		}

		rs.close();
		stmt.close();
		con.close();

		return resultVo;
		
	}
	public ArrayList<MakerVO> selectList(MakerVO vo) throws Exception{
		String query = "";  
		query += "select ";
		query += "	maker_code, ";
		query += "	maker_name, ";
		query += "	in_date, ";
		query += "	in_user, ";
		query += "	up_date, ";
		query += "	up_user ";
		query += "from ";
		query += "	maker ";
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<MakerVO> list = new ArrayList<MakerVO>();
		
		while (rs.next()) {
			String maker_code = rs.getString(1);
			String maker_name = rs.getString(2);
			String in_date = rs.getString(3);
			String in_user = rs.getString(4);
			String up_date = rs.getString(5);
			String up_user = rs.getString(6);

			MakerVO tempVo = new MakerVO();
			tempVo.setMaker_code(maker_code);
			tempVo.setMaker_name(maker_name);
			tempVo.setIn_date(in_date);
			tempVo.setIn_user(in_user);
			tempVo.setUp_date(up_date);
			tempVo.setUp_user(up_user);
			
			list.add(tempVo);

		}

		rs.close();
		stmt.close();
		con.close();

		
		return list;
	}
	
	public static void main(String[] args) throws Exception {
		MakerDao dao = new MakerDao();
		
		ArrayList<MakerVO> list = dao.selectList(null);
		
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).getMaker_code());
		}
	}

}
