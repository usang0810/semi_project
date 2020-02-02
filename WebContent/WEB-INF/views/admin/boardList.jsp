<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="com.semi.board.model.vo.Board, java.util.List, com.semi.member.model.vo.PageInfo"%>
<%
	List<Board> bList = (List<Board>)request.getAttribute("bList");
	PageInfo pInf = (PageInfo)request.getAttribute("pInf");
	String boardType = (String)request.getAttribute("boardType");
	
	int listCount = pInf.getListCount();
	int currentPage = pInf.getCurrentPage();
	int maxPage = pInf.getMaxPage();
	int startPage = pInf.getStartPage();
	int endPage = pInf.getEndPage();
	
	// 검색용 
	String searchKey = request.getParameter("searchKey");
	String searchValue = request.getParameter("searchValue");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="../css/adminPage-list.css">
<%@ include file="sideBar.jsp"%>
<title>온 스터디</title>
</head>
<body>

	<div id="container">
    <div class="container">

      <div class="row">

        <div class="col-md-12">
          <h2 class="content-title">
          	<%if(boardType.equals("F")){ %>
          	<span>자유 게시판</span>
          	<%}else if(boardType.equals("S")){ %>
          	<span>건의 게시판</span>
          	<%}else if(boardType.equals("D")){ %>
          	<span>신고 게시판</span>
          	<%}else{ %>
          	<span>잘못된 접근입니다.</span>
          	<%} %>
          </h2>
          <div class="board-content">
            <form action="boardList" method="get" class="board-form">

              <!-- 카테고리, 검색input, 버튼 -->
              <div id="search-wrap">
                <button type="submit" class="btn form-control orange-hover-btn" id="searchBtn">검색</button>
                <input type="hidden" name="boardType" value="<%=boardType %>">
                <input type="text" class="form-control input-comment" placeholder="검색어를 입력해 주세요" id="searchBox" name="searchValue">
                <select class="form-control" id="selectOption" name="searchKey">
					<option value="게시글번호">게시글번호</option>
					<option value="제목">제목</option>
					<option value="작성자">작성자</option>
					<option value="작성일">작성일</option>
					<option value="삭제여부">삭제여부</option>
					<option value="내용">내용</option>
					<%if(boardType.equals("D")){ %>
					<option value="신고처리상태">신고처리상태</option>
					<%} %>
                </select>
              </div>
              <!-- 카테고리, 검색input, 버튼 -->

              <!-- 테이블 -->
              <div class="row">
                <div class="col-md-12">
                  <table class="table  container table-striped" id="simulate_log" cellspacing="0" style="padding : 0px 0px" width="100%">
                    <thead>
                      <tr>
                        <th scope="col">게시글 번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">작성일</th>
                        <th scope="col">삭제여부</th>
                        <%if(boardType.equals("D")){ %>
						<th scope="col">신고처리상태</th>
						<%} %>
                      </tr>
                    </thead>
                    <tbody>
                      <% if(bList.isEmpty()){ %>
						<tr>
							<td colspan="5">존재하는 게시글이 없습니다.</td>
						</tr>
					  <% }else{ %>
					  <% for(Board board : bList){ %>
						<tr class="tableContent">
							<td><%= board.getBoardNo() %></td>
							<td><%= board.getBoardTitle() %></td>
							<td><%= board.getBoardWriter() %></td>
							<td><%= board.getBoardModifyDt() %></td>
							<td><%= board.getBoardStatus() %></td>
							<%if(boardType.equals("D")){ %>
							<td><%= board.getDeclarStatus()%></td>
							<%} %>
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
							href="<%= request.getContextPath() %>/admin/boardList?boardType=<%=boardType %>&currentPage=1&searchKey=<%=searchKey%>&searchValue=<%=searchValue%>">
							&lt;&lt;</a>
					</li>

					<li class="page-item">
						<!-- 이전으로(<) -->
						<a class="page-link page-pre"
							href="<%= request.getContextPath() %>/admin/boardList?boardType=<%=boardType %>&currentPage=<%= currentPage-1 %>&searchKey=<%=searchKey%>&searchValue=<%=searchValue%>">
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
							href="<%= request.getContextPath() %>/admin/boardList?boardType=<%=boardType %>&currentPage=<%= p %>&searchKey=<%=searchKey%>&searchValue=<%=searchValue%>">
							<%= p %></a>
					</li>
					<% } %>
					<%} %>

					<!-- 다음 페이지로(>) -->
					<% if(currentPage < maxPage){ %>
					<li class="page-item"><a class="page-link page-next"
						href="<%= request.getContextPath() %>/admin/boardList?boardType=<%=boardType %>&currentPage=<%= currentPage+1 %>&searchKey=<%=searchKey%>&searchValue=<%=searchValue%>">
							&gt;</a></li>

					<!-- 맨 끝으로(>>) -->
					<li class="page-item"><a class="page-link page-end"
						href="<%= request.getContextPath() %>/admin/boardList?boardType=<%=boardType %>&currentPage=<%= maxPage %>&searchKey=<%=searchKey%>&searchValue=<%=searchValue%>">
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
  
  <script>
  	$(function(){
  		var searchKey = "<%= searchKey %>";
		var searchValue = "<%= searchValue %>";
		
		if(searchValue != "null" && searchKey != "null"){
			$.each($("select[name=searchKey] > option"), function(index, item){
				if($(item).val() == searchKey){
					$(item).prop("selected","true");
				} 
			});
			
			$("input[name=searchValue]").val(searchValue);
		}
		
		$("#simulate_log td").click(function(){
			var boardNo = $(this).parent().children().eq(0).text();
			// 쿼리스트링을 이용하여 get 방식으로 글 번호를 server로 전달
			location.href="<%= request.getContextPath() %>/admin/boardDetail?boardNo=" + boardNo;
		
		}).mouseenter(function(){
			$(this).parent().css("cursor", "pointer");
		
		});
  	});
  </script>

</body>
</html>