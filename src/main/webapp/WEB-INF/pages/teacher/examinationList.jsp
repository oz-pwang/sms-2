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
    <title>考试列表</title>
</head>
<body>

<div class="container">
    <div class="clearfix">&nbsp;</div>

    <jsp:include page="/WEB-INF/common/navbar.jsp"/>

    <div class="well">
        <h3 class="text-left">
            考试列表
        </h3>
        <table id="tableid" class="table table-condensed" align="center">
            <thead>
            <tr>
                <td>${user.name}</td>
            </tr>
            <tr style="background-color: yellow">
                <td>ID</td>
                <td>考试名称</td>
                <td>创建时间</td>
                <td>考试状态</td>
                <td style="margin-right: 30px">指令</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${commandList}" var="examination">
                <tr>
                    <td>${examination.id}</td>
                    <td>${examination.name}</td>
                    <td>${examination.createDate}</td>
                    <td>
                        <c:if test="${examination.examinationStatus == 'no'}">
                            考试未开始
                        </c:if>
                        <c:if test="${examination.examinationStatus == 'yes'}">
                            考试结束
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${examination.examinationStatus == 'yes'&& examination.achievementStatus == 'yes'}">
                            <a class="btn btn-primary" href="<c:url value="/teacher/queryAchievement?id=${examination.id}" />" style="width: 45%">查看成绩</a>
                        </c:if>
                        <c:if test="${examination.examinationStatus == 'yes'&& examination.achievementStatus == 'no'}">
                            <a class="btn btn-primary" href="<c:url value="/achievement/add?eid=${examination.id}&tid=${user.id}" />" style="width: 45%">录入成绩</a>
                        </c:if>
                        <c:if test="${examination.examinationStatus == 'no'&& examination.achievementStatus == 'no'}">
                            <a class="btn btn-primary" href="<c:url value="#"/>" aria-disabled="true" style="width: 45%">等待考试</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
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
