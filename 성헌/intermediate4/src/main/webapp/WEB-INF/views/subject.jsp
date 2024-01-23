<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String uri = request.getRequestURI();
String[] urlArr = uri.split("/");
int len = urlArr.length;
String subject = urlArr[len-2].toUpperCase();
%>
<h1>v.<%=subject %></h1>