<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="panel-group">
  <div class="panel panel-default">
    <div class="panel-heading">
    <h4 class="panel-title">
        <a data-toggle="collapse" href="#quizDetails">Quiz Details</a>
        (Click on text to see details)
      </h4>
      </div>
    <div id="quizDetails" class="panel-collapse collapse">
				<div class="panel-body">
					<div class="col-md-4">
						<div class="cmnSubHead">
							<s:message code="label.quiz.name" text="Quiz Name"/>
						</div>
						<span>${quiz.name}</span>
					</div>
					<div class="col-md-4">
						<div class="cmnSubHead">
							<s:message code="label.quiz.category" text="Category"/>
						</div>
						<span>${quiz.category}</span>
					</div>
					<div class="col-md-4">
						<div class="cmnSubHead">
							<s:message code="label.quiz.subCategory" text="Sub Category"/>
						</div>
						<span>${quiz.subCategory}</span>
					</div>
				</div>
				<div class="panel-body">
					<div class="col-md-4">
						<div class="cmnSubHead">
							<s:message code="label.quiz.typeOfQuiz" text="Type of Quiz"/>
						</div>
						<span>${quiz.typeOfQuiz}</span>
					</div>
					<div class="col-md-4">
						<div class="cmnSubHead">
							<s:message code="label.quiz.noOfQuestions" text="Number of Questions"/>
						</div>
						<span>${quiz.noOfQuestions}</span>
					</div>
					<div class="col-md-4">
						<div class="cmnSubHead">
							<s:message code="label.quiz.markingRequired" text="Is Marking Required"/>
						</div>
						<span>${quiz.markingRequired}</span>
					</div>
				</div>
				</div>
				</div>
				</div>