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
        $('#sessionInBlock').text(parsedData.length);
        //console.log(JSON.stringify(data));
    }

});