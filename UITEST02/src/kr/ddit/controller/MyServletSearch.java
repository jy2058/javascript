package kr.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ddit.dao.Co_addrDao;
import kr.ddit.vo.Co_addrVO;

@WebServlet("/myservletsearch")
public class MyServletSearch extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("myservletsearch");
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String instreet = request.getParameter("param");
		System.out.println("param" + instreet);
		
		Co_addrDao dao = new Co_addrDao();
		Co_addrVO vo = new Co_addrVO();
		
		vo.setStreet(instreet);

		try {
			ArrayList<Co_addrVO> rVO = dao.selectList(vo);

			String text_pre = "[";
			String text = "";
			String text_post = "]";

			for (int i = 0; i < rVO.size(); i++) {
				String zipcode = rVO.get(i).getZipcode();
				String city = rVO.get(i).getCity();
				String gu = rVO.get(i).getGu();
				String street = rVO.get(i).getStreet();
				String street_num = rVO.get(i).getStreet_num();
				
				text += "{\"zipcode\":\"" + zipcode 
						+ "\", \"city\":\"" + city
						+ "\", \"gu\":\"" + gu
						+ "\", \"street\":\"" + street
						+ "\", \"street_num\":\"" + street_num
						+ "\"},";
			}

			if (rVO.size() > 0) {
				text = text.substring(0, text.length() - 1);
			}

			out.print(text_pre);
			out.print(text);
			out.print(text_post);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
