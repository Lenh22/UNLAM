function validar(){
    var regexemail = /^[0-9a-zA-Z._.-]+\@[0-9a-zA-Z._.-]+\.[0-9a-zA-Z]+$/; //expresion regular para emails validos
    var mensaje =""; //variable que va a almacenar todos los mensajes de error
    var error =0; /*variable auxiliar que se va a utilizar para retornar o no falso. 
                            En caso de que su valor sea 0, retornara verdadero y el formulario se enviara. En el caso de que sea mayor a 0 retornara falso.*/
    reset();
    if ($("#nombre").val()==""){ /*valida que nombre no este vacio*/
        mensaje+= "<p>El campo nombre es obligatorio </p>";
        error++;
        $("#nombre").addClass('error');
    }
    if($("#apellido").val().length < 5){
        mensaje+= "<p>El campo apellido debe tener al menos 4 caracteres </p>";
        error++;
        $("#apellido").addClass('error');
    }

    //validamos un select con la propiedad selectedIndex
    if ($("#provincia option:selected").val()==0){
        mensaje+= "<p>Debe Seleccionar una provincia</p>";
        error++;
        $("#provincia").addClass('error');
    }

    if(!$("#email").val().match(regexemail)){
        mensaje+= "<p>Debe ser un email valido</p>";
        error++;
        $("#email").addClass('error');
    }

    //validamos un input radio
    if (!($('input[name="sexo"]').is(':checked'))) { /*Si ningun input de name sexo esta seleccionado*/
        mensaje+= "<p>Debe seleccionar un sexo</p>";  
        error++;
    }
    //Validamos un campo de tipo checkbox, por ejemplo condiciones
    if (!($("#condiciones").is(':checked'))){ 
        mensaje+= "<p>Debe Aceptar los terminos y condiciones</p>";
        error++;
    }

    /*Si error es mayor a 0 retorna falso y muestra todo los mensajes de errores acumulado en la variable mensaje*/
    if (error>0){
        
        $("#mensaje").append(mensaje); //agregamos al div de id mensaje, los mensajes de error acumulados en la variable mensaje
        return false;
    }
    /*Sino retorna verdadero y el formulario se envía*/
    else{
        return true;
    }

}
function reset(){ /*Esta funciona elimina todas las clases de error*/
    $("#nombre").removeClass('error');
    $("#apellido").removeClass('error');
    $("#provincia").removeClass('error');
    $("#email").removeClass('error');
    $("#mensaje").empty(); //vaciamos el contenido del div de id mensaje
}

$(document).ready(function() {
    
    $("#form").submit(function() {
        return validar();
    });
    $('input[name="sexo"]').change(function() {
        validar();
    });
    $("#condiciones").change(function() {
        validar();
    });
    $("#nombre").keyup(function() {
        validar();
    });
    $("#provincia").change(function() {
        validar();
    });
    $("#apellido").keyup(function() {
        validar();
    });
    
    $("#email").keyup(function() {
        validar("#email");
    });
});