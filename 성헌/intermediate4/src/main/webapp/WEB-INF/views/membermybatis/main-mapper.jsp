<%@page import="com.myweb.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=request.getRequestURI() %></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/top2.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypage.css">
</head>
<body>
<%@include file="../topmenu.jsp" %>

<main>
<%@include file="submenu.jsp" %>

<%
request.setCharacterEncoding("utf-8");
MemberDTO dto = (MemberDTO)request.getAttribute("dto");
%>


<div class="main-mapper">
<div class="maintitle">


<h2>너님 정보임</h2>

</div>



<hr>
	
	<table class="myinfotable" style="margin-top: 60px;margin-bottom: 60px;" >
	
		<tr><th style="width : 50%"class="myinfoline">등급</th><td>회원</td></tr>
		<tr><th class="myinfoline">ID</th><td><%=dto.getUser_id()%></td></tr>
		<tr><th class="myinfoline">PW</th><td><%=dto.getPw()%></td></tr>
		<tr><th class="myinfoline">Name</th><td><%=dto.getName()%></td></tr>
		<tr><th class="myinfoline">nickname</th><td><%=dto.getNickname()%></td></tr>
      	<tr><th class="myinfoline">email</th><td><%=dto.getEmail()%></td></tr>
      	<tr><th class="myinfoline">PhoneNumber</th><td><%=dto.getPhoneNumber()%></td></tr>	
	</table>


<hr>




























</div>








</main>


</body>
</html>