<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 基本表单</title>
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
                        <c:if test="${pushRule.id<=0}">
                            <h5>规则创建 <small>创建文章推送的规则</small></h5>
                        </c:if>
                        <c:if test="${pushRule.id>0}">
                            <h5>规则修改 <small>修改文章推送的规则</small></h5>
                        </c:if>
                    </div>
                    <div class="ibox-content">
                        <form method="post" class="form-horizontal" action="${pageContext.request.contextPath}/pushrule/save">
                            <input type="hidden" name="id" value="${pushRule.id}">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">规则名称</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="rule_name" required="" value="${pushRule.rule_name}">
                                </div>
                            </div>

                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">限定板块</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="section_urls" required="" value="${pushRule.section_urls}">
                                </div>
                            </div>

                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">限定标题关键词</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="article_title_include" required="" value="${pushRule.article_title_include}">
                                </div>
                            </div>

                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">排除标题关键词</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="article_title_exclude" required="" value="${pushRule.article_title_exclude}">
                                </div>
                            </div>

                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">推送时间</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="pushtime_type" required="" value="${pushRule.pushtime_type}">
                                </div>
                            </div>

                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-outline btn-success" type="submit">保存规则</button>
                                    <button class="btn btn-outline btn-primary" type="reset">撤销修改</button>
                                    <button class="btn btn-outline btn-info" onclick="window.location.href='${pageContext.request.contextPath}/pushrules'" type="button">所有规则</button>
                                    <button class="btn btn-outline btn-danger" onclick="window.location.href='${pageContext.request.contextPath}/firstPage'" type="button">返回主页</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
