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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" 
  	   	  rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" 
          crossorigin="anonymous">
<link rel="stylesheet" 
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,1,0" />
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">
<meta http-equiv="Content-Type" content= "text/html; charset=UTF-8">
<title>글 수정</title>
</head>
<body>
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
   
    <%
    try
    {
    	// JDBC 드라이버 연결
        Class.forName("com.mysql.jdbc.Driver");
        String db_address = "jdbc:mysql://localhost:3306/pratice_board";
        String db_username = "root";
        String db_pwd = "1234";
        Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
        
        // 문자열의 인코딩 방식 결정
        request.setCharacterEncoding("UTF-8");
        
        // 게시글 번호를 파라미터값을 통해 받아와 정수형 변수에 저장
        String num = request.getParameter("num");
        
        // MySQL로 전송하기 위한 쿼리문인 insertQuery 문자열 선언 (읽어온 게시글 번호를 통해, 불러올 게시글을 결정함)
        String insertQuery = "SELECT * FROM pratice_board.post WHERE num=" + num;
        
        // SQL 쿼리문을 실행 (MySQL로 전송)하기 위한 객체 선언
        PreparedStatement psmt = connection.prepareStatement(insertQuery);
        
        // 조회된 결과물들을 저장하기 위한 ResultSet 객체 선언
        ResultSet result = psmt.executeQuery();
        
        // 받아온 정보가 있을 때
        while(result.next())
        {%>
        	<!-- 새로 작성함 -->
        	<form action="post_modify_send.jsp" method="post">
            <!-- 숨겨진 textbox에 num값을 삽입해, 수정 버튼을 누르면 함께 post_modify_send.jsp로 전송 -->
            <input type="hidden" name="num" value="<%=result.getInt("num") %>">
        	
        	<div style="padding-top:150px; width:40%; margin-left:auto; margin-right:auto;">
			<div class="row">
			<form method="post" action="post_new_send.jsp">
			<table>
                <tr>
                    <td colspan="2">
                        <!-- 수정 버튼을 누르면 post_modify_send.jsp로 연결되며, -->
                        <!-- submit 형식의 button을 통해, post 방식으로 내용 전송 -->
                        <button class="btn btn-primary" type="submit" style="background-color:#0095f6;">수정</button>
                        <!-- 목록으로 버튼을 누르면 post_list.jsp로 연결됨 -->
                        <button class="btn btn-primary" type="button" style="background-color:#0095f6;" onclick="location.href='post_list.jsp'">목록으로</button>
                        <!-- 원상복구 버튼을 누르면 text 입력값이 DB에서 받아왔던 원상태로 모두 초기화 -->
                        <button class="btn btn-primary" type="reset" style="background-color:#0095f6;">원상복구</button>
                    </td>
                </tr>
            </table>
				<table class="table table-striped" style="text-align: center; border:1px solid #dddddd">
					<thead>
						<tr><th colspan="2" style="backgroud-color:#eeeeee; text-align: center;"> 게시글 수정 </th></tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" name="title" placeholder="글 제목" maxlength="50" value="<%=result.getString("title") %>"></input></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" name="writer" placeholder="작성자" maxlength="50" value="<%=result.getString("writer") %>"></input></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용" name="content" maxlength="3000" style="height: 550px;"><%=result.getString("content") %></textarea></td>
						</tr>
					</tbody>
				</table>
				<div class="input-group mb-3">
 				 <input type="file" class="form-control" id="inputGroupFile02">
				</div>
				
            </form>				
			</form>
			
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	
			
           
        	<!-- 새로 작성함 -->
            <!-- 입력값을 전송하기 위한 post method 방식의 form action 선언 -->
            
    <%
        }
    }
    catch (Exception ex)
    {
    	out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
    }%>
</body>
</html>