<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/top2.css">
</head>
<body>
<%@include file="submenu.jsp" %>
<h2>회원가입</h2>

<!-- 아이디 비밀번호 이름 닉네임 이메일 전화번호  -->


		
	
		 <body> 
  <h2>회원가입</h2>

            <form name ="logincheck"  onsubmit="return validateForm()" action = "signup" method = "post">

            <div class="form-group" style="margin:3% 25%;">
               <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="mName" placeholder="이름" oninput="checkName(),activateSignupbtn()" name = "mName" autocomplete='off'>
                  <label for="floatingInput">이름</label>
                  <i id = "nEmo" class="fa fa-id-card-o"></i>
               </div>
               <div class="form-group mb-1">
               <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="mNickName" placeholder="닉네임" oninput="checkNickName(),activateSignupbtn()" name = "mNickName" autocomplete='off'>
                  <label for="floatingInput">닉네임</label>
                  <i id = "nEmo2" class="fa fa fa-id-card-o"></i>
               </div>
               <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="mId"   placeholder="ID" oninput="checkId(), activateSignupbtn()" name = "mId" autocomplete='off'>
                  <label for="floatingInput">ID</label>
                  <i id="idEmo" class="fa-solid fa-id-card"></i>
                        <font color = "red" id = "failid" style = "display:none">5~15자의 영문자와 숫자를 조합해서 입력해주세요.</font>
                        <font color = "red" id = "fail" style = "display:none">이미 존재하는 ID입니다.</font>
               </div>
               <div class="form-floating">
                  <input type="password" class="form-control" id="mPwd" placeholder="Password" oninput ="checkPwd(), checkPwd2()" name = "mPwd" >
                  <label for="floatingPassword">Password</label>
                  <i id= "pwEmo1"class="fa-solid fa-fingerprint"></i>
                  <font color = "red" id = "failpwd" style = "display:none">8~16자의 영문자와 숫자를 조합해서 입력해주세요.</font>
               </div>
               <div class="form-floating">
                  <input type="password" class="form-control" id="pwCheck" placeholder="Password 확인" oninput ="checkPwd2(), activateSignupbtn()" name = "pwcheck">
                  <label for="floatingPassword">Password 확인</label>
                  <i id = "pwEmo2" class="fa-solid fa-check-double"></i>
               </div>
               <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="mTel"   placeholder="전화번호" oninput="addhyphen(),checkTel(), activateSignupbtn()" name = "mTel" autocomplete='off'>
                  <label for="floatingInput">전화번호</label>
                  <i id = "telEmo" class="fa-solid fa-phone"></i>
               </div>
               <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="mEmail"   placeholder="이메일" name = "mEmail">
                  <label for="floatingInput">이메일</label>
                  <i id = "tel4Emo" class="fa-solid fa-phone"></i>
               </div>
           
               
               <div>
                  <p>생년월일</p>
                   <select name="years" id = "years">
                        <script>
                            for(i=2022; i>1900; i--){
                                document.write("<option>" + [i] + "</option>");
                            }
                        </script>
                    </select>
                    <select name="month" id = "month">
                        <script>
                            for(i=1; i<13; i++) {
                                document.write("<option>" + [i] + "</option>");
                            }
                        </script>
                    </select>
                    <select name="day" id="day">
                        <script>
                       
                                for(i=1; i<32; i++) {
                                    document.write("<option>" + [i] + "</option>");
                                }
                        
                        </script>
                    </select>
                    <i id = "birthdayEmo" class="fa-solid fa-calendar"></i>  
               </div>
               
               
               
               <div style="display: grid; padding-top: 5%;">
               <button type="submit" class="btn btn-secondary" style="padding: 2% 0 2%;" id="signupbtn" >회원가입</button>
               </div>
            </div>
         </form>
   </body>
	
	



<script>
//정규 표현식
function regMemberid(mId) { //영문자 또는 숫자 6~16자
   var regExp = /^[A-za-z0-9]{5,15}/g;
   return regExp.test(mId);   
}
function regPassword(mPwd) { //8~16자 영문, 숫자 조합
   var regExp = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;
   return regExp.test(mPwd);
}
function regPhoneNumber(mTel) { //전화번호
   var regExp = /^01(?:0|1|[6-9])-(?:\d{3})-\d{5}$/;
   return regExp.test(mTel);
}
function regMemberName(mName) { //이름
   var regExp = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
   return regExp.test(mName);
}
function regMemberNickName(mNickName) { //이름
   var regExp = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
   return regExp.test(mNickName);
}




