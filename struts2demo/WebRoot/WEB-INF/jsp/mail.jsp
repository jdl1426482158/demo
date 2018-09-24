<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>Email Form</title>
</head>
<body>
	<em>The form below uses Google's SMTP server. So you need to enter
		a gmail username and password </em>
	<form action="test/mail" method="post">
		<label for="from">From</label><br /> 
		<input type="text" name="from" /><br />
		<label for="password">Password</label><br />
		<input type="password" name="password" /><br />
		<label for="to">To</label><br /> <input type="text" name="to" /><br /> 
		<label for="subject">Subject</label><br />
		<input type="text" name="subject" /><br />
		<label for="body">Body</label><br />
		<input type="text" name="body" /><br />
		<input type="submit"
			value="Send Email" />
	</form>
</body>
</html>