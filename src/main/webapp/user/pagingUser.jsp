<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
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

<%@include file="/common/common_lib.jsp"%>
<link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">
<script>
// 문서 로딩이 완료되고 나서 실행되는 영역
$(function(){
	$('.user').on('click',function(){

		var userid = $(this).data('userid');
		$('#userid').val(userid);
		$('#frm').submit();
	})
	
	$('#insertBtn').on('click', function(){
		 location.href="/user/registUser.jsp"
	})
})
</script>
</head>

<body>
<%
	// 서블릿에서 만들어서 보낸 데이터를 보여준다.
	List<UserVo> userList = (List<UserVo>)request.getAttribute("userList");

%>

	<form id="frm" action="<%= request.getContextPath() %>/user" >
		<input type="hidden" id="userid" name="userid" value="" />
	</form>
	
	<%@ include file="/common/header.jsp" %>

<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/common/left.jsp"%>
			</div>
			
			

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>

								<%
									
									for(UserVo user : userList){
								%>
								<tr class="user" data-userid="<%= user.getUserid() %>">
									<td><%= user.getUserid() %></td>
									<td><%= user.getUsernm() %></td>
									<td><%= user.getPass() %></td>
									<td>fmt : <%= user.getReg_dt_fmt()%></td>
								</tr>
	  						<% } %>
							</table>
						</div>
						
						<a id="insertBtn" class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
						
						<%--사용자가 누른 현재 페이지번호를 알 수 있음 --%>
						<% PageVo pageVo = (PageVo)request.getAttribute("pagevo"); 
						   int pagination = (int)request.getAttribute("pagination");
						%>
							
							<ul class="pagination">
							
							<%-- 아래코드 해석
								pagination 값이 4이므로 1~4까지 4번 반복된다
								- 현재 사용자수  : 16명
								- 페이지 사이즈  : 5
								- 전체 페이지 수 : 4페이지
							 --%>
								<li class="prev">
									<a href="<%=request.getContextPath() %>/pagingUser?page=1&pageSize=<%=pageVo.getPageSize()%>">«</a>
								</li>
								
								<%
								for (int i = 1; i <= pagination; i++) {

									if (pageVo.getPage() == i) {
										
								%>
										 <li class="active"><span><%=i %></span></li>
								<% } 
									 else{ %>
										 
									<li><a href="<%=request.getContextPath() %>/pagingUser?page=<%=i %>&pageSize=<%=pageVo.getPageSize()%>"><%=i %></a></li>
								<% } %>
								<% } %>
								
								<li class="next">
									<a href="<%=request.getContextPath() %>/pagingUser?page=4&pageSize=<%=pageVo.getPageSize()%>">»</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
