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
							$scope.parkings = null;

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
								mainService.addParking($scope.address, $scope.userName);
								window.alert("Parking in " +  $scope.address + " added Succesfully")
							}

							$scope.showParkings = function() {
								mainService.showParkings().then(
										function(parkings) {
											$scope.parkings = parkings
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
		addParking : function(address, userName) {
			return $http.post('/parking/addParking', {
				address : address,
				userName: userName
			});
		},

		showParkings : function() {
			return $http.get('/parking/getParking').then(function(response) {
				console.log(response);
				return response.data;
			});
		}
	};
});
