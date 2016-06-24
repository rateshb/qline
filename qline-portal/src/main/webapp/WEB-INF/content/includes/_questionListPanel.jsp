<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="panel-group">
  <div class="panel panel-default">
    <div class="panel-heading">
    <h4 class="panel-title">
        <a data-toggle="collapse" href="#questionList">Question List</a>
        (Click on text to see details)
      </h4>
      </div>
    <div id="questionList" class="panel-collapse collapse">
              <c:if test="${not empty questions}">
							<c:forEach items="${questions}" var="question">
				<div class="panel-body">
					<div class="col-md-3">
						<div class="cmnSubHead">
							<s:message code="label.qusetion.content" text="Question Content"/>
						</div>
						<span>${question.questionContent}</span>
					</div>
					<div class="col-md-3">
						<div class="cmnSubHead">
							<s:message code="label.question.answerType" text="Answer Type"/>
						</div>
						<span>${question.answerType.displayString}</span>
					</div>
					<div class="col-md-6">
						<div class="cmnSubHead">
							<s:message code="label.question.options" text="Options"/> /
							<s:message code="label.question.marks" text="Marks"/>
						</div>
						<ul>
						<c:forEach items="${question.options}" var="answerOption">
						<li>${answerOption.answer} / ${answerOption.marks}</li>
						</c:forEach>
						</ul>
					</div>
				</div>
				</c:forEach>
				</c:if>
				

				</div>
				</div>
				</div>