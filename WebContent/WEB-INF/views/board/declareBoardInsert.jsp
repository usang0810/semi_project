<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온스터디</title>

<style>
/* header */
*{margin:0; padding:0;}
a{
  text-decoration: none;
  color : #333333;
}
ul{
  list-style: none;
}
a:hover{
    text-decoration: none;
}
body{
  position: relative;
}
#shadow{
  width: 100%;
  height: 100%;
  position: fixed;
  top: 0;
  left: 0;
  background-color: rgba(0,0,0,0.5);
  z-index: 800;
  display: none;
  cursor : pointer;
}
#header{
    background-color: #002d4c;
    position: fixed;
    z-index: 500;
    width: 100%;
    top:0;
    left:0;
}
#header-wrap nav{
  margin-right: 8rem;
}
#header-wrap nav div > ul > li{
  float: left;
  padding-left: 10px;
  margin-left: 75px;
  position: relative;
}
#header-wrap nav div > ul > li:first-child{
  margin-left:0;
}
#header-wrap nav div > ul > li > ul{
  position: absolute;
  top: 38px;
  left: 0;
  width: 155px;
  padding: 10px;
  background-color: #024068;
  border-radius: 5px;
}
#header-wrap nav a:hover{
    color : #f15a25;
}
#header-wrap nav a.menu-list{
    color : white;
    font-size : 18px;
}
#header-wrap nav a.menu-list+ul{
  display: none;
}
#header-wrap .logo-img{
  width: 75%;
  min-width: 120px;
}
a.sub-menu-list{
 font-size : 16px;
 color : white;
}
.mypage-btn{
  width: 12%;
  text-align: center;
  cursor: default;
}
.mypage-btn img{
  width: 45px;
  transition: all 0.3s;
  cursor: pointer;
}
.mypage-btn img:hover{
  opacity : 0.7;
}

/* 좌측 마이페이지 부분 */
#mypage-nav{
  width: 280px;
  background-color: #002d4c;
  height: 100%;
  position: fixed;
  z-index: 900;
  padding-top: 30px;
  display: none;
  top:0;
  left:0;
}
#mypage-nav .info-area{
  background-color: #ffffff;
  border-radius: 10px;
  width: 80%;
  text-align: center;
  margin: 0 auto;
  padding: 50px 25px;
}
#mypage-nav .info-area .profile-icon{
  width: 100px;
}
#mypage-nav .info-area ul{
  margin-top: 20px;
}
#mypage-nav .info-area ul li{
  font-weight: bold;
}
#mypage-nav .bell-setting-btn{
  float: right;
}
#mypage-nav .bell-setting-btn img{
  width:30px;
}
#mypage-nav .mypage-btn-list a{
  color: #ffffff;
  font-size: 20px;
  display: block;
  text-align: center;
  margin-top: 30px;
}
#mypage-nav .mypage-btn-list a:hover{
  color :#f15a25;
}
/* 푸터 */
#footer{
  background-color: #55595c;
  padding: 20px 0;
}
#footer .footer-logo{
    width: 120px;
}
#footer .copyright{
  color: white;
  font-size: 17px;
  line-height: 91.5px;
  margin-bottom: 0;
  margin-left : 30px;
}
/* 탑 버튼 */
#button-top{
  position: fixed;
  bottom: 100px;
  right: 100px;
  display:none;
}
#button-top .top-btn{
  color: #ffffff;
  width: 50px;
  height: 50px;
  background-color: #f15a25;
  display: inline-block;
  text-align: center;
  line-height: 50px;
  border-radius: 50px;
  font-weight: 600;
  border: none;
}

