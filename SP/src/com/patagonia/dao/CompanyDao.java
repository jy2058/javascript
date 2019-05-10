package com.patagonia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.patagonia.model.CompanyVO;
import com.patagonia.model.EmpVO;

public class CompanyDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String password = "q1w2e3r4";
	
	public CompanyVO select(CompanyVO vo) throws Exception{
		// 쿼리문 길어지니까 미리 써두기
		String query = "";
		query += "select ";
		query += "com.co_id, ";
		query += "com.co_name, ";
		query += "com.manager_id, ";
		query += "com.stock_yn, ";
		
		query += "com.co_tel, ";
		query += "com.co_ceo_name, ";
		query += "com.intime, ";
		query += "com.inid, ";
		query += "com.uptime, ";
		
		query += "com.upid, ";
		query += "e.sawon_name as manager_name ";
		query += "from ";
		query += "company com, ";
		query += "emp e ";
		query += "where ";
		
		query += "com.manager_id = e.sawon_id and ";
		query += "com.co_id = '"+vo.getCo_id()+"' ";
		query += " ";
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		CompanyVO resultVO = null;
		
		while(rs.next()){
			String co_id 		= rs.getString(1);
			String co_name 		= rs.getString(2);
			String manager_id 	= rs.getString(3);
			String stock_yn 	= rs.getString(4);
			String co_tel 		= rs.getString(5);
			
			String co_ceo_name 		= rs.getString(6);
			String intime 		= rs.getString(7);
			String inid 		= rs.getString(8);
			String uptime 		= rs.getString(9);
			String upid 		= rs.getString(10);
			
			String manager_name = rs.getString(11);
			
			resultVO = new CompanyVO();
			
			resultVO.setCo_id(co_id);
			resultVO.setCo_name(co_name);
			resultVO.setManager_id(manager_id);
			resultVO.setStock_yn(stock_yn);
			
			resultVO.setCo_tel(co_tel);
			resultVO.setCo_ceo_name(co_ceo_name);
			resultVO.setIntime(intime);
			resultVO.setInid(inid);
			resultVO.setUptime(uptime);
			resultVO.setUpid(upid);
			
			resultVO.setManager_name(manager_name);
			
		}
		
		rs.close();
		stmt.close();
		con.close();
		
		return resultVO;
	}
	
	
	public ArrayList<CompanyVO> selectList(CompanyVO vo) throws Exception{
		String query = "";
		query += "select ";
		query += "com.co_id, ";
		query += "com.co_name, ";
		query += "com.manager_id, ";
		query += "com.stock_yn, ";
		
		query += "com.co_tel, ";
		query += "com.co_ceo_name, ";
		query += "com.intime, ";
		query += "com.inid, ";
		query += "com.uptime, ";
		
		query += "com.upid, ";
		query += "e.sawon_name as manager_name ";
		query += "from ";
		query += "company com, emp e ";
		query += "where ";
		query += "com.manager_id = e.sawon_id ";
		
		
		
		
		
		System.out.println(query);
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		
		
		while(rs.next()){
			String co_id 		= rs.getString(1);
			String co_name 		= rs.getString(2);
			String manager_id 	= rs.getString(3);
			String stock_yn 	= rs.getString(4);
			String co_tel 		= rs.getString(5);
			
			String co_ceo_name 		= rs.getString(6);
			String intime 		= rs.getString(7);
			String inid 		= rs.getString(8);
			String uptime 		= rs.getString(9);
			String upid 		= rs.getString(10);
			String manager_name = rs.getString(11);
			
			CompanyVO companyvo = new CompanyVO();
			companyvo.setCo_id(co_id);
			companyvo.setCo_name(co_name);
			companyvo.setManager_id(manager_id);
			companyvo.setStock_yn(stock_yn);
			
			companyvo.setCo_tel(co_tel);
			companyvo.setCo_ceo_name(co_ceo_name);
			companyvo.setIntime(intime);
			companyvo.setInid(inid);
			companyvo.setUptime(uptime);
			companyvo.setUpid(upid);
			
			companyvo.setManager_name(manager_name);
			
			list.add(companyvo);
		}
		
		
		rs.close();
		stmt.close();
		con.close();
		
		return list;
		
	}
	
	public int insert(CompanyVO vo) throws Exception{
		String query = "";
		
		query += "insert into company ";
		query += "( ";
		query += "co_id, co_name, manager_id, stock_yn, co_tel, ";
		query += "co_ceo_name, intime, inid, uptime, upid ";
		query += ") ";
		
		query += "values ";
		query += "( ";
		query += "'"+vo.getCo_id()+"','"+vo.getCo_name()+"','"+vo.getManager_id()+"','"+vo.getStock_yn()+"',";
		query += "'"+vo.getCo_tel()+"','"+vo.getCo_ceo_name()+"',sysdate,'"+vo.getManager_id()+"',sysdate,'"+vo.getManager_id()+"' ";
		query += ") ";
		
		System.out.println(query);
		
		Class.forName(driver);		
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(query);
		
		stmt.close();
		con.close();
		
		return cnt;
	}
	
	public int update(CompanyVO vo) throws Exception{
		String query = "";
		query += "update company ";
		query += "set ";
		query += "co_name = '"+vo.getCo_name()+"', ";
		
		query += "manager_id = '"+vo.getManager_id()+"', ";
		query += "stock_yn = '"+vo.getStock_yn()+"', ";
		query += "co_tel = '"+vo.getCo_tel()+"', ";
		query += "co_ceo_name = '"+vo.getCo_ceo_name()+"', ";
		query += "uptime = sysdate, ";
		query += "upid = '"+vo.getManager_id()+"' ";
		
		query += "where ";
		query += "co_id = '"+vo.getCo_id()+"' ";
		
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
	
	public int delete (CompanyVO vo) throws Exception{
		String query = "delete from company where co_id = '"+vo.getCo_id()+"'";
		
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
		CompanyDao dao = new CompanyDao();
		CompanyVO vo = new CompanyVO();
		
		/*
		// select
		ArrayList<CompanyVO> list = dao.selectList(null);
		
		System.out.println("회사ID\t회사이름\t담당자ID\t상장여부\t전화번호\t사장\t입력시간\t입력인\t수정시간\t수정인ID");
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i).getCo_id()+"\t");
			System.out.print(list.get(i).getCo_name()+"\t");
			System.out.print(list.get(i).getManager_id()+"\t");
			System.out.print(list.get(i).getStock_yn()+"\t");
			System.out.print(list.get(i).getCo_tel()+"\t");
			System.out.print(list.get(i).getCo_ceo_name()+"\t");
			System.out.print(list.get(i).getIntime()+"\t");
			System.out.print(list.get(i).getInid()+"\t");
			System.out.print(list.get(i).getUptime()+"\t");
			System.out.print(list.get(i).getUpid()+"\t");
			
		}
		*/

		/*
		// insert
		vo.setCo_id("2");
		vo.setCo_name("2");
		vo.setManager_id("2");
		vo.setStock_yn("Y");
		
		vo.setCo_tel("22");
		vo.setCo_ceo_name("2");
		vo.setIntime("222");
		vo.setInid("2");
		vo.setUptime("2");
		vo.setUpid("2");
		
		int cnt = dao.insert(vo);
		System.out.println(cnt + "개를 추가 하였습니다.");
		*/
		
		
		/*
		// update
		vo.setCo_id("2");
		vo.setCo_name("23");
		vo.setManager_id("2");
		vo.setStock_yn("Y");
		
		vo.setCo_tel("22");
		vo.setCo_ceo_name("2");
		vo.setUptime("2");
		vo.setUpid("2");
		
		int cnt = dao.update(vo);
		System.out.println(cnt + "개가 수정 되었습니다.");
		*/
		
		
		// delete
		vo.setCo_id("1");
		int cnt = dao.delete(vo);
		System.out.println(cnt+"개가 삭제되었습니다.");
		
		}
	}


