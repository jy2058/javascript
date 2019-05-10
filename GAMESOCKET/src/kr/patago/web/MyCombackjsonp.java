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
@WebServlet("/mycomback_jsonp")
public class MyCombackjsonp extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
	
		PrintWriter out = response.getWriter();
		
		OmokServiceImpl omokService = OmokServiceImpl.getInstance();
		try {
			ArrayList<OmokVO> list = (ArrayList<OmokVO>) omokService.selectListPan();
			
			String text_pre = "[";
			String text = "";
			String text_post = "]";
			
			for(int i = 0; i < list.size(); i++){
				String pan = list.get(i).getPan();
				text+="{\"pan\" : \""+pan+"\"},";
			}
			if(list.size() > 0){
				text = text.substring(0, text.length()-1);
			}
			
			out.print("myCallback(");
			out.print(text_pre);
			out.print(text);
			out.print(text_post);
			out.print(")");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
