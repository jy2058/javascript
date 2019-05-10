
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
		function fn_delete(){
			var flag = confirm("삭제된 데이터는 복구 할 수 없습니다. 진행 하시겠습니까?");
			if(!flag){
				return;
			}
			document.frm.submit();
		}
		
		function fn_update(){
			
			document.frm.action ="13_EMP_UPD.jsp";
			document.frm.submit();
		}
	
	</script>
	<body>
	상세화면
	<%
		String sawon_id = request.getParameter("sawon_id");
		
		EmpVO paramVO = new EmpVO();
		paramVO.setSawon_id(sawon_id);
		
		EmpDao dao = new EmpDao();
		EmpVO rVO = dao.OneSelEmp(paramVO);
		
	%>
	<form name="frm" method="POST" action="13_EMP_DEL_ACT.jsp">
	<table>
		<input type="hidden" name="sawon_id" value="<%=rVO.getSawon_id()%>"/>
		<tr>
			<td>사번</td>
			<td><%=rVO.getSawon_id()%></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=rVO.getSawon_id()%></td>
		</tr>
		<tr>
			<td>휴대폰</td>
			<td><%=rVO.getMobile()%></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=rVO.getEmail()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="삭제" onclick="fn_delete()"/>
				<input type="button" value="수정" onclick="fn_update()"/>
			</td>
		</tr>
		
	</table>
	</form>	


	</body>
</html>