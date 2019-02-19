var remainder = angular
		.module("remainder", [])
		.controller(
				'RemainderController',
				function($scope, $http) {
					$scope.RemainderDetailsInsertion = function() {
						var queryString = '?title=' + $scope.title
								+ '&description=' + $scope.description
								+ '&date_day=' + $scope.date_day;
						var url = 'RemainderCreationServlet' + queryString;
						$http
								.get(url)
								.then(
										function(response) {
											var customerData = response.data.remainders;
											if (customerData != "") {
												textToDisplay = "Successfully added your details";
											} else {
												textToDisplay = "Please try again";
											}
											document
													.getElementById("displayArea").innerHTML = textToDisplay;
										});
					};
				});