<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ include file="_header.jsp"%>
<%@ include file="_aside.jsp"%>
<!--内容部分-->
    <div class="content-wrapper">
        <div class="content-header user-content-header">
            <h1>
                用户列表
                <small>UserList</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="DashBoardServlet"><i class="fa fa-dashboard"></i> PicBank</a></li>
                <li class="active">UserList</li>
            </ol>
        </div>
        <div style="padding: 15px 15px 0 15px;margin-right: auto;margin-left: auto;">
            <a class="btn btn-info btn-sm" href="_addPeople.jsp">添加成员</a>
        </div>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="user-list" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>编号</th>
                                    <th>用户名</th>
                                    <th>注册IP</th>
                                    <th>注册时间</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!--  <tr>
                                    <td>1</td>
                                    <td>testName</td>
                                    <td>192.168.1.1</td>
                                    <td>2015-2-2</td>
                                    <td>可用</td>
                                    <td>
                                        <a href="_editPeople.html">编辑</a>&nbsp;&nbsp;&nbsp;
                                        <a>删除</a>
                                    </td>
                                </tr>-->
                                <%
                                String strLength=String.valueOf(request.getAttribute("length"));
                                int intLength=Integer.parseInt(strLength);
                               	ArrayList uid=(ArrayList)request.getAttribute("uid");
                                ArrayList username1=(ArrayList)request.getAttribute("username1");
                                ArrayList userip=(ArrayList)request.getAttribute("userip");
                                ArrayList regtime=(ArrayList)request.getAttribute("regtime");
                                //ArrayList dateStr=(ArrayList)request.getAttribute("dateStr");
                                ArrayList status=(ArrayList)request.getAttribute("status");
                                for(int i=0;i<intLength;i++){%>
                                	<tr>
                                    <td><%=uid.get(i) %></td>
                                    <td><%=username1.get(i) %></td>
                                    <td><%=userip.get(i) %></td>
                                    <td><%=regtime.get(i) %></td>
                                    <td><%=status.get(i) %></td>
                                    <td>
                                        <a href="_editPeople.jsp?uid=<%=uid.get(i) %>&username=<%=username1.get(i) %>">编辑</a>&nbsp;&nbsp;&nbsp;
                                        <a href="AdminUserDeleteServlet?uid=<%=uid.get(i) %>" onclick="return confirm('是否删除!')">删除</a>&nbsp;&nbsp;&nbsp;
                                        <a href="AdminUserBanServlet?uid=<%=uid.get(i) %>&status=0" onclick="return confirm('是否禁用该用户!')">禁用</a>&nbsp;&nbsp;&nbsp;
                                        <a href="AdminUserBanServlet?uid=<%=uid.get(i) %>&status=1" onclick="return confirm('是否启用该用户!')">启用</a>
                                    </td>
                                </tr>
                                <%}
                                %>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>编号</th>
                                    <th>用户名</th>
                                    <th>注册IP</th>
                                    <th>注册时间</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <script>
    $(function () {
        $('#user-list').DataTable();
    });
	</script>
<%@ include file="_footer.jsp"%>