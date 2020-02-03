<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.board.model.vo.Board, java.util.List, com.semi.board.model.vo.PageInfo"%>
<%
	List<Board> bList = (List<Board>)request.getAttribute("bList");
	PageInfo pInf = (PageInfo)request.getAttribute("pInf");
	String boardType = (String)request.getAttribute("boardType");
	
	String searchKey = request.getParameter("searchKey");
	String searchValue = request.getParameter("searchValue");
	
	String status = null;
	if(boardType.equals("F")){
		status = "F";
	}else if(boardType.equals("FSEARCH")){
		status = "FSEARCH";
	}
	
	int listCount = pInf.getListCount();
	int currentPage = pInf.getCurrentPage();
	int maxPage = pInf.getMaxPage();
	int startPage = pInf.getStartPage();
	int endPage = pInf.getEndPage();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
/* 게시판 */
#container{
  margin: 200px 0 100px 0;
  text-align: center;
  min-height :505px;
}
#board-wrap .board-title{
  font-weight: bold;
  margin-bottom : 50px;
}
#board-wrap #search-wrap{
  overflow: hidden;
  margin-bottom: 30px;
  height: 45px;
  padding-top: 5px;
}
#board-wrap #search-wrap>*{
  float: right;
}
#board-wrap .board-form select{
  width: 15%;
  margin-right: 10px;
}
#board-wrap .board-form .input-content{
  width: 35%;
  margin-right: 10px;
}
#board-wrap .board-form .orange-btn-style{
  width: 7%;
  padding: 0;
}
#board-wrap .board-form .board{
  width: 100%;
  border: 1px solid #efefef;
  margin-bottom: 30px;
}
#board-wrap .board-form .board thead tr{
  background-color: #002d4c;
  color: #ffffff;
  height: 40px;
}
#board-wrap .board-form .board tbody tr:hover:not(.no-list-tr){
  background-color : rgba(0,123,255,.25);
  cursor: pointer;
}
#board-wrap .board-form .board tbody tr{
  height: 35px;
  border-bottom: 1px solid #efefef;
}
#board-wrap .board-form .board th:first-child{
  width: 10%;
}
#board-wrap .board-form .board th:nth-child(2){
  width: 55%;
}
#board-wrap .board-form .board th:nth-child(3){
  width: 20%;
}
#board-wrap .board-form .board th:last-child{
  width: 15%;
}
#board-wrap .board-form  .write-content-btn{
  padding: .375rem 0;
  position: absolute;
  right: 0;
  bottom: -20px;
}

/* 부트스트랩 색상 조정*/
.page-link:hover,
.page-link{
  color : #f15a25;
}
.page-item.active .page-link{
  background-color: #f15a25;
  border-color: #f15a25;
}
.form-control:focus,
.page-link:focus{
  box-shadow: 0 0 0 0.2rem rgba(241,90,37,.25);
}
.form-control:focus{
  border-color : #f15a25;
}

@media (max-width: 767px){
  #board-wrap .board-form .orange-btn-style{
    width: 10%;
  }
}
.no-has-list{
	display:none;
}
</style>
</head>

