<%@page import="com.myweb.dto.AdminNoticeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/top2.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css?v=<%=new java.util.Date().getTime() %>">
     

<%
	String errorMessage = request.getParameter("errorMessage");
	String success = request.getParameter("success");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminview.jsp</title>
</head>
<body>
<%@include file="../topmenu.jsp" %>

<script>
    function validateForm(form) { 
        if (form.name.value == "") {
            alert("작성자를 입력하세요.");
            form.name.focus();
            return false;
        }
        if (form.title.value == "") {
            alert("제목을 입력하세요.");
            form.title.focus();
            return false;
        }
        if (form.attachedFile.value == "") {
            alert("첨부파일은 필수 입력입니다.");
            return false;
        }
    }
</script>
<body>
<main>


<div class="maintitle">

		<h2>자유게시판</h2>
</div>

<div class="Replyjsp">
    <form name="fileForm" method="post" enctype="multipart/form-data"
          action="fileUploadAction" onsubmit="return validateForm(this);">

          <table class="ReplyList-write">
          
          <tr>
          <th class="w-px160 ReplyListline">제목</th>
          <td class="Replylinetd"><input type="text" name="title" class="need reply-input" /></td>
		 </tr>
          	<tr>
          			<th class="ReplyListline">작성자</th>
          			<td class="Replylinetd">
          			<input class="reply-input"type="text" name="nickname" value=<%=session.getAttribute("nickname") %> />
					</td>          			
          	</tr>
          	<tr>
          	<th class="ReplyListline">내용 </th>
          	<td class="Replylinetd"><textarea name="content" class="reply-textarea"></textarea>
          	</tr>
          	<tr>
          		<th class="ReplyListline">
          		첨부파일
          		</th>
          		<td class="left Replylinetd"><input type="file" name="attachedFile" />
          		
          	</tr>
		</table>
	
	<div class="btnSet">
        <input style="height: 31.5px;width: 51px;" class="btn-fill" type="submit" value="저장" >
        <a class="btn-empty" href="adminlist">취소</a>
	</div>
    </form>
	</div>		     
       
       
 </main>
</body>
</html>






