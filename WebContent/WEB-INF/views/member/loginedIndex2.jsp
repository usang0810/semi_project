<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.semi.onstudy.model.vo.Onstudy"%>
<%@page import="com.semi.member.model.vo.Member"%>
<%
	String msg = (String)session.getAttribute("msg");
	Member loginMember = (Member)session.getAttribute("loginMember");
	List<Onstudy> pList = (List<Onstudy>)request.getAttribute("pList");
	
%> 
<	!DOCTYPE html>
<html lang="ko">

<head>

	<link rel="stylesheet" href="../css/header.css?ver=1">
	<link rel="stylesheet" href="../css/logined_main.css?ver=1">
	<link rel="stylesheet" href="../css/common.css?ver=1">
	
	<title>온 스터디</title>
</head>

<body>

	<%@ include file="../common/loginedHeader.jsp" %>
	
  <!-- content -->
  <div class="container" style="margin-top: 200px;">
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-6">
          <!-- 공지사항 -->
          <div class="jumbotron text-center border">
            <h3>공지사항</h3>
            <br>
            <p>업데이트 내용</p>
            <p>업데이트 내용</p>
            <p>업데이트 내용</p>
            <p>버그 수정 내용</p>
            <p>버그 수정 내용</p>
            <p>버그 수정 내용</p>
          </div>
        </div>
        <!-- 공지사항 끝 -->
        <!-- 학습노트 -->
        <div class="col-md-6">
          <div class="jumbotron text-center border pb-3">
            <h3>금주의 학습노트 제작자</h3>
            <p>축하드립니다! 이번주에 제일 많은 좋아요를 받으셨어요!</p>
            <br>
            <div class="mb-3" id="profile-wrap" style="display: inline-block;">
              <img class="member-profile rounded-circle" src="../images/profile_sample.jfif" alt="프로필아이콘">
              <p class="m-0">아이디</p>
            </div>
            <div class="row shadow-sm d-flex justify-content-between learning-note">
              <div class="p-4 d-flex flex-column text-center">
                <h5 class="main-font-color font-border">카테고리</h5>
                <h6>과학</h6>
              </div>
              <div class="p-4 d-flex flex-row position-static text-center">
                <h5 class="flex-fill pt-3 font-border">생명과학 용어 정리</h5>
              </div>
              <div class="p-2 d-flex flex-row position-static">
                <i class="far fa-thumbs-up learning-note-icon mt-auto">378</i>
              </div>
            </div>
          </div>
        </div>
        <!-- 학습노트 끝 -->
        <!-- 온스터디 -->
        <div class="col-md-12">
          <div class="jumbotron border pb-3">
            <div class="text-center mb-5" id="onStudyIntro">
              <h3>Hot On Study!</h3>
              <p>참가비가 제일 많이 모인 온 스터디를 확인하세요!</p>
            </div>
            
            <div class="row">
            <%for(Onstudy onstudy : pList) { %>
              <div class="col-md-4">
                <div class="card mb-4 shadow-sm">
         <img class="mb-3" alt="온스타일 이미지" src="<%if(onstudy.getThumbnail() != null) { %><%=request.getContextPath()%>/resources/onstudyThumbnails/<%=onstudy.getThumbnail()%> <%} else { %><%=request.getContextPath()%>/resources/onstudyThumbnails/noimage.png"<%}%>>

                  <div class="card-body">
                    <p class="card-title"><%=onstudy.getOnstudyTitle() %></p>
                    <p class="card-text">
                      - 마감날짜 : <%=onstudy.getOnstudyDeadlineDt() %>(D-<%=onstudy.getOnstudyDday() %>)<br>
                      - 인증빈도 : 주 <%=onstudy.getOnstudyCertifyCount() %>회<br>
                      - 참여자 수 : <%=onstudy.getMemberCount() %>명<br>
                      - 모인금액 : <%=onstudy.getSumFee() %>원
                    </p>
                    <div class="d-flex justify-content-between align-items-center ">
                      <div class="btn-group">
                        <a class="btn btn-sm form-control orange-hover-btn" href="../onstudy/detail?no=<%=onstudy.getOnstudyNo() %>">자세히</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
	            <%} %>
          </div>
        </div>
        <!-- 온스터디 끝 -->
      </div>
    </div>
  </div>
  </div>
  <!-- content end -->
	<%@ include file="../common/footer.jsp"%>
  
  
  
  <div id="button-top">
    <button type="button" class="top-btn">TOP</button>
  </div>

</body>

</html>