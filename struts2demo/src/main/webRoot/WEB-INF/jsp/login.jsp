<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<%-- <%@ include file="/WEB-INF/jsp/showErrMsg.jsp" %> --%>
	
  </head>
  
  <body>
  <!-- 常规的 -->
<!--   <form action="test/login" method="post">
    用户名: <input type="text" name="user" /><br />
    密码: <input type="password" name="pwd" /><br />
    <input type="submit" value="提交" />
    <input type="reset" value="取消" />
    </form> -->
    
    <s:form action="test/login" method="post">
      <s:textfield name="user" label="User" size="20" />
      <s:textfield name="pwd" label="Pwd" size="20" />
      <s:submit name="submit" label="Submit" align="center" />
   </s:form>
    
  </body>
</html>
