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
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<style>
      #container{
        margin: 200px 0 100px 0;
      }
    </style>
<body>

	<!-- header -->
	<%@ include file="../common/loginedHeader.jsp" %>  
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
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
                      <input type="text" id="onstudy-title" name="onstudy-title" class="col-sm-10 form-control input-comment" value="<%=onstudy.getOnstudyTitle()%>">
                    </p>
                    <p id="thumbnail"  class="form-row">
                      <label for="onstudy-thumbnail"  class="col-sm-2" style="font-weight: bolder;" >썸네일</label>
						<span class="boardImg col-sm-5" id="thumbnail">
							<img id="thumbnailImg" width="200" height="200" src="<%=request.getContextPath()%>/resource/onstudyThumbnails/<%=onstudy.getThumbnail()%>">
						</span>
                      <input type="file" id="onstudy-thumbnail" name="onstudy-thumbnail" class="col-sm-5 form-control input-comment" accept=".jpg,.png" onchange="LoadImg(this)">
                    </p>
                    <p id="date"  class="form-row">
						<label for="onstudy-date" class="col-sm-2" style="font-weight: bolder;">시작일</label>
						<span class="col-sm-4">
						<input type="text" class="date-picker form-control input-comment" id="onstudy-start" name="onstudy-start" value="<%=onstudy.getOnstudyStartDt()%>">
						</span>
						<label for="onstudy-date" class="col-sm-2" style="font-weight: bolder;">종료일</label>
						<span class="col-sm-4">
						<input type="text" class="date-picker form-control input-comment" id="onstudy-end" name="onstudy-end" value="<%=onstudy.getOnstudyEndDt()%>" disabled>
						</span>
                    </p>
                    <p id="term"  class="form-row">
                      <label for="onstudy-term" class="col-sm-2" style="font-weight: bolder;">기간</label>
                      <span class="col-sm-10" style="font-weight: bold;"><input type="number" id="onstudy-weeks" name="onstudy-weeks" class="form-control input-comment" value="<%=onstudy.getOnstudyWeeks()%>" min="2" max="7" style="text-align: right;">주 (최소 2주)</span>
                    </p>
                    <p id="times"  class="form-row">
                      <label for="onstudy-times" class="col-sm-2" style="font-weight: bolder;">인증 횟수</label>
                      <span class="col-sm-10" style="font-weight: bold;">주 <input type="number" id="onstudy-times" name="onstudy-times" class="form-control input-comment" value="<%=onstudy.getOnstudyCertifyCount()%>" min="3" max="7" style="text-align: right;">회 (최소 3회)</span>
                    </p>
                    <p id="add-notice"  class="form-row">
						<label for="add-notice" style="font-weight: bolder;">추가 입력사항(<span id="add-notice-count"></span>/1000자)</label><br>
						<textarea class="form-control" rows="5" id="add-notice" name="add-notice" style="resize:none" maxlength="1000"><%=onstudy.getOnstudyAddComment()%></textarea>
					</p>
                    <p id="onstudy-button"  class="form-row" style="float: right;">
                      <a class="btn btn-sm form-control gray-btn" id="cancel" href="../onstudy/manage">취 소</a>&nbsp;
                      <button class="btn btn-sm form-control orange-hover-btn" type="submit">저 장</button>&nbsp;
                      <a class="btn btn-sm form-control orange-hover-btn" id="del">삭 제</a>
                    </p>
					</form>
					</div>
				</div>
			</div>
            
		</div>
	</div>
	
	<script>
	
		$(function(){
			
			$("#del").on("click",function(){
				if(confirm("정말 삭제 하시겠습니까?")) location.href ="../onstudy/delete?no=<%=onstudy.getOnstudyNo() %>";
			});
			
			// 입력된 기간(주) 저장
			var weeks = $("#onstudy-weeks").val();
			
			// 종료일 datepicker의 'yy-mm-dd'형식으로 설정
			// 종료일 기본값 지정(시작일의 +2주)
			$("#onstudy-end").datepicker({dateFormat: 'yy-mm-dd'});
			$("#onstudy-end").datepicker("setDate", "+"+(weeks*7)+"D");

			// 시작일 datepicker 옵션 설정
			// onSelect : 날짜 선택 시 종료일의 값 변경
	        $("#onstudy-start").datepicker({
	          dateFormat: 'yy-mm-dd'
	          ,minDate: new Date()
	          ,showOtherMonths:true
	          ,showMonthAfterYear: true
	          ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	          ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	          ,dayNames: ['일','월','화','수','목','금','토']
	          ,dayNamesShort: ['일','월','화','수','목','금','토']
	          ,dayNamesMin: ['일','월','화','수','목','금','토']
	          ,onSelect : function(){

	            var now = $("#onstudy-start").datepicker("getDate");
	            year = now.getFullYear();
	            month = now.getMonth();
	            day = now.getDate();
	            var now1 = new Date(year, month, day+(weeks*7)-1);

	            $("#onstudy-end").datepicker("setDate",now1);
	          }
	        });
			// 시작일 기본값은 내일
	        $("#onstudy-start").datepicker("setDate", "+1D");
	       
			// 기간의 값이 변하면 종료일 값 변경
	        $("#onstudy-weeks").on("change", function(){

	          weeks = $("#onstudy-weeks").val();

	          var now2 = $("#onstudy-start").datepicker("getDate");
	          year = now2.getFullYear();
	          month = now2.getMonth();
	          day = now2.getDate();
	          var now3 = new Date(year, month, day+(weeks*7)-1);
	          $("#onstudy-end").datepicker("setDate",now3);

	        });
		});
		
	    function LoadImg(value) {
	    	
	    	if(value.files && value.files[0]){
	    		
	    		var reader = new FileReader(); 
	    		
	    		reader.onload = function(e){
	    			$("#thumbnailImg").prop("src", e.target.result);
	    		} 
	    		reader.readAsDataURL(value.files[0]);
	    	}
	    }
		
		function sendEnd(){
			$("#onstudy-end").prop("disabled",false);
		}
		
	</script>	
        
        <!-- footer -->
	<%@ include file="../common/footer.jsp"%>

</body>
</html>