/*
 * copyright 下午10:37:36
 *
 */
package com.jdl.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @author jdl
 * 
 *         date: 2018年9月23日
 *
 */
public class HelloAction extends ActionSupport {
	private String[] params;
	private String param;

	/**
	 * @return the params
	 */
	public String[] getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(String[] params) {
		this.params = params;
	}

	/**
	 * @return the param
	 */
	public String getParam() {
		return param;
	}

	/**
	 * @param param
	 *            the param to set
	 */
	public void setParam(String param) {
		this.param = param;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String test() throws Exception {
		// 输出从浏览器获取到的参数
		if (params != null) {
			System.out.println("params.length:" + params.length);
			for (int i = 0; i < params.length; i++) {
				System.out.println(params[i]);
			}
		}
		System.out.println("param:" + param);

		// 返回需要被那个result来回应处理结果，
		return SUCCESS;
	}

}
