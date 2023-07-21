var regexCampoNumerico=/^[0-9]+$/;
var regexCampoTexto=/^[a-z][A-Z]+$/
var regexEmail=/^[0-9a-zA-Z._.-]+\@[0-9a-zA-Z._.-]+\.[0-9a-zA-Z]+$/;

function validar(){
    var error=false;
    var mensajeError="";
    if(!regexCampoNumerico.test(document.getElementById("numero").value)){
        error=true;
        mensajeError+="<p>El campo numero tiene que ser numeros y 3 caracteres</p>"
    }
    if(!regexEmail.test(document.getElementById("email").value)){
        error=true;
        mensajeError+="<p>El campo email tiene que ser valido</p>"
    }
    
    if(error){
        document.getElementById("mensaje").innerHTML=mensajeError;
        return false;
    }else{
        return true;
    }
}