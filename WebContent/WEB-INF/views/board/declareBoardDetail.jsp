<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.board.model.vo.Board"%>
<%@page import="com.semi.board.model.vo.BoardImage"%>
<%@page import="java.util.ArrayList"%>
<% 
	Board board = (Board)request.getAttribute("board");
	int boardNo = (int)(request.getAttribute("no"));
	int boardNumbering = (int)(request.getAttribute("boardNumbering"));
	String currentPage = request.getParameter("currentPage");
	String declaredId = (String)request.getAttribute("declaredId");
	
	ArrayList<BoardImage> files = (ArrayList<BoardImage>)request.getAttribute("files");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardDetail.css">
<title>온스터디</title>
</head>

<body>
	<%@ include file="../common/loginedHeader.jsp" %>
	
        <div id="container">
          <div class="container">
            <div class="row">
              <div id="board-content-wrap" class="col-md-12">
                <h2 class="content-title">건의/신고 게시판</h2>
                <div class="board-content">
                  <form class="board-form" action="#" method="post">
                    <div class="content-wrap">
                      <p class="board-content-title"><span class="numbering">No. <%= boardNumbering %></span> <span class="category">[<%= board.getBoardType()%>]</span> <%= board.getBoardTitle() %></p>
                      <p class="writer-date">
                        <span class="writer">작성자 : <%= board.getBoardWriter() %></span>
                        <span class="date">작성일 : <%= board.getBoardModifyDt() %></span>
                      </p>
                      <p class="content">
                      	<% if(declaredId!=null){%>
					           신고 대상 아이디 : <%=declaredId %> <br>
					           사유 : <%= board.getBoardContent() %>
					     <% } else { %>
					    	 <%= board.getBoardContent() %>
					     <% } %>
                      </p>
                    <% if(files != null){ %>
                      <div class="board-image-wrap">
                      	<p class="board-image-title">첨부파일</p>
                      	<div class="board-image-con">
	                      	<% for(int i=0; i<files.size() ; i++) {
	                      		String src = request.getContextPath()+"/resources/boardImages/"+files.get(i).getImageChangeName();
	                      	%>
	                      	<img class="uploaded-img" src="<%= src %>" title="클릭시 다운로드 됩니다."
	                      	 onerror="this.src='../images/document.png'"/>
	                      	<input type="hidden" value=<%=files.get(i).getImageNo() %>>
	                      	<% } %>
	                    </div>
                      </div>
                      <% } %>
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
                        <p class="my-id"><%=loginMember.getMemberId() %></p>
                      	<textArea class="input-comment form-control" name="your-comment" rows="2" id="commentContent" placeholder="댓글 내용을 작성해주세요." style="resize:none"></textArea>
                        <button type="button" id="addComment"class="form-control submit-btn orange-hover-btn">작성하기</button>
                      </div>
                    </div>
                    <div class="bottom-btn-wrap">
	                   <a href="declareBoardList?boardType=SD&currentPage=<%= currentPage %>" class="form-control orange-hover-btn go-list-btn">목록으로</a>
					   <% if(loginMember != null && (board.getBoardWriter().equals(loginMember.getMemberId()))) { %>
		                   <a href="updateDeclareBoardGo?no=<%=boardNo %>&declareId=<%= declaredId %>&category=<%= board.getBoardType()%>" class="form-control orange-hover-btn go-list-btn">수정</a>
		                   <a href="javascript:" id="board-delete-btn" class="form-control orange-hover-btn go-list-btn">삭제</a>
	                   <% } %> 
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
	    <script>
			$("#board-delete-btn").on("click",function(){
				if(confirm("정말 삭제 하시겠습니까?")) location.href = "deleteBoard?boardType=SD&no=<%= boardNo %>";
			});
			
			// 이미지 클릭 시 다운로드
			$(".uploaded-img").on("click",function(){
				var fNo = $(this).next().val();
				location.href="<%= request.getContextPath() %>/board/imageDownload?fNo="+fNo;
			});
			
			// 댓글 출력 함수
			function selectRlist(){
				var boardNo = <%= boardNo %>;
				
				$.ajax({
					url : "selectReplyList",
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
					var boardNo = <%= boardNo %>;
					var content = $("#commentContent").val();
					
					// 로그인 검사 
					<% if(loginMember == null ) { %>
						alert("로그인 후 이용해 주세요.");
					<% } else { %>
						writer = "<%= loginMember.getMemberNo()%>";
						
						$.ajax({
							url : "insertReply", // URL을 필수 속성!!!
							type : "post",
							data : {writer:writer, content:content, boardNo:boardNo},
							success : function(result){
								if(result>0){
									$("#commentContent").val("");
									selectRlist();
								}else{
									alert("댓글 등록 실패!");
								}
							},
							error : function(){
								console.log("ajax 통신 실패");
							}
						});
					<% } %>
					
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
			});
		</script>
	
	<%@ include file="../common/footer.jsp"%>
</body>
</html>