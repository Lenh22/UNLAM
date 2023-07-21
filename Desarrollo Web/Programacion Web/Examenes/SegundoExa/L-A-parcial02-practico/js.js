$(document).ready(function(){
    $("#form").submit(function(e){
        e.preventDefault();
        console.log(e);
        validar(e);

    });
});

function validar(e){
       
    var error=false;
    var mensajeError="";
    var regexcodigo = /^[0-9]{6}$/;
    var regexemail = /^[0-9a-zA-Z._.-]+\@[0-9a-zA-Z._.-]+\.[0-9a-zA-Z]+$/;

    $("#mensaje").empty();

 if(($("#producto").val()<3)  || ($("#producto").val()>20)) {
    $("#mensaje").empty();
        }else{
            error =true;
            mensajeError+="<p>No puede tener menos de 3 letras o mas de 20</p>";
        }
  

    if(!$("#email").val().match(regexemail)){
        mensajeError+= "<p>Debe ser un email valido</p>";
        error=true;
        $("#email").addClass('error');
     }

     if(!$("#codigo").val().match(regexcodigo) ){
        error = true;
        mensajeError += "<p>El codigo solo es numerico</p>"
     }
     if($("#codigo").val() != $("#repcodigo").val()){
        error=true;
        mensajeError+="<p>Los codigos no son iguales</p>"


     }
     if(error){
        $("#mensaje").append(mensajeError);
    }
    

}
