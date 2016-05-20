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
                            <h3 class="box-title">编辑成员</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" action="AdminUserEditServlet" method="post">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="uid">编号</label>
                                    <input type="text" class="form-control" id="uid" name="uid" value="<%=request.getParameter("uid") %>">
                                </div>
                                <div class="form-group">
                                    <label for="username">用户名</label>
                                    <input type="text" class="form-control" id="username" name="username" value="<%=request.getParameter("username") %>">
                                </div>
                                <div class="form-group">
                                    <label for="password">密码</label>
                                    <input type="text" class="form-control" id="password" name="password" placeholder="密码">
                                </div>
                                 <div class="form-group">
                                    <label for="status">状态</label>
                                    <select class="form-control" id="status" name="status">
                                        <option value="1">启用</option>
                                        <option value="0">禁用</option>
                                    </select>
                                </div> 
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">确认编辑</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>
<%@ include file="_footer.jsp"%>