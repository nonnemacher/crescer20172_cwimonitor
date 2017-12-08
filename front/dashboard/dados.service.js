angular.module('app').factory('dadosService', function ($http) {

    let urlBase = 'http://localhost:';

    //15 minutos
    function cpu15Minutos() {
        return $http.get(urlBase)       
    }

    function memoria15Minutos() {
        return $http.get(urlBase)       
    }

    function disco15Minutos() {
        return $http.get(urlBase)       
    }
    //1 hora
    function cpu1Hora() {
        return $http.get(urlBase)       
    }

    function memoria1Hora() {
        return $http.get(urlBase)       
    }

    function disco1Hora() {
        return $http.get(urlBase)       
    }
    //6 hora
    function cpu6Horas() {
        return $http.get(urlBase)       
    }

    function memoria6Horas() {
        return $http.get(urlBase)       
    }

    function disco6Horas() {
        return $http.get(urlBase)       
    }
    //12 hora
    function cpu12Horas() {
        return $http.get(urlBase)       
    }

    function memoria12Horas() {
        return $http.get(urlBase)       
    }

    function disco12Horas() {
        return $http.get(urlBase)       
    }
    //24 horas
    function cpu24Horas() {
        return $http.get(urlBase)       
    }

    function memoria24Horas() {
        return $http.get(urlBase)       
    }

    function disco24Horas() {
        return $http.get(urlBase)       
    }
    //7 dias
    function cpu7Dias() {
        return $http.get(urlBase)       
    }

    function memoria7Dias() {
        return $http.get(urlBase)       
    }

    function disco7Dias() {
        return $http.get(urlBase)       
    }
    //30 dias
    function cpu30Dias() {
        return $http.get(urlBase)       
    }

    function memoria30Dias() {
        return $http.get(urlBase)       
    }

    function disco30Dias() {
        return $http.get(urlBase)       
    }

    return {
        cpu15Minutos : cpu15Minutos,
        memoria15Minutos : memoria15Minutos,
        disco15Minutos : disco15Minutos,

        cpu1Hora : cpu1Hora ,
        memoria1Hora  : memoria1Hora ,
        disco1Hora  : disco1Hora,

        cpu6Horas : cpu6Horas,
        memoria6Horas : memoria6Horas,
        disco6Horas : disco6Horas,

        cpu12Horas : cpu12Horas,
        memoria12Horas : memoria12Horas,
        disco12Horas : disco12Horas,

        cpu24Horas : cpu24Horas,
        memoria24Horas : memoria24Horas,
        disco24Horas: disco24Horas,

        cpu7Dias : cpu7Dias,
        memoria7Dias : memoria7Dias,
        disco7Dias: disco7Dias,

        cpu30Dias : cpu30Dias,
        memoria30Dias : memoria30Dias,
        disco30Dias: disco30Dias

        
    };

})