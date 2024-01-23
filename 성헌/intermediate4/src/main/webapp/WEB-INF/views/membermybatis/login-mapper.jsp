<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>

* {
    margin: 0;
    padding: 0;
}

html{
    width: 100%;
    height: 100vh;
}

body {
    background: #e5e5e5;
    width: 100%;
    text-align: center;
    font-family: 'Open Sans', sans-serif;
    font-weight: 600;
    letter-spacing: 1px;
}


 /* 뒷 배경임 나중에 바꾸고 싶으면 바꾸삼 */
.panel{
    width: 450px;
    max-width: 90%;
    height: 700px;
     background:url('https://picsum.photos/1000/1500?image=827')  #fff;
    background-repeat:no-repeat;
    background-position: top center;
    background-size: cover;
    margin:5% auto 0px;
}




.shadow1{
  -webkit-box-shadow:  0 20px 15px -15px rgba(119, 119, 119, 0.85);
     -moz-box-shadow:  0 20px 15px -15px rgba(119, 119, 119, 0.85);
          box-shadow:  0 40px 30px -30px rgba(119, 119, 119, 0.85);
}


form{
    height: 700px;
    padding: 50px;
}

.panel-switch{
    text-align: center;
    margin-top: 30px;
}

.panel-switch button{
    display: inline-block;
    width: 100px;
    height: 40px;
    background: #f03699;
    margin: 0px 10px 50px;
    border: none;
    color: #fff;
    font-family: 'Open Sans', sans-serif;
    text-transform: uppercase;
    font-weight: 600;
    letter-spacing: 2px;
    font-size: 0.8em;
    
	transition: background-color 0.2s, color 0.2s, opacity 0.2s;
}

.panel-switch button:active{
    background: #b52773;
    color: #c9c9c9;
}

.active-button{
    opacity: 0.5;
}

button , .button , a {
    cursor: pointer;
}

form h1{
    color: #fff;
    font-family: 'Open Sans', sans-serif;
    text-transform: uppercase;
    font-weight: 600;
    letter-spacing: 4px;
    margin: 50px 0;
    font-size: 1.7em;
}

fieldset{
    border: none;
}

.animate1 , .animate2 , .animate3 , .animate4{
    -webkit-animation-duration: 2s;
    -moz-animation-duration: 2s;
}

.animate1
{
    -webkit-animation-delay: 0.2s;
    -moz-animation-delay: 0.2s;
}
                                                                       
.animate2
{
    -webkit-animation-delay: 0.7s;
    -moz-animation-delay: 0.7s;
}
.animate2
{
    -webkit-animation-delay: 0.7s;
    -moz-animation-delay: 0.7s;
}

.animate3
{
    -webkit-animation-delay: 1.1s;
    -moz-animation-delay: 1.1s;
}
.animate33
{
    -webkit-animation-delay: 1.1s;
    -moz-animation-delay: 1.1s;
}

.animate4
{
    -webkit-animation-delay: 1.4s;
    -moz-animation-delay: 1.5s;
}
.animate5
{
    -webkit-animation-delay: 1.7s;
    -moz-animation-delay: 2.2s;
}

.animate6
{
    -webkit-animation-delay: 2.0s;
    -moz-animation-delay: 2.2s;
}
.animate7
{
    -webkit-animation-delay: 2.3s;
    -moz-animation-delay: 2.2s;
}
.animate8
{
    -webkit-animation-delay: 2.7s;
    -moz-animation-delay: 2.2s;
}
.animate9
{
    -webkit-animation-delay: 3.0s;
    -moz-animation-delay: 2.2s;
}
.animate10
{
    -webkit-animation-delay: 3.4s;
    -moz-animation-delay: 2.2s;
}

@-webkit-keyframes fadeInUp {
  from {
    opacity: 0;
    -webkit-transform: translate3d(0, 100%, 0);
    transform: translate3d(0, 100%, 0);
  }

  to {
    opacity: 1;
    -webkit-transform: translate3d(0, 0, 0);
    transform: translate3d(0, 0, 0);
  }
}

@keyframes fadeInUp {
  from {
    opacity: 0;
    -webkit-transform: translate3d(0, 100%, 0);
    transform: translate3d(0, 100%, 0);
  }

  to {
    opacity: 1;
    -webkit-transform: translate3d(0, 0, 0);
    transform: translate3d(0, 0, 0);
  }
}

