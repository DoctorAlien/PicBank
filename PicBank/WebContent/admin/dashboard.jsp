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
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-aqua">
                        <div class="inner">
                            <h3>
								<%
								ArrayList imgsCount = (ArrayList)request.getAttribute("imgsCount");
				                out.print(imgsCount.get(0));
								%>
							</h3>

                            <p>图库</p>
                        </div>
                        <div class="icon">
                            <i class="fa fa-question-circle"></i>
                        </div>
                        <a href="AdminPicListServlet" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-green">
                        <div class="inner">
                            <h3>
								<%
								ArrayList usersCount = (ArrayList)request.getAttribute("usersCount");
				                out.print(usersCount.get(0));
								%>
							</h3>

                            <p>用户</p>
                        </div>
                        <div class="icon">
                            <i class="fa fa-user-plus"></i>
                        </div>
                        <a href="AdminUserListServlet" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
        </section>
    </div>
<%@ include file="_footer.jsp"%>