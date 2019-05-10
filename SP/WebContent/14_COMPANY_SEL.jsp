

<%@page import="com.patagonia.model.CompanyVO"%>
<%@page import="com.patagonia.dao.CompanyDao"%>
<%@page import="java.util.ArrayList"%>

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
			location.href = "14_COMPANY_INS.jsp";
		}
	
	</script>
	<body>

<table border="1">
	<tr>
		<td>협력사ID</td>
		<td>협력사명</td>
		<td>담당자ID</td>
		<td>담당자명</td>
		<td>주식회사여부</td>
		
	</tr>

<%
	CompanyDao dao = new CompanyDao();
	ArrayList<CompanyVO> list = dao.selectList(null);
	
	for(int i=0; i<list.size(); i++) {
	   String co_id = list.get(i).getCo_id();
	   String co_name = list.get(i).getCo_name();
	   String manager_id = list.get(i).getManager_id();
	   String stock_yn = list.get(i).getStock_yn();
	   String manager_name = list.get(i).getManager_name();
	   
%>
	<tr>
		<td>
		<a href="14_COMPANY_DETAIL.jsp?co_id=<%=co_id%>"><%=co_id%></td></a>
		<td><%=co_name%></td>
		<td><%=manager_id%></td>
		<td><%=manager_name%></td>
		<td><%=stock_yn%></td>
	</tr>
	
<%	
	}
%>

</table>
<input type="button" value="협력사등록" onclick="fn_insert()">

	</body>
</html>