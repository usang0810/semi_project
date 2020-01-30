/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-01-30 10:38:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.onstudy.onstudy.model.vo.Onstudy;
import com.onstudy.studynote.model.vo.StudyNote;
import com.onstudy.member.model.vo.Member;

public final class memberDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/admin/sideBar.jsp", Long.valueOf(1580294062722L));
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
    _jspx_imports_classes.add("com.onstudy.onstudy.model.vo.Onstudy");
    _jspx_imports_classes.add("com.onstudy.studynote.model.vo.StudyNote");
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
      out.write("\r\n");
      out.write("\r\n");

	Member member = (Member)request.getAttribute("member");
	List<StudyNote> noteList = (List<StudyNote>)request.getAttribute("noteList");
	List<Onstudy> pList = (List<Onstudy>)request.getAttribute("pOnstudyList");
	List<Onstudy> eList = (List<Onstudy>)request.getAttribute("eOnstudyList");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("  <title>온스터디</title>\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("\r\n");

	Member admin = (Member) session.getAttribute("loginMember");
	if(admin == null){
		response.sendRedirect(request.getContextPath());
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
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
      out.write("<link rel=\"shortcut icon\" href=\"img/favicon.png\">\r\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" href=\"img/icon57.png\">\r\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" href=\"img/icon114.png\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/common.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- data table -->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"https://code.jquery.com/jquery-3.3.1.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css\">\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf8\"\r\n");
      out.write("\tsrc=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js\"></script>\r\n");
      out.write("<title>온 스터디</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 관리자 페이지 사이드바 메뉴 -->\r\n");
      out.write("\t<div class=\"sidenav\">\r\n");
      out.write("\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/logo1-white.png\" id=\"adminTitleImg\">\r\n");
      out.write("\t\t<p id=\"adminSidebarTitle\">Admin</p>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/admin/memberList\">회원 목록 조회</a>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t<a href=\"#\">온스터디 목록 조회</a>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t<p id=\"boardTitle\">게시판</p>\r\n");
      out.write("\t\t<a href=\"#\">-자유게시판</a> <a href=\"#\">-건의게시판</a> <a href=\"#\">-신고게시판</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 관리자 페이지 사이드바 메뉴 -->\r\n");
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
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"../css/02.adminPage-member-info.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <!-- 카테고리, 검색input, 버튼 -->\r\n");
      out.write("  <div id=\"container\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <h2 class=\"content-title\">회원 상세 정보</h2>\r\n");
      out.write("      <div class=\"board-content\">\r\n");
      out.write("\r\n");
      out.write("        <!-- 테이블 -->\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-md-12\">\r\n");
      out.write("            <table class=\"table table-bordered container\">\r\n");
      out.write("                  <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>번호</th>\r\n");
      out.write("                      <td>");
      out.print(member.getMemberNo() );
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>아이디</th>\r\n");
      out.write("                      <td>");
      out.print(member.getMemberId() );
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>이름</th>\r\n");
      out.write("                      <td>");
      out.print(member.getMemberNm() );
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>전화번호</th>\r\n");
      out.write("                      <td>");
      out.print(member.getMemberPhone() );
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>학습노트</th>\r\n");
      out.write("                      <td>\r\n");
      out.write("\t                      ");
if(noteList.isEmpty()){ 
      out.write("\r\n");
      out.write("\t                  \t  \t  <span>-</span>\r\n");
      out.write("\t                   \t  ");
}else{ 
      out.write("\r\n");
      out.write("\t                   \t\t  <a href=\"#\">");
      out.print(noteList.get(0).getStudyNoteTitle() );
      out.write("</a>                  \t  \r\n");
      out.write("\t                      ");
} 
      out.write("\r\n");
      out.write("\t                      ");
for(int i=1; i < noteList.size(); i++){ 
      out.write("\r\n");
      out.write("\t                      \t, <a href=\"#\">");
      out.print(noteList.get(i).getStudyNoteTitle() );
      out.write("</a>\r\n");
      out.write("\t                      ");
} 
      out.write("\r\n");
      out.write("                      </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>참여중인 온스터디</th>\r\n");
      out.write("                      <td>\r\n");
      out.write("                      \t  ");
if(pList.isEmpty()){ 
      out.write("\r\n");
      out.write("\t                  \t  \t  <span>-</span>\r\n");
      out.write("                      \t  ");
}else{ 
      out.write("\r\n");
      out.write("\t                   \t\t  <a href=\"#\">");
      out.print(pList.get(0).getOnstudyTitle() );
      out.write("</a>                  \t  \r\n");
      out.write("                      \t  ");
} 
      out.write("\r\n");
      out.write("\t                      ");
for(int i=1; i < pList.size(); i++){ 
      out.write("\r\n");
      out.write("\t                      \t, <a href=\"#\">");
      out.print(pList.get(i).getOnstudyTitle() );
      out.write("</a>\r\n");
      out.write("\t                      ");
} 
      out.write("\r\n");
      out.write("                      </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>참여했던 온스터디</th>\r\n");
      out.write("                      <td>\r\n");
      out.write("                      \t  ");
if(eList.isEmpty()){ 
      out.write("\r\n");
      out.write("                      \t  \t  <span>-</span>\r\n");
      out.write("                      \t  ");
}else{ 
      out.write("\r\n");
      out.write("\t                      \t  <span>");
      out.print(eList.get(0).getOnstudyTitle() );
      out.write("</span>                      \t  \r\n");
      out.write("                      \t  ");
} 
      out.write("\r\n");
      out.write("\t                      ");
for(int i=1; i < eList.size(); i++){ 
      out.write("\r\n");
      out.write("\t                      \t  <span>, ");
      out.print(eList.get(i).getOnstudyTitle() );
      out.write("</span>\r\n");
      out.write("\t                      ");
} 
      out.write("\r\n");
      out.write("                      </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>포인트</th>\r\n");
      out.write("                      <td>");
      out.print(member.getMemberPoint() );
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>가입일</th>\r\n");
      out.write("                      <td>");
      out.print(member.getMemberEnrollDt() );
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>은행명</th>\r\n");
      out.write("                      <td>");
      out.print(member.getBankName() );
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>계좌번호</th>\r\n");
      out.write("                      <td>");
      out.print(member.getMemberAccount() );
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>신고회수</th>\r\n");
      out.write("                      <td>");
      out.print(member.getMemberDeclarCount() );
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>정지여부</th>\r\n");
      out.write("                      <td>");
      out.print(member.getMemberStatus() );
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("              </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("            <!-- 테이블-->\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- 회원정지, 회원복구, 삭제 버튼 -->\r\n");
      out.write("        <div id=\"btn-area\">\r\n");
      out.write("\r\n");
      out.write("\t\t");
if(member.getMemberStatus() == 'Y'){ 
      out.write("\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn form-control orange-hover-btn \" data-toggle=\"modal\" data-target=\"#stopMember\"\r\n");
      out.write("            \tid=\"stopMemberButton\">회원 정지</button>\r\n");
      out.write("\t\t");
}else if(member.getMemberStatus() == 'S'){ 
      out.write("\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn form-control orange-hover-btn \" data-toggle=\"modal\" data-target=\"#reMember\"\r\n");
      out.write("            \tid=\"reMemberButton\">회원 복구</button>\t\t\r\n");
      out.write("\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn form-control orange-hover-btn \" data-toggle=\"modal\" data-target=\"#reMember\"\r\n");
      out.write("            \tid=\"reMemberButton\">회원 복구</button>\r\n");
      out.write("            \r\n");
      out.write("            <button type=\"button\" class=\"btn form-control orange-hover-btn \" data-toggle=\"modal\" data-target=\"#deleteMember\"\r\n");
      out.write("             id=\"deleteMemberButton\">회원 삭제</button>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t  <!-- 회원 정지 모달 -->\r\n");
      out.write("          <div class=\"modal fade\" id=\"stopMember\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("              <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-header\">\r\n");
      out.write("                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span\r\n");
      out.write("                      aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-body\">\r\n");
      out.write("               \t\t이 회원을 정지 시키겠습니까?\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                  <button type=\"button\" class=\"btn form-control orange-hover-btn modal-btn\" data-dismiss=\"modal\" value=\"S\" id=\"stopBtn\">정지</button>\r\n");
      out.write("                  <button type=\"button\" class=\"btn form-control orange-hover-btn modal-btn\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t  <!-- 회원 복구 모달 -->\r\n");
      out.write("          <div class=\"modal fade\" id=\"reMember\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("              <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-header\">\r\n");
      out.write("                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span\r\n");
      out.write("                      aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-body\">\r\n");
      out.write("               \t\t이 회원을 복구 시키겠습니까?\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                  <button type=\"button\" class=\"btn form-control orange-hover-btn modal-btn\" data-dismiss=\"modal\" value=\"Y\" id=\"reBtn\">복구</button>\r\n");
      out.write("                  <button type=\"button\" class=\"btn form-control orange-hover-btn modal-btn\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          \r\n");
      out.write("          <!-- 회원 삭제 모달 -->\r\n");
      out.write("          <div class=\"modal fade\" id=\"deleteMember\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("              <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-header\">\r\n");
      out.write("                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span\r\n");
      out.write("                      aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-body\">\r\n");
      out.write("                \t\t 이 회원을 삭제하시겠습니까?\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                  <button type=\"button\" class=\"btn form-control orange-hover-btn modal-btn\" data-dismiss=\"modal\" value=\"N\" id=\"deleteBtn\">삭제</button>\r\n");
      out.write("                  <button type=\"button\" class=\"btn form-control orange-hover-btn modal-btn\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  <script>\r\n");
      out.write("  \t$(function(){\r\n");
      out.write("  \t\t// 모달 버튼 클릭 시\r\n");
      out.write("  \t\t$(\".modal-footer button:first-child\").on(\"click\", function(){\r\n");
      out.write("  \t\t\tvar status = $(this).val();\r\n");
      out.write("  \t\t\t$.ajax({\r\n");
      out.write("  \t\t\t\turl : \"changeMemberStatus\",\r\n");
      out.write("  \t\t\t\tdata : {\r\n");
      out.write("  \t\t\t\t\tno : ");
      out.print(member.getMemberNo() );
      out.write(",\r\n");
      out.write("  \t\t\t\t\tstatus : status\r\n");
      out.write("  \t\t\t\t},\r\n");
      out.write("  \t\t\t\tdataType : \"text\",\r\n");
      out.write("  \t\t\t\ttype : \"GET\",\r\n");
      out.write("  \t\t\t\tsuccess : function(result){\r\n");
      out.write("  \t\t\t\t\t\r\n");
      out.write("  \t\t\t\t\tvar $btnArea = $(\"#btn-area\");\r\n");
      out.write("  \t\t\t\t\t$btnArea.html(\"\");\r\n");
      out.write("  \t\t\t\t\t\r\n");
      out.write("  \t\t\t\t\tvar $result = \"\";\r\n");
      out.write("  \t\t\t\t\t\r\n");
      out.write("  \t\t\t\t\talert(\"회원 정보 수정 성공\");\r\n");
      out.write("  \t\t\t\t\t\r\n");
      out.write("  \t\t\t\t\tconsole.log(\"result : \" + result);\r\n");
      out.write("  \t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$(\".modal-backdrop\").prop(\"display\", \"none\");\r\n");
      out.write("  \t\t\t\t\tif(result == \"Y\"){\r\n");
      out.write("  \t\t\t\t\t\t");
member.setMemberStatus('Y'); 
      out.write("\r\n");
      out.write("  \t\t\t\t\t\t$result = \"<button type='button' class='btn form-control orange-hover-btn' data-toggle='modal'\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"data-target='#stopMember' id='stopMemberButton'>회원 정지</button>\";\r\n");
      out.write("\t\t\t\t\t\t$btnArea.append($result);\r\n");
      out.write("\r\n");
      out.write("  \t\t\t\t\t}else if(result == \"S\"){\r\n");
      out.write("\t  \t\t\t\t\t");
member.setMemberStatus('S'); 
      out.write("\r\n");
      out.write("\t  \t\t\t\t\t$result = \"<button type='button' class='btn form-control orange-hover-btn' data-toggle='modal'\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"data-target='#reMember' id='reMemberButton'>회원 복구</button>\";\r\n");
      out.write("\t\t\t\t\t\t$btnArea.append($result);\r\n");
      out.write("  \t\t\t\t\t\r\n");
      out.write("  \t\t\t\t\t}else{\r\n");
      out.write("  \t\t\t\t\t\tlocation.href = \"memberList\";\r\n");
      out.write("  \t\t\t\t\t}\r\n");
      out.write("  \t\t\t\t},\r\n");
      out.write("  \t\t\t\terror : function(){\r\n");
      out.write("  \t\t\t\t\talert(\"정보 수정 실패\");\r\n");
      out.write("  \t\t\t\t}\r\n");
      out.write("  \t\t\t});\r\n");
      out.write("  \t\t});\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t});\r\n");
      out.write("  </script>\r\n");
      out.write("  \r\n");
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
