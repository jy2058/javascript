package com.patagonia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OracleDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String password = "q1w2e3r4";
	
	//PataVo = MVC 패턴(Model View Controller) 
	// Model = VO // View = JSP // Controller = Servlet 
	public ArrayList<PataVO> getPata() throws Exception{
		
		ArrayList<PataVO> list = new ArrayList<>();
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select col1, col2, col3 from pata");
		
		while(rs.next()){
			String col1 = rs.getString(1);
			String col2 = rs.getString(2);
			String col3 = rs.getString(3);
			
			PataVO vo = new PataVO();
			vo.setCol1(col1);
			vo.setCol2(col2);
			vo.setCol3(col3);
			
			list.add(vo);
		}
		rs.close();
		stmt.close();
		con.close();
		
		return list;
		
	}
	
	public int insPata(PataVO vo) throws Exception{
		
		String query = "insert into pata (col1, col2, col3) values ('"+vo.getCol1()+"','"+vo.getCol2()+"','"+vo.getCol3()+"')";
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(query);
	
		stmt.close();
		con.close();
		
		return cnt;
	}
	
	public int updPata(PataVO vo) throws Exception{
		
		String query = "update pata set col2 = '"+vo.getCol2()+"', col3 = '"+vo.getCol3()+"' where col1 = '"+vo.getCol1()+"'";

		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(query);
		System.out.println("cnt : " + cnt);
	
		stmt.close();
		con.close();
		
		return cnt;
	}
	
	public int delPata(PataVO vo) throws Exception{
		
		String query = "delete from pata where col1 = '"+vo.getCol1()+"'";
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(query);
		System.out.println("cnt : " + cnt);
	
		stmt.close();
		con.close();
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		OracleDao dao = new OracleDao();
		 
		
		/*  //ArrayList<PataVO> getPata() //select문 
		ArrayList<PataVO> list = dao.getPata();
		System.out.println("사번\t이름\t연봉");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).getCol1()+"\t"+list.get(i).getCol2()+"\t"+list.get(i).getCol3());
		*/
		
		
		/*//insPata(PataVO vo) // insert 문
		PataVO vo = new PataVO();
		vo.setCol1("1001");
		vo.setCol2("김지연");
		vo.setCol3("1억");
		
		int cnt = dao.insPata(vo);
		System.out.println(cnt + "개 적용되었습니다.");
		*/
		
		/* updPata(PataVO vo) // update 문
		PataVO vo = new PataVO();
		vo.setCol1("2");
		vo.setCol2("3");
		vo.setCol3("7");
		
		int cnt = dao.updPata(vo);
		System.out.println(cnt + "개 적용되었습니다.");
		*/
		
		//delPata(PataVO vo) // delete 문
		PataVO vo = new PataVO();
		vo.setCol1("김");
		int cnt = dao.delPata(vo);
		System.out.println(cnt + " 개가 삭제 되었습니다.");
		}
		
	}


