angular.module('makersweb').controller('FotoController', function ($scope, $http, $routeParams) {
    var URL_API = "http://localhost:8080/spring-rest-api/api/v1/foto";

    $scope.foto = {};
    $scope.mensagem = '';

    if ($routeParams.fotoId) {
        $http.get(URL_API + '/' + $routeParams.fotoId)
                .then(function (response) {
                    $scope.foto = response.data;
                })
                .catch(function (error) {
                    $scope.mensagem = 'Não foi possível encontrar a Foto.';
                    console.log(error);
                });
    }

    $scope.submeter = function () {
        if ($scope.formulario.$valid) {
            if ($scope.foto.id) {
                $http.put(URL_API + '/' + $scope.foto.id, $scope.foto)
                        .then(function () {
                            $scope.mensagem = 'Foto '+ $scope.foto.titulo +' atualizada com sucesso!';
                        })
                        .catch(function (error) {
                            $scope.mensagem = 'Não foi possível atualizar a Foto ' + $scope.foto.titulo;
                            console.log(error);
                        });
            } else {
                $http.post(URL_API, $scope.foto)
                        .then(function (response) {
                            $scope.foto = {};
                            $scope.mensagem = response.data.message;
                        }).catch(function (error) {
                    $scope.mensagem = 'Não foi possível incluir a Foto.';
                    console.log(error);
                });
            }
        }
    };
});


