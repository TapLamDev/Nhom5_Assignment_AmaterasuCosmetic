const app = angular.module("app", []);
app.controller("category-ctrl", function($scope, $http) {
	$scope.form = {};
	$scope.items = [];

	$scope.reset = function() {
		$scope.form = {};
	}

	$scope.initialize = function() {
		$http.get("/rest/categories").then(resp => {
			$scope.items = resp.data;
			console.log("Success", resp);
		})
	}

	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		var formContainer = document.getElementById('brandForm');
		formContainer.scrollIntoView({ behavior: 'smooth' });
	}


	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http.post('/rest/categories', item).then(resp => {
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm mới Category thành công");
		}).catch(error => {
			alert("Lỗi thêm mới!");
			console.log("Error", error);
		});
	}

	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http.put('/rest/categories/' + item.id, item).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items[index] = item;
			alert("Cập nhật thương hiệu thành công");
		}).catch(error => {
			alert("Lỗi cập nhật!");
			console.log("Error", error);
		});
	}
	$scope.delete = function(item) {
		$http.delete('/rest/categories/' + item.id).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert("Xóa Category thành công");
			// Gọi lại hàm để cập nhật dữ liệu từ server
			$scope.initialize();
		}).catch(error => {
			alert("Lỗi xóa dữ liệu!");
			console.log("Error", error);
		});
	}

	$scope.initialize();
	$scope.reset();
});