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
<title>ajax</title>
<script type="text/javascript">
	$(function() {
		$("#jquery_ajax").click(function() {
			$.ajax({
				url : "test/json",
				type : "post",
				data : "param=hello",
				dataType : "json",
				success : function(data) {
					alert(data.name);
				}
			});
		});
		$("#jquery_upload").click(function() {
			$("#content").upload("test/json?param=hello");
		});
	});
</script>


</head>

<body>
	<button id="jquery_ajax">jquery_ajax</button>
	<button id="js_ajax">js_ajax</button>
	<button id="jquery_upload">jquery_upload</button>
	<h1 id="content"></h1>
</body>
<script type="text/javascript">
	/* 原始的js的ajax */
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
		xmlhttp.onreadystatechange = function() {
			//每一状态改变都会调用该函数，4表示最后返回状态，200表示成功
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("content").innerText = xmlhttp.responseText;
			} else if (xmlhttp.readyState == 4)
				document.getElementById("content").innerText = "error";
		}
		xmlhttp.open("GET", "test/json?param=hello", true);
		xmlhttp.send();

	/* //post方法就多了一点东西
	xmlhttp.open("POST","test/json",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("fname=Henry&lname=Ford"); */
	}
</script>
</html>
