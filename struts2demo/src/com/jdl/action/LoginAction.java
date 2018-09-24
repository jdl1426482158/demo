package com.jdl.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1010553567577930726L;
	private String user;
	private String pwd;
	private String test;

	public String login() {
		System.out.println("用户名: " + user);
		System.out.println("密码: " + pwd);
		return "success";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * 错误总结： java.lang.reflect.InvocationTargetException
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	/**
	 * validate+方法名首字母大写(如果第二个字母大写了，则不用首字母大写)是对方法的验证，
	 * 运行在action方法的前面，若果add*Error则返回input
	 * addFieldError需要配合struts标签才能使用方便
	 *
	 * date: 2018年9月24日 下午5:14:39
	 */
	public void validateLogin() {

		if (user == null && pwd == null) {
			addFieldError("", "");
			return;
		}

		System.out.println("loginValidate");
		if (user == null)
			addFieldError("user", "不能为null");
		else if (pwd == null)
			addFieldError("pwd", "不能为null");
		else if (user.length() == 0 || pwd.length() == 0)
			addFieldError("pwd", "账户或密码为空字符串");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	@Override
	public void validate() {
		System.out.println("validate");
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}
