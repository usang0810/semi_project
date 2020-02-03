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
/* 게시판상세 */
#container{
  margin: 200px 0 100px 0;
  text-align: center;
}
#board-content-wrap .board-title{
  font-weight: bold;
  margin-bottom : 50px;
}
#board-content-wrap .content-wrap{
  border: 1px solid #efefef;
  margin-bottom: 20px;
}
#board-content-wrap .board-content-title{
  text-align: initial;
  background: #002d4c;
  color: #ffffff;
  height: 50px;
  line-height: 50px;
  margin-bottom: 0;
  padding-left: 25px;
  font-weight: bold;
}
#board-content-wrap .board-content-title .numbering{
  border-right: 1px solid #efefef;
  height: 50px;
  display: inline-block;
  padding-right: 16px;
  margin-right: 10px;
}
#board-content-wrap .writer-date{
  overflow: hidden;
  border-bottom: 1px solid #efefef;
  height: 40px;
  line-height: 40px;
}
#board-content-wrap .writer-date .writer{
  float: left;
  margin-left: 25px;
}
#board-content-wrap .writer-date .date{
  float: right;
  margin-right: 10px;
}
#board-content-wrap .content{
  text-align: initial;
  padding-left: 40px;
  padding-bottom: 50px;
  margin-bottom: 0;
}
#board-content-wrap .comment-wrap{
  border: 1px solid #efefef;
  border-radius: 20px;
  width: 100%;
  margin: 0 auto;
}
#board-content-wrap .comment-title{
  text-align: initial;
  background: #9e9e9e;
  color: #ffffff;
  height: 40px;
  border-radius: 20px 20px 0 0;
  line-height: 40px;
  padding-left: 25px;
  font-weight: bold;
  margin-bottom: 0;
}
#board-content-wrap .comment{
  overflow: hidden;
  height: 40px;
  width: 100%;
  border-bottom: 1px solid #efefef;
  line-height: 40px;
  margin-bottom: 0;
}
#replyListArea{
    width: 100%;
    display: inline-block;
    border-bottom: 1px solid #efefef;
    line-height: 30px;
}
#replyListArea span.rWriter{
    display: inline-block;
    width: 15%;
    margin: 0 10px;
    float: left;
    font-weight: bold;
}
#replyListArea span.rDate{
    display: inline-block;
    width: 13%;
    color: gray;
    float: left;
    margin: 0 10px;
    font-size: 0.8em;
}
#replyListArea p.rContent{
  width: 100%;
  float: left;
  text-align: initial;
  padding-left: 6%;
}
#board-content-wrap .comment-id{
  float: left;
  width: 15%;
}
#board-content-wrap .comment-content{
    float: left;
}
#board-content-wrap .your-comment-wrap{
  padding: 1%;
  overflow: hidden;
  width: 100%;
}
#board-content-wrap .input-comment{
  width: 71%;
  float: left;
  margin-right: 1%;
}
#board-content-wrap .submit-btn{
    width: 10%;
    float: left;
    transform: translateY(10px);
}
.orange-btn-style,
.orange-btn-style:focus{
  background-color: #f15a25;
  color: #ffffff;
  border: none;
  padding: 0;
}
.input-comment.form-control:focus{
  border-color: #f15a25;
  box-shadow: 0 0 0 0.2rem rgba(241,90,37,.25);
}
.prev-next-title-wrap{
    overflow: hidden;
}
.prev-next-title-wrap .prev-title{
  overflow: hidden;
  margin: 0;
  border-bottom: none;
  border-right: none;
}
.prev-next-title-wrap .next-title{
    border-top: none;
}
.prev-next-title-wrap dl{
    border: 1px solid #efefef;
}
.prev-next-title-wrap dt{
  float: left;
  background: #002d4c;
  width: 13%;
  color: #ffffff;
  padding: 5px 0;
  min-width: 89px;
}
.prev-next-title-wrap dd{
  float: left;
  margin: 0;
  padding: 5px 0 5px 10px;
}
html a:hover{
  text-decoration: none;
}
.go-list-btn{
  width: 12%;
  float: right;
  margin-top: 30px;
}
.bottom-btn-wrap>a{
	width : 10%; 
	margin-left : 5px;
}
.my-id{
    width: 15%;
    float: left;
    font-weight: bold;
    transform: translateY(15px);
}
.board-image-wrap{
    overflow: hidden;
}
.uploaded-img{
    float: left;
    width: 130px;
    margin-right : 10px;
    cursor : pointer;
}
.board-image-title{
    float: left;
    background-color: #002d4c;
    color: #ffffff;
    font-weight: bold;
    width: 14%;
    height: 150px;
    margin-bottom: 0;
    line-height: 150px;
}
.board-image-con{
    border-top: 1px solid #efefef;
    overflow: hidden;
    height: 150px;
    padding: 13px;
}
</style>
</head>

<body>
	<%@ include file="../common/loginedHeader.jsp" %>
	
	<div id="container">
          <div class="container">
            <div class="row">
              <div id="board-content-wrap" class="col-md-12">
              	<h2 class="content-title">인증 게시판</h2>
                <div class="board-content">
                  <form class="board-form" method="post">
                    <div class="content-wrap">
                      <p class="board-content-title"><span class="numbering">No. <%= board.getRowNum() %></span><%= board.getBoardTitle() %></p>
                      <p class="writer-date">
                        <span class="writer">작성자 : <%= board.getBoardWriterId() %></span>
                        <span class="date">작성일 : <%= board.getBoardModifyDt() %></span>
                      </p>
                      <p class="content">
                      	<%= board.getBoardContent() %>
                      </p>
                      <% if(files != null){ %>
                      <div class="board-image-wrap">
                      	<p class="board-image-title">첨부파일</p>
                      	<div class="board-image-con">
	                      	<% for(int i=0; i<files.size() ; i++) {
	                      		String src = request.getContextPath()+"/resources/onstudyBoard/"+files.get(i).getChangeName();
	                      	%>
	                      	<img class="uploaded-img" src="<%= src %>" />
	                      	<% } %>
	                    </div>
                      </div>
                      <% } %>
                    </div>
                    <div class="bottom-btn-wrap">
	                   <a href="boardList?oNo=<%= board.getOnstudyNo() %>&currentPage=<%= currentPage %>" class="form-control orange-hover-btn go-list-btn">목록으로</a>
		               <% if(loginMember.getMemberId().equals(board.getBoardWriterId())){ %>
		               <a href="javascript:" id="board-mod-btn" class="form-control orange-hover-btn go-list-btn">수정</a>
		               <%} %>
						<%-- 온스터디 게시글은 삭제 불가 --%>
		               <%--<a href="javascript:" id="board-delete-btn" class="form-control orange-hover-btn go-list-btn">삭제</a> --%>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
    </div>
    <script>
    $("#board-mod-btn").on("click",function(){
		 location.href = "<%= request.getContextPath() %>/onstudy/boardUpdateView?oNo=<%= board.getOnstudyNo() %>&bNo=<%=board.getBoardNo()%>&currentPage=<%=currentPage%>";
	});
    </script>
    
	<%@ include file="../common/footer.jsp" %>
	
</body>
</html>