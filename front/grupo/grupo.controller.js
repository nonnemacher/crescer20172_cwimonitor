angular.module('app').controller('GrupoController', function ($scope, grupoService) {

    let page = 0;
    const size = 5;

    $scope.take = size;


    listar(page, size);

    $scope.avancarPagina = function () {


        page = $scope.nPagina - 1;
        listar(page, size);

    }

    function listar(page, size) {
        grupoService.listar(page, size)
            .then(function (response) {
                $scope.grupos = response.data.content;
                $scope.paginas = response.data.totalElements;
            })

    }

    $scope.pesquisar = function (pes) {
        grupoService.pesquisar(pes)
            .then(function (response) {
                $scope.grupos = response.data.content;
                $scope.paginas = response.data.totalElements;

            })

    }

    $scope.excluir = function (grupo) {
        swal({
            title: `Você deseja deletar ${grupo.description}?`,
            text: "Esse grupo será deletado permanentemente!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Sim, deletar!",
            closeOnConfirm: false
        },
            function () {
                grupoService.remover(grupo.id).then(function () {
                    swal("Deletado!", `${grupo.description} foi deletado`, "success")
                    listar(0, 5)
                }, function (response) {
                    swal("Falha na solicitação!", response.data.message, "error")
                })

            });

    }




});
