$(function () {
    $('#container').highcharts({
        chart: {
            type: 'scatter',
            zoomType: 'xy'
        },
        title: {
            text: 'Распределение лайков по часам'
        },
        xAxis: {
            title: {
                enabled: true,
                text: 'Часы'
            },
            startOnTick: true,
            endOnTick: true,
            showLastLabel: true
        },
        yAxis: {
            title: {
                text: 'Лайки'
            }
        },
        plotOptions: {
            scatter: {
                marker: {
                    radius: 5,
                    states: {
                        hover: {
                            enabled: true,
                            lineColor: 'rgb(100,100,100)'
                        }
                    }
                },
                states: {
                    hover: {
                        marker: {
                            enabled: false
                        }
                    }
                },
                tooltip: {
                    headerFormat: '<b>{series.name}</b><br>',
                    pointFormat: '{point.x} лайков в {point.y} часов'
                }
            }
        },
        series: [{
            name: 'Лайки',
            color: 'rgba(223, 83, 83, .5)',
            data: scatter_data

        }]
    });
});
