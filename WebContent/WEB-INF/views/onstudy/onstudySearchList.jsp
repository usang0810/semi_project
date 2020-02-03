<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.semi.onstudy.model.vo.Onstudy"%>
<%@page import="com.semi.onstudy.model.vo.PageInfo"%>

<%
//String msg = (String)session.getAttribute("msg");
List<Onstudy> sList = (List<Onstudy>)request.getAttribute("sList");
PageInfo pInf = (PageInfo)request.getAttribute("pInf");
String condition=(String)session.getAttribute("condition");


String searchKeyword = request.getParameter("search-keyword");
String searchCategory = request.getParameter("search-category");
String searchStart = request.getParameter("search-start");
String searchEnd = request.getParameter("search-end");

int listCount = pInf.getListCount();
int currentPage = pInf.getCurrentPage();
int maxPage = pInf.getMaxPage();
int startPage = pInf.getStartPage();
int endPage = pInf.getEndPage();
%>
    
<!DOCTYPE html>
<html lang="ko">
    <head>
    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	    <link rel="shortcut icon" href="img/favicon.png">
	    <link rel="apple-touch-icon-precomposed" href="img/icon57.png">
	    <link rel="apple-touch-icon-precomposed" href="img/icon114.png">
	    <link rel="stylesheet" href="../css/common.css">
	    <link rel="stylesheet" href="../css/header.css">
		<link rel="stylesheet" href="../css/onstudyMain.css">
		   
	    <title>온스터디</title>
	    <style>
	      #container{
	        margin: 200px 0 100px 0;
	      }
	    </style>
	
	    </head>
	    <body>
	     <%@ include file="../common/loginedHeader.jsp" %>
    
        <div id="container" style="color:#333333;"> <!-- container 시작 div -->
          
          
          <div class="container-fluid container">

            <!-- 타이틀 -->
            <div class="row"> 
              <div class="col-md-12">
                <div class="page-header">
                  검색 결과
                </div>
              </div>
            </div>

            <!-- 검색 -->
            <div class="row">
              <div class="col-md-12 onstudy-main-search">
                <form method="get" action="../onstudy/searchList">
                  <input type="text" id="search-keyword" name="search-keyword" class="col-sm-10" value="<%=searchKeyword %>" placeholder="검색할 단어를 입력하세요">
                  <button class="btn btn-outline-secondary more-btn" id="search-btn" type="submit">검색</button><br>
                  <a class="option-detail-btn" href="#option-detail"><b>세부 옵션 설정 <span id="option-detail-icon">▼</span></b></a><br>
                  <div id="option-detail">
                    <b>- 카테고리</b><br>
						<div class="btn-category btn-group-toggle" id="onstudy-category" name="onstudy-category" data-toggle="buttons">
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="영어"> 영어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="중국어"> 중국어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="일본어"> 일본어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="스페인어"> 스페인어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="프랑스어"> 프랑스어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="한자"> 한자 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="JAVA"> JAVA 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="C언어"> C언어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="PYTHON"> PYTHON 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="자바스크립트"> 자바스크립트 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="정보처리기사"> 정보처리기사 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="수학"> 수학 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="한국사"> 한국사 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="과학"> 과학 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="사회"> 사회 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="공무원"> 공무원 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="임용고시"> 임용고시 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="수능"> 수능 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="전산세무"> 전산세무 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="기타 등등"> 기타 등등 
									</label>&nbsp;
								</div>
                    <br>
                    <b>- 기간설정</b><br>
                    <input type="date" name="search-start" value="<%=searchStart %>">
                    ~
                    <input type="date" name="search-end" value="<%=searchEnd%>">
                  </div>
                </form>
              </div>
            </div>

            <br><br>
            <!-- 온스터디 -->
            <div class="row">
              <div class="col-md-12">
                <div class="row">
                  <div class="col-md-12">
                    <hr>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="row">
                <%for(Onstudy onstudy : sList) { %>
                      <div class="col-md-4">
                        <div class="card">
                          <img class="mb-3" alt="온스타일 이미지" style="height:200px"
                          	src="<%= onstudy.getThumbnail() != null ? request.getContextPath() + "/resources/onstudyThumbnails/" + onstudy.getThumbnail() : request.getContextPath() + "/resources/onstudyThumbnails/noimage.png" %>" />
                          <div class="card-block">
                            <h5 class="card-title">
                        <%=onstudy.getOnstudyTitle() %>
                            </h5>
                            <p class="card-text">
                              <span class="badge badge-pill badge-secondary">#<%=onstudy.getCategoryNm() %></span><br>
                              <b>모집 마감</b>&nbsp;&nbsp;<%=onstudy.getOnstudyDeadlineDt() %><br>
                              <b>참여 기간</b>&nbsp;&nbsp;<%=onstudy.getOnstudyStartDt() %> ~ <%=onstudy.getOnstudyEndDt() %> (<%=onstudy.getOnstudyWeeks() %>주)<br>
                              <b>인증 횟수</b>&nbsp;&nbsp;주 <%=onstudy.getOnstudyCertifyCount() %>회<br>
                              <b>참 가 비</b>&nbsp;&nbsp;<%=onstudy.getOnstudyFee() %><br>
                              <a class="btn btn-outline-secondary more-btn" href="../onstudy/detail?oNo=<%=onstudy.getOnstudyNo() %>" style="float: right;">자세히보기</a>
                            </p>
                          </div>
                        </div>
                      </div>
             	<%} %>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <br><br>
        <!-- 페이징바 -->
	        <div style="clear: both;">
	            <ul class="pagination">
	            	<% if(currentPage > 1) { %>
	                <li>
	                	<!-- 맨 처음으로(<<) -->
	                    <a class="page-link" href="<%= request.getContextPath() %>/onstudy/searchList?currentPage=1">&lt;&lt;</a>
	                </li>
	                
	                <li>
	                	<!-- 이전으로(<) -->
                   		<a class="page-link" href="<%= request.getContextPath() %>/onstudy/searchList?currentPage=<%= currentPage-1 %>">&lt;</a>
	                </li>
	                <% } %>
	                
	                <!-- 페이지 목록 -->
	                <% for(int p = startPage; p <= endPage; p++){ %>
	                	<% if(p == currentPage) { %>
		                <li>
		                    <a class="page-link"><%= p %></a>
		                </li>
	                	<% } else{ %>
                		<li>
	                    	<a class="page-link" href="<%= request.getContextPath() %>/onstudy/searchList?currentPage=<%= p %>"><%= p %></a>              
	                	</li>
	                	<% } %>
					<%} %>
	                
	                <!-- 다음 페이지로(>) -->
	                <% if(currentPage < maxPage){ %>
	                <li>
	                    <a class="page-link" href="<%= request.getContextPath() %>/onstudy/searchList?currentPage=<%= currentPage+1 %>">&gt;</a>
	                </li>
	                
	                
	                
	                <!-- 맨 끝으로(>>) -->
	                <li>
	                    <a class="page-link" href="<%= request.getContextPath() %>/onstudy/searchList?currentPage=<%= maxPage %>">&gt;&gt;</a>
	                </li>
	                <% }%>
	                
	            </ul>
	        </div>              <br><br>

        </div> <!-- container 종료 div -->

        <script>
          // 팔로우 버튼 클릭시 이벤트
          $(function(){
            var optionToggle = 0;
            $(".follow-btn").on({
              click : function(){
                if(followToggle==0){
                  var count = $(".follower-count dt").html();
                  count++;
                  $(".follower-count dt").html(count);
                  followToggle = 1;
                  $(".follow-btn").html("팔로우 취소");
                }else{
                  var count = $(".follower-count dt").html();
                  count--;
                  $(".follower-count dt").html(count);
                  followToggle = 0;
                  $(".follow-btn").html("팔로우");
                }
              }
            });
          
          
            // 세부 옵션 클릭시 이벤트
            $(".option-detail-btn").on({
              click : function(){
                if(optionToggle == 0){
                  var count = $("#option-detail-icon").html("▲");
                  $(this).css("color", "#f15a25");
                  optionToggle = 1;
                }else{
                  var count = $("#option-detail-icon").html("▼");
                  $(this).css("color", "#333333");
                  optionToggle = 0;
                }
              }
            });
          });
        </script>

        <div id="button-top">
          <button type="button" class="top-btn">TOP</button>
        </div>

        <script>
        
        $(function(){
            var optionToggle = 0;
            $(".follow-btn").on({
              click : function(){
                if(followToggle==0){
                  var count = $(".follower-count dt").html();
                  count++;
                  $(".follower-count dt").html(count);
                  followToggle = 1;
                  $(".follow-btn").html("팔로우 취소");
                }else{
                  var count = $(".follower-count dt").html();
                  count--;
                  $(".follower-count dt").html(count);
                  followToggle = 0;
                  $(".follow-btn").html("팔로우");
                }
              }
            });
          
          
            // 세부 옵션 클릭시 이벤트
            $(".option-detail-btn").on({
              click : function(){
                if(optionToggle == 0){
                  var count = $("#option-detail-icon").html("▲");
                  $(this).css("color", "#f15a25");
                  optionToggle = 1;
                }else{
                  var count = $("#option-detail-icon").html("▼");
                  $(this).css("color", "#333333");
                  optionToggle = 0;
                }
              }
            });
          
          $("#search-category").on({
          	click : function(){
        		$('input[name="search-category"]').prop("chekced");
          	}
          
            });
         
   
      	});
        
        
        $.each($("input[name=onstudy-category]"),function(index,item){
        	if($(item).val() == "<%=searchCategory%>"){
        		$(item).prop("checked", true);
        	}
        });      
        
        
        
        
        
       
       </script>

<%@ include file="../common/footer.jsp"%>

        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
