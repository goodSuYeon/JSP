<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

표현식, 스크립틀릿을 EL, JSTL로 변경 <br>
<table border="1">
	 <c:forEach begin="1" end="10" var="j">
	  <tr>
	   <c:forEach begin="2" end="9" var="i">
	 	<td>${i} * ${j} = ${i*j} </td>
	   </c:forEach>
	 </tr>
	 </c:forEach>
</table>
</body>
</html>