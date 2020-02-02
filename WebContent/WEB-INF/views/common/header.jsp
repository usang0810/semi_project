<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.semi.member.model.vo.Member"%>

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
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/common.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/intro.css">
<title>온 스터디</title>

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