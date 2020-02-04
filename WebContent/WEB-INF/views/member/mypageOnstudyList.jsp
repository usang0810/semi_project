<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.onstudy.model.vo.PageInfo"%>
<%@page import="com.semi.member.model.vo.MyOnstudy"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<% 
	List<MyOnstudy> myList = (List<MyOnstudy>)request.getAttribute("myList");
	int onstudyNo = 0;
	int memberNo = 0;
	int progress = 0;

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온스터디</title>
  <style>

	#container{
        margin: 200px 0 100px 0;
      }
    .onstudy-main-search {
      border: 1px solid #333333;
    }

    .option-detail:hover {
      color: #f15a25;
    }

    .overlay {
        position: absolute;
        background: rgb(0, 0, 0);
        background: rgba(0, 0, 0, 0.5); /* Black see-through */
        color: #f1f1f1;
        width: 100%;
        height: 200px;
        opacity:1;
        color: white;
        font-size: 30px;
        font-weight: bolder;
        padding: 20px;
        text-align: center;
        line-height: 150px;
        top : 0;
        left : 0;
    }
    .card{
    	margin-top : 15px;
    }
    .btn{
    	min-width : 90px;
    	margin : 0 1px;
    }
  </style>
</head>
<body>

	<!-- header -->
	<%@ include file="../common/loginedHeader.jsp" %>  


	<div id="container" style="color:#333333;">

    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="content-title">
            온스터디 참여내역
          </p>
          
          <form class="custom-control custom-checkbox "><input type="checkbox" id="participation-onstudy" name="participation-onstudy"  class="custom-control-input">
            <label for="participation-onstudy" class="custom-control-label">참여중인 온스터디</label>
          </form>
          
          <div class="row">
          <% if(myList.isEmpty()){ %>
			<div class="col-md-12">
				<div class="jumbotron text-center">
				<br><br>
				<i class="fa fa-exclamation-circle fa-5x"></i><br><br>
				<h2 style="text-align: center;">
				현재 진행중인 온스터디 내역이 없습니다.
				</h2>
				<br><br>
				<a class="btn btn-outline-secondary more-btn" href="../onstudy/main">온스터디 보러가기</a>
				<br><br>
				</div>
			</div>
			<% }else{ 
        			for(MyOnstudy onstudy : myList) { 
         				if(onstudy.getImageName() == null){ onstudy.setImageName("noimage.png");}
         				
         				String overlay = "";
         				String close = "";
         				if(onstudy.getCloseCheck() == 1){
         					//overlay = "overlay";
         					overlay = "<div class='overlay mb-3'>완 료</div>";
         					close = "close-onstudy";
	
         				}
         				%>
  			<%progress = (int)Math.floor(((double)onstudy.getMyCertifyCount()/(double)(onstudy.getOnstudyCertifyCount() * onstudy.getOnstudyWeeks()))*100); %>
           	<div class="col-md-4">
           		<div class="card <%=close%>">
           			
					<img class="mb-3" alt="랜덤 이미지" style="height: 200px" src="<%=request.getContextPath()%>/resources/onstudyThumbnails/<%=onstudy.getImageName()%>">
					<%-- <div class="<%=overlay %> mb-3">완 료</div> --%>
					<%=overlay %> 
					<div class="card-block">
 						<div class="card-title">
   						<h5><%= onstudy.getOnstudyTitle() %></h5>
 						</div>
					  	<div class="card-text">
					  		<table>
					  			<tr>
					  				<th colspan="2" class="badge badge-pill badge-secondary">#<%= onstudy.getCategoryNm() %></th>
					  			</tr>
					  			<tr>
						  			<th>참여 기간</th>
						  			<td><%=onstudy.getOnstudyStartDt() %> ~ <%=onstudy.getOnstudyEndDt() %></td>
					  			</tr>
					  			<tr>
					  				<th>인증 횟수</th>
					  				<td>주 <%=onstudy.getOnstudyCertifyCount() %>회</td>
					  			</tr>
					  			<tr>
					  				<th>참 가 비</th>
					  				<td><%= onstudy.getOnstudyFee() %>원</td>
					  			</tr>
					  			<tr>
					  				<th>참 여 율</th>
					  				<td>(<%= onstudy.getMyCertifyCount() %>회 / <%= onstudy.getOnstudyCertifyCount() * onstudy.getOnstudyWeeks() %>회)</td>
					  			</tr>
					  		</table>
					  		<div class="progress">
								<div class="progress-bar" style="width:<%=progress%>%; background-color: #002d4c;"><%=progress%>%</div>
							</div><br>
							<div>
							<a class="btn form-control orange-hover-btn" href="../onstudy/detail?oNo=<%=onstudy.getOnstudyNo() %>" style="width:30%; float: left;">상세보기</a>&nbsp;&nbsp;
							<a class="btn form-control orange-hover-btn" href="../onstudy/boardList?oNo=<%=onstudy.getOnstudyNo() %>" id="certify" style="width:30%; float: left;">인증하기</a>&nbsp;&nbsp;
							
							<%if ( onstudy.getRefundD() == -1 && onstudy.getCloseCheck() == 1) {%> <!-- 미환급 + 온스터디 종료 -->
							
							<input type="hidden" value="<%=onstudy.getOnstudyNo() %>" class="onstudyNo">
							<input type="hidden" value="<%=progress %>" class="progress">
							<input type="hidden" value="<%=onstudy.getOnstudyFee() %>" class="fee">
							<a href="javascript:" class="btn form-control orange-hover-btn reward-btn" style="width:30%; float: left; visibility:visibility">환급신청</a>&nbsp;&nbsp;
							<%} else  if ( onstudy.getRefundD() >= 0 && onstudy.getCloseCheck() == 1){%><!-- 환급  + 온스터디 종료 -->
							<button class="btn form-control orange-btn" style="width:30%; float: left; disabled">환급완료</a>&nbsp;&nbsp;	
							<%} %>
							
							</form>
							</div>
						</div>
					</div>
				</div>
			</div>
				<%} %>
           	<%} %>
          </div>
        </div>
      </div>
    </div>
  </div>

	    <!-- footer -->
	<%@ include file="../common/footer.jsp"%>
	<script>
	 // 무한스크롤 인식
	   /* var page = 2;
	   $(window).scroll(function() { // 스크롤 이벤트가 발생할 때마다 인식
	        if ($(window).scrollTop() == $(document).height() - $(window).height()) {
	          console.log(++page);
	          $("body").append('<div class="big-box"><h1>Page ' + page + '</h1></div>');

	        }
	    }); */
	   
	   	$("input:checkbox").on("click", function(){

	        if($(this).prop("checked")){
	            $(this).parent().addClass("selected");
	            $(".close-onstudy").parent().hide();
	        }else{
	            $(this).parent().removeClass("selected");
	            $(".close-onstudy").parent().show();
	        }
	    });
	   	
	   	$(".reward-btn").on("click",function(){
	   		var check = $(this);
	   		var onstudyNo = check.parent().children(".onstudyNo").val();
	   		var fee = check.parent().children(".fee").val();
	   		var progress = check.parent().children(".progress").val();
	   		
	   		console.log(check);
	   		console.log(onstudyNo);
	   		console.log(fee);
	   		console.log(progress);
	   		
	   		
		   	if( confirm("환급 신청하시겠습니까?") ) {
 		   		location.href ="<%= request.getContextPath()%>/onstudy/reward?onstudyNo=" + onstudyNo + "&progress=" + progress + "&fee=" + fee;
 	   	
		    // 값 보내는 방법
		   	
		   	}
	   	}); 	
	</script>  

</body>
</html>