angular.module('app').controller('RegistraAgenteController', function ($scope,$location,agenteService,tagService) {
   

    $scope.loadTags = function(query) {
        
        return tagService.pesquisarPorDescricao(query)
        
      };
    
    
    $scope.salvar = function (agente) {
        var tags=[];
        agente.tags.forEach(element => {
            tags.push(element.text);
        });
        
        agente.tags=tags;
        agenteService.cadastrar(agente)
            .then(function (response) {
                $location.path('/agente')

            }, function (response) {

                swal("Falha na solicitação!","error")

            });
    }

});
