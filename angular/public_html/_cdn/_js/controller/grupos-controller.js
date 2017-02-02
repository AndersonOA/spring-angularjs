angular.module('makersweb').controller('GruposController', function ($scope, $http) {
    var URL_API = "http://localhost:8080/spring-rest-api/api/v1/grupo";

    $scope.grupos = {};

    $http.get(URL_API)
            .then(function (response) {
                $scope.grupos = response.data;
            }).catch(function (error) {
                console.log(error);
            });
});

