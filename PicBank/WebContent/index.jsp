<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页-登陆注册</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="./css/public.css">
<script src="./js/jquery-2.2.1.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</head>
<body>
<div class="index-login">
    <div class="index-login-main">
        <div id="login-title">
            <h1 style="font-size: 4em">PicBank</h1>
        </div>
        <div class="login-main-body">
            <div class="tab-title">
                <a href="#register" class="view-part" id="btn-rigister-top">注册</a>
                <a href="#login" id="btn-login-top">登陆</a>
            </div>
            <div id="register" style="display:block;">
                <form id="form-reg" action="Servlet/RegisterServlet" method="post">
                    <div class="form-ctrl-login">
                        <div class="form-reg-style">
                            <input type="text" class="form-control" id="reg-name" name="reg_name" placeholder="用户名">
                        </div>
                        <div class="form-reg-style">
                            <input type="password" class="form-control" id="reg-pass" name="reg_pass" placeholder="密码">
                        </div>
                    </div>
                    <input type="submit" class="btn btn-info btn-lg btn-block" value="注册PicBank">
                </form>

            </div>
            <div id="login" style="display: none">
                <form id="form-login" action="Servlet/LoginServlet" method="post">
                    <div  class="form-ctrl-login">
                        <div class="form-reg-style">
                            <input type="text" class="form-control" id="login-name" name="login_name" placeholder="用户名">
                        </div>
                        <div class="form-reg-style">
                            <input type="password" class="form-control" id="login-pass" name="login_pass" placeholder="密码">
                        </div>
                    </div>
                    <input type="submit" class="btn btn-info btn-lg btn-block" value="登陆PicBank">
                </form>

            </div>
        </div>
    </div>
</div>
<script>
    function registerClick(){
        $('#btn-rigister-top').addClass('view-part');
        $('#btn-login-top').removeClass('view-part');
        $('#register').css('display','block');
        $("#login").css('display','none');
    };
    function loginClick(){
        $('#btn-login-top').addClass('view-part');
        $('#btn-rigister-top').removeClass('view-part');
        $('#login').css('display','block');
        $("#register").css('display','none');
    };
    window.onload=function(){
        if(window.location.hash=="#register"){
            registerClick();
        }else if(window.location.hash=="#login"){
            loginClick();
        }
    };
    $('#btn-rigister-top').click(function(){
        registerClick();
    });
    $('#btn-login-top').click(function(){
        loginClick();
    });
</script>

</body>
</html>