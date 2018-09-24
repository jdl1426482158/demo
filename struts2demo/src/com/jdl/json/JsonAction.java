/*
 * copyright 下午12:59:02
 *
 */
package com.jdl.json;

import com.jdl.entity.ResultEntity;

/**
 * 
 * 
 * @author jdl
 * 
 * date: 2018年9月24日
 *
 */
public class JsonAction {
	
	private String param;
	
	private ResultEntity result;
	
	/**
	 * @return the param
	 */
	public String getParam() {
		return param;
	}

	/**
	 * @param param the param to set
	 */
	public void setParam(String param) {
		this.param = param;
	}

	/**
	 * @return the result
	 */
	public ResultEntity getResult() {
		return result;
	}


	public String json(){
		System.out.println(param);
		if(param==null)
			return "ajax";
		
		//报异常的话，就会返回异常网页
		if(result==null)
			result = new ResultEntity();
		
		result.setName("你的名字");
		return "json";
	}
}
