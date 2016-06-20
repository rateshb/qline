<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Qline - Welcome</title>
<link rel="stylesheet" href="styles/default.css" />
</head>

<body>
<div id="container">
<div id="header" style="height: 61px; ">
   <div id="logo" class="logo"></div>
   <div id="login">
      <input type="text" name="username">
      <input type="text" name="password">
      <input type="submit" name="Login" value="Login">
   </div>
</div>

<div id="main">
    <s:form id="signUp" action="add" >
<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
 <div id="container">
    <div id="name"><s:textfield label="Quiz Name*" name="quiz.name"/></div>
<%--     <div id="emailId"><s:textfield label="Your Email Id*" name="entry.email" /></div>
    <div id="spouse"><s:textfield label="Spouse Name" name="entry.spouseName"/></div>
    <div id="spouseEmailId"><s:textfield label="Spouse Email" name="entry.spouseEmail"/></div>
    <div id="childName"><s:textfield label="Child Name" name="child.name"/></div>
 --%>
  </div>
 
 <s:submit value="Sign Up"></s:submit>
 
</s:form>
</div>

<div id="footer">
  <div id="menu">
   <ul>
    <li>Home</li>
    <li>Privacy Policy</li>
    <li>Disclaimer</li>
    <li>Contact Us</li>
    </ul>
  </div>
</div>
</div>
</body>
</html>