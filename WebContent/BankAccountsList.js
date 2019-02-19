var comp1 = angular.module("comp1", []).controller("bankAccountsList",
		function($scope, $http) {
			$http.get('BankInformationServlet').then(function(response) {
				$scope.details = response.data.accounts;
			})
		});
