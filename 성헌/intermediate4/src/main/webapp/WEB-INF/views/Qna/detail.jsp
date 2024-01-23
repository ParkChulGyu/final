<%@page import="com.myweb.dto.AdminNoticeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
     

     

	<%
	String nickname = (String) session.getAttribute("nickname"); 
	
	%>
	
	



<!DOCTYPE html>
<html>
<head>
<title>New.jsp</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/top2.css">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css?v=<%=new java.util.Date().getTime() %>">
<meta charset="UTF-8">
<%@include file="../topmenu.jsp" %>
</head>



<body>
<main>

<div class="detailjsp">


<div class="maintitle">

		<h2>Q&A</h2>
</div>






<table class="DetailList">

	<tr>
		<th class="w-px160 detailline">제목</th>
		<td colspan="5" class="left detaillinetd ">${dto.title }</td>
	</tr>
	<tr>
		<th class="detailline">작성자</th>
		<td class="detaillinetd">${dto.writer }</td>
		<th class="w-px120 detailline">작성일자</th>
		<td class="w-px120 detaillinetd ">${dto.regdate }</td>
		<th class="w-px80 detailline">조회수</th>
		<td class="w-px80  detaillinetd">${dto.readcnt }</td>
	</tr>
	<tr>
		<th style="height: 90px; " class="detailline">내용</th>
		<td colspan="5" class="left detailtd">${fn:replace(dto.content, crlf, '<br>') }</td>
	</tr>
	<tr>
	
		<th class="detailline">첨부 파일</th>
		<td colspan="5" class="left detaillinetd ">
			
			
			<c:if test="${not empty dto.filename }">
				<a href="download?idx=${dto.idx}" style='margin-left: 15px'><i class="fas fa-download font-img"></i><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-image" viewBox="0 0 16 16">
  							<path d="M6.002 5.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
  							<path d="M2.002 1a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2h-12zm12 1a1 1 0 0 1 1 1v6.5l-3.777-1.947a.5.5 0 0 0-.577.093l-3.71 3.71-2.66-1.772a.5.5 0 0 0-.63.062L1.002 12V3a1 1 0 0 1 1-1h12z"/>
					</svg></a>
					${dto.filename }
			</c:if>
		</td>
	</tr>
</table>










<div class="detailbtnSet">
	<a class="btn-fill" href="Qna">목록으로</a>
		<c:if test="${nickname eq dto.writer}">
    <a class="btn-fill" href="modify?idx=${dto.idx}">수정</a>
    <a class="btn-fill" onclick="if (confirm('정말 삭제하시겠습니까?')) { location.href='delete?idx=${dto.idx}' }">삭제</a>
	</c:if>
	<c:if test="${not empty sessionScope.nickname}">
		<a class="btn-fill" href="reply?idx=${dto.idx}">답글 쓰기</a>
	</c:if>
	
	
</div>


	
</div>




</main>
</body>
</html>