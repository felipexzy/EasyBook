var a = angular.module('teste', []);
a.controller('testeController', function($scope, $http){
    
	$scope.editar = function(a){
		console.log(a)
	}
    
});

