angular.module('app').controller('AgenteController', function ($scope, agenteService) {

    let page = 0;
    const size = 10;

    $scope.take = size;


    listar(page, size);

    $scope.avancarPagina = function () {


        page = $scope.nPagina - 1;
        listar(page, size);

    }

    new Clipboard('.btn');
    $scope.pesquisar = function (id) {
        agenteService.pesquisarPorId(id)
            .then(function (response) {
                $scope.info = response.data;

            })
    }

    $scope.excluir = function (agente) {
        swal({
            title: `Você deseja deletar ${agente.machineNickname}?`,
            text: "Esse agente será deletado permanentemente!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Sim, deletar!",
            closeOnConfirm: false
        },
            function () {
                agenteService.deletar(agente.id).then(function () {
                    swal("Deletado!", `${agente.machineNickname} foi deletado`, "success")
                    listar(0, 5)
                }, function (response) {
                    console.log(response)
                    swal("Falha na solicitação!", response.data.message, "error")
                })

            });

    }

    $scope.pesquisar = function (pes) {
        
        agenteService.pesquisar(pes)
            .then(function (response) {
                $scope.agentes = response.data.content;
                
                $scope.paginas = response.data.totalElements;

            })

    }


    function listar(page, size) {
        agenteService.listar(page, size)
            .then(function (response) {
                $scope.agentes = response.data.content;
               
                $scope.paginas = response.data.totalElements;
            })

    }

});
