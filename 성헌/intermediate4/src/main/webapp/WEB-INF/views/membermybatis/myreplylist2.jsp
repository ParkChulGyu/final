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


<style>








.tab-box{
border: 2px solid #bebebe;
border-radius: 30px;
margin-top : 5px; 
box-shadow: 5px 5px 10px 2px #e0e0e0;
text-align: center;
 height : 50px;
 width: 260px;
 
 

}
 
 
.tab-box .tab-tpye1 {
display: flex; /* 가로 정렬을 위한 flex 속성 적용 */

 margin-top: 0px;
    margin-bottom: 0px;
    
    padding-left: 0px;
    
    

}




.tab-tpye1 li {
display: flex;
  padding: 10px;
  margin: 5px;
    z-index: 1;
    width : 50%
}






.on-back button {
    z-index: 1;
    border : none;
    background-color : transparent ;
        display: flex;
    justify-content: center;
    align-items: center;
    align-self: center;
    font-size : 15px;
    
}










#Qnabtn {
    left: 0;
}

#Freebtn {
    left: 100px; /* 예시로 100px만큼 이동 */
}


.on-back {
    text-align: center;
}

#backgroundM {

    position: absolute;
    width: 120px;
    height: 38px;
    background-color: transparent;
     cursor: pointer;
    z-index: 0;
    background-color: #5F8CDD !important;
transition: left 0.3s cubic-bezier(0, 0, 1, 1);
border-radius: 28px;
		left: 25px;
		top: 16px;

}



</style>
<%
request.setCharacterEncoding("utf-8");

MemberDTO dto = (MemberDTO)request.getAttribute("dto");
%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
    <title>YouTube 알림</title>
  
<main>




		<div class="home-container-right">
		<div id="backgroundM" onclick="this.style.left='100px' "></div>
<div class="tab-box">
	<ul class="tab-tpye1">
		<li id="Qnali"  onclick="moveBackground1()" class="on-back">	
			<button  id="Qnabtn" class="buttonfirst1 " type="button" title="" > <Strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Qna</Strong></button>
		</li>
		
		<li id="Freeli"  onclick="moveBackground2()" class="on-back">
			<button id="Freebtn" class="buttonfirst2" type="button" title="" ><Strong>자유게시판</Strong></button>
		</li>
	</ul>
</div>
		</div>











<script>
window.onload = function() {
    // 페이지가 로드될 때 실행되는 코드
  };
    
  
  function moveBackground1() {
	    document.getElementById('backgroundM').style.left = '25px';
	}
    
  function moveBackground2() {
	    document.getElementById('backgroundM').style.left = '140px';
	}
    
  
 
  
  

    
    
</script>

</main>
</body>
</html>