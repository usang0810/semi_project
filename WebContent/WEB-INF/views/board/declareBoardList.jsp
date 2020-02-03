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
	if(boardType.equals("SD")){
		status = "SD";
	}else if(boardType.equals("SDSEARCH")){
		status = "SDSEARCH";
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
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardList.css">
<title>온스터디</title>
</head>
<body>
<%@ include file="../common/loginedHeader.jsp" %>
	     <div id="container">
          <div class="container">
            <div class="row">
              <div id="board-wrap" class="col-md-12">
                <h2 class="content-title">건의/신고 게시판</h2>
                <div class="board-content">
                  <form action="<%= request.getContextPath() %>/board/declareBoardList?boardType=SDSEARCH" method="post" class="board-form" onsubmit="return checkSearchVal();">
                    <div id="search-wrap">
                      <button type="submit" class="find-btn form-control orange-btn-style orange-hover-btn">검색</button>
                      <input type="text" id="searchValue" class="form-control input-content input-comment" placeholder="내용을 검색해주세요." name="searchValue">
                      <select class="form-control input-comment" name="searchKey" id="searchKey">
                        <option value="title">제목</option>
                        <option value="writer">작성자</option>
                        <option value="content">내용</option>
                      </select>
                    </div>
                      <div class="col-md-12">
                        <div class="row">
                          <table class="board declare-board">
                            <thead>
                              <tr>
                                <th style="width:10%;">No</th>
                                <th style="width:8%;">분류</th>
                                <th style="width:47%;">제목</th>
                                <th style="width:20%;">작성자</th>
                                <th style="width:15%;">작성일</th>
                              </tr>
                            </thead>
                            <tbody>
                              <% if(bList.isEmpty()){ %>        
	                              <tr class="no-list-tr">
	                              	<td colspan="6" class="nolist-warning">존재하는 게시글이 없습니다.</td>
	                              </tr>
	                              <% }else{ %>
	                              	<% for(Board board : bList){%>
	                              		<tr>
	                              			<td class="no-has-list"><%= board.getBoardNo()%></td>
	                              			<td class="has-list"><%= board.getBoardNumbering()%></td>
	                              			<td class="has-list"><%= board.getBoardType()%></td>
	                              			<% if(board.getSecretStatus()=='Y'){ %>
	                              				<% if(loginMember!=null && (loginMember.getMemberId().equals(board.getBoardWriter()) || loginMember.getMemberId().equals("admin"))){ %>
	                              					<td class="has-list"><%= board.getBoardTitle()%></td>
	                              				<% }else{ %>
			                              			<td class="has-list secret-list">비밀글입니다</td>
	                              				<% }%>
	                              			<% } else { %>
	                              					<td class="has-list"><%= board.getBoardTitle()%></td>
	                              			<% } %>
	                              			<td class="has-list"><%= board.getBoardWriter()%></td>
	                              			<td class="has-list"><%= board.getBoardModifyDt()%></td>
	                              			
	                              	<% } %>
	                              <% } %>
                            </tbody>
                          </table>
                          <a href="<%= request.getContextPath() %>/board/goInsertDeclareBoard" class="write-content-btn form-control orange-hover-btn orange-btn-style">글쓰기</a>
                        </div>
                      </div>
                      <ul class="pagination">
	                      	<% if(currentPage>1){%>
	                        <li class="page-item">
	                          <a class="page-link" href="<%= request.getContextPath() %>/board/declareBoardList?boardType=<%= status %>&currentPage=1&searchKey=<%= searchKey %>&searchValue=<%= searchValue %>">&lt;&lt;</a>
	                        </li>
	                        <li class="page-item">
	                          <a class="page-link" href="<%= request.getContextPath() %>/board/declareBoardList?boardType=<%= status %>&currentPage=<%= currentPage-1 %>&searchKey=<%= searchKey %>&searchValue=<%= searchValue %>">&lt;</a>
	                        </li>
	                        <% } %>
	                        
	                        <% for(int p = startPage; p <= endPage; p++){ %>
	                        	<% if(p == currentPage) { %>
			                        <li class="page-item active">
			                          <a class="page-link"><%= p %></a>
			                        </li>
			                    <% }else{%>
			                    	<li class="page-item">
			                          <a class="page-link" href="<%= request.getContextPath() %>/board/declareBoardList?boardType=<%= status %>&currentPage=<%= p %>&searchKey=<%= searchKey %>&searchValue=<%= searchValue %>"><%= p %></a>
			                        </li>
	                        	<% }%>
                        	<% }%>
                        	
	                        <% if(currentPage<maxPage){%>
	                        <li class="page-item">
	                          <a class="page-link" href="<%= request.getContextPath() %>/board/declareBoardList?boardType=<%= status %>&currentPage=<%= currentPage+1 %>&searchKey=<%= searchKey %>&searchValue=<%= searchValue %>">&gt;</a>
	                        </li>
	                        <li class="page-item">
	                          <a class="page-link" href="<%= request.getContextPath() %>/board/declareBoardList?boardType=<%= status %>&currentPage=<%= maxPage %>&searchKey=<%= searchKey %>&searchValue=<%= searchValue %>">&gt;&gt;</a>
	                        </li>
	                        <% } %>
	                      </ul>
                    </form>
                </div>
              </div>
            </div>
          </div>
        </div>
	<%@ include file="../common/footer.jsp"%>
	<script>
      	$(function(){
      		/* 게시글 상세 조회용  */
      		$(".declare-board .has-list").on({
      			click : function(){
      				var boardNo = $(this).parent().children().eq(0).text();
      				var boardNumbering = $(this).parent().children().eq(1).text();
      				if($(this).parent().children().eq(3).hasClass("secret-list")){
      					alert("비밀글입니다.");
      					return false;
      				}else{
	      				location.href="<%= request.getContextPath() %>/board/declareBoardDetail?no="+boardNo +"&Numbering="+boardNumbering+"&currentPage="+<%=currentPage%>;
      				}
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
    			location.href="declareBoardList?boardType=SD";
        		return false;
    		}
			return true;	        		
    	}
      </script>     
</body>
</html>