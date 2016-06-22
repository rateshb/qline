(function(){
	"use strict";
	app.controller("QuizController", ["$scope", "$state", "$location","$stateParams", "QuizService", function($scope, $state, $location, $stateParams, QuizService){
		
		$scope.quiz={};
		$scope.question={quiz:{}, options:[]};
		$scope.questions=[];
		$scope.answerType= ["SUBJECTIVE", "OBJECTIVE_SINGLE_CHOICE", "OBJECTIVE_MULTIPLE_CHOICE", "MIXED"];
		
		//init();
		initQuiz();
		
		$scope.submitQuiz = function(){
			QuizService.saveQuizMetaData($scope.quiz).then(function(data){
				if(data.data.error){
	    			alert(data.data.error.message);
				}
				else {
					$scope.quiz=data.data.result;
					//$scope.question.quizId=$scope.quiz.id;
					//$location.path('/start/addQuestions/'+$scope.quiz.id);
					$state.go("addQuestions", {quizId:$scope.quiz.id});
				}
			});
		}
		
		$scope.addQuestions = function(){
			var id = $stateParams.quizId;
			$scope.question.quiz.id = id;
			initQuiz();
			QuizService.addQuestions($scope.question).then(function(data){
				if(data.data.error){
	    			alert(data.data.error.message);
				}
				else {
					//move to init method on page refresh
					$scope.questions=data.data.result;
					$scope.question={quiz:{}, options:[]};
					//$state.go("addQuestions", {quizId:id});
					//$location.path('/addQuestions');
					//$state.go("addQuestions");
				}
			});
		}
		
		
		function initQuiz(){
			if($stateParams.quizId && isEmpty($scope.quiz)){
					QuizService.getQuizById($stateParams.quizId).then(function(data){
						if(data.data.error){
			    			alert(data.data.error.message);
						}
						else {
							if(data.data.result){
								$scope.quiz = data.data.result;
							}
							else{
								$scope.quiz={};
							}
						}
					});			
			}
		};
		
		
		function isEmpty(obj) {
		    return (Object.getOwnPropertyNames(obj).length === 0);
		}
		
	}]);
	
	
	
	
})();