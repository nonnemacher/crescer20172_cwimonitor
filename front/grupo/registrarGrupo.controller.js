angular.module('app').controller('RegistrarGrupoController', function ($scope,$location, grupoService) {

    function imagem(){
        return  document.getElementById('file').files[0];
    }
    
    $scope.salvar = function (grupo) {       
        var file = imagem();
        grupo.groupIcon= file.name;
        grupoService.cadastrar(grupo)
            .then(function (response) {
                $location.path('/grupo')

            }, function (response) {

                swal("Falha na solicitação!", response.data.message, "error")

            });
    }
   
    $scope.addFoto = function(){
        var file = imagem();
        var fd = new FormData();
        fd.append('file', file);
        grupoService.addFoto(fd).then(
          function(response){
            console.log(response)
            alert("Foto adicionada com sucesso!")
          }, function(response){
            console.log(response)
          }
        )};  

});
