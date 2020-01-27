<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.onstudy.member.model.vo.Member"%>

<%
	Member loginMember = (Member) session.getAttribute("loginMember");

	// 쿠키사용
	boolean save = false;
	String saveId = "";
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie c : cookies) {
			if (c.getName().equals("saveId")) {
				saveId = c.getValue();
				save = true;
			}
		}
	}
%>
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

<!-- css 임포트 에러 -->
<%-- <link rel="stylesheet" href="<%= request.getContextPath() %>/css/login.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>css/common.css"> --%>
<style>
/* 기본 CSS 적용 */
ul {
	list-style: none;
}

img, fieldset {
	border: none;
}

body, input {
	color: #333333 !important;
}

input, select, img {
	vertical-align: middle;
}

table {
	border-collapse: collapse;
}

html body .background-navy {
	background: #002d4c;
	color: #ffffff;
}

html body .background-orange {
	background: #f15a25;
	color: #ffffff;
}

html body .background-gray {
	background: #9e9e9e;
	color: #ffffff;
}

html body .form-control.navy-btn {
	background-color: #002d4c;
	color: #ffffff;
	border: none;
	padding: 0;
}

html body .form-control.orange-btn {
	background-color: #f15a25;
	color: #ffffff;
	border: none;
	padding: 0;
}

html body .form-control.navy-hover-btn {
	background: transparent;
	color: #002d4c;
	border: 1px solid #002d4c;
	transition: all 0.3s;
}

html body .form-control.navy-hover-btn:hover {
	background: #002d4c;
	color: #ffffff;
}

html body .form-control.orange-hover-btn {
	background: transparent;
	color: #f15a25;
	border: 1px solid #f15a25;
	transition: all 0.3s;
}

html body .form-control.orange-hover-btn:hover {
	background: #f15a25;
	color: #ffffff;
}

html body .form-control.gray-btn {
	background-color: #f15a25;
	color: #9e9e9e;
	border: none;
	padding: 0;
}

html body .content-seciton.orange-hover-background {
	background-color: #9e9e9e;
	color: #333333;
	transition: all 0.3s;
}

html body .content-seciton.orange-hover-background:hover {
	background-color: #f15a25;
	color: #ffffff;
}

html body .form-control.input-comment {
	transition: all 0.3s;
}

html body .form-control.input-comment:focus {
	border-color: #f15a25;
	box-shadow: 0 0 0 0.2rem rgba(241, 90, 37, .25);
}

html body .content-title {
	text-align: initial;
	margin: 50px 0;
	font-size: 35px;
	border-bottom: 2px solid #333333;
	padding-bottom: 10px;
}

.page-link:hover, .page-link {
	color: #f15a25;
}

.page-item.active .page-link {
	background-color: #f15a25;
	border-color: #f15a25;
}

.page-link:focus {
	box-shadow: 0 0 0 0.2rem rgba(241, 90, 37, .25);
}

.pagination {
	position: absolute;
	left: 50%;
	transform: translateX(-50%);
	bottom: -80px;
}
/* 반응형 세부 수정사항 */
@media ( max-width : 767px) { /*767px : 구조가 바뀌는 기준*/
	.form-control {
		min-width: 90px;
	}
}
/* 메인 버튼 */
.main-btn-color {
	border: 1px solid #002d4c;
	color: #ffffff;
	background-color: #002d4c;
}

.main-btn-color:hover {
	border: 1px solid #002d4c;
	background-color: #ffffff;
	color: #002d4c;
}

/* number 태그 화살표 제거 */
input[type="number"]::-webkit-outer-spin-button, input[type="number"]::-webkit-inner-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
}

/* 로그인 전체요소 가운데 위치 */
.login-wrapper {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

/* 배경 색 */
body {
	background-color: #f5f5f5;
	height: 100%;
}

/* login 이미지 */
#login-img {
	display: block;
	margin: 0px auto;
	width: 200px;
}

@media ( max-width : 991px) {
	body {
		font-size: 12px;
	}
}
</style>

<title>온 스터디</title>
</head>

