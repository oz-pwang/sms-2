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
    <title>用户信息</title>


    <style type="text/css">
        div#container {
        }

        div#header {
            background-color: #99bbbb;
        }

        div#menu {
            background-color: #ffff99;
        }

        div#content {
            background-color: #EEEEEE;
            float: left;
        }

        div#footer {
            background-color: #99bbbb;
            clear: both;
            text-align: center;
        }

        h1 {
            margin-bottom: 0;
        }

        h2 {
            margin-bottom: 0;
            font-size: 14px;
        }

        ul {
            margin: 0;
        }

        li {
            list-style: none;
        }
    </style>
</head>
<body>

<div id="container">

    <div id="header">
        <jsp:include page="/WEB-INF/common/navbar.jsp"/>
    </div>

    <div class="list-group" style="float:left; width: 20%">
        <a href="/clazz/info?id=${user.clazzId}" class="list-group-item">查看当前教学的班级</a>
        <a href="/teacher/examinationList?id=${user.id}" class="list-group-item">查看所有考试</a>
        <a href="/examination/add?id=${user.id}" class="list-group-item">创建新的考试</a>
        <a href="/teacher/edit?id=${user.id}" class="list-group-item">修改信息</a>
    </div>


        <div class="well" style="float: left; width: 50%">
            <h3 class="text-left">
                ${user.name}
            </h3>
            <table class="table table-condensed">
                <tbody>
                <tr>
                    <td>Gender</td>
                    <td>${user.gender}</td>
                    <%--<td rowspan="3">--%>
                    <%--<img src="..." alt="wwwww" class="img-rounded">--%>
                    <%--</td>--%>
                </tr>
                <tr>
                    <td>Age</td>
                    <td>${user.age}</td>
                </tr>
                <tr>
                    <td>Phone Number</td>
                    <td>${user.phoneNumber}</td>
                </tr>
                <tr>
                    <td>birthDay</td>
                    <td>${user.birthDateString}</td>
                </tr>
                <tr>
                    <td>IDCardNumber</td>
                    <td>${user.IDCardNumber}</td>
                </tr>
                <tr>
                    <td>Subject</td>
                    <td>${user.subjectName}</td>
                </tr>
                <tr>
                    <td>Class</td>
                    <td>${user.clazzName}</td>
                </tr>
                </tbody>
            </table>
        </div>

    <div id="footer">底部</div>

</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>
