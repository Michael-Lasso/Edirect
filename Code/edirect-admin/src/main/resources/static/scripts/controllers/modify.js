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
	
	$http.get('/edirect-admin/list/warehouse').success(function(response) {
		$scope.warehouses = angular.fromJson(response.content);
		$scope.stat = "warehouse retrieved"
	}).error(function(data, status, headers, config){
        $log.log("warehouse not retrieved")
    });
     
	// post
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
 					 category_name:$scope.category_name, 
 					 description: $scope.description
				 		}
 				}

 		$http(req).success(function(data, status, headers, config) {
 			$log.log("Category created")
		}).error(function(data, status, headers, config){
	        $log.log("Category was not created")
	    });
     };
     $scope.createProduct = function () {
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
  					 category_name:$scope.category_name, 
  					 description: $scope.description
 				 		}
  				}

  		$http(req).success(function(data, status, headers, config) {
  			$log.log("Category created")
 		}).error(function(data, status, headers, config){
 	        $log.log("Category was not created")
 	    });
      };
      
      $scope.createWarehouse= function () {
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
   					 category_name:$scope.category_name, 
   					 description: $scope.description
  				 		}
   				}

   		$http(req).success(function(data, status, headers, config) {
   			$log.log("Category created")
  		}).error(function(data, status, headers, config){
  	        $log.log("Category was not created")
  	    });
       };
       $scope.createAdministrator = function () {
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
    					 category_name:$scope.category_name, 
    					 description: $scope.description
   				 		}
    				}

    		$http(req).success(function(data, status, headers, config) {
    			$log.log("Category created")
   		}).error(function(data, status, headers, config){
   	        $log.log("Category was not created")
   	    });
        };
        $scope.createDeal = function () {
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
     					 category_name:$scope.category_name, 
     					 description: $scope.description
    				 		}
     				}

     		$http(req).success(function(data, status, headers, config) {
     			$log.log("Category created")
    		}).error(function(data, status, headers, config){
    	        $log.log("Category was not created")
    	    });
         };
         $scope.createImage= function () {
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
      					 category_name:$scope.category_name, 
      					 description: $scope.description
     				 		}
      				}

      		$http(req).success(function(data, status, headers, config) {
      			$log.log("Category created")
     		}).error(function(data, status, headers, config){
     	        $log.log("Category was not created")
     	    });
          };
          $scope.createAffiliatedCompany = function () {
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
       					 category_name:$scope.category_name, 
       					 description: $scope.description
      				 		}
       				}

       		$http(req).success(function(data, status, headers, config) {
       			$log.log("Category created")
      		}).error(function(data, status, headers, config){
      	        $log.log("Category was not created")
      	    });
        };
        $scope.createDiscountCode = function () {
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
     					 category_name:$scope.category_name, 
     					 description: $scope.description
    				 		}
     				}

     		$http(req).success(function(data, status, headers, config) {
     			$log.log("Category created")
    		}).error(function(data, status, headers, config){
    	        $log.log("Category was not created")
    	    });
         };
         $scope.createAlert = function () {
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
      					 category_name:$scope.category_name, 
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