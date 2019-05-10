package com.patagonia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.patagonia.model.EmpVO;

public class EmpDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String password = "q1w2e3r4";
	
	public EmpVO OneSelEmp(EmpVO vo) throws Exception{
		// 쿼리문 길어지니까 미리 써두기
		String query = ""; // 공백 넣아야 됨 / 안 넣으면 붙은 걸로 인식해서 오류남 
		query += "select ";
		query += "	sawon_id, ";
		query += "	sawon_name, ";
		query += "	mobile, ";
		query += "	email, ";
		query += "	ins_date, ";
		query += "	ins_id, ";
		query += "	upd_date, ";
		query += "	upd_id ";
		query += "from ";
		query += "	emp ";
		query += "where ";
		query += "	sawon_id = '"+vo.getSawon_id()+"' ";
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		EmpVO resultVO = new EmpVO();
		
		while(rs.next()){
			String sawon_id 	= rs.getString(1);
			String sawon_name 	= rs.getString(2);
			String mobile 		= rs.getString(3);
			String email 		= rs.getString(4);
			
			String ins_date 	= rs.getString(5).substring(0,10);
			String ins_id 		= rs.getString(6);
			String upd_date 	= rs.getString(7).substring(0,10);
			String upd_id 		= rs.getString(8);
			
			resultVO.setSawon_id(sawon_id);
			resultVO.setSawon_name(sawon_name);
			resultVO.setMobile(mobile);
			resultVO.setEmail(email);
			
			resultVO.setIns_date(ins_date);
			resultVO.setIns_id(ins_id);
			resultVO.setUpd_date(upd_date);
			resultVO.setUpd_id(upd_id);
			
		}
		
		rs.close();
		stmt.close();
		con.close();
		
		return resultVO;
	}
	
	public ArrayList<EmpVO> selEmp(EmpVO vo) throws Exception{
		// 쿼리문 길어지니까 미리 써두기
		String query = ""; // 공백 넣아야 됨 / 안 넣으면 붙은 걸로 인식해서 오류남 
		query += "select ";
		query += "	sawon_id, ";
		query += "	sawon_name, ";
		query += "	mobile, ";
		query += "	email, ";
		query += "	ins_date, ";
		query += "	ins_id, ";
		query += "	upd_date, ";
		query += "	upd_id ";
		query += "from ";
		query += "	emp ";
		
		
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			String sawon_id 	= rs.getString(1);
			String sawon_name 	= rs.getString(2);
			String mobile 		= rs.getString(3);
			String email 		= rs.getString(4);
			
			String ins_date 	= rs.getString(5).substring(0,10);
			String ins_id 		= rs.getString(6);
			String upd_date 	= rs.getString(7).substring(0,10);
			String upd_id 		= rs.getString(8);
			
			EmpVO tempvo = new EmpVO();
			tempvo.setSawon_id(sawon_id);
			tempvo.setSawon_name(sawon_name);
			tempvo.setMobile(mobile);
			tempvo.setEmail(email);
			
			tempvo.setIns_date(ins_date);
			tempvo.setIns_id(ins_id);
			tempvo.setUpd_date(upd_date);
			tempvo.setUpd_id(upd_id);
			
			list.add(tempvo);
		}
		
		rs.close();
		stmt.close();
		con.close();
		
		return list;
	}
	
	public int insEmp(EmpVO vo) throws Exception{
		String query = "";
		
		query += "insert into emp ";
		query += "( ";
		query += "sawon_id, sawon_name, mobile, email, ";
		query += "ins_date, ins_id, upd_date, upd_id ";
		query += ") ";
		
		query += "values ";
		query += "( ";
		query += "'"+vo.getSawon_id()+"','"+vo.getSawon_name()+"','"+vo.getMobile()+"','"+vo.getEmail()+"', ";
		query += "sysdate,'"+vo.getSawon_id()+"',sysdate,'"+vo.getSawon_id()+"' ";
		query += ") ";
		
		
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(query);
		
		stmt.close();
		con.close();
		
		return cnt;
	}
	
	public int updEmp(EmpVO vo) throws Exception{
		String query = "";
		query += "update emp ";
		query += "set ";
		query += "sawon_name = '"+vo.getSawon_name()+"', ";
		
		query += "mobile = '"+vo.getMobile()+"', ";
		query += "email = '"+vo.getEmail()+"', ";
		
		query += "upd_date = sysdate, ";
		query += "upd_id = "+vo.getSawon_id()+" ";
		query += "where ";
		query += "sawon_id = '"+vo.getSawon_id()+"' ";
		
		System.out.println(query);
		
		 
		Class.forName(driver);

		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(query);
		
		System.out.println("cnt : " + cnt);

		stmt.close();
		con.close();

		return cnt;

	}
	
	public int delEmp(EmpVO vo) throws Exception{
		String query = "delete from emp where sawon_id = '"+vo.getSawon_id()+"'";
		
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
		EmpDao dao = new EmpDao();
		EmpVO vo = new EmpVO();
		
		/*
		// select
		ArrayList<EmpVO> list = dao.selEmp(null);
		
		System.out.println("사번\t이름\t전화번호\t이메일\t\t입력날짜\t입력ID\t업데이트날짜\t업데이트ID");
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i).getSawon_id()+"\t");
			System.out.print(list.get(i).getSawon_name()+"\t");
			System.out.print(list.get(i).getMobile()+"\t");
			System.out.print(list.get(i).getEmail()+"\t");
			System.out.print(list.get(i).getIns_date()+"\t");
			System.out.print(list.get(i).getIns_id()+"\t");
			System.out.print(list.get(i).getUpd_date()+"\t");
			System.out.print(list.get(i).getUpd_id()+"\t");
		}
		*/

		
		// insert
		vo.setSawon_id("1");
		vo.setSawon_name("김지연");
		vo.setMobile("111-1111-1111");
		vo.setEmail("asd@naver.com");
		
		vo.setIns_date("18/11/27");
		vo.setIns_id("1");
		vo.setUpd_date("18/11/27");
		vo.setUpd_id("1");
		
		int cnt = dao.insEmp(vo);
		System.out.println(cnt + "개를 추가 하였습니다.");
		
		
		
		/*
		// update
		vo.setSawon_id("1");
		vo.setSawon_name("김지연");
		vo.setMobile("111-1213-1144");
		vo.setEmail("df@naver.com");
		
		vo.setIns_id("1");
		vo.setUpd_id("1");
		
		int cnt = dao.updEmp(vo);
		System.out.println(cnt + "개가 수정 되었습니다.");
		*/
		
		/*
		// delete
		vo.setSawon_id("1");
		int cnt = dao.delEmp(vo);
		System.out.println(cnt+"개가 삭제되었습니다.");
		*/
		}

}
