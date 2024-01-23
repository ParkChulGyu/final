<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
	window.Kakao.init("362b656b5b93008aab3b5504dea7f99d");
	
	function kakaoLogin(){
		window.Kakao.Auth.login({
			scope: 'profile_nickname',
			success: function(authObj) {
				console.log(authObj);
				window.Kakao.API.request({
					url: "/v2/user/me",
					success: function(res) {
						const kakao_account = res.kakao_account;
						console.log(kakao_account);
					}
				});
			}
		});
	}
</script>