<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>None</title>
<style>

/* 좌측 메인 이미지 */
.p1k_img_main{
	position: absolute;
	left: 528px;
	top: 86px;
}

/* 박스상단 사과 이미지 */
.p1k_img_logo{
	position: absolute;
	left: 1114px;
	top: 184px;
}

/*로고이미지를 담을 블록요소*/
.login__text {
  height: 86px;
  display: flex;
  align-items: center;
  justify-content: center;
}


/* 로그인 박스(상단 입력 박스) */
.p1k_loginbox1{
 position: relative;
 width: 328.91px;
 height: 328.05px;
 left: 990px;
 top: 280px;
 background: #FFFFFF;
 border: 4px solid #CCCCCC;
 border-radius: 6px;
}

/*로그인 인풋박스*/
.p1k_login__input {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 8px;
  padding: 0 40px;
}


/*로그인 인풋태그*/
.p1k_login__input input {
  width: 100%;
  height: 38px;
  padding: 9px 0 7px 8px ;
  border-width: 0 0 3.57px;
  border-radius: 3px;
  margin-bottom: 6px;
  outline: none;
  font-family: Inter;
  font-size: 16px;
  font-style: normal;
  font-weight: 500;
  line-height: 150%; /* 24px */
}


/*로그인 버튼*/
.p1k_login__input button {
  border: 0;
  width: 100%;
  height: 42px;
  background-color: #0095f6;
  color: #fff;
  margin-top: 10px;
  font-weight: 700;
  border-radius: 3px;
  transition: background 0.5s;
  letter-spacing: -0.176px;
  font-size : 16px;
}

/*비밀번호를 잊으셧나요?*/
.p1k_forgetPWd{
	margin-top: 8px;
	text-align: center;
	font-family: Inter;
	font-size: 16px;
	font-style: normal;
	font-weight: 500;
	line-height: 160%; /* 24px */
	letter-spacing: -0.176px;
}

.p1k_forgetPWd a{
	color: #1E1E1E;
	text-decoration-line: none;
}

/*로그인 폼 제출*/
.login__form,
.login__register {
  padding: 10px 0 20px;
  text-align: center;
  border: 1px solid rgba(var(--b6a, 219, 219, 219), 1);
  background-color: #fff;
}

/*=============================================================================================================================================*/

/*로그인 박스(하단 입력 박스)*/
.p1k_loginbox2{
	position: relative;
	width: 328.91px;
	height: 54px;
	left: 990px;
	top: 290px;
	background: #FFFFFF;
	border: 4px solid #CCCCCC;
	border-radius: 6px;
}

/* 계정이 없으신가요? */
.p1k_notHaveAccount {
	margin-top: 15px;
	text-align: center;
	font-family:'inter';
	margin-left: auto;
	margin-right: auto;
	vertical-align:middle;
}

.p1k_notHaveAccount a{
	color: #1E1E1E;
	text-decoration-line: none;
	font-weight: 700;
}

</style>
</head>
<body>
	<div id='wrapper'>
		<!-- 상단 이미지로고 -->
		<div class="p1k_img_logo">
			<a href ="p1k_LoginForm.jsp"><img src="https://github.com/afsdfdasfadsfdsa/P1k_Project/blob/main/p1k_peak1_logo%201.png?raw=true" height ="115" width="103" /></a>
		</div>
		<!-- 메인 이미지-->
		<div class="p1k_img_main">
			<img src="https://github.com/afsdfdasfadsfdsa/P1k_Project/blob/main/p1k_main_logo%201.png?raw=true" width= 380px; height= 700px;>
		</div>
		<!-- 첫번째 박스 (로그인) -->
			<div class="p1k_loginbox1">
				<div>
					<!-- 상단 이미지바(추가 기능 없음) -->
					<p style="text-align: center;">
						<img src="https://github.com/jeenie00/P1k_Project/blob/main/mainicon-removebg-preview.png?raw=true" width= 280px; height= 75px;>
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