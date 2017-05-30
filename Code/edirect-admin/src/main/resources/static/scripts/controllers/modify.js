angular.module('edirect.modify', [ 'ngRoute' ]).config(function($routeProvider) {

	$routeProvider.when('/modify', {
		templateUrl : 'views/modify.html',
		controller : 'modify',
		controllerAs: 'controller'
	});

}).controller('modify', function($scope,$http, $log) {
    
	$http.get('/edirect-admin/list/category').success(function(response) {
		$scope.categories = angular.fromJson(response.content);
		$scope.stat = "a test 1"
	}).error(function(data, status, headers, config){
        $log.log("Categories were not retrieved")
    });
     
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