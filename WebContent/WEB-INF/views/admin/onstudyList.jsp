<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.member.model.vo.PageInfo, java.util.List"%>
<%@page import="com.semi.onstudy.model.vo.Onstudy"%>
<%
	PageInfo pInf = (PageInfo)request.getAttribute("pInf");
	List<Onstudy> oList = (List<Onstudy>)request.getAttribute("oList");
	String condition = request.getParameter("condition");
	String content = request.getParameter("content");
	
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
  <title>온스터디</title>
  <%@ include file="sideBar.jsp"%>
  <link rel="stylesheet" href="../css/adminPage-list.css">
</head>

<body>
  
  <!-- 카테고리, 검색input, 버튼 -->
  <div id="container">
    <div class="container">

      <div class="row">
        <div class="col-md-12">
          <h2 class="content-title">온스터디 목록 조회</h2>
          <div class="board-content">
            <form action="<%= request.getContextPath() %>/admin/onstudyList" method="get" class="board-form">

              <!-- 카테고리, 검색input, 버튼 -->
              <div id="search-wrap">
                <button type="submit" class="btn form-control orange-hover-btn" id="searchBtn">검색</button>
                <input type="text" class="form-control input-comment"
                	 placeholder="검색어를 입력해 주세요" id="searchBox" name="content">
                <select class="form-control" id="selectOption" name="condition">
                  <option value="온스터디번호">온스터디번호</option>
                  <option value="온스터디명">온스터디명</option>
                  <option value="카테고리">카테고리</option>
                  <option value="참여인원">참여인원</option>
                  <option value="시작일">시작일</option>
                  <option value="종료일">종료일</option>
                  <option value="참가비">참가비</option>
                  <option value="삭제여부">삭제여부</option>
                </select>
              </div>
              <!-- 카테고리, 검색input, 버튼 -->

              <div class="row">
                <div class="col-md-12">
                  <table class="table table-bordered table-striped " id="simulate_log" cellspacing="0" width="100%"
                    style="padding : 0px 0px">
                    <thead>
                      <tr>
                        <th scope="col">온스터디 번호</th>
                        <th scope="col">온스터디명</th>
                        <th scope="col">카테고리</th>
                        <th scope="col">참여인원</th>
                        <th scope="col">시작일</th>
                        <th scope="col">종료일</th>
                        <th scope="col">참가비</th>
                        <th scope="col">삭제여부</th>
                      </tr>
                    </thead>
                    <tbody>
                      <% if(oList.isEmpty()){ %>
						<tr>
							<td colspan="8">존재하는 게시글이 없습니다.</td>
						</tr>
					  <% }else{ %>
					  <% for(Onstudy onstudy : oList){ %>
						<tr class="tableContent">
							<td><%= onstudy.getOnstudyNo() %></td>
							<td><%= onstudy.getOnstudyTitle() %></td>
							<td><%= onstudy.getCategoryNm() %></td>
							<td><%= onstudy.getPartiMembers() %></td>
							<td><%= onstudy.getOnstudyStartDt() %></td>
							<td><%= onstudy.getOnstudyEndDt() %></td>
							<td><%= onstudy.getOnstudyFee() %></td>
							<td><%= onstudy.getOnstudyStatus() %></td>
						</tr>
					  <% } } %>
                    </tbody>
                  </table>
                </div>
              </div>

				<!-- 페이징바 -->
				<div style="clear: both;">
					<ul class="pagination">
						<% if(currentPage > 1) { %>
						<li class="page-item">
							<!-- 맨 처음으로(<<) -->
							<a class="page-link page-first"
								href="<%= request.getContextPath() %>/admin/onstudyList?currentPage=1&condition=<%=condition%>&content=<%=content%>">
								&lt;&lt;</a>
						</li>
	
						<li class="page-item">
							<!-- 이전으로(<) -->
							<a class="page-link page-pre"
								href="<%= request.getContextPath() %>/admin/onstudyList?currentPage=<%= currentPage-1 %>&condition=<%=condition%>&content=<%=content%>">
								&lt;</a>
						</li>
						<% } %>
	
						<!-- 10개의 페이지 목록 -->
						<% for(int p = startPage; p <= endPage; p++){ %>
						<% if(p == currentPage) { %>
						<li class="page-item"><a class="page-link page-now"><%= p %></a>
						</li>
						<% } else{ %>
						<li class="page-item">
							<a class="page-link page-other"
								href="<%= request.getContextPath() %>/admin/onstudyList?currentPage=<%= p %>&condition=<%=condition%>&content=<%=content%>">
								<%= p %></a>
						</li>
						<% } %>
						<%} %>
	
						<!-- 다음 페이지로(>) -->
						<% if(currentPage < maxPage){ %>
						<li class="page-item"><a class="page-link page-next"
							href="<%= request.getContextPath() %>/admin/onstudyList?currentPage=<%= currentPage+1 %>&condition=<%=condition%>&content=<%=content%>">
								&gt;</a></li>
	
						<!-- 맨 끝으로(>>) -->
						<li class="page-item"><a class="page-link page-end"
							href="<%= request.getContextPath() %>/admin/onstudyList?currentPage=<%= maxPage %>&condition=<%=condition%>&content=<%=content%>">
								&gt;&gt;</a></li>
						<% }%>
					</ul>
				</div>
              <!-- 테이블 페이지 -->
            </form>
          </div>
        </div>
        <!-- 테이블 -->


      </div>
    </div>
  </div>

  <script>
	$(document).ready(function() {
		var condition = "<%= condition %>";
		var content = "<%= content %>";
		
		if(content != "null" && condition != "null"){
			$.each($("select[name=condition] > option"), function(index, item){
				if($(item).val() == condition){
					$(item).prop("selected","true");
				} 
			});
			
			$("input[name=content]").val(content);
		}
		
		$("#simulate_log td").click(function(){
			var onstudyNo = $(this).parent().children().eq(0).text();
			// 쿼리스트링을 이용하여 get 방식으로 글 번호를 server로 전달
			location.href="<%= request.getContextPath() %>/admin/onstudyDetail?onstudyNo=" + onstudyNo;
		
		}).mouseenter(function(){
			$(this).parent().css("cursor", "pointer");
		
		});
		
		$("#searchBox").on("keyup", function(){
			if($("#selectOption option:selected").val() == "온스터디번호" ||
				$("#selectOption option:selected").val() == "참여인원" ||
				$("#selectOption option:selected").val() == "참가비"){
				 $("#searchBox").val($(this).val().replace(/[^0-9]/g,""));				
			}
		});
		
	});
  </script>

</body>

</html>