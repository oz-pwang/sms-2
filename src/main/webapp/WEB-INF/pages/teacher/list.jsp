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
            教师列表
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
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>省份证号</td>
                <td>出生年月</td>
                <td>联系电话</td>
                <td>教学班级</td>
                <td>教学科目</td>
                <td style="margin-right: 30px">操做</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.IDCardNumber}</td>
                    <td>${user.birthDateString}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.clazzName}</td>
                    <td>${user.subjectName}</td>
                    <td>
                        <a class="btn btn-primary" href="<c:url value="/teacher/edit?id=${user.id}" />"
                           style="width: 45%">编辑</a>
                        <a class="btn btn-primary" href="<c:url value="/teacher/delete?id=${user.id}" />"
                           style="width: 45%">删除</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <a href="<c:url value="/teacher/add" />" class="btn btn-primary" role="button"
                       style="width: 45%">添加</a>
                    <a href="<c:url value="/user/export" />" class="btn btn-primary" role="button"
                       style="width: 45%">导出</a>
                </td>
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
