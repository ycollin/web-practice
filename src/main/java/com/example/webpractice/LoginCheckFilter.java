package com.example.webpractice;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lombok.val;

@Component
public class LoginCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		val session = ((HttpServletRequest) request).getSession();
		val path = ((HttpServletRequest) request).getRequestURI();
		if (path.startsWith("/login") || path.startsWith("/logout")) { // TODO
			// do nothing
		} else if (session == null) {
			((HttpServletResponse) response).sendRedirect("/login");
		} else if (session.getAttribute("login") == null) {
			((HttpServletResponse) response).sendRedirect("/login");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
