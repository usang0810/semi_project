<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.onstudy.model.vo.Onstudy"%>
<%@page import="java.util.List"%>

<%
	List<Onstudy> oList = (List<Onstudy>)request.getAttribute("oList");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>온스터디</title>
	<link rel="stylesheet" href="css/header.css">
    <style>
      #container{
        margin: 200px 0 100px 0;
      }
      .card{
      	margin-top : 15px;
      }
    </style>
</head>
<body>

	<!-- header -->
	<%@ include file="../common/loginedHeader.jsp" %>  
	
	<div id="container" style="color:#333333;">
	
		<div class="container-fluid container">
	  		<div class="row">
	    		<div class="col-md-12">
	      			<div class="content-title">
	        			온스터디 관리
	      			</div>
	    		</div>
	  		</div>
	  		
	  		<div class="row">
	    		<div class="col-md-12">
	          		<div class="row">
	          		<% if(oList.isEmpty()){ %>
						<div class="col-md-12">
							<div class="jumbotron text-center">
							<br><br>
							<i class="fa fa-exclamation-circle fa-5x"></i><br><br>
							<h2 style="text-align: center;">
							개설한 온스터디가 없습니다.
							</h2>
							<br><br>
							<a class="btn btn-outline-secondary more-btn" href="../onstudy/createView">온스터디 개설하기</a>
							<br><br>
							</div>
						</div>
					<% }else{ %>
	          			<%for(Onstudy onstudy : oList) { 
		          			if(onstudy.getThumbnail() == null){
								onstudy.setThumbnail("noimage.png");
							}%>
	            		<div class="col-md-4">
	              			<div class="card"  >
								<img class="mb-3" alt="랜덤 이미지" style="height: 200px" src="<%=request.getContextPath()%>/resources/onstudyThumbnails/<%=onstudy.getThumbnail()%>">
								<div class="card-block">
		  						<h5 class="card-title">
		    					<%= onstudy.getOnstudyTitle() %>
		  						</h5>
							  	<p class="card-text">
								    <span class="badge badge-pill badge-secondary">#<%= onstudy.getCategoryNm() %></span><br>
								    <b>참여 기간</b>&nbsp;&nbsp;<%=onstudy.getOnstudyStartDt() %> ~ <%=onstudy.getOnstudyEndDt() %><br>
								    <b>인증 횟수</b>&nbsp;&nbsp;주 <%=onstudy.getOnstudyCertifyCount() %>회<br>
								    <b>참 가 비</b>&nbsp;&nbsp;<%= onstudy.getOnstudyFee() %>원<br>

								    <a class="btn btn-sm orange-hover-btn form-control" href="../onstudy/updateView?no=<%=onstudy.getOnstudyNo() %>" style="float: right; width:20%;">수   정</a>
								</p>
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

    $(function () {

	    $("input:checkbox").on("click", function(){
	
	        if($(this).prop("checked")){
	            $(this).parent().addClass("selected");
	            $(".close-onstudy").hide();
	        }else{
	            $(this).parent().removeClass("selected");
	            $(".close-onstudy").show();
	        }
    	});
       
    });
	</script>
        
        

</body>
</html>