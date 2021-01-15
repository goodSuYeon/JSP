<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el.jsp</title>
</head>
<body>
	<%
		// jsp하나로만 가지고 테스트 해보는것 
		//( Controller에서 조회된 데이터를 request에 저장 했다라는 가정 )
		UserVo userVo = new UserVo();
		userVo.setUserid("suyeon");
		userVo.setUsernm("김수연");
		userVo.setAlias("뚜연");
		
		request.setAttribute("userVo", userVo);
	%>
	
	<%-- View --%>
	<h1>표현식 - userVo</h1>
	userVo : <%=request.getAttribute("userVo") %> <br>
	userVo.getUserid() : <%= ((UserVo)request.getAttribute("userVo")).getUserid() %> <br><br>
	<hr>
	<h1>el - userVo</h1>
	userVo : ${userVo} <br>
	userVo.getUserid() : ${userVo.userid} 또는  	<%-- ${속성명.필드명} --%>
						 ${userVo.getUserid() } <br><br>
	<hr>	
			 
	<%
		// Map객체 실습 
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userid", "suyeon");
		map.put("usernm", "김수연");
		map.put("alias", "뚜연");
		
		request.setAttribute("map", map);
	%>    
	
	<h1>map - 표현식</h1>
	map : <%=map %> <br>
	map.get("userid") : <%=map.get("userid") %> <br><br>
	<hr>
	<h1>map - EL</h1>
	map : ${map} <br>
	map.get("userid") : ${map.userid} <br><br>
	<hr>
	
	<h1>산술 연산</h1>
	${5 + 5}
</body>
</html>