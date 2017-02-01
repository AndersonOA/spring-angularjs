angular.module('makersweb', ['minhaDiretivas', 'ngAnimate', 'ngRoute'])
        .config(function ($routeProvider) {
            $routeProvider.when('/fotos', {
                templateUrl: 'partials/principal.html',
                controller: "FotosController"
            });
        });


