<!-- SQL 연결을 위한 import -->
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
<meta http-equiv="Content-Type" content= "text/html; charset=UTF-8">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
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
<link rel="stylesheet" type="text/css" href="css/ServiceCenter.css">
<style>

</style>
<title>게시글 목록</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="width:100%; height: 70px; position: fixed;">
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
    <!-- 게시글 목록 폼임을 표시 -->
    <h1 style="text-align:center;">게시글 목록</h1>
      <%
      try
      {
        // JDBC 드라이버 연결
        Class.forName("com.mysql.jdbc.Driver");
        String db_address = "jdbc:mysql://localhost:3306/pratice_board";
        String db_username = "root";
        String db_pwd = "1234";
        Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
        
        // MySQL로 전송하기 위한 쿼리문인 insertQuery 문자열 선언
        String insertQuery = "SELECT * FROM pratice_board.post order by num desc";
        
        // MySQL 쿼리문 실행
        PreparedStatement psmt = connection.prepareStatement(insertQuery);
        
        // 쿼리문을 전송해 받아온 정보를 result 객체에 저장
        ResultSet result = psmt.executeQuery();%>
        
        <!-- 새로 만듬 -->
        <div style="padding-top:150px; width:40%; margin-left:auto; margin-right:auto;">
		<div class="row">
					<tr>
		 			 <td colspan="5">
          				  <button class="instagram-button" style="width:150px;" type="button" value="신규 글 작성" onClick="location.href='write.jsp'">신규 글 작성</button>
          			</td>
        			</tr>
				<table style="text-align: center; border:1px solid #dddddd; margin-left:auto; margin-right:auto;">
						<tr><th class="instagram-font" colspan="5" style="backgroud-color:#eeeeee; text-align: center;"> 문의 게시글 </th></tr>
        			 <tr>
        		<table style="text-align:center; border:1px solid #dddddd; margin-left:auto; margin-right:auto;">
          <td class="td_set">번호</td>
          <td class="td_set">작성자</td>
          <td class="td_set">제목</td>
          <td class="td_set">작성일</td>
          <td class="td_set">관리</td>
        </tr>
        
        <%
        // 받아온 정보를 입력하고, 하나씩 커서를 다음으로 넘김
        while (result.next())
          {%>
            <tr>
              <!-- 번호 <td> 아래에 DB에서 받아온 num 칼럼값 삽입 -->
              <td class="td_set"><%=result.getInt("num") %></td>
              
              <!-- 작성자 <td> 아래에 DB에서 받아온 writer 칼럼값 삽입 -->
              <td class="td_set"><%=result.getString("writer") %></td>
              
              <!-- 제목 <td> 아래에 DB에서 받아온 title 칼럼값 삽입, 제목 클릭시 post_read.jsp로 연결되며 num 칼럼값을 parameter로 넘김 -->
              <td class="td_set"><a href="post_read.jsp?num=<%=result.getInt("num") %>"><%=result.getString("title") %></a></td>
              
              <!-- 작성일 <td> 아래에 DB에서 받아온 reg_date 칼럼값 삽입 -->
              <td class="td_set"><%=result.getTimestamp("reg_date") %></td>
              
              <td>
                <!-- 수정 버튼을 누르면 post_modify.jsp로 연결되며 num 칼럼값을 parameter로 넘김 -->
                <button type="button" value="수정" class="btn btn-primary" style="background-color:#0095f6;" onClick="location.href='post_modify.jsp?num=<%=result.getString("num") %>'">수정</button>
                <!-- 삭제 버튼을 누르면 post_delete_send.jsp로 연결되며 num 칼럼값을 parameter로 넘김 -->
                <button type="button" value="삭제" class="btn btn-primary" style="background-color:#0095f6;" onClick="location.href='post_delete_send.jsp?num=<%=result.getString("num") %>'">삭제</button>
              </td>
            </tr>
            
            <%
            }%>
          </table>
          </table>
        <%
        }
      catch (Exception ex)
      {
        out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
      }%>
        			
					
				</table>
				<div class="input-group mb-3">
				</div>				
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
        <!-- 새로 만듬 -->
</body>
</html>