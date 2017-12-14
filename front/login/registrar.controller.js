angular.module('app').controller('RegistrarController', function ($scope, $location, authService, usuarioService) {

  $scope.registrar = function (usuario) {

    if ($scope.formRegistrar.$invalid) {
      return;
    }

    usuarioService.cadastrar(usuario)
      .then(function (response) {
        authService.login(usuario)
          .then(
          function (response) {


          },
          function (response) {

            alert('Erro no Login!');
          });

      }, function (response) {

        swal("Falha na solicitação!", response.data.message, "error")

      })

  };

});