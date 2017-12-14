angular.module('app').factory('tagService', function ($http) {

    let urlBase = 'http://localhost:9090/tag/';

    
    function pesquisarPorDescricao(descricao){
        return $http.get(urlBase+descricao)
    }

    return {
        
        pesquisarPorDescricao : pesquisarPorDescricao
    };

})