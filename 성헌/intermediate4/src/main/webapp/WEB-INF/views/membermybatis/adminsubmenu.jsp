<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script>
	function deleteConfirm() {
		const input = confirm("회원을 탈퇴할까요?");
		alert(input);
		if (input) location.href = "delete-mapper";
		else return;
	};
</script>



<div class="adminall">



<div class="adminpage">
<a href="main-mapper">내 정보</a>
</div>


<div class="adminpage">
 <a href="#" onclick="deleteConfirm();">회원탈퇴</a> 
</div>
<div class="adminpage">
   <a href="logout-mapper">로그아웃</a>
</div>


</div>








