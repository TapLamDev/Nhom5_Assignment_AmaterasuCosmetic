const app = angular.module("app", []);
app.controller("register-ctrl", function($scope, $http) {
	$scope.form = {};
	$scope.items = [];

	$scope.reset = function() {
		$scope.form = {};
	}

	$scope.initialize = function() {
		$http.get("/rest/register").then(resp => {
			$scope.items = resp.data;
			console.log("Success", resp);
		})
	}

	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http.post('/rest/register', item).then(resp => {
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Tạo tài khoản mới thành công!");
		}).catch(error => {
			alert("Tạo tài khoản không thành công!");
			console.log("Error", error);
		});
	}
	//js
	$scope.initialize();
	$scope.reset();
});