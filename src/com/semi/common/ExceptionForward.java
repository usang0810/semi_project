package com.semi.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionForward{

	public static void errorPage(HttpServletRequest request, HttpServletResponse response, String errorMsg, Exception e) throws ServletException, IOException{
		String path = "/WEB-INF/views/common/errorPage.jsp";
		request.setAttribute("errorMsg", errorMsg + " 과정에서 오류가 발생하였습니다.");
		e.printStackTrace();
		
		request.getRequestDispatcher(path).forward(request,response);
	}
}