<body>
	<%@ include file="../common/loginedHeader.jsp" %>
	
	<!-- 게시판 container start-->
	<div id="container">
	          <div class="container">
	            <div class="row">
	              <div id="board-wrap" class="col-md-12">
	              	<h2 class="content-title">자유 게시판</h2>
	                <div class="board-content">
	                  <form action="<%= request.getContextPath() %>/board/freeBoardList?boardType=FSEARCH" method="post" class="board-form" onsubmit="return checkSearchVal();"> 
	                    <div id="search-wrap">                  
	                      <button type="submit" id="findContentBtn"class="find-btn form-control orange-btn-style orange-hover-btn">검색</button>
	                      <input type="text" id="searchValue" class="form-control input-content" placeholder="내용을 검색해주세요." name="searchValue">
	                      <select class="form-control" name="searchKey" id="searchKey">
	                        <option value="title">제목</option>
	                        <option value="writer">작성자</option>
	                        <option value="content">내용</option>
	                      </select>
	                    </div>    
	                      <div class="col-md-12">
	                        <div class="row"> 
	                          <table class="board free-board">
	                            <thead>
	                              <tr>
	                                <th>No</th>
	                                <th>제목</th>
	                                <th>작성자</th>
	                                <th>작성일</th>
	                              </tr>
	                            </thead>
	                            <tbody>
	                              <% if(bList.isEmpty()){ %>        
	                              <tr class="no-list-tr">
	                              	<td colspan="5"  class="nolist-warning">존재하는 게시글이 없습니다.</td>
	                              </tr>
	                              <% }else{ %>
	                              	<% for(Board board : bList){%>
	                              		<tr>
	                              			<td class="no-has-list"><%= board.getBoardNo()%></td>
	                              			<td class="has-list"><%= board.getBoardNumbering()%></td>
	                              			<td class="has-list"><%= board.getBoardTitle()%></td>
	                              			<td class="has-list"><%= board.getBoardWriter()%></td>
	                              			<td class="has-list"><%= board.getBoardModifyDt()%></td>
	                              			
	                              	<% } %>
	                              <% } %>
	                            </tbody>
	                          </table>
	                          <a href="<%= request.getContextPath() %>/board/goInsertFreeBoard" class="write-content-btn form-control orange-hover-btn orange-btn-style">글쓰기</a>
	                        </div>
	                      </div>
	                      <ul class="pagination">
	                      	<% if(currentPage>1){%>
	                        <li class="page-item">
	                          <a class="page-link" href="<%= request.getContextPath() %>/board/freeBoardList?boardType=<%= status %>&currentPage=1&searchKey=<%= searchKey %>&searchValue=<%= searchValue %>">&lt;&lt;</a>
	                        </li>
	                        <li class="page-item">
	                          <a class="page-link" href="<%= request.getContextPath() %>/board/freeBoardList?boardType=<%= status %>&currentPage=<%= currentPage-1 %>&searchKey=<%= searchKey %>&searchValue=<%= searchValue %>">&lt;</a>
	                        </li>
	                        <% } %>
	                        
	                        <% for(int p = startPage; p <= endPage; p++){ %>
	                        	<% if(p == currentPage) { %>
			                        <li class="page-item active">
			                          <a class="page-link"><%= p %></a>
			                        </li>
			                    <% }else{%>
			                    	<li class="page-item">
			                          <a class="page-link" href="<%= request.getContextPath() %>/board/freeBoardList?boardType=<%= status %>&currentPage=<%= p %>&searchKey=<%= searchKey %>&searchValue=<%= searchValue %>"><%= p %></a>
			                        </li>
	                        	<% }%>
                        	<% }%>
                        	
	                        <% if(currentPage<maxPage){%>
	                        <li class="page-item">
	                          <a class="page-link" href="<%= request.getContextPath() %>/board/freeBoardList?boardType=<%= status %>&currentPage=<%= currentPage+1 %>&searchKey=<%= searchKey %>&searchValue=<%= searchValue %>">&gt;</a>
	                        </li>
	                        <li class="page-item">
	                          <a class="page-link" href="<%= request.getContextPath() %>/board/freeBoardList?boardType=<%= status %>&currentPage=<%= maxPage %>&searchKey=<%= searchKey %>&searchValue=<%= searchValue %>">&gt;&gt;</a>
	                        </li>
	                        <% } %>
	                      </ul>
	                    </form>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	        <!-- 게시판 container end-->
	        <%@ include file="../common/footer.jsp"%>	   
	        
	        <script>
	        	$(function(){
	        		
		        	/* 게시글 상세 조회용  */
	        		$(".free-board .has-list").on({
	        			click : function(){
	        				var boardNo = $(this).parent().children().eq(0).text();
	        				var boardNumbering = $(this).parent().children().eq(1).text();
	        				location.href="<%= request.getContextPath() %>/board/freeBoardDetail?no="+boardNo +"&Numbering="+boardNumbering+"&currentPage="+<%=currentPage%>;
	        			}
	        		});
		        	
		        	
		        	/* 검색용 */
	        		var searchKey = "<%= searchKey %>";
            		var searchValue = "<%= searchValue %>";
            		
            		if(searchKey != "null" && searchValue != "null"){
            			// 검색한 경우
            			$.each( $("select[name=searchKey] > option"), function(index,item){
            				if($(item).val() == searchKey){
            					//$(item) : 현재 접근 요소
								$(item).prop("selected","true");	            					
            				}
            			});
            			$("input[name=searchValue]").val(searchValue);
            		}
            		
            		
	        	});
	        	
	        	// 검색내용없이 검색했을때 다시 첫 페이지로 이동
	        	function checkSearchVal(){
	        		console.log($("#searchKey").val());
	        		console.log($("#searchValue").val());
	        		
	        		if($("#searchValue").val().length==0){
	        			location.href="freeBoardList?boardType=F";
		        		return false;
	        		}
					return true;	        		
	        	}
	        	
	        </script>     
</body>
</html>