<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.onstudy.model.vo.Onstudy"%>
<%@page import="java.util.List"%>
    
<%
	List<Onstudy> nList = (List<Onstudy>)request.getAttribute("nList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <style>
      #container{
        margin: 200px 0 100px 0;
      }
      .page-header{
        text-align: initial;
        margin: 50px 0;
        font-size: 35px;
        border-bottom: 4px solid #212529;
        padding-bottom: 10px;
      }
      .onstudy-main-search{
        border: 1px solid #333333;
      }
      .option-detail:hover{
        color: #f15a25;
      }
    </style>

<title>온스터디</title>
</head>
<body>

	<!-- header -->
	<%@ include file="../common/loginedHeader.jsp" %>
	
	
	<!-- content -->
	<div id="container" style="color:#333333;">
	
		<div class="container-fluid container">
		  
			<div class="row">
				<div class="col-md-12">
					<div class="content-title">
					온스터디 인증
					n번째 주는 체크를 못했는데,, 어떡하냐,,
					</div>
				</div>
			</div>
		  
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<% if(nList.isEmpty()){ %>
							<div class="col-md-12">
								<div class="jumbotron text-center">
								<br><br>
								<i class="fa fa-exclamation-circle fa-5x"></i><br><br>
								<h2 style="text-align: center;">
								참여 중인 온스터디가 없습니다.
								</h2>
								<br><br>
								<a class="btn btn-outline-secondary" href="onstudy_main.html">온스터디 보러가기</a>
								<br><br>
								</div>
							</div>
						<% }else{ 
		          			for(Onstudy onstudy : nList) { 
			          			if(onstudy.getThumbnail() == null){
									onstudy.setThumbnail("noimage.png");
								}%>
			            	<div class="col-md-4">
			            		<div class="card"  >
									<img class="mb-3" alt="랜덤 이미지" style="height: 200px" src="<%=request.getContextPath()%>/resources/onstudyThumbnails/<%=onstudy.getThumbnail()%>">
									<div class="card-block">
			  						<h5 class="card-title">
			    					<%= onstudy.getOnstudyTitle() %>
			  						</h5>
								  	<p class="card-text">
									    <span class="badge badge-pill badge-secondary">#<%= onstudy.getCategoryNm() %></span><br>
									    <b>참여 기간</b>&nbsp;&nbsp;<%=onstudy.getOnstudyStartDt() %> ~ <%=onstudy.getOnstudyEndDt() %><br>
									    <b>참여 인원</b>&nbsp;&nbsp;총 <%=onstudy.getMemberCount() %>명<br>
									    <b>인증 횟수</b>&nbsp;&nbsp;주 <%=onstudy.getOnstudyCertifyCount() %>회<br>
									    <b>참 가 비</b>&nbsp;&nbsp;<%= onstudy.getOnstudyFee() %>원<br>
									    <b>참 여 율</b>(회 / <%= onstudy.getOnstudyCertifyCount() * onstudy.getOnstudyWeeks() %>회)<br>
										<div class="progress">
										<div class="progress-bar" style="width:70%; background-color: #002d4c;">70%</div>
										</div>
										<br>
										<p style="font-weight: bolder;">
										<%if(onstudy.getTodayCertifyCheck() == 0){ %>
											인증해 주세요
											<p>
											<a class="btn form-control orange-hover-btn" href="../onstudy/boardList?oNo=<%=onstudy.getOnstudyNo() %>" style="float: right;">인증하기</a>
											</p>
										<%}else{ %>
											오늘 인증 완료
											<p>
											<a class="btn form-control gray-btn" href="../onstudy/boardList?oNo=<%=onstudy.getOnstudyNo() %>" style="float: right;">인증완료</a>
											</p>
										<%} %>
									</p>
									</div>
								</div>
							</div>
						<%} %>
	              	<%} %>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- content end -->
	<%@ include file="../common/footer.jsp"%>
</body>
</html>