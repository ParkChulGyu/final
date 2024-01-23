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



<div class="myinformationall">



<div class="subinformation">
<a href="/web/membermybatis/main-mapper">내 정보</a>
</div>
<div class="subinformation">
<a href="/web/membermybatis/update-mapper">정보수정</a> 
</div>
<div class="subinformation">
<a href="/web/membermybatis/mywritelist">내가 쓴 글</a> 
</div>
<div class="subinformation">
<a href="/web/membermybatis/myreplylist">내가 단 댓글들</a> 
</div>
<div class="subinformation">
 <a href="#" onclick="deleteConfirm();">회원탈퇴</a> 
</div>
<div class="subinformation">
   <a href="/web/membermybatis/logout-mapper">로그아웃</a>
</div>


</div>








