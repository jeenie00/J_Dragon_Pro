<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content= "text/html; charset=UTF-8">
<!-- 어느 기기에서도 맞춤으로 보이는 반응형 웹에 사용되는 기본 Meta Tag -->
<meta name="viewport" content="width-device-width", initial-scale="1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" 
  	   	  rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" 
          crossorigin="anonymous">
        
	<!-- Google Material Icons -->
	<link rel="stylesheet" 
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,1,0" />
<link rel="stylesheet" href="css/bootstrap.css">
<title>고객센터 문의하기</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="width:100%; height: 70px; position: fixed;">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">
    	<img src="https://github.com/jeenie00/P1k_Project/blob/main/mainicon-removebg-preview.png?raw=true" alt="P1K" width="158" height="47">
    	</a>
    
    	<!-- 검색 창 -->
    	<input class="form-control" style="width: 600px" type="search" placeholder="Search" aria-label="Search">
    
    	<!-- 홈,메시지,업로드,탐색,좋아요 아이콘 -->
    	<div>
    		<span class="material-symbols-outlined">home</span>
    		<span class="material-symbols-outlined">send</span>
    		<span class="material-symbols-outlined">add_box</span>
    		<span class="material-symbols-outlined">explore</span>
    		<span class="material-symbols-outlined">favorite</span>
    	</div>
  </div>
</nav>

	<%
		String userID = null;
	
		//로그인한 사용자들이라면, userID에 값이 담기게될 것!
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
	%>
	<!-- 전반적인 웹사이트 구성을 나타내는 네비게이션 -->
	<!-- 게시판 글쓰기 양식 부분 -->
	<div class="container" style="padding-top:150px">
		<div class="row">
			<form method="post" action="writeAction.jsp">
				<table class="table table-striped" style="text-align: center; border:1px solid #dddddd">
					<thead>
						<tr><th colspan="2" style="backgroud-color:#eeeeee; text-align: center;"> 문의하기 </th></tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="글 제목" name="boardTitle" maxlength="50"></input></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용" name="boardContent" maxlength="3000" style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<div class="input-group mb-3">
 				 <input type="file" class="form-control" id="inputGroupFile02">
				</div>
				<input type="submit" class="btn btn-primary pull-right" value="저장하기"></input>				
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	
</body>
</html>