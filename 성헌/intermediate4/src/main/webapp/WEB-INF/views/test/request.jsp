<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../topmenu.jsp" %>
<h2>
@RequestParam
<ul>
<li>get / post 방식 값 받을 때</li>
<li>request.getParameter 역할</li>
<li>DTO 사용시에는 사용 안함</li>
</ul>
</h2>
<h3>
<hr>
GET1 : <a href="get?id=get-hong">GTE @RequestMapping</a> <br>
GET2 : <a href="get2?id2=get-hong">GET @GetMapping</a> <br>
<hr>
POST - DTO (@RequestMapping)
<form action="postDTO" method="post">
<input type="text" name="id" value="post-dto-hong1">
<input type="text" name="pw" value="post-dto-1111">
<input type="submit" value="post request">
</form> 
<hr>
POST - Map (@PostMapping)
<form action="postMap" method="post">
<input type="text" name="id" value="post-map-hong1">
<input type="text" name="pw" value="post-map-1111">
<input type="submit" value="post request">
</form> 
<hr>
POST - List(Name 값이 같은 경우)
<form action="postList" method="post">
<input type="text" name="id" value="post-list-hong1">
<input type="text" name="id" value="post-list-hong2">
<input type="submit" value="post request">
</form>
</h3>
<hr>
<h2>
Response : View로 이동하는 방법
<ol>
Forward 방식
<li>String + Model 객체</li>
<li>ModelAndView 객체</li>
<li>request.setAttribute("key", object) == Model.addAttribute("key", object)</li>
<li>request.setAttribute("key", object) == ModelAndView.addObject("key", object)</li>
</ol>
<ol>
Redirect 방식
<li>respons.sendRedirect() == "redirect:"</li>
</ol>
<hr>
POST - DTO (String - Model 방식)
<form action="postSM" method="post">
<input type="text" name="id" value="post-string-model-hong1">
<input type="text" name="pw" value="post-string-model-1111">
<input type="submit" value="post request">
</form> 
<hr>
POST - DTO (ModelAndView 방식)
<form action="postMAV" method="post">
<input type="text" name="id" value="post-modelandview-hong1">
<input type="text" name="pw" value="post-modelandview-1111">
<input type="submit" value="post request">
</form> 
</h2>
</body>
</html>