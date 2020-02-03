package com.semi.common.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.ExceptionForward;
import com.semi.onstudy.model.service.OnstudyService;
import com.semi.onstudy.model.vo.Onstudy;


@WebServlet("")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/").length());
		String path = null;
		RequestDispatcher view = null;
		String msg = null;
		
		OnstudyService onstudyService = new OnstudyService();

		try {
			
			List<Onstudy> mainList = onstudyService.selectMainList();
			request.setAttribute("mainList", mainList);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		} catch (Exception e) {

			ExceptionForward.errorPage(request, response, "온스터디 목록 조회", e); 	
		
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
