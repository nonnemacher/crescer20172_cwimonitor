angular.module('app').config(function ($routeProvider) {

  $routeProvider

    // pública
    .when('/registrar', {
      controller: 'RegistrarController',
      templateUrl: 'login/registrar.html'
    })
    .when('/grupo', {
      controller: 'GrupoController',
      templateUrl: 'grupo/grupo.html',
      resolve: {

        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/adicionarAgente/:idGrupo?', {
      controller: 'AdicionarAgenteController',
      templateUrl: 'grupo/adicionarAgente/adicionarAgente.html',
      resolve: {

        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/listarAgentes/:idGrupo?', {
      controller: 'ListarAgenteController',
      templateUrl: 'grupo/listarAgentes/listarAgentes.html',
      resolve: {

        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/registrarGrupo', {
      controller: 'RegistrarGrupoController',
      templateUrl: 'grupo/registrarGrupo.html',
      resolve: {

        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })

    .when('/alerta', {
      controller: 'AlertaController',
      templateUrl: 'alerta/alerta.html',
      resolve: {

        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
   
    .when('/registrarAlerta', {
      controller: 'RegistrarAlertaController',
      templateUrl: 'alerta/registrarAlerta.html',
      resolve: {

        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })

    .when('/agente', {
      controller: 'AgenteController',
      templateUrl: 'agente/agente.html',
      resolve: {

        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/registrarAgente', {
      controller: 'RegistraAgenteController',
      templateUrl: 'agente/registrarAgente.html',
      resolve: {

        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })

    // pública
    .when('/login', {
      controller: 'LoginController',
      templateUrl: 'login/login.html'
    })

    
    .when('/dashboard/:idAgente?', {
      controller: 'DashBoardController',
      templateUrl: 'dashboard/dashboard.html',
      resolve: {

        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/dashboard/grupo/:idAgente?', {
      controller: 'DashBoardGrupoController',
      templateUrl: 'dashboard/grupo/dashboardGrupo.html',
      resolve: {

        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })

    .otherwise('/login');
});
