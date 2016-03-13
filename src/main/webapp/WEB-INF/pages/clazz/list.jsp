<%--
  Created by IntelliJ IDEA.
  User: Yang Wang
  Date: 8/15/15
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <jsp:include page="/WEB-INF/common/meta.jsp"/>
    <title>用户列表</title>
    <script type="application/javascript">
        function searchUser() {
            var searchText = document.getElementById('searchText').value;
            var url = "<c:url value="/teacher/list" />";
            if (searchText) {
                url += ("?query=" + searchText);
            }
            window.location.href = url;
        }
    </script>
</head>
<body>

<div class="container">
    <div class="clearfix">&nbsp;</div>

    <jsp:include page="/WEB-INF/common/navbar.jsp"/>

    <div class="well">
        <h1 class="text-left">
            学生列表
        </h1>

        <div class="row">

            <div class="col-lg-6">
                <div class="input-group">
                    <input id="searchText" type="text" class="form-control" placeholder="Search for..."
                           value="${param.query}">
                      <span class="input-group-btn">
                        <button class="btn btn-default" type="button" onclick="searchUser()">Go!</button>
                      </span>
                </div>
            </div>
        </div>
        <table id="tableid" class="table table-condensed" align="center">
            <thead>
            <tr style="background-color: yellow">
                <td>ID</td>
                <td>名称</td>
                <td>班主任</td>
                <td>人数</td>
                <td style="margin-right: 30px">操做</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${clazzList}" var="clazz">
                <tr>
                    <td>${clazz.id}</td>
                    <td>${clazz.name}</td>
                    <td>${clazz.headTeacher}</td>
                    <td>${clazz.size}</td>
                    <td>
                        <a class="btn btn-primary" href="<c:url value="/clazz/info?id=${clazz.id}" />" style="width: 45%">查看班级信息</a>
                        <a class="btn btn-primary" href="<c:url value="/teacher/delete?id=${user.id}" />" style="width: 45%">删除</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <div>
                    <td>
                        <a href="<c:url value="/teacher/add" />" class="btn btn-primary" role="button" style="width: 45%">添加</a>
                        <a href="<c:url value="/user/export" />" class="btn btn-primary" role="button" style="width: 45%">导出</a>
                    </td>

                </div>
            </tr>
            </tbody>

        </table>

    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>