var idCheck = 0;
var pwdCheck = 0;
var phoneCheck = 0;
var nameCheck = 0;
var nicknameCheck = 0;
var pwCheck = 0;

function checkName() {
   var inputed = $('#mName').val(); //이름에 입력한 값
   $.ajax({
      success: function() {
         if(regMemberName(inputed) == false || inputed.length > 18) { //입력한 값이 정규표현식에 해당되지 않을 때와 18자 이상이 넘을 때 
            $("#signupbtn").prop("disabled", true); //회원가입 버튼 누르지 못하게 하기
            $("#signupbtn").css("background-color", "#signupbtn"); //버튼 회색으로 바꾸기 
            $("#mName").css("background-color", "#FFCECE");  // input 배경 붉은색으로 바꾸기
            $("#nEmo").css("color", "#ff2020"); //이모티콘 빨간색으로 바꾸기
            nameCheck = 0; // 회원 가입 전 값들 체크하기 위해 (0은 불가, 1은 가능)
         } else if(regMemberName(inputed) == true) { //정규표현식에 해당할 때
            $("#mName").css("background-color", "#B0F6AC"); // input 배경 초록색으로 바꾸기
            $("#nEmo").css("color", "#1853ff"); // 이모티콘 파란색으로 바꾸기
            nameCheck = 1;
         }
      }
   })
}

function checkId() {
	   var inputed = $('#mId').val();
	   $.ajax({
	      data : {
	         mId : inputed //입력한 값을 mId라는 변수에 담음
	      },
	      url : "../membermybatis/checkid", // data를 checkid url에 보냄 (Controller에서 받아처리한다. 중복이 되면 1, 아니면 0을 반환하는 함수를 구현했다.)
	      success : function(data) {
	         if(data == '1') { //아이디가 중복되었을 때
	            $("#fail").css("display", "block"); //에러메세지를 띄운다
	            $("#failid").css("display","none"); //중복에러메세지 말고 다른 에러 메세지를 지운다.
	            $("#signupbtn").prop("disabled", true);
	            $("#signupbtn").css("background-color", "#aaaaaa");
	            $("#mId").css("background-color", "#FFCECE");
	            $("#idEmo").css("color", "#ff2020");
	            idCheck = 0;
	         } else if (regMemberid(inputed) == false || inputed.length > 14) {
	            $("#failid").css("display","block");
	            $("#fail").css("display","none");
	            $("#signupbtn").prop("disabled", true);
	            $("#signupbtn").css("background-color", "#aaaaaa");
	            $("#mId").css("background-color", "#FFCECE");
	            $("#idEmo").css("color", "#ff2020");
	            idCheck = 0;
	         } else if( data == '0' && regMemberid(inputed)) { //중복되지않고, 정규식을 통과할 때
	            $("#mId").css("background-color", "#B0F6AC");
	            $("#idEmo").css("color", "#1853ff");
	            $("#failid").css("display","none");
	            $("#fail").css("display","none");
	            idCheck = 1;  
	         }
	      }
	   });
	}
