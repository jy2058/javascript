<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>patagonia</title>
	</head>
	<body>
		<a href="http://localhost:8080/SP/04_gugudan.jsp?dan=2">2단</a>
		<a href="http://localhost:8080/SP/04_gugudan.jsp?dan=3">3단</a>
		<a href="http://localhost:8080/SP/04_gugudan.jsp?dan=4">4단</a>
		<a href="http://localhost:8080/SP/04_gugudan.jsp?dan=5">5단</a>
		<a href="http://localhost:8080/SP/04_gugudan.jsp?dan=6">6단</a>
		<a href="http://localhost:8080/SP/04_gugudan.jsp?dan=7">7단</a>
		<a href="http://localhost:8080/SP/04_gugudan.jsp?dan=8">8단</a>
		<a href="http://localhost:8080/SP/04_gugudan.jsp?dan=9">9단</a></br>
		
		<%

			int dan = Integer.parseInt(request.getParameter("dan"));
			out.print(dan + "단" + "<br>");
			for (int i = 1; i < 10; i++) {
				out.println(dan + " * " + i + "=" + (dan * i) + "<br>");
			}
		%>

<!--  
		<% for (int i = 1; i < 10; i++) {%>
		<%=dan + " * " + i + "=" + (dan * i) + "<br>" %>
		<%} %>
-->
	</body>
</html>



