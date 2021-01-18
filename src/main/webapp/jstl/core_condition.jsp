<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if,choose</title>
</head>
<body>
	<h3>if</h3>
	<c:set var="userid" value="brown" />
	
	<%-- Java 
		 if()문 -> test속성에 검사할 조건식을 기술
		 userid 속성 값이 brown인지 체크하고 brown일때만 화면에 userid 속성을 출력한다 
		 
		 ${userid} == "brown"
		 틀린예시  : ${userid} == 'brown'
		 올바른예시 : ${userid == 'brown'}
		
		 <% if( ((String)pageContext.getAttribute("userid")).equals("brown")){
		 		out.write((String)pageContext.getAttribute("userid"));
		 	}
		  %>
		 --%>
		 <% if( ((String)pageContext.getAttribute("userid")).equals("brown")){
		 		out.write("userid-스크립틀릿 : " + (String)pageContext.getAttribute("userid"));
		 	}
		  %> <br>
	<c:if test="${userid} == 'brown'">
		틀린 userid : ${userid} <br>	
	</c:if>
	
	<c:if test="${userid == 'brown'} ">
		올바른 userid : ${userid} <br>	
	</c:if>
	
	<h3>choose</h3>
	일반 if, else if, else <br>
	<c:choose>
		<c:when test="${userid == 'sally'}"> sally사용자 입니다.</c:when>
		<c:when test="${userid == 'moon'}"> moon사용자 입니다.</c:when>
		<c:when test="${userid == 'brown'}"> brown사용자 입니다.</c:when>
		<c:when test="${userid == 'cony'}"> cony사용자 입니다.</c:when>
		<c:otherwise>when절에 매칭되는 조건이 없습니다!</c:otherwise>
	</c:choose>
</body>
</html>
