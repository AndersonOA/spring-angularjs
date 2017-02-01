angular.module('makersweb').controller('FotoController', function ($scope, $http) {
    var URL_API = "http://localhost:8080/spring-rest-api/api/v1/foto";

    $scope.foto = {};
    $scope.mensagem = '';

    $scope.submeter = function () {
        if ($scope.formulario.$valid) {
            $http.post(URL_API, $scope.foto)
                .then(function (response) {
                    $scope.foto = {};
                    $scope.mensagem = response.data.message;
                }).catch(function (error) {
                    $scope.mensagem = 'Não foi possível incluir a Foto.';
                    console.log(error);
                });
        }
    };
});


