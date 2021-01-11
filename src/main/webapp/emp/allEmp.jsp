<%@page import="kr.or.ddit.emp.model.EmpVo"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Jsp</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<link href="<%=request.getContextPath() %>/css/dashboard.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/css/blog.css" rel="stylesheet">

</head>

<body>
<% List<EmpVo> empList = (List<EmpVo>)request.getAttribute("empList"); %>

	<%@ include file="/common/header.jsp" %>

<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/common/left.jsp"%>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사원정보</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사원번호</th>
									<th>사원이름</th>
									<th>담당업무</th>
									<th>매니저 사번번호</th>
									<th>입사일자</th>
									<th>급여</th>
									<th>성과금</th>
									<th>부서번호</th>									
								</tr>
								<%
									for(EmpVo empvo : empList){
								%>
								<tr>
									<td><%= empvo.getEmpno() %></td>
									<td><%= empvo.getEname() %></td>
									<td><%= empvo.getJob() %></td>
									<td><%= empvo.getMgr() %></td>
									<td><%= empvo.getHiredate() %></td>
									<td><%= empvo.getSal() %></td>
									<td><%= empvo.getComm() %></td>
									<td><%= empvo.getDeptno() %></td>
								</tr>
	  						<% } %>
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