/* 반응형 세부 수정사항 */
@media (max-width: 767px){ /*767px : 구조가 바뀌는 기준*/
  #logo-wrap{
    text-align: center;
  }
  #header-wrap nav{
    margin-right: 0;
  }
  .mypage-btn{
    width: 9%;
    text-align: center;
    position: absolute;
    left: 7%;
    top: 50%;
    transform: translate(0, -50%);
  }
  #footer .footer-logo-wrap{
    text-align: center;
  }
  #footer .copyright{
    margin: 0;
    text-align: center;
  }
}
@media (max-width: 590px){
  #header-wrap nav div > ul > li{
    margin-left:30px;
  }
}
/* 기본 CSS 적용 */
ul{list-style: none;}
img,fieldset{border:none;}
body,input{color : #333333 !important;}
input,select,img{vertical-align:middle;}
table	{border-collapse:collapse;}

html body .background-navy{
  background: #002d4c;
  color: #ffffff;
}
html body .background-orange{
  background: #f15a25;
  color: #ffffff;
}
html body .background-gray{
  background: #9e9e9e;
  color: #ffffff;
}
html body .form-control.navy-btn{
  background-color: #002d4c;
  color: #ffffff;
  border: none;
  padding: 0;
}
html body .form-control.orange-btn{
  background-color: #f15a25;
  color: #ffffff;
  border: none;
  padding: 0;
}
html body .form-control.navy-hover-btn{
  background: transparent;
  color: #002d4c;
  border: 1px solid #002d4c;
  transition: all 0.3s;
}
html body .form-control.navy-hover-btn:hover{
  background:  #002d4c;
  color: #ffffff;
}
html body .form-control.orange-hover-btn{
  background: transparent;
  color: #f15a25;
  border: 1px solid #f15a25;
  transition: all 0.3s;
}
html body .form-control.orange-hover-btn:hover{
  background:  #f15a25;
  color: #ffffff;
}
html body .form-control.gray-btn{
  background-color: #f15a25;
  color: #9e9e9e;
  border: none;
  padding: 0;
}
html body .content-seciton.orange-hover-background{
  background-color: #9e9e9e;
  color: #333333;
  transition: all 0.3s;
}    
html body .content-seciton.orange-hover-background:hover{
  background-color: #f15a25;
  color: #ffffff;
}   
html body .form-control.input-comment{
  transition: all 0.3s;
}
html body .form-control.input-comment:focus{
  border-color: #f15a25;
  box-shadow: 0 0 0 0.2rem rgba(241,90,37,.25);
}
html body .content-title{
  text-align: initial;
  margin: 50px 0;
  font-size: 35px;
  border-bottom: 2px solid #333333;
  padding-bottom: 10px;
}
.page-link:hover,
.page-link{
  color : #f15a25;
}
.page-item.active .page-link{
  background-color: #f15a25;
  border-color: #f15a25;
}
.page-link:focus{ 
  box-shadow: 0 0 0 0.2rem rgba(241,90,37,.25);
}
.pagination{
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  bottom: -80px;
}
/* 반응형 세부 수정사항 */
@media (max-width: 767px){ /*767px : 구조가 바뀌는 기준*/
  .form-control{
    min-width : 90px;
  }
}
/* 게시판 작성용 css */
#container{
  margin: 200px 0 100px 0;
  text-align: center;
}
#board-write-wrap .board-title{
  font-weight: bold;
  margin-bottom : 50px;
}
.warning{
  text-align: end;
  color: #ee4135;
  margin : 5px 0;
}
.board-write table{
  margin: 0 auto;
  width: 100%;
}
.board-write table th{
  width: 20%;
  background: #002d4c;
  color: #ffffff;
  border-radius: .25rem;
}
.board-write .input-content{
    resize: none;
}
.file{
  padding: 10px;
  height: 50px;
}
.board-write .submit-btn{
  background-color: #f15a25;
  color: #ffffff;
  border: none;
  padding: 0;
  width: 11%;
  margin-top: 15px;
  float: right;
}
.board-write .cancel-btn{
  float: right;
  background-color: #9e9e9e;
  color: #ffffff;
  margin-top: 15px;
  border: none;
  padding: 0;
  width: 8%;
  float: right;
  line-height: 38px;
  margin-right: 5px;
}
#board-write-wrap .form-control:focus:focus{
  border-color: #f15a25;
  box-shadow: 0 0 0 0.2rem rgba(241,90,37,.25);
}
.form-td img{
	cursor : pointer;
}
.form-td{
    display: block;
    padding: 10px;
    border: 1px solid #ced4da;
    border-radius: .25rem;
}
#declare-id{
    width: 50%;
    min-width: 355px;
    float: left;
}
#confirm-declare-id{
    float: left;
    margin-left: 10px;
    width: 10%;
    min-width: 70px;		
}
.form-inline>.boardImg{
    position: relative;
    width: 130px;
    height: 130px;
}
.plese-upload{
	position : absolute;
	top : 50%;
	left : 50%; 
	transform : translate(-50%,-50%);
	color : #6c757d;
}
.mini-thumbnail-img{
	position : absolute;
	top : 0;
	left : 0;
}
#confirm-result{
    color: green;
    transform: translateY(9px);
    float: left;
    display: inline-block;
    font-size: 13px;
    text-align: initial;
    margin-left: 1.5%;
}
.secret-wrap{
	text-align:end;
	margin-bottom:10px;
}
.secret-wrap>*{
	cursor : pointer;
	font-size : 17px;
}
#container .custom-control-label::before,
#container .custom-control-label::after{
	top: 5px;
}
</style>

