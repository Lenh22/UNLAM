$(document).ready(function(){
    $(".popup").hide();
    $("#abrir").click(function(){
        $(".popup").fadeIn();
    });
    $("#cerrar").click(function(){
        $(".popup").fadeOut();
    });
    $("#ocultar").click(function(){
        $(".texto").hide();
    });
    $("#mostrar").click(function(){
        $(".texto").show();
    });
});