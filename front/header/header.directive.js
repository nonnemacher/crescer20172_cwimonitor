angular.module('app')
  .directive('cwiHeader', function (authService, $rootScope) {

    return {

      restrict: 'E',

      scope: {},
      
      templateUrl: 'header/header.directive.html',
      
      controller: function ($scope) {

        atualizarUsuario();

        $scope.logout = authService.logout;

        $rootScope.$on('authLoginSuccess', function () {
          atualizarUsuario();
        });

        $rootScope.$on('authLogoutSuccess', function () {
          atualizarUsuario();
        });        

        function atualizarUsuario() {
          $scope.usuario = authService.getUsuario();
          $scope.logado=authService.isAutenticado();
        }

        
      }
    }

  });