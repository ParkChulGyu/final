<%@page import="com.myweb.dto.AdminNoticeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/top2.css">
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css?v=<%=new java.util.Date().getTime() %>">
     

	
	
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New.jsp</title>
</head>
<body>
<%@include file="../topmenu.jsp" %>

<main>
<div class="maintitle">

		<h2>Q&A</h2>
</div>
<div class="Replyjsp">

<form action="insert" method="post" enctype="multipart/form-data">


	<table class="ReplyList-write">
		<tr>
			<th class="w-px160 ReplyListline">제목</th>
			<td class="Replylinetd"><input type="text" name="title" class="need reply-input" /></td>
		</tr>
		<tr>
			<th class="ReplyListline">작성자${idx }</th>
			<td class="Replylinetd">${nickname }</td>
		</tr>
		<tr>
			<th class="ReplyListline">내용</th>
			<td class="Replylinetd"><textarea name="content" class="need reply-textarea"></textarea></td>
		</tr>
		<tr>
			<th class="ReplyListline">파일 첨부</th>
			<td class="left Replylinetd">
				<label>
					<input type="file" name="file" id="attach-file" />
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-image" viewBox="0 0 16 16">
  							<path d="M6.002 5.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
  							<path d="M2.002 1a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2h-12zm12 1a1 1 0 0 1 1 1v6.5l-3.777-1.947a.5.5 0 0 0-.577.093l-3.71 3.71-2.66-1.772a.5.5 0 0 0-.63.062L1.002 12V3a1 1 0 0 1 1-1h12z"/>
					</svg>
				파일 업로드
					<!-- <img src="img/select.png" class="file-img" /> -->
				</label>
				<span id="file-name" name="attachedFile"></span>
				<span id="delete-file" style="color: red; margin-lefT: 20px;"><i class="fas fa-times font-img" ></i></span>
 			</td>
		</tr>
	</table>
</form>
<div class="btnSet">
	<!--  <a class="btn-fill" onclick="if(necessary()) $('form').submit()">저장</a> -->
	<a class="btn-fill" onclick="if (necessary()) { $('form').submit(); }">저장</a>
	<a class="btn-empty" href="Qna">취소</a>
</div>

</div>




<script>
/**
 * 입력 항목에 입력되어 있는지 반환하는 함수
 */
 function necessary() {
 	$('.need').each(function(){
 		if($(this).val() == "") {
 			alert("입력하세요!");
 			$(this).focus();
 			need = false;
 			return need;
 		}else{
 			need=true;
 		}
 		console.log(need);
 	});
 	return need;
 }
 
 $('[name=title]').on('keypress', function(e) {
	    if (e.key === 'Enter') {
	        e.preventDefault(); // 기본 엔터 동작 방지
	        if (necessary()) {
	            $('form').submit();
	        } else {
	            return false;
	        }
	    }
	});
 
 
 
 
 /**
  * 첨부파일 관련 처리
  */
  /* 파일을 선택했을 때 파일명이 보이게 처리 */
 $('#attach-file').on('change', function(){
	 	$('#file-name').text( this.files[0].name );
	 	$('#delete-file').css('display', 'inline');
	 });
	 $('#delete-file').on('click', function(){
	 	$('#file-name').text('');
		$('#delete-file').css('display', 'none');
		$('#attach-file').val('');
	 });
 
</script>

	




</main>

</body>
</html>