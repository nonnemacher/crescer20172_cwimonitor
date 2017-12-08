angular.module('app').controller('DashBoardController', function ($scope, authService, dadosService) {

  function atualizarChart(Titulo,Tempo,EixoX, EixoY,UnidadeMedida){
    return chart= {
      "caption": Titulo,
      "subCaption": Tempo,
      "xAxisName": EixoX,
      "yAxisName": EixoY,
      "lineThickness": "2",
      "paletteColors": "#0075c2",
      "baseFontColor": "#333333",
      "baseFont": "Helvetica Neue,Arial",
      "captionFontSize": "14",
      "subcaptionFontSize": "14",
      "subcaptionFontBold": "0",
      "showBorder": "0",
      "bgColor": "#ffffff",
      "showShadow": "0",
      "numberPrefix": "",
      "NumberSuffix": UnidadeMedida,
      "canvasBgColor": "#ffffff",
      "canvasBorderAlpha": "0",
      "divlineAlpha": "100",
      "divlineColor": "#999999",
      "divlineThickness": "1",
      "divLineIsDashed": "1",
      "divLineDashLen": "1",
      "divLineGapLen": "1",
      "showXAxisLine": "1",
      "xAxisLineThickness": "1",
      "xAxisLineColor": "#999999",
      "showAlternateHGridColor": "0"
    }

  }

  $scope.disco = {
    chart: {
      "caption": "Disco",
      "subCaption": "Tempo Real",
      "xAxisName": "Segundos",
      "yAxisName": "Porcentagem",
      "lineThickness": "2",
      "paletteColors": "#0075c2",
      "baseFontColor": "#333333",
      "baseFont": "Helvetica Neue,Arial",
      "captionFontSize": "14",
      "subcaptionFontSize": "14",
      "subcaptionFontBold": "0",
      "showBorder": "0",
      "bgColor": "#ffffff",
      "showShadow": "0",
      "NumberPrefix": "",
      "NumberSuffix": "gb",
      "canvasBgColor": "#ffffff",
      "canvasBorderAlpha": "0",
      "divlineAlpha": "100",
      "divlineColor": "#999999",
      "divlineThickness": "1",
      "divLineIsDashed": "1",
      "divLineDashLen": "1",
      "divLineGapLen": "1",
      "showXAxisLine": "1",
      "xAxisLineThickness": "1",
      "xAxisLineColor": "#999999",
      "showAlternateHGridColor": "0"
    },
    "data": [
      {
        "label": "23:00",
        "value": "35"
      },
      {
        "label": "23:15",
        "value": "55"
      },
      {
        "label": "23:30",
        "value": "64"
      },
      {
        "label": "23:45",
        "value": "90"
      },
      {
        "label": "00:00",
        "value": "88"
      }

    ],
    "trendlines": [
      {
        "line": [
          {
            "startvalue": "45",
            "color": "#1aaf5d",
            "displayvalue": "Média",
            "valueOnRight": "1",
            "thickness": "2"
          }
        ]
      }
    ]
  };



  $scope.memoria = {
    chart: {
      "caption": "Memória",
      "subCaption": "Tempo Real",
      "xAxisName": "Segundos",
      "yAxisName": "Megabites",
      "lineThickness": "2",
      "paletteColors": "#0075c2",
      "baseFontColor": "#333333",
      "baseFont": "Helvetica Neue,Arial",
      "captionFontSize": "14",
      "subcaptionFontSize": "14",
      "subcaptionFontBold": "0",
      "showBorder": "0",
      "bgColor": "#ffffff",
      "showShadow": "0",
      "numberPrefix": "",
      "NumberSuffix": "mb",
      "canvasBgColor": "#ffffff",
      "canvasBorderAlpha": "0",
      "divlineAlpha": "100",
      "divlineColor": "#999999",
      "divlineThickness": "1",
      "divLineIsDashed": "1",
      "divLineDashLen": "1",
      "divLineGapLen": "1",
      "showXAxisLine": "1",
      "xAxisLineThickness": "1",
      "xAxisLineColor": "#999999",
      "showAlternateHGridColor": "0"
    },
    
    "trendlines": [
      {
        "line": [
          {
            "startvalue": "45",
            "color": "#1aaf5d",
            "displayvalue": "Média",
            "valueOnRight": "1",
            "thickness": "2"
          }
        ]
      }
    ]
  };


  $scope.cpu = {
    chart: {
      "caption": "Cpu",
      "subCaption": "Tempo Real",
      "xAxisName": "Segundos",
      "yAxisName": "Porcentagem",
      "lineThickness": "2",
      "paletteColors": "#0075c2",
      "baseFontColor": "#333333",
      "baseFont": "Helvetica Neue,Arial",
      "captionFontSize": "14",
      "subcaptionFontSize": "14",
      "subcaptionFontBold": "0",
      "showBorder": "0",
      "bgColor": "#ffffff",
      "showShadow": "0",
      "numberPrefix": "",
      "NumberSuffix": "%",
      "canvasBgColor": "#ffffff",
      "canvasBorderAlpha": "0",
      "divlineAlpha": "100",
      "divlineColor": "#999999",
      "divlineThickness": "1",
      "divLineIsDashed": "1",
      "divLineDashLen": "1",
      "divLineGapLen": "1",
      "showXAxisLine": "1",
      "xAxisLineThickness": "1",
      "xAxisLineColor": "#999999",
      "showAlternateHGridColor": "0"
    },
   
    "trendlines": [
      {
        "line": [
          {
            "startvalue": "45",
            "color": "#1aaf5d",
            "displayvalue": "Média",
            "valueOnRight": "1",
            "thickness": "2"
          }
        ]
      }
    ]
  };
  function realTime(){
    let promiseCpu = dadosService.cpuReal()
    let promiseMemoria = dadosService.memoriaReal()
    let promiseDisco = dadosService.discoReal()
    promise(promiseCpu,promiseMemoria,promiseDisco,1)

  }
  realTime();
  
  var real = setInterval(realTime, 5000)
  
  $scope.real = function (){
    realTime();
    real = setInterval(realTime, 5000)
  }
  

  
  $scope.hora = function (horario) {
    clearInterval(real);

    if (horario === 1) {
      var promiseCpu = dadosService.cpu15Minutos()
      var promiseMemoria = dadosService.memoria15Minutos()
      var promiseDisco = dadosService.disco15Minutos()
      var tempo = '15 minutos atrás';
      var eixoX='Segundos';

    } else if (horario === 2) {
      var promiseCpu = dadosService.cpu1Hora()
      var promiseMemoria = dadosService.memoria1Hora()
      var promiseDisco = dadosService.disco1Hora()
      var tempo = 'Uma hora atrás';
      var eixoX='Minutos';
      
    } else if (horario === 3) {
      var promiseCpu = dadosService.cpu6Horas()
      var promiseMemoria = dadosService.memoria6Horas()
      var promiseDisco = dadosService.disco6Horas()
      var tempo = 'Seis horas atrás';
      var eixoX='Horas';

    } else if (horario === 4) {
      var promiseCpu = dadosService.cpu12Horas()
      var promiseMemoria = dadosService.memoria12Horas()
      var promiseDisco = dadosService.disco12Horas()
      var tempo = '12 horas atrás';
      var eixoX='Horas';

    } else if (horario === 5) {
      var promiseCpu = dadosService.cpu1Dia()
      var promiseMemoria = dadosService.memoria1Dia()
      var promiseDisco = dadosService.disco1Dia()
      tempo = 'Um dia atrás';
      eixoX='Horas';

    } else if (horario === 6) {
      var promiseCpu = dadosService.cpu7Dias()
      var promiseMemoria = dadosService.memoria7Dias()
      var promiseDisco = dadosService.disco7Dias()
      var  tempo = 'Sete dias atrás';
      var  eixoX='Dias';

    } else if (horario === 7) {
      var promiseCpu = dadosService.cpu30Dias()
      var promiseMemoria = dadosService.memoria30Dias()
      var promiseDisco = dadosService.disco30Dias()
      var tempo = '30 dias atrás';
      var eixoX='Dias';

    }
    $scope.memoria.chart =  atualizarChart('Memória',tempo,eixoX,'Magabites','mb');
    $scope.cpu.chart =  atualizarChart('Cpu',tempo,eixoX,'Porcentagem','%');
    
    $scope.disco.chart =  atualizarChart('Disco',tempo,eixoX,'Gigabites','gb');
    promise(promiseCpu,promiseMemoria,promiseDisco,0)
    
}
    // element.horario[3]+':'+element.horario[4]
    function promise(promiseCpu,promiseMemoria,promiseDisco,isReal){

      promiseCpu.then(function (response1) {
        let dataResponse1 = [];
        response1.data.forEach(element => {
          
          dataResponse1.push({ label: isReal === 1 ?  '' :element.horario[3]+':'+element.horario[4], value: element.quantidade});
        });
        $scope.cpu.data = dataResponse1;
        
      });
  
      promiseMemoria.then(function (response2) {
        let dataResponse2 = [];
        response2.data.forEach(element => {
          
          dataResponse2.push({ label: isReal === 1 ?  '' :element.horario[3]+':'+element.horario[4], value: element.quantidade });
        });
        $scope.memoria.data = dataResponse2;
  
      });
  
      promiseDisco.then(function (response) {
        let dataResponse = [];
        response.data.forEach(element => {
          dataResponse.push({ label: isReal === 1 ?  '' :element.horario[3]+':'+element.horario[4], value: element.quantidade });
        });
        $scope.disco.data = dataResponse;
  
      });
    }

    

    

  
});



