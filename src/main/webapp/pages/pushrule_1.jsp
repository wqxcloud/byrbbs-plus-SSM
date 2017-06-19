<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 基础表格</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>推送规则</h5>
                </div>
                <div class="ibox-content">
                    <table class="table table-bordered">
                        <%--表格--%>
                        <%--<table class="table table-striped table-hover">--%>
                        <thead>
                        <tr>
                            <th width="10%">id</th>
                            <th width="20%">section_urls</th>
                            <th width="30%">article_title_include</th>
                            <th width="30%">article_title_exclude</th>
                            <th width="10%">pushtime_type</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pushrules}" var="item" varStatus="status">
                            <tr>
                                <%--此处不显示内部id，而是重新编号，从1开始--%>
                                <td>${status.index+1}</td>
                                <%--<td>${item.id}</td>--%>
                                <td>${item.section_urls}</td>
                                <td>${item.article_title_include}</td>
                                <td>${item.article_title_exclude}</td>
                                <td>${item.pushtime_type}</td>
                                <%--<td><a href="${item.article_url}" class="btn btn-default" role="button" target="_blank">链接</a>--%>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>
