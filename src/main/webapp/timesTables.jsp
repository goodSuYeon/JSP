<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<% for(int j=1; j<=10; j++) { %>	   <!-- 표현식 : 문자열 출력 -->
		<tr>
		<% for(int i=2; i<=9; i++) { %>
		<td><%= i + " * " + j + " =" + i*j %></td>
<%-- 또는 <td><%= i %> * <%=j %> = <%= i*j %> </td> --%>
	  <% } %>
	   </tr>
	<% } %> 

</table>
</body>
</html>