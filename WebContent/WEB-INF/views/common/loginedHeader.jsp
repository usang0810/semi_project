<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.onstudy.member.model.vo.Member"%>
<%
	Member loginMember = (Member) session.getAttribute("loginMember");
	String memberImagePath = (String)session.getAttribute("memberImagePath");
	String profileImagePath = "/images/navi-icon-default.png"; // default 이미지 경로
	String msg = (String)session.getAttribute("msg");
	
	// null이 아니면 받아온 이미지 경로로 변경
	if(memberImagePath != null) profileImagePath = memberImagePath;
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

<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/common.css">

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
						<a href="<%=request.getContextPath() %>/member/main"> <img class="logo-img"
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
			<img src="<%=request.getContextPath() + profileImagePath %>" alt="회원아이콘"
				class="profile-icon">
			<ul>
				<li><%=loginMember.getMemberId() %> 님</li>
				<li><%=loginMember.getMemberPoint() %> 포인트</li>
				<li>팔로워 수 : 100명</li>
				<li>팔로잉 수 : 50명</li>
			</ul>
			<a href="#" class="bell-setting-btn">
				<img src="../images/bell-off.png" alt="알람벨버튼"></a>
			<a href="<%=request.getContextPath() %>/member/mypage"	class="bell-setting-btn">
				<img src="../images/setting-off.png" alt="세팅버튼"></a>
		</div>
		<div class="mypage-btn-list">
			<a href="#">학습노트 관리</a>
			<a href="#">온스터디 내역</a>
			<a href="<%=request.getContextPath() %>/member/logout">로그아웃</a>
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