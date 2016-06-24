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

             <jsp:include page="./includes/_quizDetailsPanel.jsp"/>
			<jsp:include page="./includes/_questionListPanel.jsp"/>
				<!--div class="form-group">${quiz.name}</div>
				<div class="form-group">${quiz.category}</div-->
				<form:form id="addQuestionForm" modelAttribute="questionModel" action="addQuestionN">
					<form:hidden name="quizId" path="question.quiz.id" />
					<div class="form-group">
						<label><s:message code="label.question.content"
								text="Type your Question here" /></label>
						<form:input class="form-control" path="question.questionContent" />
					</div>
					<div class="form-group">
						<label><s:message code="label.question.comment"
								text="Comments / Hints" /></label>
						<form:input class="form-control" path="question.comments" />
					</div>
					<div class="form-group">
						<label><s:message code="label.question.type"
								text="Type of Answer" /></label>
						<form:select class="form-control" path="question.answerType">
							<form:options items="<%=TypeOfAnswer.values()%>"
								itemLabel="displayString" />
						</form:select>
					</div>
					<div class="form-group">
						<label><s:message code="label.answers.header"
								text="Type your options below" /></label>
						<c:forEach begin="1" end="5" varStatus="status">
							<div class="form-group">
								<label><s:message code="label.option.${status.count}"
										text="Option ${status.count} " /></label>
								<form:input path="options[${status.count -1}].answer" />
								<form:input path="options[${status.count - 1}].marks" />
							</div>
						</c:forEach>
					</div>
					<div>
						<input type="submit" class="btn btn-success" id="addQues"
							name="Add Question" value="Add Question" />
					</div>
				</form:form>
				<c:if test="${quiz.status != 'COMPLETE'}">
				  <input type="button" class="btn btn-success" id="completeQuiz"
							name="Complete Quiz" value="Complete Quiz" />
				</c:if>
			</div>
		</div>

	</div>

	<script>
		$(document).ready(function() {
			$('#completeQuiz').on('click', function() {
				$.post({
					url : '${pageContext.request.contextPath}/completeQuiz',
					data : {quizId:$('#quizId')},
					success : function() {
						window.location.reload();
					},
					error : function(ex) {
						alert("An error has occured. Please try again later.");
					}
				});
			});
		});
	</script>
</body>
</html>