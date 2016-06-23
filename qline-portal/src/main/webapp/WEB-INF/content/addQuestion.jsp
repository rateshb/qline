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

					<div>
						<c:if test="${not empty questions}">
							<c:forEach items="${questions}" var="quest">
								<div>${quest.questionContent}</div>
							</c:forEach>
						</c:if>
					</div>
									
				<!--div class="form-group">${quiz.name}</div>
				<div class="form-group">${quiz.category}</div-->
				<form:form modelAttribute="questionModel" action="addQuestionN">
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
								<form:input path="options[${status.count}].answer" />
								<form:input path="options[${status.count}].marks" />
							</div>
						</c:forEach>
					</div>
					<div>
						<input type="submit" class="btn btn-success" id="addQues"
							name="Add Question" value="Add Question" />
					</div>
				</form:form>
			</div>
		</div>

	</div>

	<script>
		$(document).ready(function() {
			$('#addQuestionForm').on('submit', function() {
				$.post({
					url : '${pageContext.request.contextPath}/addQuestion',
					data : $('#addQuestionForm').serialize(),
					success : function() {
						window.location.reload();
					},
					error : function(ex) {
						console.log(ex);
						alert("An error has occured. Please try again later.");
					}
				});
			});
		});
	</script>
</body>
</html>