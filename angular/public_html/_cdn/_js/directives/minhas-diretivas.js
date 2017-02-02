angular.module('minhaDiretivas', [])
        .directive('minhaFoto', function () {
            var ddo = {};

            ddo.restrict = "AE";

            //escopo privado para elemento
            ddo.scope = {
                titulo: '@',
                url: '@'
            };

            //define onde vai ter elementos filhos
            ddo.transclude = true;

            ddo.templateUrl = '_cdn/_js/directives/_tpl/minha-foto.html';

            return ddo;

        })
        .directive('meuPainel', function () {
            var ddo = {};

            ddo.restrict = "AE";

            //escopo privado para elemento
            ddo.scope = {
                titulo: '@'
            };

            //define onde vai ter elementos filhos
            ddo.transclude = true;

            ddo.templateUrl = '_cdn/_js/directives/_tpl/meu-painel.html';

            return ddo;
        })
        .directive('meuBotaoPerigo', function () {
            var ddo = {};

            ddo.restrict = "E";

            ddo.scope = {
                nome: '@', //string
                acao: '&' //utilizado para passar uma expressao (function)
            };

            ddo.template = '<button ng-click="acao(foto)" class="btn btn-danger btn-block m-top-10">{{nome}}</button>';

            return ddo;
        })
        .directive('meuFocus', function () {
            var ddo = {};
    
            ddo.restrict = "A";
            
            ddo.link = function (scope, element) {
                scope.$on('fotoCadastrada', function () {
                    element[0].focus();
                });
            };
    
            return ddo;
        });