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
						<button class="col-md-3 btn form-control orange-hover-btn" value="Y"
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
		
		<!-- js laod -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/signup.js"></script>

</body>


</html>