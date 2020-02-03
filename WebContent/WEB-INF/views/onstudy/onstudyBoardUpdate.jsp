<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.onstudy.model.vo.CAttachment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.semi.onstudy.model.vo.CBoard"%>
<% 
	CBoard board = (CBoard)request.getAttribute("board");
	String currentPage = request.getParameter("currentPage");
	ArrayList<CAttachment> files = (ArrayList<CAttachment>)request.getAttribute("files");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온스터디</title>
</head>
<body>

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
.form-td{
    display: block;
    padding: 10px;
    border: 1px solid #ced4da;
    border-radius: .25rem;
}
</style>

</head>
<body>
		<%@ include file="../common/loginedHeader.jsp" %>
		<div id="container">
          <div class="container">
            <div class="row">
              <div id="board-write-wrap" class="col-md-12">
                <h2 class="content-title">인증 게시판</h2>
                <p class="warning">파일첨부는 최대 4개까지 가능합니다.</p>
                <div class="board-write">
                  <form class="write-form" action="<%= request.getContextPath() %>/onstudy/boardUpdate?oNo=<%=board.getOnstudyNo() %>&bNo=<%=board.getBoardNo()%>&currentPage=<%=currentPage %>" 
                  method="post" enctype="multipart/form-data" role="form" onsubmit="return validate();">
                    <table>
                      <tr>
                        <th><label for="title">제목</label></th>
                        <td><input id="title" class="form-control input-comment " type="text" name="title" value=<%= board.getBoardTitle() %>></td>
                      </tr>
                      <tr>
                        <th><label for="content">내용</label></th>
                        <td>
                          <textarea id="content" class="form-control input-content" name="content" rows="15" cols="100"><%=board.getBoardContent() %></textarea>
                        </td>
                      </tr>
                      <tr>
                      	<th><label for="file">파일첨부</label></th>
                      	<td class="form-td">
                      		<div class="form-inline">
                      		
                      		<!-- 기본 첨부 이미지 세팅 -->
                      			<% if(files != null){ %>
                      				<% for(int i=0; i<files.size() ; i++) {
	                      				String src = request.getContextPath()+"/resources/onstudyBoard/"+files.get(i).getChangeName();
	                      			%>
                      				<div class="mr-2 boardImg" id="contentImgArea<%=i+1%>">
									<p class="plese-upload">클릭시 첨부</p>
									<img class="mini-thumbnail-img" id="contentImg<%=i+1%>" width="130" height="130" src="<%=src %>">
									</div>
                      				<%} %>
                      				<%if(files.size() < 4){ %>
                      					<%for(int j=files.size()+1 ; j<5; j++){ %>
                      					<div class="mr-2 boardImg" id="contentImgArea<%=j%>">
											<p class="plese-upload">클릭시 첨부</p>
											<img class="mini-thumbnail-img" id="contentImg<%=j%>" width="130" height="130">
										</div>
                      					<%} %>
                      				<%} %>
                      			<% }else{%>
                      				<%for(int k=0; k<4; k++){ %>
                      				<div class="mr-2 boardImg" id="contentImgArea<%=k+1%>">
									<p class="plese-upload">클릭시 첨부</p>
									<img class="mini-thumbnail-img" id="contentImg<%=k+1%>" width="130" height="130">
									</div>
									<%} %>
                      			<%} %>
                      			
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
                      	</td>
                      </tr>
                    </table>
                    <button class="submit-btn form-control orange-hover-btn" name="submit">저장</button>
                    <a class="cancel-btn form-control" href="boardDetail?oNo=<%=board.getOnstudyNo() %>&bNo=<%=board.getBoardNo()%>">취소</a>
                    
                    <!-- 이미지 수정 하려고 클릭하면 값이 바뀌어서 수정 여부 판별 가능 -->
                    <%if(files != null){ %>
                    <% for(int i=0 ; i<4 ; i++){ 
		                  if(i < files.size()){ %>
		               		<input type="hidden" name="beforeImg" value="<%= files.get(i).getChangeName()%>">
		               <% }else{%>
		               		<input type="hidden" name="beforeImg" value="">
		            <%    } 
		           	   } %>
		           <%} %>
                    
                    
                    
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
        <%@ include file="../common/footer.jsp"%>
        
        <script>	  
    		// 유효성 검사
	        function validate() {
    			
    			
    			/* 이미지 수정 시 필요한 부분 */
        	    $.each( $("input[type=file]"), function(index, item){
                   
                   if($(item).val() == ""){
                      $($("input[name=beforeImg]").get(index)).val("");
                   }
                });

    			
    			
				if ($("#title").val().trim().length == 0) {
					alert("제목을 입력해 주세요.");
					$("#title").focus();
					return false;
				}
	
				if ($("#content").val().trim().length == 0) {
					alert("내용을 입력해 주세요.");
					$("#content").focus();
					return false;
				}
			}
	
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
   		    	console.log($(value).val());
   	  			
   		    	var dot = $(value).val().lastIndexOf(".");
   		    	var ext = $(value).val().substring(dot+1, $(value).val().length);
   		    	
   		    	ext = ext.toLowerCase();
   		    	
   		    	var flag = true;
   		    	switch(ext){ 
   		    	case "jpg" : case "png" : case "gif" : case "jpeg" :
   		    		flag = false; break;
   	  			}
   	  			
   	  			
   		    	if(flag){
   		    		alert("사진 파일만 업로드해주세요!");
   		    	}else{
   		    	
	   		    	// 파일 업로드 시 업로드된 파일의 경로는 
	   		    	// 해당 요소에 files라는 배열이 생성되며 저장된다.
	   		    	if(value.files && value.files[0]){ //--> 파일이 선택이 된 경우
	   		    		var reader = new FileReader();
	   		    		reader.onload = function(e){
	   		    			switch(num){
	   		    				case 1 : $("#contentImg1").prop("src",e.target.result); break; 
	   		    				case 2 : $("#contentImg2").prop("src",e.target.result); break;
	   		    				case 3 : $("#contentImg3").prop("src",e.target.result); break;
	   		    				case 4 : $("#contentImg4").prop("src",e.target.result); break;
	   		    			}
	   		    		}
	   		    		
	   		    		// file에서 내용(Content)을 읽어옴.
	   		    		// + base64 인코딩된 경로를 반환
	   		    		reader.readAsDataURL(value.files[0]);
	   		    	}
   		    	}
   		    }
        	   
        </script>
        
</body>
</html>