/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-02-02 12:30:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.semi.member.model.vo.Member;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1580646416251L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1580646424079L));
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>온 스터디</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String msg = (String)session.getAttribute("msg");

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
      out.write("\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/favicon.png\">\r\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" href=\"images/icon57.png\">\r\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" href=\"images/icon114.png\">\r\n");
      out.write("\r\n");
      out.write("<!-- 폰트 link -->\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- bootstrap icon link -->\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/76b49c6d9b.js\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("\t\r\n");
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
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath() );
      out.write("/css/common.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath() );
      out.write("/css/intro.css\">\r\n");
      out.write("<title>온 스터디</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<nav\r\n");
      out.write("\t\tclass=\"navbar navbar-expand-md background-navy sticky-top py-2 px-5 m-0\">\r\n");
      out.write("\t\t<a href=\"#\"> <img class=\"img-fluid\" src=\"images/logo2-white.png\"\r\n");
      out.write("\t\t\talt=\"...\" id=\"logo-img\">\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t\t<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\r\n");
      out.write("\t\t\tdata-target=\"#navbarCollapse\" aria-controls=\"navbarCollapse\"\r\n");
      out.write("\t\t\taria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("\t\t\t<i class=\"fas fa-bars\" id=\"navbarCollapse-icon\"></i>\r\n");
      out.write("\t\t</button>\r\n");
      out.write("\t\t<div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\r\n");
      out.write("\t\t\t<ul class=\"navbar-nav mx-auto\">\r\n");
      out.write("\t\t\t\t<li class=\"nav-item mx-3\"><a class=\"nav-link navbar-link\"\r\n");
      out.write("\t\t\t\t\thref=\"#\">소개</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"nav-item mx-3\"><a class=\"nav-link site-header-link\"\r\n");
      out.write("\t\t\t\t\thref=\"#learning-note\">학습 노트</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"nav-item mx-3\"><a class=\"nav-link site-header-link\"\r\n");
      out.write("\t\t\t\t\thref=\"#on-study\">온 스터디</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<a class=\"mx-3\" href=\"member/login\">로그인</a> <a class=\"mx-3\"\r\n");
      out.write("\t\t\t\t\thref=\"#myModal\" data-toggle=\"modal\">회원가입</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 회원가입 모달 -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"myModal\">\r\n");
      out.write("\t\t<div class=\"modal-dialog modal-md\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Modal Header -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\">회원가입 방식을 선택해주세요</h4>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Modal body -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-body mb-3\">\r\n");
      out.write("\t\t\t\t\t<a class=\"btn btn-lg btn-secondary btn-block mb-3\" role=\"button\"\r\n");
      out.write("\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath() );
      out.write("/member/signupForm\" style=\"color: white;\">기존 회원가입</a>\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-lg btn-warning btn-block mb-3\" type=\"submit\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"location.href='#'\" style=\"color: white;\">카카오톡으로\r\n");
      out.write("\t\t\t\t\t\t회원가입</button>\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"location.href='#'\">페이스북으로 회원가입</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Modal footer -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn background-gray\"\r\n");
      out.write("\t\t\t\t\t\tdata-dismiss=\"modal\">Close</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- Modal End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"button-top\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"top-btn\">TOP</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"\r\n");
      out.write("\t\tintegrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\"\r\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"\r\n");
      out.write("\t\tintegrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\"\r\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"\r\n");
      out.write("\t\tintegrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\"\r\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("        function scrollFunction() {\r\n");
      out.write("            if ($(window).scrollTop() >= 200) {\r\n");
      out.write("                $('#button-top').show(0);\r\n");
      out.write("            } else {\r\n");
      out.write("                $('#button-top').hide(0);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        $(function () {\r\n");
      out.write("            scrollFunction();\r\n");
      out.write("            $(window).scroll(function () {\r\n");
      out.write("                scrollFunction();\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            $('#button-top').on({\r\n");
      out.write("                click: function () {\r\n");
      out.write("                    $('html,body').stop().animate({ scrollTop: 0 });\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            // 버튼 클릭 시 경고창\r\n");
      out.write("            $(\".learning-note, .card-body a, .category-list>li\").click(function () {\r\n");
      out.write("                alert(\"로그인이 필요한 기능입니다!\");\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("    <!-- content -->\r\n");
      out.write("    <!-- intro -->\r\n");
      out.write("    <div class=\"position-relative overflow-hidden p-3 p-md-5 text-center\" id=\"intro\">\r\n");
      out.write("        <div class=\"col-md-10 p-lg-5 centered\">\r\n");
      out.write("            <h1 class=\"display-4 font-weight-normal\">On Study에 오신것을 환영합니다!</h1>\r\n");
      out.write("            <p class=\"lead font-weight-normal my-0\">On Study는 특정 주제에 대해 학습자들끼리 모여 학습하는 문화를 활발하게 해줍니다.</p>\r\n");
      out.write("            <p class=\"lead font-weight-normal my-0\">개인 학습자료, 노하우 등을 스터디 그룹을 연계 할 수 있는 서비스를 제공합니다.</p>\r\n");
      out.write("            <p class=\"lead font-weight-normal my-0\">자신만의 학습노트를 만들고 공유하세요! On Study의 모든 학습노트는 오픈되어 있습니다.</p>\r\n");
      out.write("            <p class=\"lead font-weight-normal\">학습노트를 기반으로 한 문제를 풀어보세요!\r\n");
      out.write("                단순한 암기가 잘 안되신다면 다양한 학습방법을 통해 학습하세요.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- learning-note -->\r\n");
      out.write("    <div class=\"position-relative overflow-hidden p-3 p-md-5 text-center\" id=\"learning-note\">\r\n");
      out.write("        <div class=\"col-md-8 p-lg-5 mx-auto my-5\">\r\n");
      out.write("            <h1 class=\"display-4 font-weight-normal\">학습노트를 이용해 보세요!</h1>\r\n");
      out.write("            <p class=\"lead font-weight-normal\">인기가 많은 학습노트를 확인해 보세요.</p>\r\n");
      out.write("            <p class=\"lead font-weight-normal\">마음에 드는 학습노트가 없다면 검색해보세요. 온 스터디는 다양한 학습노트를 제공하고 있습니다.</p>\r\n");
      out.write("            <div class=\" col-md-8 input-group mx-auto\">\r\n");
      out.write("                <div class=\"input-group-prepend\">\r\n");
      out.write("                    <select class=\"form-control\" id=\"search\" name=\"search\">\r\n");
      out.write("                        <option selected>전체</option>\r\n");
      out.write("                        <option>카테고리</option>\r\n");
      out.write("                        <option>제목</option>\r\n");
      out.write("                        <option>작성자</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"Search\">\r\n");
      out.write("                <div class=\"input-group-append\">\r\n");
      out.write("                    <button class=\"btn form-control orange-hover-btn\" type=\"submit\">검색</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- learning-note-list -->\r\n");
      out.write("        <div class=\"contaner text-center\" id=\"ln-list\">\r\n");
      out.write("            <div class=\"col-md-6 learning-note px-0 mx-auto\">\r\n");
      out.write("                <div\r\n");
      out.write("                    class=\"row no-gutters border overflow-hidden flex-md-row mb-3 shadow-sm h-md-250 d-flex justify-content-between\">\r\n");
      out.write("                    <div class=\"p-4 d-flex flex-column text-center\">\r\n");
      out.write("                        <h4 class=\"main-font-color font-border\">카테고리</h4>\r\n");
      out.write("                            <h5>컴퓨터</h5>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"p-4 d-flex flex-row position-static text-center\">\r\n");
      out.write("                        <h3 class=\"flex-fill pt-3 font-border\">자바 용어 모음</h3>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"p-2 d-flex flex-row position-static\">\r\n");
      out.write("                        <i class=\"far fa-thumbs-up learning-note-icon mt-auto\">1,024</i>\r\n");
      out.write("                        <div class=\"ml-auto my-auto\">\r\n");
      out.write("                            <img src=\"images/tower1.PNG\" alt=\"...\" id=\"learning-note-profile-img\"\r\n");
      out.write("                                class=\"rounded-circle\">\r\n");
      out.write("                            <h6>홍길동</h6>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-6 learning-note px-0 mx-auto\">\r\n");
      out.write("                <div\r\n");
      out.write("                    class=\"row no-gutters border overflow-hidden flex-md-row mb-3 shadow-sm h-md-250 d-flex justify-content-between\">\r\n");
      out.write("                    <div class=\"p-4 d-flex flex-column text-center\">\r\n");
      out.write("                        <h4 class=\"main-font-color font-border\">카테고리</h5>\r\n");
      out.write("                            <h5>컴퓨터</h5>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"p-4 d-flex flex-row position-static text-center\">\r\n");
      out.write("                        <h3 class=\"flex-fill pt-3 font-border\">C언어 포인터 용어 정리</h3>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"p-2 d-flex flex-row position-static\">\r\n");
      out.write("                        <i class=\"far fa-thumbs-up learning-note-icon mt-auto\">956</i>\r\n");
      out.write("                        <div class=\"ml-auto my-auto\">\r\n");
      out.write("                            <img src=\"images/flower2.PNG\" alt=\"...\" id=\"learning-note-profile-img\"\r\n");
      out.write("                                class=\"rounded-circle\">\r\n");
      out.write("                            <h6>김유신</h6>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-6 learning-note px-0 mx-auto\">\r\n");
      out.write("                <div\r\n");
      out.write("                    class=\"row no-gutters border overflow-hidden flex-md-row mb-3 shadow-sm h-md-250 d-flex justify-content-between\">\r\n");
      out.write("                    <div class=\"p-4 d-flex flex-column text-center\">\r\n");
      out.write("                        <h4 class=\"main-font-color font-border\">카테고리</h4>\r\n");
      out.write("                            <h5>외국어</h5>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"p-4 d-flex flex-row position-static text-center\">\r\n");
      out.write("                        <h3 class=\"flex-fill pt-3 font-border\">토익 2019년도 기출문제 정리</h3>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"p-2 d-flex flex-row position-static\">\r\n");
      out.write("                        <i class=\"far fa-thumbs-up learning-note-icon mt-auto\">1,300</i>\r\n");
      out.write("                        <div class=\"ml-auto my-auto\">\r\n");
      out.write("                            <img src=\"images/river1.PNG\" alt=\"...\" id=\"learning-note-profile-img\"\r\n");
      out.write("                                class=\"rounded-circle\">\r\n");
      out.write("                            <h6>드링크</h6>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-6 learning-note px-0 mx-auto\">\r\n");
      out.write("                <div\r\n");
      out.write("                    class=\"row no-gutters border overflow-hidden flex-md-row mb-3 shadow-sm h-md-250 d-flex justify-content-between\">\r\n");
      out.write("                    <div class=\"p-4 d-flex flex-column text-center\">\r\n");
      out.write("                        <h4 class=\"main-font-color font-border\">카테고리</h5>\r\n");
      out.write("                            <h5>자동차</h5>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"p-4 d-flex flex-row position-static text-center\">\r\n");
      out.write("                        <h3 class=\"flex-fill pt-3 font-border\">자동차 부품 용어 정리</h3>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"p-2 d-flex flex-row position-static\">\r\n");
      out.write("                        <i class=\"far fa-thumbs-up learning-note-icon mt-auto\">4,128</i>\r\n");
      out.write("                        <div class=\"ml-auto my-auto\">\r\n");
      out.write("                            <img src=\"images/forest1.PNG\" alt=\"...\" id=\"learning-note-profile-img\"\r\n");
      out.write("                                class=\"rounded-circle\">\r\n");
      out.write("                            <h6>차박사</h6>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-6 learning-note px-0 mx-auto\">\r\n");
      out.write("                <div\r\n");
      out.write("                    class=\"row no-gutters border overflow-hidden flex-md-row mb-3 shadow-sm h-md-250 d-flex justify-content-between\">\r\n");
      out.write("                    <div class=\"p-4 d-flex flex-column text-center\">\r\n");
      out.write("                        <h4 class=\"main-font-color font-border\">카테고리</h5>\r\n");
      out.write("                            <h5>과학</h5>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"p-4 d-flex flex-row position-static text-center\">\r\n");
      out.write("                        <h3 class=\"flex-fill pt-3 font-border\">생명과학 용어 정리</h3>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"p-2 d-flex flex-row position-static\">\r\n");
      out.write("                        <i class=\"far fa-thumbs-up learning-note-icon mt-auto\">378</i>\r\n");
      out.write("                        <div class=\"ml-auto my-auto\">\r\n");
      out.write("                            <img src=\"images/tower1.PNG\" alt=\"...\" id=\"learning-note-profile-img\"\r\n");
      out.write("                                class=\"rounded-circle\">\r\n");
      out.write("                            <h6>메딕</h6>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- on study -->\r\n");
      out.write("    <div class=\"position-relative overflow-hidden p-3 p-md-5\" id=\"on-study\" style=\"background-color: lightgray;\">\r\n");
      out.write("        <div class=\"col-md-10 p-lg-5 mx-auto mt-5 text-center\">\r\n");
      out.write("            <h1 class=\"display-4 font-weight-normal\">온 스터디를 이용해 보세요!</h1>\r\n");
      out.write("            <p class=\"lead font-weight-normal\">의지가 부족하신가요? 여럿이서 같이 공부해보면 어떨까요?<br>\r\n");
      out.write("                열심히 한다면 보상까지 얻을 수 있는 온스터디를 해보세요!</p>\r\n");
      out.write("            <p class=\"lead font-weight-normal\">인기가 많은 온 스터디를 확인해 보세요.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- on study list -->\r\n");
      out.write("        <div class=\"album pb-5 \">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                        <div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("                            <div class=\"Thumbnail\">Thumbnail</div>\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                                <p class=\"card-title\">토익 목표점수 달성반</p>\r\n");
      out.write("                                <p class=\"card-text\">\r\n");
      out.write("                                    - 마감날짜 : 2020-01-01(D-10)<br>\r\n");
      out.write("                                    - 인증빈도 : 주 3회<br>\r\n");
      out.write("                                    - 참여자 수 : 20명\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <div class=\"d-flex justify-content-between align-items-center \">\r\n");
      out.write("                                    <div class=\"btn-group\">\r\n");
      out.write("                                        <a class=\"btn btn-sm form-control orange-hover-btn\">자세히</a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                        <div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("                            <div class=\"Thumbnail\">Thumbnail</div>\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                                <p class=\"card-title\">토익 목표점수 달성반</p>\r\n");
      out.write("                                <p class=\"card-text\">\r\n");
      out.write("                                    - 마감날짜 : 2020-01-01(D-10)<br>\r\n");
      out.write("                                    - 인증빈도 : 주 3회<br>\r\n");
      out.write("                                    - 참여자 수 : 20명\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <div class=\"d-flex justify-content-between align-items-center \">\r\n");
      out.write("                                    <div class=\"btn-group\">\r\n");
      out.write("                                        <a class=\"btn btn-sm form-control orange-hover-btn\">자세히</a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                        <div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("                            <div class=\"Thumbnail\">Thumbnail</div>\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                                <p class=\"card-title\">토익 목표점수 달성반</p>\r\n");
      out.write("                                <p class=\"card-text\">\r\n");
      out.write("                                    - 마감날짜 : 2020-01-01(D-10)<br>\r\n");
      out.write("                                    - 인증빈도 : 주 3회<br>\r\n");
      out.write("                                    - 참여자 수 : 20명\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <div class=\"d-flex justify-content-between align-items-center \">\r\n");
      out.write("                                    <div class=\"btn-group\">\r\n");
      out.write("                                        <a class=\"btn btn-sm form-control orange-hover-btn\">자세히</a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                        <div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("                            <div class=\"Thumbnail\">Thumbnail</div>\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                                <p class=\"card-title\">토익 목표점수 달성반</p>\r\n");
      out.write("                                <p class=\"card-text\">\r\n");
      out.write("                                    - 마감날짜 : 2020-01-01(D-10)<br>\r\n");
      out.write("                                    - 인증빈도 : 주 3회<br>\r\n");
      out.write("                                    - 참여자 수 : 20명\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <div class=\"d-flex justify-content-between align-items-center \">\r\n");
      out.write("                                    <div class=\"btn-group\">\r\n");
      out.write("                                        <a class=\"btn btn-sm form-control orange-hover-btn\">자세히</a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                        <div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("                            <div class=\"Thumbnail\">Thumbnail</div>\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                                <p class=\"card-title\">토익 목표점수 달성반</p>\r\n");
      out.write("                                <p class=\"card-text\">\r\n");
      out.write("                                    - 마감날짜 : 2020-01-01(D-10)<br>\r\n");
      out.write("                                    - 인증빈도 : 주 3회<br>\r\n");
      out.write("                                    - 참여자 수 : 20명\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <div class=\"d-flex justify-content-between align-items-center \">\r\n");
      out.write("                                    <div class=\"btn-group\">\r\n");
      out.write("                                        <a class=\"btn btn-sm form-control orange-hover-btn\">자세히</a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                        <div class=\"card mb-4 shadow-sm\">\r\n");
      out.write("                            <div class=\"Thumbnail\">Thumbnail</div>\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                                <p class=\"card-title\">토익 목표점수 달성반</p>\r\n");
      out.write("                                <p class=\"card-text\">\r\n");
      out.write("                                    - 마감날짜 : 2020-01-01(D-10)<br>\r\n");
      out.write("                                    - 인증빈도 : 주 3회<br>\r\n");
      out.write("                                    - 참여자 수 : 20명\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <div class=\"d-flex justify-content-between align-items-center \">\r\n");
      out.write("                                    <div class=\"btn-group\">\r\n");
      out.write("                                        <a class=\"btn btn-sm form-control orange-hover-btn\">자세히</a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- 온스터디 카테고리 목록 -->\r\n");
      out.write("        <div class=\"category-list-wrap container mb-5\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <h2 class=\"recommend-title\">온스터디 카테고리</h2>\r\n");
      out.write("                    <p class=\"recommend-sub-title\">나에게 맞는 카테고리를 찾아보세요.</p>\r\n");
      out.write("                    <ul class=\"category-list list-1\">\r\n");
      out.write("                        <li><a>토익</a></li>\r\n");
      out.write("                        <li><a>중국어</a></li>\r\n");
      out.write("                        <li><a>일본어</a></li>\r\n");
      out.write("                        <li><a>독일어</a></li>\r\n");
      out.write("                        <li><a>코딩</a></li>\r\n");
      out.write("                        <li><a>HTML</a></li>\r\n");
      out.write("                        <li><a>CSS</a></li>\r\n");
      out.write("                        <li><a>Javascript</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <ul class=\"category-list\">\r\n");
      out.write("                        <li><a>토익</a></li>\r\n");
      out.write("                        <li><a>중국어</a></li>\r\n");
      out.write("                        <li><a>일본어</a></li>\r\n");
      out.write("                        <li><a>독일어</a></li>\r\n");
      out.write("                        <li><a>코딩</a></li>\r\n");
      out.write("                        <li><a>HTML</a></li>\r\n");
      out.write("                        <li><a>CSS</a></li>\r\n");
      out.write("                        <li><a>Javascript</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- footer -->\r\n");
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
