var tools = {};

tools.range = function(min, max, step) {
	step = step || 1;
	var input = [];
	for (var i = min; i <= max; i += step)
		input.push(i);
	return input;
};

tools.springBootRestFactory = function() {
	var factory = {};
	
	factory.load = function($scope, $http, url, options) {
		if (!angular.isObject($scope)) throw new Error("No $scope supplied !");
		if (!angular.isDefined($http)) throw new Error("No $http supplied !");
		if (!angular.isDefined(url)) throw new Error("No url supplied !");
		options = options || '';
		
		$scope.pagination = {selected: 1, size: 5};
		
		$scope.updatePage = function() {
			$http.get(url + '?page=' + ($scope.pagination.selected - 1) + '&size=' + $scope.pagination.size + options).success(function(data) {
				$scope.data = data._embedded;
				$scope.page = data.page;
			});
		};
	};

	return factory;
}

var commgrApp = angular.module('commgr', ['ui.bootstrap']);


commgrApp.factory('springBootRestFactory', ['$http', function($http) {
	
	this.build = function($scope, url, options) {
		
	};
	
}]);

commgrApp.controller('CommunityController', ['$http', function($http) {
	var $scope = this;
	
	tools.springBootRestFactory().load($scope, $http, '/communities', '&sort=name,asc'); //&sort=seasons.name,desc
}]);


commgrApp.controller('SeasonController', ['$http', function($http) {
	var $scope = this;
	
	// &projection=seasonBase &projection=seasonInlineCommunity
	tools.springBootRestFactory().load($scope, $http, '/seasons', '&projection=seasonBase');
}]);


commgrApp.controller('AccountController', function($http) {
	var $scope = this;

	tools.springBootRestFactory().load($scope, $http, '/accounts');
});

