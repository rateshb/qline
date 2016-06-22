"use strict";

var app = angular
		.module('qlineApp', [ 'ui.router', 'ui.bootstrap', 'ngSanitize'])
		.run(function ($rootScope, $state, $http) {
			$rootScope.hasPendingRequests = function() {
				    return $http.pendingRequests.length > 0;
				  };
				
				  //home page
				  $state.go("start");
					
		})
		.config(function($stateProvider, $urlRouterProvider, $provide, $httpProvider) {
			//Enable after user log-in implemented
			/*		$provide.factory('AuthHttpInterceptor', function ($q, $window) {
						return {
							responseError: function (rejection) {
								// force a page reload so we can get around the authentication
								// redirect error on a timeout. This is hacky, but works.
								switch (rejection.status) {
									case 500: {
										$window.alert(rejection.data.error.message);																		
										break;
									}
								}
								
								$window.location.reload();
								return $q.reject(rejection);
							}
						};
					});
					$httpProvider.interceptors.push('AuthHttpInterceptor');
			 	*/
			
			$urlRouterProvider.when('/start', '/start');
			$urlRouterProvider.when('', '/start');		
			$urlRouterProvider.otherwise("/start");
			$stateProvider
					.state('start', {
						url : '/start',
						views:{
							"start" :{ controller : 'QuizController',
										templateUrl : 'resources/templates/createQuizMetaData.html'
									}
							}
						
					})
					.state('addQuestions', {
						url : '/:quizId/addQuestions',
						views:{
							"start" :{ controller : 'QuizController',
										templateUrl : 'resources/templates/addQuestions.html'
									}
							}
						
					});

			
		});
		

app.controller('mainController', [ '$scope', '$http', '$state',
		'QuizService', function($scope, $http, $state, QuizService) {
	
		
		
		}]);