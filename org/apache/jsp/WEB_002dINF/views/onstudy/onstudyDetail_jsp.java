/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-02-03 02:53:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.onstudy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.semi.onstudy.model.vo.Onstudy;
import com.semi.member.model.vo.Member;

public final class onstudyDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/onstudy/../common/footer.jsp", Long.valueOf(1580687082435L));
    _jspx_dependants.put("/WEB-INF/views/onstudy/../common/loginedHeader.jsp", Long.valueOf(1580698249394L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.semi.onstudy.model.vo.Onstudy");
    _jspx_imports_classes.add("java.util.List");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	
	//List<Onstudy> dList = (List<Onstudy>)request.getAttribute("dList");
	Onstudy onstudy = (Onstudy)request.getAttribute("onstudy");
	List<Onstudy> sameList = (List<Onstudy>)request.getAttribute("sameList");
	
	int check = (Integer)request.getAttribute("check");
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("    <head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"img/favicon.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" href=\"img/icon57.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" href=\"img/icon114.png\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/header.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/common.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/onstudyDetail.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("    <title>온스터디</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
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
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"menu-list\">학습노트</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"sub-menu-list\">학습노트 검색</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"sub-menu-list\">학습노트 만들기</a></li>\r\n");
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
      out.write("\t\t\t<a href=\"#\" class=\"bell-setting-btn\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/bell-off.png\" alt=\"알람벨버튼\"></a>\r\n");
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/mypage\"\tclass=\"bell-setting-btn\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/setting-off.png\" alt=\"세팅버튼\"></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"mypage-btn-list\">\r\n");
      out.write("\t\t\t<a href=\"#\">학습노트 관리</a>\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"container\" style=\"color:#333333;\">\r\n");
      out.write("          <div class=\"container-fluid container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("              <div class=\"col-md-12\">\r\n");
      out.write("                <div class=\"content-title\">\r\n");
      out.write("                  온스터디\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("              <div class=\"col-md-12\">\r\n");
      out.write("                <div class=\"jumbotron\">\r\n");
      out.write("                  <h3>\r\n");
      out.write("                    <p>");
      out.print(onstudy.getOnstudyTitle() );
      out.write("&nbsp;<span class=\"badge dDay\">D-");
      out.print(onstudy.getOnstudyDday() );
      out.write("</span></p>\r\n");
      out.write("                    <p class=\"badge badge-pill badge-secondary\">#");
      out.print(onstudy.getCategoryNm() );
      out.write("</p>\r\n");
      out.write("                  </h3>\r\n");
      out.write("                  <p>\r\n");
      out.write("                    <b>참여 인원</b>&nbsp;<span>");
      out.print(onstudy.getMemberCount() );
      out.write("</span>명\r\n");
      out.write("                  </p>\r\n");
      out.write("                  <p>\r\n");
      out.write("                    <b>­기간</b>&nbsp;<span>");
      out.print(onstudy.getOnstudyStartDt() );
      out.write(' ');
      out.write('~');
      out.write(' ');
      out.print(onstudy.getOnstudyEndDt() );
      out.write("</span> (");
      out.print(onstudy.getOnstudyWeeks());
      out.write("주)\r\n");
      out.write("                  </p>\r\n");
      out.write("                  <p>\r\n");
      out.write("                    <b>인증 횟수</b>&nbsp;주 <span>");
      out.print(onstudy.getOnstudyCertifyCount() );
      out.write("</span>회 (총 ");
      out.print(onstudy.getTotalCertifyCount() );
      out.write("회)\r\n");
      out.write("                  </p>\r\n");
      out.write("                  <p>\r\n");
      out.write("                    <b>참가비 금액</b>&nbsp;<span>");
      out.print(onstudy.getOnstudyFee());
      out.write("</span>원\r\n");
      out.write("                  </p>\r\n");
      out.write("                  <br>\r\n");
      out.write("                  <h5>온스터디 진행방식</h5><hr>\r\n");
      out.write("                  <p>\r\n");
      out.write("                    <textarea class=\"form-control\" rows=\"5\" style=\"resize:none; background-color:white;\" readonly></textarea>\r\n");
      out.write("                  </p>\r\n");
      out.write("                  <h5>인증시 주의사항</h5><hr>\r\n");
      out.write("                  <p>\r\n");
      out.write("                    <textarea class=\"form-control\" rows=\"5\" style=\"resize:none; background-color:white;\" readonly></textarea>\r\n");
      out.write("                  </p>\r\n");
      out.write("                  <h5>추가 주의사항</h5><hr>\r\n");
      out.write("                  <p>\r\n");
      out.write("                    <textarea class=\"form-control\" rows=\"5\" style=\"resize:none; background-color:white;\" readonly>");
if(onstudy.getOnstudyAddComment()!=null) { 
      out.print(onstudy.getOnstudyAddComment());
} 
      out.write("\r\n");
      out.write("                    </textarea>\r\n");
      out.write("                  </p>\r\n");
      out.write("                  <h5>이 온스터디와 동시에 할 수 없어요</h5><hr>\r\n");
      out.write("\t\t\t\t\t");
if(sameList!=null) { 
      out.write("\r\n");
      out.write("                  <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("                      <div class=\"row\">\r\n");
      out.write("                      <!-- for문 사용 -->\r\n");
      out.write("\t\t\t\t\t\t");
for(Onstudy sameOnstudy : sameList) { 
      out.write("\r\n");
      out.write("                        <div class=\"col-md-4\">\r\n");
      out.write("                          <div class=\"card\">\r\n");
      out.write("                            <img class=\"mb-3\" alt=\"온스타일 이미지\" src=\"");
if(sameOnstudy.getThumbnail() != null) { 
      out.print(request.getContextPath());
      out.write("/resources/onstudyThumbnails/");
      out.print(sameOnstudy.getThumbnail());
      out.write(' ');
} else { 
      out.print(request.getContextPath());
      out.write("/resources/onstudyThumbnails/noimage.png\">\r\n");
      out.write("                            <div class=\"card-block\">\r\n");
      out.write("                              <h5 class=\"card-title\">\r\n");
      out.write("                              ");
      out.print(sameOnstudy.getOnstudyTitle() );
      out.write("\r\n");
      out.write("                              </h5>\r\n");
      out.write("                              <p class=\"card-text\">\r\n");
      out.write("                                <span class=\"badge badge-pill badge-secondary\">#");
      out.print(sameOnstudy.getCategoryNm() );
      out.write("</span><br>\r\n");
      out.write("                                <b>모집 마감</b>&nbsp;&nbsp;");
      out.print(sameOnstudy.getOnstudyDeadlineDt() );
      out.write("<br>\r\n");
      out.write("                                <b>참여 기간</b>&nbsp;&nbsp;");
      out.print(sameOnstudy.getOnstudyStartDt() );
      out.write(' ');
      out.write('~');
      out.write(' ');
      out.print(sameOnstudy.getOnstudyEndDt() );
      out.write(' ');
      out.write('(');
      out.print(sameOnstudy.getOnstudyWeeks() );
      out.write("주)<br>\r\n");
      out.write("                                <b>인증 횟수</b>&nbsp;&nbsp;주 ");
      out.print(sameOnstudy.getOnstudyCertifyCount() );
      out.write("회<br>\r\n");
      out.write("                                <b>참 가 비</b>&nbsp;&nbsp;");
      out.print(sameOnstudy.getOnstudyFee() );
      out.write("원<br>\r\n");
      out.write("                                <!-- <a class=\"btn btn-outline-secondary more-btn\" href=\"#\">수정하기</a> -->\r\n");
      out.write("                              </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                          </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                      </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("\t\t\t");
 }
						}
      out.write("\r\n");
      out.write("                  <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("                      <p id=\"onstudy-button\"  class=\"form-row\" style=\"float: right;\"><br>\r\n");
      out.write("                        <a class=\"btn form-control orange-hover-btn\" id=\"join\" href=\"../onstudy/enter?no=");
      out.print(onstudy.getOnstudyNo());
      out.write("\">참가하기</a>\r\n");
      out.write("                        <a class=\"btn form-control orange-btn\" id=\"cancel\" href=\"../onstudy/cancel?no=");
      out.print(onstudy.getOnstudyNo());
      out.write("\">참가취소</a>\r\n");
      out.write("                      </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
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
      out.write("        <script>\r\n");
      out.write("          \r\n");
      out.write("          $(function(){\r\n");
      out.write("\r\n");
      out.write("            joinButton = ");
      out.print( check );
      out.write(";\r\n");
      out.write("            // check > 0 이면 참가 중임 \r\n");
      out.write("\r\n");
      out.write("            if(joinButton != 0){\r\n");
      out.write("              $(\"#join\").hide();\r\n");
      out.write("              $(\"#cancel\").show();\r\n");
      out.write("            }else{\r\n");
      out.write("              $(\"#join\").show();\r\n");
      out.write("              $(\"#cancel\").hide();\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            $(\"#cancel\").on(\"click\", function(){\r\n");
      out.write("\r\n");
      out.write("              confirm(\"참가 취소하시겠습니까?\\n취소 시 참가비는 반환됩니다.\");\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("          });\r\n");
      out.write("       </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\" integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
