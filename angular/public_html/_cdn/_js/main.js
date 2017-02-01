angular.module('makersweb', ['minhaDiretivas', 'ngAnimate', 'ngRoute'])
        .config(function ($routeProvider) {
            $routeProvider.when('/fotos', {
                templateUrl: 'principal.html',
                controller: "FotosController"
            });
        });


