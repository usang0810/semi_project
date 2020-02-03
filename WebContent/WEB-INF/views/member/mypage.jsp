<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/mypage-main.css">

<title>온스터디</title>
</head>

<body>
	<%@ include file="../common/loginedHeader.jsp"%>
	<%
		String bankName = "";
		switch(loginMember.getBankCode()){
		case 0: bankName = "없음"; break;
		case 1: bankName = "국민"; break;
		case 2: bankName = "신한"; break;
		case 3: bankName = "농협"; break;
		case 4: bankName = "우리"; break;
		}
	%>
	
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
											<button type="button" class="form-control orange-hover-btn delete-btn" style="width: auto"
												id="secession" data-toggle="modal" data-target="#checkPwdModal1">탈퇴</button>
									</span>
									<span>
											<button type="button" class="mr-1 form-control orange-hover-btn edit-btn" style="width: auto"
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
														<input type="password" id="inputPassword" class="form-control input-comment"
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
												<h6 id="account"><%= bankName %>
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
									<span>
										<a class="btn form-control orange-hover-btn setting-btn" href="pointDetail?pointInOut=W&pointMonth=0"
											style="width: auto">관리</a>
									</span>
								</div>
								<ul class="point-list mt-5 ml-1 mb-1">
									<li><%= loginMember.getMemberPoint() %> 포인트</li>
								</ul>
							</div>
							<div class="jumbotron p-4 mypage-follow">
								<div>
									<p class="mypage-follow-title ml-1">팔로우</p>
									<span><a style="width: auto"
										class="btn form-control orange-hover-btn setting-btn" href="followDetail">관리</a></span>
								</div>
								<ul class="follow-list mt-5 ml-1 mb-1">
									<li>내가 팔로우하는 회원 <%=follow[0] %></li>
									<br>
									<li>나를 팔로우하는 회원 <%=follow[1] %></li>
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