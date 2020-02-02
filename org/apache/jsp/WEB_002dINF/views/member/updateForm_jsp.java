/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-02-02 13:38:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.semi.member.model.vo.Member;

public final class updateForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1580646424079L));
    _jspx_dependants.put("/WEB-INF/views/common/loginedHeader.jsp", Long.valueOf(1580646411512L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.semi.member.model.vo.Member");
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

      out.write('\r');
      out.write('\n');

	int allOnstudyCount = (int)request.getAttribute("allOnstudyCount");
	int partiOnstudyCount = (int)request.getAttribute("partiOnstudyCount");
	int studynoteCount = (int)request.getAttribute("studynoteCount");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
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
      out.write("<link rel=\"stylesheet\" href=\"../css/mypage-update-member.css\">\r\n");
      out.write("<title>온스터디</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		String[] phone = ((Member) session.getAttribute("loginMember")).getMemberPhone().split("-");
	
      out.write("\r\n");
      out.write("\t<div id=\"container\" style=\"color: #333333;\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t\t<p class=\"content-title\">회원정보 수정</p>\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-7\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"jumbotron\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<form method=\"POST\" action=\"update\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tonsubmit=\"return validate();\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row mb-1 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6>이름</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6 id=\"name\">");
      out.print(loginMember.getMemberNm());
      out.write("</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row mb-1 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6>아이디</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6 id=\"id\">");
      out.print(loginMember.getMemberId());
      out.write("</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row mb-1 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6>비밀번호</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control input-comment\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tid=\"newPwd1\" name=\"newPwd1\" maxlength=\"12\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"비밀번호를 입력하세요\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row mb-1 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6>비밀번호 확인</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control input-comment\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tid=\"newPwd2\" name=\"newPwd2\" maxlength=\"12\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"비밀번호 확인\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row mb-1 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6>전화번호</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<select class=\"custom-select form-control input-comment\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tid=\"phone1\" name=\"phone1\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option>010</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option>011</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option>016</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option>017</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option>019</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$.each($(\"#phone1>option\"), function(index, item){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tif($(item).text() == \"");
      out.print(phone[0]);
      out.write("\"){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(item).prop(\"selected\", true);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"number\" class=\"form-control input-comment phone\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tid=\"phone2\" name=\"phone2\" maxlength=\"4\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print(phone[1]);
      out.write("\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"number\" class=\"form-control input-comment phone\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tid=\"phone3\" name=\"phone3\" maxlength=\"4\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print(phone[2]);
      out.write("\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row mb-1 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6>계좌번호</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<select class=\"custom-select\" id=\"bank\" name=\"bankCode\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\trequired>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=0>없음</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=1>국민</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=2>신한</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=3>농협</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=4>우리</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$.each($(\"#bank>option\"), function(index, item){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tif($(item).val() == \"");
      out.print(loginMember.getBankCode());
      out.write("\"){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(item).prop(\"selected\", true);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control input-comment\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tid=\"account\" name=\"bankAccount\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print(loginMember.getMemberAccount() == null ? "" : loginMember.getMemberAccount());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"btn btn-sm mt-5 form-control orange-hover-btn edit-btn\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype=\"submit\" style=\"width: 20%\">수정</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-5\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"jumbotron\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"profile-wrap\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form method=\"POST\" action=\"updateProfile\" enctype=\"multipart/form-data\" role=\"form\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img class=\"member-profile\"\tsrc=\"");
      out.print(request.getContextPath() + profileImagePath);
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talt=\"프로필아이콘\" style=\"width: 40%\" id=\"profileImg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"mt-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<label for=\"upload\"\tid=\"upBtn\" style=\"width: 50px\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"btn btn-sm form-control orange-hover-btn mb-0\">수정</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"file\" id=\"upload\" onchange=\"LoadImg(this)\" name=\"filename\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<button class=\"btn btn-sm form-control orange-hover-btn\" type=\"submit\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 50px\">확인</button>\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"profile-sub-list-wrap\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row mt-5 mb-1 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6>포인트</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6 id=\"name\">");
      out.print(loginMember.getMemberPoint());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t포인트\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row mb-1 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6>알람</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6 id=\"name\">2개</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row mb-1 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6>진행중인 온스터디</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6 id=\"name\">");
      out.print(partiOnstudyCount );
      out.write('/');
      out.print(allOnstudyCount );
      out.write("</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row mb-1 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6>작성한 학습노트</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6 id=\"name\">");
      out.print(studynoteCount );
      out.write("개</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
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
      out.write("\t<script>\r\n");
      out.write("    var formatCheck = {\r\n");
      out.write("      \"newPwd1\": false,\r\n");
      out.write("      \"newPwd2\": false,\r\n");
      out.write("      \"phone3\": false,\r\n");
      out.write("    };\r\n");
      out.write("    \r\n");
      out.write("    $(function () {\r\n");
      out.write("\t\tvar $newPwd1 = $(\"#newPwd1\");\r\n");
      out.write("\t\tvar $newPwd2 = $(\"#newPwd2\");\r\n");
      out.write("\t\tvar $phone2 = $(\"#phone2\");\r\n");
      out.write("\t\tvar $phone3 = $(\"#phone3\");\r\n");
      out.write("    \t\r\n");
      out.write("      $(\"#upload\").css(\"display\", \"none\");\r\n");
      out.write("      $(\"#upBtn\").mouseenter(function () {\r\n");
      out.write("        $(this).css(\"cursor\", \"pointer\");\r\n");
      out.write("      });\r\n");
      out.write("      \r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("\t// 이미지 첨부 시 이미지 출력\r\n");
      out.write("\tfunction LoadImg(value) {\r\n");
      out.write("\r\n");
      out.write("\t\tif (value.files && value.files[0]) {\r\n");
      out.write("\t\t\t// -> 파일이 선택이 된 경우\r\n");
      out.write("\t\t\tvar reader = new FileReader();\r\n");
      out.write("\r\n");
      out.write("\t\t\treader.onload = function(e) {\r\n");
      out.write("\t\t\t\t$(\"#profileImg\").prop(\"src\", e.target.result);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t// file에서 내용(Content)을 읽어옴\r\n");
      out.write("\t\t\t// + base64 인코딩된 경로를 반환\r\n");
      out.write("\t\t\treader.readAsDataURL(value.files[0]);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t// submit 동작\r\n");
      out.write("\tfunction validate() {\r\n");
      out.write("\t\tvar regExp = /^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&~^])[A-Za-z\\d$@$!%*#?&~^]{8,16}$/;\r\n");
      out.write("\r\n");
      out.write("\t\tif (!regExp.test($(\"#newPwd1\").val())) {\r\n");
      out.write("\t\t  formatCheck.newPwd1 = false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t  formatCheck.newPwd1 = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif ($(\"#newPwd1\").val() != $(\"#newPwd2\").val()) {\r\n");
      out.write("\t\t  formatCheck.newPwd2 = false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t  formatCheck.newPwd2 = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 전화번호 input 태그에 4글자 이상 입력하지 못하게 하는 이벤트\r\n");
      out.write("\t\tif ($(this).val().length > $(this).prop(\"maxLength\")) {\r\n");
      out.write("\t\t  $(this).val($(this).val().slice(0, $(this).prop(\"maxLength\")));\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// 전화번호 유효성 검사\r\n");
      out.write("\t\tvar regExp1 = /^\\d{3,4}$/; // 숫자 3~4 글자\r\n");
      out.write("\t\tvar regExp2 = /^\\d{4,4}$/; // 숫자 4 글자\r\n");
      out.write("\t\tif (!regExp1.test($phone2.val()) || !regExp2.test($phone3.val())) {\r\n");
      out.write("\t\t  formatCheck.phone3 = false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t  formatCheck.phone3 = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfor (var key in formatCheck) {\r\n");
      out.write("\t\t  if (!formatCheck[key]) {\r\n");
      out.write("\t\t    alert(\"일부 입력값이 잘못되었습니다.\");\r\n");
      out.write("\t\t    var id = \"#\" + key;\r\n");
      out.write("\t\t    $(id).focus();\r\n");
      out.write("\t\t    return false;\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t}\r\n");
      out.write("    }\r\n");
      out.write("  </script>\r\n");
      out.write("\r\n");
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
