<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/mypage-main.css">
<style>
#container {
	margin: 200px 0 100px 0;
	text-align: center;
	height: 1000px;
}

.jumbotron {
	height: 95%;
}

.mypage-content {
	text-align: initial;
	font-size: 1.5em;
}

.edit-btn, .delete-btn {
	float: right;
	width: 15%;
}

.member-profile {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 30%;
}

.mypage-point {
	height: 150px;
}

.mypage-point-title {
	float: left;
	font-size: 1.2em;
}

.mypage-follow {
	height: 200px;
}

.mypage-follow-title {
	float: left;
	font-size: 1.2em;
}

.setting-btn {
	float: right;
	width: 20%;
}

.point-list li, .follow-list li {
	float: left;
}

html body .form-control.orange-hover-btn {
	width: 20%;
}

</style>
<title>온스터디</title>

</head>

<body>
	<%@ include file="../common/loginedHeader.jsp"%>
	
	<div id="container" style="color: #333333;">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<p class="content-title">마이페이지</p>
					<div class="row">
						<div class="col-md-7">
							<div class="jumbotron p-4">
								<div>
									<p class="mypage-content">회원정보
									 <span>
											<button type="button" class="form-control orange-hover-btn delete-btn"
												id="secession" data-toggle="modal" data-target="#checkPwdModal1">탈퇴</button>
									</span>
									<span>
											<button type="button" class="mr-1 form-control orange-hover-btn edit-btn"
												id="update" data-toggle="modal" data-target="#checkPwdModal1">수정</button>
										</span>
									</p>

									<!-- Modal -->
									<div class="modal fade" id="checkPwdModal1" role="dialog">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title">비밀번호 확인</h5>
													<button type="button" class="close" data-dismiss="modal">×</button>
												</div>
												<form method="POST" action="pwdCheck" role=form id="pwdCheckForm">
													<div class="modal-body">
														<input type="password" id="inputPassword" class="form-control"
																placeholder="비밀번호를 입력해주세요." name="inputPassword" required
																autofocus>
														<input type="text" style="display: none" id="setPath" name="setPath">
													</div>
													
													<div class="modal-footer">
														<button type="submit" class="btn background-orange"
															 id="confirmPwdBtn">확인</button>
														<button type="button" class="btn background-gray"
															data-dismiss="modal">취소</button>
													</div>
												</form>
											</div>
										</div>
									</div>
									<!-- Modal -->

									<img class="member-profile mt-4"
										src="<%=request.getContextPath() + profileImagePath %>" alt="프로필아이콘">
									<div class="profile-sub-list-wrap">
										<div class="row mt-5 mb-1 form-row">
											<div class="col-md-5">
												<h6>이름</h6>
											</div>
											<div class="col-md-5">
												<h6 id="name"><%= loginMember.getMemberNm() %></h6>
											</div>
										</div>
										<div class="row mb-1 form-row">
											<div class="col-md-5">
												<h6>아이디</h6>
											</div>
											<div class="col-md-5">
												<h6 id="id"><%= loginMember.getMemberId() %></h6>
											</div>
										</div>
										<div class="row mb-1 form-row">
											<div class="col-md-5">
												<h6>휴대전화</h6>
											</div>
											<div class="col-md-5">
												<h6 id="phone"><%= loginMember.getMemberPhone() %></h6>
											</div>
										</div>
										<div class="row mb-1 form-row">
											<div class="col-md-5">
												<h6>계좌번호</h6>
											</div>
											<div class="col-md-5">
												<h6 id="account"><%= loginMember.getBankCode() %>
													<%=(loginMember.getMemberAccount() != null) ? loginMember.getMemberAccount() : "" %></h6>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-5">
							<div class="jumbotron p-4 mypage-point">
								<div>
									<p class="mypage-point-title ml-1">포인트</p>
									<span><a
										class="btn form-control orange-hover-btn setting-btn" href="#">관리</a></span>
								</div>
								<ul class="point-list mt-5 ml-1 mb-1">
									<li><%= loginMember.getMemberPoint() %> 포인트</li>
								</ul>
							</div>
							<div class="jumbotron p-4 mypage-follow">
								<div>
									<p class="mypage-follow-title ml-1">팔로우</p>
									<span><a
										class="btn form-control orange-hover-btn setting-btn" href="#">관리</a></span>
								</div>
								<ul class="follow-list mt-5 ml-1 mb-1">
									<li>내가 팔로우하는 회원 5</li>
									<br>
									<li>나를 팔로우하는 회원 10</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../common/footer.jsp"%>
	
	<script>
		$(function(){
			$("#secession").on("click", function(){
				$("#setPath").val("secession");
			});
			
			$("#update").on("click", function(){
				$("#setPath").val("update");
			});
		});
	</script>
</body>

</html>