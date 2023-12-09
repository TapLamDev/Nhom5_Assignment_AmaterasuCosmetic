const app = angular.module("app", []);
app.controller("order-ctrl", function($scope, $http) {
	$scope.form = {
		status: 'Processsing',

	};
	$scope.items = [];
	$scope.account = {};

	$scope.reset = function() {
		$scope.form = {
			status: 'Processsing',
		};
	}

	$scope.initialize = function() {
		$http.get("/rest/orders").then(resp => {
			$scope.items = resp.data;
			console.log("Success", resp);
		})
	}
	
	$scope.account = function() {
		$http.get("/rest/register").then(resp => {
			$scope.account = resp.data;
			console.log("Success", resp);
		})
	}

	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs button:eq(1)").tab('show')
	}


	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http.post('/rest/orders', item).then(resp => {
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Mã hóa đơn của bạn là: " );
		}).catch(error => {
			alert("Lỗi thêm mới!");
			console.log("Error", error);
		});
	}

	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http.put('/rest/orders/' + item.id, item).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items[index] = item;
			alert("Cập nhật Category thành công");
		}).catch(error => {
			alert("Lỗi cập nhật!");
			console.log("Error", error);
		});
	}
	$scope.delete = function(item) {
		$http.delete('/rest/orders/' + item.id).then(resp => {
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

	$scope.pager = {
		page: 0,
		size: 3,
		get items() {
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first() {
			this.page = 0;
		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}
		},
		last() {
			this.page = this.count - 1;
		}

	};

	$scope.initialize();
	$scope.account();
	//$scope.reset();
});