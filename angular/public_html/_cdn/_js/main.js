angular.module('makersweb', ['minhaDiretivas', 'ngAnimate', 'ngRoute'])
        .config(function ($routeProvider, $locationProvider) {
            $routeProvider.when('/fotos', {
                templateUrl: 'partials/principal.html',
                controller: "FotosController"
            });
            
            $routeProvider.when('/fotos/new', {
                templateUrl: 'partials/foto.html',
                controller: "FotoController"
            });
            
            $routeProvider.when('/fotos/edit/:fotoId', {
                templateUrl: 'partials/foto.html',
                controller: "FotoController"
            });
            
            $routeProvider.otherwise({redirectTo: '/fotos'});
            
            // use the HTML5 History API
            $locationProvider.html5Mode(true); //the hashPrefix is for SEO
        });