fieldset input{
    background: rgba(255, 255, 255, 0.2);
    border: none;
    border-radius: 5em;
    height: 20px;
    width: 80%;
    margin: 10px 0;
    padding: 5px;
    text-indent: 10px;
    color: #fff;
    font-weight: 600;
}

fieldset input::placeholder {
    color: #c7c6c6;
}


fieldset input:focus {
   
    border: 1px solid rgba(0, 0, 0, 0.2);
    border-radius: 5em;
    margin: 9px 0;
}

.login_form{
    position: relative;
    bottom:0;
    width: 70%;
    height: 4em;
    margin-top: 150px;
    border: none;
    border-radius: 10em;
    background: #f03699;
    color: #fff;
    font-family: 'Open Sans', sans-serif;
    text-transform: uppercase;
    font-weight: 600;
    letter-spacing: 2px;
    z-index: 1;
    
    transition: background-color 0.2s , color 0.2s;
}

#login-form-submit:active{
    background: #b52773;
    color: #c9c9c9;
}

p , a{
    margin: 0;
    padding: 0;
}

a{
    color: #898787;
    font-size: 0.7em;
    text-decoration: none;
}

.hidden{
    display: none;
}



html, body {
	 padding: 0;
	 margin: 0;
	 width: 100vw;
	 height: 100vw;
	 position: relative;
	 overflow: hidden;
	 background: linear-gradient(#123, #111);
}
 .snowflake {
	 --size: 1vw;
	 width: var(--size);
	 height: var(--size);
	 background: white;
	 border-radius: 50%;
	 position: absolute;
	 top: -5vh;
}
 @keyframes snowfall {
	 0% {
		 transform: translate3d(var(--left-ini), 0, 0);
	}
	 100% {
		 transform: translate3d(var(--left-end), 110vh, 0);
	}
}
 .snowflake:nth-child(1) {
	 --size: 1vw;
	 --left-ini: -8vw;
	 --left-end: 3vw;
	 left: 21vw;
	 animation: snowfall 12s linear infinite;
	 animation-delay: -10s;
}
 .snowflake:nth-child(2) {
	 --size: 0.6vw;
	 --left-ini: 2vw;
	 --left-end: 10vw;
	 left: 17vw;
	 animation: snowfall 9s linear infinite;
	 animation-delay: -9s;
}
 .snowflake:nth-child(3) {
	 --size: 0.8vw;
	 --left-ini: -5vw;
	 --left-end: -7vw;
	 left: 78vw;
	 animation: snowfall 12s linear infinite;
	 animation-delay: -1s;
}
 .snowflake:nth-child(4) {
	 --size: 0.2vw;
	 --left-ini: -1vw;
	 --left-end: -9vw;
	 left: 57vw;
	 animation: snowfall 6s linear infinite;
	 animation-delay: -9s;
}
 .snowflake:nth-child(5) {
	 --size: 0.2vw;
	 --left-ini: 9vw;
	 --left-end: -1vw;
	 left: 39vw;
	 animation: snowfall 10s linear infinite;
	 animation-delay: -3s;
}
 .snowflake:nth-child(6) {
	 --size: 0.8vw;
	 --left-ini: 3vw;
	 --left-end: -6vw;
	 left: 60vw;
	 animation: snowfall 10s linear infinite;
	 animation-delay: -1s;
}
 .snowflake:nth-child(7) {
	 --size: 1vw;
	 --left-ini: -1vw;
	 --left-end: -4vw;
	 left: 89vw;
	 animation: snowfall 6s linear infinite;
	 animation-delay: -8s;
}
 .snowflake:nth-child(8) {
	 --size: 1vw;
	 --left-ini: -4vw;
	 --left-end: -7vw;
	 left: 33vw;
	 animation: snowfall 11s linear infinite;
	 animation-delay: -2s;
}
 .snowflake:nth-child(9) {
	 --size: 1vw;
	 --left-ini: -4vw;
	 --left-end: -4vw;
	 left: 78vw;
	 animation: snowfall 10s linear infinite;
	 animation-delay: -5s;
}
 .snowflake:nth-child(10) {
	 --size: 0.6vw;
	 --left-ini: -3vw;
	 --left-end: 1vw;
	 left: 73vw;
	 animation: snowfall 15s linear infinite;
	 animation-delay: -7s;
}
 .snowflake:nth-child(11) {
	 --size: 0.4vw;
	 --left-ini: 6vw;
	 --left-end: -1vw;
	 left: 62vw;
	 animation: snowfall 8s linear infinite;
	 animation-delay: -8s;
}
 .snowflake:nth-child(12) {
	 --size: 0.4vw;
	 --left-ini: -1vw;
	 --left-end: 1vw;
	 left: 46vw;
	 animation: snowfall 14s linear infinite;
	 animation-delay: -10s;
}
 .snowflake:nth-child(13) {
	 --size: 0.8vw;
	 --left-ini: 5vw;
	 --left-end: 0vw;
	 left: 28vw;
	 animation: snowfall 9s linear infinite;
	 animation-delay: -5s;
}
 .snowflake:nth-child(14) {
	 --size: 0.8vw;
	 --left-ini: 0vw;
	 --left-end: -8vw;
	 left: 96vw;
	 animation: snowfall 9s linear infinite;
	 animation-delay: -5s;
}
 .snowflake:nth-child(15) {
	 --size: 1vw;
	 --left-ini: 9vw;
	 --left-end: 4vw;
	 left: 48vw;
	 animation: snowfall 8s linear infinite;
	 animation-delay: -5s;
}
 .snowflake:nth-child(16) {
	 --size: 0.6vw;
	 --left-ini: -2vw;
	 --left-end: 6vw;
	 left: 42vw;
	 animation: snowfall 11s linear infinite;
	 animation-delay: -3s;
}
 .snowflake:nth-child(17) {
	 --size: 0.8vw;
	 --left-ini: -5vw;
	 --left-end: -5vw;
	 left: 11vw;
	 animation: snowfall 15s linear infinite;
	 animation-delay: -4s;
}
 .snowflake:nth-child(18) {
	 --size: 1vw;
	 --left-ini: -5vw;
	 --left-end: 2vw;
	 left: 21vw;
	 animation: snowfall 6s linear infinite;
	 animation-delay: -5s;
}
 .snowflake:nth-child(19) {
	 --size: 0.6vw;
	 --left-ini: -6vw;
	 --left-end: 0vw;
	 left: 66vw;
	 animation: snowfall 14s linear infinite;
	 animation-delay: -5s;
}
 .snowflake:nth-child(20) {
	 --size: 0.8vw;
	 --left-ini: 7vw;
	 --left-end: -5vw;
	 left: 20vw;
	 animation: snowfall 9s linear infinite;
	 animation-delay: -4s;
}
 .snowflake:nth-child(21) {
	 --size: 1vw;
	 --left-ini: 5vw;
	 --left-end: -9vw;
	 left: 50vw;
	 animation: snowfall 13s linear infinite;
	 animation-delay: -2s;
}
 .snowflake:nth-child(22) {
	 --size: 0.8vw;
	 --left-ini: 3vw;
	 --left-end: 5vw;
	 left: 16vw;
	 animation: snowfall 12s linear infinite;
	 animation-delay: -8s;
}
 .snowflake:nth-child(23) {
	 --size: 0.2vw;
	 --left-ini: -1vw;
	 --left-end: 5vw;
	 left: 89vw;
	 animation: snowfall 15s linear infinite;
	 animation-delay: -2s;
}
 .snowflake:nth-child(24) {
	 --size: 0.2vw;
	 --left-ini: -8vw;
	 --left-end: -9vw;
	 left: 36vw;
	 animation: snowfall 13s linear infinite;
	 animation-delay: -9s;
}
 .snowflake:nth-child(25) {
	 --size: 0.2vw;
	 --left-ini: -6vw;
	 --left-end: 0vw;
	 left: 100vw;
	 animation: snowfall 8s linear infinite;
	 animation-delay: -3s;
}
 .snowflake:nth-child(26) {
	 --size: 1vw;
	 --left-ini: -4vw;
	 --left-end: 3vw;
	 left: 72vw;
	 animation: snowfall 9s linear infinite;
	 animation-delay: -3s;
}
 .snowflake:nth-child(27) {
	 --size: 0.8vw;
	 --left-ini: -1vw;
	 --left-end: 0vw;
	 left: 23vw;
	 animation: snowfall 14s linear infinite;
	 animation-delay: -1s;
}
 .snowflake:nth-child(28) {
	 --size: 0.2vw;
	 --left-ini: 8vw;
	 --left-end: -5vw;
	 left: 37vw;
	 animation: snowfall 13s linear infinite;
	 animation-delay: -5s;
}
 .snowflake:nth-child(29) {
	 --size: 1vw;
	 --left-ini: 9vw;
	 --left-end: 8vw;
	 left: 61vw;
	 animation: snowfall 12s linear infinite;
	 animation-delay: -1s;
}
 .snowflake:nth-child(30) {
	 --size: 1vw;
	 --left-ini: -4vw;
	 --left-end: -1vw;
	 left: 59vw;
	 animation: snowfall 11s linear infinite;
	 animation-delay: -10s;
}
 .snowflake:nth-child(31) {
	 --size: 1vw;
	 --left-ini: 2vw;
	 --left-end: -3vw;
	 left: 54vw;
	 animation: snowfall 15s linear infinite;
	 animation-delay: -7s;
}
 .snowflake:nth-child(32) {
	 --size: 1vw;
	 --left-ini: -4vw;
	 --left-end: -2vw;
	 left: 82vw;
	 animation: snowfall 6s linear infinite;
	 animation-delay: -6s;
}
 .snowflake:nth-child(33) {
	 --size: 0.8vw;
	 --left-ini: 8vw;
	 --left-end: 4vw;
	 left: 16vw;
	 animation: snowfall 7s linear infinite;
	 animation-delay: -2s;
}
 .snowflake:nth-child(34) {
	 --size: 0.8vw;
	 --left-ini: -8vw;
	 --left-end: -4vw;
	 left: 39vw;
	 animation: snowfall 15s linear infinite;
	 animation-delay: -10s;
}
 .snowflake:nth-child(35) {
	 --size: 1vw;
	 --left-ini: -9vw;
	 --left-end: 6vw;
	 left: 40vw;
	 animation: snowfall 13s linear infinite;
	 animation-delay: -1s;
}
 .snowflake:nth-child(36) {
	 --size: 0.4vw;
	 --left-ini: -6vw;
	 --left-end: -6vw;
	 left: 36vw;
	 animation: snowfall 15s linear infinite;
	 animation-delay: -7s;
}
 .snowflake:nth-child(37) {
	 --size: 0.4vw;
	 --left-ini: -5vw;
	 --left-end: -6vw;
	 left: 90vw;
	 animation: snowfall 7s linear infinite;
	 animation-delay: -9s;
}
 .snowflake:nth-child(38) {
	 --size: 1vw;
	 --left-ini: -8vw;
	 --left-end: -8vw;
	 left: 9vw;
	 animation: snowfall 7s linear infinite;
	 animation-delay: -6s;
}
 .snowflake:nth-child(39) {
	 --size: 0.6vw;
	 --left-ini: 5vw;
	 --left-end: 3vw;
	 left: 83vw;
	 animation: snowfall 7s linear infinite;
	 animation-delay: -3s;
}
 .snowflake:nth-child(40) {
	 --size: 0.6vw;
	 --left-ini: -2vw;
	 --left-end: 1vw;
	 left: 84vw;
	 animation: snowfall 9s linear infinite;
	 animation-delay: -3s;
}
 .snowflake:nth-child(41) {
	 --size: 0.6vw;
	 --left-ini: -1vw;
	 --left-end: -8vw;
	 left: 73vw;
	 animation: snowfall 13s linear infinite;
	 animation-delay: -9s;
}
 .snowflake:nth-child(42) {
	 --size: 0.2vw;
	 --left-ini: -4vw;
	 --left-end: 3vw;
	 left: 19vw;
	 animation: snowfall 13s linear infinite;
	 animation-delay: -10s;
}
 .snowflake:nth-child(43) {
	 --size: 0.4vw;
	 --left-ini: -2vw;
	 --left-end: 4vw;
	 left: 80vw;
	 animation: snowfall 13s linear infinite;
	 animation-delay: -3s;
}
 .snowflake:nth-child(44) {
	 --size: 0.8vw;
	 --left-ini: 6vw;
	 --left-end: -3vw;
	 left: 7vw;
	 animation: snowfall 8s linear infinite;
	 animation-delay: -9s;
}
 .snowflake:nth-child(45) {
	 --size: 0.6vw;
	 --left-ini: -5vw;
	 --left-end: -7vw;
	 left: 60vw;
	 animation: snowfall 8s linear infinite;
	 animation-delay: -7s;
}
 .snowflake:nth-child(46) {
	 --size: 0.2vw;
	 --left-ini: -4vw;
	 --left-end: -9vw;
	 left: 82vw;
	 animation: snowfall 12s linear infinite;
	 animation-delay: -7s;
}
 .snowflake:nth-child(47) {
	 --size: 0.2vw;
	 --left-ini: -4vw;
	 --left-end: -2vw;
	 left: 56vw;
	 animation: snowfall 15s linear infinite;
	 animation-delay: -8s;
}
 .snowflake:nth-child(48) {
	 --size: 0.6vw;
	 --left-ini: 8vw;
	 --left-end: -8vw;
	 left: 11vw;
	 animation: snowfall 15s linear infinite;
	 animation-delay: -10s;
}
 .snowflake:nth-child(49) {
	 --size: 1vw;
	 --left-ini: 3vw;
	 --left-end: 8vw;
	 left: 24vw;
	 animation: snowfall 12s linear infinite;
	 animation-delay: -9s;
}
 .snowflake:nth-child(50) {
	 --size: 1vw;
	 --left-ini: 7vw;
	 --left-end: -8vw;
	 left: 69vw;
	 animation: snowfall 12s linear infinite;
	 animation-delay: -3s;
}

/* added small blur every 6 snowflakes*/
 .snowflake:nth-child(6n) {
	 filter: blur(1px);
}




</style>












<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      
        <!-- Font online-->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
      
<!--        Animate.css-->
          <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
                
                                
     
        
        <!-- Google JQuery CDN -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        
     

    </head>
    <body>
    
    <div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
<div class="snowflake"></div>
    
    
    
    
    
        <div>
           <div class="panel shadow1">
                <form class="login-form">
                    <div class="panel-switch animated fadeIn">
                        <button type="button"  id="sign_up" class="active-button">회원가입</button>
                        <button type="button" id="log_in" class="" disabled>로그인</button>
                    </div>
                    <h1 class="animated fadeInUp animate1" id="title-login">Welcome Back !</h1>
                    <h1 class="animated fadeInUp animate1 hidden"style="margin-top: 10px; margin-bottom: 10px;" id="title-signup">Welcome !</h1>
                    <fieldset id="login-fieldset">
                        <input class="login animated fadeInUp animate2"  name="username" type="textbox"     placeholder="아이디를 적어주쇼"  >
                        <input class="login animated fadeInUp animate3"  name="password" type="password"  placeholder="이번엔 비밀번호를..." >
                    </fieldset>
                    <fieldset id="signup-fieldset" class="hidden">
                    	<input type="text" class="login animated fadeInUp animate22" id="mName" placeholder="이름" oninput="checkName(),activateSignupbtn()" name = "mName" autocomplete='off'>
                        <input type="text" class="login animated fadeInUp animate33" id="mNickName" placeholder="닉네임" oninput="checkNickName(),activateSignupbtn()" name = "mNickName" autocomplete='off'>
                         <input type="text" class="login animated fadeInUp animate4" id="mId"   placeholder="ID" oninput="checkId(), activateSignupbtn()" name = "mId" autocomplete='off'>
                           <font color = "red" id = "failid" style = "display:none">5~15자의 영문자와 숫자를 조합해서 입력해주세요.</font>
                        <font color = "red" id = "fail" style = "display:none">이미 존재하는 ID입니다.</font>
                         <input type="password" class="login animated fadeInUp animate5" id="mPwd" placeholder="Password" oninput ="checkPwd(), checkPwd2()" name = "mPwd" >
                         <font color = "red" id = "failpwd" style = "display:none">8~16자의 영문자와 숫자를 조합해서 입력해주세요.</font>
                       	<input type="password" class="login animated fadeInUp animate6" id="pwCheck" placeholder="Password 확인" oninput ="checkPwd2(), activateSignupbtn()" name = "pwcheck">
                       <input type="text" class="login animated fadeInUp animate7" id="mTel"   placeholder="전화번호" oninput="addhyphen(),checkTel(), activateSignupbtn()" name = "mTel" autocomplete='off'>
                         <input type="text" class="login animated fadeInUp animate8" id="mEmail"  oninput="checkEmail() , activateSignupbtn()" placeholder="이메일" name = "mEmail">
                       
                       
                       
                    </fieldset>
                    <input type="submit" id="login-form-submit" class="login_form button animated fadeInUp animate5" value="Log in">
                    <input type="submit" style="margin-top: 27px;"id="signup-form-submit" class="login_form button animated fadeInUp animate9 hidden" value="Sign up">
                    <p><a id="lost-password-link1" href="javascript:void(0);" onclick="idfind();" class="animated fadeIn animate6">I forgot my  user_id (!)</a>
                    <a id="lost-password-link2" href="javascript:void(0);" onclick="pwfind();" class="animated fadeIn animate6">I forgot my  password (!)</a></p>
                </form>
            </div>
        </div>
        <script >
        $(document).ready(function(){
        	//--------- change color value of the form text/password inputs -----
				
        
        	  const textInputs =  $("input[type='textbox']");
        	  const passwordsInputs =  $("input[type='password']");
        	  //--------- Login screen swicth -----

        	
        	  
        	  
        	  
        	  $("#login-form-submit").click(function(event){  //  prevent buttons in form to reload
        	        event.preventDefault();
        	    });
        	  
        	  $("#login-form-submit").click(function(event){  //  prevent buttons in form to reload
        	        event.preventDefault();
        	    });
        	   
        	  
        	    
        	    $("#sign_up").click(function(){ // when click Sign Up button, hide the Log In elements, and display the Sign Up elements
        	        $("#title-login").toggleClass("hidden",true);
        	        $("#login-fieldset").toggleClass("hidden",true);
        	        $("#login-form-submit").toggleClass("hidden",true);
        	        $("#lost-password-link1").toggleClass("hidden",true);
        	        $("#lost-password-link2").toggleClass("hidden",true);
        	        $("#sign_up").toggleClass("active-button",false);
        	        $("#log_in").removeAttr("disabled");
        	        
        	        $("#title-signup").toggleClass("hidden",false);
        	        $("#signup-fieldset").toggleClass("hidden",false);
        	        $("#signup-form-submit").toggleClass("hidden",false);
        	        $("#log_in").toggleClass("active-button",true);
        	        $("#sign_up").prop('disabled', true);
        	    });
        	    
        	    $("#log_in").click(function(){ // when click Log In button, hide the Sign Up elements, and display the Log In elements
        	        $("#title-login").toggleClass("hidden",false);
        	        $("#login-fieldset").toggleClass("hidden",false);
        	        $("#login-form-submit").toggleClass("hidden",false);
        	        $("#lost-password-link1").toggleClass("hidden",false);
        	        $("#lost-password-link2").toggleClass("hidden",false);
        	        $("#sign_up").toggleClass("active-button",true);
        	        $("#log_in").prop('disabled', true);
        	        
        	        $("#title-signup").toggleClass("hidden",true);
        	        $("#signup-fieldset").toggleClass("hidden",true);
        	        $("#signup-form-submit").toggleClass("hidden",true);
        	        $("#log_in").toggleClass("active-button",false);
        	        $("#sign_up").removeAttr("disabled");
        	        
        	    });
        		
        	
        	    
        	    
        	    
        	    
        	    
        	    
        	    
        	})	
        	    $("#login-form-submit").click(function(){
        	    	console.log("이거 되야 혀");
        			console.log("확인이얌 " + $(".login.animated.fadeInUp.animate2").val());
        			$.ajax({
        				url : "../membermybatis/loginP",
        				type : "POST",
        				 dataType: "json",
        				data : {
        					user_id : $(".login.animated.fadeInUp.animate2").val(),
        					pw : $(".login.animated.fadeInUp.animate3").val()
        					
        					
        					
        					
        				},
        				success : function(result) {
        					
        					console.log(result);
        					
        					if (result === 1){
        					window.location.href = "/web/";        					
        						
        					}else if(result === 0){
        							alert("다시 적으렴");
        						
        					}
        					
        				},
        			})
        		});
        	  
        	
        
    			var newWindow;
        	    function idfind() {
        	     newWindow = window.open("idfind", "하위", "width=500,height=500");
        	    	console.log(newWindow);
        	    };
        	    
        	    
        	    function pwfind() {
        	    	console.log("newWindow");
        	     newWindow = window.open("pwfind", "하위", "width=500,height=500");
        	    	console.log(newWindow);
        	     
        	    
        	    };
        	    
        	    
        	    
        	    
        	    
        	   
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

        	  function regMemberEmail(mEmail) {
        		  
        	  var regExp = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
        	  	return regExp.test(mEmail)
        	 
        	  }
        	  



        	  var idCheck = 0;
        	  var pwdCheck = 0;
        	  var phoneCheck = 0;
        	  var nameCheck = 0;
        	  var nicknameCheck = 0;
        	  var pwCheck = 0;
        	  var emailCheck = 0;

        	  function checkName() {
        	     var inputed = $('#mName').val(); //이름에 입력한 값
        	     $.ajax({
        	        success: function() {
        	           if(regMemberName(inputed) == false || inputed.length > 18) { //입력한 값이 정규표현식에 해당되지 않을 때와 18자 이상이 넘을 때 
        	              $("#signup-form-submit").prop("disabled", true); //회원가입 버튼 누르지 못하게 하기
        	              $("#signup-form-submit").css("background-color", "#signup-form-submit"); //버튼 회색으로 바꾸기 
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
        		        
        		    	  
        		    	  if (regMemberid(inputed) == false || inputed.length > 14) {
        		    		  $("#failid").css({
        		    			  "display": "block",
        		    			  "font-size": "12px" // 여기에 원하는 글자 크기를 지정하세요
        		    			});
          		            $("#fail").css({
        		            	  "display": "none",
        		            	  "color": "red",
        		            	  "font-size": "12px"
        		            	});
          		            $("#signup-form-submit").prop("disabled", true);
          		            $("#signup-form-submit").css("background-color", "#aaaaaa");
          		            $("#mId").css("background-color", "#FFCECE");
          		            $("#idEmo").css("color", "#ff2020");
          		            idCheck = 0;
        		    	  } else if(data == '1') { //아이디가 중복되었을 때
        		            $("#fail").css("display", "block"); //에러메세지를 띄운다
        		            $("#failid").css({
        		            	  "display": "none",
        		            	  "color": "red",
        		            	  "font-size": "12px"
        		            	});//중복에러메세지 말고 다른 에러 메세지를 지운다.
        		            $("#signup-form-submit").prop("disabled", true);
        		            $("#signup-form-submit").css("background-color", "#aaaaaa");
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
        	  function checkEmail() {
        	     var inputed = $('#mEmail').val(); //이름에 입력한 값
        	     $.ajax({
        	        success: function() {
        	      	  console.log("regMemberEmail 체크 : " + inputed);
        	      	  console.log("regMemberEmail 체크 : " + regMemberEmail(inputed));
        	           if(regMemberEmail(inputed) == false) { //입력한 값이 정규표현식에 해당되지 않을 때와 18자 이상이 넘을 때 
        	              $("#signup-form-submit").prop("disabled", true); //회원가입 버튼 누르지 못하게 하기
        	              $("#mEmail").css("background-color", "#FFCECE");  // input 배경 붉은색으로 바꾸기 
        	              $("#nEmo2").css("color", "#ff2020"); //이모티콘 빨간색으로 바꾸기
        	              emailCheck = 0; // 회원 가입 전 값들 체크하기 위해 (0은 불가, 1은 가능)
        	           } else if(regMemberEmail(inputed) == true) { //정규표현식에 해당할 때
        	          	 console.log("이거 왜 안됌?");
        	              $("#mEmail").css("background-color", "#B0F6AC"); // input 배경 초록색으로 바꾸기
        	              $("#nEmo2").css("color", "#1853ff"); // 이모티콘 파란색으로 바꾸기
        	              emailCheck = 1;
        	             
        	              activateSignupbtn()
        	           }
        	        }
        	     })
        	  }

        	  
        	  function checkNickName() {
        	     var inputed = $('#mNickName').val(); //이름에 입력한 값
        	     $.ajax({
        	        success: function() {
        	      	  console.log("nickname 체크 : " + inputed);
        	      	  console.log("nickname 체크 : " + regMemberNickName(inputed));
        	           if(regMemberNickName(inputed) == false || inputed.length > 18) { //입력한 값이 정규표현식에 해당되지 않을 때와 18자 이상이 넘을 때 
        	              $("#signup-form-submit").prop("disabled", true); //회원가입 버튼 누르지 못하게 하기
        	              $("#signup-form-submit").css("background-color", "#aaaaaa"); //버튼 회색으로 바꾸기 
        	              $("#mNickName").css("background-color", "#FFCECE");  // input 배경 붉은색으로 바꾸기
        	              $("#nEmo2").css("color", "#ff2020"); //이모티콘 빨간색으로 바꾸기
        	              nicknameCheck = 0; // 회원 가입 전 값들 체크하기 위해 (0은 불가, 1은 가능)
        	           } else if(regMemberNickName(inputed) == true) { //정규표현식에 해당할 때
        	          	 console.log("이거 왜 안됌?");
        	              $("#mNickName").css("background-color", "#B0F6AC"); // input 배경 초록색으로 바꾸기
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
        	  	            $("#signup-form-submit").prop("disabled", true);
        	  	            $("#signup-form-submit").css("background-color", "#aaaaaa");
        	  	          $("#failpwd").css({
    		    			  "display": "block",
    		    			  "font-size": "12px" // 여기에 원하는 글자 크기를 지정하세요
    		    			});
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
        	  	            $("#signup-form-submit").prop("disabled", true);
        	  	            $("#signup-form-submit").css("background-color", "#aaaaaa");
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
        	        	   console.log("이거 안되니?");
        	        	   console.log("이거 안되니?");
        	              $("#mTel").css("background-color", "#B0F6AC");
        	              $("#telEmo").css("color", "#1853ff");
        	              phoneCheck = 1;
        	        	   console.log("이거 안되니?" + phoneCheck);
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
        	  	
        	  	
        	  	   if( idCheck == 1 && pwdCheck == 1  && nameCheck == 1 && nicknameCheck == 1 && pwCheck == 1 && phoneCheck == 1 && emailCheck == 1 ) {
        	  	   console.log("이거 안되야 혀");
        	  	      $("#signup-form-submit").prop("disabled", false);   
        	  	      $("#signup-form-submit").css("background-color", "#B0F6AC");
        	  	      
        	  	    $("#signup-form-submit").click(function(){
              		  
        	  	    	signup()
              	  })
        	  	      
        	  	   }
        	  	   else  {
        	  	      $("#signup-form-submit").css("background-color", "#FF0000");
        	  	      $("#signup-form-submit").prop("disabled", true);
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
        	  	

        	  
        	  
        	  
        	 
        		  
        		 function signup() {
        			  
      	    	console.log("이거 되야 혀");
      			console.log("확인이얌 " + $(".login.animated.fadeInUp.animate2").val());
      			$.ajax({
      				url : "../membermybatis/signup",
      				type : "POST",
      				 dataType: "json",
      				data : {
      					
      				  name : $(".login.animated.fadeInUp.animate22").val(),
                      nickname : $(".login.animated.fadeInUp.animate33").val(),
                      user_id : $(".login.animated.fadeInUp.animate4").val(),
                      pw : $(".login.animated.fadeInUp.animate5").val(),
                      PhoneNumber : $(".login.animated.fadeInUp.animate7").val(),
                      Email : $(".login.animated.fadeInUp.animate8").val()
      					
      					
      					
      				},
      				success : function(rowcount) {
      					
      					
      					
      					if (rowcount == 1) {
      					    alert("회원가입 성공");
      					  location.href='/web/'
      					  
      					  
      					}else {
      					  alert("회원가입 실패");
      					}
      				
      				
      					
      				},
      			})
        		  }
      		
        
        
        
        
        
        </script>
    </body>
</html>