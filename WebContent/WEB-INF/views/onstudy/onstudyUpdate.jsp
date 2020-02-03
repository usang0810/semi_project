<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.onstudy.model.vo.Onstudy"%>

<%
	Onstudy onstudy = (Onstudy)request.getAttribute("onstudy");

	if(onstudy.getThumbnail() == null){
		onstudy.setThumbnail("noimage.png");
	}
	
	if(onstudy.getOnstudyAddComment() == null){
		onstudy.setOnstudyAddComment("");
	}
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
    </style>
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
                <div class="jumbotron">
                  <form method="POST" action="../onstudy/updateOnstudy?no=<%=onstudy.getOnstudyNo() %>" enctype="multipart/form-data" onsubmit="sendEnd();">
                    <p id="title" class="form-row">
                      <label for="onstudy-title" class="col-sm-2" style="font-weight: bolder;" >제목</label>
                      <input type="text" id="onstudy-title" class="col-sm-10 form-control input-comment" value="<%=onstudy.getOnstudyTitle()%>" readonly>
                    </p>
                    <p id="thumbnail"  class="form-row">
                      <label for="onstudy-thumbnail"  class="col-sm-2" style="font-weight: bolder;" >썸네일</label>
						<span class="boardImg col-sm-5" id="thumbnail">
							<img id="thumbnailImg" width="200" height="200" src="<%=request.getContextPath()%>/resources/onstudyThumbnails/<%=onstudy.getThumbnail()%>">
						</span>
                      <input type="file" id="onstudy-thumbnail" name="onstudy-thumbnail" class="col-sm-5 form-control input-comment" accept=".jpg,.png" onchange="LoadImg(this)">
                    </p>
                    <p id="times"  class="form-row" class="col-sm-12">
                      <label for="onstudy-times" class="col-sm-2" style="font-weight: bolder;">인증 횟수</label>
                      <p style="font-weight: bold;" class="col-sm-2" >주 <input type="number" id="onstudy-times" name="onstudy-times" class="form-control input-comment" value="<%=onstudy.getOnstudyCertifyCount()%>" min="3" max="7" style="text-align: right;">회 (최소 3회)</p>
                    </p>
                    <p id="add-notice"  class="form-row">
						<label for="add-notice" style="font-weight: bolder;">추가 입력사항(<span id="add-notice-count"></span>/1000자)</label><br>
						<textarea class="form-control" rows="5" id="add-notice" name="add-notice" style="resize:none" maxlength="1000"><%=onstudy.getOnstudyAddComment()%></textarea>
					</p>
                    <p id="onstudy-button"  class="form-row" style="float: right;">
                      <a class="btn btn-sm form-control background-gray" id="cancel" href="../onstudy/manage">취 소</a>&nbsp;
                      <button class="btn btn-sm form-control orange-hover-btn" type="submit">저 장</button>&nbsp;
                    </p>
					</form>
					</div>
				</div>
			</div>
            
		</div>
	</div>
	
        <!-- footer -->
	<%@ include file="../common/footer.jsp"%>
	<script>
		
	    function LoadImg(value) {
	    	
	    	if(value.files && value.files[0]){
	    		
	    		var reader = new FileReader(); 
	    		
	    		reader.onload = function(e){
	    			$("#thumbnailImg").prop("src", e.target.result);
	    		} 
	    		reader.readAsDataURL(value.files[0]);
	    	}
	    }
		
	</script>	
        
</body>
</html>