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
            创建考试
        </h1>
        <form:form action="/examination/add?id=${id}" method="post" cssClass="form-horizontal" commandName="command">

            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="name" class="col-sm-2 control-label">考试名称</label>

                    <div class="col-sm-10">
                        <form:input id="name" path="name" cssClass="form-control" placeholder="Examination name"
                                    required="true"/>
                        <form:errors path="name" cssClass="alert-danger" element="div"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="startDate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="startDate" class="col-sm-2 control-label">考试时间</label>

                    <div class="col-sm-10">
                        <form:input id="startDate" path="startDate" cssClass="form-control" placeholder="1999-01-01"
                                    type="datetime"/>
                        <form:errors path="startDate" cssClass="alert-danger" element="div"/>
                    </div>
                </div>
            </spring:bind>

            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">考试科目</label>

                <div class="col-sm-10">
                        <%--<form:checkboxes path="subjectList" items="${command.subjectList}" itemLabel="name" itemValue="id" />--%>
                    <c:forEach items="${command.subjectList}" var="subject" >
                        <form:checkbox path="subjectIdList" value="${subject.id}" label="${subject.name}"/>
                    </c:forEach>

                </div>
            </div>


            <div class="form-group" >
                <label for="name" class="col-sm-2 control-label">班级</label>

                <div class="col-sm-10">
                        <%--<form:checkboxes path="subjectList" items="${command.subjectList}" itemLabel="name" itemValue="id" />--%>
                    <c:forEach items="${command.clazzList}" var="clazz" >
                        <form:checkbox path="clazzIdList" value="${clazz.id}" label="${clazz.name}"/>
                    </c:forEach>

                </div>

            </div>


            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Sumbit</button>
                </div>
            </div>
        </form:form>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>
