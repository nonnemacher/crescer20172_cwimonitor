angular.module('app').controller('AdicionarAgenteController', function ($scope,$routeParams, agenteService,grupoService, $window) {

    let page = 0;
    const size = 5;

    $scope.take = size;


    listar($routeParams.idGrupo,page, size);

    $scope.avancarPagina = function () {


        page = $scope.nPagina - 1;
        listar($routeParams.idGrupo,page, size);

    }

    function listar(id,page, size) {
        agenteService.listarAgenteAdicionar(id,page, size)
            .then(function (response) {
                $scope.agentes = response.data.content;
                console.log($scope.agentes);
                $scope.paginas = response.data.totalElements;
            })

    }

    $scope.adicionarAgente= function(idAgente){
        grupoService.adicionarAgente($routeParams.idGrupo,idAgente)
            .then(function(reponse){
                $window.location.reload()

            })


    }

    


});
