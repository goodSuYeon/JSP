<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>userModify.Jsp</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<link href="<%=request.getContextPath() %>/css/dashboard.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/css/blog.css" rel="stylesheet">

<script>
    new daum.Postcode({
        oncomplete: function(data) {
        	$('#addr1').val(data.roadAddress); //도로주소
			$('#zipcode').val(data.zonecode);  //우편번호
        }
    }).open();
</script>

</head>

<body>
	<%@include file="/common/header.jsp"%>
	
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@include file="/common/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<% UserVo userVo = (UserVo) request.getAttribute("user"); %>

				<form class="form-horizontal" role="form" action="<%= request.getContextPath() %>/userModify">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="userId" name="userId" value="사용자 아이디" placeholder="사용자 아이디"> 						
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="userName" name="userName" value="사용자 이름" placeholder="사용자 이름"> 						
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userAlias" name="userAlias" value="별명" placeholder="별명">
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<%
							String pass = userVo.getPass();
							if (pass != null) {
								pass = "******";
							}
							%>
							<label class="control-label"><%=pass%></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">등록일시</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="userReg_dt" name="userReg_dt" value="등록일시" placeholder="등록일시"> 						
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zipcode" name="zipcode" value="우편번호" placeholder="우편번호">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">도로명주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr1" name="addr1" value="도로명주소" placeholder="도로명주소">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2" name="addr2" value="상세주소" placeholder="상세주소">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">사용자 수정</button>
						</div>
					</div>
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>
