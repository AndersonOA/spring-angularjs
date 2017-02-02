angular.module('meusServicos', ['ngResource'])
        .factory('recursoFoto', function ($resource) {
            return $resource('http://localhost:8080/spring-rest-api/api/v1/foto/:fotoId', null, {
                update: {
                    method: 'PUT'
                }
            });
        })
        .factory('cadastroDeFotos', function (recursoFoto, $q) {
            var servico = {};

            servico.cadastrar = function (foto) {
                return $q(function (resolve, reject) {
                    if (foto.id) {
                        recursoFoto.update({fotoId: foto.id}, foto, function () {
                            resolve({
                                mensagem: 'Foto ' + foto.titulo + ' atualizada com sucesso!',
                                inclusao: false
                            });
                        }, function (error) {
                            console.log(error);
                            reject({
                                mensagem: 'Não foi possível alterar a foto ' + foto.titulo
                            });
                        });
                    } else {
                        recursoFoto.save(foto, function () {
                            resolve({
                                mensagem: 'Foto ' + foto.titulo + ' incluida com sucesso!',
                                inclusao: true
                            });
                        }, function (error) {
                            console.log(error);
                            reject({
                                mensagem: 'Não foi possível incluir a foto ' + foto.titulo
                            });
                        });
                    }
                });
            };

            return servico;
        });

