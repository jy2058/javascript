
<%@page import="com.patagonia.dao.EmpDao"%>
<%@page import="com.patagonia.model.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>patagonia</title>
	</head>
	<script type="text/javascript">

		function fn_save(){
			document.frm.submit();
		}
	
	</script>
	<body>
	등록화면
	
	<form name="frm" method="POST" action="13_EMP_INS_ACT.jsp">
	<table>
		<tr>
			<td>사번</td>
			<td><input type="text" name="sawon_id" value="" ></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="sawon_name" value=""></td>
		</tr>
		<tr>
			<td>휴대폰</td>
			<td><input type="text" name="mobile" value=""></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value=""></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="저장" onclick="fn_save()"/>
			</td>
		</tr>
		
	</table>
	</form>	


	</body>
</html>