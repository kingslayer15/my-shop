<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

    <title>我的商城丨控制面板</title>
    <jsp:include page="../includes/header.jsp"/>
</head>


<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <jsp:include page="../includes/menu.jsp"/>
    </aside>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">用户管理</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>

                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                        </div>
                        <form:form cssClass="form-horizontal" action="/user/search" method="post" modelAttribute="tbUser">
                            <div class="col-xs-3">
                                <div class="form-group">
                                    <label for="username" class="col-sm-2 control-label">用户名</label>

                                    <div class="col-sm-8">
                                        <form:input path="username" cssClass="form-control" placeholder="请输入用户名地址"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-3">
                                <div class="form-group">
                                    <label for="email" class="col-sm-2 control-label">邮箱</label>

                                    <div class="col-sm-8">
                                        <form:input path="email" cssClass="form-control" placeholder="请输入邮箱地址"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-3">
                                <div class="form-group">
                                    <label for="phone" class="col-sm-2 control-label">手机</label>

                                    <div class="col-sm-8">
                                        <form:input path="phone" cssClass="form-control" placeholder="请输入手机"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="padding-right: 70px">
                                <div class="col-sm-8 pull-right">
                                    <button type="submit" class="btn btn-info pull-right">搜索</button>
                                </div>
                            </div>

                        </form:form>
                    </div>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                            <div class="row" style="padding-left: 11px; padding-top: 10px;">
                                <a href="/user/form" type="button" class="btn btn-default btn-sm"><i class="fa fa-fw fa-plus"></i>新增</a>&nbsp;
                                <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-fw fa-trash-o"></i>删除</a>&nbsp;
                                <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-fw fa-download"></i>导入</a>&nbsp;
                                <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-fw fa-upload"></i>导出</a>
                                <button type="button" class="btn btn-sm btn-primary" onclick="$('.box-info-search').css('display') == 'none' ? $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')"><i class="fa fa-search"></i> 搜索</button>
                            </div>
                        </div>

                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" class="minimal icheck_master"/></th>
                                        <th>ID</th>
                                        <th>用户名</th>
                                        <th>手机号</th>
                                        <th>邮箱</th>
                                        <th>更新时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbUsers}" var="tbUser">
                                    <tr>
                                        <td><input type="checkbox" class="minimal"/></td>
                                        <td>${tbUser.id}</td>
                                        <td>${tbUser.username}</td>
                                        <td>${tbUser.phone}</td>
                                        <td>${tbUser.email}</td>
                                        <td><fmt:formatDate value="${tbUser.updated}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                                        <td>
                                            <a href="/user/form" type="button" class="btn btn-default btn-sm" ><i class="fa fa-fw fa-search"></i>查看</a>
                                            <a href="/user/form" type="submit" class="btn btn-primary btn-sm" ><i class="fa fa-fw fa-edit"></i>编辑</a>
                                            <a href="#" type="button" class="btn btn-danger btn-sm" ><i class="fa fa-fw fa-trash-o"></i>删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="../includes/copyright.jsp"/>
</div>

<jsp:include page="../includes/footer.jsp"/>
</body>
</html>