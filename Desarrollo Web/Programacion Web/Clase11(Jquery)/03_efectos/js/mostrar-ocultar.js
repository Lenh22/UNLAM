$(document).ready(function(){
    //oculta
$(".popup").hide(); //llenarFormulario
$("#abrir").click(function(){ //icono
    $(".popup").fabeIn();
});
$("#cerrar").click(function(){ //icono
    $(".popup").fabeOut();
});
$("#ocultar").click(function(){
    $(".texto").hide();
});

});