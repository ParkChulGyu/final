<%@page import="com.myweb.dto.AdminNoticeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/common.css?v=<%=new java.util.Date().getTime() %>">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/top2.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pagination.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pagination.css">


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qna.jsp</title>
</head>
<body>
	<c:import url="../topmenu.jsp" />
<main>
	<div class="maintitle">
		<h2>Q&A</h2>
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
				<th>제목</th>
				<th class="w-px100 QnaListTh">작성자</th>
				<th class="w-px120 QnaListTh">작성일자</th>
				<th class="w-px70 QnaListTh">첨부파일</th>
			</tr>


			<c:forEach items="${list }" var="QnaDTO" varStatus="dto">


				<tr>
					<td class="QnaListTd">${QnaDTO.no }</td>
					<td class="Title"><c:forEach var="i" begin="1"
							end="${QnaDTO.indent }">
							<div class="arrowimg">

								<c:choose>
									<c:when test="${i eq OnaDTO.indent}">
      					&nbsp;&nbsp;
                            </c:when>
									<c:otherwise>
										<img
											src=${pageContext.request.contextPath}/resources/svg/arrow-return-right.svg />
									</c:otherwise>

								</c:choose>
							</div>
						</c:forEach>
						<div class="atitle">
							<a href="detail?idx=${QnaDTO.idx }">${QnaDTO.title }</a>
						</div></td>

					<td class="QnaListTd">${QnaDTO.writer }</td>
					<td class="QnaListTd">${QnaDTO.regdate }</td>
					<td class="QnaListTd"><c:if test="${!empty QnaDTO.filename }">
							<a href="download?idx=${QnaDTO.idx }"> <svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-download" viewBox="0 0 16 16"
									title="${QnaDTO.filename }">
 							 <path
										d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z" />
  							 <path
										d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3z" />
					</svg>
							</a>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>




		<div class="writebtn">
			<ul>
				<!--<core:if test="${login_info.admin eq 'Y' }">-->
				<li><a class="" href="New">글쓰기</a></li>
				<!--</core:if>-->
			</ul>
		</div>








		<!-- 페이징 처리값 세팅 -->
		<div class="pagebtn">
			<ul class="pagination">
				<c:if test="${pdto.isPrev eq true }">
					<li class="page-btn"><a
						href="/web/Qna/Qna?pageNum=${pdto.pageNum - 1}&str=${str}&listNum=${pdto.listNum}">이전</a>
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
								href="/web/Qna/Qna?pageNum=${pageNumber}&str=${str}&listNum=${pdto.listNum}">${pageNumber}</a>
							</li>

						</c:otherwise>
					</c:choose>

				</c:forEach>
				<c:if test="${pdto.isNext eq true }">
					<li class="page-btn"><a
						href="/web/Qna/Qna?pageNum=${pdto.pageNum + 1}&str=${str}&listNum=${pdto.listNum}">다음</a>
					</li>
				</c:if>
			</ul>
		
		<hr >
		</div>

	





</main>	
</body>
</html>