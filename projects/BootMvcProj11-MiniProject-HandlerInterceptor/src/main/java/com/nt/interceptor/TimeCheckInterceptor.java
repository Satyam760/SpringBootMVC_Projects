package com.nt.interceptor;

import java.time.LocalDateTime;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeCheckInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TimeCheckInterceptor.preHandle()");
		
		if(request.getServletPath().equalsIgnoreCase("/"))
			return true;
		
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		if (hour<9 || hour>17) {
			RequestDispatcher rd =request.getRequestDispatcher("/timeout.jsp");
			rd.forward(request, response);
			return false;
		}
		
		return true;	
		
	}
}