<body>
	<div class="container-fluid px-0">
		<div class="container p-5 login-wrapper">
			<div class="col-md-5 m-auto">
				<form id="loginForm"
					action="<%=request.getContextPath()%>/member/loginedIndex"
					method="POST">
					<img class="mb-4 img-fluid" id="login-img"
						src="<%=request.getContextPath()%>/images/logo2-navy.png"
						alt="...">
					<h3 class="text-center">로그인 정보를 입력하세요</h3>
					<br> <label for="inputId">아이디</label> <input type="text"
						id="inputId" name="inputId" class="form-control"
						value="<%=saveId%>" placeholder="아이디를 입력해주세요." required autofocus>
					<br> <label for="inputPassword">비밀번호</label> <input
						type="password" id="inputPassword" name="inputPassword"
						placeholder="비밀번호를 입력해주세요." class="form-control" required>
					<label><input type="checkbox" id="save" name="save"
						<%=save ? "checked" : ""%>> 아이디 저장 </label> <br>
					<button class="btn btn-lg btn-block main-btn-color" type="submit">로그인</button>
					<div class="d-flex justify-content-between mt-1">
						<div class="m-1">
							<a href="#findIdModal" id="open-findid-modal">아이디 찾기</a>
						</div>
						<div class="m-1">
							<a href="#findPwdModal" id="open-findpwd-modal">비밀번호 찾기</a>
						</div>
						<div class="m-1">
							<a href="#signUpModal" id="open-signup-modal">회원가입</a>
						</div>
					</div>
				</form>
			</div>
		</div>

		<!-- The SignUp Modal -->
		<div class="modal fade" id="signUpModal">
			<div class="modal-dialog modal-md modal-dialog-centered">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">회원가입 방식을 선택해주세요</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<a class="btn btn-lg btn-secondary btn-block mb-3" role="button"
							href="<%=request.getContextPath() %>/member/signupForm" style="color: white;">기존 회원가입</a>
						<button class="btn btn-lg btn-warning btn-block mb-3"
							type="submit" onclick="location.href='#'" style="color: white;">카카오톡으로
							회원가입</button>
						<button class="btn btn-lg btn-primary btn-block" type="submit"
							onclick="location.href='#'">페이스북으로 회원가입</button>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn sub-btn-color-rev"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal End -->

		<!-- The Find Id Modal -->
		<div class="modal fade" id="findIdModal">
			<div class="modal-dialog modal-md modal-dialog-centered">
				<div class="modal-content">
					<form name="findIdForm">
						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">아이디 찾기</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
							<p>계정에 연결된 전화번호를 입력하세요</p>
							<div class="row mb-3">
								<!-- 전화번호1 -->
								<div class="col-md-4">
									<select class="custom-select" id="findIdPhone1" name="phone1"
										required>
										<option>010</option>
										<option>011</option>
										<option>016</option>
										<option>017</option>
										<option>019</option>
									</select>
								</div>

								<!-- 전화번호2 -->
								<div class="col-md-4">
									<input type="number" class="form-control phone"
										id="findIdPhone2" maxlength="4" name="phone2" required>
								</div>

								<!-- 전화번호3 -->
								<div class="col-md-4">
									<input type="number" class="form-control phone"
										id="findIdPhone3" maxlength="4" name="phone3" required>
								</div>
							</div>
							<a class="btn btn-lg main-btn-color btn-block mb-3" role="button"
								id="findIdBtn">확인하기</a>
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn background-gray"
								data-dismiss="modal">Close</button>
						</div>
					</form>

				</div>
			</div>
		</div>
		<!-- Modal End -->

		<!-- The Find Id Result Modal -->
		<div class="modal fade" id="findIdResultModal">
			<div class="modal-dialog modal-md modal-dialog-centered">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">조회 결과</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<h6 class="text-center">회원정보를 확인하세요</h6>
						<div id="findIdResultBody">
							<!-- <p class="small">
								아이디 : <span id="findIdResult">programDoc***</span>
								<br>
								 이름 : <span id="findNameResult">컴박*</span>
								<br>
								가입일 : <span id="findDateResult">2019.05.06</span>
							</p> -->
						</div>

						<a class="btn btn-lg main-btn-color btn-block mb-3" role="button"
							href="#findPwdModal" id="findId-findPwdBtn">비밀번호 찾기</a>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn background-gray"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal End -->

		<!-- The Find Pwd Modal -->
		<div class="modal fade" id="findPwdModal">
			<div class="modal-dialog modal-md modal-dialog-centered">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">비밀번호 찾기</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form onsubmit="false" id="findPwdForm">
							<div class="mb-3">
								<label for="findPwd-input-id">아이디를 입력하세요</label> <input
									type="text" id="findPwd-input-id" class="form-control"
									placeholder="아이디를 입력해주세요." name="findPwd-input-id" required
									autofocus>
							</div>

							<div>
								<label for="findPwd-phone1">전화번호를 입력하세요</label>
								<div class="row mb-3">
									<!-- 전화번호1 -->
									<div class="col-md-4">
										<select class="custom-select" id="findPwd-phone1"
											name="findPwd-phone1" required>
											<option>010</option>
											<option>011</option>
											<option>016</option>
											<option>017</option>
											<option>019</option>
										</select>
									</div>

									<!-- 전화번호2 -->
									<div class="col-md-4">
										<input type="number" class="form-control phone"
											id="findPwd-phone2" maxlength="4" name="findPwd-phone2"
											required>
									</div>

									<!-- 전화번호3 -->
									<div class="col-md-4">
										<input type="number" class="form-control phone"
											id="findPwd-phone3" maxlength="4" name="findPwd-phone3"
											required>
									</div>
								</div>
							</div>
							<a class="btn btn-lg main-btn-color btn-block mb-3" role="button"
								href="#changePwdModal" id="findPwdBtn">확인하기</a>
						</form>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn background-gray"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal End -->

		<!-- The Change Pwd Modal -->
		<div class="modal fade" id="changePwdModal">
			<div class="modal-dialog modal-md modal-dialog-centered">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">비밀번호 변경</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form onsubmit="false" id="changePwdForm">
							<div class="mb-3">
								<label for="changePwd-input-pwd1">새로운 비밀번호를 입력하세요</label> <input
									type="password" id="changePwd-input-pwd1" class="form-control"
									placeholder="비밀번호를 입력해주세요." name="changePwd-input-pwd1"
									required autofocus>
							</div>

							<div class="mb-3">
								<label for="changePwd-input-pwd2">비밀번호를 재입력하세요</label> <input
									type="password" id="changePwd-input-pwd2" class="form-control"
									placeholder="비밀번호를 재입력해주세요." name="changePwd-input-pwd2"
									required autofocus>
							</div>
							<a class="btn btn-lg main-btn-color btn-block mb-3" role="button"
								href="#" id="changePwdBtn">변경하기</a>
						</form>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn background-gray"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal End -->

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
		src="<%=request.getContextPath()%>/js/login.js"></script>

</body>

</html>