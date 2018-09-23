package com.jdl.test;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.entities.ResultConfig;

public class LoginAction extends ActionSupport{
	private String user;
	private String pwd;
	private String test;
	
	public String login(){
		System.out.println("用户名: "+user);
		System.out.println("密码: "+pwd);
		return "success";
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
