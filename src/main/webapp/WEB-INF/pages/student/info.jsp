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

</head>
<body>

<div class="container">
  <div class="clearfix">&nbsp;</div>

  <jsp:include page="/WEB-INF/common/navbar.jsp"/>

  <div class="well">
    <h1 class="text-left">
      ${user.name}
    </h1>
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


      </tbody>
    </table>
    <a class="btn btn-primary btn-lg" href="/student/edit?id=${user.id}" role="button">修改信息</a>
    <a class="btn btn-primary btn-lg" href="/student/member?clazzId=${user.clazzId}&id=${user.id}" role="button">查看班级成员</a>
    <a class="btn btn-primary btn-lg" href="/student/viewResults?id=${user.id}" role="button">查看成绩</a>
    <a class="btn btn-primary btn-lg" href="/student/update?name=${user.name}" role="button" >修改密码</a>
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>
