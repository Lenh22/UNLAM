var contador=0;
$(document).ready(function(){
    $(".agregar").click(function(){
        contador++;
        /*$("#contador").empty();//borra
        $("#contador").append(contador);*//*agrega*/
        $("#contador").text(contador);
    });
});