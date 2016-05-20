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

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="img-list" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>编号</th>
                                    <th>图片</th>
                                    <th>上传用户</th>
                                    
                                    <th>上传时间</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!-- <tr>
                                    <td>1</td>
                                    <td>
                                        <img src="../img/1.jpg" width="30px;" height="30px;">
                                    </td>
                                    <td>1</td>
                                    <td>192.168.1.1</td>
                                    <td>2015-6-6</td>
                                    <td>可用</td>
                                    <td>
                                        <a href="_editPic.html">编辑</a>&nbsp;&nbsp;&nbsp;
                                        <a>删除</a>
                                    </td>
                                </tr> -->
                                <%
                                String strLength=String.valueOf(request.getAttribute("length"));
                                int intLength=Integer.parseInt(strLength);
                                ArrayList iid=(ArrayList)request.getAttribute("iid");
                                ArrayList username1=(ArrayList)request.getAttribute("username1");
                                ArrayList uid=(ArrayList)request.getAttribute("uid");
                                ArrayList imgurl=(ArrayList)request.getAttribute("imgurl");
                                ArrayList uptime=(ArrayList)request.getAttribute("uptime");
                                ArrayList status=(ArrayList)request.getAttribute("status");
                                
                                for(int i=0;i<intLength;i++){%>
                                	<tr>
                                    <td><%=iid.get(i) %></td>
                                    <td>
                                        <img src="<%=imgurl.get(i) %>" width="30px;" height="30px;">
                                    </td>
                                    <td><a href="_editPeople.jsp?uid=<%=uid.get(i) %>&username=<%=username1.get(i) %>"><%=username1.get(i) %></a></td>
                                    
                                    <td><%=uptime.get(i) %></td>
                                    
                                    <td><%=status.get(i) %></td>
                                    <td>
                                        <a href="AdminPicDeleteServlet?iid=<%=iid.get(i)%>">删除</a>
                                    </td>
                                	</tr>
                                <%}
                                %>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>编号</th>
                                    <th>图片</th>
                                    <th>上传用户</th>
                                    
                                    <th>上传时间</th>
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
        $('#img-list').DataTable();
    });
	</script>
<%@ include file="_footer.jsp"%>