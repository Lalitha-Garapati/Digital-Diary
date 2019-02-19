var comp3 = angular.module("comp3", []).controller("FriendsDetailsCtrl",
		function($scope, $http) {
			$http.get('FriendInformationServlet').then(function(response) {
				$scope.details = response.data.friends
			})
		});
