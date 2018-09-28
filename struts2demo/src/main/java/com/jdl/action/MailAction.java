/*
 * copyright 下午6:02:06
 *
 */
package com.jdl.action;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @author jdl
 * 
 *         date: 2018年9月24日
 *
 */
public class MailAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9128284667211285640L;
	private String from;
	private String password;
	private String to;
	private String subject;
	private String body;

	static Properties properties = new Properties();
	static {
		properties.put("mail.smtp.host", "smtp.163.com");
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
	}

	public String execute() {
		// 如果是直接访问则直接跳转到网页
		if (from == null && password == null && to == null && subject == null && body == null)
			return "mail";

		String ret = SUCCESS;
		try {
			// 建立session连接
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			});

			// 设置邮件信息
			MimeMessage message = new MimeMessage(session);
			// 设置mime头的编码
			message.addHeader("Content-Transfer-Encoding", "UTF-8");
			// 设置网页用户名编码,中文别名是发件人的别名
			message.setFrom(new InternetAddress(from, "中文别名", "UTF-8"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			// 设置邮件标题
			message.setSubject(subject);
			// 设置邮件标题,应该使用html格式，直接传输会被当成垃圾邮件
			message.setContent(toHtmlContent(body), "text/html;charset=UTF-8");
			// 设置发送日期
			message.setSentDate(new Date());
			// 发送邮件
			Transport transport = session.getTransport();
			// 连接发送者邮箱服务器
			transport.connect(from, password);
			// 发送邮件
			transport.sendMessage(message, message.getAllRecipients());
			// 关闭连接
			transport.close();
		} catch (Exception e) {
			ret = ERROR;
			e.printStackTrace();
		}
		return ret;
	}

	private String toHtmlContent(String content) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!doctype html><html>");
		buffer.append("<head>");
		buffer.append("<meta charset='UTF-8'>");
		buffer.append("</head>");
		buffer.append("<body>");
		buffer.append("<h1>");
		buffer.append(content);
		buffer.append("</h1>");
		buffer.append("</body>");
		return buffer.toString();
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public static Properties getProperties() {
		return properties;
	}

	public static void setProperties(Properties properties) {
		MailAction.properties = properties;
	}
}
