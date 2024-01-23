<%@page import="com.myweb.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="loginCheck-mapper.jsp" />
<%
request.setCharacterEncoding("utf-8");

MemberDTO dto = (MemberDTO)request.getAttribute("dto");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update.jsp</title>
<script>

	
</script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/top2.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypage.css">
</head>
<body>
<%@include file="../topmenu.jsp" %>
<main>
<%@include file="submenu.jsp" %>


<div class="update-mapper">
<div class="maintitle">


<h2>회원정보수정</h2>

</div>




<hr>

<form action="updateP" method="post" style="border-top-width: 50px;  padding-top: 50px; padding-bottom: 50px;">
	<table class="updatetable">
		<tr><th class="updateline">ID</th><td><%=dto.getUser_id()%></td></tr>
		<tr><th class="updateline">PW</th><td><input type="text" id="myInput" name="pw" value="<%=dto.getPw()%>"></td></tr>
		<tr><th class="updateline">Name</th><td class="updateline"><input  id="myInput" type="text" name="name" value="<%=dto.getName()%>"></td></tr>
		<tr><th class="updateline" >nickname</th><td class="updateline" ><input  id="myInput" type="text" name="nickname" value="<%=dto.getNickname()%>"></td></tr>
      	<tr><th class="updateline">email</th><td><input type="text" id="myInput"  name="email" value="<%=dto.getEmail()%>"></td></tr>
      	<tr><th class="updateline" >PhoneNumber</th><td class="updateline"><input id="myInput"  type="text" name="PhoneNumber" value="<%=dto.getPhoneNumber()%>"></td></tr>	
	</table>
		<div class="submitbtndiv">
		<button type="submit" class="submitbtn">수정</button>
		</div>

</form>
<hr>

</div>







</main>
</body>
</html>