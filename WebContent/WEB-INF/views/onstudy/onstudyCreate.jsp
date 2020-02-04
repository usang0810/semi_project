<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="../css/createView.css">

<title>온스터디</title>
<style>
  #container{
    margin: 200px 0 100px 0;
  }
  label.col-sm-2 {
	padding-right : 30px;
	text-align : right;
  }
</style>

</head>
<body>

	<!-- header -->
	<%@ include file="../common/loginedHeader.jsp" %>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<!-- content -->
	<div id="container" style="color:#333333;">
	
		<div class="container-fluid container">
		
			<div class="row">
				<div class="col-md-12">
					<div class="content-title">
					온스터디 개설
	                </div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<div class=" onstudy-create-div">
						<form method="POST" action="../onstudy/createOnstudy" enctype="multipart/form-data" onsubmit="sendEnd();">
							<p id="title" class="form-row">
                      <label for="onstudy-title" class="col-sm-2" style="font-weight: bolder;" >제목</label>
                      <input type="text" id="onstudy-title" name="onstudy-title" class="col-sm-10 form-control input-comment" placeholder="제목을 입력해주세요" required>
                    </p>
                    <p id="thumbnail"  class="form-row">
                      <label for="onstudy-thumbnail"  class="col-sm-2" style="font-weight: bolder;" >썸네일</label>
						<span class="boardImg col-sm-5" id="thumbnail">
							<img id="thumbnailImg" width="200" height="200" >
						</span>
                      <input type="file" id="onstudy-thumbnail" name="onstudy-thumbnail" class="col-sm-5 form-control input-comment" accept=".jpg,.png" onchange="LoadImg(this)">
                    </p>
							<p id="date"  class="form-row">
								<label for="onstudy-date" class="col-sm-2" style="font-weight: bolder;" required>시작일</label>
								<span class="col-sm-4">
								<input type="text" class="date-picker form-control input-comment" id="onstudy-start" name="onstudy-start" style="width:80%;">
								</span>
								<label for="onstudy-date" class="col-sm-2" style="font-weight: bolder; text-align:center;">종료일</label>
								<span class="col-sm-4">
								<input type="text" class="date-picker form-control input-comment" id="onstudy-end" name="onstudy-end" disabled>
								</span>
							</p>
							<p id="term"  class="form-row">
		                        <label for="onstudy-term" class="col-sm-2" style="font-weight: bolder;">기간</label>
		                        <span class="col-sm-10" style="font-weight: bold;"><input type="number" id="onstudy-weeks" name="onstudy-weeks" class="form-control input-comment" min="2" max="8" value="2" style="text-align: right; width:30%; margin-left:35px;" required>주 (최소 2주 - 최대 8주)</span>
		                     </p>
		                     <p id="times"  class="form-row">
		                        <label for="onstudy-times" class="col-sm-2" style="font-weight: bolder;">인증 횟수</label>
		                        <span class="col-sm-10" style="font-weight: bold;">주 <input type="number" id="onstudy-times" name="onstudy-times" class="form-control input-comment" min="3" max="7" value="3" style="text-align: right; width:30%;" required>회 (최소 3회)</span>
		                     </p>
							<p id="fee"  class="form-row">
								<label for="onstudy-fee" class="col-sm-2" style="font-weight: bolder;">참가비</label>
								<input type="range" class="custom-range col-sm-4 input-comment" id="onstudy-fee" name="onstudy-fee" min="10000" max="100000"
										oninput="document.getElementById('onstudy-fee-value').innerHTML=this.value;" step="10000" required>
								<span id="onstudy-fee-value" name="onstudy-fee-value"></span>원
							</p>
							<p id="category"  class="form-row">
								<label style="font-weight: bolder;">카테고리</label>
								<div class="btn-category btn-group-toggle" data-toggle="buttons" >
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="1" class="form-control input-comment" checked> 영어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="2" class="form-control input-comment"> 중국어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="3" class="form-control input-comment"> 일본어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="4" class="form-control input-comment"> 스페인어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="5" class="form-control input-comment"> 프랑스어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="6" class="form-control input-comment"> 한자 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="7" class="form-control input-comment"> JAVA 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="8" class="form-control input-comment"> C언어 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="9" class="form-control input-comment"> PYTHON 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="10" class="form-control input-comment"> 자바스크립트 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="11" class="form-control input-comment"> 정보처리기사 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="12" class="form-control input-comment"> 수학 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="13" class="form-control input-comment"> 한국사 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="14" class="form-control input-comment"> 과학 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="15" class="form-control input-comment"> 사회 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="16" class="form-control input-comment"> 공무원 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="17" class="form-control input-comment"> 임용고시 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="18" class="form-control input-comment"> 수능 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="19" class="form-control input-comment"> 전산세무 
									</label>&nbsp;
									<label class="btn btn-sm btn-outline-dark">
										<input type="radio" name="onstudy-category" value="20" class="form-control input-comment"> 기타 등등 
									</label>&nbsp;
								</div>
							</p>
							<p id="add-notice"  class="form-row">
								<label for="add-notice" style="font-weight: bolder;">추가 입력사항(<span id="add-notice-count"></span>/1000자)</label><br>
								<textarea class="form-control input-comment" rows="5" id="add-notice" name="add-notice" style="resize:none" maxlength="1000"></textarea>
							</p>
							<div class="d-flex justify-content-between align-items-center " style="position: relative;">
                                <div style="float: right;">
                                    <a class="btn form-control background-gray create-reset"  href="../onstudy/main" >취소</a>
									<button class="btn form-control orange-hover-btn onstudy-create-btn" type="submit">만들기</button>
                                </div>
                            </div>
						</form>
					</div>
				</div>
			</div>
		</div>
          
	</div>
	
	<script>
	
		$(function(){
			
			$("textarea").on("input", function(){
				var inputLength = $(this).val().length;
				$("#add-notice-count").html(inputLength);
			});
			
			// 이미지 공간을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수
   	    	// 파일 선택 버튼이 있는 영역을 보이지 않게 함.
			$("#fileArea").hide();
			
			// 이미지 영역 클릭 시 파일 첨부창 띄우기
   	    	$("#thumbnail").click(function(){
   	    		$("#onstudy-thumbnail").click();
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
	          ,minDate: "1D"
	          ,maxDate: "10D"
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
		
		
		// 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
	    function LoadImg(value) {
	    	
	    	// 파일 업로드 시 업로드된 파일의 경로는 해당 요소에 files라는 배열이 생성되면 저장됨
	    	if(value.files && value.files[0]){
	    		// -> 파일이 선택된 경우
	    		
	    		var reader = new FileReader(); // 해당 경로의 파일을 읽어들이는 것
	    		
	    		// 파일을 다 읽으면 실행해라
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
	
	<!-- content end -->
	<%@ include file="../common/footer.jsp"%>
</body>
</html>