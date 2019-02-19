var mainApp = angular
	.module("mainApp", [])
	.controller(
		'UserController',
		function($scope, $http) {
			$scope.processSignUp = function() {
				var queryString = '?name=' + $scope.name + '&email='
				+ $scope.email + '&password=' + $scope.password;
				var url = 'UserCreationServlet' + queryString;
				$http
					.get(url)
					.then(
						function(response) {
							var regStatus = response.data.status;

							if (regStatus == "success") {
								document.getElementById("signUpForm").reset();
								window.location = "Login.html";

							} else {
								alert("Sign Up Unsuccessful\nPlease check your details");
							}

						});
			};
		});