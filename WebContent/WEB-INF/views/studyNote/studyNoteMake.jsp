<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.semi.member.model.vo.Member"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<link rel="shortcut icon" href="../images/favicon.png">
<link rel="apple-touch-icon-precomposed" href="../images/icon57.png">
<link rel="apple-touch-icon-precomposed" href="../images/icon114.png">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css//common.css">
<title>온스터디</title>
<style>
#container {
	margin: 200px 0 100px 0;
	text-align: center;
}

#profile-wrap .member-profile {
	width: 25%;
	min-width: 120px;
	display: block;
	margin: 0 auto;
}

#profile-wrap .profile-sub-list-wrap {
	margin-left: 10%;
}

#profile-wrap .member-profile-info {
	display: inline-block;
	width: 20%;
	margin-top: 2%;
}

#profile-wrap .member-profile-info dt {
	font-size: 3em;
}

#profile-wrap .member-profile-info dd {
	font-weight: bold;
	font-size: 18px;
}

#profile-wrap .follow-btn {
	background-color: #f15a25;
	border: none;
	width: 11%;
	height: 40px;
	min-width: 80px;
	color: #ffffff;
	border-radius: 30px;
	font-size: 17px;
	transform: translateY(-35px);
}

#study-note-list .study-note-list-title {
	text-align: initial;
	margin: 50px 0;
	font-size: 35px;
	border-bottom: 4px solid #212529;
	padding-bottom: 10px;
}

#study-note-list ul li {
	background-color: #9e9e9e;
	overflow: hidden;
	color: #333333;
	margin-top: 20px;
	font-weight: bold;
	cursor: pointer;
	transition: all 0.3s;
}

#study-note-list ul li:hover {
	background-color: #f15a25;
	color: #ffffff;
}

/* #study-note-list ul li:hover{
  background-color: #f15a25;
}
#study-note-list ul li:hover{
  background-color: #f15a25;
} */
#study-note-list ul li>p {
	margin-bottom: 0;
}

#study-note-list .category-name, #study-note-list .study-note-name {
	float: left;
	font-size: 1.5em;
	line-height: 150px;
}

#study-note-list .etc-info {
	position: relative;
	float: left;
	font-size: 18px;
}

#study-note-list .etc-info .content-amount {
	line-height: 150px;
}

#study-note-list .etc-info .like-btn {
	position: absolute;
	bottom: 10px;
	right: 20px;
}

#study-note-list .etc-info .like-btn>.like-btn-img {
	width: 25px;
	height: 25px;
	background-image: url(../images/like-btn-off2.png);
	background-size: 25px 25px;
	background-repeat: no-repeat;
	background-position: 50% 0%;
	display: inline-block;
}

#study-note-list .etc-info .like-btn>.like-btn-img.on {
	background-image: url(../images/like-btn-on2.png);
}

#study-note-list .etc-info .like-btn>span.like-count {
	transform: translateY(-4px);
	display: inline-block;
}

@media ( max-width : 767px) {
	/*767px : 구조가 바뀌는 기준*/
	#study-note-list .category-name, #study-note-list .study-note-name,
		#study-note-list .etc-info .content-amount {
		line-height: 40px;
	}
}

@media ( max-width : 991px) {
	#profile-wrap .follow-btn {
		font-size: 14px;
	}
}

#add-category:hover {
	cursor: pointer;
}

#add-category {
	font-size: 15px;
}

.bt-category-list {
	width: auto;
	margin: auto;
	background-color: #f15a25;
	color: white;
}

.bt-category-list:hover {
	background-color: white;
	color: #f15a25;
}

#add-category>span :hover {
	background-color: #f15a25;
}

.box-delete:hover {
	background-color: white;
	color: #f15a25;
}

.box-delete {
	cursor: pointer;
	background-color: #f15a25;
	color: white;
}

.add-btn {
	cursor: pointer;
}
</style>
</head>

