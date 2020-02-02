/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-02-02 15:11:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.semi.board.model.vo.Board;
import java.util.List;
import com.semi.member.model.vo.PageInfo;
import com.semi.member.model.vo.Member;

public final class boardList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/admin/sideBar.jsp", Long.valueOf(1580656282555L));
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
    _jspx_imports_classes.add("com.semi.member.model.vo.Member");
    _jspx_imports_classes.add("com.semi.board.model.vo.Board");
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

      out.write('\n');
      out.write('\n');

	List<Board> bList = (List<Board>)request.getAttribute("bList");
	PageInfo pInf = (PageInfo)request.getAttribute("pInf");
	String boardType = (String)request.getAttribute("boardType");
	
	int listCount = pInf.getListCount();
	int currentPage = pInf.getCurrentPage();
	int maxPage = pInf.getMaxPage();
	int startPage = pInf.getStartPage();
	int endPage = pInf.getEndPage();
	
	// 검색용 
	String searchKey = request.getParameter("searchKey");
	String searchValue = request.getParameter("searchValue");
	

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"../css/adminPage-list.css\">\n");
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
      out.write("<link rel=\"shortcut icon\" href=\"img/favicon.png\">\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" href=\"img/icon57.png\">\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" href=\"img/icon114.png\">\n");
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
      out.write("/images/logo1-white.png\" id=\"adminTitleImg\">\n");
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
      out.write("<title>온 스터디</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<div id=\"container\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("      <div class=\"row\">\n");
      out.write("\n");
      out.write("        <div class=\"col-md-12\">\n");
      out.write("          <h2 class=\"content-title\">\n");
      out.write("          \t");
if(boardType.equals("F")){ 
      out.write("\n");
      out.write("          \t<span>자유 게시판</span>\n");
      out.write("          \t");
}else if(boardType.equals("S")){ 
      out.write("\n");
      out.write("          \t<span>건의 게시판</span>\n");
      out.write("          \t");
}else if(boardType.equals("D")){ 
      out.write("\n");
      out.write("          \t<span>신고 게시판</span>\n");
      out.write("          \t");
}else{ 
      out.write("\n");
      out.write("          \t<span>잘못된 접근입니다.</span>\n");
      out.write("          \t");
} 
      out.write("\n");
      out.write("          </h2>\n");
      out.write("          <div class=\"board-content\">\n");
      out.write("            <form action=\"boardList\" method=\"get\" class=\"board-form\">\n");
      out.write("\n");
      out.write("              <!-- 카테고리, 검색input, 버튼 -->\n");
      out.write("              <div id=\"search-wrap\">\n");
      out.write("                <button type=\"submit\" class=\"btn form-control orange-hover-btn\" id=\"searchBtn\">검색</button>\n");
      out.write("                <input type=\"hidden\" name=\"boardType\" value=\"");
      out.print(boardType );
      out.write("\">\n");
      out.write("                <input type=\"text\" class=\"form-control input-comment\" placeholder=\"검색어를 입력해 주세요\" id=\"searchBox\" name=\"searchValue\">\n");
      out.write("                <select class=\"form-control\" id=\"selectOption\" name=\"searchKey\">\n");
      out.write("\t\t\t\t\t<option value=\"게시글번호\">게시글번호</option>\n");
      out.write("\t\t\t\t\t<option value=\"제목\">제목</option>\n");
      out.write("\t\t\t\t\t<option value=\"작성자\">작성자</option>\n");
      out.write("\t\t\t\t\t<option value=\"작성일\">작성일</option>\n");
      out.write("\t\t\t\t\t<option value=\"삭제여부\">삭제여부</option>\n");
      out.write("\t\t\t\t\t<option value=\"내용\">내용</option>\n");
      out.write("\t\t\t\t\t");
