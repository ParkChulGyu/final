<%@page import="com.myweb.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDTO dto = (MemberDTO)request.getAttribute("dto");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test/response.jsp</title>
</head>
<body>
<%@include file="../topmenu.jsp" %>
<h1>RESPONSE</h1>
<h2>
ID : <%=dto.getUser_id() %> / PW : <%=dto.getPw() %>
</h2>
</body>
</html>