/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-02-04 04:56:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.semi.onstudy.model.vo.Onstudy;
import com.semi.member.model.vo.Member;

public final class onstudyDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/admin/sideBar.jsp", Long.valueOf(1580775375827L));
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

      out.write('\n');
      out.write('\n');
	Onstudy onstudy = (Onstudy)request.getAttribute("onstudy"); 
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ko\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  ");
      out.write('\n');
      out.write('\n');

	Member admin = (Member) session.getAttribute("loginMember");
	if(admin == null){
		response.sendRedirect(request.getContextPath());
	}
	String msg = (String)session.getAttribute("msg");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<script>\n");
      out.write("\t");
 if(msg != null) {
      out.write("\n");
      out.write("\t\talert(\"");
      out.print( msg );
      out.write("\");\n");
      out.write("\t\t");
 session.removeAttribute("msg"); 
      out.write('\n');
      out.write('	');
 } 
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\"\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\n");
      out.write("\tintegrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\"\n");
      out.write("\tcrossorigin=\"anonymous\">\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"\n");
      out.write("\tintegrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\"\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\n");
      out.write("\t\n");
      out.write("<link rel=\"shortcut icon\" href=\"");
      out.print(request.getContextPath() );
      out.write("/images/favicon.png\">\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" href=\"");
      out.print(request.getContextPath() );
      out.write("/images/icon57.png\">\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" href=\"");
      out.print(request.getContextPath() );
      out.write("/images/icon114.png\">\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/common.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/adminPage-sideBar.css\">\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://code.jquery.com/jquery-3.3.1.js\"></script>\n");
      out.write("<title>온 스터디</title>\n");
      out.write("<style>\n");
      out.write("\ta{\n");
      out.write("\t\ttext-decoration: none;\n");
      out.write("\t}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<!-- 관리자 페이지 사이드바 메뉴 -->\n");
      out.write("\t<div class=\"sidenav\">\n");
      out.write("\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/logo2-white.png\" id=\"adminTitleImg\">\n");
      out.write("\t\t<p id=\"adminSidebarTitle\">Admin</p>\n");
      out.write("\t\t<hr>\n");
      out.write("\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/admin/memberList\">회원 목록 조회</a>\n");
      out.write("\t\t<hr>\n");
      out.write("\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/admin/onstudyList\">온스터디 목록 조회</a>\n");
      out.write("\t\t<hr>\n");
      out.write("\t\t<p id=\"adminBoardTitle\">게시판</p>\n");
      out.write("\t\t<a href=\"boardList?boardType=F\">-자유게시판</a>\n");
      out.write("\t\t<a href=\"boardList?boardType=S\">-건의게시판</a>\n");
      out.write("\t\t<a href=\"boardList?boardType=D\">-신고게시판</a>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- 관리자 페이지 사이드바 메뉴 -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<script\n");
      out.write("\t\tsrc=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"\n");
      out.write("\t\tintegrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\"\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\n");
      out.write("\t<script\n");
      out.write("\t\tsrc=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"\n");
      out.write("\t\tintegrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\"\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\n");
      out.write("\t\t\n");
      out.write("\t<script>\n");
      out.write("\t\t$(\"#adminTitleImg\").on(\"click\", function(){\n");
      out.write("\t\t\tvar check = confirm(\"메인페이지로 접속하시겠습니까?\");\n");
      out.write("\t\t\tif(check){\n");
      out.write("\t\t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}).mouseenter(function(){\n");
      out.write("\t\t\t$(this).css({\"cursor\" : \"pointer\"});\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("  <link rel=\"stylesheet\" href=\"../css/adminPage-onstudy-info.css\">\n");
      out.write("  <title>온스터디</title>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("  <div id=\"container\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <h2 class=\"content-title\">온스터디 상세 정보</h2>\n");
      out.write("      <div class=\"board-content\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- 테이블 -->\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-md-12\">\n");
      out.write("            <table class=\"table table-bordered container\">\n");
      out.write("              <tbody>\n");
      out.write("                <tr>\n");
      out.write("                  <th>번호</th>\n");
      out.write("                  <td>");
      out.print(onstudy.getOnstudyNo() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                  <th>온스터디명</th>\n");
      out.write("                  <td>");
      out.print(onstudy.getOnstudyTitle() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                  <th>카테고리</th>\n");
      out.write("                  <td>");
      out.print(onstudy.getCategoryNm() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                  <th>참여인원</th>\n");
      out.write("                  <td>");
      out.print(onstudy.getPartiMembers() );
      out.write("명</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                  <th>기간</th>\n");
      out.write("                  <td>");
      out.print(onstudy.getOnstudyStartDt() );
      out.write(' ');
      out.write('~');
      out.write(' ');
      out.print(onstudy.getOnstudyEndDt() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                  <th>참가비</th>\n");
      out.write("                  <td>");
      out.print(onstudy.getOnstudyFee() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                  <th>인증 빈도</th>\n");
      out.write("                  <td>주 ");
      out.print(onstudy.getOnstudyCertifyCount() );
      out.write("회</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                  <th>개설자</th>\n");
      out.write("                  <td><a href=\"memberDetail?memberNo=");
      out.print(onstudy.getMemberNo() );
      out.write('"');
      out.write('>');
      out.print(onstudy.getMemberId() );
      out.write("</a></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                  <th>\n");
      out.write("                  \t삭제 여부(Y : 정상, N : 삭제)\n");
      out.write("                  </th>\n");
      out.write("                  <td>");
      out.print(onstudy.getOnstudyStatus() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("              </tbody>\n");
      out.write("            </table>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- 테이블-->\n");
      out.write("\n");
      out.write("        <!-- 회원정지, 삭제 버튼 -->\n");
      out.write("        <div id=\"btn-area\">\n");
      out.write("\t\t  \n");
      out.write("\t\t  ");
if(onstudy.getOnstudyStatus().equals("Y")){ 
      out.write("\n");
      out.write("\t          <button type=\"button\" class=\"btn form-control orange-hover-btn \" data-toggle=\"modal\"\n");
      out.write("\t            data-target=\"#deleteMember\" id=\"deleteButton\">삭제</button>\n");
      out.write("\t\t  \n");
      out.write("\t\t  ");
}else{ 
      out.write("\n");
      out.write("\t\t  \t  <button type=\"button\" class=\"btn form-control orange-hover-btn \" data-toggle=\"modal\"\n");
      out.write("\t            data-target=\"#reMember\" id=\"reButton\">복구</button>\n");
      out.write("\t\t  ");
} 
      out.write("\n");
      out.write("\n");
      out.write("          <!-- <button type=\"button\" class=\"btn form-control orange-hover-btn\" id=\"completeCorrection\">수정 완료</button> -->\n");
      out.write("\n");
      out.write("          <div class=\"modal fade\" id=\"deleteMember\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("              <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span\n");
      out.write("                      aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                 \t\t 해당 온스터디를 삭제 하시겠습니까?\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                  <button type=\"button\" class=\"btn form-control orange-hover-btn\" data-dismiss=\"modal\" value=\"N\" id=\"deleteBtn\">삭제</button>\n");
      out.write("                  <button type=\"button\" class=\"btn form-control orange-hover-btn\" data-dismiss=\"modal\" id=\"modalBtn\">취소</button>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("          <div class=\"modal fade\" id=\"reMember\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("              <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span\n");
      out.write("                      aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                 \t\t 해당 온스터디를 복구 하시겠습니까?\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                  <button type=\"button\" class=\"btn form-control orange-hover-btn\" data-dismiss=\"modal\" value=\"Y\" id=\"reBtn\">복구</button>\n");
      out.write("                  <button type=\"button\" class=\"btn form-control orange-hover-btn\" data-dismiss=\"modal\" id=\"modalBtn\">취소</button>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("  <script>\n");
      out.write(" \t $(function(){\n");
      out.write("\t\t$(\".modal-footer button:first-child\").on(\"click\", function(){\n");
      out.write("\t\t\tvar status = $(this).val();\n");
      out.write("\t\t\tlocation.href=\"changeOnstudyStatus?onstudyNo=");
      out.print(onstudy.getOnstudyNo() );
      out.write("&status=\" + status;\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("  </script>\n");
      out.write("  \n");
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