<body>

	<%@ include file="../common/loginedHeader.jsp"%>
	<!-- content 시작 -->
	<div id="container"
		style="margin: 350px auto; text-align: center; font-size: 40px; color: #333333;">
		<form
			action="<%=request.getContextPath()%>/StudyNoteController/createStudyNote"
			method="post" role="form">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-3">

					<b style="font-size: 20px;">학습노트 작성</b>
				</div>
			</div>

			<hr>

			<div class="container" style="font-size: 15px;">

				<div class="row">
					<div class="col-3" style="font-size: 30px;">제목</div>
					<div class="col-6" style="margin: auto;">

						<input type="text" class="col-12" id="input" name="title"
							placeholder="제목 입력 칸" style="text-align: center;">
					</div>
					<div class="col-3">
						<button class="col-5 pointer " id="search-input" type="submit"
							style="font-size: 20px; border: none; background-color: #002d4c; color: white;">작성</button>
					</div>
				</div>

			</div>

			<div class="container" style="margin-top: 2%;">
				<div class="row">
					<div class="col-3" style="text-align: right;"></div>
					<div class="col-9">
						<div class="row" style="font-size: 15px;">

						<button type="button" id="영어1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >영어</button>&nbsp;
                        <button type="button" id="중국어1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >중국어</button>&nbsp;
                        <button type="button" id="일본어1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >일본어</button>&nbsp;
                        <button type="button" id="스페인어1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >불어</button>&nbsp;
                        <button type="button" id="불어1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >한자</button>&nbsp;
                        <button type="button" id="한자1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >JAVA</button>&nbsp;
                        <button type="button" id="JAVA1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >C언어</button>&nbsp;
                        <button type="button" id="C언어1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >PYTHON</button>&nbsp;
						<button type="button" id="PYTHON1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >수학</button>&nbsp;
                        <button type="button" id="자바스크립트1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >한국사</button>&nbsp;
                        <button type="button" id="정보처리기사1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >과학</button>&nbsp;
                        <button type="button" id="수학1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >사회</button>&nbsp;
                        <button type="button" id="한국사1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >공무원</button>&nbsp;
                        <button type="button" id="과학1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 13%; margin: auto; font-size: 15px; float: left;" value="false" >수능</button>&nbsp;
                        <button type="button" id="사회1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 15%; margin: auto; font-size: 15px; float: left;" value="false" >임용고시</button>&nbsp;
                        <button type="button" id="공무원1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 15%; margin: auto; font-size: 15px; float: left;" value="false" >스페인어</button>&nbsp;
                        <button type="button" id="임용고시1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 15%; margin: auto; font-size: 15px; float: left;" value="false" >전산세무</button>&nbsp;
                        <button type="button" id="수능1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 15%; margin: auto; font-size: 15px; float: left;" value="false" >기타 등등</button>&nbsp;
                        <button type="button" id="전산세무1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 15%; margin: auto; font-size: 15px; float: left;" value="false" >정보처리기사</button>&nbsp;
                        <button type="button" id="기타 등등1" class="bt-category-list rounded orange-hover-btn form-control" style="width: 15%; margin: auto; font-size: 15px; float: left;" value="false" >자바스크립트</button>&nbsp;
						</div>

						<div class="row" style="font-size: 20px; display: none">

							<input type="radio" name="category" id="영어"
								class="category-answer form-control orange-hover-btn" value="1"
								style="margin: auto; width: 10%">영어 &nbsp; <input
								type="radio" name="category" id="중국어"
								class="category-answer form-control orange-hover-btn" value="2"
								style="margin: auto; width: 10%">중국어 &nbsp; <input
								type="radio" name="category" id="일본어"
								class="category-answer form-control orange-hover-btn" value="3"
								style="margin: auto; width: 10%">일본어 &nbsp; <input
								type="radio" name="category" id="스페인어"
								class="category-answer form-control orange-hover-btn" value="4"
								style="margin: auto; width: 10%">스페인어 &nbsp; <input
								type="radio" name="category" id="불어"
								class="category-answer form-control orange-hover-btn" value="5"
								style="margin: auto; width: 10%">불어 &nbsp; <input
								type="radio" name="category" id="한자"
								class="category-answer form-control orange-hover-btn" value="6"
								style="margin: auto; width: 10%">한자 &nbsp; <input
								type="radio" name="category" id="JAVA"
								class="category-answer form-control orange-hover-btn" value="7"
								style="margin: auto; width: 10%">JAVA &nbsp; <input
								type="radio" name="category" id="C언어"
								class="category-answer form-control orange-hover-btn" value="8"
								style="margin: auto; width: 10%">C언어 &nbsp; <input
								type="radio" name="category" id="PYTHON"
								class="category-answer form-control orange-hover-btn" value="9"
								style="margin: auto; width: 10%">PYTHON &nbsp; <input
								type="radio" name="category" id="자바스크립트"
								class="category-answer form-control orange-hover-btn" value="10"
								style="margin: auto; width: 10%">자바스크립트 &nbsp; <input
								type="radio" name="category" id="정보처리기사"
								class="category-answer form-control orange-hover-btn" value="11"
								style="margin: auto; width: 10%">정보처리기사 &nbsp; <input
								type="radio" name="category" id="수학"
								class="category-answer form-control orange-hover-btn" value="12"
								style="margin: auto; width: 10%">수학 &nbsp; <input
								type="radio" name="category" id="한국사"
								class="category-answer form-control orange-hover-btn" value="13"
								style="margin: auto; width: 10%">한국사 &nbsp; <input
								type="radio" name="category" id="과학"
								class="category-answer form-control orange-hover-btn" value="14"
								style="margin: auto; width: 10%">과학 &nbsp; <input
								type="radio" name="category" id="사회"
								class="category-answer form-control orange-hover-btn" value="15"
								style="margin: auto; width: 10%">사회 &nbsp; <input
								type="radio" name="category" id="공무원"
								class="category-answer form-control orange-hover-btn" value="16"
								style="margin: auto; width: 10%">공무원 &nbsp; <input
								type="radio" name="category" id="임용고시"
								class="category-answer form-control orange-hover-btn" value="17"
								style="margin: auto; width: 10%">임용고시 &nbsp; <input
								type="radio" name="category" id="수능"
								class="category-answer form-control orange-hover-btn" value="18"
								style="margin: auto; width: 10%">수능 &nbsp; <input
								type="radio" name="category" id="전산세무"
								class="category-answer form-control orange-hover-btn" value="19"
								style="margin: auto; width: 10%">전산세무 &nbsp; <input
								type="radio" name="category" id="기타 등등"
								class="category-answer form-control orange-hover-btn" value="20"
								style="margin: auto; width: 10%">기타 등등 &nbsp;


						</div>

						<hr>

					</div>
				</div>
			</div>
			<br> <br>



			<div class="container" id="word-collect">


				<div class="container">
					<div class="row box-deleted">
						<div class="col-1">
							<div class="rounded box-delete"
								style="width: 100%; margin-top: 40%; font-size: 100%;">-</div>
						</div>
						<div class="col-11">
							<div class="row">

								<div class="col-1"></div>
								<div class="col-5">
									<textarea class="jumbotron" name="setWord" id="" cols="30"
										rows="8"
										style="font-size: 15px; width: 100%; size: 100%; padding: 0%;"></textarea>

								</div>
								<div class="col-1"></div>
								<div class="col-5">
									<textarea class="jumbotron" name="setMean" id="" cols="30"
										rows="8"
										style="font-size: 15px; width: 100%; size: 100%; padding: 0%;"></textarea>
								</div>
							</div>

						</div>


					</div>
				</div>



				<div class="container">
					<div class="row ">
						<div class="col-1">
							<div class="rounded box-delete"
								style="width: 100%; margin-top: 40%; font-size: 100%;">-</div>
						</div>
						<div class="col-11">
							<div class="row">

								<div class="col-1"></div>
								<div class="col-5">
									<textarea class="jumbotron" name="setWord" id="" cols="30"
										rows="8"
										style="font-size: 15px; width: 100%; size: 100%; padding: 0%;"></textarea>
								</div>
								<div class="col-1"></div>
								<div class="col-5">
									<textarea class="jumbotron" name="setMean" id="" cols="30"
										rows="8"
										style="font-size: 15px; width: 100%; size: 100%; padding: 0%;"></textarea>
								</div>
							</div>

						</div>


					</div>
				</div>

				<div class="container">
					<div class="row box-deleted">
						<div class="col-1">
							<div class="rounded box-delete"
								style="width: 100%; margin-top: 40%; font-size: 100%;">-</div>
						</div>
						<div class="col-11">
							<div class="row">

								<div class="col-1"></div>
								<div class="col-5">
									<textarea class="jumbotron" name="setWord" id="" cols="30"
										rows="8"
										style="font-size: 15px; width: 100%; size: 100%; padding: 0%;"></textarea>
								</div>
								<div class="col-1"></div>
								<div class="col-5">
									<textarea class="jumbotron" name="setMean" id="" cols="30"
										rows="8"
										style="font-size: 15px; width: 100%; size: 100%; padding: 0%;"></textarea>
								</div>
							</div>

						</div>


					</div>
				</div>
			</div>
			<div class="container ">
				<div class="row">
					<div style="text-align: center; margin: auto; font-size: 20px;">
						<img src="../images/add-btn.PNG" alt="학습노트 추가 버튼" class="add-btn">
						<span>추가하기</span> <input class="add-many" type="text"
							placeholder="10" value="10" style="border: none; width: 30px;">
					</div>
				</div>

			</div>


		</form>
	</div>
	<!-- content 종료 -->

	<script>
        
	$(document).ready(function(){
		
			
		setTimeout(function() {
		
		$("#영어1").trigger("click");
		
		}, 100);
		
		}); 
	
	
        $(function () {


            $(document).on("click", ".add-btn", function () {
                var many = $(".add-many").val();
                var html = '<div class="container">'
                    + '<div class="row ">'
                    + '<div class="col-1" >'
                    + '<div class="rounded box-delete " style="width: 100%;  margin-top: 40%; font-size: 100%;">-</div>'
                    + '</div>'
                    + '<div class="col-11">'
                    + ' <div class="row">'

                    + '<div class="col-1"></div>'
                    + '<div class="col-5">'
                    + '<textarea class="jumbotron" name="setWord" id="" cols="30" rows="8"  style="font-size: 15px; width: 100%; size: 100%; padding: 0%;"></textarea>'
                    + '</div>'
                    + '<div class="col-1" ></div>'
                    + '<div class="col-5">'
                    + '<textarea class="jumbotron" name="setMean" id="" cols="30" rows="8"  style="font-size: 15px; width: 100%; size: 100%; padding: 0%;"></textarea>'
                    + '</div>'
                    + '</div>'

                    + '</div>'


                    + '</div>'
                    + '</div>';

                
                    if (many != null) {
                    for (var i = 0; i < many; i++) {

                        $("#word-collect").append(html)
                    }



                } else {

                    $("#word-collect").append(html);
                }
            });

            $(function () {
                /* $(".btn-w1").mouseenter(function () {
                    $(this).css("backgroundColor", "white").css("color", "#f15a25")
                });
                $(".btn-w1").mouseleave(function () {
                    $(this).css("backgroundColor", "#f15a25").css("color", "black")
                }); */
            

          
                $(document).on("click", ".box-delete", function () {
                    $(this).parent().parent().parent().remove();
                });


                
            })
        })

				        $(function(){
				
				    $(".bt-category-list").click(function () {
				
				    var flag = $(this).val();
				    var txt = $(this).html();
				    console.log("앤서"+txt)
				    var answer = "'#"+txt+"'";
				    
				    console.log("앤서"+answer)
				
				if (flag == "false") {
				// 선택으로 만들어라
				    $(".bt-category-list").val("false");
				    $(this).val("true");
				
				// 클릭 안된 상태
				            
				// 클릭된 상태
				                        
				
				
				
				    // 전부 이상한 색으로 바꾼다.
				    $(".bt-category-list").css("backgroundColor", "white").css("color", "#f15a25");
				    $(this).css("backgroundColor", "#f15a25").css("color", "white");;
				    $("#"+txt+"").prop('checked',true);
				    $(this).addClass("orange-hover-btn").addClass("form-control");
				} else {
				    // 선택전 색으로 가게 한다.
				    $(this).css("backgroundColor", "white").css("color", "#f15a25");
				    $(this).val("false")
				   
				}
				
				})
				
				
				})
        
    </script>





	<!-- footer 시작 -->
	<%@ include file="../common/footer.jsp" %>


	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>

</html>