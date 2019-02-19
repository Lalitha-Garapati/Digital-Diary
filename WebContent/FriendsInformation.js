var friends = angular
	.module("friends", [])
	.controller(
		'FriendsController',
		function($scope, $http) {
			$scope.FriendDetailsInsertion = function() {
				var birth = $scope.birthday.getDate() + "-" + $scope.birthday.getMonth() + "-" + $scope.birthday.getYear();
				//alert(birth);
				var queryString = '?friendName=' + $scope.friendName
				+ '&address=' + $scope.address + '&birthday='
				+ birth + '&mobile=' + $scope.mobile
				+ '&email=' + $scope.email;
				alert("" + queryString);
				var url = 'FriendsCreationServlet' + queryString;
				$http
					.get(url)
					.then(
						function(response) {
							var customerData = response.data.friends;
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