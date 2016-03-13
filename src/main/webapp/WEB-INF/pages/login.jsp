<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yang Wang
  Date: 16/2/1
  Time: 下午4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/common/meta.jsp"/>

    <title>用户登录</title>

</head>
<body class="body">
<style>
    body {
        background: #3c3c3c;
        /*background-image: url(/imgs/background.jpg);*/
        /*background-size: 100%;*/
    }

</style>


<div class="container">

    <div class="clearfix">&nbsp;</div>
    <div class="clearfix">&nbsp;</div>
    <div class="well" style="background:transparent; border: 0; width: 40%; margin: 0 20%  20px 20% ;">

        <h1 class="text-center" style="color: white;">用户登录</h1>

        <c:if test="${param.failed eq 'true'}">
            <div class="alert alert-danger" role="alert" style="width: 70%; opacity: 0.7; margin: 0 0 20px 20%">
                Username , password or role is not match.
            </div>
        </c:if>
        <%--'/j_spring_security_check'--%>
        <form action="<c:url value="/login"/>" method="post" class="form-horizontal">
            <div class="form-group" style="opacity: 0.4;">
                <label for="role" class="col-sm-2 control-label" style="color: white">Role</label>
                <select class="form-control" style="width: 70%" name="role" id="role">
                    <option value="STUDENT">学生</option>
                    <option value="TEACHER">教师</option>
                    <option value="ADMIN">管理员</option>
                </select>
            </div>
            <div class="form-group" style="opacity: 0.4;">
                <label for="username" class="col-sm-2 control-label" style="color: white">Username</label>

                <div class="col-sm-10">
                    <input id="username" type="text" name="username" class="form-control" placeholder="Username">
                </div>
            </div>

            <div class="form-group" style="opacity: 0.4;">
                <label for="password" class="col-sm-2 control-label" style="color: white">Password</label>

                <div class="col-sm-10">
                    <input id="password" type="password" name="password" class="form-control" placeholder="Password">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10" style="width: 70%;opacity: 0.4;">
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>
