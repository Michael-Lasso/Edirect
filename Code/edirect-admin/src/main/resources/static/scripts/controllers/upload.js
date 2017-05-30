angular.module('edirect.upload', [ 'ngRoute' ]).config(function($routeProvider) {

	$routeProvider.when('/upload', {
		templateUrl : 'views/upload.html',
		controller : 'upload',
		controllerAs: 'controller'
	});

}).controller('upload', function($scope,$http, $log) {
	$http.get('/edirect-admin/upload/inventory').success(function(response) {
		$scope.content = response.content;
		$scope.stat = "a test 1"
	}).error(function(data, status, headers, config){
        $log.log("Categories were not retrieved")
    });
});