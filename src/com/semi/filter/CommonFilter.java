package com.semi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "encoding", urlPatterns = "/*")
public class CommonFilter implements Filter {

	public CommonFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");

		// response.setContentType("text/html; charset=UTF-8");
		String uri = ((HttpServletRequest) request).getRequestURI();

		if (!uri.substring(uri.lastIndexOf(".") + 1).equals("css")) {
			response.setContentType("text/html; charset=UTF-8");
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
