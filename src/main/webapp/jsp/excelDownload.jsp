<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	response.setHeader("Content-Disposition", "attachment; filename-excle.xls");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>userId</th>
			<th>이름</th>
		</tr>
		<tr>
			<td>suyeon</td>
			<td>김수연</td>
		</tr>
		<tr>
			<td>brwon</td>
			<td>브라운</td>
		</tr>
		<tr>
			<td>sally</td>
			<td>셀리</td>
		</tr>
	</table>
</body>
</html>