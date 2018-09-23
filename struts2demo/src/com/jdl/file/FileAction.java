package com.jdl.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

public class FileAction {
	private File[] file;
	/**
	 * 文件名，前面部分必须同上面变量一直
	 */
	private String[] fileFileName;
	/**
	 * 同理
	 */
	private String[] fileContentType;
	private String destPath;

	/**
	 * 文件上传，不复制保存的话在关闭后，文件就会被删除
	 * 
	 * @return
	 * @throws IOException
	 *
	 * date: 2018年9月23日 下午11:36:53
	 */
	public String upload() throws IOException {
		if (file == null || file.length==0)
			return "file";

		byte[] buffer = new byte[4 * 1024];
		//获取项目路径的磁盘路径
		destPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/resource")+File.separator;
		System.out.println(destPath);
		//以下几个变量都是临时变量
		//文件读入
		FileInputStream in;
		//文件输出流
		FileOutputStream out;
		//需要保存的文件的名字
		File destFile;
		int len;
		System.out.println(destPath);
		//文件上传后生成的是临时文件所以需要保存起来，才能长久存在
		for (int i = 0; i < file.length; i++) {
			in = new FileInputStream(file[i]);
			destFile = new File(destPath + fileFileName[i]);
			out = new FileOutputStream(destFile);

			while ((len = in.read(buffer)) > 0)
				out.write(buffer, 0, len);
			out.flush();
			in.close();
			out.close();
		}
		return "file";
	}

	public String download() {

		return "file";
	}

	/**
	 * @return the file
	 */
	public File[] getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(File[] file) {
		this.file = file;
	}

	/**
	 * @return the fileFileName
	 */
	public String[] getFileFileName() {
		return fileFileName;
	}

	/**
	 * @param fileFileName
	 *            the fileFileName to set
	 */
	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	/**
	 * @return the fileContentType
	 */
	public String[] getFileContentType() {
		return fileContentType;
	}

	/**
	 * @param fileContentType
	 *            the fileContentType to set
	 */
	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

}
