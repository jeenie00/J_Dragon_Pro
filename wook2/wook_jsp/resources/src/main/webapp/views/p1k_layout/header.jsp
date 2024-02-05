<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()"> <!-- 보안 설정  -->
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"/>
<link rel="stylesheet" href="/css/header.css/">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="hidden" id="principal-id" value="${principal.user.id}"/>
	<input type="hidden" id="principal-username" value="${principal.user.username}"/>

	<div class = "header_main">
		<!-- 검색창 시작 -->
	
		<div class = "header_search">
			<form id="searchForm" action="/search" method="GET">
				<input onkeyup="enterkey()" type="search" name="searchValue"/>
				
				<div class = "header_search_logo">
					<button type="submit">
					<i class="fa-solid fa-magnifying-glass"></i>
					</button>
				</div>
			</form>
			<script>
				function enterkey() {
				        if (window.event.keyCode == 13) {
				             document.getElementById("searchForm").submit();
				        }
				}
			</script>
		</div>
		<!-- 검색창 끝  -->
	
		<!-- 왼쪽 유저정보 시작 -->
		<div class = "hearder_user_name">${dto.user.username}</div><!-- 유저명  -->
		
		<div class = "header_user_image">
			<a href = "#"> <!-- 누르면 회원정보란으로 이동  -->
				<img src="/upload/${dto.user.profileImageUrl}" alt=""  onerror="에러시 대체 이미지 생성해야함'" id="profile-image-url"/>
			</a>
		</div>
		<!-- 왼쪽 유저정보 끝 -->
	</div>
</body>
</html>