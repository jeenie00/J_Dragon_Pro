<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <!-- Required meta tags -->
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" 
  	   	  rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" 
          crossorigin="anonymous">
        
	<!-- Google Material Icons -->
	<link rel="stylesheet" 
          href="https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp"/>
	<link rel="stylesheet"
		  href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,1,0">
	
	<!-- jquery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	
  	<link rel="stylesheet" href="/css/mainBody.css">
  	<link rel="stylesheet" href="/css/feedStyle.css">
  	<link rel="stylesheet" href="/css/style.css">
  	<link rel="stylesheet" href="/css/upLoadModal.css">
  	
<title>Pear1kgram</title>
</head>
<body>

	<!-- 상단 네비게이션 시작 부분 -->
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="width:100%; height: 50px; position: fixed;">
	<div class="container">
    	<img src="/images/text.png" alt="P1K" width="168" height="45">
    
    	검색 창
    	<input class="form-control" style="width: 600px" type="search" placeholder="Search" aria-label="Search">
   </div>
</nav>
<!-- 상단 네비게이션 끝 -->

<!-- 바디 영역 -->
<div class="main_body">
   <div class="left_body">
	  <ul>
      	<li><span class="material-icons">home</span></li>
      	<li><span class="material-icons">send</span></li>
      	<li><span id="add_feed" class="material-icons-outlined">add_box</span></li>
      	<li><span class="material-icons-outlined">explore</span></li>
      	<li><span class="material-icons-outlined">favorite_border</span></li>
      </ul>
    </div>
	<div class="feed_main">
	  <div class="border feed_box">
	  	<div class="feed_name">
	  	  <div class="profile_box">
	  	    <img class="profile_img" src="https://images.pexels.com/photos/16299779/pexels-photo-16299779.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1">
	      </div>
	      
	      <span class="feed_name_txt"> jeenie00 </span>
	      </div>
	    <img class="feed_img" src="https://images.pexels.com/photos/7345169/pexels-photo-7345169.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load">
	 
	 
	  <div class="feed_icon">
	  	<div>
	  		<span class="material-icons-outlined">
	  			favorite_border
	  		</span>
	  		<span class="material-icons-outlined">
	  			mode_comment
	  		</span>
	  		<span class="material-icons-outlined">
	  			send
	  		</span>
	  	</div>
	  	<div>
	  		<span class="material-icons-outlined">
	  			turned_in_not
	  		</span>
	  	</div>
	  </div>
	  
	  <div class="feed_like">
	  	<p class="feed_txt"><b>좋아요 10개</b></p>
	  </div>
	  <div class="feed_content">
	  	<p class="feed_txt"><b>jeenie00</b> 갬성</p>
	  </div>
	  <div class="feed_reply">
	  	<span class="feed_txt"> <b> boss </b> 이쁘다 </span>
	  	<span class="feed_txt"> <b> human </b> 와우 </span>
	  </div>
	</div>
</div>  

	<!-- 우측 바 시작 -->
	<div class="right_body">
	  <div class="feed_name" style="justify-content: space-between">
	    <div style="display: flex; align-items: center;">
	      <div class="big_profile_box">
	        <img class="profile_img" src="https://images.pexels.com/photos/16299779/pexels-photo-16299779.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1">
	      </div>
	      <div class="name_content">
	       <span class="feed_name_txt"> jeenie00 </span>
	       <span class="name_content_txt"> Park Hyejin </span>
	      </div>
	     </div>
	    <a class="link_txt">
	      전환
	    </a>
	  </div>
	
	<div class="recommend_box">
	  <span style="color: gray"> 회원님을 위한 추천 </span>
	  <span style="font-size: 12px"> 모두 보기 </span>
	</div>

	  <div class="feed_name" style="justify-content: space-between">
	    <div class="profile_box">
	      <img class="profile_img" src="https://images.pexels.com/photos/13202908/pexels-photo-13202908.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1">
	    </div>
	    
	    <div class="name_content">
	      <span class="feed_name_txt"> wodyd22 </span>
	      <span class="name_content_txt"> Pear1kgram 신규가입 </span>
	    </div>
	    
	    <a class="link_txt">
	    	팔로우
	    </a>
	</div>
	
	<div class="feed_name" style="justify-content: space-between">
	  <div class="profile_box">
	    <img class="profile_img" src="https://images.pexels.com/photos/19610882/pexels-photo-19610882.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1">
	  </div>
	  <div class="name_content">
	    <span class="feed_name_txt"> billie33 </span>
	    <span class="name_content_txt"> jeenie00 외 5명이 팔로우 </span>
	  </div>
	  
	  <a class="link_txt">
	  	팔로우
	  </a>
	</div>
	  
	  <div class="feed_name" style="justify-content: space-between">
	  <div class="profile_box">
	    <img class="profile_img" src="https://images.pexels.com/photos/19710596/pexels-photo-19710596.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load">
	  </div>
	  <div class="name_content">
	    <span class="feed_name_txt"> lemon44 </span>
	    <span class="name_content_txt"> jeenie00 외 5명이 팔로우 </span>
	  </div>
	  
	  <a class="link_txt">
	  	팔로우
	  </a>
	  </div>
    </div>
  </div>
  <!-- 우측 바 끝 -->
  
  <!-- 업로드 모달 -->
  <div id="modal_add_feed" class="modal modal_overlay">
  	<div class="modal_window">
  	  <div class="modal_title">
  	  	<div class="modal_title_side"></div>
  	  		<div>새 게시물</div>
  	  	<div class="modal_title_side">
  	  		<span id="close_modal" class="material-icons-outlined" style="cursor: pointer; font-size: 30px;">
  	  			close
  	  		</span>
  	  	</div>
  	  </div>
  	  <div class="modal_image_upload">
  	  	<span style="text-align: center"> 사진을 여기에 끌어다 놓으세요.</span>
  	  </div>
  	</div>
  </div>
	<!-- 모달 상단 끝 -->
	
	<!-- 이미지 첨부 후 모달 화면 두개로 나눔 -->
	<div id="modal_add_feed_content" class="modal modal_overlay_content">
    <div class="modal_window">
        <div class="modal_title">
            <div class="modal_title_side"></div>
            <div style="margin: 5px"> 새 게시물 </div>
            <div class="modal_title_side">
                <span id="close_modal" class="close_modal material-icons-outlined" style="font-size: 30px">
                    close
                </span>
            </div>
        </div>
        <div class="modal_image_content">
            <div id="input_image" class="modal_image_upload_content">
