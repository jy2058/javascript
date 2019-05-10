package com.patagonia.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet") //경로
public class MyServlet extends HttpServlet {
	
	// doGet 은 주소창에 매개변수 값이 보인다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");

		//CGI 프로그래밍 방식(Common GateWay Interface)
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");

		out.print("Hello Servlet");
		
		out.print("</body>");
		
		out.print("<html>");
		out.print("</html>");
	}
	
	// doPost 는 주소창에 매개변수 값이 안 보인다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		String myname = request.getParameter("myname");
		System.out.println("myname: " + myname);
	}

}
