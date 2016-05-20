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
<!--<a href="./upload.jsp"><i class="fa fa-upload fa-2x" style="float: right;padding: 15px 0 15px 0;z-index: 999" id="upload-pic"></i></a>-->

<a href="./upload.jsp" title="上传图片"><i class="fa fa-upload fa-2x" style="float: right;padding: 15px 0 0 15px;z-index: 999" id="upload-pic"></i></a>
<a href="DisplayBasicServlet" title="编辑模式"><i class="fa fa-edit fa-2x" style="float: right;padding: 15px 0 0 0;z-index: 999" id="pic-edit"></i></a>
<div class="container" style="padding-top:10px; ">
    <div role="main">
        <span style="color:#ccc;font-size: 26px;" id="nowYM"></span>
        <ul class="tiles-wrap animated" id="layout-img">
            
            <%
            //if(request.getAttribute("length")!=null){
            	String strLength=String.valueOf(request.getAttribute("length"));
                int intLength=Integer.parseInt(strLength);
                ArrayList imgList = (ArrayList)request.getAttribute("images");
                for(int i=0;i<intLength;i++)
                {%>
                	<li>
                		<img src=" <%=imgList.get(i)%>" width='255' data-toggle='popover' data-placement='bottom' data-content="<%=imgList.get(i)%>">
                	</li>
                <%}
            %>
        </ul>
    </div>
</div>
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/wookmark.min.js"></script>
<script type="text/javascript">
    window.onload=function(){
        var wookmark1 = new Wookmark('#layout-img', {
            //outerOffset: 5, //网格距离父元素的距离
            itemWidth: 255 // 网格宽度
        });
        $("[data-toggle='popover']").popover();
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