var appModule = angular.module('myApp', []);

appModule
		.controller(
				'MainCtrl',
				[
						'mainService',
						'$scope',
						'$http',
						function(mainService, $scope, $http) {
							$scope.greeting = 'ParkingLot';
							$scope.token = null;
							$scope.error = null;
							$scope.roleUser = false;
							$scope.roleAdmin = false;
							$scope.roleFoo = false;
							$scope.addressGiven = "no address";

							// login logout

							$scope.login = function() {
								$scope.error = null;
								mainService
										.login($scope.userName)
										.then(
												function(token) {
													$scope.token = token;
													$http.defaults.headers.common.Authorization = 'Bearer '
															+ token;
													$scope.checkRoles();
												}, function(error) {
													$scope.error = error
													$scope.userName = '';
												});
							}

							$scope.logout = function() {
								$scope.userName = '';
								$scope.token = null;
								$http.defaults.headers.common.Authorization = '';
							}

							$scope.loggedIn = function() {
								return $scope.token !== null;
							}

							// parking

							$scope.addParking = function() {
								$scope.addedParking = true;
								$scope.error = null;
								mainService.addParking($scope.address);
								window.alert("Parking in " +  $scope.address + " added Succesfully")
							}

							$scope.showParkings = function() {
								mainService.showParkings().then(
										function(address) {
											$scope.addressGiven = address
										});
							}

							// TODO roles - remove

							$scope.checkRoles = function() {
								mainService.hasRole('user').then(
										function(user) {
											$scope.roleUser = user
										});
								mainService.hasRole('admin').then(
										function(admin) {
											$scope.roleAdmin = admin
										});
								mainService.hasRole('foo').then(function(foo) {
									$scope.roleFoo = foo
								});
							}

						} ]);

appModule.service('mainService', function($http) {
	return {
		// login requests
		login : function(username) {
			return $http.post('/user/login', {
				name : username
			}).then(function(response) {
				return response.data.token;
			});
		},
		// parking requests
		addParking : function(address) {
			return $http.post('/parking/addParking', {
				address : address
			});
		},

		showParkings : function() {
			return $http.get('/parking/getParking').then(function(response) {
				console.log(response);
				return response.data;
			});
		},

		// TODO remove

		hasRole : function(role) {
			return $http.get('/api/role/' + role).then(function(response) {
				console.log(response);
				return response.data;
			});
		}
	};
});
