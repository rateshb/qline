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
      <div>
         <label><s:message code="label.quiz.name" text="Quiz Name"/></label>
         <label>${loadedQuiz.name}</label>
      </div><div>
         <label><s:message code="label.quiz.category" text="Category"/></label>
         <label>${loadedQuiz.category}</label>
      </div>
      <div>
         <label><s:message code="label.quiz.subCategory" text="Sub Category"/></label>
         <label>${loadedQuiz.subCategory}</label>
      </div>
      <div>
         <label><s:message code="label.quiz.typeOfQuiz" text="Type of Quiz"/></label>
         <label>${loadedQuiz.typeOfQuiz}</label>
      </div>
      <div>
         <label><s:message code="label.quiz.noOfQuestions" text="Number of Questions"/></label>
         <label>${loadedQuiz.noOfQuestions}</label>
      </div>
      <div>
         <label><s:message code="label.quiz.markingRequired" text="Is Marking Required"/></label>
         <label>${loadedQuiz.markingRequired}</label>
      </div>
    <form:form modelAttribute="invitationModel" action="inviteFriends">
      <form:textarea path="inviteByEmail"/>
      <form:hidden path="quizCode" value="${loadedQuiz.quizCode}"/>
      <input type="submit" name="Invite Friends" value="Invite Friends" />
    </form:form>
   
    </div>
  </div>
 
</div>
</body>
</html>