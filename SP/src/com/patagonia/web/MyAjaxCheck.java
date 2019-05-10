package com.patagonia.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.patagonia.dao.CompanyDao;
import com.patagonia.model.CompanyVO;

@WebServlet("/MyAjaxCheck")
public class MyAjaxCheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "ng";
		
		String co_id = request.getParameter("co_id");
		System.out.println("co_id : " + co_id);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		CompanyDao dao = new CompanyDao();
		CompanyVO vo = new CompanyVO();
		
		vo.setCo_id(co_id);

		try {
			CompanyVO rVO = dao.select(vo);
			
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
