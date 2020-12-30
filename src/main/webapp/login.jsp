<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<!-- POST로 보내는 이유? 개인정보를 전송하므로 URL에 노출되지 않도록 request body영역에  파라미터를 전송 -->
	<form id="" action="<%=request.getContextPath() %>/LoginController" method="post" >
	user id : <input type="text" name="userid"> <br>
	user id : <input type="text" name="userid"> <br>
	password : <input type="password" name="pass"> <br>
	<input type="submit" value="전송">
	</form>
</body>
</html>