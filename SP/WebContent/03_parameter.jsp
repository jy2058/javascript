<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>patagonia</title>
	</head>
	<body>
		<% 
		String myname = request.getParameter("myname"); // 주소창에 파라미터 이름을 적어주는 것!
		out.print("myname: " + myname); // ?myname=jy 이렇게 주소창 뒤에 적어준다. 그럼 jy가 리턴 돼서 화면에 출력 됨
		
		%>
		<%="myname:"+ myname %>	
	
	</body>
</html>