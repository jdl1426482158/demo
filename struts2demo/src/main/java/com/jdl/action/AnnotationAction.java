/*
 * copyright 下午10:39:01
 *
 */
package com.jdl.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @author jdl
 * 
 *         date: 2018年9月23日
 *
 */
@ParentPackage("struts-default")

/**
 * 不要狗血啊，命名空间必须要以斜杠开头啊,写类名的时候不要有空格啊
 * 注解改变后不起作用的话，可能需要重启才能生效
 * 不需要取web.xml文件中设置init-param
 * 直接通过默认规范来搜索注解action
 * 
 * @author jdl
 * 
 * date: 2018年9月24日
 *
 */
@Namespace("/annotation")

@Results({ @Result(name = "login", location = "/WEB-INF/jsp/annotation.jsp"),
		@Result(name = "error", location = "/WEB-INF/jsp/error.jsp")})

@ExceptionMappings({ @ExceptionMapping(
		exception = "java.lang.NullPointerException", 
		result = "error",
		params={"exception","nullPoint"})
})

/**
 * 注意使用注解的话包名需要使用以action结尾，并继承ActionSupport为宜
 * 
 * 
 * @author jdl
 * 
 * date: 2018年9月24日
 *
 */
public class AnnotationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2104937198965723271L;
	private String param;

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
	@Override
	@Action("index")
	public String execute() {
		return "login";
	}

	@Action(value = "login", results = { @Result(name = "success", location = "/WEB-INF/jsp/success.jsp") })
	public String login() {
		if (param == null)
			throw new NullPointerException("the parameter cann't be null");
		else
			return "success";
	}
}