angular.module('app').controller('DashBoardController', function ($scope, authService, dadosService) {

  $scope.hora = function (horario) {

    if (horario === 1) {
      var promiseCpu = dadosService.cpu15Minutos()
      var promiseMemoria = dadosService.memoria15Minutos()
      var promiseDisco = dadosService.disco15Minutos()

    } else if (horario === 2) {
      var promiseCpu = dadosService.cpu1Hora()
      var promiseMemoria = dadosService.memoria1Hora()
      var promiseDisco = dadosService.disco1Hora()

    } else if (horario === 3) {
      var promiseCpu = dadosService.cpu6Horas()
      var promiseMemoria = dadosService.memoria6Horas()
      var promiseDisco = dadosService.disco6Horas()

    } else if (horario === 4) {
      var promiseCpu = dadosService.cpu12Horas()
      var promiseMemoria = dadosService.memoria12Horas()
      var promiseDisco = dadosService.disco12Horas()

    } else if (horario === 5) {
      var promiseCpu = dadosService.cpu1Dia()
      var promiseMemoria = dadosService.memoria1Dia()
      var promiseDisco = dadosService.disco1Dia()

    } else if (horario === 6) {
      var promiseCpu = dadosService.cpu24Horas()
      var promiseMemoria = dadosService.memoria24Horas()
      var promiseDisco = dadosService.disco24Horas()

    } else if (horario === 7) {
      var promiseCpu = dadosService.cpu30Dias()
      var promiseMemoria = dadosService.memoria30Dias()
      var promiseDisco = dadosService.disco30Dias()

    }

    promiseCpu.then(function (response) {
      let dataResponse = [];
      response.data.forEach(element => {
        dataResponse.push({ label: element.horario, value: element.quantidade });
      });
      $scope.cpu.data = dataResponse;

    });

    promiseMemoria.then(function (response) {
      let dataResponse = [];
      response.data.forEach(element => {
        dataResponse.push({ label: element.horario, value: element.quantidade });
      });
      $scope.memoria.data = dataResponse;

    });

    promiseDisco.then(function (response) {
      let dataResponse = [];
      response.data.forEach(element => {
        dataResponse.push({ label: element.horario, value: element.quantidade });
      });
      $scope.disco.data = dataResponse;

    });
}

    $scope.disco = {
      chart: {
        "caption": "Disco",
        "subCaption": "Uma hora atrás",
        "xAxisName": "Minutos",
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
        "subCaption": "Uma hora atrás",
        "xAxisName": "Minutos",
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
        "NumberSuffix": "mg",
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
          "value": "30"
        },
        {
          "label": "23:15",
          "value": "45"
        },
        {
          "label": "23:30",
          "value": "30"
        },
        {
          "label": "23:45",
          "value": "65"
        },
        {
          "label": "00:00",
          "value": "80"
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



    $scope.cpu = {
      chart: {
        "caption": "CPU",
        "subCaption": "Uma hora atrás",
        "xAxisName": "Minutos",
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
      "data": [
        {
          "label": "23:00",
          "value": "40"
        },
        {
          "label": "23:15",
          "value": "25"
        },
        {
          "label": "23:30",
          "value": "30"
        },
        {
          "label": "23:45",
          "value": "45"
        },
        {
          "label": "00:00",
          "value": "50"
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
  
});



