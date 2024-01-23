<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.myweb.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="loginCheck-mapper.jsp" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pagination.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pagination.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pagination.css">









<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/top2.css">
<meta charset="UTF-8">
<title>memberList.jsp</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/adminpage.css">
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<!-- 탑메뉴 넣기-->
	<main>
		<%@include file="adminsubmenu.jsp"%>


		<div class="memberlistpaging">

			<div class="maintitle">
				<h2>회원 정보</h2>
			</div>



			<div class="container">
				<div class="topcount">
					<Strong>
						<ul>
							<li style="margin-left: 160px; margin-right: 0px;">총 게시물 : <span
								class="ft-blue">${pdto.totalCount}</span></li>

						</ul>
					</Strong>

				</div>

				<div class="topsearch">
					<form action="/web/membermybatis/memberList-paging" method="post">
						<select name="listNum" class="form-select"
							aria-label="Default select example">
							<!-- 선택 목록 -->
							<option value="5">5</option>
							<option value="10" selected>10</option>
							<option value="20">20</option>
						</select> <select name="slt" class="form-select">
							<!-- 선택 목록 -->
							<option value="name">이름</option>
							<option value="nickname" selected>이름or닉네임</option>
						</select> <input type="text" class="form-write" name="str"
							placeholder="검색어를 입력하세요">
						<button type="submit" class="form-btn">검색</button>
					</form>

					<script>
					var searchValue = $("#search").val();
				</script>
				</div>

			</div>





			<!--  테이블 시작-->
			<table class="memberlist">
				<!-- 선택  all 테이블 체크박스 -->

				<tr>
					<th class="w-px65 memberListTh"></th>
					<th class="w-px80	 memberListTh">아이디</th>
					<th class="w-px70 memberListTh">이름</th>
					<th class="w-px100 memberListTh">닉네임</th>
					<th class="w-px100 memberListTh">전화번호</th>
					<th class=" memberListTh">이메일</th>
					<th class="w-px90 memberListTh">가입날자</th>
				</tr>
				<c:forEach items="${list}" var="MemberDTO">
					<tr>
						<!-- 다른 필드들도 필요에 따라 출력 -->
						<td><input class="chk" type="checkbox" name="checkRow"
							id="${MemberDTO.user_id}" value="${MemberDTO.user_id}"></td>
						<td class="MemberListTd">${MemberDTO.user_id}</td>
						<td class="MemberListTd">${MemberDTO.name}</td>
						<td class="MemberListTd">${MemberDTO.nickname}</td>
						<td class="MemberListTd">${MemberDTO.phoneNumber}</td>
						<td class="MemberListTd">${MemberDTO.email}</td>
						<td class="MemberListTd">${MemberDTO.sysdate}</td>
					</tr>
				</c:forEach>


			</table>

			<div style="display: flex;">
				<div class="checkcheck">
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



			<!-- 페이징 처리값 세팅 -->
			<div class="pagebtn">
				<ul class="pagination">
					<c:if test="${pdto.isPrev eq true }">
						<li class="page-btn"><a
							href="/web/membermybatis/memberList-paging?pageNum=${pdto.pageNum - 1}&str=${str}&listNum=${pdto.listNum}">이전</a>
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
									href="/web/membermybatis/memberList-paging?pageNum=${pageNumber}&str=${str}&listNum=${pdto.listNum}">${pageNumber}</a>
								</li>

							</c:otherwise>
						</c:choose>

					</c:forEach>
					<c:if test="${pdto.isNext eq true }">
						<li class="page-btn"><a
							href="/web/membermybatis/memberList-paging	?pageNum=${pdto.pageNum + 1}&str=${str}&listNum=${pdto.listNum}">다음</a>
						</li>
					</c:if>
				</ul>

			</div>
				<hr>



		</div>






















		<script>
//체크박스 전체선택, 전체 해체	
	function checkAll() {
		if( $("#th_checkAll").is(':checked') ){
		$("input[name=checkRow]").prop("checked",true);
		}else{
			$("input[name=checkRow]").prop("checked",false);
		}
	}
	
	function deleteAction(){
		console.log("deleteAction 시작");
		var cnt = $("input[name='checkRow']:checked").length;
		let arr= [];
		var value = $("input[name='checkRow']:checked").val();
		console.log(value);
		$("input[name='checkRow']:checked").each(function(index) {
			   var bChecked = $(this).prop('checked');
			 // arr.push($(this).attr(value));
			  var value = $(this).val();
			   arr.push(value);
			  
		});
		console.log(arr);
		console.log("deleAc 성공");
		
		if(cnt == 0) { alert("선택된 글이 없습니다.");  }
		else{
		 console.log("ajax실행");
		 var user_id = arr;
		 console.log("id 체크 : " + user_id);
          $.ajax({
              // get방식일때만 사용 contentType : 'application/json',
			//contentType : 'application/json',
                type: "POST",
                traditional : true,
                url: "../membermybatis/memberdelete",
                data:  {user_id},
                dataType:"json",
                success: function(response){
                	console.log("response 체크 :" + response);
                    if(response == 1) {  alert("삭제 성공");  
                    window.location.reload() }
                    else{ alert("삭제 실패");  } },
                error: function(){alert("서버통신 오류");}
                    });
        } }
	
	
$(function(){ // onload 삭제
		$('.delete').click( function(){  
		deleteAction()
	});	
});
	
	
	
	
 </script>


	</main>
</body>
</html>