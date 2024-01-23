pdto<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.myweb.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

<%
	request.setCharacterEncoding("utf-8");
		List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("list");
%>
		

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/top2.css">
</head>
<body>
<%@include file="submenu.jsp" %>
<h2>회원목록</span></h2>
<hr>
<table border="1">
<tr>
	<th>Idx</th>
	<th >ID</th>
	<th>PW</th>
	<th>Name</th>
	<th>NickName</th>
	<th>Email</th>
	<th>PhonNumber</th>
	<th>Sysdate</th>
	<th>Point</th>
	<th>Grade</th>
	<th>전체선택<input type="checkbox" name="checkAll" id="th_checkAll" onclick="checkAll();"></th>
</tr>
	<button class="delete">삭제</button>
		
		
        
<%
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a HH:mm"); 

%>
		
<% for (MemberDTO dto : list) { %>
	<%
		dto.getSysdate().setHours(dto.getSysdate().getHours()-9);	
	
	String strNowDate = simpleDateFormat.format(dto.getSysdate()); 
	
	%>
	<tr>
		<td><%=dto.getUser_idx()%></td>
		<td><%=dto.getUser_id()%></td>
		<td><%=dto.getPw() %></td>
		<td><%=dto.getName()%></td>
		<td><%=dto.getNickname() %></td>
		<td><%=dto.getEmail() %></td>
		<td><%=dto.getPhoneNumber() %></td>
		<td><%=strNowDate%></td>
		<td><%=dto.getPoint() %></td>
		<td><%=dto.getGrade() %></td>
		<td><input class="chk" type="checkbox" name="checkRow" id=<%=dto.getUser_id()%> value=<%=dto.getUser_id()%>></td>
	</tr>
<% } %>
</table>



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
		console.log("hi");
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
		console.log("hi");
		
		if(cnt == 0) {
		 alert("선택된 글이 없습니다.");
		}
		 else{
		 console.log("ajax실행");
		 var user_id = arr;
		 console.log("체크할거야 : " + user_id);
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
                    if(response == 1) {
                        alert("삭제 성공");
                        window.location.reload()
                       
                    }
                    else{
                        alert("삭제 실패");
                    }
                },
                error: function(){alert("서버통신 오류");}
            });
        }
    }
	
	
  
	
	
$(function(){ // onload
	//삭제
	
		$('.delete').click( function(){  
		deleteAction()
	
		
	});	
	
});
	
	
	
	
</script>

</body>
</html>