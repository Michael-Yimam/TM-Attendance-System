$( document ).ready(function() {

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


});