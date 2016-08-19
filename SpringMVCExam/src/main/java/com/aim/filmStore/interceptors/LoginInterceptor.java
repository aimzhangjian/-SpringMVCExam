package com.aim.filmStore.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.aim.filmStore.domain.Customer;
import com.aim.filmStore.domain.Staff;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		String servletPath=request.getServletPath();
        if(servletPath.contains("/loginHandler")|| servletPath.contains("/regHandler")||servletPath.contains("login")){
        	//放行
             return true;
        }else {
		Customer user=(Customer) request.getSession().getAttribute("user");
			if(user==null){
				//去登陆页面
				request.getRequestDispatcher("/publicJsp/login.jsp").forward(request, response);
			     
			}else {
				
				return true;
				
			}
        }
		
		return false;
	}
}
