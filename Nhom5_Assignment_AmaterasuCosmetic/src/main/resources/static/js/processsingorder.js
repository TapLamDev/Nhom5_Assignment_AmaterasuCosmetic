const app = angular.module("app", []);
app.controller("processsingorder-ctrl", function($scope, $http) {
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

    $scope.duyet = function(item) {
        // Thực hiện cập nhật trạng thái đơn hàng thành Confirmed
        item.status = "Confirmed"; // Đây là giả định, bạn cần thay đổi dựa trên dữ liệu thực tế
        $http.put('/rest/orders/' + item.id, item).then(resp => {
            console.log("Đã duyệt đơn hàng", resp);
            alert("Đã duyệt đơn hàng thành công");
            // Gọi lại hàm để cập nhật dữ liệu từ server
            $scope.initialize();
        }).catch(error => {
            alert("Lỗi khi duyệt đơn hàng!");
            console.log("Error", error);
        });
    }

    $scope.huy = function(item) {
        // Thực hiện cập nhật trạng thái đơn hàng thành Cancelled
        item.status = "Cancel"; // Đây là giả định, bạn cần thay đổi dựa trên dữ liệu thực tế
        $http.put('/rest/orders/' + item.id, item).then(resp => {
            console.log("Đã hủy đơn hàng", resp);
            alert("Đã hủy đơn hàng thành công");
            // Gọi lại hàm để cập nhật dữ liệu từ server
            $scope.initialize();
        }).catch(error => {
            alert("Lỗi khi hủy đơn hàng!");
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

    $scope.initialize();
    $scope.reset();
});
