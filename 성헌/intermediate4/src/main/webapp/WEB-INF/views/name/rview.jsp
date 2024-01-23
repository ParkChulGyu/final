<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/view2.css">


</head>
<body>
	<%@include file="../topmenu.jsp"%>

	<main>

		<div class="body-tab">
			<div class="head-tab">
				<div class="title-tab">
					<h1>${rdto.res_name}</h1>
				</div>
				<!--  이미지 탭  -->
				<div class="tab-inner">
					<input type="radio" name="img-tabmenu" id="tab1" checked="checked">
					<input type="radio" name="img-tabmenu" id="tab2"> <input
						type="radio" name="img-tabmenu" id="tab3">
					<div class="content slide1">
						<img
							src="${pageContext.request.contextPath}/resources/img/${ilist[0].file_name}"
							class="card-img-top" alt="...">
					</div>
					<div class="content slide2">
						<img
							src="${pageContext.request.contextPath}/resources/img/${ilist[1].file_name}"
							class="card-img-top" alt="...">
					</div>
					<div class="content slide3">
						<img
							src="${pageContext.request.contextPath}/resources/img/${ilist[2].file_name}"
							class="card-img-top" alt="...">
					</div>
					<div class="btn">
						<label for="tab1"></label> <label for="tab2"></label> <label
							for="tab3"></label>
					</div>
				</div>
				<!--  이미지 탭  종료 -->

				<!-- text tep  -->
				
				<div class="text-tabmenu out-tabmenu">
					<ul>
						<li id="tab1" class="btnCon"><input type="radio" checked
							name="text-tabmenu" id="tabmenu1"> <label for="tabmenu1">기본
								정보</label>
							<div class="tabCon">
								<table class="table-tab">
									<c:choose>
										<c:when test="${not empty rdto.reservation}">
										<tr>
										<th class="jb-th">문의 번호</th>
										<td class="jb-td">${rdto.reservation}</td>
										</tr>
										</c:when>
									</c:choose>
									
									<c:choose>
										<c:when test="${not empty rdto.business_number}">
										<tr>
										<th class="jb-th">사업자 번호</th>
										<td class="jb-td">${rdto.business_number}</td>
										</tr>
										</c:when>
									</c:choose>
									
									<c:choose>
										<c:when test="${not empty rdto.post_num}">
										<tr>
										<th class="jb-th">우편번호</th>
										<td class="jb-td">${rdto.post_num}</td>
										</tr>
										</c:when>
									</c:choose>
									
										<c:choose>
										<c:when test="${not empty rdto.address}">
										<tr>
										<th class="jb-th">주소</th>
										<td class="jb-td">${rdto.address}</td>
										</tr>
										</c:when>
									</c:choose>
									
										<c:choose>
										<c:when test="${not empty rdto.information}">
										<tr>
										<th class="jb-th">상세 정보</th>
										<td class="jb-td">${rdto.information}</td>
										</tr>
										</c:when>
									</c:choose>
									
								</table>
							</div></li>
						<li id="tab2" class="btnCon"><input type="radio"
							name="text-tabmenu" id="tabmenu2"> <label for="tabmenu2">이용
								안내</label>
							<div class="tabCon">
							<table class="table-tab">
									<c:choose>
										<c:when test="${not empty rdto.open}">
										<tr>
										<th class="jb-th">영업 시간</th>
										<td class="jb-td">${rdto.open}</td>
										</tr>
										</c:when>
									</c:choose>
									
										<c:choose>
										<c:when test="${not empty rdto.day_off}">
										<tr>
										<th class="jb-th">쉬는 날</th>
										<td class="jb-td">${rdto.day_off}</td>
										</tr>
										</c:when>
									</c:choose>
								</table>
							</div></li>
						<li id="tab3" class="btnCon"><input type="radio"
							name="text-tabmenu" id="tabmenu3"> <label for="tabmenu3">기타 정보</label>
							<div class="tabCon">
							
							<table class="table-tab">
									<c:choose>
										<c:when test="${not empty rdto.menu}">
										<tr>
										<th class="jb-th"> 메 뉴 </th>
										<td class="jb-td">${rdto.menu}</td>
										</tr>
										</c:when>
									</c:choose>
									
										<c:choose>
										<c:when test="${not empty rdto.recommend}">
										<tr>
										<th class="jb-th">추천 메뉴</th>
										<td class="jb-td">${rdto.recommend}</td>
										</tr>
										</c:when>
									</c:choose>
										<c:choose>
										<c:when test="${not empty rdto.parking}">
										<tr>
										<th class="jb-th">주차 시설</th>
										<td class="jb-td">${rdto.parking}</td>
										</tr>
										</c:when>
									</c:choose>
									
										<c:choose>
										<c:when test="${not empty rdto.packaging}">
										<tr>
										<th class="jb-th">메뉴 포장</th>
										<td class="jb-td">${rdto.packaging}</td>
										</tr>
										</c:when>
									</c:choose>
								</table>
							</div></li>
					</ul>
				</div>
			</div>
			<!-- 설명 끝 -->
			<div class="content-tab">
			<h2> 상세 설명 </h2>
				<p> ${rdto.outline} </p>

			</div>
		</div>

	</main>


</body>
</html>