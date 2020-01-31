<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.onstudy.member.model.vo.PageInfo, java.util.List, com.onstudy.member.model.vo.Member"%>
<%
	PageInfo pInf = (PageInfo)request.getAttribute("pInf");
	List<Member> mList = (List<Member>)request.getAttribute("mList");
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
	<%@ include file="sideBar.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/adminPage-member-List.css">
<title>온스터디</title>
</head>

<body>

	<div id="container">
		<div class="container">

			<div class="row">
				<div class="col-md-12">
					<h2 class="content-title">회원 목록 조회</h2>
					<div class="board-content">
						<form action="<%= request.getContextPath() %>/admin/memberList"
							 method="get" class="board-form">

							<!-- 카테고리, 검색input, 버튼 -->
							<div id="search-wrap">
								<button type="submit" class="btn form-control orange-hover-btn"
									id="searchBtn" type="submit">검색</button>
								<input type="text" class="form-control input-comment" name="content"
									placeholder="검색어를 입력해 주세요" id="searchBox">
								<select	class="form-control" id="selectOption" name="condition">
									<option value="회원번호">회원번호</option>
									<option value="아이디">아이디</option>
									<option value="이름">이름</option>
									<option value="전화번호">전화번호</option>
									<option value="포인트">포인트</option>
									<option value="신고회수">신고회수</option>
									<option value="정지여부">정지여부</option>
								</select>
							</div>
							<!-- 카테고리, 검색input, 버튼 -->

							<!-- 테이블 -->
							<div class="row">
								<div class="col-md-12">

									<table class="table table-bordered table-striped"
										id="simulate_log" style="padding: 0px 0px" width="100%">

										<thead>
											<tr>
												<th scope="col" data-sortable="true">회원번호</th>
												<th scope="col">아이디</th>
												<th scope="col">이름</th>
												<th scope="col">전화번호</th>
												<th scope="col">포인트</th>
												<th scope="col">신고회수</th>
												<th scope="col">정지여부</th>
											</tr>
										</thead>
										<tbody>
											<% if(mList.isEmpty()){ %>
											<tr>
												<td colspan="7">존재하는 게시글이 없습니다.</td>
											</tr>
											<% }else{ %>
											<% for(Member member : mList){ %>
											<tr class="tableContent">
												<td><%= member.getMemberNo() %></td>
												<td><%= member.getMemberId() %></td>
												<td><%= member.getMemberNm() %></td>
												<td><%= member.getMemberPhone() %></td>
												<td><%= member.getMemberPoint() %></td>
												<td><%= member.getMemberDeclarCount() %></td>
												<td><%= member.getMemberStatus() %></td>
											</tr>
											<% } } %>
										</tbody>
									</table>
								</div>
							</div>
							<!-- 테이블 -->

							<!-- 페이징바 -->
							<div style="clear: both;">
								<ul class="pagination">
									<% if(currentPage > 1) { %>
									<li class="page-item">
										<!-- 맨 처음으로(<<) -->
										<a class="page-link page-first"
											href="<%= request.getContextPath() %>/admin/memberList?currentPage=1&condition=<%=condition%>&content=<%=content%>">
											&lt;&lt;</a>
									</li>

									<li class="page-item">
										<!-- 이전으로(<) -->
										<a class="page-link page-pre"
											href="<%= request.getContextPath() %>/admin/memberList?currentPage=<%= currentPage-1 %>&condition=<%=condition%>&content=<%=content%>">
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
											href="<%= request.getContextPath() %>/admin/memberList?currentPage=<%= p %>&condition=<%=condition%>&content=<%=content%>">
											<%= p %></a>
									</li>
									<% } %>
									<%} %>

									<!-- 다음 페이지로(>) -->
									<% if(currentPage < maxPage){ %>
									<li class="page-item"><a class="page-link page-next"
										href="<%= request.getContextPath() %>/admin/memberList?currentPage=<%= currentPage+1 %>&condition=<%=condition%>&content=<%=content%>">
											&gt;</a></li>

									<!-- 맨 끝으로(>>) -->
									<li class="page-item"><a class="page-link page-end"
										href="<%= request.getContextPath() %>/admin/memberList?currentPage=<%= maxPage %>&condition=<%=condition%>&content=<%=content%>">
											&gt;&gt;</a></li>
									<% }%>

								</ul>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 테이블 sorting  ( datatable 기능 ) -->
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
				var memberNo = $(this).parent().children().eq(0).text();
				// 쿼리스트링을 이용하여 get 방식으로 글 번호를 server로 전달
				location.href="<%= request.getContextPath() %>/admin/memberDetail?memberNo=" + memberNo;
			
			}).mouseenter(function(){
				$(this).parent().css("cursor", "pointer");
			
			});
			
			
		});
	</script>

</body>

</html>