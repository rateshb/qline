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
      <jsp:include page="./includes/_quizDetailsPanel.jsp"></jsp:include>
      
      
    <form:form modelAttribute="quiz" action="startQuiz" target="_blank" onClick="window.open('startQuiz?ic=${invitationCode}','_blank', config='height=100,width=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, directories=no, status=no' )">
      <input type="hidden" name="invitationCode" value="${invitationCode}"/>
      
      <input type="submit" name="Start Quiz" value="Start Quiz" />
    </form:form>
   <!--  -->
    </div>
  </div>
 
</div>
</body>
</html>