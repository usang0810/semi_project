<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.semi.onstudy.model.vo.Onstudy"%>
<%
	List<Onstudy> mainList = (List<Onstudy>)request.getAttribute("mainList");
	List<String> cList = (List<String>)request.getAttribute("cList");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>온 스터디</title>
</head>

<body>

	<%@ include file="WEB-INF/views/common/header.jsp" %>
    <!-- content -->
    <!-- intro -->
    <div class="position-relative overflow-hidden p-3 p-md-5 text-center" id="intro">
        <div class="col-md-10 p-lg-5 centered">
            <h1 class="display-4 font-weight-normal">On Study에 오신것을 환영합니다!</h1>
            <p class="lead font-weight-normal my-0">On Study는 특정 주제에 대해 학습자들끼리 모여 학습하는 문화를 활발하게 해줍니다.</p>
            <p class="lead font-weight-normal my-0">개인 학습자료, 노하우 등을 스터디 그룹을 연계 할 수 있는 서비스를 제공합니다.</p>
            <p class="lead font-weight-normal my-0">자신만의 학습노트를 만들고 공유하세요! On Study의 모든 학습노트는 오픈되어 있습니다.</p>
            <p class="lead font-weight-normal">학습노트를 기반으로 한 문제를 풀어보세요!
                단순한 암기가 잘 안되신다면 다양한 학습방법을 통해 학습하세요.</p>
        </div>
    </div>
    <!-- learning-note -->
    <div class="position-relative overflow-hidden p-3 p-md-5 text-center" id="learning-note">
        <div class="col-md-8 p-lg-5 mx-auto my-5">
            <h1 class="display-4 font-weight-normal">학습노트를 이용해 보세요!</h1>
            <p class="lead font-weight-normal">인기가 많은 학습노트를 확인해 보세요.</p>
            <p class="lead font-weight-normal">마음에 드는 학습노트가 없다면 검색해보세요. 온 스터디는 다양한 학습노트를 제공하고 있습니다.</p>
            <div class=" col-md-8 input-group mx-auto">
                <div class="input-group-prepend">
                    <select class="form-control" id="search" name="search">
                        <option selected>전체</option>
                        <option>카테고리</option>
                        <option>제목</option>
                        <option>작성자</option>
                    </select>
                </div>
                <input type="text" class="form-control" placeholder="Search">
                <div class="input-group-append">
                    <button class="btn form-control orange-hover-btn" type="submit">검색</button>
                </div>
            </div>
        </div>
        <!-- learning-note-list -->
        <div class="contaner text-center" id="ln-list">
            <div class="col-md-6 learning-note px-0 mx-auto">
                <div
                    class="row no-gutters border overflow-hidden flex-md-row mb-3 shadow-sm h-md-250 d-flex justify-content-between">
                    <div class="p-4 d-flex flex-column text-center">
                        <h4 class="main-font-color font-border">카테고리</h4>
                            <h5>컴퓨터</h5>
                    </div>
                    <div class="p-4 d-flex flex-row position-static text-center">
                        <h3 class="flex-fill pt-3 font-border">자바 용어 모음</h3>
                    </div>
                    <div class="p-2 d-flex flex-row position-static">
                        <i class="far fa-thumbs-up learning-note-icon mt-auto">1,024</i>
                        <div class="ml-auto my-auto">
                            <img src="images/tower1.PNG" alt="..." id="learning-note-profile-img"
                                class="rounded-circle">
                            <h6>홍길동</h6>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 learning-note px-0 mx-auto">
                <div
                    class="row no-gutters border overflow-hidden flex-md-row mb-3 shadow-sm h-md-250 d-flex justify-content-between">
                    <div class="p-4 d-flex flex-column text-center">
                        <h4 class="main-font-color font-border">카테고리</h5>
                            <h5>컴퓨터</h5>
                    </div>
                    <div class="p-4 d-flex flex-row position-static text-center">
                        <h3 class="flex-fill pt-3 font-border">C언어 포인터 용어 정리</h3>
                    </div>
                    <div class="p-2 d-flex flex-row position-static">
                        <i class="far fa-thumbs-up learning-note-icon mt-auto">956</i>
                        <div class="ml-auto my-auto">
                            <img src="images/flower2.PNG" alt="..." id="learning-note-profile-img"
                                class="rounded-circle">
                            <h6>김유신</h6>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 learning-note px-0 mx-auto">
                <div
                    class="row no-gutters border overflow-hidden flex-md-row mb-3 shadow-sm h-md-250 d-flex justify-content-between">
                    <div class="p-4 d-flex flex-column text-center">
                        <h4 class="main-font-color font-border">카테고리</h4>
                            <h5>외국어</h5>
                    </div>
                    <div class="p-4 d-flex flex-row position-static text-center">
                        <h3 class="flex-fill pt-3 font-border">토익 2019년도 기출문제 정리</h3>
                    </div>
                    <div class="p-2 d-flex flex-row position-static">
                        <i class="far fa-thumbs-up learning-note-icon mt-auto">1,300</i>
                        <div class="ml-auto my-auto">
                            <img src="images/river1.PNG" alt="..." id="learning-note-profile-img"
                                class="rounded-circle">
                            <h6>드링크</h6>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 learning-note px-0 mx-auto">
                <div
                    class="row no-gutters border overflow-hidden flex-md-row mb-3 shadow-sm h-md-250 d-flex justify-content-between">
                    <div class="p-4 d-flex flex-column text-center">
                        <h4 class="main-font-color font-border">카테고리</h5>
                            <h5>자동차</h5>
                    </div>
                    <div class="p-4 d-flex flex-row position-static text-center">
                        <h3 class="flex-fill pt-3 font-border">자동차 부품 용어 정리</h3>
                    </div>
                    <div class="p-2 d-flex flex-row position-static">
                        <i class="far fa-thumbs-up learning-note-icon mt-auto">4,128</i>
                        <div class="ml-auto my-auto">
                            <img src="images/forest1.PNG" alt="..." id="learning-note-profile-img"
                                class="rounded-circle">
                            <h6>차박사</h6>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 learning-note px-0 mx-auto">
                <div
                    class="row no-gutters border overflow-hidden flex-md-row mb-3 shadow-sm h-md-250 d-flex justify-content-between">
                    <div class="p-4 d-flex flex-column text-center">
                        <h4 class="main-font-color font-border">카테고리</h5>
                            <h5>과학</h5>
                    </div>
                    <div class="p-4 d-flex flex-row position-static text-center">
                        <h3 class="flex-fill pt-3 font-border">생명과학 용어 정리</h3>
                    </div>
                    <div class="p-2 d-flex flex-row position-static">
                        <i class="far fa-thumbs-up learning-note-icon mt-auto">378</i>
                        <div class="ml-auto my-auto">
                            <img src="images/tower1.PNG" alt="..." id="learning-note-profile-img"
                                class="rounded-circle">
                            <h6>메딕</h6>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- on study -->
    <div class="position-relative overflow-hidden p-3 p-md-5" id="on-study" style="background-color: lightgray;">
        <div class="col-md-10 p-lg-5 mx-auto mt-5 text-center">
            <h1 class="display-4 font-weight-normal">온 스터디를 이용해 보세요!</h1>
            <p class="lead font-weight-normal">의지가 부족하신가요? 여럿이서 같이 공부해보면 어떨까요?<br>
                열심히 한다면 보상까지 얻을 수 있는 온스터디를 해보세요!</p>
            <p class="lead font-weight-normal">인기가 많은 온 스터디를 확인해 보세요.</p>
        </div>
        <!-- on study list -->
        <div class="album pb-5 ">
			<div class="container">
				<div class="row">
					<%
						for (Onstudy onstudy : mainList) {
					%>


					<div class="col-md-4">
						<div class="card mb-4 shadow-sm">
							<img style="height:200px"
								src="<%= onstudy.getThumbnail() != null ? request.getContextPath() + "/resources/onstudyThumbnails/" + onstudy.getThumbnail() : request.getContextPath() + "/resources/onstudyThumbnails/noimage.png" %>">
							<div class="card-body">
								<p class="card-title"><%=onstudy.getOnstudyTitle()%></p>
								<p class="card-text">
									- 마감날짜 :
									<%=onstudy.getOnstudyDeadlineDt()%>(D-<%=onstudy.getOnstudyDday()%>)<br>

									- 인증빈도 : 주
									<%=onstudy.getOnstudyCertifyCount()%>회<br> - 참여자 수 :
									<%=onstudy.getMemberCount()%>명
								</p>
								<div class="d-flex justify-content-between align-items-center ">
									<div class="btn-group">
										<a class="btn btn-sm form-control orange-hover-btn"
											id="detail-btn">자세히</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<%
						}
					%>

				</div>
			</div>
		</div>

        <!-- 온스터디 카테고리 목록 -->
        <div class="category-list-wrap container mb-5">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="recommend-title">온스터디 카테고리</h2>
                    <p class="recommend-sub-title">나에게 맞는 카테고리를 찾아보세요.</p>
                    <ul class="category-list list-1">
    		 	         <% if(cList == null) { %>
	                   		 <%for (int i=0; i < 6; i++) { %>
	                        <li><a>카테고리 불러오기 실패</a></li>
	                        <%}%>
	                        </ul>
	                        <ul class="category-list">
	                        <%for(int i=0; i < 6; i++) {%>
	                        <li><a>카테고리 불러오기 실패</a></li>
	                        <%} %>
                        <% } else { %>
	                        <%for(int i=0; i < 6; i++) { %>
	                        <li><a><%=cList.get(i) %></a></li>
	                        <%} %>
	                        </ul>
	                        <ul class="category-list">
	                        <%for(int i=6; i<16; i++) { %>
	                        <li><a><%=cList.get(i) %></a></li>
	                        <%} %>
                       <%} %>
                     </ul>
                </div>
            </div>
        </div>
    </div>

	<!-- footer -->
	<%@ include file="WEB-INF/views/common/footer.jsp"%>

</body>

</html>