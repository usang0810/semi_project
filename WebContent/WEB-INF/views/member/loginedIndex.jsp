<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<!-- <link rel="stylesheet" href="../css/logined_main.css?ver=1"> -->
<style>
#profile-wrap .member-profile {
	width: 25%;
	min-width: 120px;
	display: block;
	margin: 0 auto;
	cursor: pointer;
}

#profile-wrap .member-profile:hover {
	transform: scale(1.1, 1.1);
}

/* 학습노트 마우스 오버시 색 변환 및 커서 변경 */
.learning-note {
	background-color: #9e9e9e;
}

.learning-note:hover {
	background-color: rgba(241, 90, 37, 1);
	transition-duration: 0.3s;
	cursor: pointer;
}

/* 학습노트의 아이콘 속성 */
.learning-note-icon {
	font-size: 1.2em;
}

/* 추천 첼린저스 */
.Thumbnail {
	height: 150px;
	background-repeat: no-repeat;
	background-size: cover;
}

.recommend-title, .recommend-sub-title {
	text-align: center;
	margin-top: 10px;
}

.recommend-title {
	margin-top: 50px;
	font-weight: bold;
	font-size: 35px;
}

.card-title {
	font-size: 20px;
	font-weight: bold;
}

.card-body .d-flex {
	float: right;
}

.card-body .more-btn {
	border: 1px solid #f15a25;
	color: #f15a25;
}

.card-body .more-btn:hover {
	border: 1px solid #f15a25;
	background-color: #f15a25;
	color: #ffffff;
}
</style>

<title>온 스터디</title>
</head>

<body>

	<%@ include file="../common/loginedHeader.jsp"%>

	<!-- content -->
	<div class="container" style="margin-top: 200px;">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-6">
					<!-- 공지사항 -->
					<div class="jumbotron text-center border">
						<h3>공지사항</h3>
						<br>
						<p>업데이트 내용</p>
						<p>업데이트 내용</p>
						<p>업데이트 내용</p>
						<p>버그 수정 내용</p>
						<p>버그 수정 내용</p>
						<p>버그 수정 내용</p>
					</div>
				</div>
				<!-- 공지사항 끝 -->
				<!-- 학습노트 -->
				<div class="col-md-6">
					<div class="jumbotron text-center border pb-3">
						<h3>금주의 학습노트 제작자</h3>
						<p>축하드립니다! 이번주에 제일 많은 좋아요를 받으셨어요!</p>
						<br>
						<div class="mb-3" id="profile-wrap" style="display: inline-block;">
							<img class="member-profile rounded-circle"
								src="<%=request.getContextPath() %>/images/mypage-icon.png" alt="프로필아이콘">
								<%-- <%=request.getContextPath() %>/images/mypage-icon.png --%>
							<p class="m-0">아이디</p>
						</div>
						<div
							class="row shadow-sm d-flex justify-content-between learning-note">
							<div class="p-4 d-flex flex-column text-center">
								<h5 class="main-font-color font-border">카테고리</h5>
								<h6>과학</h6>
							</div>
							<div class="p-4 d-flex flex-row position-static text-center">
								<h5 class="flex-fill pt-3 font-border">생명과학 용어 정리</h5>
							</div>
							<div class="p-2 d-flex flex-row position-static">
								<i class="far fa-thumbs-up learning-note-icon mt-auto">378</i>
							</div>
						</div>
					</div>
				</div>
				<!-- 학습노트 끝 -->
				<!-- 온스터디 -->
				<div class="col-md-12">
					<div class="jumbotron border pb-3">
						<div class="text-center mb-5" id="onStudyIntro">
							<h3>Hot On Study!</h3>
							<p>이번주에 참가비가 제일 많이 모인 온 스터디를 확인하세요!</p>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="card mb-4 shadow-sm">
									<div class="Thumbnail" id="img-test"
										style="background-image: url(../images/river1.PNG);"></div>
									<div class="card-body">
										<p class="card-title">토익 목표점수 달성반</p>
										<p class="card-text">
											- 마감날짜 : 2020-01-01(D-10)<br> - 인증빈도 : 주 3회<br> -
											참여자 수 : 20명<br> - 모인금액 : 1,000,000원
										</p>
										<div
											class="d-flex justify-content-between align-items-center ">
											<div class="btn-group">
												<a class="btn btn-sm form-control orange-hover-btn">자세히</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="card mb-4 shadow-sm">
									<div class="Thumbnail"
										style="background-image: url(../images/tower1.PNG);"></div>
									<div class="card-body">
										<p class="card-title">토익 목표점수 달성반</p>
										<p class="card-text">
											- 마감날짜 : 2020-01-01(D-10)<br> - 인증빈도 : 주 3회<br> -
											참여자 수 : 20명<br> - 모인금액 : 1,000,000원
										</p>
										<div
											class="d-flex justify-content-between align-items-center ">
											<div class="btn-group">
												<a class="btn btn-sm form-control orange-hover-btn">자세히</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="card mb-4 shadow-sm">
									<div class="Thumbnail"
										style="background-image: url(../images/flower1.PNG);"></div>
									<div class="card-body">
										<p class="card-title">토익 목표점수 달성반</p>
										<p class="card-text">
											- 마감날짜 : 2020-01-01(D-10)<br> - 인증빈도 : 주 3회<br> -
											참여자 수 : 20명<br> - 모인금액 : 1,000,000원
										</p>
										<div
											class="d-flex justify-content-between align-items-center ">
											<div class="btn-group">
												<a class="btn btn-sm form-control orange-hover-btn">자세히</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 온스터디 끝 -->
			</div>
		</div>
	</div>
	<!-- content end -->
	<%@ include file="../common/footer.jsp"%>

</body>

</html>