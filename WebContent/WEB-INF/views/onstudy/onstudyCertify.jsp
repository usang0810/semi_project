<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.onstudy.model.vo.Onstudy"%>
<%@page import="java.util.List"%>
<%@page import="com.semi.onstudy.model.vo.CertifyCount"%>
<%@page import="com.semi.onstudy.model.vo.CertifyBoardTotal"%>
    
<%
   //List<Onstudy> nList = (List<Onstudy>)request.getAttribute("nList");
   //List<CertifyCount> twList = (List<CertifyCount>)request.getAttribute("twList");
   //List<CertifyCount> ccList = (List<CertifyCount>)request.getAttribute("ccList");
   
   List<CertifyBoardTotal> totalList = (List<CertifyBoardTotal>)request.getAttribute("totalList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <style>
      #container{
        margin: 200px 0 100px 0;
      }
      .onstudy-main-search{
        border: 1px solid #333333;
      }
      .option-detail:hover{
        color: #f15a25;
      }
      /* 온스터디 카드 공통 적용 */
.recommend-title,
.recommend-sub-title{
  text-align: center;
  margin-top : 10px;
}
.recommend-title{
  margin-top : 50px;
  font-weight : bold;
  font-size : 35px;
}
.card-title{
  font-size: 20px;
  font-weight: bold;
}
.card-body .d-flex{
  float: right;
}
/* .card-body .more-btn{
  border: 1px solid #f15a25;
  color: #f15a25;
}
.card-body .more-btn:hover{
  border: 1px solid #f15a25;
  background-color : #f15a25;
  color: #ffffff;
} */
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
               </div>
            </div>
         </div>
        
         <div class="row">
            <div class="col-md-12">
               <div class="row">
                  <% if(totalList.isEmpty()){ %>
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
                         for(CertifyBoardTotal cbt : totalList) { 
                            if(cbt.getImagePath() == null){
                            	cbt.setImagePath("noimage.png");
                        	}%>
                        <div class="col-md-4">
                           <div class="card"  >
                           <img class="mb-3" alt="랜덤 이미지" style="height: 200px" src="<%=request.getContextPath()%>/resources/onstudyThumbnails/<%=cbt.getImagePath()%>">
                           <div class="card-block">
                             <h5 class="card-title">
                            <%= cbt.getOnstudyTitle() %>
                             </h5>
                             <p class="card-text">
                               <span class="badge badge-pill badge-secondary">#<%= cbt.getCategoryNm() %></span><br>
                               <b>참여 기간</b>&nbsp;&nbsp;<%= cbt.getStartDt() %> ~ <%=cbt.getEndDt() %><br>
                               <b>참여 인원</b>&nbsp;&nbsp;총 <%=cbt.getMemberCount() %>명<br>
                               <b>인증 횟수</b>&nbsp;&nbsp;주 <%=cbt.getOnstudyCertifyCount() %>회<br>
                               <b>참 가 비</b>&nbsp;&nbsp;<%= cbt.getOnstudyFee() %>원<br>
                             	 <b>참 여 율</b>(<%= cbt.getTotalCertifyCount() %>회 / <%= cbt.getOnstudyCertifyCount() * cbt.getOnstudyWeeks() %>회)<br>
                              <div class="progress">
                              <div class="progress-bar" style="width:<%= cbt.getTotalCertifyCount() %>%; background-color: #002d4c;"><%= cbt.getTotalCertifyCount() %>%</div>
                              </div>
                              <br>
                              <p style="font-weight: bolder;">
                              	<p>
                             	
                             		<%if(cbt.getOnstudyCertifyCount() <= cbt.getWeekCertifyCount()){ %>
                              	<%= cbt.getTodayNWeek() %>주차 인증완료
		                                 <a class="btn form-control gray-btn" href="../onstudy/boardList?oNo=<%=cbt.getOnstudyNo() %>" style="float: right; width:30%;">인증완료</a> 
                              	 <%} else if(cbt.getOnstudyCertifyCount() > cbt.getWeekCertifyCount() && cbt.getTodayCertifyCount() != 0){%>
		                                 	오늘 인증 완료
		                                 <a class="btn form-control gray-btn" href="../onstudy/boardList?oNo=<%=cbt.getOnstudyNo() %>" style="float: right; width:30%;">인증완료</a> 
		                         <%}else{ %>
		                                 	인증해 주세요
		                                 <a class="btn form-control orange-hover-btn" href="../onstudy/boardList?oNo=<%=cbt.getOnstudyNo() %>" style="float: right; width:30%;">인증하기</a> 
		                                 
                              	 <%} %>
		                          </p>
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