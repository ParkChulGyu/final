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
					<h1>${hdto.hotel_name}</h1>
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
										<c:when test="${not empty hdto.reservation}">
											<tr>
												<th class="jb-th">문의 번호</th>
												<td class="jb-td">${hdto.reservation}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.post_num}">
											<tr>
												<th class="jb-th">우편번호</th>
												<td class="jb-td">${hdto.post_num}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.address}">
											<tr>
												<th class="jb-th">주소</th>
												<td class="jb-td">${hdto.address}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.home_page}">
											<tr>
												<th class="jb-th">상세 정보 홈페이지 </th>
												<td class="jb-td">${hdto.home_page}</td>
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
										<c:when test="${not empty hdto.pick_up}">
											<tr>
												<th class="jb-th">접근성</th>
												<td class="jb-td">${hdto.pick_up}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.other}">
											<tr>
												<th class="jb-th">편의 시설 </th>
												<td class="jb-td">${hdto.other}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.café}">
											<tr>
												<th class="jb-th">카페 </th>
												<td class="jb-td">${hdto.café}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.information}">
											<tr>
												<th class="jb-th">추가 상세 정보</th>
												<td class="jb-td">${hdto.information}</td>
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
										<c:when test="${not empty hdto.volume}">
											<tr>
												<th class="jb-th">규 모</th>
												<td class="jb-td">${hdto.volume}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.room_type}">
											<tr>
												<th class="jb-th">객실 종류</th>
												<td class="jb-td">${hdto.room_type}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.parking}">
											<tr>
												<th class="jb-th">주차 시설</th>
												<td class="jb-td">${hdto.parking}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.cooking}">
											<tr>
												<th class="jb-th">조리 시설</th>
												<td class="jb-td">${hdto.cooking}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.check_in}">
											<tr>
												<th class="jb-th">입실 정보</th>
												<td class="jb-td">${hdto.check_in}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.check_out}">
											<tr>
												<th class="jb-th">퇴실 정보</th>
												<td class="jb-td">${hdto.check_out}</td>
											</tr>
										</c:when>
									</c:choose>
									
									<c:choose>
										<c:when test="${not empty hdto.seminar}">
											<tr>
												<th class="jb-th">세미나</th>
												<td class="jb-td">${hdto.seminar}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.sports}">
											<tr>
												<th class="jb-th">스포츠 시설</th>
												<td class="jb-td">${hdto.sports}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.beauty}">
											<tr>
												<th class="jb-th">미용 시설</th>
												<td class="jb-td">${hdto.beauty}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.karaoke}">
											<tr>
												<th class="jb-th">노래방</th>
												<td class="jb-td">${hdto.karaoke}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.bbq}">
											<tr>
												<th class="jb-th">바베큐</th>
												<td class="jb-td">${hdto.bbq}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.campfire}">
											<tr>
												<th class="jb-th">캠프 파이어</th>
												<td class="jb-td">${hdto.campfire}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.bicycle_rental}">
											<tr>
												<th class="jb-th">자전거 대여</th>
												<td class="jb-td">${hdto.bicycle_rental}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.gym}">
											<tr>
												<th class="jb-th">gym</th>
												<td class="jb-td">${hdto.gym}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.public_pc}">
											<tr>
												<th class="jb-th">공용 PC</th>
												<td class="jb-td">${hdto.public_pc}</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty hdto.shower}">
											<tr>
												<th class="jb-th">외부 샤워 시설</th>
												<td class="jb-td">${hdto.shower}</td>
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
				<h2>상세 설명</h2>
				<p>${hdto.outline}</p>

			</div>
		</div>

	</main>


</body>
</html>