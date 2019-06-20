$( document ).ready(function() {

    $('#downloadTable').hide();

    $('#meditationBlock').on('change', function(){

        var contextRoot= "/"+ window.location.pathname.split('/')[1];
        var studentId = $('#studentIdSpan').text();

        if(this.value != ''){
            $.ajax({
                url :  contextRoot + '/getBlockMeditations/' + this.value + '/' + studentId,
                type: 'GET',
                dataType: 'text',
                success: populateTable,
                error: function(request, status, error){
                    console.error("something is wrong!");
                }
            });
        }
    });

    function populateTable(data){
        console.log("some data arrived");
        var parsedData = JSON.parse(data);

        var sessionsInABlock = parsedData.length;
        $('#sessionInBlock').text(sessionsInABlock);

        var absenceCounter = 0;
        $('#attendanceTable > thead').empty();

        var trh = $('<tr>');
        var th1 = $('<th>').text('Date');
        var th2 = $('<th>').text('Present');

        trh.append(th1);
        trh.append(th2);
        $('#attendanceTable > thead').append(trh);

        if(parsedData.length > 0){
            $('#downloadTable').show();
        }else{
            $('#downloadTable').hide();
        }

        $.each(parsedData, function(i, tm){

            var tr = $('<tr>');
            var td1 = $('<td>').text(tm.date);
            var td2 = $('<td>').text(tm.present);

            tr.append(td1);
            tr.append(td2);


            $('#attendanceTable > thead').append(tr);

            if(tm.present == false){
                absenceCounter++;
            }

        });

        var daysPresent = sessionsInABlock - absenceCounter;

        $('#daysPresent').text(daysPresent);

        var percentageAttened = parseFloat((daysPresent/sessionsInABlock) * 100).toFixed(2);
        $('#percentageAttended').text(percentageAttened + "%");

        var credit = 0;

        if(percentageAttened >= 90.0) credit = 1.5;
        else if(percentageAttened >= 80.0) credit = 1;
        else if(percentageAttened >= 70.0) credit = 0.5;
        else{}

        $('#creditPoints').text(credit);
    }


    function exportTableToCSV($table, filename) {

        var $rows = $table.find('tr:has(td)'),

            // Temporary delimiter characters unlikely to be typed by keyboard
            // This is to avoid accidentally splitting the actual contents
            tmpColDelim = String.fromCharCode(11), // vertical tab character
            tmpRowDelim = String.fromCharCode(0), // null character

            // actual delimiter characters for CSV format
            colDelim = '","',
            rowDelim = '"\r\n"',

            // Grab text from table into CSV formatted string
            csv = '"' + $rows.map(function(i, row) {
                var $row = $(row),
                    $cols = $row.find('td');

                return $cols.map(function(j, col) {
                    var $col = $(col),
                        text = $col.text();

                    return text.replace(/"/g, '""'); // escape double quotes

                }).get().join(tmpColDelim);

            }).get().join(tmpRowDelim)
                .split(tmpRowDelim).join(rowDelim)
                .split(tmpColDelim).join(colDelim) + '"';

        // Deliberate 'false', see comment below
        if (false && window.navigator.msSaveBlob) {

            var blob = new Blob([decodeURIComponent(csv)], {
                type: 'text/csv;charset=utf8'
            });

            // Crashes in IE 10, IE 11 and Microsoft Edge
            // See MS Edge Issue #10396033
            // Hence, the deliberate 'false'
            // This is here just for completeness
            // Remove the 'false' at your own risk
            window.navigator.msSaveBlob(blob, filename);

        } else if (window.Blob && window.URL) {
            // HTML5 Blob
            var blob = new Blob([csv], {
                type: 'text/csv;charset=utf-8'
            });
            var csvUrl = URL.createObjectURL(blob);

            $(this)
                .attr({
                    'download': filename,
                    'href': csvUrl
                });
        } else {
            // Data URI
            var csvData = 'data:application/csv;charset=utf-8,' + encodeURIComponent(csv);

            $(this)
                .attr({
                    'download': filename,
                    'href': csvData,
                    'target': '_blank'
                });
        }
    }


    // This must be a hyperlink
    $("#downloadTable").on('click', function(event) {
        // CSV
        var args = [$('#attendanceTable'), 'export.csv'];

        exportTableToCSV.apply(this, args);

        // If CSV, don't do event.preventDefault() or return false
        // We actually need this to be a typical hyperlink
    });
});