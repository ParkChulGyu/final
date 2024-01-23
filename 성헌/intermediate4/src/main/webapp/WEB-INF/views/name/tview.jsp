<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/view2.css">
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

		<div class="body-tab">
			<div class="head-tab">
				<div class="title-tab">
					<h1>${tdto.tour_name}</h1>
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
										<c:when test="${not empty tdto.inquiry_number}">
										<tr>
										<th class="jb-th">문의 번호</th>
										<td class="jb-td">${tdto.inquiry_number}</td>
										</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty tdto.post_num}">
										<tr>
										<th class="jb-th">우편번호</th>
										<td class="jb-td">${tdto.post_num}</td>
										</tr>
										</c:when>
									</c:choose>
										<c:choose>
										<c:when test="${not empty tdto.address}">
										<tr>
										<th class="jb-th">주소</th>
										<td class="jb-td">${tdto.address}</td>
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
										<c:when test="${not empty tdto.information}">
										<tr>
										<th class="jb-th">상세 정보</th>
										<td class="jb-td">${tdto.information}</td>
										</tr>
										</c:when>
									</c:choose>
										<c:choose>
										<c:when test="${not empty tdto.open}">
										<tr>
										<th class="jb-th">open</th>
										<td class="jb-td">${tdto.open}</td>
										</tr>
										</c:when>
									</c:choose>
										<c:choose>
										<c:when test="${not empty tdto.day_off}">
										<tr>
										<th class="jb-th">쉬는 날</th>
										<td class="jb-td">${tdto.day_off}</td>
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
										<c:when test="${not empty tdto.ex_info}">
										<tr>
										<th class="jb-th"> 체험 정보 </th>
										<td class="jb-td">${tdto.ex_info}</td>
										</tr>
										</c:when>
									</c:choose>
										<c:choose>
										<c:when test="${not empty tdto.parking}">
										<tr>
										<th class="jb-th">주차 시설</th>
										<td class="jb-td">${tdto.parking}</td>
										</tr>
										</c:when>
									</c:choose>
										<c:choose>
										<c:when test="${not empty tdto.pets}">
										<tr>
										<th class="jb-th">반려 동물 동반 여부</th>
										<td class="jb-td">${tdto.pets}</td>
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
				<p> ${tdto.outline} </p>

			</div>
		</div>

	</main>


</body>
</html>