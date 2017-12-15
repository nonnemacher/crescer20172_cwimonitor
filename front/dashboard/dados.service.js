angular.module('app').factory('dadosService', function ($http) {
    
        let urlBase = 'http://localhost:9090/graphs/';
    
        //real
        function dadosReal(id) {
            return $http.get(urlBase+'realtime/'+id)
        }

        //15 minutos
        function dados15Minutos(id) {
            return $http.get(urlBase+'last-15-min/'+id)
        }
    
        //30 minutos
        function dados30Minutos(id) {
            return $http.get(urlBase+'last-30-min/'+id)
        }
    
        //1 hora
        function dados1Hora(id) {
            return $http.get(urlBase+'last-hour/'+id)
        }
    
        //6 hora
        function dados6Horas(id) {
            return $http.get(urlBase+'last-6-hours/'+id)
        }
    
        //12 hora
        function dados12Horas(id) {
            return $http.get(urlBase+'last-12-hours/'+id)
        }
    
    
        //24 horas
        function dados24Horas(id) {
            return $http.get(urlBase+'last-day/'+id)
        }
    
        //7 dias
        function dados7Dias(id) {
            return $http.get()
        }
    
        //30 dias
        function dados30Dias(id) {
            return $http.get(urlBase)
        }
    
        return {
            dadosReal: dadosReal,
            dados15Minutos: dados15Minutos,
            dados30Minutos: dados30Minutos,
            dados1Hora: dados1Hora,
            dados6Horas: dados6Horas,
            dados12Horas: dados12Horas,
            dados1Dia: dados24Horas,
            dados7Dias: dados7Dias,
            dados30Dias: dados30Dias
        };
    })