package com.jdl.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction {

	/**
	 * 这是给下载文件的文件名
	 */
	private String fileName;
	private InputStream input;

	public String download() {
		// 若果包含路径的或则不包含.的话就是无效的文件名
		if (fileName == null || fileName.contains("\\") || fileName.contains("/") || !fileName.contains("."))
			return "download";

		// 注意分割字符串是用正则表达式，.在正则表达式中是特殊符号啊
		String[] strs = fileName.split("\\.");
		String fileType = strs[strs.length - 1];

		// 没有相应路径的话返回
		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/resource/" + fileType + "/");
		if (path == null)
			return "download";

		File f = new File(path + fileName);
		// 如果文件不存在也就不能传输了啊
		if (!f.exists())
			return "download";
		try {
			input = new FileInputStream(f);
			return "startDownload";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "download";
		}
	}

	public InputStream getInput() {
		return (InputStream) input;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
