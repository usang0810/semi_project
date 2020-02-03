<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.semi.member.model.vo.Member"%>

<%
	Member loginMember = (Member) session.getAttribute("loginMember");
	String msg = (String)session.getAttribute("msg");

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

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/login.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css">

<script>
	<% if(msg != null) {%>
		alert("<%= msg %>");
		<% session.removeAttribute("msg"); %>
	<% } %>
</script>

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
						id="inputId" name="inputId" class="form-control input-comment"
						value="<%=saveId%>" placeholder="아이디를 입력해주세요." required autofocus>
					<br> <label for="inputPassword">비밀번호</label> <input
						type="password" id="inputPassword" name="inputPassword"
						placeholder="비밀번호를 입력해주세요." class="form-control input-comment" required>
					<div class="custom-control custom-checkbox remember-id">
						<input type="checkbox" id="save" name="save" class="custom-control-input"
							<%=save ? "checked" : ""%>> <label class="custom-control-label" for="save">아이디 저장 </label>
					</div>
					<button class="btn btn-lg btn-block main-btn-color" type="submit">로그인</button>
					<div class="d-flex justify-content-between mt-1 find-id-pw-signUp">
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
						<button type="button" class="btn background-gray"
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
									<select class="custom-select" id="findIdPhone1"	required>
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
										id="findIdPhone2" maxlength="4" required>
								</div>

								<!-- 전화번호3 -->
								<div class="col-md-4">
									<input type="number" class="form-control phone"
										id="findIdPhone3" maxlength="4" required>
								</div>
							</div>
							<button class="btn btn-lg main-btn-color btn-block mb-3" role="button"
								id="findIdBtn">확인하기</button>
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
						</div>

						<button class="btn btn-lg main-btn-color btn-block mb-3" role="button"
							id="findId-findPwdBtn">비밀번호 찾기</button>
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
								<label for="findPwdId">아이디를 입력하세요</label> <input
									type="text" id="findPwdId" class="form-control"
									placeholder="아이디를 입력해주세요." required autofocus>
							</div>

							<div>
								<label for="findPwd-phone1">전화번호를 입력하세요</label>
								<div class="row mb-3">
									<!-- 전화번호1 -->
									<div class="col-md-4">
										<select class="custom-select" id="findPwdPhone1" required>
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
											id="findPwdPhone2" maxlength="4" required>
									</div>

									<!-- 전화번호3 -->
									<div class="col-md-4">
										<input type="number" class="form-control phone"
											id="findPwdPhone3" maxlength="4" required>
									</div>
								</div>
							</div>
							<button class="btn btn-lg main-btn-color btn-block mb-3" role="button"
								id="findPwdBtn">확인하기</button>
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
							<div class="caption">8~16자의 최소 하나의 문자, 숫자, 하나의 특수 문자를 포함해야
							합니다.</div>
							<div class="mb-3">
								<label for="changePwd-input-pwd1">새로운 비밀번호를 입력하세요</label> <input
									type="password" id="changePwd-input-pwd1" class="form-control"
									placeholder="비밀번호를 입력해주세요." required autofocus>
							</div>

							<div class="mb-3">
								<label for="changePwd-input-pwd2">비밀번호를 재입력하세요</label> <input
									type="password" id="changePwd-input-pwd2" class="form-control"
									placeholder="비밀번호를 재입력해주세요."	required autofocus>
							</div>
							<button class="btn btn-lg main-btn-color btn-block mb-3" role="button"
								id="changePwdBtn">변경하기</button>
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