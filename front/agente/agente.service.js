angular.module('app').factory('agenteService', function ($http) {

    let urlBase = 'http://localhost:9090/machineregister/';

    function cadastrar(agente) {
        return $http.post(urlBase, agente)

    }
    function listar(page, size) {
        return $http.get(urlBase + '?page=' + page + '&size=' + size)
    }
    function listarAgenteAdicionar(id, page, size) {
        return $http.get(urlBase + 'noGroup/' + id + '?page=' + page + '&size=' + size)
    }

    function listarAgenteAdicionados(id, page, size) {
        return $http.get(urlBase + 'group/' + id + '?page=' + page + '&size=' + size)
    }

    function deletar(id) {
        return $http.delete(urlBase + id);
    }

    function listarTodos() {
        return $http.get(urlBase + 'all')
    }
    function pesquisarPorId(id) {
        return $http.get(urlBase + id)
    }
    

    return {
        cadastrar: cadastrar,
        listar: listar,
        pesquisarPorId: pesquisarPorId,
        listarTodos: listarTodos,
        listarAgenteAdicionar: listarAgenteAdicionar,
        listarAgenteAdicionados: listarAgenteAdicionados,
        deletar: deletar
    };

})