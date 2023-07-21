var regexCampoNumerico=/^[0-9]+$/;
var regexCampoTexto=/^[a-z][A-Z]+$/;
var regexEmail=/^[0-9a-zA-Z._.-]+\@[0-9a-zA-Z._.-]+\.[0-9a-zA-Z]+$/;
$(document).ready(function(){
    $("#form").submit(function(e){
        validar(e);
    });
});
function validar(e){
    var error=false;
    var mensajesError="";
    $("#mensaje").empty();
    //selector.val().match(expresionRegular);
    if(!($("#numero").val().match(regexCampoNumerico))){
        error=true;
        mensajesError+="<p>Este campo solo admite numeros</p>";
    }
    if(error){
        $("#mensaje").append(mensajesError);
        e.preventDefault(); //detiene el envio
    }
}