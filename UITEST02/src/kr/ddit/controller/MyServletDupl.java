package kr.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ddit.dao.Co_userDao;
import kr.ddit.vo.Co_userVO;

@WebServlet("/myservletdupl")
public class MyServletDupl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				String message = "ng";
				
				String co_id = request.getParameter("co_id");
				System.out.println("co_id : " + co_id);
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				
				PrintWriter out = response.getWriter();
				
				Co_userDao dao = new Co_userDao();
				Co_userVO vo = new Co_userVO();
				
				vo.setCo_id(co_id);
		
				try {
					Co_userVO rVO = dao.select(vo);
					
					if (rVO == null) {
						message = "OK";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				out.print("{\"message\" :\"" + message +"\"}");
		}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
