<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>patagonia</title>
		<script src="jquery-1.12.4.js"></script>
		<script type="text/javascript">
		
			function init(){
				
				$.ajax({
					type : "get",
					url : "http://localhost/UITEST01/MySelect01",
					dataType : "json",

					success : function(data) {
						
						var text = "";			
						for(var i = 0; i < data.length; i++){
							text += "<option value='"+data[i].maker_code+"'>";
							text += data[i].maker_name+"</option>";
						}
						$("#sel01").append(text);
					},
				
					error : function(xhr, status, error) {
						console.log("에러!: " + error);
					},
				});							
			}
			
			function mychange01(){
				$.ajax({
					type : "get",
					url : "http://localhost/UITEST01/MySelect02",
					data : { param1 : $("#sel01").val()},
					dataType : "json",
					

					success : function(data) {
						var text = "";			
						for(var i = 0; i < data.length; i++){
							text += "<option value='"+data[i].car_code+"'>";
							text += data[i].car_name+"</option>";
						}
						$("#sel02").html(text);
					},
				
					error : function(xhr, status, error) {
						console.log("에러!: " + error);
					},
				});							
				
				
			}
			
			function mychange02(){
				
				$.ajax({
					type : "get",
					url : "http://localhost/UITEST01/myselect03",
					data : { param1 : $("#sel02").val()},
					dataType : "json",

					success : function(data) {
						var text = "";			
						//for(var i = 0; i < data.length; i++){
							text += "<tr>";
							text += "	<td>"+data[0].car_name+"</td>";
							text += "	<td>"+data[0].maker_name+"</td>";
							text += "	<td>"+data[0].fuel_type+"</td>";
							text += "	<td>"+data[0].cc+"</td>";
							text += "	<td>"+data[0].yunbi+"</td>";
							text += "	<td>"+data[0].debut.substring(0,10)+"</td>";
							text += "</tr>";
						//}
						$("#mytbody").html(text);
					},
				
					error : function(xhr, status, error) {
						console.log("에러!: " + error);
					},
				});					
			}
		</script>
	</head>
	<body onload="init()">
		
		<select onchange="mychange01()" id="sel01">
			<option value="">제조사 선택</option>
		</select>
		<select onchange="mychange02()" id="sel02">
			<option value="">---</option>		
		</select>
		<br>
		
		<table border="1">
			<tr>
				<td>차명</td>			
				<td>제조사</td>			
				<td>연료유형</td>			
				<td>배기량(cc)</td>			
				<td>연비</td>			
				<td>출시일</td>			
			</tr>
			<tbody id="mytbody">
			</tbody>
		</table>
		
		
	</body>
</html>