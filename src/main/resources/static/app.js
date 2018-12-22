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
										.login($scope.userName,$scope.password)
										.then(
												function(token) {
													$scope.token = token;
													$http.defaults.headers.common.Authorization = 'Bearer '
															+ token;
												}, function(error) {
													$scope.error = error
													$scope.userName = '';
													$scope.password = '';
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
							
							$scope.signUp = function() {
								mainService.signUp($scope.userNameS,$scope.passwordS);
								$scope.passwordS='';
								$scope.userNameS='';
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
											$scope.parkings.sort(function(p1,p2){
												return p1.id - p2.id;
											});
										});
							}
						} ]);

appModule.service('mainService', function($http) {
	return {
		// login requests
		login : function(username,password) {
			return $http.post('/user/login', {
				name : username,
				password: password
			}).then(function(response) {
				return response.data.token;
			});
		},
		
		signUp : function(email, password) {
			return $http.post('/user/signUp', {
				name : email,
				password: password
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