function checkNickName() {
   var inputed = $('#mNickName').val(); //이름에 입력한 값
   $.ajax({
      success: function() {
    	  console.log("nickname 체크 : " + inputed);
    	  console.log("nickname 체크 : " + regMemberNickName(inputed));
         if(regMemberNickName(inputed) == false || inputed.length > 18) { //입력한 값이 정규표현식에 해당되지 않을 때와 18자 이상이 넘을 때 
            $("#signupbtn").prop("disabled", true); //회원가입 버튼 누르지 못하게 하기
            $("#signupbtn").css("background-color", "#aaaaaa"); //버튼 회색으로 바꾸기 
            $("#mNickName").css("background-color", "#FFCECE");  // input 배경 붉은색으로 바꾸기
            $("#nEmo2").css("color", "#ff2020"); //이모티콘 빨간색으로 바꾸기
            nicknameCheck = 0; // 회원 가입 전 값들 체크하기 위해 (0은 불가, 1은 가능)
         } else if(regMemberNickName(inputed) == true) { //정규표현식에 해당할 때
        	 console.log("이거 왜 안됌?");
            $("#mNickName").css("background-color", "#aaaaaa"); // input 배경 초록색으로 바꾸기
            $("#nEmo2").css("color", "#1853ff"); // 이모티콘 파란색으로 바꾸기
            nicknameCheck = 1;
         }
      }
   })
}
function checkPwd() {
	   var inputed = $('#mPwd').val();
	   
	   $.ajax({
	      success: function() {
	         if(regPassword(inputed) == false || inputed.length > 16) {
	            $("#signupbtn").prop("disabled", true);
	            $("#signupbtn").css("background-color", "#aaaaaa");
	            $("#failpwd").css("display", "block");
	            $("#mPwd").css("background-color", "#FFCECE");
	            $("#pwEmo1").css("color", "#ff2020");
	            pwdCheck = 0;
	         } else if(regPassword(inputed) == true) {
	            $("#mPwd").css("background-color", "#B0F6AC");
	            $("#failpwd").css("display", "none");
	            $("#pwEmo1").css("color", "#1853ff");
	            pwdCheck = 1;
	         }
	      }
	   })
	}
	function checkPwd2() {
	   var inputed = $('#pwCheck').val();
	   var inputed1 = $('#mPwd').val();
	   
	   $.ajax({
	      success: function() {
	    	  console.log("inputted : " + inputed);
	    	  console.log("inputted : " + inputed1);
	         if(inputed != inputed1) {
	            $("#signupbtn").prop("disabled", true);
	            $("#signupbtn").css("background-color", "#aaaaaa");
	            $("#pwCheck").css("background-color", "#FFCECE");
	            $("#pwEmo2").css("color", "#ff2020");
	            pwCheck = 0;
	         } else if(inputed == inputed1) {
	            $("#pwCheck").css("background-color", "#B0F6AC");
	            $("#pwEmo2").css("color", "#1853ff");
	            pwCheck = 1;
	         }
	      }
	   })
	}






function checkTel() {
   var inputed = $('#mTel').val();
   
   $.ajax({
      success: function() {
         if(regPhoneNumber(inputed) ==  false) {
            $("#mTel").css("background-color", "#FFCECE");
            $("#telEmo").css("color", "#ff2020");
            inputed = $('#mTel').val();
            phoneCheck = 0;
         }
         else if(regPhoneNumber(inputed)== true) {
            $("#mTel").css("background-color", "#B0F6AC");
            $("#telEmo").css("color", "#1853ff");
            phoneCheck = 1;
         }
      }
   })
}

function addhyphen() {
	   $(document).on("keyup", "#mTel", function () {
	      $(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3").replace("--", "-") ); //- 자동으로 입력
	   })
	}
	
function activateSignupbtn() {
	console.log("id check :" + idCheck );
	console.log("pw pwdheck :" + pwdCheck );
	console.log("nameCheck :" + nameCheck );
	console.log("pw nicknameCheck :" + nicknameCheck );
	console.log("pw pwCheck :" + pwCheck );
	console.log("pw pwdCheck :" + pwdCheck );
	console.log("pw phoneCheck :" + phoneCheck );
	
	   if( idCheck == 1 && pwdCheck == 1  && nameCheck == 1 && nicknameCheck == 1 && pwCheck == 1  ) {
	   console.log("이거 안되야 혀");
	      $("#signupbtn").prop("disabled", false);   
	      $("#signupbtn").css("background-color", "#B0F6AC");
	   }
	   else  {
	      $("#signupbtn").css("background-color", "#FF0000");
	      $("#signupbtn").prop("disabled", true);
	   console.log("너도 마찬가지여");
	   }
	}
	
	
	
function validateForm() {
    // 여기에서 폼 검증 또는 원하는 작업 수행
    var name = document.forms["myForm"]["mName"].value;
    if (name === "") {
        alert("이름을 입력하세요.");
        return false; // 제출 중지
    }
}
	

</script>

</body>
</html>