angular
		.module('edirect.modify', [ 'ngRoute' ])
		.config(function($routeProvider) {

			$routeProvider.when('/modify', {
				templateUrl : 'views/modify.html',
				controller : 'modify',
				controllerAs : 'controller'
			});

		})
		.controller(
				'modify',
				function($scope, $http, $log) {

					$http.get('/edirect-admin/list/category').success(
							function(response) {
								$scope.categories = angular
										.fromJson(response.content);
								$scope.stat = "a test 1"
							}).error(function(data, status, headers, config) {
						$log.log("Categories were not retrieved")
					});

					$http.get('/edirect-admin/list/warehouse').success(
							function(response) {
								$scope.warehouses = angular
										.fromJson(response.content);
								$scope.stat = "warehouse retrieved"
							}).error(
							function(data, status, headers, config) {
								var t = "4.5"
								var t2 = "0.29"
								$log.log("warehouses were not retrieved: "
										+ (parseFloat(t, 10) + parseFloat(t2,
												10)));
							});

					// post
					$scope.createCategory = function() {
						// use $.param jQuery function to serialize data from
						// JSON
						var req = {
							method : 'POST',
							url : 'create/category',
							headers : {
								'Content-Type' : "application/json"
							},
							interceptor : {
								response : function(response) {
									var result = response.resource;
									result.$status = response.status;
									return result;
								}
							},
							data : {
								category_name : $scope.category_name,
								description : $scope.category_description
							}
						}

						$http(req).success(
								function(data, status, headers, config) {
									alert("Category created")
								}).error(
								function(data, status, headers, config) {
									alert("Category was not created")
								});
					};
					$scope.createProduct = function() {
						var req = {
							method : 'POST',
							url : '/edirect-admin/create/product',
							headers : {
								'Content-Type' : "application/json"
							},
							interceptor : {
								response : function(response) {
									var result = response.resource;
									result.$status = response.status;
									return result;
								}
							},
							data : {
								category_id : $scope.selectedCategory.category_id,
								product_name : $scope.product_name,
								description : $scope.product_description,
								featured_product : false,
								company_name : $scope.prod_company_name,
								buy_price : parseFloat($scope.prod_buy_price),
								sell_price : parseFloat($scope.prod_sell_price),
								packaging : ($scope.packaging == "true"),
								video_link : $scope.video_link,
								treshold_max : parseInt($scope.treshold_max),
								treshold_min : parseInt($scope.treshold_min),
								weight : parseFloat($scope.weight),
								dimension : $scope.dimension,
								logistic_price : parseFloat($scope.logistic_price),
								tarif : parseFloat($scope.tarif),
								percentage_deal : parseFloat($scope.percentage_deal),
								season_reup_alert_days : parseInt($scope.season_reup_alert_days),
								season_reup_alert_date : $scope.season_reup_alert_date,
								tags : $scope.tags
							}
						}

						$http(req).success(
								function(data, status, headers, config) {
									alert("Product created")
								}).error(
								function(data, status, headers, config) {
									alert("Product was not created")
								});
					};

					$scope.createWarehouse = function() {
						// use $.param jQuery function to serialize data from
						// JSON
						var req = {
							method : 'POST',
							url : '/edirect-admin/create/warehouse',
							headers : {
								'Content-Type' : "application/json"
							},
							interceptor : {
								response : function(response) {
									var result = response.resource;
									result.$status = response.status;
									return result;
								}
							},
							data : {
								warehouse_name : $scope.warehouse_name,
								street : $scope.warehouse_street,
								city : $scope.warehouse_city,
								state : $scope.warehouse_state,
								zip_code : $scope.warehouse_zipcode,
								country : $scope.warehouse_country,
								phone_number : $scope.season_reup_alert_date
							}
						}

						$http(req).success(
								function(data, status, headers, config) {
									alert("Warehouse created")
								}).error(
								function(data, status, headers, config) {
									alert("warehouse not created")
								});
					};
					$scope.createAdministrator = function() {
						// use $.param jQuery function to serialize data from
						// JSON
						var req = {
							method : 'POST',
							url : '/edirect-admin/create/admin',
							headers : {
								'Content-Type' : "application/json"
							},
							interceptor : {
								response : function(response) {
									var result = response.resource;
									result.$status = response.status;
									return result;
								}
							},
							data : {
								warehouse_id : $scope.selectedWarehouse.warehouse_id,
								first_name : $scope.first_name,
								last_name : $scope.last_name,
								street : $scope.admin_street,
								city : $scope.admin_city,
								state : $scope.admin_state,
								zip_code : $scope.admin_zipcode,
								country : $scope.admin_country,
								phone_number : $scope.admin_phone,
								email : $scope.email,
								password : $scope.password,
								permissions : $scope.permissions
							}
						}

						$http(req).success(
								function(data, status, headers, config) {
									alert("Administrator created")
								}).error(
								function(data, status, headers, config) {
									alert("Administrator was not created")
								});
					};
					$scope.createDeal = function() {
						// use $.param jQuery function to serialize data from
						// JSON
						var req = {
							method : 'POST',
							url : '/edirect-admin/create/deal',
							headers : {
								'Content-Type' : "application/json"
							},
							interceptor : {
								response : function(response) {
									var result = response.resource;
									result.$status = response.status;
									return result;
								}
							},
							data : {
								category_id : parseInt($scope.selectedCategory.category_id),
								product_id : parseInt($scope.deal_product_id),
								deal_name : $scope.deal_name,
								start_date : $scope.deal_start_date,
								end_date : $scope.deal_end_date
							}
						}

						$http(req).success(
								function(data, status, headers, config) {
									alert("Deal created: " + $scope.deal_name)
								}).error(
								function(data, status, headers, config) {
									alert("Deal was not created")
								});
					};
					$scope.createImage = function() {
						// use $.param jQuery function to serialize data from
						// JSON
						var req = {
							method : 'POST',
							url : '/edirect-admin/create/image',
							headers : {
								'Content-Type' : "application/json"
							},
							interceptor : {
								response : function(response) {
									var result = response.resource;
									result.$status = response.status;
									return result;
								}
							},
							data : {
								product_id : parseInt($scope.image_product_id),
								image_name : $scope.image_name,
								url : $scope.image_url
							}
						}

						$http(req).success(
								function(data, status, headers, config) {
									alert("Image created")
								}).error(
								function(data, status, headers, config) {
									alert("Image was not created")
								});
					};
					$scope.createAffiliatedCompany = function() {
						var req = {
							method : 'POST',
							url : '/edirect-admin/create/affiliated_company',
							headers : {
								'Content-Type' : "application/json"
							},
							interceptor : {
								response : function(response) {
									var result = response.resource;
									result.$status = response.status;
									return result;
								}
							},
							data : {
								discount_id : parseInt($scope.discount_id_number),
								start_affiliated_date : $scope.start_affiliated_date,
								end_affiliated_date : $scope.end_affiliated_date,
								company_name : $scope.affi_company_name,
								street : $scope.company_street,
								city : $scope.company_city,
								state : $scope.company_state,
								zip_code : $scope.company_zipcode,
								country : $scope.company_country,
								phone_number : $scope.company_phone,
								company_email : $scope.company_email
							}
						}

						$http(req).success(
								function(data, status, headers, config) {
									alert("Company created")
								}).error(
								function(data, status, headers, config) {
									alert("Company was not created")
								});
					};
					$scope.createDiscountCode = function() {
						// use $.param jQuery function to serialize data from
						// JSON
						var req = {
							method : 'POST',
							url : '/edirect-admin/create/discount_code',
							headers : {
								'Content-Type' : "application/json"
							},
							interceptor : {
								response : function(response) {
									var result = response.resource;
									result.$status = response.status;
									return result;
								}
							},
							data : {
								category_id : parseInt($scope.selectedCategory.category_id),
								start_date : $scope.discount_start_date,
								end_date : $scope.discount_end_date,
								discount_name : $scope.discount_name,
								discount_code : $scope.discount_code
							}
						}

						$http(req).success(
								function(data, status, headers, config) {
									alert("Discount Code created")
								}).error(
								function(data, status, headers, config) {
									alert("Discount code was not created")
								});
					};
					$scope.createAlert = function() {
						// use $.param jQuery function to serialize data from
						// JSON
						var req = {
							method : 'POST',
							url : '/edirect-admin/create/email_alert',
							headers : {
								'Content-Type' : "application/json"
							},
							interceptor : {
								response : function(response) {
									var result = response.resource;
									result.$status = response.status;
									return result;
								}
							},
							data : {
								alert_id : $scope.description,
								type_id : $scope.type_id,
								alert_name : $scope.alert_name,
								property_id : parseInt($scope.property_id),
								description : $scope.alert_description,
								created_date : $scope.alert_date

							}
						}

						$http(req).success(
								function(data, status, headers, config) {
									alert("Alert created")
								}).error(
								function(data, status, headers, config) {
									alert("Alert was not created")
								});
					};
				});