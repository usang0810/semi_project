/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-02-01 09:56:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.onstudy.member.model.vo.Member;

public final class loginedIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/member/../common/loginedHeader.jsp", Long.valueOf(1580550940707L));
    _jspx_dependants.put("/WEB-INF/views/member/../common/footer.jsp", Long.valueOf(1580169496029L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.onstudy.member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/logined_main.css\">\r\n");
      out.write("\r\n");
      out.write("<title>온 스터디</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");

	Member loginMember = (Member) session.getAttribute("loginMember");
	if(loginMember == null){
		System.out.println("세션 만료 실행");
		session.setAttribute("msg", "세션이 만료되어 메인페이지로 돌아갑니다.");
		response.sendRedirect(request.getContextPath());
	}
	
	int[] follow = (int[])session.getAttribute("follow");
	String memberImagePath = (String)session.getAttribute("memberImagePath");
	String profileImagePath = "/images/navi-icon-default.png"; // default 이미지 경로
	String msg = (String)session.getAttribute("msg");
	
	// null이 아니면 받아온 이미지 경로로 변경
	if(memberImagePath != null) profileImagePath = memberImagePath;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\r\n");
      out.write("\tintegrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\"\r\n");
      out.write("\tcrossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"\r\n");
      out.write("\tintegrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"../images/favicon.png\">\r\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" href=\"../images/icon57.png\">\r\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" href=\"../images/icon114.png\">\r\n");
      out.write("<script>\r\n");
      out.write("\t");
 if(msg != null) {
      out.write("\r\n");
      out.write("\t\talert(\"");
      out.print( msg );
      out.write("\");\r\n");
      out.write("\t\t");
 session.removeAttribute("msg"); 
      out.write('\r');
      out.write('\n');
      out.write('	');
 } 
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/header.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/common.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- bootstrap icon link -->\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/76b49c6d9b.js\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"header\" class='m-0'>\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\tclass=\"d-flex flex-column flex-md-row align-items-center mb-3 mt-3\"\r\n");
      out.write("\t\t\t\t\tid=\"header-wrap\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"mypage-btn\"><img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"../images/mypage-icon.png\" alt=\"마이페이지 버튼\"></a>\r\n");
      out.write("\t\t\t\t\t<h1 class=\"my-0 mr-md-auto font-weight-normal text-white\"\r\n");
      out.write("\t\t\t\t\t\tid=\"logo-wrap\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/main\"> <img class=\"logo-img\"\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"../images/logo2-white.png\" alt=\"로고\" id=\"logo-img\">\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t<nav class=\"my-2 my-md-0\">\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"menu-list\">학습노트</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"sub-menu-list\">학습노트 검색</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"sub-menu-list\">학습노트 만들기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"menu-list\">온스터디</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"sub-menu-list\">온스터디 검색</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"sub-menu-list\">온스터디 만들기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"sub-menu-list\">온스터디 인증하기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"sub-menu-list\">온스터디 관리</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"menu-list\">게시판</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"sub-menu-list\">자유 게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"sub-menu-list\">건의/신고 게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//헤더 메뉴 호버 이벤트\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$(\".menu>li\").on({\r\n");
      out.write("\t\t\t\tmouseenter : function() {\r\n");
      out.write("\t\t\t\t\t$(this).find(\"ul\").stop().slideDown(300);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tmouseleave : function() {\r\n");
      out.write("\t\t\t\t\t$(this).find(\"ul\").stop().slideUp(300);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<div id=\"mypage-nav\">\r\n");
      out.write("\t\t<div class=\"info-area\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(request.getContextPath() + profileImagePath );
      out.write("\" alt=\"회원아이콘\"\r\n");
      out.write("\t\t\t\tclass=\"profile-icon\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>");
      out.print(loginMember.getMemberId() );
      out.write(" 님</li>\r\n");
      out.write("\t\t\t\t<li>");
      out.print(loginMember.getMemberPoint() );
      out.write(" 포인트</li>\r\n");
      out.write("\t\t\t\t<li>팔로워 수 : <span id=\"mypage-follower\">");
      out.print(follow[1] );
      out.write("</span>명</li>\r\n");
      out.write("\t\t\t\t<li>팔로잉 수 : <span id=\"mypage-following\">");
      out.print(follow[0] );
      out.write("</span>명</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"bell-setting-btn\">\r\n");
      out.write("\t\t\t\t<img src=\"../images/bell-off.png\" alt=\"알람벨버튼\"></a>\r\n");
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/mypage\"\tclass=\"bell-setting-btn\">\r\n");
      out.write("\t\t\t\t<img src=\"../images/setting-off.png\" alt=\"세팅버튼\"></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"mypage-btn-list\">\r\n");
      out.write("\t\t\t<a href=\"#\">학습노트 관리</a>\r\n");
      out.write("\t\t\t<a href=\"#\">온스터디 내역</a>\r\n");
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/logout\">로그아웃</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"shadow\"></div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//좌측 마이페이지 버튼 클릭시 이벤트\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$(\".mypage-btn>img\").on({\r\n");
      out.write("\t\t\t\tclick : function() {\r\n");
      out.write("\t\t\t\t\t$(\"#mypage-nav\").fadeIn(300);\r\n");
      out.write("\t\t\t\t\t$(\"#shadow\").show(0);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#shadow\").on({\r\n");
      out.write("\t\t\t\tclick : function() {\r\n");
      out.write("\t\t\t\t\t$(this).hide(0);\r\n");
      out.write("\t\t\t\t\t$(\"#mypage-nav\").fadeOut(300);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t// 미니버튼 호버시 색상변경 이벤트\r\n");
      out.write("\t\t\t$(\".bell-setting-btn\").on(\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\tmouseenter : function() {\r\n");
      out.write("\t\t\t\t\t\t\tvar renameImg = $(this).find(\"img\").prop(\"src\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t.replace(\"-off.\", \"-on.\");\r\n");
      out.write("\t\t\t\t\t\t\t$(this).find(\"img\").prop(\"src\", renameImg);\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\tmouseleave : function() {\r\n");
      out.write("\t\t\t\t\t\t\tvar renameImg = $(this).find(\"img\").prop(\"src\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t.replace(\"-on.\", \"-off.\");\r\n");
      out.write("\t\t\t\t\t\t\t$(this).find(\"img\").prop(\"src\", renameImg);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"button-top\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"top-btn\">TOP</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction scrollFunction() {\r\n");
      out.write("\t\t\tif ($(window).scrollTop() >= 200) {\r\n");
      out.write("\t\t\t\t$('#button-top').show(0);\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$('#button-top').hide(0);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\tscrollFunction();\r\n");
      out.write("\t\t\t$(window).scroll(function() {\r\n");
      out.write("\t\t\t\tscrollFunction();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$('#button-top').on({\r\n");
      out.write("\t\t\t\tclick : function() {\r\n");
      out.write("\t\t\t\t\t$('html,body').stop().animate({\r\n");
      out.write("\t\t\t\t\t\tscrollTop : 0\r\n");
      out.write("\t\t\t\t\t}, 600);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"\r\n");
      out.write("\t\tintegrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\"\r\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"\r\n");
      out.write("\t\tintegrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\"\r\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- content -->\r\n");
      out.write("\t<div class=\"container\" style=\"margin-top: 200px;\">\r\n");
      out.write("\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t<!-- 공지사항 -->\r\n");
      out.write("\t\t\t\t\t<div class=\"jumbotron text-center border\">\r\n");
      out.write("\t\t\t\t\t\t<h3>공지사항</h3>\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<p>업데이트 내용</p>\r\n");
      out.write("\t\t\t\t\t\t<p>업데이트 내용</p>\r\n");
      out.write("\t\t\t\t\t\t<p>업데이트 내용</p>\r\n");
      out.write("\t\t\t\t\t\t<p>버그 수정 내용</p>\r\n");
      out.write("\t\t\t\t\t\t<p>버그 수정 내용</p>\r\n");
      out.write("\t\t\t\t\t\t<p>버그 수정 내용</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- 공지사항 끝 -->\r\n");
      out.write("\t\t\t\t<!-- 학습노트 -->\r\n");
      out.write("\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t<div class=\"jumbotron text-center border pb-3\">\r\n");
      out.write("\t\t\t\t\t\t<h3>금주의 학습노트 제작자</h3>\r\n");
      out.write("\t\t\t\t\t\t<p>축하드립니다! 이번주에 제일 많은 좋아요를 받으셨어요!</p>\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"mb-3\" id=\"profile-wrap\" style=\"display: inline-block;\">\r\n");
      out.write("\t\t\t\t\t\t\t<img class=\"member-profile rounded-circle\"\r\n");
      out.write("\t\t\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath() );
      out.write("/images/mypage-icon.png\" alt=\"프로필아이콘\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"m-0\">아이디</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"row shadow-sm d-flex justify-content-between learning-note\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"p-4 d-flex flex-column text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h5 class=\"main-font-color font-border\">카테고리</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t<h6>과학</h6>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"p-4 d-flex flex-row position-static text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h5 class=\"flex-fill pt-3 font-border\">생명과학 용어 정리</h5>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"p-2 d-flex flex-row position-static\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"far fa-thumbs-up learning-note-icon mt-auto\">378</i>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- 학습노트 끝 -->\r\n");
      out.write("\t\t\t\t<!-- 온스터디 -->\r\n");
      out.write("\t\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t\t<div class=\"jumbotron border pb-3\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"text-center mb-5\" id=\"onStudyIntro\">\r\n");
      out.write("\t\t\t\t\t\t\t<h3>Hot On Study!</h3>\r\n");
      out.write("\t\t\t\t\t\t\t<p>이번주에 참가비가 제일 많이 모인 온 스터디를 확인하세요!</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"Thumbnail\" id=\"img-test\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tstyle=\"background-image: url(../images/river1.PNG);\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p class=\"card-title\">토익 목표점수 달성반</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p class=\"card-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t- 마감날짜 : 2020-01-01(D-10)<br> - 인증빈도 : 주 3회<br> -\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t참여자 수 : 20명<br> - 모인금액 : 1,000,000원\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"d-flex justify-content-between align-items-center \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-sm form-control orange-hover-btn\">자세히</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"Thumbnail\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tstyle=\"background-image: url(../images/tower1.PNG);\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p class=\"card-title\">토익 목표점수 달성반</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p class=\"card-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t- 마감날짜 : 2020-01-01(D-10)<br> - 인증빈도 : 주 3회<br> -\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t참여자 수 : 20명<br> - 모인금액 : 1,000,000원\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"d-flex justify-content-between align-items-center \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-sm form-control orange-hover-btn\">자세히</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"Thumbnail\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tstyle=\"background-image: url(../images/flower1.PNG);\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p class=\"card-title\">토익 목표점수 달성반</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p class=\"card-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t- 마감날짜 : 2020-01-01(D-10)<br> - 인증빈도 : 주 3회<br> -\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t참여자 수 : 20명<br> - 모인금액 : 1,000,000원\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"d-flex justify-content-between align-items-center \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-sm form-control orange-hover-btn\">자세히</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- 온스터디 끝 -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- content end -->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- footer -->\r\n");
      out.write("    <div id=\"footer\">\r\n");
      out.write("        <div class=\"container-fluid container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-md-4 footer-logo-wrap\">\r\n");
      out.write("                            <img class=\"footer-logo\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/logo2-white.png\" alt=\"푸터로고\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-8\">\r\n");
      out.write("                            <p class=\"copyright\">&copy; 2020 NOKJO COMPANY. ALL RIGHTS RESERVED.</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}