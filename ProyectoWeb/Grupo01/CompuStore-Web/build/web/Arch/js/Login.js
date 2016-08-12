$(document).ready(function () {
    //Asigna Valores Cookie a campo
    $("#InputUsuario").val($.cookie('Usuario'));
    $("#inputPass").val($.cookie('Password'));
    if ($("#inputUsuario").val() != "") {
        $("#Recordarme").attr('checked', true);
    }

    // jQuery methods go here...
    $("#BotDashboard").click(function () {
        $("#Indicadores").toggle("slow");
    });

    $("#frmLogin").submit(function (event) {

        //Recordarme // Cookie
        if ($("#Recordarme").is(':checked')) {
            //alert("Está activado");
            varuser = $("#InputUsuario").val();
            varpassword = $("#inputPass").val();
            
            $.cookie('Usuario', varuser);
            $.cookie('Password', varpassword);
        } else {
            // alert("No está activado");
            $("#Recordarme").attr('checked', false);
            $.removeCookie('Usuario');
            $.removeCookie('Password');
        }
        

        //alert("Handler for .submit() called.");
        //event.preventDefault();
    });

    // Modal
    //$("#myModal").modal();

    /*$("#Login").click(function () {
        $("#myModal").modal();
        $("#frmLogin").submit();
    });*/

});