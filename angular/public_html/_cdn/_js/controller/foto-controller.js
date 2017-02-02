angular.module('makersweb').controller('FotoController', function ($scope, $routeParams, recursoFoto, cadastroDeFotos) {
    $scope.foto = {};
    $scope.mensagem = '';

    if ($routeParams.fotoId) {
        recursoFoto.get({fotoId: $routeParams.fotoId}, function (foto) {
            $scope.foto = foto;
        }, function (error) {
            $scope.mensagem = 'Não foi possível encontrar a Foto.';
            console.log(error);
        });
    }

    $scope.submeter = function () {
        if ($scope.formulario.$valid) {
            cadastroDeFotos.cadastrar($scope.foto)
                    .then(function (retorno) {
                        $scope.mensagem = retorno.mensagem;
                        if (retorno.inclusao) $scope.foto = {};
                    })
                    .catch(function (error) {
                        $scope.mensagem = error.mensagem;
                    });
        }
    };
});