if(boardType.equals("D")){ 
      out.write("\n");
      out.write("\t\t\t\t\t<option value=\"신고처리상태\">신고처리상태</option>\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\n");
      out.write("                </select>\n");
      out.write("              </div>\n");
      out.write("              <!-- 카테고리, 검색input, 버튼 -->\n");
      out.write("\n");
      out.write("              <!-- 테이블 -->\n");
      out.write("              <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                  <table class=\"table  container table-striped\" id=\"simulate_log\" cellspacing=\"0\" style=\"padding : 0px 0px\" width=\"100%\">\n");
      out.write("                    <thead>\n");
      out.write("                      <tr>\n");
      out.write("                        <th scope=\"col\">게시글 번호</th>\n");
      out.write("                        <th scope=\"col\">제목</th>\n");
      out.write("                        <th scope=\"col\">작성자</th>\n");
      out.write("                        <th scope=\"col\">작성일</th>\n");
      out.write("                        <th scope=\"col\">삭제여부</th>\n");
      out.write("                        ");
if(boardType.equals("D")){ 
      out.write("\n");
      out.write("\t\t\t\t\t\t<th scope=\"col\">신고처리상태</th>\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\n");
      out.write("                      </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                      ");
 if(bList.isEmpty()){ 
      out.write("\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"5\">존재하는 게시글이 없습니다.</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t  ");
 }else{ 
      out.write("\n");
      out.write("\t\t\t\t\t  ");
 for(Board board : bList){ 
      out.write("\n");
      out.write("\t\t\t\t\t\t<tr class=\"tableContent\">\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print( board.getBoardNo() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print( board.getBoardTitle() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print( board.getBoardWriter() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print( board.getBoardModifyDt() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print( board.getBoardStatus() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t");
if(boardType.equals("D")){ 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print( board.getDeclarStatus());
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t");
} 
      out.write("\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t  ");
 } } 
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                  </table>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <!-- 테이블 -->\n");
      out.write("              \n");
      out.write("              <!-- 페이징바 -->\n");
      out.write("\t\t\t<div style=\"clear: both;\">\n");
      out.write("\t\t\t\t<ul class=\"pagination\">\n");
      out.write("\t\t\t\t\t");
 if(currentPage > 1) { 
      out.write("\n");
      out.write("\t\t\t\t\t<li class=\"page-item\">\n");
      out.write("\t\t\t\t\t\t<!-- 맨 처음으로(<<) -->\n");
      out.write("\t\t\t\t\t\t<a class=\"page-link page-first\"\n");
      out.write("\t\t\t\t\t\t\thref=\"");
      out.print( request.getContextPath() );
      out.write("/admin/boardList?boardType=");
      out.print(boardType );
      out.write("&currentPage=1&searchKey=");
      out.print(searchKey);
      out.write("&searchValue=");
      out.print(searchValue);
      out.write("\">\n");
      out.write("\t\t\t\t\t\t\t&lt;&lt;</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<li class=\"page-item\">\n");
      out.write("\t\t\t\t\t\t<!-- 이전으로(<) -->\n");
      out.write("\t\t\t\t\t\t<a class=\"page-link page-pre\"\n");
      out.write("\t\t\t\t\t\t\thref=\"");
      out.print( request.getContextPath() );
      out.write("/admin/boardList?boardType=");
      out.print(boardType );
      out.write("&currentPage=");
      out.print( currentPage-1 );
      out.write("&searchKey=");
      out.print(searchKey);
      out.write("&searchValue=");
      out.print(searchValue);
      out.write("\">\n");
      out.write("\t\t\t\t\t\t\t&lt;</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t<!-- 10개의 페이지 목록 -->\n");
      out.write("\t\t\t\t\t");
 for(int p = startPage; p <= endPage; p++){ 
      out.write("\n");
      out.write("\t\t\t\t\t");
 if(p == currentPage) { 
      out.write("\n");
      out.write("\t\t\t\t\t<li class=\"page-item\"><a class=\"page-link page-now\">");
      out.print( p );
      out.write("</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t");
 } else{ 
      out.write("\n");
      out.write("\t\t\t\t\t<li class=\"page-item\">\n");
      out.write("\t\t\t\t\t\t<a class=\"page-link page-other\"\n");
      out.write("\t\t\t\t\t\t\thref=\"");
      out.print( request.getContextPath() );
      out.write("/admin/boardList?boardType=");
      out.print(boardType );
      out.write("&currentPage=");
      out.print( p );
      out.write("&searchKey=");
      out.print(searchKey);
      out.write("&searchValue=");
      out.print(searchValue);
      out.write("\">\n");
      out.write("\t\t\t\t\t\t\t");
      out.print( p );
      out.write("</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t<!-- 다음 페이지로(>) -->\n");
      out.write("\t\t\t\t\t");
 if(currentPage < maxPage){ 
      out.write("\n");
      out.write("\t\t\t\t\t<li class=\"page-item\"><a class=\"page-link page-next\"\n");
      out.write("\t\t\t\t\t\thref=\"");
      out.print( request.getContextPath() );
      out.write("/admin/boardList?boardType=");
      out.print(boardType );
      out.write("&currentPage=");
      out.print( currentPage+1 );
      out.write("&searchKey=");
      out.print(searchKey);
      out.write("&searchValue=");
      out.print(searchValue);
      out.write("\">\n");
      out.write("\t\t\t\t\t\t\t&gt;</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<!-- 맨 끝으로(>>) -->\n");
      out.write("\t\t\t\t\t<li class=\"page-item\"><a class=\"page-link page-end\"\n");
      out.write("\t\t\t\t\t\thref=\"");
      out.print( request.getContextPath() );
      out.write("/admin/boardList?boardType=");
      out.print(boardType );
      out.write("&currentPage=");
      out.print( maxPage );
      out.write("&searchKey=");
      out.print(searchKey);
      out.write("&searchValue=");
      out.print(searchValue);
      out.write("\">\n");
      out.write("\t\t\t\t\t\t\t&gt;&gt;</a></li>\n");
      out.write("\t\t\t\t\t");
 }
      out.write("\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("  <script>\n");
      out.write("  \t$(function(){\n");
      out.write("  \t\tvar searchKey = \"");
      out.print( searchKey );
      out.write("\";\n");
      out.write("\t\tvar searchValue = \"");
      out.print( searchValue );
      out.write("\";\n");
      out.write("\t\t\n");
      out.write("\t\tif(searchValue != \"null\" && searchKey != \"null\"){\n");
      out.write("\t\t\t$.each($(\"select[name=searchKey] > option\"), function(index, item){\n");
      out.write("\t\t\t\tif($(item).val() == searchKey){\n");
      out.write("\t\t\t\t\t$(item).prop(\"selected\",\"true\");\n");
      out.write("\t\t\t\t} \n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t$(\"input[name=searchValue]\").val(searchValue);\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t$(\"#simulate_log td\").click(function(){\n");
      out.write("\t\t\tvar boardNo = $(this).parent().children().eq(0).text();\n");
      out.write("\t\t\t// 쿼리스트링을 이용하여 get 방식으로 글 번호를 server로 전달\n");
      out.write("\t\t\tlocation.href=\"");
      out.print( request.getContextPath() );
      out.write("/admin/boardDetail?boardNo=\" + boardNo;\n");
      out.write("\t\t\n");
      out.write("\t\t}).mouseenter(function(){\n");
      out.write("\t\t\t$(this).parent().css(\"cursor\", \"pointer\");\n");
      out.write("\t\t\n");
      out.write("\t\t});\n");
      out.write("  \t});\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("</body>\n");
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
