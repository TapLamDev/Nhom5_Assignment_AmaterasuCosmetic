const app = angular.module("app", []);
app.controller("cancelorder-ctrl", function($scope, $http) {
    $scope.form = {};
    $scope.items = [];

    $scope.reset = function() {
        $scope.form = {
            createDate: new Date()
        };
    }

    $scope.initialize = function() {
        $http.get("/rest/orders").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            });
            console.log("Success", resp);
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

    $scope.initialize();
    $scope.reset();
});
