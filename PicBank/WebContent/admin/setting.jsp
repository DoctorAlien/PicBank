<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ include file="_header.jsp"%>
<%@ include file="_aside.jsp"%>
<!--内容部分-->
    <div class="content-wrapper">
        <div class="content-header user-content-header">
            <h1>
                控制面板
                <small>Control</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="DashBoardServlet"><i class="fa fa-dashboard"></i> PicBank</a></li>
                <li class="active">Dashboard</li>
            </ol>
        </div>

        <section class="content">
            <!-- Small boxes (Stat box) -->
            <div class="row">
                <div class="col-xs-6">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">修改密码</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" action="AdminChangePWDServlet" method="post">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="old-pass">旧密码</label>
                                    <input type="text" class="form-control" id="old-pass" name="old_pass" placeholder="旧密码">
                                </div>
                                <div class="form-group">
                                    <label for="new-pass">新密码</label>
                                    <input type="text" class="form-control" id="new-pass" name="new_pass" placeholder="新密码">
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">确认修改</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>
<%@ include file="_footer.jsp"%>