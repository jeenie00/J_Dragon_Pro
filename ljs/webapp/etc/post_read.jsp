<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" type="image/png" sizes="16x16"
href="https://github.com/afsdfdasfadsfdsa/fds/blob/main/favicon-32x32.png?raw=true">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" 
  	   	  rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" 
          crossorigin="anonymous">
        
<!-- Google Material Icons -->
<link rel="stylesheet" 
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,1,0" />
<link rel="stylesheet" type="text/css" href="css/ServiceCenter.css">
<title>게시글 상세 열람</title>
</head>
<style>

</style>
<body>
<!-- 상단 네비게이션 시작 부분 -->
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="width:100%; height: 50px; position: fixed;">
	<div class="container-fluid">
		<a class="navbar-brand" href="main.html">
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
<!-- 상단 네비게이션 끝 -->

    <h1>게시글 상세 열람</h1>
    <%
    try
    {
        // JDBC 드라이버 연결
        Class.forName("com.mysql.jdbc.Driver");
        String db_address = "jdbc:mysql://localhost:3306/pratice_board";
        String db_username = "root";
        String db_pwd = "1234";
        Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
        
        // 받아오는 문자열의 인코딩 방식 결정
        request.setCharacterEncoding("UTF-8");
        
        // 파라미터를 통해 전해진 게시글 번호를 받아와, num 변수에 저장
        String num = request.getParameter("num");
        
        // MySQL로 전송하기 위한 쿼리문인 insertQuery 문자열 선언 (읽어온 게시글 번호를 통해, 불러올 게시글을 결정함)
        String insertQuery = "SELECT * FROM pratice_board.post WHERE num=" + num;
        
        // SQL 쿼리문을 실행 (MySQL로 전송)하기 위한 객체 선언
        PreparedStatement psmt = connection.prepareStatement(insertQuery);
        
        // 조회된 결과물들을 저장하기 위한 ResultSet 객체 선언
        ResultSet result = psmt.executeQuery(); %>
        
        <table border="1">
            <%
            // 받아온 정보가 있을때
            while(result.next())
            {%>
            	
            	<!-- 새로 만들기 시작 -->
            	
            	      	
            	<div class="container" style="padding-top:100px" >      
		<div class="row">
		
			<form method="post" action="post_new_send.jsp">
				<div class="instagram-container">
				<button class="btn btn-primary" style="background-color:#0095f6;" type=button onclick="location.href='post_list.jsp'">목록으로</button>
				</div>
				<table class="table table-striped" style="text-align: center; width: 40%; margin-left:auto; margin-right:auto; border:1px solid #dddddd">
					<thead>
						<tr><th colspan="2" style="backgroud-color:#eeeeee; text-align: center;"> 문의하기 </th></tr>	
					</thead>
					<tbody>
						<tr>
							<td><%=result.getString("title") %></td>
						</tr>
						<tr>
							<td><%=result.getString("writer") %></td>
						</tr>
						<tr>
							<td><textarea class="form-control" name="content" maxlength="3000" style="height: 550px;" readonly><%=result.getString("content") %></textarea></td>
						</tr>
					</tbody>
				</table>	
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
            	<!-- 새로 만들기 끝 -->
            	<%            	
            }%>
        </table>
        <%
    }
    catch (Exception ex)
    {
        out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
    }%>
    
	

</body>
</html>