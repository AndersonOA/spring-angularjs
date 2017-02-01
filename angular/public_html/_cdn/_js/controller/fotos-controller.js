angular.module('makersweb').controller('FotosController', function ($scope, $http) {
    var URL_API = "http://localhost:8080/spring-rest-api/api/v1/foto";

    $scope.fotos = [];
    $scope.filtro = '';
    $scope.mensagem = '';

    $http.get(URL_API)
            .then(function (retorno) {
                $scope.fotos = retorno.data;
            }).catch(function (error) {
        console.log(error);
    });

    $scope.remover = function (foto) {
        $http.delete(URL_API + '/' + foto.id)
                .then(function () {
                    var indiceFoto = $scope.fotos.indexOf(foto);
                    $scope.fotos.splice(indiceFoto, 1);
                    $scope.mensagem = 'Foto '+ foto.titulo +' removida com sucesso!';
                }).catch(function (error) {
            console.log(error);
            $scope.mensagem = 'Não foi possível remover a Foto ' + foto.titulo;
        });
    };
});


