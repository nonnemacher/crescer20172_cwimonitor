angular.module('app').controller('DashBoardController', function ($scope, authService, dadosService, $routeParams) {

  $scope.isAgente = !!$routeParams.idAgente;

  if ($scope.isAgente) {

    function atualizarChartLineMemoria(Tempo, EixoX) {
      return chart = {
        "caption": "Memória",
        "subCaption": Tempo,
        "showvalues": "1",
        "yaxisname": "Porcentagem",
        "xAxisName": EixoX,
        "numdivlines": "0",
        "canvasborderalpha": "0",
        "canvasbgalpha": "0",
        "numvdivlines": "5",
        "plotgradientcolor": "679436",
        "drawanchors": "1",
        "plotfillangle": "90",
        "plotfillalpha": "63",
        "vdivlinealpha": "22",
        "vdivlinecolor": "6281B5",
        "bgcolor": "ffffff",
        "showplotborder": "0",
        "numbersuffix": "%",
        "bordercolor": "ffb822",
        "borderalpha": "100",
        "canvasbgratio": "0",
        "basefontcolor": "37444A",
        "tooltipbgcolor": "37444A",
        "tooltipbordercolor": "37444A",
        "tooltipcolor": "FFFFFF",
        "basefontsize": "8",
        "outcnvbasefontsize": "11",
        "showyaxisvalues": "0",
        "animation": "1",
        "palettecolors": "679436",
        "showtooltip": "1",
        "showborder": "0"
      }

    }

    function atualizarChartLineCpu(Tempo, EixoX) {
      return chart = {
        "caption": "Cpu",
        "subCaption": Tempo,
        "showvalues": "1",
        "yaxisname": "Porcentagem",
        "xAxisName": EixoX,
        "numdivlines": "0",
        "canvasborderalpha": "0",
        "canvasbgalpha": "0",
        "numvdivlines": "5",
        "plotgradientcolor": "0000FF",
        "drawanchors": "1",
        "plotfillangle": "90",
        "plotfillalpha": "63",
        "vdivlinealpha": "22",
        "vdivlinecolor": "6281B5",
        "bgcolor": "716aca,B3CCE1",
        "showplotborder": "0",
        "numbersuffix": "%",
        "bordercolor": "9DBCCC",
        "borderalpha": "100",
        "canvasbgratio": "0",
        "basefontcolor": "37444A",
        "tooltipbgcolor": "37444A",
        "tooltipbordercolor": "37444A",
        "tooltipcolor": "FFFFFF",
        "basefontsize": "8",
        "outcnvbasefontsize": "11",
        "showyaxisvalues": "0",
        "animation": "1",
        "palettecolors": "0080C0",
        "showtooltip": "1",
        "showborder": "0"

      }
    }

    function atualizarChartPie(tempo) {
      return chart = {
        "caption": "Disco",
        "subcaption": tempo,
        "numbersuffix": "%",
        "startingangle": "310",
        "decimals": "0",
        "defaultcenterlabel": "Total revenue: $60K",
        "centerlabel": "Revenue from $label: $value",
        "theme": "fint",
        "showlegend": "1",
        "legendborder": "0",
        "legendposition": "bottom",
        "enablesmartlabels": "1",
        "use3dlighting": "0",
        "showshadow": "0",
        "legendbgcolor": "#CCCCCC",
        "legendbgalpha": "20",
        "legendborderalpha": "0",
        "legendshadow": "0",
        "legendnumcolumns": "3",
        "palettecolors": "#020100,#F2E94E"
      }
    }

    $scope.disco = {
      "chart": {
        "caption": "Disco",
        "subcaption": "Tempo real",
        "numbersuffix": "%",
        "startingangle": "310",
        "decimals": "0",
        "defaultcenterlabel": "Total revenue: $60K",
        "centerlabel": "Revenue from $label: $value",
        "theme": "fint",
        "showlegend": "1",
        "legendborder": "0",
        "legendposition": "bottom",
        "enablesmartlabels": "1",
        "use3dlighting": "0",
        "showshadow": "0",
        "legendbgcolor": "#CCCCCC",
        "legendbgalpha": "20",
        "legendborderalpha": "0",
        "bgcolor": "ffffff",
        "legendshadow": "0",
        "legendnumcolumns": "3",
        "palettecolors": "#020100,#F2E94E"
      }

    };



    $scope.memoria = {
      "chart": {
        "caption": "Memória",
        "subCaption": "Tempo Real",
        "showvalues": "1",
        "yaxisname": "Porcentagem",
        "xAxisName": "Segundos",
        "numdivlines": "0",
        "canvasborderalpha": "0",
        "canvasbgalpha": "0",
        "numvdivlines": "5",
        "plotgradientcolor": "679436",
        "drawanchors": "1",
        "plotfillangle": "90",
        "plotfillalpha": "63",
        "vdivlinealpha": "22",
        "vdivlinecolor": "6281B5",
        // "bgcolor": "020100,FDFFFC",
        "bgcolor": "ffffff",
        "showplotborder": "0",
        "numbersuffix": "%",
        "bordercolor": "ffb822",
        "borderalpha": "100",
        "canvasbgratio": "0",
        "basefontcolor": "37444A",
        "tooltipbgcolor": "37444A",
        "tooltipbordercolor": "37444A",
        "tooltipcolor": "FFFFFF",
        "basefontsize": "8",
        "outcnvbasefontsize": "11",
        "showyaxisvalues": "0",
        "animation": "1",
        "palettecolors": "679436",
        "showtooltip": "1",
        "showborder": "0"
      }
    }


    $scope.cpu = {
      "chart": {
        "caption": "Cpu",
        "subCaption": "Tempo Real",
        "showvalues": "1",
        "yaxisname": "Porcentagem",
        "xAxisName": "Segundos",
        "numdivlines": "0",
        "canvasborderalpha": "0",
        "canvasbgalpha": "0",
        "numvdivlines": "5",
        "plotgradientcolor": "0000FF",
        "drawanchors": "1",
        "plotfillangle": "90",
        "plotfillalpha": "63",
        "vdivlinealpha": "22",
        "vdivlinecolor": "6281B5",
        // "bgcolor": "716aca,B3CCE1",
        "bgcolor": "ffffff",
        "showplotborder": "0",
        "numbersuffix": "%",
        "bordercolor": "9DBCCC",
        "borderalpha": "100",
        "canvasbgratio": "0",
        "basefontcolor": "37444A",
        "tooltipbgcolor": "37444A",
        "tooltipbordercolor": "37444A",
        "tooltipcolor": "FFFFFF",
        "basefontsize": "8",
        "outcnvbasefontsize": "11",
        "showyaxisvalues": "0",
        "animation": "1",
        "palettecolors": "0080C0",
        "showtooltip": "1",
        "showborder": "0"
      }
    }
    function realTime() {
      let promiseDados = dadosService.dadosReal($routeParams.idAgente);
      promise(promiseDados, 1)
    }


    realTime();

    var real = setInterval(realTime, 2000)

    $scope.real = function () {
      realTime();
      real = setInterval(realTime, 2000)
    }



    $scope.hora = function (horario) {
      clearInterval(real);

      if (horario === 1) {
        var promiseDados = dadosService.dados15Minutos($routeParams.idAgente)
        var tempo = '15 minutos atrás';
        var eixoX = 'Minutos';

      } else if (horario === 2) {
        var promiseDados = dadosService.dados1Hora()
        var tempo = 'Uma hora atrás';
        var eixoX = 'Minutos';

      } else if (horario === 3) {
        var promiseDados = dadosService.dados6Horas()
        var tempo = 'Seis horas atrás';
        var eixoX = 'Horas';

      } else if (horario === 4) {
        var promiseDados = dadosService.dados12Horas()
        var tempo = '12 horas atrás';
        var eixoX = 'Horas';

      } else if (horario === 5) {
        var promiseDados = dadosService.dados1Dia()
        tempo = 'Um dia atrás';
        eixoX = 'Horas';

      } else if (horario === 6) {
        var promiseDados = dadosService.dados30Minutos()
        var tempo = '30 minutos atrás';
        var eixoX = 'Minutos';

      }
      $scope.memoria.chart = atualizarChartLineMemoria(tempo, eixoX);
      $scope.cpu.chart = atualizarChartLineCpu(tempo, eixoX);

      $scope.disco.chart = atualizarChartPie(tempo);
      promise(promiseDados, 0)

    }

    function promise(promiseDados, isReal) {

      promiseDados.then(function (response) {
        var dataResponseCpu = [];
        var dataResponseDisco = [];
        var dataResponseMemoria = [];
        console.log(response.data);

        dataResponseDisco.push(!!isReal ?  { label: 'Usado', value: response.data[0].occupiedDiskAvg } :{ label: 'Usado', value: response.data[0].id.occupiedDiskAvg });
        dataResponseDisco.push(!!isReal ?  { label: 'Usado', value: response.data[0].freeDiskAvg } :{ label: 'Usado', value: response.data[0].id.freeDiskAvg });
        response.data.forEach(element => {

          dataResponseCpu.push(!!isReal ?  {  label: '', value: element.cpuAvg}:{  label: '', value: element.id.cpuAvg });
          dataResponseMemoria.push(!!isReal ?  {  label: '', value: element.ramAvg}:{  label: '', value: element.id.ramAvg});

        });
        console.log(dataResponseMemoria)
        $scope.cpu.data = dataResponseCpu;
        $scope.memoria.data = dataResponseMemoria;
        $scope.disco.data = dataResponseDisco;
      });

//!!isReal ? '' : element.execTime[3] + ':' + element.execTime[4]
    }

  }

});



