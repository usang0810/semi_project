package com.onstudy.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onstudy.admin.model.service.AdminService;
import com.onstudy.common.ExceptionForward;
import com.onstudy.member.model.vo.Member;
import com.onstudy.member.model.vo.PageInfo;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();

		String contextPath = request.getContextPath();

		String command = uri.substring((contextPath + "/admin").length());

		String path = null;
		RequestDispatcher view = null;
		String msg = null;

		AdminService adminService = new AdminService();
		
		// 회원 목록
		if(command.equals("/memberList")) {
			
			String condition = null;
			if(request.getParameter("condition") != null) {
				condition = request.getParameter("condition");
			}
			
			String content = null;
			if(request.getParameter("content") != null){
				content = request.getParameter("content");
			}
			
			try {
				System.out.println("condition : " + condition);
				System.out.println("content : " + content);
				// 조건에 맞는 회원 수 조회
				int mListCount = adminService.getMemberListCount(condition, content);
				System.out.println("회원 수 : " + mListCount);
				
				int limit = 10; // 한 페이지에 보여질 게시글의 수
				int pagingBarSize = 10; // 보여질 페이징바의 페이지 개수
				int maxPage = 0; // 전체 페이지의 수 (== 마지막 페이지)
				int startPage = 0; // 페이징바 시작 페이지 번호
				int endPage = 0; // 페이징바 끝 페이지 번호
				int currentPage = 1; // 현재 페이지, default = 1
				if(request.getParameter("currentPage") != null) {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
				// maxPage - 총 페이지 수(== 마지막 페이지)
				maxPage = (int)Math.ceil( ( (double)mListCount / limit ) );
				
				startPage = (currentPage - 1) / pagingBarSize * pagingBarSize + 1;
				
				// endPage - 페이징바의 끝 페이지 번호
				endPage = startPage + pagingBarSize - 1;
				if(maxPage <= endPage) {
					endPage = maxPage;
				}
				
				PageInfo pInf = new PageInfo(mListCount, limit, pagingBarSize, currentPage, maxPage, startPage, endPage);
				List<Member> mList = adminService.selectMemberList(condition, content, currentPage, limit);
				
				request.setAttribute("pInf", pInf);
				request.setAttribute("mList", mList);
				

				path = "/WEB-INF/views/admin/memberList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "회원 목록 출력", e);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
