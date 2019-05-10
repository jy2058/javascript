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
import kr.ddit.dao.MakerDao;
import kr.ddit.vo.CarVO;
import kr.ddit.vo.MakerVO;
@WebServlet({"/MySelect02","/myselect02"})

public class MySelect02 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("myselect02");
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
		
		try {
			
			PrintWriter out = response.getWriter();
			String param1 = request.getParameter("param1");
			System.out.println(param1);
			
			CarDao cDao = new CarDao();
			CarVO cVo = new CarVO();
			cVo.setMaker_code(param1);
			
			ArrayList<CarVO> list = cDao.selectList(cVo);
			
			String text_pre = "[";
			String text = "";
			String text_post = "]";
			
			for(int i = 0; i < list.size(); i++){
				String car_code = list.get(i).getCar_code();
				String car_name = list.get(i).getCar_name();
				
				text += "{\"car_code\":\""+car_code+"\",\"car_name\":\""+car_name+"\"},";
			}
			if(list.size() > 0){
				text = text.substring(0, text.length()-1);
			}
			
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
