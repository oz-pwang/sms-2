<%--
  Created by IntelliJ IDEA.
  User: Yang Wang
  Date: 8/15/15
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <jsp:include page="/WEB-INF/common/meta.jsp"/>
    <title>用户信息</title>

</head>
<body>

<div class="container">
    <div class="clearfix">&nbsp;</div>

    <jsp:include page="/WEB-INF/common/navbar.jsp"/>


    <div class="well">
        <h1 class="text-left">
            ${clazz.name}
        </h1>
        <h4>人数:${clazz.size}&nbsp;&nbsp;&nbsp;&nbsp;班主任:${clazz.headTeacher}</h4>
        <table class="table table-condensed">

            <tbody>
            <tr>
                <td>ID</td>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>班级</td>
                <td>联系电话</td>
                <td>身份证号</td>
            </tr>
            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.gender}</td>
                    <td>${student.age}</td>
                    <td>${student.clazz.name}</td>
                    <td>${student.phoneNumber}</td>
                    <td>${student.IDCardNumber}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-primary btn-lg" href="/student/edit?id=${user.id}" role="button">修改信息</a>
        <a class="btn btn-primary btn-lg" href="/student/add" role="button">添加学生</a>
        <a class="btn btn-primary btn-lg" href="/student/member?clazzId=${user.clazzId}&id=${user.id}" role="button">查看班级成员</a>
        <a class="btn btn-primary btn-lg" href="/student/examination?id=${user.id}" role="button">查看成绩</a>
        <a class="btn btn-primary btn-lg" href="/student/update?name=${user.name}" role="button">修改密码</a>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>
