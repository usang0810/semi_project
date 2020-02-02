<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.semi.member.model.vo.Point, com.semi.member.model.vo.PageInfo"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypage-point-list.css">

  <title>온스터디</title>
 
</head>

<body>
<%@ include file="../common/loginedHeader.jsp"%>
<% 
	List<Point> pList = (List<Point>)request.getAttribute("pList");
	PageInfo pInf = (PageInfo)request.getAttribute("pInf");
	char pointInOut = request.getParameter("pointInOut").charAt(0);
	int pointMonth = Integer.parseInt(request.getParameter("pointMonth"));
	
	int listCount = pInf.getListCount();
	int currentPage = pInf.getCurrentPage();
	int maxPage = pInf.getMaxPage();
	int startPage = pInf.getStartPage();
	int endPage = pInf.getEndPage();
%>
<%	
	String bankName = "";
	switch(loginMember.getBankCode()){
	case 0: bankName = "없음"; break;
	case 1: bankName = "국민"; break;
	case 2: bankName = "신한"; break;
	case 3: bankName = "농협"; break;
	case 4: bankName = "우리"; break;
	}
%>
  <div id="container" style="color:#333333;">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="content-title">
            포인트 관리
          </p>
          <div class="row">
            <div class="col-md-12">
              <div class="jumbotron p-4">
                <div class="col-md-6 pl-2 mb-2">
                  <p class="retention-point">
                    보유포인트
                  </p>
                  <span class="retention-point-number"><%=loginMember.getMemberPoint() %></span>
                </div>
                <div class="vl mr-5 pr-5"></div>
                <div class="col-md-6">
                  <p class="mt-2 my-account-title">나의 계좌</p>
                  <p class="mt-3 mb-3 my-account-number"><%=bankName %> <%=loginMember.getMemberAccount() != null ? loginMember.getMemberAccount() : "" %></p>
                  <a href="pointPayBackForm" class="btn btn-link" type="button">환급신청</a>
                  <a href="pointChargeForm" class="btn btn-link" type="button">충전하기</a>
                </div>
              </div>
            </div>
          </div>

          <div class="row mt-2 mb-5">

            <div class="btn-group btn-group-toggle" data-toggle="buttons" id="pointInOutWrapper">
              <label class="btn btn-total btn-dark">
                <input type="radio" name="pointInOut" id="point-total" value="W"> 전체
              </label>
              <label class="btn btn-income btn-dark">
                <input type="radio" name="pointInOut" id="point-income" value="A"> 입금
              </label>
              <label class="btn btn-outgo btn-dark">
                <input type="radio" name="pointInOut" id="point-outgo" value="M"> 출금
              </label>
              <script>
              	$(function(){
              		var pointInOut = "<%= pointInOut %>";
              		$.each($("#pointInOutWrapper input"), function(index, item){
              			if($(item).val() == pointInOut){
              				$(item).prop("checked", "checked");
              			}
              		});
              	});
              </script>
            </div>
          </div>
        </div>
      </div>
      <div class="row mt-2 mb-5">
        <div class="btn-group btn-group-toggle" data-toggle="buttons" id="pointMonthWrapper">
          <label class="btn btn-dark btn-1month">
            <input type="radio" name="pointMonth" id="point-1month" value="1"> 1개월
          </label>
          <label class="btn btn-dark btn-3month">
            <input type="radio" name="pointMonth" id="point-3month" value="3"> 3개월
          </label>
          <label class="btn btn-dark btn-6month">
            <input type="radio" name="pointMonth" id="point-6month" value="6"> 6개월
          </label>
          <label class="btn btn-dark btn-12month">
            <input type="radio" name="pointMonth" id="point-12month" value="12"> 12개월
          </label>
          <label class="btn btn-dark btn-total-terms">
            <input type="radio" name="pointMonth" id="point-total-terms" value="0"> 전체
          </label>
          <script>
           	$(function(){
           		var pointMonth = "<%= pointMonth %>";
           		$.each($("#pointMonthWrapper input"), function(index, item){
           			if($(item).val() == pointMonth){
           				$(item).prop("checked", "checked");
           			}
           		});
           	});
           </script>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12 point-content1">
          <table class="table container mt-3">
            <thead>
              <tr>
                <th scope="col">상태</th>
                <th scope="col">내용</th>
                <th scope="col">날짜</th>
                <th scope="col">적립금</th>
              </tr>
            </thead>
            <tbody>
            	<% if(pList.isEmpty()){ %>
					<tr>
						<td colspan="4">존재하는 게시글이 없습니다.</td>
					</tr>
				<% }else{ %>
					<% for(Point point : pList){ %>
					<tr>
						<td><%= point.getPointStatus() =='A' ? "입금" : "출금" %></td>
						<td><%= point.getPointDetailNm() %></td>
						<td><%= point.getPointUpdateDt() %></td>
						<td><%= point.getPoint() %></td>
					</tr>
					<% } %>
				<% } %>
            </tbody>
          </table>
          
	          <!-- 페이징바 -->
	        <div style="clear: both;">
	            <ul class="pagination">
	            	<% if(currentPage > 1) { %>
	                <li class="page-item">
	                	<!-- 맨 처음으로(<<) -->
	                    <a class="page-link page-first"
	                    	 href="<%= request.getContextPath() %>/member/pointDetail?currentPage=1&pointInOut=<%=pointInOut %>&pointMonth=<%=pointMonth %>">
	                    	 &lt;&lt;</a>
	                </li>
	                
	                <li class="page-item">
	                	<!-- 이전으로(<) -->
	                  		<a class="page-link page-pre"
	                  			href="<%= request.getContextPath() %>/member/pointDetail?currentPage=<%= currentPage-1 %>&pointInOut=<%=pointInOut %>&pointMonth=<%=pointMonth %>">
	                  			&lt;</a>
	                </li>
	                <% } %>
	                
	                <!-- 10개의 페이지 목록 -->
	                <% for(int p = startPage; p <= endPage; p++){ %>
	                	<% if(p == currentPage) { %>
		                <li class="page-item">
		                    <a class="page-link page-now"><%= p %></a>
		                </li>
	                	<% } else{ %>
	               		<li class="page-item">
	                    	<a class="page-link page-other"
	                    	 href="<%= request.getContextPath() %>/member/pointDetail?currentPage=<%= p %>&pointInOut=<%=pointInOut %>&pointMonth=<%=pointMonth %>">
	                    	 <%= p %></a>
	                	</li>
	                	<% } %>
					<%} %>
	                
	                <!-- 다음 페이지로(>) -->
	                <% if(currentPage < maxPage){ %>
	                <li class="page-item">
	                    <a class="page-link page-next"
	                     href="<%= request.getContextPath() %>/member/pointDetail?currentPage=<%= currentPage+1 %>&pointInOut=<%=pointInOut %>&pointMonth=<%=pointMonth %>">
	                     &gt;</a>
	                </li>
	                
	                <!-- 맨 끝으로(>>) -->
	                <li class="page-item">
	                    <a class="page-link page-end"
	                     href="<%= request.getContextPath() %>/member/pointDetail?currentPage=<%= maxPage %>&pointInOut=<%=pointInOut %>&pointMonth=<%=pointMonth %>">
	                     &gt;&gt;</a>
	                </li>
	                <% }%>
	                
	            </ul>
	        </div>
        </div>
      </div>
    </div>
  </div>
  <%@ include file="../common/footer.jsp"%>
  
  <script>
  	$(function(){
  		
  		$("input[name='pointInOut']").on("click", function(){
  			var pointMonth = $("input[name='pointMonth']:checked").val();
  			location.href="<%= request.getContextPath() %>/member/pointDetail?pointInOut=" + $(this).val() + "&pointMonth=" + pointMonth;
  		});
  		
  		$("input[name='pointMonth']").on("click", function(){
  			var pointInOut = $("input[name='pointInOut']:checked").val();
  			location.href="<%= request.getContextPath() %>/member/pointDetail?pointInOut=" + pointInOut + "&pointMonth=" + $(this).val();
  		});

  	});
  </script>
</body>

</html>