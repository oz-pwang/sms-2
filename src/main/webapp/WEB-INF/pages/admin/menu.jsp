<%--
  Created by IntelliJ IDEA.
  User: Yang Wang
  Date: 16/3/6
  Time: 下午1:31
  To change this template use File | Settings | File Templates.
--%>

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

<%--<div class="container">--%>
<%--<div class="clearfix">&nbsp;</div>--%>

<%--<jsp:include page="common/navbar.jsp"/>--%>

<%--<div class="well">--%>
<%--<h1 class="text-left">--%>
<%--${user.name}--%>
<%--</h1>--%>
<%--<table class="table table-condensed">--%>
<%--<tbody>--%>
<%--<tr>--%>
<%--<td>Gender</td>--%>
<%--<td>${user.gender}</td>--%>
<%--&lt;%&ndash;<td rowspan="3">&ndash;%&gt;--%>
<%--&lt;%&ndash;<img src="..." alt="wwwww" class="img-rounded">&ndash;%&gt;--%>
<%--&lt;%&ndash;</td>&ndash;%&gt;--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>Age</td>--%>
<%--<td>${user.age}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>Phone Number</td>--%>
<%--<td>${user.phoneNumber}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>Role</td>--%>
<%--<td>${user.roleName}</td>--%>
<%--</tr>--%>


<%--</tbody>--%>
<%--</table>--%>
<%--<a class="btn btn-primary btn-lg" href="/user/update?name=${user.name}" role="button">修改信息</a>--%>
<%--<a class="btn btn-primary btn-lg" href="/user/update?name=${user.name}" role="button">查看班级成员</a>--%>
<%--</div>--%>
<%--</div>--%>


<div id="container">

  <div id="header">
    <jsp:include page="/WEB-INF/common/navbar.jsp"/>
  </div>

  <div class="list-group" style="float:left; width: 20%">
    <a href="/teacher/add" class="list-group-item">添加教师</a>
    <a href="/student/add" class="list-group-item">添加学生</a>
    <a href="/clazz/list" class="list-group-item">查看班级</a>
    <a href="/teacher/list" class="list-group-item">查看教师</a>
    <a href="/student/list" class="list-group-item">查看学生</a>
  </div>


  <div class="well" style="float: left; width: 50%">
    <h3 class="text-left">
      ${user.name}
    </h3>
  </div>

  <div id="footer">底部</div>

</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>



