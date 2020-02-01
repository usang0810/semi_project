<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, java.util.HashMap"%>
<%
	List<Member>[] followList = (List<Member>[])request.getAttribute("followList");
	HashMap<Integer, String> followImageMap = (HashMap<Integer, String>)request.getAttribute("followImageMap");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypage-follow.css">

  <title>온스터디</title>
 
</head>

<body>
  <%@ include file="../common/loginedHeader.jsp"%>

  <div id="container" style="color:#333333;">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="content-title">
            팔로우 관리
          </p>
          <div class="jumbotron">
            <div class="col-md-6 p-1 following-list">
              <p class="following-list-title">Following<span class="mr-2 following-count" style="float:right;" id="following-title"><%=follow[0] %></span>
              </p>
              <div class="col-md-12 pt-3 pb-3 mt-0 following-list-content">
                <ul>
                	<%for(Member following : followList[0]){ %>
	                  <li class="id-list" name="id" value="<%=following.getMemberNo() %>">
	                  	<%if(followImageMap.get(following.getMemberNo()) != null){ %>
		                  	<img src="<%=request.getContextPath() + followImageMap.get(following.getMemberNo()) %>">	                  	
	                  	<%}else{ %>
		                  	<img src="<%=request.getContextPath() %>/images/navi-icon-default.png">	                  	
	                  	<%} %>
                  		<span><%=following.getMemberId() %></span>
	                    <div class="fa fa-window-close follow-cancle-btn">
	                    </div>
	                  </li>
                	<%} %>
                </ul>
              </div>
            </div>
            <div class="col-md-6 p-1 follower-list">
              <p class="follower-list-title">Follower<span class="mr-2 follower-count" style="float:right;"><%=follow[1] %></span></p>
              <div class="col-md-12 pt-3 pb-3 mt-0 following-list-content">
                <ul>
                	<%for(Member follower : followList[1]){ %>
                		<li value="<%=follower.getMemberNo() %>">
                			<%if(followImageMap.get(follower.getMemberNo()) != null){ %>
		                  		<img src="<%=request.getContextPath() + followImageMap.get(follower.getMemberNo()) %>">	                  	
		                  	<%}else{ %>
			                  	<img src="<%=request.getContextPath() %>/images/navi-icon-default.png">	                  	
		                  	<%} %>
                			<span><%=follower.getMemberId() %></span>
                		</li>
                	<%} %>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script>
    $(function () {
      $(".follow-cancle-btn").on({
        "click": function () {
          var result = confirm('팔로우를 취소하시겠습니까?');
          if (result) {
        	  var memberNo = $(this).parent();
              
              $.ajax({
					url : "unFollow",
					data : {memberNo: memberNo.val()},
					type : "GET",
					success : function(result){
						if( result == "1"){
							$("#following-title").text($("#following-title").text()-1);
							$("#mypage-following").text($("#mypage-following").text()-1)
							memberNo.detach();
								
						}else{
							alert("언팔로우 실패");	
						}
					},
					error : function(e){
						console.log("언팔로우 ajax 실패");	
						console.log(e);
					},
				});
          }
        }
      });
    });
  </script>

  <%@ include file="../common/footer.jsp"%>
</body>

</html>