package kr.patago.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.patago.service.OmokServiceImpl;
import kr.patago.vo.OmokVO;


@WebServlet("/myselpan")
public class MySelPan extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("myselpan");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String p_pan = request.getParameter("pan");
		System.out.println("p_pan: " + p_pan);
	  
        OmokVO p_vo = new OmokVO();
        p_vo.setPan(p_pan);
        
	
		PrintWriter out = response.getWriter();
		
		OmokServiceImpl omokService = OmokServiceImpl.getInstance();
		try {
			ArrayList<OmokVO> list = (ArrayList<OmokVO>) omokService.selectListPans(p_vo);
			
			String text_pre = "[";
			String text = "";
			String text_post = "]";
			
			for(int i = 0; i < list.size(); i++){
				String pan = list.get(i).getPan();
				String pan_order = list.get(i).getPan_order();
				String history = list.get(i).getHistory();
				String winner = list.get(i).getWinner();
				
				text+="{\"pan\" : \""+pan+"\",\"pan_order\":\""+pan_order+"\",\"history\":\""+history+"\",\"winner\":\""+winner+"\"},";
			}
			
			if(list.size() > 0){
				text = text.substring(0, text.length()-1);
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
