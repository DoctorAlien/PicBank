<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="session_start.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Index/Upload</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="./css/public.css">
<script src="js/jquery-2.2.1.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</head>
<body>
<div id="header">
    <span class="index-title">PicBank</span>
    <span style="float: right;">
        <a href="DisplayServlet">UserCenter</a>
    </span>
</div>
<div id="content">
    <form action="Servlet/UploadServlet" enctype="multipart/form-data" method="post">
    	<label for="uploadFile">点击选择图片</label>
    	<input type="file" id="uploadFile" name="uploadFile" style="display:none">
        <input type="submit" class="btn btn-primary" value="上传">
     </form>
</div>
</body>
</html>