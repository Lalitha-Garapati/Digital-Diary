var mainApp1 = angular.module("mainApp1", []).controller(
	'LogInController',
	function($scope, $http) {
		$scope.processSignIn = function() {

			var queryString = '?email=' + $scope.email + '&password='
			+ $scope.password;

			var url = 'UserInformationServlet' + queryString;

			$http.get(url).then(function(response) {

				var customerData = response.data.status;
				if (customerData != "failure") {
					window.location = "FirstPage.html";
				} else {
					alert("Invalid USERNAME or PASSWORD");
				}

			});
		};
	});