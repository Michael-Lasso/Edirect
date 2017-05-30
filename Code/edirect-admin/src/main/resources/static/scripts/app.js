angular.module('edirect', 
		[ 
		  'ngRoute',
		  'edirect.modify',
		  'edirect.login',
		  'edirect.products',
		  'edirect.upload',
		  'edirect.orders'
		  ]
).config(function($routeProvider, $httpProvider) {
	$routeProvider.when('/', {
		templateUrl : 'views/home.html',
		controller : 'home',
		controllerAs: 'controller'
	}).otherwise('/');

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

}).controller('home', function($http) {
	var self = this;
	$http.get('/edirect-admin/resource/').then(function(response) {
		self.greeting = response.data;
	})
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
