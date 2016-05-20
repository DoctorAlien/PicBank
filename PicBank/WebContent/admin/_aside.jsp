<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!--左边导航-->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="../img/guest.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>
						<%=request.getSession().getAttribute("username")%>
					</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <ul class="sidebar-menu">
                <li class="header">导航</li>
                <li class="">
                    <a href="DashBoardServlet">
                        <i class="fa fa-dashboard"></i> <span>控制面板</span>
                    </a>
                </li>
                <li class="">
                    <a href="AdminPicListServlet">
                        <i class="fa fa-picture-o"></i> <span>图库</span>
                    </a>
                </li>
                <li class="">
                    <a href="AdminUserListServlet">
                        <i class="fa fa-user"></i> <span>用户列表</span>
                    </a>
                </li>

                <!--<li class="">-->
                    <!--<a href="message.html">-->
                        <!--<i class="fa fa-pencil-square-o"></i> <span>通告</span>-->
                    <!--</a>-->
                <!--</li>-->
                <!--<li class="">-->
                    <!--<a href="feedback.html">-->
                        <!--<i class="fa fa-info-circle"></i> <span>反馈意见</span>-->
                    <!--</a>-->
                <!--</li>-->
                <li class="">
                    <a href="setting.jsp">
                        <i class="fa fa-cog"></i> <span>设置</span>
                    </a>
                </li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>