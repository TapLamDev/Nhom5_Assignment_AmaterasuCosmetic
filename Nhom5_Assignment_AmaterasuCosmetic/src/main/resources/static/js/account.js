const app = angular.module("app", []);
app.controller("account-ctrl", function($scope, $http) {
	$scope.form = {};
	$scope.accounts = [];

	$scope.reset = function() {
		$scope.form = {
			image: 'defaultImage.png'
		};
	};

	$scope.initialize = function() {
		$http.get("/rest/accounts").then(resp => {
			$scope.accounts = resp.data;
			console.log("Success", resp);
		});
	};

	$scope.edit = function(account) {
		$scope.form = angular.copy(account);
		var formContainer = document.getElementById('accountForm');
		formContainer.scrollIntoView({ behavior: 'smooth' });
	};

	$scope.create = function() {
		var account = angular.copy($scope.form);
		$http.post('/rest/accounts', account).then(resp => {
			$scope.accounts.push(resp.data);
			$scope.reset();
			alert("Thêm mới tài khoản thành công");
		}).catch(error => {
			alert("Lỗi thêm mới!");
			console.log("Error", error);
		});
	};

	$scope.update = function() {
		var account = angular.copy($scope.form);
		$http.put('/rest/accounts/' + account.username, account).then(resp => {
			var index = $scope.accounts.findIndex(a => a.username === account.username);
			$scope.accounts[index] = account;
			alert("Cập nhật tài khoản thành công");
		}).catch(error => {
			alert("Lỗi cập nhật!");
			console.log("Error", error);
		});
	};

	$scope.delete = function(account) {
		$http.delete('/rest/accounts/' + account.username).then(resp => {
			var index = $scope.accounts.findIndex(a => a.username === account.username);
			$scope.accounts.splice(index, 1);
			$scope.reset();
			alert("Xóa tài khoản thành công");
			// Gọi lại hàm để cập nhật dữ liệu từ server
			$scope.initialize();
		}).catch(error => {
			alert("Lỗi xóa dữ liệu!");
			console.log("Error", error);
		});
	};

	$scope.imageChanged = function(files) {
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/account', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.image = resp.data.name;
		}).catch(error => {
			alert("Lỗi tải ảnh!");
			console.log("Error", error);
		});
	};

	$scope.pager = {
		page: 0,
		size: 3,
		get items() {
			var start = this.page * this.size;
			return $scope.accounts.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.accounts.length / this.size);
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
	$scope.reset();
});
