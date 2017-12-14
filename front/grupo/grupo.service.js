angular.module('app').factory('grupoService', function ($http) {

    let urlBase = 'http://localhost:9090/group/';

    function cadastrar(grupo) {
        return $http.post(urlBase, grupo)

    }
    function listar(page, size) {
        return $http.get(urlBase + '?page=' + page + '&size=' + size)
    }

    function listarTodos(page, size) {
        return $http.get(urlBase + 'all')
    }

    function remover(id) {
        return $http.delete(urlBase + id)
    }

    function adicionarAgente(grupo, agente) {
        return $http.post(urlBase + 'add?group=' + grupo + '&machine=' + agente)
    }
    function removerAgente(grupo,agente){
        return $http.put(urlBase+'removeAgent?group=' + grupo + '&machine=' + agente)
    }

    function addFoto(formData) {
        var request = {
            method: 'POST',
            url: 'http://localhost:9090/group/file',
            data: formData,
            headers: {
                'Content-Type': undefined
            }
        }
        return $http(request);
    }

    return {
        cadastrar: cadastrar,
        listar: listar,
        listarTodos: listarTodos,
        addFoto: addFoto,
        remover: remover,
        adicionarAgente: adicionarAgente,
        removerAgente:removerAgente

    };

})