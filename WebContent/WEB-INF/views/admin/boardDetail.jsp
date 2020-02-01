<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, com.onstudy.board.model.vo.Board, com.onstudy.board.model.vo.BoardImage"%>
<% 
	Board board = (Board)request.getAttribute("board");
	String declarId = (String)request.getAttribute("declarId");
	ArrayList<BoardImage> files = (ArrayList<BoardImage>)request.getAttribute("files");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/adminPage-boardDetail.css">
<style>

</style>
<title>온스터디</title>
</head>

<body>
	<%@ include file="../admin/sideBar.jsp" %>
 		<div id="container">
          <div class="container">
            <div class="row">
              <div id="board-content-wrap" class="col-md-12">
              	<h2 class="content-title">
 		          	<%if(board.getBoardType().equals("F")){ %>
		          	<span>자유 게시판</span>
		          	<%}else if(board.getBoardType().equals("S")){ %>
		          	<span>건의 게시판</span>
		          	<%}else if(board.getBoardType().equals("D")){ %>
		          	<span>신고 게시판</span>
		          	<%}else{ %>
		          	<span>잘못된 접근입니다.</span>
		          	<%} %>
              	</h2>
                <div class="board-content">
                  <form class="board-form" action="#" method="post">
                    <div class="content-wrap">
                      <p class="board-content-title"><span class="numbering">게시판 번호. <%= board.getBoardNo() %></span><%= board.getBoardTitle() %></p>
                      <p class="writer-date">
                        <span class="writer">작성자 : <%= board.getBoardWriter() %></span>
                        <span class="date">작성일 : <%= board.getBoardModifyDt() %></span>
                      </p>
                      <p class="content">
                      	<%= board.getBoardContent() %>
                      </p>
                      <% if(files != null){ %>
                      <div class="board-image-wrap">
                      	<% for(int i=0; i<files.size() ; i++) {
                      		String src = request.getContextPath()+"/resources/uploadImages/"+files.get(i).getImageChangeName();
                      	%>
                      	<img class="uploaded-img" src="<%= src %>" />
                      	<input type="hidden" value=<%=files.get(i).getImageNo() %>>
                      	<% } %>
                      </div>
                      <% } %>
                      <%if(board.getBoardType().equals("D")){ %>
                      <span class="writer"><strong>신고 대상자 : <%= declarId %></strong></span>
                      <%} %>
                    </div>
                    <div class="comment-wrap">
                      <p class="comment-title">댓글</p>	
                      <ul id="replyListArea">
	                    <li class="reply-row" id="1"> 
	                   		<span class="rWriter">작성자</span> 
	                   		<span class="rDate">2020.01.23</span>
	                   		<p class="rContent">댓글 내용</p>
	                    </li>
					  </ul>                      
                      <div class="your-comment-wrap">
                      	<p class="my-id"><%=admin.getMemberId() %></p>
                      	<textArea class="input-comment form-control" name="your-comment" rows="2" id="commentContent" placeholder="댓글 내용을 작성해주세요." style="resize:none"></textArea>
                        <button id="addComment" type="button" class="form-control submit-btn orange-hover-btn">작성하기</button>
                      </div>
                    </div>
                    <div class="bottom-btn-wrap">
                    	<%if(board.getBoardStatus() == 'Y'){ %>
		                   <a href="changeBoardStatus?boardNo=<%=board.getBoardNo() %>&status=<%=board.getBoardStatus() %>"
		                   		 id="board-delete-btn" class="form-control orange-hover-btn go-list-btn">게시판 삭제</a>                	
                    	<%}else{ %>
		                   <a href="changeBoardStatus?boardNo=<%=board.getBoardNo() %>&status=<%=board.getBoardStatus() %>"
		                   		 id="board-re-btn" class="form-control orange-hover-btn go-list-btn">게시판 복구</a>                	
                    	<%} %>
                    	
                    	<%if(board.getBoardType().equals("D")){ %>
                     		<%if(board.getDeclarStatus().equals("N")){ %>
                    		<button type="button" id="board-no-declar-btn" class="form-control orange-hover-btn go-list-btn" value="N">신고무효</button>  
                    		<button type="button" id="board-declar-btn" class="form-control orange-hover-btn go-list-btn" value="Y">신고처리</button>
                    		<%} %>
                    	<%} %>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
    </div>
	<script>
		$(function(){
			$(".bottom-btn-wrap button").on("click", function(){
				var status = $(this).val();
				
				location.href="declar?boardNo=<%=board.getBoardNo()%>&declarId=<%=declarId %>&status=" + status;
			});
		});

		
		<%-- // 댓글 출력 함수
		function selectRlist(){
			var boardNo = <%= board.getBoardNo() %>;
			
			$.ajax({
				url : "<%=request.getContextPath()%>/board/selectReplyList",
				type : "post",
				dataType : "json",
				data : {boardNo : boardNo},
				success : function(rList){
					
					var $replyListArea = $("#replyListArea");
					
					$replyListArea.html(""); // 기존 내용 삭제
					
					$.each(rList, function(i){
						var $li = $("<li>"); // <li></li>를 의미
						var $rWriter = $("<span>").prop("class","rWriter").html(rList[i].memberId);
						var $rDate = $("<span>").prop("class","rDate").html(rList[i].commentModifyDt);
						var $rContent = $("<p>").prop("class","rContent").html(rList[i].commentContent);
						
						$li.append($rWriter).append($rDate).append($rContent);
						
						$replyListArea.append($li);
					});
				}
			});
		}
		
		// 댓글 등록 버튼 동작
		$("#addComment").on("click", function(){
			
			if(!$("#commentContent").val().trim().length == 0){
				var writer;
				var boardNo = <%= board.getBoardNo() %>;
				var content = $("#commentContent").val();
				
				writer = "<%=admin.getMemberNo()%>";
				
				$.ajax({
					url : "<%=request.getContextPath()%>/board/insertReply", // URL을 필수 속성!!!
					type : "post",
					data : {writer:writer, content:content, boardNo:boardNo},
					success : function(result){
						if(result>0){
							$("#commentContent").val("");
							selectRlist();
							alert("댓글이 등록되었습니다.");
						}else{
							alert("댓글 등록 실패!");
						}
					},
					error : function(){
						console.log("ajax 통신 실패");
					}
				});
				
				selectRlist();
			}else{
				alert("댓글창에 아무런 내용도 입력되지 않았습니다!");
				$("#commentContent").focus();
			}
			
		}); 
		
	 	$(function(){
			selectRlist();
			
			// 일정시간(3초)마다 댓글 갱신
			setInterval(function(){
				selectRlist();
			}, 3000);
		}); --%>
		
	</script>
</body>
</html>