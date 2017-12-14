angular.module('app').controller('RegistrarAlertaController', function ($scope, $location, alertaService, grupoService, agenteService) {

    $scope.alerta = {
        isGrupo: true,
        metrica: 'Cpu',
        isMaior: true
    }

    function listarGrupos() {
        grupoService.listarTodos()
            .then(function (response) {
                $scope.gruposOuAgentes = response.data;

            })
    }
    listarGrupos();

    $scope.grupo = function () {

        grupoService.listarTodos()
            .then(function (response) {
                $scope.gruposOuAgentes = response.data;

            })

    }

    $scope.agente = function () {
        agenteService.listarTodos()
            .then(function (response) {
                $scope.gruposOuAgentes = response.data;
                for (let x = 0; x < response.data.length; x++) {
                    $scope.gruposOuAgentes[x].description = response.data[x].machineNickname;
                }

            })

    }

    $scope.salvar = function (alerta) {

        alertaService.cadastrar(alerta)
            .then(function (response) {           
                    $location.path('/alerta')

            }, function (response) {

                swal("Falha na solicitação!", "error")

            });
    }

});
