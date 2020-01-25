<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.onstudy.member.model.vo.Member"%>

<%
	String msg = (String)session.getAttribute("msg");
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

<link rel="shortcut icon" href="images/favicon.png">
<link rel="apple-touch-icon-precomposed" href="images/icon57.png">
<link rel="apple-touch-icon-precomposed" href="images/icon114.png">

<!-- 폰트 link -->
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">

<!-- bootstrap icon link -->
<script src="https://kit.fontawesome.com/76b49c6d9b.js"
	crossorigin="anonymous"></script>
	
<script>
	<% if(msg != null) {%>
		alert("<%= msg %>");
		<% session.removeAttribute("msg"); %>
	<% } %>
</script>

<%-- css파일 임포트 에러 --%>
<%-- <link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/common.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/intro.css"> --%>
<title>온 스터디</title>

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
/* html scroll animation */
html {
	scroll-behavior: smooth;
}

body {
	font-family: 'Noto Sans KR', sans-serif;
}

/* 요소를 정가운데로 정렬 */
.centered {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

/* 네비 목록 글자 색상 및 호버 시 */
.background-navy a {
	color: white;
	transition: ease-in-out color .15s;
	font-size: large;
}

.background-navy a:hover {
	color: #f15a25;
	text-decoration: none;
}

/* 이미지 크기 */
#logo-img {
	max-width: 120px;
	min-width: 60px;
}

/* 사이드바 지정 */
#navbarCollapse-icon {
	font-size: 1.5em;
	color: white;
}

#navbarCollapse-icon:hover {
	transition-duration: 0.3s;
	color: gray;
}

.img-wrapper {
	text-align: center;
}

.navbar-toggler {
	color: rgba(255, 255, 255, .5);
	border-color: rgba(255, 255, 255, .1);
}

#intro {
	background-color: lightgray;
	background-attachment: fixed;
	background-image: linear-gradient(135deg, rgba(241, 90, 37, 0.25),
		rgba(211, 211, 211, 0.9)), url("<%=request.getContextPath()%>/images/intro-bg3.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	height: 600px;
}

/* 학습노트 마우스 오버시 색 변환 및 커서 변경 */
.learning-note {
	background-color: white;
	cursor: pointer;
}

.learning-note:hover {
	background-color: rgba(241, 90, 37, 1);
	transition-duration: 0.3s;
}

/* 학습노트의 프로필 이미지 속성 */
#learning-note-profile-img {
	width: 3em;
	height: 3em;
}

/* 학습노트의 아이콘 속성 */
.learning-note-icon {
	font-size: 1.2em;
}

/* 추천 첼린저스 */
.Thumbnail {
	background-color: #777777;
	color: white;
	text-align: center;
	height: 150px;
	line-height: 150px;
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

/* 카테고리 추천 */
.category-list {
	margin-bottom: 0;
	list-style: none;
}

.list-1 {
	margin-top: 50px;
}

.category-list li {
	float: left;
	border: 1px solid #777777;
	width: 12.5%;
	padding: 5% 0;
	text-align: center;
	margin-top: -1px;
	margin-left: -1px;
	background-color: white;
	transition: all 0.3s;
}

.category-list li a {
	color: #777777;
}

.category-list li:hover {
	background-color: #f15a25;
	cursor: pointer;
	border: 1px solid #f15a25;
	z-index: 100;
	position: relative;
}

.category-list li:hover a {
	color: #ffffff;
	font-weight: 600;
}

/* 푸터 */
#footer {
	background-color: #55595c;
	padding: 20px 0;
}

#footer .footer-logo {
	width: 120px;
}

#footer .copyright {
	color: white;
	font-size: 17px;
	line-height: 91.5px;
	margin-bottom: 0;
	margin-left: 30px;
}
/* 탑 버튼 */
#button-top {
	position: fixed;
	bottom: 100px;
	right: 100px;
	display: none;
}

#button-top .top-btn {
	color: #ffffff;
	width: 50px;
	height: 50px;
	background-color: #f15a25;
	display: inline-block;
	text-align: center;
	line-height: 50px;
	border-radius: 50px;
	font-weight: 600;
	border: none;
}

/* 반응형 세부 수정사항 */
@media ( max-width : 767px) { /*767px : 구조가 바뀌는 기준*/
	#footer .footer-logo-wrap {
		text-align: center;
	}
	#footer .copyright {
		margin: 0;
		text-align: center;
	}
}
</style>

</head>

<body>
	<nav
		class="navbar navbar-expand-md background-navy sticky-top py-2 px-5 m-0">
		<a href="#"> <img class="img-fluid" src="images/logo2-white.png"
			alt="..." id="logo-img">
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<i class="fas fa-bars" id="navbarCollapse-icon"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item mx-3"><a class="nav-link navbar-link"
					href="#">소개</a></li>
				<li class="nav-item mx-3"><a class="nav-link site-header-link"
					href="#learning-note">학습 노트</a></li>
				<li class="nav-item mx-3"><a class="nav-link site-header-link"
					href="#on-study">온 스터디</a></li>
			</ul>
			<div>
				<a class="mx-3" href="member/login">로그인</a> <a class="mx-3"
					href="#myModal" data-toggle="modal">회원가입</a>
			</div>
		</div>
	</nav>

	<!-- 회원가입 모달 -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-md">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">회원가입 방식을 선택해주세요</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body mb-3">
					<a class="btn btn-lg btn-secondary btn-block mb-3" role="button"
						href="<%=request.getContextPath() %>/member/signupForm" style="color: white;">기존 회원가입</a>
					<button class="btn btn-lg btn-warning btn-block mb-3" type="submit"
						onclick="location.href='#'" style="color: white;">카카오톡으로
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


	<div id="button-top">
		<button type="button" class="top-btn">TOP</button>
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

	<script>
        function scrollFunction() {
            if ($(window).scrollTop() >= 200) {
                $('#button-top').show(0);
            } else {
                $('#button-top').hide(0);
            }
        }
        $(function () {
            scrollFunction();
            $(window).scroll(function () {
                scrollFunction();
            });

            $('#button-top').on({
                click: function () {
                    $('html,body').stop().animate({ scrollTop: 0 });
                }
            });

            // 버튼 클릭 시 경고창
            $(".learning-note, .card-body a, .category-list>li").click(function () {
                alert("로그인이 필요한 기능입니다!");
            });
        });
    </script>


</body>

</html>