<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
    <%@ include file="session_start.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Index/User</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="./css/public.css">
</head>
<body>
<div class="user-header">
    <a href="#" data-target="#mySet" data-toggle="modal" ><img src="img/guest.png"></a>
</div>

<!-- Modal -->
<div class="modal fade" id="mySet" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
            </div>
            <div class="modal-body">
                <form action="Servlet/ChangePWDServlet" method="post" id="change_pwd">
                    <div class="form-group">
                        <label for="old-pass">旧密码</label>
                        <input type="text" class="form-control" id="old-pass" name="old_pass" placeholder="旧密码">
                    </div>
                    <div class="form-group">
                        <label for="new-pass">新密码</label>
                        <input type="text" class="form-control" id="new-pass" name="new_pass" placeholder="新密码">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" onclick="change_pwd.submit()">保存</button>
            </div>
        </div>
    </div>
</div>

<a href="Servlet/LoginOutServlet" title="登出用户"><i class="fa fa-power-off fa-2x" style="float: right;padding: 15px;z-index: 999" id="power-off"></i></a>
<a href="./upload.jsp" title="上传图片"><i class="fa fa-upload fa-2x" style="float: right;padding: 15px 0 0 15px;z-index: 999" id="upload-pic"></i></a>
<a href="DisplayServlet" title="看图模式"><i class="fa fa-image fa-2x" style="float: right;padding: 15px 0 0 0;z-index: 999" id="pic-look"></i></a>
<div class="container" style="padding-top:10px; ">
    <span style="color:#ccc;font-size: 26px;" id="nowYM"></span>
    <div class="col-xs-12">
    <%
    String strLength=String.valueOf(request.getAttribute("length"));
    int intLength=Integer.parseInt(strLength);
    ArrayList iid=(ArrayList)request.getAttribute("iid");
    ArrayList uptime=(ArrayList)request.getAttribute("uptime");
    ArrayList status=(ArrayList)request.getAttribute("status");
    ArrayList url=(ArrayList)request.getAttribute("url");
    
    for(int i=0;i<intLength;i++){%>
    	<div class="user-basic">
            <img src="<%=url.get(i) %>" width="200px" style="float: left;">

            <div style="padding-left: 230px;line-height: 40px;">
                <div>图片编号&nbsp;:&nbsp;<span><%=iid.get(i) %></span></div>
                <div>上传时间&nbsp;:&nbsp;<span><%=uptime.get(i) %></span></div>
                <div>图片状态&nbsp;:&nbsp;<span><%=status.get(i) %></span></div><a href="Servlet/EditPicStatusServlet?iid=<%=iid.get(i) %>&status=1">启用</a>&nbsp;&nbsp;&nbsp;<a href="Servlet/EditPicStatusServlet?iid=<%=iid.get(i) %>&status=0">禁用</a>
                <div>图片地址&nbsp;:&nbsp;<span><%=url.get(i) %></span></div>
                <a href="Servlet/DeletePicServlet?iid=<%=iid.get(i) %>">删除</a>
            </div>
        </div>
    <%}
    %>
    <div style="text-align:center;padding:5px;margin:3px;"><i class="fa fa-spinner fa-spin"></i>&nbsp;Loading...</div>
    </div>
</div>
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/delayDisplay.js"></script>
<script type="text/javascript">
    window.onload=function(){
    	delayDisplay(5,"user-basic",1500);
        getTime("#nowYM");
    }
    function getTime(id){
        var date=new Date();
        var str=date.getFullYear()+"-";
        var month=date.getMonth()+1;
        if(month<10){
            str+="0"+month;
        }else{
            str+=month;
        }
        $(id).html(str);
    }
</script>
</body>
</html>