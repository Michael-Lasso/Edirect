angular.module('edirect.upload', [ 'ngRoute' ]).config(
		function($routeProvider) {

			$routeProvider.when('/upload', {
				templateUrl : 'views/upload.html',
				controller : 'upload',
				controllerAs : 'controller'
			});

		}).controller('upload', function($scope, $http, $log) {
	$http.get('upload/inventory').success(function(response) {
		$scope.content = response.content;
		$scope.stat = "a test 1"
	}).error(function(data, status, headers, config) {
		$log.log("Categories were not retrieved")
	});

	$scope.re_stock_item = [ {
		'product_id' : '1002',
		'description' : 'test 1',
		'quantity' : 3,
		'user' : 'jose',
		'date' : '2016-09-09'
	}, {
		'product_id' : '1002',
		'description' : 'test 2',
		'quantity' : 2,
		'user' : 'mlasso',
		'date' : '2016-09-09'
	} ];

	$scope.addRow = function() {
		$scope.re_stock_item.push({
			product_id : $scope.product_id,
			description : $scope.description,
			quantity : $scope.quantity,
			ser : $scope.user,
			date : $scope.date,
		});
		$scope.product_id = '';
		$scope.description = '';
		$scope.quantity = '';
		$scope.user = '';
		$scope.date = '';
	};
});