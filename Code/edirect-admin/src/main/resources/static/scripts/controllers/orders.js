angular.module('edirect.orders', [ 'ngRoute' ]).config(function($routeProvider) {

	$routeProvider.when('/orders', {
		templateUrl : 'views/orders.html',
		controller : 'orders',
		controllerAs: 'controller'
	});

}).controller('orders', function($http) {
	var self = this;
	$http.get('/edirect-admin/order').then(function(response) {
		self.greeting = response.data;
	})
});