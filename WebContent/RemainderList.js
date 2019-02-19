var comp2 = angular.module("comp2", []).controller("RemaindersListCtrl",
		function($scope, $http) {
			$http.get('RemainderInformationServlet').then(function(response) {
				$scope.remainders = response.data.remainders;
			})
		});