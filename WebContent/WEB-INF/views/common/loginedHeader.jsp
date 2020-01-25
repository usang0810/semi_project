<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.onstudy.member.model.vo.Member"%>
<%
	Member loginMember = (Member) session.getAttribute("loginMember");
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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<link rel="shortcut icon" href="../images/favicon.png">
<link rel="apple-touch-icon-precomposed" href="../images/icon57.png">
<link rel="apple-touch-icon-precomposed" href="../images/icon114.png">
<script>
	<% if(msg != null) {%>
		alert("<%= msg %>");
		<% session.removeAttribute("msg"); %>
	<% } %>
</script>

<!-- css 임포트 에러 -->
<!-- <link rel="stylesheet" href="../css/header.css?ver=1">
	<link rel="stylesheet" href="../css/common.css?ver=1"> -->

<style>
/* header */
* {
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
	color: #333333;
}

ul {
	list-style: none;
}

a:hover {
	text-decoration: none;
}

body {
	position: relative;
}

#shadow {
	width: 100%;
	height: 100%;
	position: fixed;
	top: 0;
	left: 0;
	background-color: rgba(0, 0, 0, 0.5);
	z-index: 800;
	display: none;
	cursor: pointer;
}

#header {
	background-color: #002d4c;
	position: fixed;
	z-index: 500;
	width: 100%;
	top: 0;
	left: 0;
}

#header-wrap nav {
	margin-right: 8rem;
}

#header-wrap nav div>ul>li {
	float: left;
	padding-left: 10px;
	margin-left: 75px;
	position: relative;
}

#header-wrap nav div>ul>li:first-child {
	margin-left: 0;
}

#header-wrap nav div>ul>li>ul {
	position: absolute;
	top: 38px;
	left: 0;
	width: 155px;
	padding: 10px;
	background-color: #024068;
	border-radius: 5px;
}

#header-wrap nav a:hover {
	color: #f15a25;
}

#header-wrap nav a.menu-list {
	color: white;
	font-size: 18px;
}

#header-wrap nav a.menu-list+ul {
	display: none;
}

#header-wrap .logo-img {
	width: 75%;
	min-width: 120px;
}

a.sub-menu-list {
	font-size: 16px;
	color: white;
}

.mypage-btn {
	width: 12%;
	text-align: center;
	cursor: default;
}

.mypage-btn img {
	width: 45px;
	transition: all 0.3s;
	cursor: pointer;
}

.mypage-btn img:hover {
	opacity: 0.7;
}

/* 좌측 마이페이지 부분 */
#mypage-nav {
	width: 280px;
	background-color: #002d4c;
	height: 100%;
	position: fixed;
	z-index: 900;
	padding-top: 30px;
	display: none;
	top: 0;
	left: 0;
}

#mypage-nav .info-area {
	background-color: #ffffff;
	border-radius: 10px;
	width: 80%;
	text-align: center;
	margin: 0 auto;
	padding: 50px 25px;
}

#mypage-nav .info-area .profile-icon {
	width: 100px;
}

#mypage-nav .info-area ul {
	margin-top: 20px;
}

#mypage-nav .info-area ul li {
	font-weight: bold;
}

#mypage-nav .bell-setting-btn {
	float: right;
}

#mypage-nav .bell-setting-btn img {
	width: 30px;
}

#mypage-nav .mypage-btn-list a {
	color: #ffffff;
	font-size: 20px;
	display: block;
	text-align: center;
	margin-top: 30px;
}

#mypage-nav .mypage-btn-list a:hover {
	color: #f15a25;
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
	#logo-wrap {
		text-align: center;
	}
	#header-wrap nav {
		margin-right: 0;
	}
	.mypage-btn {
		width: 9%;
		text-align: center;
		position: absolute;
		left: 7%;
		top: 50%;
		transform: translate(0, -50%);
	}
	#footer .footer-logo-wrap {
		text-align: center;
	}
	#footer .copyright {
		margin: 0;
		text-align: center;
	}
}

@media ( max-width : 590px) {
	#header-wrap nav div>ul>li {
		margin-left: 30px;
	}
}
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
</style>

<!-- bootstrap icon link -->
<script src="https://kit.fontawesome.com/76b49c6d9b.js"
	crossorigin="anonymous"></script>

