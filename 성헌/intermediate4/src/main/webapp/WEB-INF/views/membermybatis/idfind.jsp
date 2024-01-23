<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idfind.jsp</title>
</head>
 <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript"
		src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	var msg = "${msg}";

	if (msg != "") {
		alert(msg);
	}
</script>
<style type="text/css">
.mybtn {
	width: 150px;
	height: 40px;
	padding: 0;
	display: inline;
	border-radius: 4px;
	
	 
	background: #212529;
	color: #fff;
	margin-top: 20px;
	border: solid 2px #212529;
	transition: all 0.5s ease-in-out 0s;
}

.mybtn:hover .mybtn:focus {
	background: white;
	color: #212529;
	text-decoration: none;
}



</style>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4 w3-auto" style="width: 382px;height: 456.3px;">
			<div class="w3-center w3-large w3-margin-top">
				<h3>아이디 찾기</h3>
			</div>
			<div>
				<form action="idfindP" method="post">
					<p >
						<label>이메일 주소를 입력하세요</label>
						 <input class="w3-input" type="text" name="str_email01" id="str_email01"  placeholder="이메일 아이디를 입력하쇼">
					</p>
					<p >
						@<input class="w3-input" type="text" name="str_email02"
							id="str_email02" placeholder="@제외하고 적으쇼" disabled value="naver.com">
					</p>
					<p >
						<select class="w3-input" name="selectEmail" id="selectEmail">
							<option value="1"  >직접입력</option>
							<option value="naver.com" selected>naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="nate.com">nate.com</option>
							<option value="gmail.com">gmail.com</option>
						</select>
					</p>
					<p >

						<button type="submit"
							class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">찾기</button>
						<button type="button"  onclick="windowclose();"class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">현재창 닫기</button>
					</p>
				</form>
			</div>
		</div>
	</div>











	
	<script type="text/javascript">
		//이메일 입력방식 선택
		$('#selectEmail').change(function() {
			$("#selectEmail option:selected").each(function() {

				if ($(this).val() == '1') { //직접입력일 경우
					$("#str_email02").val(''); //값 초기화
					
					$("#str_email02").attr("disabled", false); //활성화
				} else { //직접입력이 아닐경우
					$("#str_email02").val($(this).text()); //선택값 입력
					$("#str_email02").attr("disabled", true); //비활성화
				}
			});
		});
		
		
		
		
		function windowclose() {
   	     
    		window.close();
    };
		
		
		
	</script>


















</body>
</html>