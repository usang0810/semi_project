<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.semi.member.model.vo.Member"%>
<%
	Member admin = (Member) session.getAttribute("loginMember");
	if(admin == null){
		response.sendRedirect(request.getContextPath());
	}
	String msg = (String)session.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<script>
	<% if(msg != null) {%>
		alert("<%= msg %>");
		<% session.removeAttribute("msg"); %>
	<% } %>
</script>

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
	
<link rel="shortcut icon" href="img/favicon.png">
<link rel="apple-touch-icon-precomposed" href="img/icon57.png">
<link rel="apple-touch-icon-precomposed" href="img/icon114.png">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/adminPage-sideBar.css">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<title>온 스터디</title>
<style>
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<!-- 관리자 페이지 사이드바 메뉴 -->
	<div class="sidenav">
		<img src="<%=request.getContextPath() %>/images/logo1-white.png" id="adminTitleImg">
		<p id="adminSidebarTitle">Admin</p>
		<hr>
		<a href="<%=request.getContextPath() %>/admin/memberList">회원 목록 조회</a>
		<hr>
		<a href="<%=request.getContextPath() %>/admin/onstudyList">온스터디 목록 조회</a>
		<hr>
		<p id="adminBoardTitle">게시판</p>
		<a href="boardList?boardType=F">-자유게시판</a>
		<a href="boardList?boardType=S">-건의게시판</a>
		<a href="boardList?boardType=D">-신고게시판</a>
	</div>
	<!-- 관리자 페이지 사이드바 메뉴 -->


	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
		
	<script>
		$("#adminTitleImg").on("click", function(){
			var check = confirm("메인페이지로 접속하시겠습니까?");
			if(check){
				location.href="<%=request.getContextPath()%>";
			}
		}).mouseenter(function(){
			$(this).css({"cursor" : "pointer"});
		});
	</script>

</body>
</html>