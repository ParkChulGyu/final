<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// loginCheck.jsp
if(session.getAttribute("user_id") == null){
%>
 <script>
	alert('session이 끊겼습니다.!!');
	location.href = 'login';
</script>	
<%	
}
%> 