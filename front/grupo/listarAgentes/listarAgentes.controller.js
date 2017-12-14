angular.module('app').controller('ListarAgenteController', function ($scope,$routeParams, agenteService,grupoService, $window) {

    let page = 0;
    const size = 5;

    $scope.take = size;


    listar($routeParams.idGrupo,page, size);

    $scope.avancarPagina = function () {


        page = $scope.nPagina - 1;
        listar($routeParams.idGrupo,page, size);

    }

    function listar(id,page, size) {
        agenteService.listarAgenteAdicionados(id,page, size)
            .then(function (response) {
                $scope.agentes = response.data.content;
                console.log($scope.agentes);
                $scope.paginas = response.data.totalElements;
            })

    }

    $scope.removerAgente= function(idAgente){
        grupoService.removerAgente($routeParams.idGrupo,idAgente)
            .then(function(reponse){
                $window.location.reload()

            })


    }
    $scope.removerAgente = function(agente){
        swal({
            title: `Você deseja remover ${agente.machineNickname}?`,
            text: "Esse agente será removido!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Sim, Remover!",
            closeOnConfirm: false
        },
            function () {
                grupoService.removerAgente($routeParams.idGrupo,agente.id).then(function () {
                    swal("Removido!", `${agente.machineNickname} foi removido`, "success")
                    listar($routeParams.idGrupo,page, size);
                }, function (response) {
                    swal("Falha na solicitação!", response.data.message, "error")
                })

            });

    }

    


});
