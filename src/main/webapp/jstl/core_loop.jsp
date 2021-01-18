<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>for문 실습</title>
</head>
<body>
	<%-- 
		for(1.초기화; 2.조건체크; 4.증감식){
			3. 반복할 문장
		}
		1-2-3-4-2-3-4-2-3-4-....
		begin : 시작 인덱스값
		end   : 종료 인덱스값
		step  : 증감 값 (default 1)
		var   : 인덱스변수 or 향상된 for문에서 사용할 경우 collection객체에서 꺼낸 값 설정
		varStatus : 루프변수   (그렇게 중요하지 않음!!) 
			(1). index - 현재 인덱스값
			(2). count - 루프 실행 횟수
			(3). begin, end - 루프의 begin,end값
	 --%>
	 
	 <h3>일반 for문 형태</h3>

	 <c:forEach begin="0" end="10" var="i" varStatus="loop">
	 	${i} : 번쨰 반복할 문장 ${loop.index} / ${loop.count} <br>
	 </c:forEach>
	<hr>
		 
	 <h3>향상된 for문 형태</h3>
	<%
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("moon");
		rangers.add("james");
		request.setAttribute("rangers", rangers);
	
		/*
			for(String ranger : (List<String>) request.getAttribute("rangers")) {
				
					
			}
			<c:forEach items="${rangers}" var="ranger">
			</c:forEach>
		*/
	%>
	
	<c:forEach items="${rangers }" var="ranger" varStatus="loop">
		${ranger} / ${loop.index} / ${loop.count} / ${loop.begin} / ${loop.end}<br>
	</c:forEach>
	
	<hr>
	
	<% request.setAttribute("lineeangers", "brown,cony,sally,moon,james"); %>
	<c:forTokens items="${lineeangers}" delims="," var="i">
		${i} <br>
	</c:forTokens>
	
	<hr>
	
	<h3>map타입 객체 루프를 통해 담겨진 값 확인하기</h3>
	<%
		Map<String, String> map = new HashMap<String, String>();
		
		//map, list
		/*
		   map  : 순차적으로 접근이 아닌, 특정 키에 의해 원하는 값을 확인하고 싶을 때
		   list : 순차적으로 접근하고 싶을 때
		   for(String str : list)  ==> 리스트에 담겨있는 모든 값에 대해 처리
		   map에 담겨진 모든 값을 확인하려면?
		   		for(String key : map.keySet()){
		   			map.get(key);
		   		 }
		*/
		map.put("userid", "brown");
		map.put("usernm","브라운");
		map.put("alias","곰");
		request.setAttribute("ranger", map);
		
   		for(String key : map.keySet()){
   			map.get(key);
   		 }
	%>
	
	<c:forEach items="${ranger }" var="entry">
		${entry.key} / ${entry.value} <br>
	</c:forEach>
	
	<hr>
	
	<h3>url 작성</h3>
	<a href="<c:url value="/registUser" />">사용자 등록</a> <br>
	
	<a href="${cp }/registUser">사용자 등록</a> <br>
	
	[var속성을 적용하지 않은 경우]
	 - 태그를 작성한 곳에 출력  ★이건 잘 알아두기!★
	<c:url value="/registUser"></c:url> <br>
	
	[var속성을 적용한 경우]
	 - var속성으로 저장만 된다 (EL을 통해 활용)
	<c:url value="/registUser" var="url"></c:url>
	${url}
</body>
</html>