</head>

<body>
	<div id="header" class='m-0'>
		<div class="row">
			<div class="col-md-12">
				<div
					class="d-flex flex-column flex-md-row align-items-center mb-3 mt-3"
					id="header-wrap">
					<a href="#" class="mypage-btn"><img
						src="../images/mypage-icon.png" alt="마이페이지 버튼"></a>
					<h1 class="my-0 mr-md-auto font-weight-normal text-white"
						id="logo-wrap">
						<a href="#"> <img class="logo-img"
							src="../images/logo2-white.png" alt="로고" id="logo-img">
						</a>
					</h1>
					<nav class="my-2 my-md-0">
						<div>
							<ul class="menu">
								<li><a href="#" class="menu-list">학습노트</a>
									<ul>
										<li><a href="#" class="sub-menu-list">학습노트 검색</a></li>
										<li><a href="#" class="sub-menu-list">학습노트 만들기</a></li>
									</ul></li>
								<li><a href="#" class="menu-list">온스터디</a>
									<ul>
										<li><a href="#" class="sub-menu-list">온스터디 검색</a></li>
										<li><a href="#" class="sub-menu-list">온스터디 만들기</a></li>
										<li><a href="#" class="sub-menu-list">온스터디 인증하기</a></li>
										<li><a href="#" class="sub-menu-list">온스터디 관리</a></li>
									</ul></li>
								<li><a href="#" class="menu-list">게시판</a>
									<ul>
										<li><a href="#" class="sub-menu-list">자유 게시판</a></li>
										<li><a href="#" class="sub-menu-list">건의/신고 게시판</a></li>
									</ul></li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<script>
		//헤더 메뉴 호버 이벤트
		$(function() {
			$(".menu>li").on({
				mouseenter : function() {
					$(this).find("ul").stop().slideDown(300);
				},
				mouseleave : function() {
					$(this).find("ul").stop().slideUp(300);
				}
			});
		});
	</script>
	<div id="mypage-nav">
		<div class="info-area">
			<img src="../images/navi-icon-default.png" alt="회원아이콘"
				class="profile-icon">
			<ul>
				<li>홍길동 님</li>
				<li>10,000 포인트</li>
				<li>팔로워 수 : 100명</li>
				<li>팔로잉 수 : 50명</li>
			</ul>
			<a href="#" class="bell-setting-btn"><img
				src="../images/bell-off.png" alt="알람벨버튼"></a> <a href="#"
				class="bell-setting-btn"><img src="../images/setting-off.png"
				alt="세팅버튼"></a>
		</div>
		<div class="mypage-btn-list">
			<a href="#">학습노트 관리</a> <a href="#">온스터디 내역</a>
		</div>
	</div>
	<div id="shadow"></div>
	<script>
		//좌측 마이페이지 버튼 클릭시 이벤트
		$(function() {
			$(".mypage-btn>img").on({
				click : function() {
					$("#mypage-nav").fadeIn(300);
					$("#shadow").show(0);
				}
			});
			$("#shadow").on({
				click : function() {
					$(this).hide(0);
					$("#mypage-nav").fadeOut(300);
				}
			});

			// 미니버튼 호버시 색상변경 이벤트
			$(".bell-setting-btn").on(
					{
						mouseenter : function() {
							var renameImg = $(this).find("img").prop("src")
									.replace("-off.", "-on.");
							$(this).find("img").prop("src", renameImg);
						},
						mouseleave : function() {
							var renameImg = $(this).find("img").prop("src")
									.replace("-on.", "-off.");
							$(this).find("img").prop("src", renameImg);
						}
					});
		});
	</script>

	<div id="button-top">
		<button type="button" class="top-btn">TOP</button>
	</div>

	<script>
		function scrollFunction() {
			if ($(window).scrollTop() >= 200) {
				$('#button-top').show(0);
			} else {
				$('#button-top').hide(0);
			}
		}
		$(function() {
			scrollFunction();
			$(window).scroll(function() {
				scrollFunction();
			});
			$('#button-top').on({
				click : function() {
					$('html,body').stop().animate({
						scrollTop : 0
					}, 600);
				}
			});
		});
	</script>


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