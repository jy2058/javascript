package kr.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ddit.dao.CarDao;
import kr.ddit.vo.CarVO;
@WebServlet("/myselect03")

public class MySelect03 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("myselect03");
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
		
	try {
				
				PrintWriter out = response.getWriter();
				String param1 = request.getParameter("param1");
				System.out.println(param1);
				
				CarDao cDao = new CarDao();
				CarVO cVo = new CarVO();
				
				cVo.setCar_code(param1);
				CarVO rVO = cDao.Select(cVo);
				
				String text_pre = "[";
				String text = "";
				String text_post = "]";
				
				text += "{\"car_name\":\"" + rVO.getCar_name() 
			               + "\",\"maker_name\":\"" + rVO.getMaker_name()
			               + "\",\"fuel_type\":\"" + rVO.getFuel_type()
			               + "\",\"cc\":\"" + rVO.getCc()
			               + "\",\"yunbi\":\"" + rVO.getYunbi()
			               + "\",\"debut\":\"" + rVO.getDebut()
			               + "\"}";
				
				out.print(text_pre);
				out.print(text);
				out.print(text_post);
			
			}catch (Exception e) {
				e.printStackTrace();
			}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
