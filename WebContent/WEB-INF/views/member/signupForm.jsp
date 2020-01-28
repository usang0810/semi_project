<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/signup.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">

<title>온 스터디</title>
</head>

<body>
	<div class="container">
		<div class="signup-header pt-5">
			<img class="mb-4 center-img img-fluid" src="<%=request.getContextPath() %>/images/logo2-navy.png"
				alt="...">
			<h3 class="text-center">회원가입정보를 입력해주세요</h3>
			<br>
		</div>
		<div class="col-md-6 mx-auto pb-5">
			<form class="signUpForm" method="POST" name="signUpForm" action="signup"
				enctype="multipart/form-data" role="form" onsubmit="return validate();">
				
				<!-- 아이디 -->
				<div class="mb-3" id="id-wrapper">
					<label for="inputId">* 아이디</label>
					<div class="row col-md-12 px-0 mx-0">
						<input type="text" class="col-md-9 form-control" id="inputId"
							placeholder="아이디를 입력해주세요" name="signupId" required autofocus>
						<input type="hidden" name="idDup" id="idDup" value="false">
						<button class="col-md-3 btn form-control orange-hover-btn"
							type="button" id="idDupCheck">중복 확인</button>
					</div>
					<div class="caption">6~12자의 영문 대소문자, 숫자만 사용 가능합니다.(첫글자는 영어
						소문자)</div>
					<div>
						<span id="checkId">&nbsp;</span>
					</div>
				</div>

				<!-- 비밀번호 -->
				<div class="mb-3" id="pwd-wrapper">
					<label for="inputPassword">* 비밀번호</label> <input type="password"
						id="inputPwd" class="col-md-12 form-control" name="signupPwd"
						required>
					<div class="caption">8~16자의 최소 하나의 문자, 숫자, 하나의 특수 문자를 포함해야
						합니다.</div>
					<div>
						<span id="checkPwd1">&nbsp;</span>
					</div>
				</div>

				<!-- 비밀번호 재확인 -->
				<div class="mb-3" id="pwdCheck-wrapper">
					<label for="inputPasswordCheck">* 비밀번호 재확인</label> <input
						type="password" id="inputPwdCk" class="form-control"
						name="signupPwdCk" required>
					<div>
						<span id="checkPwd2">&nbsp;</span>
					</div>
				</div>

				<!-- 이름 -->
				<div class="mb-3" id="name-wrapper">
					<label for="inputName">* 이름</label> <input type="text"
						id="inputName" class="form-control" name="signupName" required
						autofocus>
					<div class="caption">2글자 이상의 한글만 사용 가능합니다.</div>
					<div>
						<span id="checkName">&nbsp;</span>
					</div>
				</div>

				<!-- 전화번호 -->
				<div class="mb-3" id="phone-wrapper">
					<label for="phone1">* 휴대전화</label>
					<div class="row">
						<!-- 전화번호1 -->
						<div class="col-md-4">
							<select class="custom-select" id="phone1" name="phone1" required>
								<option>010</option>
								<option>011</option>
								<option>016</option>
								<option>017</option>
								<option>019</option>
							</select>
						</div>

						<!-- 전화번호2 -->
						<div class="col-md-4">
							<input type="number" class="form-control phone" id="phone2"
								maxlength="4" name="phone2" required>
						</div>

						<!-- 전화번호3 -->
						<div class="col-md-4">
							<input type="number" class="form-control phone" id="phone3"
								maxlength="4" name="phone3" required>
						</div>
					</div>
					<div>
						<span id="checkPhone">&nbsp;</span>
					</div>
				</div>

				<!-- 계좌번호 -->
				<div class="mb-3">
					<label for="inputAccount">계좌번호</label>
					<div class="row col-md-12 mx-0 px-0">
						<div class="col-md-4 pl-0">
							<select class="custom-select" id="selectBank" name="bankCode"
								required>
								<option value=0>없음</option>
								<option value=1>국민</option>
								<option value=2>신한</option>
								<option value=3>농협</option>
								<option value=4>우리</option>
							</select>
						</div>
						<input type="number" id="inputAccount" name="bankAccount"
							class="col-md-8 form-control">
					</div>
				</div>

				<!-- 프로필 -->
				<div class="mb-5">
					<label>프로필 사진</label> <img class="mb-3 center-img rounded"
						id="profileImg" src="<%=request.getContextPath() %>/images/navi-icon-default.png" alt="..."
						width="200" height="200">
					<div class="custom-file">
						<input type="file" class="custom-file-input" id="inputImg"
							name="filename" onchange="LoadImg(this)"> <label
							class="custom-file-label" for="customFile">Choose file</label>
					</div>
				</div>

				<button class="btn btn-lg main-btn-color btn-block" type="submit">회원가입</button>
				<div class="caption">*은 필수 입력사항입니다.</div>
			</form>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
		
	<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/js/signup.js"></script> --%>
	<script>
		var signUpCheck = {
			"id" : false,
			"pwd1" : false,
			"pwd2" : false,
			"name" : false,
			"phone" : false,
			"idDup" : false
		};

		$(document).ready(function() {
			// Add the following code if you want the name of the file appear on select
			$(".custom-file-input").on("change", function() {
				var fileName = $(this).val()
						.split("\\").pop();
				
				$(this).siblings(".custom-file-label")
						.addClass("selected").html(fileName);
			});

			// jQuery 변수 : 변수에 직접적으로 jQuery메소드를 사용할 수 있음.
			var $id = $("#inputId");
			var $pwd1 = $("#inputPwd");
			var $pwd2 = $("#inputPwdCk");
			var $name = $("#inputName");
			var $phone2 = $("#phone2");
			var $phone3 = $("#phone3");

			// 아이디  유효성 검사
			// 첫글자는 영어 소문자, 나머지 글자는 영어 대,소문자 + 숫자, 총 6~12글자
			$id.on("input", function() {
				var regExp = /^[a-z][a-zA-z\d]{5,11}$/;
				if (!regExp.test($id.val())) {
					$("#checkId").text("아이디 형식이 유효하지 않습니다.")
							.css("color", "red");

					signUpCheck.id = false;

				} else {
					$("#checkId").text("유효한 형식의 아이디 입니다.").css(
							"color", "green");

					signUpCheck.id = true;
				}
			});
			
			$("#idDupCheck").click(function(){
				
				if(signUpCheck.id == true){
					$.ajax({
						url : "idDupCheck",
						data : {id: $id.val()},
						type : "GET",
						success : function(result){
							if( result == "yes"){
								alert("사용 가능한 아이디입니다.");
								
								signUpCheck.idDup = true;
							}else{
								alert("중복된 아이디입니다. 다른 아이디를 입력해 주세요.");	
								
								signUpCheck.idDup = false;
							}
						},
						error : function(e){
							console.log("아이디 중복검사 ajax 실패");	
							console.log(e);
						},
					});
					
				}else{
					alert("유효한 아이디 형식을 입력 후 다시 시도해 주세요.");
				}
			});

			// 비밀번호  유효성 검사
			//영어 대,소문자 + 숫자, 특수문자(~!@#$%^&*_-) 총 8~16글자
			$pwd1.on("input",function() {
				// var regExp = /^[A-Za-z0-9~!@#$%^&*_-]{8,16}$/;
	
				// 최소 8자 ~ 최대 16자, 최소 하나의 문자, 숫자, 하나의 특수 문자
				var regExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&~^])[A-Za-z\d$@$!%*#?&~^]{8,16}$/;
	
				// "^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$"
	
				if (!regExp.test($pwd1.val())) {
					$("#checkPwd1").text("비밀번호 형식이 유효하지 않습니다.")
							.css("color", "red");
	
					signUpCheck.pwd1 = false;
	
				} else {
					$("#checkPwd1").text("유효한 형식의 비밀번호 입니다.")
							.css("color","green");
	
					signUpCheck.pwd1 = true;
				}
			});

			// 비밀번호 일치 여부
			$pwd2.on("input", function() {
				if ($pwd1.val().trim() != $pwd2.val().trim()) {
					$("#checkPwd2").text("비밀번호가 일치하지 않습니다.")
							.css("color", "red");

					signUpCheck.pwd2 = false;

				} else {
					$("#checkPwd2").text("비밀번호가 일치합니다.").css(
							"color", "green");

					signUpCheck.pwd2 = true;
				}
			});

			// 이름 유효성 검사
			// 한글 두 글자 이상
			$name.on("input", function() {
				var regExp = /^[가-힣]{2,}$/;
				if (!regExp.test($name.val())) {
					signUpCheck.name = false;

				} else {
					signUpCheck.name = true;
				}
			});

			// 전화번호 관련
			$(".phone").on("input", function() {

				// 전화번호 input 태그에 4글자 이상 입력하지 못하게 하는 이벤트
				if ($(this).val().length > $(
						this).prop("maxLength")) {
					$(this).val($(this).val().slice(0, $(this).prop("maxLength")));
				}

				// 전화번호 유효성 검사
				var regExp2 = /^\d{3,4}$/; // 숫자 3~4 글자
				var regExp3 = /^\d{4,4}$/; // 숫자 4 글자

				if (!regExp2.test($("#phone2")
						.val())
						|| !regExp3.test($(
								"#phone3")
								.val())) {
					$("#checkPhone")
							.text(
									"전화번호가 유효하지 않습니다.")
							.css("color", "red");

					signUpCheck.phone = false;

				} else {
					$("#checkPhone").text(
							"전화번호 형식이 유효합니다.")
							.css("color",
									"green");

					signUpCheck.phone = true;

				}
			});

			// 프로필 이미지 클릭 시 파일 선택 클릭
			$("#profileImg").click(function() {
				$("#inputImg").click();
			});

		});
		// 이미지 첨부 시 이미지 출력
		function LoadImg(value) {

			if (value.files && value.files[0]) {
				// -> 파일이 선택이 된 경우
				var reader = new FileReader();

				reader.onload = function(e) {
					$("#profileImg").prop("src", e.target.result);
				}

				// file에서 내용(Content)을 읽어옴
				// + base64 인코딩된 경로를 반환
				reader.readAsDataURL(value.files[0]);
			}
		}

		// submit 동작
		function validate() {

			//console.log(signUpCheck.idDup);
			for ( var key in signUpCheck) {
				if (!signUpCheck[key]) {
					console.log("유효값 false -> " + key + " : "
							+ signUpCheck[key])
					alert("일부 입력값이 잘못되었습니다.");
					var id = "#" + key;
					$(id).focus();
					return false;
				}
			}
		}
	</script>

</body>


</html>