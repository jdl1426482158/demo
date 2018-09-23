<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$("#jquery_ajax").click(function() {
		$.ajax({
			url : "ajax",
			type : "post",
			data : "data='hello'&str=world",
			success : function(data) {
				alert(data);
			}
		});
	});
</script>


</head>

<body>
	<button id="jquery_ajax">jquery_ajax</button>
	<button id="js_ajax">js_ajax</button>
</body>
<script type="text/javascript">

	var xmlhttp;
	if (window.XMLHttpRequest) {
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	document.getElementById("js_ajax").onclick = function() {
		//简单的get方法
		xmlhttp.open("GET","ajax_info.txt",true);
		xmlhttp.send();
		
		//post方法
		xmlhttp.open("POST","/try/ajax/demo_post2.php",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("fname=Henry&lname=Ford");
	}
</script>
</html>
