var appModule = angular.module('myApp', []);

appModule.controller('MainCtrl', ['mainService','$scope','$http',
        function(mainService, $scope, $http) {
            $scope.greeting = 'ParkingLot';
            $scope.token = null;
            $scope.error = null;
            $scope.roleUser = false;
            $scope.roleAdmin = false;
            $scope.roleFoo = false;
            $scope.addedParking = false;
            $scope.addressGiven = "no address";

            $scope.login = function() {
                $scope.error = null;
                mainService.login($scope.userName).then(function(token) {
                    $scope.token = token;
                    $http.defaults.headers.common.Authorization = 'Bearer ' + token;
                    $scope.checkRoles();
                },
                function(error){
                    $scope.error = error
                    $scope.userName = '';
                });
            }
            
            $scope.addParking = function() {
            	$scope.addedParking = true;
            	$scope.error = null;
                mainService.addParking($scope.address);
                window.alert("OK");
            }
            
            $scope.checkRoles = function() {
                mainService.hasRole('user').then(function(user) {$scope.roleUser = user});
                mainService.hasRole('admin').then(function(admin) {$scope.roleAdmin = admin});
                mainService.hasRole('foo').then(function(foo) {$scope.roleFoo = foo});
            }

            $scope.logout = function() {
                $scope.userName = '';
                $scope.token = null;
                $http.defaults.headers.common.Authorization = '';
            }

            $scope.added = function() {
            	return $scope.addedParking;
            }
            
            $scope.showParkings = function() {
            	mainService.showParkings().then(function(address) {$scope.addressGiven = address});
            }
            
            $scope.loggedIn = function() {
                return $scope.token !== null;
            }
            
        } ]);



appModule.service('mainService', function($http) {
    return {
        login : function(username) {
            return $http.post('/user/login', {name: username}).then(function(response) {
                return response.data.token;
            });
        },
        
        addParking : function(address) {
            return $http.post('/user/addParking', {address: address});
        },

        hasRole : function(role) {
            return $http.get('/api/role/' + role).then(function(response){
                console.log(response);
                return response.data;
            });
        },
        
        showParkings : function() {
        	return $http.get('/user/getParking').then(function(response){
                console.log(response);
                return response.data;
            });
        }
    };
});
