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
    <title>成绩列表</title>
</head>
<body>

<div class="container">
    <div class="clearfix">&nbsp;</div>

    <jsp:include page="/WEB-INF/common/navbar.jsp"/>

    <div class="well">
        <h3 class="text-left">
            成绩列表
        </h3>

        <h3 class="text-left">
            考试名称：
        </h3>

        <table id="tableid" class="table table-condensed" align="center">
            <thead>
            <tr style="background-color: yellow">
                <td>姓名</td>
                <td>科目</td>
                <td>总分</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${examinationList}" var="examination">
                <tr>
                    <td>${examination.id}</td>
                    <td>${examination.name}</td>
                    <td>${examination.createDate}</td>
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
