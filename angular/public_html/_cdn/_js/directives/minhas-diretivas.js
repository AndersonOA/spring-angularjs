angular.module('minhaDiretivas', [])
        .directive('minhaFoto', function () {
            var ddo = {};

            ddo.restrict = "AE";

            //escopo privado para elemento
            ddo.scope = {
                titulo: '@',
                url : '@'
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
        });