<%@page import="com.myweb.dto.AdminNoticeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/top2.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css?v=<%=new java.util.Date().getTime() %>">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pagination.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pagination.css">







<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminlist.jsp</title>
</head>
<body>
<%@include file="../topmenu.jsp"%>
<main>


	
	<!--  테이블 시작-->
	
	
	<div class="maintitle">
		<h2>자유게시판</h2>
	</div>
	<div id="list-top">
	<hr>
	
	</div>
	


		<div class="container">
			<div class="topcount">
				<Strong>
					<ul>
						<li>총 게시물 : <span class="ft-blue">${pdto.totalCount}</span></li>

					</ul>
				</Strong>
			</div>


			<div class="topsearch" style="margin-right: 30px;">
				<form action="/web/Qna/Qna" method="post">
					<select name="listNum" class="form-select"
						aria-label="Default select example" style="width: 47px; 
    margin-right: 3px;
						">
						<!-- 선택 목록 -->
						<option value="5">5</option>
						<option value="10" selected>10</option>
						<option value="20">20</option>
					</select>
					 <select name="slt" class="form-select" style="width: 97px;  margin-right: 3px;">
						<!-- 선택 목록 -->
						<option value="title">제목</option>
						<option value="content" selected>제목or내용</option>
					</select> 
					<input id="search" style="width: 202px;" class="form-write" type="text" name="str"
						placeholder="검색어를 입력하세요">
					<button type="submit" class="form-btn">검색</button>
				</form>

				<script>
					var searchValue = $("#search").val();
				</script>

			</div>

		</div>
		
		
		
		
		<table class="QnaList">
			<tr>
				<th class="w-px70 QnaListTh">번호</th>
				<th >제목</th>
				<th class="w-px100 QnaListTh">작성자</th>
				<th class="w-px120 QnaListTh">작성일</th>
				<th class="w-px80 QnaListTh">조회</th>
			</tr>


			<c:forEach items="${list}" var="AdminNoticeDTO">


				<tr >
					<td class="QnaListTd">${AdminNoticeDTO.idx}</td>
					<td class="Title"><a href="/web/adminnotice/adminview?idx=${AdminNoticeDTO.idx}">${AdminNoticeDTO.title}</a></td>
					<td class="QnaListTd">${AdminNoticeDTO.nickname}</td>
					<td class="QnaListTd">${AdminNoticeDTO.regdate}</td>
					<td class="QnaListTd">${AdminNoticeDTO.totalcount}</td>
				</tr>
			</c:forEach>

		</table>




<div class="writebtn">
			<ul>
				<!--<core:if test="${login_info.admin eq 'Y' }">-->
				<li><a class="" href="/web/adminnotice/adminwrite">글쓰기</a></li>
				<!--</core:if>-->
			</ul>
		</div>








	<!-- 페이징 처리값 세팅 -->
<!-- 페이징 처리값 세팅 -->
		<div class="pagebtn">
			<ul class="pagination">
				<c:if test="${pdto.isPrev eq true }">
					<li class="page-btn"><a
						href="/web/adminnotice/adminlist?pageNum=${pdto.pageNum - 1}&str=${str}&listNum=${pdto.listNum}">이전</a>
					</li>
				</c:if>
				<c:forEach begin="${pdto.startPage}" end="${pdto.endPage}"
					var="pageNumber">

					<c:choose>
						<c:when test="${pageNumber eq pdto.pageNum}">
							<li class="page-btn"><a href="javascript:void(0);"
								style="cursor: default;">${pageNumber}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-btn"><a
								href="/web/adminnotice/adminlist?pageNum=${pageNumber}&str=${str}&listNum=${pdto.listNum}">${pageNumber}</a>
							</li>

						</c:otherwise>
					</c:choose>

				</c:forEach>
				<c:if test="${pdto.isNext eq true }">
					<li class="page-btn"><a
						href="/web/adminnotice/adminlist?pageNum=${pdto.pageNum + 1}&str=${str}&listNum=${pdto.listNum}">다음</a>
					</li>
				</c:if>
			</ul>
		
		<hr >
		</div>


	



</main>
</body>
</html>