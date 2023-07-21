$(document).ready(function(){
    $("#form").submit(function(e){
        validar(e);
    });
    /*$("#form").on("submit",function(e){
        validar(e);
    });*/
});
function validar(e){
    var error=false;
    var mensajesError="";
    $("#mensaje").empty();
    $("#nombre").removeClass();
    $("#provincia").removeClass();
    if($("#nombre").val()==""){
        error=true;
        mensajesError+="<p>El campo nombre es obligatorio</p>";
        $("#nombre").addClass("error");
    }
    if(!($("input[name='sexo']").is(':checked'))){
        error=true;
        mensajesError+="<p>El campo sexo es obligatorio</p>";
    }
    if(!($("#condiciones").is(':checked'))){
        error=true;
        mensajesError+="<p>El campo condiciones es obligatorio</p>";
    }
    if($("#provincia").val()==0){
        error=true;
        mensajesError+="<p>El campo provincia es obligatorio</p>";
        $("#provincia").addClass("error");
    }
    if(error){
        $("#mensaje").append(mensajesError);
        e.preventDefault(); //detiene el envio
    }
}