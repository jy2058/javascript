
<%@page import="com.patagonia.dao.CompanyDao"%>
<%@page import="com.patagonia.model.CompanyVO"%>
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
			
			document.frm.action ="14_COMPANY_UPD.jsp";
			document.frm.submit();
		}
	
	</script>
	<body>
	상세화면
	<%
	String co_id = request.getParameter("co_id");
	
	CompanyVO paramVO = new CompanyVO();
	paramVO.setCo_id(co_id);
	
	CompanyDao dao = new CompanyDao();
	CompanyVO rVO = dao.select(paramVO);
		
	%>
	<form name="frm" method="POST" action="14_COMPANY_DEL_ACT.jsp">
	<table>
		<input type="hidden" name="co_id" value="<%=rVO.getCo_id()%>"/>
		<tr>
			<td>협력사번호</td>
			<td><%=rVO.getCo_id()%></td>
		</tr>
		<tr>
			<td>협력사명</td>
			<td><%=rVO.getCo_name()%></td>
		</tr>
		<tr>
			<td>담당자ID</td>
			<td><%=rVO.getManager_id()%></td>
		</tr>
		<tr>
			<td>담당자명</td>
			<td><%=rVO.getManager_name()%></td>
		</tr>
		
		<tr>
			<td>주식회사여부</td>
			<td ><input type="radio" name="stock_yn" value="Y"
				<%if(rVO.getStock_yn().toUpperCase().equals("Y")){%>
					checked
				<%} %>>Y
				 <input type="radio" name="stock_yn" value="N"
				 <%if(!rVO.getStock_yn().toUpperCase().equals("Y")){%>
				 	checked
				 <%} %>>N
			</td>
		</tr>
		<tr>
			<td>회사연락처</td>
			<td><%=rVO.getCo_tel()%></td>
		</tr>
		<tr>
			<td>회사대표자</td>
			<td><%=rVO.getCo_ceo_name()%></td>
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