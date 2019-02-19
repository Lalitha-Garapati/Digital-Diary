var app = angular.module("app", [ "ngRoute", "mainApp", "mainApp1" ]).config(
	function($routeProvider) {
		$routeProvider.when("/LogIn", {
			templateUrl : "LogIn.html",
			controller : "LogInController"
		}).when("/SignUp", {
			templateUrl : "SignUpForm.html",
			controller : "UserController"
		})
	});

var app1 = angular.module("app1",
	[ "ngRoute", "friends", "comp3", "bank", "comp1" , "remainder", "comp2" ]).config(
	function($routeProvider) {
		$routeProvider.when("/AddFriend", {
			templateUrl : "FriendsInformation.html",
			controller : "FriendsController"
		}).when("/FriendsDetails", {
			templateUrl : "FriendsDetails.html",
			controller : "FriendsDetailsCtrl"
		}).when("/BankAccountDetails", {
			templateUrl : "BankAccountInformation.html",
			controller : "BankController"
		}).when("/AccountsList", {
			templateUrl : "BankAccountsList.html",
			controller : "bankAccountsList"
		}) .when("/AddRemainders", {
			templateUrl : "Remainders.html",
			controller : "RemainderController"
		}).when("/RemaindersList", {
			templateUrl : "RemaindersList.html",
			controller : "RemaindersListCtrl"
		})
	});