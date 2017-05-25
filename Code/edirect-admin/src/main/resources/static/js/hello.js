angular.module('hello', [ 'ngRoute' ]).config(function($routeProvider, $httpProvider) {

	$routeProvider.when('/', {
		templateUrl : 'home.html',
		controller : 'home',
		controllerAs: 'controller'
	}).when('/login', {
		templateUrl : 'login.html',
		controller : 'navigation',
		controllerAs: 'controller'
	}).when('/modify', {
		templateUrl : 'modify.html',
		controller : 'modify',
		controllerAs: 'controller'
	}).when('/products', {
		templateUrl : 'products.html',
		controller : 'products',
		controllerAs: 'controller'
	}).when('/orders', {
		templateUrl : 'orders.html',
		controller : 'orders',
		controllerAs: 'controller'
	}).when('/upload', {
		templateUrl : 'upload.html',
		controller : 'upload',
		controllerAs: 'controller'
	}).otherwise('/');

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

}).controller('navigation',

		function($rootScope, $http, $location, $route) {
			
			var self = this;

			self.tab = function(route) {
				return $route.current && route === $route.current.controller;
			};

			var authenticate = function(credentials, callback) {

				var headers = credentials ? {
					authorization : "Basic "
							+ btoa(credentials.username + ":"
									+ credentials.password)
				} : {};

				$http.get('user', {
					headers : headers
				}).then(function(response) {
					if (response.data.name) {
						$rootScope.authenticated = true;
					} else {
						$rootScope.authenticated = false;
					}
					callback && callback($rootScope.authenticated);
				}, function() {
					$rootScope.authenticated = false;
					callback && callback(false);
				});

			}

			authenticate();

			self.credentials = {};
			self.login = function() {
				authenticate(self.credentials, function(authenticated) {
					if (authenticated) {
						console.log("Login succeeded")
						$location.path("/");
						self.error = false;
						$rootScope.authenticated = true;
					} else {
						console.log("Login failed")
						$location.path("/login");
						self.error = true;
						$rootScope.authenticated = false;
					}
				})
			};

			self.logout = function() {
				$http.post('logout', {}).finally(function() {
					$rootScope.authenticated = false;
					$location.path("/login");
				});
			}

		}).controller('home', function($http) {
	var self = this;
	$http.get('/edirect-admin/resource/').then(function(response) {
		self.greeting = response.data;
	})
}).controller('products', function($scope,$http) {
	var self = this;
	$http.get('/edirect-admin/product').then(function(response) {
		self.greeting = response.data;
	})
	$scope.createCategory = function () {
		var req = {
			 method: 'POST',
			 url: '/edirect-admin/product/create',
			 headers: {
			   'Content-Type': "application/json"
			 },
			 data: { city:23, name:"Stamford", address:"26 weed hill", zip:06907
				 		}
			}
	
			$http(req).then(function(response) {
				self.greeting = response.data;
			});
	}
	// post
    $scope.SendData = function () {
        // use $.param jQuery function to serialize data from JSON
 		var req = {
 				 method: 'POST',
 				 url: '/edirect-admin/product/create',
 				 headers: {
 				   'Content-Type': "application/json"
 				 },
 				 data: { 
	 					 city:$scope.city, 
	 					 name: $scope.name,
	 		             address: $scope.address,
	 		             zip: $scope.zip
 					 		}
 				}

 		$http(req).then(function(response) {
			self.greeting = response.data;
		});
     };
}).controller('orders', function($http) {
	var self = this;
	$http.get('/edirect-admin/order').then(function(response) {
		self.greeting = response.data;
	})
}).controller('modify', function($scope,$http, $log) {
	
    $scope.retrieveCategories = function () {
    	$http.get('/edirect-admin/list/category').success(function(response) {
    		self.categories = response.data;
    	}).error(function(data, status, headers, config){
	        $log.log("Categories were not retrieved")
	    });
     };
	// post
	$log.log("this is a test");
    $scope.createCategory = function () {
        // use $.param jQuery function to serialize data from JSON
 		var req = {
 				 method: 'POST',
 				 url: '/edirect-admin/create/category',
 				 headers: {
 				   'Content-Type': "application/json"
 				 },
		       interceptor: {
		            response: function(response) {      
		                var result = response.resource;        
		                result.$status = response.status;
		                return result;
		            }
		       },
			 data: { 
 					 category_name:$scope.name, 
 					 description: $scope.description
				 		}
 				}

 		$http(req).success(function(data, status, headers, config) {
 			$log.log("Category created")
		}).error(function(data, status, headers, config){
	        $log.log("Category was not created")
	    });
     };
});

function htmlbodyHeightUpdate(){
	var height3 = $( window ).height()
	var height1 = $('.nav').height()+50
	height2 = $('.main').height()
	if(height2 > height3){
		$('html').height(Math.max(height1,height3,height2)+10);
		$('body').height(Math.max(height1,height3,height2)+10);
	}
	else
	{
		$('html').height(Math.max(height1,height3,height2));
		$('body').height(Math.max(height1,height3,height2));
	}
	
}
$(document).ready(function () {
	htmlbodyHeightUpdate()
	$( window ).resize(function() {
		htmlbodyHeightUpdate()
	});
	$( window ).scroll(function() {
		height2 = $('.main').height()
			htmlbodyHeightUpdate()
	});
});
