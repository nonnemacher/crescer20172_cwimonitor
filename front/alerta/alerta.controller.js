angular.module('app').controller('AlertaController', function ($scope, alertaService) {
    let page = 0;
    const size = 5;

    $scope.take = size;


    listar(page, size);

    $scope.avancarPagina = function () {


        page = $scope.nPagina - 1;
        listar(page, size);

    }

    $scope.pesquisar = function (pes) {
        alertaService.pesquisar(pes)
            .then(function (response) {
                $scope.alertas = response.data.content;                
                $scope.paginas = response.data.totalElements;

            })

    }

    function listar(page, size) {
        alertaService.listarGrupos(page, size)
            .then(function (response) {
                $scope.alertas = response.data.content;                
                $scope.paginas = response.data.totalElements;
            })

    }

    $scope.excluir=function(alerta){
        swal({
            title: `Você deseja deletar ${alerta.name}?`,
            text: "Esse alerta será deletado permanentemente!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Sim, deletar!",
            closeOnConfirm: false
        },
            function () {
                alertaService.deletar(alerta.id).then(function () {
                    swal("Deletado!", `${alerta.name} foi deletado`, "success")
                    listar(0,5)
                }, function (response) {
                    console.log(response)
                    swal("Falha na solicitação!", response.data.message, "error")
                })

            });

    }


});
