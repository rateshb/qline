<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="indexLayout" name="decorator">
</head>

<body>
<div id="main">
 <div id="container">
    <div id="form">
    <form:form modelAttribute="newUser" action="submitUser">
      <div class="form-group">
         <form:label path="username"><s:message code="label.user.name" text="Username"/></form:label>
         <form:input class="form-control" type="text" path="username" name="User Name" />
      </div>
      <div class="form-group">
         <form:label path="password"><s:message code="label.user.password" text="Password"/></form:label>
         <form:input class="form-control" type="password" path="password" name="Password" />
      </div>
      <div class="form-group">
         <form:label path="confirmPassword"><s:message code="label.user.confirmPassword" text="Confirm Password"/></form:label>
         <form:input class="form-control" type="password" path="confirmPassword" name="Confirm Password" />
      </div>
      <div class="form-group">
         <form:label path="emailId"><s:message code="label.user.email" text="Email Address"/></form:label>
         <form:input class="form-control" type="text" path="emailId" name="Email Address" />
      </div>
      <div class="form-group">
         <form:label path="firstName"><s:message code="label.user.firstName" text="First Name"/></form:label>
         <form:input class="form-control" type="text" path="firstName" name="First Name" />
      </div>
      <div class="form-group">
         <form:label path="lastName"><s:message code="label.user.lastName" text="Last Name"/></form:label>
         <form:input class="form-control" type="text" path="lastName" name="Last Name" />
      </div>
      <div class="form-group">
          <input class="btn btn-success" type="submit" name="Sign Up" value="Sign up" />
      </div>
    </form:form>
   
    </div>
  </div>
 
</div>
</body>
</html>