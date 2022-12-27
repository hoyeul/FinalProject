package com.FinalProject.Interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class GradeAdminInterceptor extends HandlerInterceptorAdapter{

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
       
    	HttpSession session = request.getSession();
		String grade = (String) session.getAttribute("sessionGrade");
		if (! "admin".equals(grade)){
			try {
				response.sendRedirect(request.getContextPath() +"/home");
			} catch (IOException e) {				 
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
}
