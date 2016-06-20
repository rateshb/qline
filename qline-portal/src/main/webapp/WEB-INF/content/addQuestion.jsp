<%@page import="com.startup.qline.domain.TypeOfAnswer"%>
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
    <form:form modelAttribute="questionModel" action="addQuestion">
      <div>${quiz.name}</div>
      <div>${quiz.category}</div>
      <form:hidden name="quizId" path="question.quiz.id"/>
      <div>
         <c:if test="${not empty questions}">
         <c:forEach items="${questions}" var="quest">
            <div>${quest.questionContent}</div>
         </c:forEach>
         </c:if>
      </div>
      <div><s:message code="label.question.content" text="Type your Question here"/><form:input path="question.questionContent"/></div>
      <div><s:message code="label.question.comment" text="Comments / Hints"/><form:input path="question.comments"/></div>
      <div><s:message code="label.question.type" text="Type of Answer"/>
      <form:select path="question.answerType">
      <form:options items="<%=TypeOfAnswer.values()%>"/>
      </form:select>
      </div>
      <div> <s:message code="label.answers.header" text="Type your options below"/>
        <c:forEach begin="1" end="5" varStatus="status">
        <div><s:message code="label.option.${status.count}" text="Option ${status.count} "/>
             <form:input path="options[${status.count}].answer"/>
             <form:input path="options[${status.count}].marks"/>
        </div>
      </c:forEach>
      </div>
      <div><input type="submit" style="width:100px;height:30px" id="addQues" name="Add Question" value="Add Question"/></div>
    </form:form>
   
    </div>
  </div>
 
</div>
</body>
</html>