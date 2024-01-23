<%@page import="com.myweb.dto.MywritelistDTO"%>
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



		<div class="mywritelist">



			<div class="maintitle">
				<h2>내가 쓴 글</h2>
			</div>



			<div class="container">
				<div class="topcount">
					<Strong>
						<ul>
							<li>총 게시물 : <span class="ft-blue">${pdto.totalCount}</span></li>

						</ul>
					</Strong>

				</div>
				<div class="topsearch">
					<form action="/web/membermybatis/mywritelist" method="Get">
						<select name="selectdate" style="width: 78px;"class="form-select">
							<!-- 선택 목록 -->
							<option value="최신순">최신순</option>
							<option value="오래된순">오래된 순</option>
						</select> <select name="slt"  style="width: 88px;" class="form-select">
							<!-- 선택 목록 -->
							<option value="" selected>모두</option>
							<option value="Qna">Qna</option>
							<option value="자유게시판">자유게시판</option>
						</select>
						<button type="submit" class="form-btn">검색</button>
					</form>

					<script>
						var searchValue = $("#search").val();
					</script>

				</div>
			</div>


			<table class="mywrite">



				<tr>
					<th class="w-px65 MywriteTh"></th>
					<th class="w-px65 MywriteTh left"></th>
					<th class="w-px110 MywriteTh">카테고리</th>
					<th class="MywriteTh">제목</th>
					<th class="w-px120 MywriteTh">작성일</th>
					<th class="w-px80 MywriteTh">조회</th>
				</tr>
				<c:forEach items="${list}" var="MywritelistDTO" varStatus="dto">

					<tr>
						<td><input class="chk" type="checkbox" name="checkRow"
							id="${MywritelistDTO.idx}" value="${MywritelistDTO.idx}"
							category="${MywritelistDTO.category}"></td>
						<td class="MywriteTd">${MywritelistDTO.idx }</td>
						<td class="MywriteTd">#${MywritelistDTO.category }</td>
						<c:choose>
							<c:when test="${MywritelistDTO.category eq '자유게시판'}">
								<td class="Title"><a
									href="/web/adminnotice/adminview?idx=${MywritelistDTO.idx}">${MywritelistDTO.title}</a></td>
							</c:when>
							<c:otherwise>
								<td class="Title"><a
									href="/web/Qna/detail?idx=${MywritelistDTO.idx }">${MywritelistDTO.title }</a></td>
							</c:otherwise>
						</c:choose>
						<td class="MywriteTd">${MywritelistDTO.regdate }</td>
						<td class="MywriteTd">${MywritelistDTO.totalcount }</td>
					</tr>


				</c:forEach>
			
						
					




			</table>
				
				<div style="display: flex;">
					<div class ="checkcheck">
					<input type="checkbox" id="th_checkAll" onclick="checkAll();">
					<label for="th_checkAll">전체선택</label> 
					</div>				
						
				<div class="deletebtn">
					<ul>
				<!--<core:if test="${login_info.admin eq 'Y' }">-->
						<li><button class="delete">삭제</button></li>
				<!--</core:if>-->
					</ul>
				</div>
				</div>



















			<div class="pagebtn">
				<ul class="pagination">
					<c:if test="${pdto.isPrev eq true }">
						<li class="page-btn"><a
							href="/web/membermybatis/mywritelist?pageNum=${pdto.pageNum - 1}&slt=${slt}&listNum=${pdto.listNum}&selectdate=${selectdate}">이전</a>
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
									href="/web/membermybatis/mywritelist?pageNum=${pageNumber}&slt=${slt}&listNum=${pdto.listNum}&selectdate=${selectdate}">${pageNumber}</a>
								</li>

							</c:otherwise>
						</c:choose>

					</c:forEach>
					<c:if test="${pdto.isNext eq true }">
						<li class="page-btn"><a
							href="/web/membermybatis/mywritelist?pageNum=${pdto.pageNum + 1}&slt=${slt}&listNum=${pdto.listNum}&selectdate=${selectdate}">다음</a>
						</li>
					</c:if>
				</ul>

				<hr>
			</div>






		</div>

		<script>
			//체크박스 전체선택, 전체 해체	
			function checkAll() {
				if ($("#th_checkAll").is(':checked')) {
					$("input[name=checkRow]").prop("checked", true);
				} else {
					$("input[name=checkRow]").prop("checked", false);
				}
			}

			function deleteAction(category) {

				var cnt = $("input[name='checkRow']:checked").length;
				var qnalist = [];
				var adminlist = [];

				var value = $("input[name='checkRow']:checked").val();
				console.log(value);

				$("input[name='checkRow']:checked").each(function(index) {
					var bChecked = $(this).prop('checked');
					var category = $(this).attr('category');

					if (category === '자유게시판') {
						var adminidx = $(this).val();
						adminlist.push(adminidx);
					} else if (category === 'Qna') {
						var qnaidx = $(this).val();
						qnalist.push(qnaidx);
					}
				});

				if (cnt == 0) {
					alert("선택된 글이 없습니다.");
				} else {
					console.log("ajax실행");
					var qna = qnalist;
					var admin = adminlist;

					if (qna == '') {
						console.log("ㅇㄹㅇㄹ하위");
						qna = 'nop';
					}
					if (admin == '') {
						console.log("ㅇㄹㅇㄹㅇ하위");
						admin = 'nop';
					}

					console.log("qna실행 " + qna);
					console.log("admin실행" + admin);

					$.ajax({
						// get방식일때만 사용 contentType : 'application/json',
						//contentType : 'application/json',
						type : "POST",
						traditional : true,
						url : "../membermybatis/mywritelistD",
						data : {
							qna : qna,
							admin : admin
						},
						dataType : "json",

						success : function(response) {
							console.log("response 체크 :" + response);
							if (response == 1) {
								alert("삭제 성공");
								window.location.reload()
							} else {
								alert("삭제 실패");
							}
						},
						error : function() {
							alert("서버통신 오류");
						}
					});
				}
			}

			$(function() { // onload 삭제
				$('.delete').click(function() {

					deleteAction();

				});
			});
		</script>

















	</main>
</body>
</html>