angular.module('app').controller('DashBoardController', function ($scope, authService, dadosService, $routeParams) {

  $scope.isAgente = !!$routeParams.idAgente;

  if ($scope.isAgente) {

    function atualizarChartLineMemoria(Tempo, EixoX) {
      return chart = {
        "caption": "Memória",
        "subCaption": Tempo,
        "yaxismaxvalue": "100",
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
        "palettecolors": "0080C0",
        "showtooltip": "1",
        "showborder": "0"
      }

    }

    function atualizarChartLineCpu(Tempo, EixoX) {
      return chart = {
        "caption": "Cpu",
        "yaxismaxvalue": "100",
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

    function atualizarChartPie(tempo) {
      return chart = {
        "caption": "Disco",
        "subcaption": tempo,
        "numbersuffix": "gb",
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
        "palettecolors": "#4169E1,#CD2626"
      }
    }

    $scope.disco = {
      "chart": {
        "caption": "Disco",
        "subcaption": "Tempo real",
        "numbersuffix": "GB",
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
        "palettecolors": "#4169E1,#CD2626"
      }

    };



    $scope.memoria = {
      "chart": {
        "caption": "Memória",
        "yaxismaxvalue": "100",
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
        "palettecolors": "0080C0",
        "showtooltip": "1",
        "showborder": "0"
      }
    }


    $scope.cpu = {
      "chart": {
        "caption": "Cpu",
        "yaxismaxvalue": "100",
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
      $scope.memoria.chart = atualizarChartLineMemoria('Real', 'Segundos');
      $scope.cpu.chart = atualizarChartLineCpu('Real', 'Segundos');
      $scope.disco.chart = atualizarChartPie('Real');
      btnDashBoard(7);
    }

    function btnDashBoard(id){
      document.getElementById(1).className='btn btn-default toggle'
      document.getElementById(2).className='btn btn-default toggle'
      document.getElementById(3).className='btn btn-default toggle'
      document.getElementById(4).className='btn btn-default toggle'
      document.getElementById(5).className='btn btn-default toggle'
      document.getElementById(6).className='btn btn-default toggle'     
      document.getElementById(7).className='btn btn-default toggle'
      document.getElementById(id).className='btn btn-dark toggle';
    }

    $scope.hora = function (horario) {
      clearInterval(real);

      btnDashBoard(horario);

      if (horario === 1) {
        var promiseDados = dadosService.dados15Minutos($routeParams.idAgente)
        var tempo = '15 minutos atrás';
        var eixoX = 'Minutos';

      } else if (horario === 2) {
        var promiseDados = dadosService.dados1Hora($routeParams.idAgente)
        var tempo = 'Uma hora atrás';
        var eixoX = 'Minutos';

      } else if (horario === 3) {
        var promiseDados = dadosService.dados6Horas($routeParams.idAgente)
        var tempo = 'Seis horas atrás';
        var eixoX = 'Horas';

      } else if (horario === 4) {
        var promiseDados = dadosService.dados12Horas($routeParams.idAgente)
        var tempo = '12 horas atrás';
        var eixoX = 'Horas';

      } else if (horario === 5) {
        var promiseDados = dadosService.dados1Dia($routeParams.idAgente)
        tempo = 'Um dia atrás';
        eixoX = 'Horas';

      } else if (horario === 6) {
        var promiseDados = dadosService.dados30Minutos($routeParams.idAgente)
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
        // console.log(response.data);

        $scope.memoriaT= Math.round((response.data[0].totalMemory * 100) / 100);
        $scope.nucleosT =  Math.floor(response.data[0].numberOfCores);

        dataResponseDisco.push(!!isReal ?  { label: 'Usado', value: response.data[0].occupiedDiskAvg } :{ label: 'Usado', value: response.data[0].id.occupiedDiskAvg });
        dataResponseDisco.push(!!isReal ?  { label: 'Livre', value: response.data[0].freeDiskAvg } :{ label: 'Livre', value: response.data[0].id.freeDiskAvg });
        response.data.forEach(element => {
         
          dataResponseCpu.push(!!isReal ?  {  label: '', value: Math.floor(element.cpuAvg)}:{  label: element.id.minu[3] + ':' + element.id.minu[4], value: Math.floor((element.id.cpuAvg)) });
          dataResponseMemoria.push(!!isReal ?  {  label: '', value:Math.floor( element.ramAvg)}:{  label: element.id.minu[3] + ':' + element.id.minu[4], value: Math.floor(element.id.ramAvg)});
          
        });
       // console.log(dataResponseMemoria)
        $scope.cpu.data = dataResponseCpu;
        $scope.memoria.data = dataResponseMemoria;
        $scope.disco.data = dataResponseDisco;
      });

//!!isReal ? '' : element.id.minu[3] + ':' + element.id.minu[4]
    }

  }

});



