(function(){
	"use strict";

app.service("QuizService", ["$http", function($http){
		
		var baseUrl = 'ajax/quiz/';
		this.saveQuizMetaData = function(data){
			return $http.post("submitQuiz", data,{});
		}
		
		this.addQuestions = function(data){
			return $http.post("addQuestions", data,{});
		}
	}]);

})();