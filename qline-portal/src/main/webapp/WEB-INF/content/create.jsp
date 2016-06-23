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
    <form:form modelAttribute="quiz" action="submitQuizN">
      <div class="form-group">
         <form:label path="name"><s:message code="label.quiz.name" text="Quiz Name"/></form:label>
         <form:input class="form-control" type="text" path="name" name="Quiz Name" />
      </div>
      <div class="form-group">
         <form:label path="category"><s:message code="label.quiz.category" text="Category"/></form:label>
         <form:input class="form-control" type="text" path="category" name="Category" />
      </div>
      <div class="form-group">
         <form:label path="subCategory"><s:message code="label.quiz.subCategory" text="Sub Category"/></form:label>
         <form:input class="form-control" type="text" path="subCategory" name="Sub Category" />
      </div>
      <div class="form-group">
         <form:label path="typeOfQuiz"><s:message code="label.quiz.typeOfQuiz" text="Type of Quiz"/></form:label>
         <form:input class="form-control" type="text" path="typeOfQuiz" name="Type of Quiz" />
      </div>
      <div class="form-group">
         <form:label path="noOfQuestions"><s:message code="label.quiz.noOfQuestions" text="Number of Questions"/></form:label>
         <form:input class="form-control" type="number" path="noOfQuestions" name="Number of Qustions" />
      </div>
      <div class="form-group">
         <form:label path="markingRequired"><s:message code="label.quiz.markingRequired" text="Is Marking Required"/></form:label>
         <form:checkbox class="form-control-inline" path="markingRequired" name="Is Marking Required" value="true"/>
      </div>
      <div class="form-group">
          <input class="btn btn-success" type="submit" name="Create a Quiz" value="Create a Quiz" />
      </div>
    </form:form>
   
    </div>
  </div>
 
</div>
</body>
</html>