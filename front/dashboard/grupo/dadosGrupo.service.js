angular.module('app').factory('dadosServiceGrupo', function ($http) {

    let urlBase = 'http://localhost:9090/graphs/';

    //real
    function dadosReal(id) {
        return $http.get(urlBase+'realtime/'+id)
    }



    //15 minutos
    function dados15Minutos(id) {
        return $http.get(urlBase+'group/last-15-min/'+id)
    }

    //30 minutos
    function dados30Minutos(id) {
        return $http.get(urlBase+'group/last-30-min/'+id)
    }


    //1 hora
    function dados1Hora(id) {
        return $http.get(urlBase+'group/last-hour/'+id)
    }


    //6 hora
    function dados6Horas(id) {
        return $http.get(urlBase+'group/last-6-hours/'+id)
    }

    //12 hora
    function dados12Horas(id) {
        return $http.get(urlBase+'group/last-12-hours/'+id)
    }


    //24 horas
    function dados24Horas(id) {
        return $http.get(urlBase+'group/last-day/'+id)
    }





    return {
        dadosReal: dadosReal,
        dados15Minutos: dados15Minutos,
        dados30Minutos: dados30Minutos,
        dados1Hora: dados1Hora,
        dados6Horas: dados6Horas,
        dados12Horas: dados12Horas,
        dados1Dia: dados24Horas
        

    };

})