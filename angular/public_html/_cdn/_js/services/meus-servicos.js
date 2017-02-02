angular.module('meusServicos', ['ngResource'])
        .factory('recursoFoto', function ($resource) {
            return $resource('http://localhost:8080/spring-rest-api/api/v1/foto/:fotoId', null, {
                update: {
                    method: 'PUT'
                }
            });
        });

