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
    <title>添加</title>
</head>
<body>

<div class="container">
    <div class="clearfix">&nbsp;</div>

    <jsp:include page="/WEB-INF/common/navbar.jsp"/>

    <div class="well">
        <h1 class="text-center">
            添加成绩
        </h1>

        <h3 class="text-center">
            科目：${command.subject.name}
            考试名称：${command.examination.name}
        </h3>

        <c:forEach items="${command.studentList}" var="student">

            <form class="form-inline" action="/achievement/add" method="post">
                <input type="hidden" name="studentId" value="${student.id}">
                <input type="hidden" name="examinationId" value="${command.examination.id}">
                <input type="hidden" name="subjectId" value="${command.subject.id}">
                <input type="hidden" name="teacherId" value="${command.teacher.id}">

                <div class="form-group">
                    <label>姓名</label>
                    <input type="text" readonly="true" name="studentName" class="form-control" value="${student.name}">
                </div>
                <div class="form-group">
                    <label>成绩</label>
                    <input type="text" name="fraction" class="form-control">
                </div>
                <button type="submit" class="btn btn-default">保存</button>
            </form>

        </c:forEach>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>
