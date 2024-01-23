<%@page import="com.myweb.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="loginCheck-mapper.jsp" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pagination.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pagination.css">


<%
request.setCharacterEncoding("utf-8");

MemberDTO dto = (MemberDTO) request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/top2.css">
<meta charset="UTF-8">
<title>myqnalist.jsp</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
</head>
<body>
	<header>
		<%@include file="../topmenu.jsp"%>
	</header>
	<main>
		<%@include file="submenu.jsp"%>



		<div class="myreplylist">


			<div class="maintitle">
				<h2>내가 단 댓글</h2>
			</div>
			
			<div class="topcountmy">
				<Strong>
					<ul>
						<li style="margin-left: 125px; margin-bottom: 10px;">총 게시물 :
							<span class="ft-blue">${pdto.totalCount}</span>
						</li>

					</ul>
				</Strong>
			</div>
			
			
			<table class="myreplylisttable">
				<tr>
					<th class="myreplylisttableTh"></th>
					<th class="myreplylisttableTh" >내용</th>
					<th class="myreplylisttableTh">작성일</th>
				</tr>
				<c:forEach items="${list}" var="replyDTO" varStatus="dto">


					<tr>
						<td class="myreplylisttabletd" >${replyDTO.idx }</td>
						<td class="myreplylisttabletd" ><a
							href="/web/adminnotice/adminview?idx=${replyDTO.bidx }">${replyDTO.content }</a></td>
						<td class="myreplylisttabletd" >${replyDTO.regdate }</td>

					</tr>


				</c:forEach>
			</table>

			<!-- 페이징 처리값 세팅 -->
			<div class="pagebtn">
				<ul class="pagination">
					<c:if test="${pdto.isPrev eq true }">
						<li class="page-btn"><a
							href="/web/membermybatis/myreplylist?pageNum=${pdto.pageNum - 1}&listNum=${pdto.listNum}">이전</a>
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
									href="/web/membermybatis/myreplylist?pageNum=${pageNumber}&listNum=${pdto.listNum}">${pageNumber}</a>
								</li>

							</c:otherwise>
						</c:choose>

					</c:forEach>
					<c:if test="${pdto.isNext eq true }">
						<li class="page-btn"><a
							href="/web/membermybatis/myreplylist?pageNum=${pdto.pageNum + 1}&listNum=${pdto.listNum}">다음</a>
						</li>
					</c:if>
				</ul>

				<hr>
			</div>






		</div>







	</main>
</body>
</html>