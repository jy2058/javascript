
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
	<script src="jquery-1.12.4.js"></script>
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
		
		function fn_check() {
			var co_id = $("input[name=co_id]").val();
			if(co_id == ""){
				alert("협력사 번호는 입력 되어야 합니다.");
				$("input[name=co_id]").focus();
				return;
			}
			var int_co_id = Number(co_id);
			var flag = Number.isInteger(int_co_id);
			
			if(!flag){
				alert("협력사 번호는 숫자 타입이어야 합니다.");
				return;
			}
			
			$.ajax({
				type : "get",
				url : "MyAjaxCheck",
				data : { co_id : co_id },
				dataType : "json",

				success : function(data) {
					console.log(data.message);
					if(data.message == "OK"){
						$("input[name=co_id]").attr("readonly", true);
						alert("사용 가능 한 아이디 입니다.");
					}else {
						$("input[name=co_id]").val("");
						$("input[name=co_id]").focus();
						alert("사용 할 수 없는 아이디 입니다.");
						
						
					}
				},
				error : function(xhr, status, error) {
					console.log("에러!: " + error);
				},
			});
		}
	
	</script>
	<body>
	등록화면
	
	<form name="frm" method="POST" action="14_COMPANY_INS_ACT.jsp">
	<table>
		<tr>
			<td>협력사번호</td>
			<td>
				<input type="text" name="co_id" value="" >
				<input type="button" value="중복체크" onclick="fn_check()" />
			</td>
		</tr>
		<tr>
			<td>협력사명</td>
			<td><input type="text" name="co_name" value=""></td>
		</tr>
		<tr>
			<td>담당자ID</td>
			<td>
				<select name="manager_id">
				<option value="">--------</option> 
<%
	EmpDao dao = new EmpDao();
 	ArrayList<EmpVO> listCombo = dao.selEmp(null);
%>
<% for(int i = 0; i < listCombo.size(); i++){ %>
					<option value="<%=listCombo.get(i).getSawon_id() %>"><%=listCombo.get(i).getSawon_name() %></option>
<% } %>
				</select>
			</td>
		</tr>
		<tr>
			<td>주식회사여부</td>
			<td><input type="radio" name="stock_yn" value="Y" checked>주식회사
			<input type="radio" name="stock_yn" value="N">기타</td>
		</tr>
		<tr>
			<td>회사연락처</td>
			<td><input type="text" name="co_tel" value=""></td>
		</tr>
		<tr>
			<td>회사대표자</td>
			<td><input type="text" name="co_ceo_name" value=""></td>
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