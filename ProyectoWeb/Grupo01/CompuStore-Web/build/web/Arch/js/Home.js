$(document).ready(function () {
    // Fecha Inicio Session
    var now = new Date();
    //var outStr = now.getHours() + ':' + now.getMinutes() + ':' + now.getSeconds();
    console.log("Fecha Inicio Session " + now)
    //AJAX GET
        //jQuery.ajax({
        //    type: "GET",
        //    url: 'DashBoard.aspx',
        //    //data: 'YOUR_DATA_TO_SEND',
        //    beforeSend: function () {
        //        $("#myModal").modal('show');
        //        // $("#loaderDiv").show();
        //    },
        //    success: function (data, status) {
        //        //alert("Data: " + data + "\nStatus: " + status);
        //        $("#myModal").modal('hide');
        //        $("#Contenido").html(data);
        //    }
        //});

    //AJAX POST
    //$.ajax(url, {
    //    data: { comment: text },
    //    type: "POST",
    //    beforeSend: function () {
    //        alert("before send");
    //    },
    //    error: function () {
    //        alert("error");
    //    },
    //    success: function (data) {
    //        alert(data);
    //    }
    //});

    //BOTONES
    $("#BotLogout").click(function () {
        $.ajax({
            type: "POST",
            url: "ValidarSession1.aspx/SessionAbandon",
            data: {},
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: true,
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(textStatus + ": " + XMLHttpRequest.responseText);
            }
        });
        //alert('Saliendo')
        //$(location).attr('href', 'Login.aspx')
    });
    

    // CARGA DASHBOARD
    //alert("test");
    jQuery.ajax({
        type: "GET",
        url: 'DashBoard.aspx',
        //data: 'YOUR_DATA_TO_SEND',
        beforeSend: function () {
            $("#myModal").modal('show');
            // $("#loaderDiv").show();
        },
        success: function (data, status) {
            //alert("Data: " + data + "\nStatus: " + status);
            $("#myModal").modal('hide');
            $("#Contenido").html(data);
        }
    });

    // MANTENER ACTIVA SESSION
    //1000 = 1segundo
    $(document).everyTime(900000, function () {
         
        $.ajax({
            type: "POST",
            url: "ValidarSession1.aspx/KeepActiveSession",
            data: {},
            contentType: "application/json",
            dataType: "json",
            async: true,
            success: VerifySessionState,
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(textStatus + ": " + XMLHttpRequest.responseText);
            }
        });
                 
    });
 
    
      
});

// MANTENER ACTIVA SESSION
var cantValidaciones = 0;
function VerifySessionState(result) {
    var now = new Date();
    var outStr = now.getHours() + ':' + now.getMinutes() + ':' + now.getSeconds();
    if (result.d) {
        console.log("Activo " + cantValidaciones + " Hora: " + outStr)
        //alert('activo' + cantValidaciones)
        //$("#EstadoSession").text("activo");
    }
    //else
        //$("#EstadoSession").text("expiro");

    //$("#cantValidaciones").text(cantValidaciones);
    cantValidaciones++;

}

