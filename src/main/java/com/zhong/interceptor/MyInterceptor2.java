package com.zhong.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor2 extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj,
			ModelAndView modelandview) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(httpservletrequest, httpservletresponse, obj, modelandview);
	}

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse,
			Object obj, Exception exception) throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(httpservletrequest, httpservletresponse, obj, exception);
	}
}
