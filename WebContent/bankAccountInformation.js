var bank = angular
		.module("bank", [])
		.controller(
				'BankController',
				function($scope, $http) {
					$scope.bankDetailsInsertion = function() {
						var queryString = '?userName=' + $scope.userName
								+ '&accountno=' + $scope.accountno
								+ '&bankName=' + $scope.bankName + '&Location='
								+ $scope.Location;
						var url = 'BankAccountDetailsServlet' + queryString;
						$http
								.get(url)
								.then(
										function(response) {
											var customerData = response.data.accounts;
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
