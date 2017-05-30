angular.module('edirect.products', [ 'ngRoute' ]).config(function($routeProvider) {

	$routeProvider.when('/products', {
		templateUrl : 'views/products.html',
		controller : 'products',
		controllerAs: 'controller'
	});

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
});