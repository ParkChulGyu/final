<%@page import="com.myweb.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<title>name/tourlist.jsp</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
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
		<h1>Cartllist</h1>
		<h4>
			<h6>
				<strong>
					<ul>
						<il>총 게시물 : ${pdto.totalCount}</il>
						<il>총 페이지 : ${pdto.totalPage}</il>
						<il> now : ${pdto.pageNum}</il>
					</ul>
				</strong>
			</h6>
			<c:forEach var="CartDTO" items="${cartdtolist}" varStatus="statusNm">
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
								<c:choose>
									<c:when test="${like_num[statusNm.index] eq 0}">
										<p><button id="likeButton-${statusNm.index}" class="like-button" data-value1="${CartDTO.title_name}" data-value2="${CartDTO.category}" data-value3="<%=session.getAttribute("user_id") %>" style="position: absolute; top: 20px; left: 20px;">
									<svg name="unlike" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart"
										viewBox="0 0 16 16">
      									  <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.920 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z" />
    								</svg>
										</button></p>
									</c:when>
									<c:when test="${like_num[statusNm.index] eq 1}">
										<p><button id="likeButton-${statusNm.index}" class="like-button" data-value1="${CartDTO.title_name}" data-value2="${CartDTO.category}" data-value3="<%=session.getAttribute("user_id") %>" style="position: absolute; top: 20px; left: 20px;">
									<svg name="like" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16"> <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/> </svg>
								</button></p>
									</c:when>
									<c:otherwise>
										<p><button id="likeButton-${statusNm.index}" class="like-button" data-value1="${CartDTO.title_name}" data-value2="${CartDTO.category}" data-value3="<%=session.getAttribute("user_id") %>" style="position: absolute; top: 20px; left: 20px;">
									<svg name="unlike" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
      									  <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.920 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z" />
    								</svg>
										</button></p>
									</c:otherwise>
								</c:choose>
								<a href="../name/findview?name=${CartDTO.title_name}&category=${CartDTO.category}">
									<img src="${pageContext.request.contextPath}/resources/img/${fn}" class="card-img-top" alt="...">
									<div class="card-body">
										<p class="card-text">
											<strong>${CartDTO.title_name}</strong> 
										</p>
								</a>
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
					<li class="page-btn"><a	href="/web/name/cartlist?pageNum=${pdto.pageNum - 1}&str=${str}&listNum=${listNum}&region=${region}">이전</a>	</li>
				</c:if>
				<c:forEach begin="${pdto.startPage}" end="${pdto.endPage}" var="pageNumber">
					<c:choose>
						<c:when test="${pageNumber eq pdto.pageNum}">
							<li class="page-btn"><a href="javascript:void(0);" style="cursor: default;">${pageNumber}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-btn"><a	href="/web/name/cartlist?pageNum=${pageNumber}&listNum=${listNum}">${pageNumber}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pdto.isNext eq true }">
					<li class="page-btn"><a
						href="/web/name/cartlist?pageNum=${pdto.pageNum + 1}&listNum=${listNum}">다음</a>
					</li>
				</c:if>
			</ul>
		</h4>
	</main>


	<script>
		$(function() {
			$("button[id^='likeButton-']")
					.click(
							function() {
								// 클릭된 버튼의 ID에서 인덱스 값을 추출
								var index = $(this).attr('id').split('-')[1];
								// 추출한 인덱스 값을 사용하여 작업 수행
								console.log('클릭된 버튼의 인덱스:', index);
								// 이후에 원하는 작업을 수행할 수 있습니다.
								// 예를 들면, AJAX 요청 등을 처리할 수 있습니다.

								var title_name = $("#likeButton-" + index).data('value1');
								console.log("인덱스에 따른 like 버튼name : "	+ title_name); // 'value1'
								var category = $("#likeButton-" + index).data('value2');
								console.log("인덱스에 따른 like 버튼category : "	+ category); // 'value2'
								// AJAX 요청으로 세션값 가져오기
								var user_id = $("#likeButton-" + index).data('value3');
								console.log("인덱스에 따른 session_id : " + user_id); // 'value2'
								// AJAX 요청으로 세션값 가져오기

								var svgIcon = $("#likeButton-" + index + " svg");

								console.log("인덱스에 따른 svgIcon : " + svgIcon); // 'value2'
								// AJAX 요청으로 세션값 가져오기

								var svgname = $(this).find("svg").attr("name");
								console.log("인덱스에 따른 svgname : " + svgname);

								if (user_id == null) { // id 값 없으면 로그인으로 보내기
									alert("로그인 후 가능한 기능입니다.");
									window.location.href = "../membermybatis/login-mapper";
								} else { // 로그인 후

									// 버튼 모양 바꾸기
									var SVGunlike = '<svg name="unlike" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16"> <path	d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.920 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z" /> </svg>';
									var SVGlike = '<svg name="like" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16"> <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/> </svg>';

									if (svgname === "unlike") {
										$("#likeButton-" + index + " svg")
												.replaceWith(SVGlike);

										// ajex로 값 던지기
										$.ajax({
											url : "../name/like",
											type : "POST",
											data : {
												user_id : user_id,
												title_name : title_name,
												category : category
											},
											success : function(result) {
												if (result === 1) {
													alert("담아두기에서 추가 하였습니다.");
												}
											},
										});

									} else {//로그인 후 else
										$("#likeButton-" + index + " svg")
												.replaceWith(SVGunlike);

										// ajex로 값 던지기
										$.ajax({
											url : "../name/unlike",
											type : "POST",
											data : {
												user_id : user_id,
												title_name : title_name,
												category : category
											},
											success : function(result) {
												if (result === 1) {
													alert("담아두기에서 제외 하였습니다.");
												}

											},
										});

									}//로그인 후 else

								}// 버튼 모양 바꾸기 end

							});
		});
	</script>








</body>
</html>

