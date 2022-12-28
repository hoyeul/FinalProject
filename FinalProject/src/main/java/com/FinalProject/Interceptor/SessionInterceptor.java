package com.FinalProject.Interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {	
    
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
       
    	HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");		
		System.out.println("인터셉터 로그인여부:" + id);
		if (id == null){
			try {
				response.sendRedirect(request.getContextPath() +"/login");
			} catch (IOException e) {				 
				e.printStackTrace();
			}
			return false;
		}
		return true;
	} 
    
}
