//品牌控制层
app.controller('brandController', function($scope, $controller, brandService) {
	// 伪继承
	$controller('baseController', {
		$scope : $scope
	});

	// 查询所有
	$scope.findAll = function() {
		brandService.findAll().success(function(response) {
			$scope.list = response;
			console.log(response);
		})
	}

	// 分页查询
	$scope.findPage = function(page, size) {
		brandService.findPage(page, size).success(function(response) {
			$scope.list = response.rows;// 显示当前页数据
			$scope.paginationConf.totalItems = response.total;// 更新总记录数
		})
	}
	// 增加实体
	$scope.save = function() {
		var object = null;
		if ($scope.entity.id != null) {
			object = brandService.update($scope.entity);
		} else {
			object = brandService.add($scope.entity);
		}
		object.success(function(response) {
			if (response.success) {
				$scope.reloadList();
			} else {
				alert(response.message);
			}
		});
	}
	// 查询实体
	$scope.findOne = function(id) {
		brandService.findOne(id).success(function(response) {
			$scope.entity = response;
		})
	}

	$scope.del = function() {
		brandService.del($scope.selectIds).success(function(response) {
			if (response.success) {
				$scope.reloadList();
			} else {
				alert(response.message)
			}
		})
	}
	// 分页查询
	$scope.searchEntity = {};
	$scope.search = function(page, size) {
		brandService.search(page, size, $scope.searchEntity).success(
				function(response) {
					$scope.list = response.rows;// 显示当前页数据
					$scope.paginationConf.totalItems = response.total;// 更新总记录数
				})
	}
});