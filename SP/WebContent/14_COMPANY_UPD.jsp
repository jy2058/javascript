
<%@page import="com.patagonia.model.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.patagonia.dao.EmpDao"%>
<%@page import="com.patagonia.dao.CompanyDao"%>
<%@page import="com.patagonia.model.CompanyVO"%>
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
			var obj_co_name = document.frm.co_name;
			if(obj_co_name.value == ""){
				alert("협력사 명은 기입하셔야 합니다.");
				obj_co_name.focus();
				return;
			}
			
			var obj_manager_id = document.frm.manager_id;
			if(obj_manager_id.value == ""){
				alert("담당자 명은 기입하셔야 합니다.");
				obj_manager_id.focus();
				return;
			}
			
			var obj_co_tel = document.frm.co_tel;
			if(obj_co_tel.value == ""){
				alert("회사 전화번호는 기입하셔야 합니다.");
				obj_co_tel.focus();
				return;
			}
			
			var obj_co_ceo_name = document.frm.co_ceo_name;
			if(obj_co_ceo_name.value == ""){
				alert("회사대표를 기입하셔야 합니다.");
				obj_co_ceo_name.focus();
				return;
			}
			
			var regExp = /^\d{3}-\d{3,4}-\d{4}$/; //휴대폰번호 정규식
		      if(!regExp.test(obj_co_tel.value)) {
		         alert("잘못된 휴대폰번호입니다. -를 포함한 숫자만 입력하세요.");
		         return;
		      }
			
			document.frm.submit();
		}
	
	</script>
	<body>
	수정화면
	<%
		String co_id = request.getParameter("co_id");
		
		CompanyVO paramVO = new CompanyVO();
		paramVO.setCo_id(co_id);
		
		CompanyDao dao = new CompanyDao();
		CompanyVO rVO = dao.select(paramVO);
		
	%>
	<form name="frm" method="POST" action="14_COMPANY_UPD_ACT.jsp">
	<table>
		<tr>
			<td>협력사번호</td>
			<td><input type="text" name="co_id" value="<%=rVO.getCo_id()%>" readonly></td>
		</tr>
		<tr>
			<td>협력사명</td>
			<td><input type="text" name="co_name" value="<%=rVO.getCo_name()%>"></td>
		</tr>
		<tr>
			<td>담당자ID</td>
			<td>
				<select name="manager_id">
					<option value="">-----</option>
<% EmpDao daoCombo = new EmpDao();
   ArrayList<EmpVO> listCombo = daoCombo.selEmp(null);
%>
<% for(int i = 0; i < listCombo.size(); i++){ %>
					<option value="<%=listCombo.get(i).getSawon_id()%>"
<%if(rVO.getManager_id().equals(listCombo.get(i).getSawon_id())){ %>
						selected
<% } %>
					>
						<%=listCombo.get(i).getSawon_name()%>
					</option>
<% } %>
				</select>
			</td>
		</tr>
		<tr>
			<td>주식회사여부</td>
			<td>
			<input type="radio" name="stock_yn" value="Y"
			<% if(rVO.getStock_yn().toUpperCase().equals("Y")){ %>
				checked
			<%} %>
			/> 주식회사
			
			<input type="radio" name="stock_yn" value="N"
			<% if(!rVO.getStock_yn().toUpperCase().equals("Y")){ %>
				checked
			<%} %>
			/> 기타
 			</td>
		</tr>
		<tr>
			<td>회사연락처</td>
			<td><input type="text" name="co_tel" value="<%=rVO.getCo_tel()%>"></td>
		</tr>
		<tr>
			<td>회사대표자</td>
			<td><input type="text" name="co_ceo_name" value="<%=rVO.getCo_ceo_name()%>"></td>
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