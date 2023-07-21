$(document).ready(function(){
    /*sintaxis $("selector").evento(function(){

    });*/
    //clonar
    $(".formulario .clonar").click(function(){
    	var clonar=$(this).parent(".bloque").clone(true); //clonar
        $(this).parent(".bloque").after(clonar); //agregarlo
    });
        
    
    //remover
    $(".formulario .eliminar").click(function(){
        var cant=$(".bloque").toArray().length;
        if(cant>3){
            $(this).parent(".bloque").remove();
        }
    });
});