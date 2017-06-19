<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>推送规则</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row">
    <div class="col-sm-12">
        <div class="wrapper wrapper-content animated fadeInUp">
            <c:forEach items="${pushrules}" var="item" varStatus="status">
                <ul class="notes">
                    <li>
                        <div>
                            <h4>${item.rule_name}</h4>
                            <p>
                                    ${item.section_urls},${item.article_title_include},${item.article_title_exclude},${item.pushtime_type}
                            </p>
                            <a class="left" href="${pageContext.request.contextPath}/pushrule/update/${item.id}">
                                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                            </a>
                            <a href="${pageContext.request.contextPath}/pushrule/delete/${item.id}">
                                <i class="fa fa-trash-o "></i>
                            </a>
                        </div>
                    </li>
                </ul>
            </c:forEach>
            <ul class="notes">
                <li>
                    <div>
                        <h4>新建规则</h4>
                        <a href="${pageContext.request.contextPath}/pushrule/update/-1">
                            <i class="fa fa-plus-square-o" aria-hidden="true"></i></a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<!-- 全局js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/js/content.js?v=1.0.0"></script>
</body>
</html>

