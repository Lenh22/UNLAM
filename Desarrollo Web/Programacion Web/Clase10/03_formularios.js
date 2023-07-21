function validar(){
    //Reconocer si encuentra algun error
    var error=false;
    //acumular mensaje de error
    var mensajesError="";
    //validar campos completos
    if(document.getElementById("nombre").value==""){
        error=true;
        mensajesError+="<p>El campo nombre no puede estar vacio</p>";
    }
    if(document.getElementById("apellido").value.length==0){
        error=true;
        mensajesError+="<p>El campo apellido no puede estar vacio</p>";
    }

    if(document.getElementById("provincia").value==0){
        error=true;
        mensajesError+="<p>No hay una provincia seleccionada</p>";
    }
    //para el sexo
    var opciones=document.getElementsByName("sexo");
    var seleccionado=false;
    for(i in opciones){
        if(opciones[i].checked){
            seleccionado=true;
        }
    }
    if(!seleccionado){
        error=true;
        mensajesError+="<p>Selecciona un sexo</p>"
    }
    //Para terminos
    if(!document.getElementById("condiciones").checked){
        error=true;
        mensajesError+="<p>Acepta los terminos y condiciones</p>"
    }

    if(error){
        //mostrar todos los errores de mensajes
        document.getElementById("mensaje").innerHTML=mensajesError;

    return false;
    }else{
        return true;
    }
}