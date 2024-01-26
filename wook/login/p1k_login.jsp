<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<!--head 태그 내 추가-->
	<link rel="icon" type="image/png" sizes="16x16" href="https://github.com/afsdfdasfadsfdsa/fds/blob/main/favicon-32x32.png?raw=true">
	<link rel="stylesheet" href="/css/login_St.css"/> 	
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Peak1KGram</title>
</head>
<body>
	<div id='wrapper'>
		<!-- 상단 이미지로고 -->
		<div class="p1k_img_logo">
			<a href ="loginpage.jsp"><img src="/images/logo.png" height ="115" width="103" /></a>
		</div>
		<!-- 메인 이미지-->
		<div class="p1k_img_main">
			<img src="/images/main.png" width= 380px; height= 700px;>
		</div>
		<!-- 첫번째 박스 (로그인) -->
			<div class="p1k_loginbox1">
				<div>
					<!-- 상단 이미지바(추가 기능 없음) -->
					<p style="text-align: center;">
						<img src="/images/text.png" width= 280px; height= 75px;>
					</p>
					
					<!-- 기본 로그인 폼 -->
					<form class="p1k_login__input" action="test.jsp" method="post">
						<input type="text" name="username" placeholder="전화번호, 사용자 이름 또는 이메일">
				         <input type="password" name="password" placeholder="비밀번호">
				         <button>로그인</button>
					</form>
					<!-- 비밀번호를 잊으셧나요(비밀번호 찾기 기능) -->
					<div class="p1k_forgetPWd">
						<a href ="/auth joinForm">비밀번호를 잊으셨나요?</a>
					</div>
				</div>
			</div>
		<!-- 두번째 박스 (회원가입) -->
			<div class="p1k_loginbox2">
				<div class ="p1k_notHaveAccount">
					계정이 없으신가요? <a href ="/joinForm">가입하기</a>
				</div>
			</div>
		</div>

</body>
</html>