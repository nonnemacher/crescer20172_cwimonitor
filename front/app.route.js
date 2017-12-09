angular.module('app').config(function ($routeProvider) {

  $routeProvider

    // pública
    .when('/home', {
      controller: 'HomeController',
      templateUrl: 'home/home.html'
    })

    // pública
    .when('/login', {
      controller: 'LoginController',
      templateUrl: 'login/login.html'
    })

     // pública
     .when('/dashboard', {
      controller: 'DashBoardController',
      templateUrl: 'dashboard/dashboard.html',
      resolve: {
        
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              }
    })

    
    .when('/privado', {
      controller: 'PrivadoController',
      templateUrl: 'privado/privado.html',
      resolve: {

       
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })

    .otherwise('/home');
});
