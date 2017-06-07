<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Article</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <%--<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.custom.js" charset="utf-8"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/static/bootstrap/js/myjs.js" charset="utf-8"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap-paginator.min.js"></script>--%>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <%--<nav class="navbar navbar-default navbar-static-top" role="navigation">--%>
                <%--<div class="navbar-header">--%>
                    <%--<button type="button" class="navbar-toggle" data-toggle="collapse"--%>
                            <%--data-target="#bs-example-navbar-collapse-1"><span--%>
                            <%--class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span--%>
                            <%--class="icon-bar"></span><span class="icon-bar"></span></button>--%>
                    <%--<a class="navbar-brand" href="#">Brand</a>--%>
                <%--</div>--%>

                <%--<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>
                    <%--<ul class="nav navbar-nav">--%>
                        <%--<li class="active"><a href="#">Link</a></li>--%>
                        <%--<li><a href="#">Link</a></li>--%>
                        <%--<li class="dropdown">--%>
                            <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong--%>
                                    <%--class="caret"></strong></a>--%>
                            <%--<ul class="dropdown-menu">--%>
                                <%--<li><a href="#">Action</a></li>--%>
                                <%--<li><a href="#">Another action</a></li>--%>
                                <%--<li><a href="#">Something else here</a></li>--%>
                                <%--<li class="divider"></li>--%>
                                <%--<li><a href="#">Separated link</a></li>--%>
                                <%--<li class="divider"></li>--%>
                                <%--<li><a href="#">One more separated link</a></li>--%>
                            <%--</ul>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                    <%--<form class="navbar-form navbar-left" role="search">--%>
                    <%--<div class="form-group">--%>
                    <%--<input type="text" class="form-control"/>--%>
                    <%--</div>--%>
                    <%--<button type="submit" class="btn btn-default">Submit</button>--%>
                    <%--</form>--%>
                    <%--<ul class="nav navbar-nav navbar-right">--%>
                        <%--<li>--%>
                            <%--<a href="#">Link</a>--%>
                        <%--</li>--%>
                        <%--<li class="dropdown">--%>
                            <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong--%>
                                    <%--class="caret"></strong></a>--%>
                            <%--<ul class="dropdown-menu">--%>
                                <%--<li><a href="#">Action</a></li>--%>
                                <%--<li><a href="#">Another action</a></li>--%>
                                <%--<li><a href="#">Something else here</a></li>--%>
                                <%--<li class="divider"></li>--%>
                                <%--<li class="divider"></li>--%>
                                <%--<li><a href="#">Separated link</a></li>--%>
                            <%--</ul>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>

            <%--</nav>--%>
            <%--表单--%>
            <br>
            <div style="width:100%;text-align:center">

                <form role="form" class="form-inline" action="${pageContext.request.contextPath}/find">
                    <div class="form-group">
                        <label for="author">Author:</label><input type="text" name="author" class="form-control"
                                                                                    id="author" placeholder="${articleinfoQueryVo.article_author}"/>
                    </div>
                    <div class="form-group">
                        <label for="keyWords">keyWords:</label><input type="text" name="keyWords" class="form-control"
                                                                                  id="keyWords" placeholder="${articleinfoQueryVo.article_titles_originalstring}"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
            <br>

            <%--表格--%>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th width="10%">id</th>
                    <th width="10%">section_name</th>
                    <th width="40%">article_title</th>
                    <th width="10%">article_createtime</th>
                    <th width="10%">article_commentnum</th>
                    <th width="10%">article_author</th>
                    <th width="10%">article_url</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfo.list}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.section_name}</td>
                        <td>${item.article_title}</td>
                        <td><fmt:formatDate value="${item.article_createtime}" pattern="yyyy-MM-dd"/></td>
                        <td>${item.article_commentnum}</td>
                        <td>${item.article_author}</td>
                        <td><a href="${item.article_url}" class="btn btn-default" role="button">链接</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <%--分页--%>
            <div style="text-align: right">
                <%--上拉栏--%>
                <ul class="pagination">
                    <li class="dropup">
                        <button class="btn btn-default dropdown-toggle" type="button" id="menu1"
                                data-toggle="dropdown">${pageInfo.pageSize}条/页
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                            <c:choose>
                                <c:when test="${pageInfo.pageSize==10}">
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">10条/页</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/pageSize/20">20条/页</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/pageSize/50">50条/页</a></li>
                                </c:when>
                                <c:when test="${pageInfo.pageSize==20}">
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/pageSize/10">10条/页</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">20条/页</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/pageSize/50">50条/页</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/pageSize/10">10条/页</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/pageSize/20">20条/页</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">50条/页</a></li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </li>
                    <%--前一页--%>
                    <c:choose>
                        <c:when test="${pageInfo.hasPreviousPage}">
                            <li><a href="${pageContext.request.contextPath}/page/${pageInfo.prePage}">&laquo;</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="javascript:void(0);">&laquo;</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <%--总页数小于9，不用省略号--%>
                    <c:if test="${pageInfo.pages<9}">
                        <c:forEach var="i" begin="1" end="${pageInfo.pages}" step="1">
                            <c:if test="${pageInfo.pageNum==i}">
                                <li class="active"><a href="javascript:void(0);">${i}</a>
                                </li>
                            </c:if>
                            <c:if test="${pageInfo.pageNum!=i}">
                                <li><a href="${pageContext.request.contextPath}/page/${i}">${i}</a></li>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <%--总页数大于等于9，用省略号--%>
                    <c:if test="${pageInfo.pages>=9}">
                        <%--当前页号靠前--%>
                        <c:if test="${pageInfo.pageNum<=3}">
                            <c:forEach var="i" begin="1" end="5" step="1">
                                <c:if test="${pageInfo.pageNum==i}">
                                    <li class="active"><a href="javascript:void(0);">${i}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageInfo.pageNum!=i}">
                                    <li><a href="${pageContext.request.contextPath}/page/${i}">${i}</a></li>
                                </c:if>
                            </c:forEach>
                            <li><a href="javascript:void(0);">..</a>
                            <li>
                                <a href="${pageContext.request.contextPath}/page/${pageInfo.pages}">${pageInfo.pages}</a>
                            </li>
                        </c:if>
                        <%--当前页号靠后--%>
                        <c:if test="${pageInfo.pages-pageInfo.pageNum<=3}">
                            <li><a href="${pageContext.request.contextPath}/page/1">1</a></li>
                            <li><a href="javascript:void(0);">..</a>
                            <c:forEach var="i" begin="${pageInfo.pages-5}" end="${pageInfo.pages}" step="1">
                                <c:if test="${pageInfo.pageNum==i}">
                                    <li class="active"><a href="javascript:void(0);">${i}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageInfo.pageNum!=i}">
                                    <li><a href="${pageContext.request.contextPath}/page/${i}">${i}</a></li>
                                </c:if>
                            </c:forEach>
                        </c:if>
                        <%--当前页号居中--%>
                        <c:if test="${pageInfo.pageNum>3 && pageInfo.pages-pageInfo.pageNum>3}">
                            <li><a href="${pageContext.request.contextPath}/page/1">1</a></li>
                            <li><a href="javascript:void(0);">..</a>
                            <c:forEach var="i" begin="${pageInfo.pageNum-2}" end="${pageInfo.pageNum+2}" step="1">
                                <c:if test="${pageInfo.pageNum==i}">
                                    <li class="active"><a href="javascript:void(0);">${i}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageInfo.pageNum!=i}">
                                    <li><a href="${pageContext.request.contextPath}/page/${i}">${i}</a></li>
                                </c:if>
                            </c:forEach>
                            <li><a href="javascript:void(0);">..</a>
                            <li>
                                <a href="${pageContext.request.contextPath}/page/${pageInfo.pages}">${pageInfo.pages}</a>
                            </li>
                        </c:if>
                    </c:if>

                    <%--后一页--%>
                    <c:choose>
                        <c:when test="${pageInfo.hasNextPage}">
                            <li><a href="${pageContext.request.contextPath}/page/${pageInfo.nextPage}">&raquo;</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="javascript:void(0);">&raquo;</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</div>

</body>
</html>