
<%@page import="com.patagonia.dao.EmpDao"%>
<%@page import="com.patagonia.model.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		String sawon_id 	= request.getParameter("sawon_id");
		String sawon_name 	= request.getParameter("sawon_name");
		String mobile 		= request.getParameter("mobile");
		String email 		= request.getParameter("email");
		
		EmpVO paramVO = new EmpVO();
		paramVO.setSawon_id(sawon_id);
		paramVO.setSawon_name(sawon_name);
		paramVO.setMobile(mobile);
		paramVO.setEmail(email);
		
		EmpDao dao = new EmpDao();
		int cnt = dao.insEmp(paramVO);
		
	%>

<!doctype html>
<html lang="en">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>patagonia</title>
	</head>
	<script type="text/javascript">
/*var cnt는 javascript 언어의 cnt / 오른쪽 cnt는 java 언어/ 둘이 다른 거임  */
	var cnt = <%=cnt%>;
	
	if(cnt === 1){
		location.href = "13_EMP_SEL.jsp";
	}else{
		history.go(-1);
	  //history.back(); 같은 기능
	}
	</script>
	<body>
	등록 실행 화면



	</body>
</html>