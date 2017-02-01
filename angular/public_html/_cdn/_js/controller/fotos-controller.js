angular.module('makersweb').controller('FotosController', function ($scope, $http) {
    $scope.fotos = [];
    $scope.filtro = '';

    $http.get('http://localhost:8080/spring-rest-api/api/v1/foto')
            .then(function (retorno) {
                $scope.fotos = retorno.data;
            }).catch(function (error) {
        console.log(error);
    });
});


