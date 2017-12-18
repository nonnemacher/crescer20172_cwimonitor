angular.module('app').factory('alertaService', function ($http) {

    let urlBase = 'http://localhost:9090/alert/';

    function cadastrar(alerta) {
        return $http.post(urlBase, alerta);

    }
    function listarGrupos(page, size) {
        return $http.get(urlBase + 'group' + '?page=' + page + '&size=' + size);

    }

    function pesquisar(pesquisa) {
        return $http.get(urlBase + 'pesquisar/' + pesquisa)
    }
    function listarAgentes(page, size) {
        return $http.get(urlBase + 'agent' + '?page=' + page + '&size=' + size);

    }
    function deletar(id) {
        return $http.delete(urlBase + id);
    }

    return {
        cadastrar: cadastrar,
        listarGrupos: listarGrupos,
        listarAgentes: listarAgentes,
        deletar: deletar,
        pesquisar:pesquisar

    };

})