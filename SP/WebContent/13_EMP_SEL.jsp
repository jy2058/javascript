
<%@page import="com.patagonia.model.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.patagonia.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>patagonia</title>
	</head>
	<script type="text/javascript">
		function fn_insert(){
			location.href = "13_EMP_INS.jsp";
		}
	
	</script>
	<body>

<table border="1">
	<tr>
		<td>사원ID</td>
		<td>사원이름</td>
		<td>전화번호</td>
		<td>이메일</td>
		
		<td>입력일</td>
		<td>입력ID</td>
		<td>수정일</td>
		<td>수정ID</td>
	</tr>

<%
	EmpDao dao = new EmpDao();
	ArrayList<EmpVO> list = dao.selEmp(null);
	
	for(int i=0; i<list.size(); i++) {
	   String sawon_id = list.get(i).getSawon_id();
	   String sawon_name = list.get(i).getSawon_name();
	   String mobile = list.get(i).getMobile();
	   String email = list.get(i).getEmail();
	   
	   String ins_date = list.get(i).getIns_date();
	   String ins_id = list.get(i).getIns_id();
	   String upd_date = list.get(i).getUpd_date();
	   String upd_id = list.get(i).getUpd_id();
%>
	<tr>
		<td>
		<a href="13_EMP_DETAIL.jsp?sawon_id=<%=sawon_id%>"><%=sawon_id%></td></a>
		<td><%=sawon_name%></td>
		<td><%=mobile%></td>
		<td><%=email%></td>
		
		<td><%=ins_date%></td>
		<td><%=ins_id%></td>
		<td><%=upd_date%></td>
		<td><%=upd_id%></td>
	</tr>
	
<%	
	}
%>

</table>
<input type="button" value="사원등록" onclick="fn_insert()">

	</body>
</html>