<!-- id="input_profile_image" class="profile_img" -->
            </div>
            <div class="modal_content_write">
                <div class="feed_name">
                    <div class="profile_box">
                        <img src="https://scontent-ssn1-1.xx.fbcdn.net/v/t1.6435-9/s1080x2048/165180104_277246477102900_6106347261862438192_n.jpg?_nc_cat=102&ccb=1-5&_nc_sid=730e14&_nc_ohc=1sN4d8i7rn8AX-7aKYN&_nc_ht=scontent-ssn1-1.xx&oh=5049b7cd176848e330b0f5ea95f28172&oe=615A08D1">
                    </div>
                    <span class="feed_name_txt"> jeenie00 </span>
                </div>
                <div style="height: 440px">
                    <textarea class="feed_content_textarea form-control col-sm-5" rows="10" placeholder="설명을 입력하세요..."></textarea>
                </div>
                <div style="width: 100%; text-align: center">
                    <button id="button_write_feed" type="button" class="btn btn-primary" style="width: 268px"> 공유하기</button>
                </div>
            </div>
        </div>

    </div>
</div>
<script>

	// 업로드 모달 띄우기
    const modal = document.getElementById("modal_add_feed");
    const buttonAddFeed = document.getElementById("add_feed");
    buttonAddFeed.addEventListener("click", e => {
    	modal.style.top = window.pageYOffset + 'px'; // top을 이용해 y위치 바꾸기
    		
        modal.style.display = "flex";
        document.body.style.overflowY = "hidden"; // 스크롤 없애기
        
    });
    	
    // 모달 닫기
    const buttonCloseModal = document.getElementById("close_modal");
    buttonCloseModal.addEventListener("click", e =>{
    	modal.style.display = "none";
    	document.body.style.overflowY = "visible";
    });

    // jquery 부분
    $('.modal_image_upload')
    	.on("dragover", dragOver)
    	.on("dragleave", dragOver)
    	.on("drop", uploadFiles);
    
    function dragOver(e){
    	console.log(e);
    	e.stopPropagation();
    	e.preventDefault();
    	
    	if(e.type == "dragover"){
    		$(e.target).css({
    			"background-color": "#EBEBEB",
    			"outline-offset": "-20px"
    		});
    	}else{
    		$(e.target).css({
    			"background-color": "white",
    			"outline-offset": "-10px"
    		});
    	}
    }
    
    function uploadFiles(e){
    	e.stopPropagation();
    	e.preventDefault();
    	console.log(e.dataTransfer)
    	console.log(e.originalEvent.dataTransfer)
    	
    	e.dataTransfer = e.originalEvent.dataTransfer;
    	
    	// files는 리스트 형태
    	        files = e.dataTransfer.files;
        if (files.length > 1) {
            alert('하나만 올려라.');
            return;
        }

        if (files[0].type.match(/image.*/)) {
            $('#modal_add_feed_content').css({
                display : 'flex'
            });
            $('.modal_image_upload_content').css({
                "background-image": "url(" + window.URL.createObjectURL(files[0]) + ")",
                "outline": "none",
                "background-size": "contain",
                "background-repeat" : "no-repeat",
                "background-position" : "center"
            });
            $('#modal_add_feed').css({
                display: 'none'
            })
        }else{
            alert('이미지가 아닙니다.');
            return;
        }
    };
    
</script>



</body>
</html>



<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<!-- 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
-->
<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
-->
