$(function () {
    $('#container-for-column').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Среднее количество лайков по часам'
        },
        xAxis: {
            title: {
              text: 'Часы'
            },
            categories: [
                '00',
                '01',
                '02',
                '03',
                '04',
                '05',
                '06',
                '07',
                '08',
                '09',
                '10',
                '11',
                '12',
                '13',
                '14',
                '15',
                '16',
                '17',
                '18',
                '19',
                '20',
                '21',
                '22',
                '23'
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Лайки'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: 'Лайки',
            data: data
        }]
    });
});
