(function(){
	"use strict";
	app.controller("QuizController", ["$scope", "$state", "$location", "QuizService", function($scope, $state, $location, QuizService){
		
		$scope.quiz={};
		$scope.submitQuiz = function(){
			QuizService.saveQuizMetaData($scope.quiz).then(function(data){
				if(data.data.error){
	    			alert(data.data.error.message);
				}
				else {
					$scope.quiz=data.data.result;
					$location.path('/addQuestions');
					//$state.go("addQuestions");
				}
			});
		}
		
		$scope.addQuestions = function(){
			QuizService.addQuestions($scope.quiz).then(function(data){
				if(data.data.error){
	    			alert(data.data.error.message);
				}
				else {
					$scope.quiz=data.data.result;
					$location.path('/addQuestions');
					//$state.go("addQuestions");
				}
			});
		}
		
	}]);
	
	
	
	
})();