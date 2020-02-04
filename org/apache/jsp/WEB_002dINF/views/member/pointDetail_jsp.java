/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-02-04 00:45:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.semi.member.model.vo.Point;
import com.semi.member.model.vo.PageInfo;
import com.semi.member.model.vo.Member;

public final class pointDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/member/../common/loginedHeader.jsp", Long.valueOf(1580775352138L));
    _jspx_dependants.put("/WEB-INF/views/member/../common/footer.jsp", Long.valueOf(1580775352137L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.semi.member.model.vo.Point");
    _jspx_imports_classes.add("com.semi.member.model.vo.Member");
    _jspx_imports_classes.add("com.semi.member.model.vo.PageInfo");
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ko\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/mypage-point-list.css\">\n");
      out.write("\n");
      out.write("  <title>온스터디</title>\n");
      out.write(" \n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
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
      out.write("<link rel=\"shortcut icon\" href=\"");
      out.print(request.getContextPath() );
      out.write("/images/favicon.png\">\r\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" href=\"");
      out.print(request.getContextPath() );
      out.write("/images/icon57.png\">\r\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" href=\"");
      out.print(request.getContextPath() );
      out.write("/images/icon114.png\">\r\n");
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
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath());
      out.write("/StudyNoteController/list\" class=\"menu-list\" class=\"menu-list\">학습노트</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath());
      out.write("/StudyNoteController/list\" class=\"sub-menu-list\">학습노트 검색</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/StudyNoteController/make\" class=\"sub-menu-list\">학습노트 만들기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/onstudy/main\" class=\"menu-list\">온스터디</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/onstudy/main\" class=\"sub-menu-list\">온스터디 검색</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/onstudy/createView\" class=\"sub-menu-list\">온스터디 만들기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/onstudy/certify\" class=\"sub-menu-list\">온스터디 인증하기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/onstudy/manage\" class=\"sub-menu-list\">온스터디 관리</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath());
      out.write("/board/freeBoardList?boardType=F\" class=\"menu-list\">게시판</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath());
      out.write("/board/freeBoardList?boardType=F\" class=\"sub-menu-list\">자유 게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath());
      out.write("/board/declareBoardList?boardType=SD\" class=\"sub-menu-list\">건의/신고 게시판</a></li>\r\n");
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
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/mypage\"\tclass=\"bell-setting-btn\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/setting-off.png\" alt=\"세팅버튼\"></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"mypage-btn-list\">\r\n");
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/StudyNoteController/selectStudyNoteSet\">학습노트 관리</a>\r\n");
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/onstudyList\">온스터디 내역</a>\r\n");
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
      out.write('\n');
 
	List<Point> pList = (List<Point>)request.getAttribute("pList");
	PageInfo pInf = (PageInfo)request.getAttribute("pInf");
	char pointInOut = request.getParameter("pointInOut").charAt(0);
	int pointMonth = Integer.parseInt(request.getParameter("pointMonth"));
	
	int listCount = pInf.getListCount();
	int currentPage = pInf.getCurrentPage();
	int maxPage = pInf.getMaxPage();
	int startPage = pInf.getStartPage();
	int endPage = pInf.getEndPage();

      out.write('\n');
	
	String bankName = "";
	switch(loginMember.getBankCode()){
	case 0: bankName = "없음"; break;
	case 1: bankName = "국민"; break;
	case 2: bankName = "신한"; break;
	case 3: bankName = "농협"; break;
	case 4: bankName = "우리"; break;
	}

      out.write("\n");
      out.write("  <div id=\"container\" style=\"color:#333333;\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-md-12\">\n");
      out.write("          <p class=\"content-title\">\n");
      out.write("            포인트 관리\n");
      out.write("          </p>\n");
      out.write("          <div class=\"row\">\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("              <div class=\"jumbotron p-4\">\n");
      out.write("                <div class=\"col-md-6 pl-2 mb-2\">\n");
      out.write("                  <p class=\"retention-point\">\n");
      out.write("                    보유포인트\n");
      out.write("                  </p>\n");
      out.write("                  <span class=\"retention-point-number\">");
      out.print(loginMember.getMemberPoint() );
      out.write("</span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"vl mr-5 pr-5\"></div>\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                  <p class=\"mt-2 my-account-title\">나의 계좌</p>\n");
      out.write("                  <p class=\"mt-3 mb-3 my-account-number\">");
      out.print(bankName );
      out.write(' ');
      out.print(loginMember.getMemberAccount() != null ? loginMember.getMemberAccount() : "" );
      out.write("</p>\n");
      out.write("                  <a href=\"pointPayBackForm\" class=\"btn btn-link\" type=\"button\">환급신청</a>\n");
      out.write("                  <a href=\"pointChargeForm\" class=\"btn btn-link\" type=\"button\">충전하기</a>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"row mt-2 mb-5\">\n");
      out.write("\n");
      out.write("            <div class=\"btn-group btn-group-toggle\" data-toggle=\"buttons\" id=\"pointInOutWrapper\">\n");
      out.write("              <label class=\"btn btn-total btn-dark\">\n");
      out.write("                <input type=\"radio\" name=\"pointInOut\" id=\"point-total\" value=\"W\"> 전체\n");
      out.write("              </label>\n");
      out.write("              <label class=\"btn btn-income btn-dark\">\n");
      out.write("                <input type=\"radio\" name=\"pointInOut\" id=\"point-income\" value=\"A\"> 입금\n");
      out.write("              </label>\n");
      out.write("              <label class=\"btn btn-outgo btn-dark\">\n");
      out.write("                <input type=\"radio\" name=\"pointInOut\" id=\"point-outgo\" value=\"M\"> 출금\n");
      out.write("              </label>\n");
      out.write("              <script>\n");
      out.write("              \t$(function(){\n");
      out.write("              \t\tvar pointInOut = \"");
      out.print( pointInOut );
      out.write("\";\n");
      out.write("              \t\t$.each($(\"#pointInOutWrapper input\"), function(index, item){\n");
      out.write("              \t\t\tif($(item).val() == pointInOut){\n");
      out.write("              \t\t\t\t$(item).prop(\"checked\", \"checked\");\n");
      out.write("              \t\t\t}\n");
      out.write("              \t\t});\n");
      out.write("              \t});\n");
      out.write("              </script>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"row mt-2 mb-5\">\n");
      out.write("        <div class=\"btn-group btn-group-toggle\" data-toggle=\"buttons\" id=\"pointMonthWrapper\">\n");
      out.write("          <label class=\"btn btn-dark btn-1month\">\n");
      out.write("            <input type=\"radio\" name=\"pointMonth\" id=\"point-1month\" value=\"1\"> 1개월\n");
      out.write("          </label>\n");
      out.write("          <label class=\"btn btn-dark btn-3month\">\n");
      out.write("            <input type=\"radio\" name=\"pointMonth\" id=\"point-3month\" value=\"3\"> 3개월\n");
      out.write("          </label>\n");
      out.write("          <label class=\"btn btn-dark btn-6month\">\n");
      out.write("            <input type=\"radio\" name=\"pointMonth\" id=\"point-6month\" value=\"6\"> 6개월\n");
      out.write("          </label>\n");
      out.write("          <label class=\"btn btn-dark btn-12month\">\n");
      out.write("            <input type=\"radio\" name=\"pointMonth\" id=\"point-12month\" value=\"12\"> 12개월\n");
      out.write("          </label>\n");
      out.write("          <label class=\"btn btn-dark btn-total-terms\">\n");
      out.write("            <input type=\"radio\" name=\"pointMonth\" id=\"point-total-terms\" value=\"0\"> 전체\n");
      out.write("          </label>\n");
      out.write("          <script>\n");
      out.write("           \t$(function(){\n");
      out.write("           \t\tvar pointMonth = \"");
      out.print( pointMonth );
      out.write("\";\n");
      out.write("           \t\t$.each($(\"#pointMonthWrapper input\"), function(index, item){\n");
      out.write("           \t\t\tif($(item).val() == pointMonth){\n");
      out.write("           \t\t\t\t$(item).prop(\"checked\", \"checked\");\n");
      out.write("           \t\t\t}\n");
      out.write("           \t\t});\n");
      out.write("           \t});\n");
      out.write("           </script>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-md-12 point-content1\">\n");
      out.write("          <table class=\"table container mt-3\">\n");
      out.write("            <thead>\n");
      out.write("              <tr>\n");
      out.write("                <th scope=\"col\">상태</th>\n");
      out.write("                <th scope=\"col\">내용</th>\n");
      out.write("                <th scope=\"col\">날짜</th>\n");
      out.write("                <th scope=\"col\">적립금</th>\n");
      out.write("              </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            \t");
 if(pList.isEmpty()){ 
      out.write("\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t<td colspan=\"4\">존재하는 게시글이 없습니다.</td>\n");
      out.write("\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t");
 }else{ 
      out.write("\n");
      out.write("\t\t\t\t\t");
 for(Point point : pList){ 
      out.write("\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print( point.getPointStatus() =='A' ? "입금" : "출금" );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print( point.getPointDetailNm() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print( point.getPointUpdateDt() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print( point.getPoint() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t\t");
 } 
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("          </table>\n");
      out.write("          \n");
      out.write("\t          <!-- 페이징바 -->\n");
      out.write("\t        <div style=\"clear: both;\">\n");
      out.write("\t            <ul class=\"pagination\">\n");
      out.write("\t            \t");
 if(currentPage > 1) { 
      out.write("\n");
      out.write("\t                <li class=\"page-item\">\n");
      out.write("\t                \t<!-- 맨 처음으로(<<) -->\n");
      out.write("\t                    <a class=\"page-link page-first\"\n");
      out.write("\t                    \t href=\"");
      out.print( request.getContextPath() );
      out.write("/member/pointDetail?currentPage=1&pointInOut=");
      out.print(pointInOut );
      out.write("&pointMonth=");
      out.print(pointMonth );
      out.write("\">\n");
      out.write("\t                    \t &lt;&lt;</a>\n");
      out.write("\t                </li>\n");
      out.write("\t                \n");
      out.write("\t                <li class=\"page-item\">\n");
      out.write("\t                \t<!-- 이전으로(<) -->\n");
      out.write("\t                  \t\t<a class=\"page-link page-pre\"\n");
      out.write("\t                  \t\t\thref=\"");
      out.print( request.getContextPath() );
      out.write("/member/pointDetail?currentPage=");
      out.print( currentPage-1 );
      out.write("&pointInOut=");
      out.print(pointInOut );
      out.write("&pointMonth=");
      out.print(pointMonth );
      out.write("\">\n");
      out.write("\t                  \t\t\t&lt;</a>\n");
      out.write("\t                </li>\n");
      out.write("\t                ");
 } 
      out.write("\n");
      out.write("\t                \n");
      out.write("\t                <!-- 10개의 페이지 목록 -->\n");
      out.write("\t                ");
 for(int p = startPage; p <= endPage; p++){ 
      out.write("\n");
      out.write("\t                \t");
 if(p == currentPage) { 
      out.write("\n");
      out.write("\t\t                <li class=\"page-item\">\n");
      out.write("\t\t                    <a class=\"page-link page-now\">");
      out.print( p );
      out.write("</a>\n");
      out.write("\t\t                </li>\n");
      out.write("\t                \t");
 } else{ 
      out.write("\n");
      out.write("\t               \t\t<li class=\"page-item\">\n");
      out.write("\t                    \t<a class=\"page-link page-other\"\n");
      out.write("\t                    \t href=\"");
      out.print( request.getContextPath() );
      out.write("/member/pointDetail?currentPage=");
      out.print( p );
      out.write("&pointInOut=");
      out.print(pointInOut );
      out.write("&pointMonth=");
      out.print(pointMonth );
      out.write("\">\n");
      out.write("\t                    \t ");
      out.print( p );
      out.write("</a>\n");
      out.write("\t                \t</li>\n");
      out.write("\t                \t");
 } 
      out.write("\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\n");
      out.write("\t                \n");
      out.write("\t                <!-- 다음 페이지로(>) -->\n");
      out.write("\t                ");
 if(currentPage < maxPage){ 
      out.write("\n");
      out.write("\t                <li class=\"page-item\">\n");
      out.write("\t                    <a class=\"page-link page-next\"\n");
      out.write("\t                     href=\"");
      out.print( request.getContextPath() );
      out.write("/member/pointDetail?currentPage=");
      out.print( currentPage+1 );
      out.write("&pointInOut=");
      out.print(pointInOut );
      out.write("&pointMonth=");
      out.print(pointMonth );
      out.write("\">\n");
      out.write("\t                     &gt;</a>\n");
      out.write("\t                </li>\n");
      out.write("\t                \n");
      out.write("\t                <!-- 맨 끝으로(>>) -->\n");
      out.write("\t                <li class=\"page-item\">\n");
      out.write("\t                    <a class=\"page-link page-end\"\n");
      out.write("\t                     href=\"");
      out.print( request.getContextPath() );
      out.write("/member/pointDetail?currentPage=");
      out.print( maxPage );
      out.write("&pointInOut=");
      out.print(pointInOut );
      out.write("&pointMonth=");
      out.print(pointMonth );
      out.write("\">\n");
      out.write("\t                     &gt;&gt;</a>\n");
      out.write("\t                </li>\n");
      out.write("\t                ");
 }
      out.write("\n");
      out.write("\t                \n");
      out.write("\t            </ul>\n");
      out.write("\t        </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  ");
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
      out.write("\n");
      out.write("  \n");
      out.write("  <script>\n");
      out.write("  \t$(function(){\n");
      out.write("  \t\t\n");
      out.write("  \t\t$(\"input[name='pointInOut']\").on(\"click\", function(){\n");
      out.write("  \t\t\tvar pointMonth = $(\"input[name='pointMonth']:checked\").val();\n");
      out.write("  \t\t\tlocation.href=\"");
      out.print( request.getContextPath() );
      out.write("/member/pointDetail?pointInOut=\" + $(this).val() + \"&pointMonth=\" + pointMonth;\n");
      out.write("  \t\t});\n");
      out.write("  \t\t\n");
      out.write("  \t\t$(\"input[name='pointMonth']\").on(\"click\", function(){\n");
      out.write("  \t\t\tvar pointInOut = $(\"input[name='pointInOut']:checked\").val();\n");
      out.write("  \t\t\tlocation.href=\"");
      out.print( request.getContextPath() );
      out.write("/member/pointDetail?pointInOut=\" + pointInOut + \"&pointMonth=\" + $(this).val();\n");
      out.write("  \t\t});\n");
      out.write("\n");
      out.write("  \t});\n");
      out.write("  </script>\n");
      out.write("</body>\n");
      out.write("\n");
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
