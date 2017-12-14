angular.module('app').factory('usuarioService', function ($http) {
    
        let urlBase = 'http://localhost:9090/collaborator/';
    
        function cadastrar(cadastro) {
            return $http.post(urlBase+"public", cadastro)
             
        }
    
        return {
           cadastrar : cadastrar
    
            
        };
    
    })