</head>
<body>
		<%@ include file="../common/loginedHeader.jsp" %>
		<div id="container">
          <div class="container">
            <div class="row">
              <div id="board-write-wrap" class="col-md-12">
                <h2 class="content-title">건의/신고 게시판 작성하기</h2>
                <p class="warning">비밀글은 신고/건의 카테고리에만 작성할 수 있습니다.</p>
                <p class="warning">같은 회원에게 신고할 수 있는 최대 횟수는 5번입니다.</p>
                <p class="warning">파일첨부는 최대 4개까지 가능합니다.</p>
                <div class="board-write">
                  <form class="write-form" action="<%= request.getContextPath() %>/board/declareBoardInsertDo" onsubmit="return validate();"
                   method="post" enctype="multipart/form-data" role="form" >
					<div class="custom-control custom-checkbox secret-wrap">
						<input type="checkbox" id="secret" name="secretStatus" value="Y" class="custom-control-input">
						<label class="custom-control-label secret-text" for="secret">비밀글</label>
					</div>
                    <table>
                      <tr>
                        <th>
                       	 <label for="category-select">분류</label>
                       	</th>
                        <td class="form-td">
	                        <select class="form-control category-selection" name="category">
	                          <option value="D" selected>신고</option>
	                          <option value="S">건의</option>
	                        </select>
                        </td>
                      </tr>
                      <tr>
                        <th><label for="title">제목</label></th>
                        <td class="form-td"><input id="title" class="form-control input-title" type="text" name="title" placeholder="제목을 입력해주세요." autocomplete="off"></td>
                      </tr>
                      <tr class="declare-tr">
                        <th><label for="title">신고하려는 회원 아이디</label></th>
                        <td class="form-td" style="overflow:hidden;">
                        	<input id="declare-id" class="form-control input-title" type="text" name="declareId" placeholder="신고하고자 하는 회원 아이디를 입력해주세요.">
                        	<button type="button" id="confirm-declare-id" class="form-control orange-hover-btn">확인</button>
                        	<span id="confirm-result"></span>
                        </td>
                      </tr>
                      <tr>
                        <th><label for="content">내용</label></th>
                        <td class="form-td">
                          <textarea id="content" class="form-control input-content" name="content" rows="15" cols="100" placeholder="내용을 입력해주세요."></textarea>
                        </td>
                      </tr>
                      <tr>
                      	<th><label for="file">파일첨부</label></th>
                      	<td class="form-td">
                      		<div class="form-inline">
								<div class="mr-2 boardImg" id="contentImgArea1">
									<p class="plese-upload plese-upload1">클릭시 첨부</p>
									<img class="mini-thumbnail-img" id="contentImg1" width="130" height="130">
								</div>
			
								<div class="mr-2 boardImg" id="contentImgArea2">
									<p class="plese-upload plese-upload2">클릭시 첨부</p>
									<img class="mini-thumbnail-img" id="contentImg2" width="130" height="130">
								</div>
			
								<div class="mr-2 boardImg" id="contentImgArea3">
									<p class="plese-upload plese-upload3">클릭시 첨부</p>
									<img class="mini-thumbnail-img" id="contentImg3" width="130" height="130">
								</div>
								
								<div class="mr-2 boardImg" id="contentImgArea4">
									<p class="plese-upload plese-upload4">클릭시 첨부</p>
									<img class="mini-thumbnail-img" id="contentImg4" width="130" height="130">
								</div>
							</div>
							<!-- 파일 업로드 하는 부분 -->
							<div id="fileArea">
								<input type="file" id="img1" 
									name="img1" onchange="LoadImg(this,1)"> 
								<input type="file" id="img2" 
									name="img2" onchange="LoadImg(this,2)"> 
								<input type="file" id="img3" 
									name="img3" onchange="LoadImg(this,3)">
								 <input type="file" id="img4"
									name="img4" onchange="LoadImg(this,4)">
							</div>
                      	</td>
                      </tr>
                    </table>
                    <button class="submit-btn form-control orange-hover-btn" name="submit">작성 완료</button>
                    <a class="cancel-btn form-control" href="declareBoardList?boardType=SD">취소</a>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
        <%@ include file="../common/footer.jsp"%>
        	  
       
         <script>	
	       	var declareStatus = false;
         	// 신고/건의 분류 선택시 신고자 인풋창 show,hide 이벤트
         	$(".category-selection").on({
         		"change" : function(){
	         		var state = $(".category-selection>option:selected").val();
    				if(state == "D"){
    					$(".declare-tr").show();
    					declareStatus = false;
    				}else{
    					$(".declare-tr").hide();
    					declareStatus = true;
    					$("#declare-id").val("");
    					$("#confirm-result").text("");
    				}
         		}
         	});
         	
       		
    		// 유효성 검사
	        function validate() {
    			
	        	var category = $(".category-selection>option:selected").val();
	        	var declareId = $("#declare-id").val();
	        	
	        	if(category == "S"){
	        		declareStatus = true;
	        		if ($("#title").val().trim().length == 0) {
						alert("제목을 입력해 주세요.");
						$("#title").focus();
						return false;
					}
		        	if($("#content").val().trim().length == 0) {
						alert("내용을 입력해 주세요.");
						$("#content").focus();
						return false;
					}
	        		
	        	}else if(category == "D"){
	        		if ($("#title").val().trim().length == 0) {
						alert("제목을 입력해 주세요.");
						$("#title").focus();
						return false;
					}
		        	if($("#content").val().trim().length == 0) {
						alert("내용을 입력해 주세요.");
						$("#content").focus();
						return false;
					}
	        		if($("#declare-id").val().trim().length == 0){
	        			alert("신고하려는 회원의 아이디를 입력해주세요.");
						$("#declare-id").focus();
						return false;
	        		}
	        		if(declareStatus == false){
	        			alert("신고회원의 아이디를 다시 한번 확인해주세요.");
						$("#declare-id").focus();
						return false;
	        		}
	        	}
			}
			
	     // 신고하려는 아이디 존재확인 버튼
   		  $("#confirm-declare-id").on({
   			  click : function(){
   			  		var declareId = $("#declare-id").val();
   			  		if(declareId.trim().length == 0){
	   			  		alert("신고하려는 회원의 아이디를 입력해주세요.");
						$("#declare-id").focus();
   			  		}else{
   			  			if(declareId == "<%= loginMember.getMemberId()%>"){
   			  				$("#confirm-result").html("본인을 신고할 수는 없습니다.").css("color","red");
   			  			}else{
	   			  			$.ajax({
		   						url : "confirmDeclareId",
		   						type : "post",
		   						dataType : "text",
		   						data : {declareId : declareId},
		   						success : function(result){
		   							$("#confirm-result").html("");
		   							if(result>5){
		   								alert("해당 회원에게 신고한 횟수가 이미 5회를 초과하셨습니다. 더 이상 신고할 수 없습니다.");
		   								$("#confirm-result").html("이 회원은 더이상 신고가 불가합니다.").css("color","red");
		   								declareStatus= false;	
		   							}else if(result>0){
		   								$("#confirm-result").html("회원 아이디가 확인 되었습니다.").css("color","green");
		   								declareStatus = true;		
		   							}else{
		   								$("#confirm-result").html("해당 아이디는 존재하지 않습니다.").css("color","red");
		   								declareStatus = false;	
		   							}
		   						}
		   					});
   			  			}
   			  		}
   			  }
   		  });
        	$(function(){
        		
        		
        		// 이미지 공간을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수
       	    	// 파일 선택 버튼이 있는 영역을 보이지 않게 함.
       			$("#fileArea").hide();
       	    	
       	    	// 이미지 영역 클릭 시 파일 첨부창 띄우기
       	    	$("#contentImgArea1").click(function(){
       	    		$("#img1").click();
       	    	});
       	    	$("#contentImgArea2").click(function(){
       	    		$("#img2").click();
       	    	});
       	    	$("#contentImgArea3").click(function(){
       	    		$("#img3").click();
       	    	});
       	    	$("#contentImgArea4").click(function(){
       	    		$("#img4").click();
       	    	}); 
        	    	
       	    	
        	});
        	
        	// 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
   		     function LoadImg(value, num) {
   	  			
   		    	var dot = $(value).val().lastIndexOf(".");
   		    	var ext = $(value).val().substring(dot+1, $(value).val().length);
   		    	
   		    	ext = ext.toLowerCase();
   		    	
   		    	var flag = true;
   		    	switch(ext){ 
   		    	case "jpg" : case "png" : case "gif" : case "jpeg" : case "bmp" : case "tiff" : case "raw" :
   		    		flag = false; break;
   	  			}
   	  			
   		    	/* if(flag){
   		    		alert("사진 파일만 업로드해주세요!"); 
   		    	} 
   		    	else{ */
   		    	
	   		    	// 파일 업로드 시 업로드된 파일의 경로는 
	   		    	// 해당 요소에 files라는 배열이 생성되며 저장된다.
   		    	if(value.files && value.files[0]){ //--> 파일이 선택이 된 경우
   		    		var reader = new FileReader();
   		    		reader.onload = function(e){
   		    			if(flag==false){
	   		    			switch(num){
	   		    				case 1 : $("#contentImg1").prop("src",e.target.result); break; 
	   		    				case 2 : $("#contentImg2").prop("src",e.target.result); break;
	   		    				case 3 : $("#contentImg3").prop("src",e.target.result); break;
	   		    				case 4 : $("#contentImg4").prop("src",e.target.result); break;
	   		    			}
   		    			}else{
	   		    			switch(num){
	   		    				case 1 : $("#contentImg1").prop("src","../images/document.png");
	   		    				         $(".plese-upload1").text(""); break;
	   		    				case 2 : $("#contentImg2").prop("src","../images/document.png");
	   		    				         $(".plese-upload2").text(""); break;
	   		    				case 3 : $("#contentImg3").prop("src","../images/document.png");
	   		    				         $(".plese-upload3").text(""); break;
	   		    				case 4 : $("#contentImg4").prop("src","../images/document.png");
	   		    				         $(".plese-upload4").text(""); break;
	   		    			}
   		    			}
   		    				
   		    		}
   		    		
   		    		// file에서 내용(Content)을 읽어옴.
   		    		// + base64 인코딩된 경로를 반환
   		    		reader.readAsDataURL(value.files[0]);
   		    	}
//		    }
		    }
    	   
    </script>
    
</body>
</html>