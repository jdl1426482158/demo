package com.jdl.filter;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Servlet Filter implementation class HelloWorldFilter
 */
public class HelloWorldFilter implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3802629879501442444L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//一般都要在struts中增加默认的拦截器
		//默认拦截器功能包括传递参数，文件上传等
		//先走拦截器，然后invoke唤醒action，之后再回到拦截器
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		if (session.get("user") == null)
			return "login";
		else
			return invocation.invoke();
	}
}
