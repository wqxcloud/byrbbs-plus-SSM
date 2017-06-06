<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Article</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
    <style>
        body {
            padding: 10px;
        }
    </style>
</head>

<body>
<div id="demo7"></div>

<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>id</th>
        <th>section_name</th>
        <th>article_title</th>
        <th>article_url</th>
        <th>article_createtime</th>
        <th>article_commentnum</th>
        <th>article_author</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageInfo.list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.section_name}</td>
            <td>${item.article_title}</td>
            <td><a class="layui-" href="${item.article_url}">地址</a> </td>
            <td>${item.article_createtime}</td>
            <td>${item.article_commentnum}</td>
            <td>${item.article_author}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    layui.use(['laypage', 'layer'], function () {
        var laypage = layui.laypage
            , layer = layui.layer;
        laypage({
            cont: 'demo7'
            , pages: 100
            , skip: true
        });
    })
</script>

</body>
</html>