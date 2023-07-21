var contador=0;
$(document).ready(function(){
        $(".agregar").click(function(){
            contador++;
            //cambiarle el texto
           
            // $("#contador").append(contador); //.append() agrega a lo que ya hay

            // $("#contador").empty(); //borra lo anterior
        
            $("#contador").text(contador); //pisa lo anterior
        
        });



});