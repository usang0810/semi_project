<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.semi.onstudy.model.vo.Onstudy"%>

<%
	List<Onstudy> mList = (List<Onstudy>)request.getAttribute("mList");
	List<Onstudy> dList = (List<Onstudy>)request.getAttribute("dList");
	//Member loginMember = (Member)session.getAttribute("loginMember");
	String searchKeyword = request.getParameter("searchKeyword");
	String searchCategory = request.getParameter("searchCategory");
	String searchStartDt = request.getParameter("searchStartDt");
	String searchEndDt = request.getParameter("searchEndDt");
		
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
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/onstudy.css">
	
   
    <title>온스터디</title>
    <style>
    	#container{
    		margin : 200px auto 100px auto;
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
                <div class="page-header content-title">
                		  온스터디 검색
                </div>
              </div>
            </div>

            <!-- 검색  ../onstudy/searchList-->
            <div class="row">
              <div class="col-md-12 onstudy-main-search">
                <form method="get" action="../onstudy/searchList" onsubmit="return validate();">
                  <div class="onstudy-search-wrap">
	                 <input type="text"  class="col-sm-8 form-control input-content input-comment" id="search-keyword" name="search-keyword" placeholder="검색할 단어를 입력하세요">
	                 <button class="more-btn form-control orange-btn-style orange-hover-btn" id="search-btn" type="submit">검색</button><br>
                  </div>
                  <a class="option-detail-btn" href="#option-detail" data-toggle="collapse"><b>세부 옵션 설정 <span id="option-detail-icon">▼</span></b></a><br>
                  <div id="option-detail" class="collapse">
                    <b>- 카테고리</b><br>
						<div class="btn-category btn-group-toggle" name="search-category" data-toggle="buttons">
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="영어"> 영어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="중국어"> 중국어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="일본어"> 일본어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="스페인어"> 스페인어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="프랑스어"> 프랑스어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="한자"> 한자 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="JAVA"> JAVA 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="C언어"> C언어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="PYTHON"> PYTHON 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="자바스크립트"> 자바스크립트 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="정보처리기사"> 정보처리기사 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="수학"> 수학 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="한국사"> 한국사 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="과학"> 과학 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="사회"> 사회 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="공무원"> 공무원 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="임용고시"> 임용고시 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="수능"> 수능 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="전산세무"> 전산세무 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="search-category" value="기타 등등"> 기타 등등 
									</label>&nbsp;
								</div>
                    <br>
                    <b>- 기간설정</b><br><br>
                    <input class="form-control input-content input-comment" type="date" id="search-start" name="search-start">
                    ~
                    <input class="form-control input-content input-comment" type="date" id="search-end" name="search-end">
                  </div>
                </form>
              </div>
            </div>

            <br><br>
<!-- 인기 온스터디 -->
            <div class="row">
              <div class="col-md-12">
                <div class="row">
                  <div class="col-md-12">
                    <h3>
                      인기 온스터디&nbsp;<span class="badge badge-warning" style="color: white;">HOT</span>
                    </h3>
                    <hr>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="row">
             	 <%for(Onstudy onstudy : mList) { %>
                      <div class="col-md-4">
                        <div class="card">
                       	  <img class="mb-3" alt="온스타일 이미지" style="height:200px"
                       	  	src="<%= onstudy.getThumbnail() != null ? request.getContextPath() + "/resources/onstudyThumbnails/" + onstudy.getThumbnail() : request.getContextPath() + "/resources/onstudyThumbnails/noimage.png" %>"/>
                          <div class="card-block">
                            <h5 class="card-title"><%=onstudy.getOnstudyTitle() %></h5>
                            <p class="card-text">
                              <span class="badge badge-pill badge-secondary">#<%=onstudy.getCategoryNm() %></span><br>
                              <b>모집 마감</b>&nbsp;&nbsp;<%=onstudy.getOnstudyDeadlineDt() %><br>
                              <b>참여 기간</b>&nbsp;&nbsp;<%=onstudy.getOnstudyStartDt() %> ~ <%=onstudy.getOnstudyEndDt() %> (<%=onstudy.getOnstudyWeeks() %>주)<br>
                              <b>참여 인원</b>&nbsp;&nbsp;<%=onstudy.getMemberCount() %>명<br>
                              <b>인증 횟수</b>&nbsp;&nbsp;주 <%=onstudy.getOnstudyCertifyCount() %>회<br>
                              <b>참 가 비</b>&nbsp;&nbsp;<%=onstudy.getOnstudyFee() %>원<br>
                              <a class="btn form-control orange-btn-style orange-hover-btn" href="../onstudy/detail?oNo=<%=onstudy.getOnstudyNo() %>" style="float: right;">자세히보기</a>
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
            <!-- 신규 온스터디 -->
            <div class="row">
              <div class="col-md-12">
                <div class="row">
                  <div class="col-md-12">
                    <h3>
                      신규 온스터디&nbsp;<span class="badge badge-warning"  style="color: white;">NEW</span>
                    </h3>
                    <hr>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="row">
                 	 <%for(Onstudy onstudy : dList) { %>
                      <div class="col-md-4">
                        <div class="card">
                          <img class="mb-3" alt="온스타일 이미지" style="height:200px"
                          	src="<%= onstudy.getThumbnail() != null ? request.getContextPath() + "/resources/onstudyThumbnails/" + onstudy.getThumbnail() : request.getContextPath() + "/resources/onstudyThumbnails/noimage.png" %>" />
                          <div class="card-block">
                            <h5 class="card-title"><%=onstudy.getOnstudyTitle() %></h5>
                            <p class="card-text">
                              <span class="badge badge-pill badge-secondary">#<%=onstudy.getCategoryNm() %></span><br>
                              <b>모집 마감</b>&nbsp;&nbsp;<%=onstudy.getOnstudyDeadlineDt() %><br>
                              <b>참여  기간</b>&nbsp;&nbsp;<%=onstudy.getOnstudyStartDt() %> ~ <%=onstudy.getOnstudyEndDt() %> (<%=onstudy.getOnstudyWeeks() %>주)<br>
                              <b>인증  횟수</b>&nbsp;&nbsp;주 <%=onstudy.getOnstudyCertifyCount() %>회<br>
                              <b>참 가 비</b>&nbsp;&nbsp; <%=onstudy.getOnstudyFee() %> 원 <br>
                              <a class="btn form-control orange-btn-style orange-hover-btn" href="../onstudy/detail?oNo=<%=onstudy.getOnstudyNo() %>" style="float: right;">자세히보기</a>
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
          </div>
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

          $.each($("input[name=onstudy-category]"),function(index,item){
          	if($(item).val() == "<%=searchCategory%>"){
          		$(item).prop("checked", true);
          	}
          });      
          
          function validate() {
        	  location.href="main";
  		}
          
          
          
          
          
          
          
        </script>
	<%@ include file="../common/footer.jsp"%>



        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
