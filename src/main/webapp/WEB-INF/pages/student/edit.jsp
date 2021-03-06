
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <jsp:include page="/WEB-INF/common/meta.jsp"/>
  <title>编辑信息</title>
</head>
<body>

<div class="container">
  <div class="clearfix">&nbsp;</div>

  <div class="well">
    <h1 class="text-center">
      编辑用户
    </h1>
    <form:form action="/student/edit" method="post" cssClass="form-horizontal" commandName="command">
      <form:hidden path="id"/>

      <spring:bind path="name">
        <div class="form-group ${status.error ? 'has-error' : ''}">
          <label for="name" class="col-sm-2 control-label">Username</label>

          <div class="col-sm-10">
            <form:input id="name" path="name" cssClass="form-control" placeholder="Username" required="true" readonly="true"/>
            <form:errors path="name" cssClass="alert-danger" element="div"/>
          </div>

        </div>
      </spring:bind>

      <spring:bind path="gender">
        <div class="form-group ${status.error ? 'has-error' : ''}">
          <label for="gender" class="col-sm-2 control-label">性别</label>

          <div class="col-sm-10">
            <div class="radio">
              <label>
                <form:radiobutton path="gender" value="male"/>男
              </label>
            </div>
            <div class="radio">
              <label>
                <form:radiobutton path="gender" value="female"/>女
              </label>
            </div>

            <form:errors path="gender" cssClass="alert-danger" element="div"/>
          </div>
        </div>
      </spring:bind>

      <spring:bind path="age">
        <div class="form-group ${status.error ? 'has-error' : ''}">
          <label for="age" class="col-sm-2 control-label">Age</label>

          <div class="col-sm-10">
            <form:input id="age" path="age" cssClass="form-control" placeholder="Age" type="number"/>
            <form:errors path="age" cssClass="alert-danger" element="div"/>
          </div>
        </div>
      </spring:bind>

      <spring:bind path="IDCardNumber">
        <div class="form-group ${status.error ? 'has-error' : ''}">
          <label for="IDCardNumber" class="col-sm-2 control-label">IDCardNumber</label>

          <div class="col-sm-10">
            <form:input id="IDCardNumber" path="IDCardNumber" cssClass="form-control" placeholder="IDCardNumber" type="number"/>
            <form:errors path="IDCardNumber" cssClass="alert-danger" element="div"/>
          </div>
        </div>
      </spring:bind>

      <spring:bind path="phoneNumber">
        <div class="form-group ${status.error ? 'has-error' : ''}">
          <label for="phoneNumber" class="col-sm-2 control-label">Phone Number</label>

          <div class="col-sm-10">
            <form:input id="phoneNumber" path="phoneNumber" cssClass="form-control" placeholder="phone" type="number"/>
            <form:errors path="phoneNumber" cssClass="alert-danger" element="div"/>
          </div>
        </div>
      </spring:bind>


      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-default">提交</button>
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
