<%@page import="com.myweb.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>name/tourlist.jsp</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/top2.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pagination.css">
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<main>
		<h1>tourlist</h1>
		<h4>
			<form action="/web/name/tourlist" method="post">
				<select name="listNum"  class="form-select"  aria-label="Default select example">
					<!-- 선택 목록 -->
					<option value="5" selected>5</option>
					<option value="10">10</option>
					<option value="20">20</option>
				</select> 
				<select name="slt" class="form-select"  style=" width: 150px; ">
					<!-- 선택 목록 -->
					<option value="name">이름</option>
					<option value="nickname" selected>이름or닉네임</option>
				</select>
				<div>
				 <input type="text" class="form-write" name="str" placeholder="검색어를 입력하세요">
				<button type="submit" class="form-btn">검색</button>
				</div>
			</form>
			
			<hr>
			<h6>
			<strong>
			<ul>
			<il>총 게시물 : ${pdto.totalCount}</il>
			<il>총 페이지 : ${pdto.totalPage}</il>
			<il> now : ${pdto.pageNum}</il>
			</ul>
			</strong>
			</h6>


			<c:forEach var="tn" items="${tnlist}" varStatus="statusNm">
				<c:choose>
					<c:when test="${statusNm.index % 5 == 0}">
						<div class="card-group">
					</c:when>
				</c:choose>

				<c:forEach var="fn" items="${fnlist[statusNm.index]}"
					varStatus="status">
					<li>
						<div style="position: relative; display: inline-block;">
							<div class="card" style="width: 18rem;">
								<a href="../name/tview?name=${tn}"> <img
									src="${pageContext.request.contextPath}/resources/img/${fn}"
									class="card-img-top" alt="...">
									
									<div class="card-body">
										<p class="card-text">
											<strong>${tn}</strong>
										</p></a>
							</div>
						</div>
						</div>
					</li>
				</c:forEach>

				<c:choose>
					<c:when test="${statusNm.index % 5 == 4 or statusNm.last}">
						</div>
					</c:when>
				</c:choose>
			</c:forEach>

			<hr>

			<!-- 페이징 처리값 세팅 -->
			<ul class="pagination">
				<c:if test="${pdto.isPrev eq true }">
					<li class="page-btn"><a
						href="/web/name/tourlist?pageNum=${pdto.pageNum - 1}&str=${str}&listNum=${listNum}">이전</a>
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
								href="/web/name/tourlist?pageNum=${pageNumber}&str=${str}&listNum=${listNum}">${pageNumber}</a>
							</li>

						</c:otherwise>
					</c:choose>

				</c:forEach>
				<c:if test="${pdto.isNext eq true }">
					<li class="page-btn"><a
						href="/web/name/tourlist?pageNum=${pdto.pageNum + 1}&str=${str}&listNum=${listNum}">다음</a>
					</li>
				</c:if>
			</ul>

		</h4>
	</main>
</body>
</html>




