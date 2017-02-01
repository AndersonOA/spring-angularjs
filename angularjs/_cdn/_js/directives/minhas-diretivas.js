angular.module('minhaDiretivas', [])
        .directive('meuPainel', function () {
            var ddo = {};

            ddo.restrict = "AE";

            //escopo privado para elemento
            ddo.scope = {
                titulo: '@'
            };

            //define onde vai ter elementos filhos
            ddo.transclude = true;

            ddo.templateUrl = '_tpl/meu-painel.html';

            return ddo;
        });