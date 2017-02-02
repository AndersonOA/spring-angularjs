angular.module('makersweb').controller('FotoController', function ($scope, $routeParams, recursoFoto) {
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
            if ($routeParams.fotoId) {
                recursoFoto.update({fotoId: $scope.foto.id}, $scope.foto, function () {
                    $scope.mensagem = 'Foto ' + $scope.foto.titulo + ' atualizada com sucesso!';
                }, function (error) {
                    $scope.mensagem = 'Não foi possível atualizar a Foto ' + $scope.foto.titulo;
                    console.log(error);
                });
            } else {
                recursoFoto.save($scope.foto, function (response) {
                    $scope.foto = {};
                    $scope.mensagem = response.data.message;
                }, function (error) {
                    $scope.mensagem = 'Não foi possível incluir a Foto.';
                    console.log(error);
                });
            }
        }
    };
});


