$(document).ready(function(){

    //selector de etiqueta
    $("h1").addClass("rojo");
    //selector de clase
    $('.clase').addClass("azul");
    //selector de id
    $("#texto").hide();

    //eventos
    $("#nombre").keyup(function(){
        //console.log($("#nombre").val());
        console.log($(this).val());
    });
    $('input[name="lenguaje"]').change(function(){
        console.log($('input[name="lenguaje"]:checked').val());
    });
});

/*$(document).ready(function(){
    /*selectores*/
    /*$("etiqueta")
    $(".clase")
    $("#id")
    $("a:hover")
    $('etiqueta[atributo="valor"]')
    $('input[name="lenguaje"]')
    $('input[name="lenguaje"]:checked')*/

    /*metodos  / efectos*/
    /*$(selector).metodo(parametro opcional);
    $("h1").hide();
    $("h1").addClass("nombreDeLaClase");*/

    /*eventos*/
    /*$(selector).evento(function(){});

    $("#enviar").click(function(){

    });
    $("#nombre").keyup(function(){
        
    });

    /*consultar por estados*/
    /*
        $(selector).is(':estado')
        $(".texto").is(':visible') //los elementos de clase texto estan visibles?
        if($(".texto").is(':visible')){

        }
        $(".texto").is(':hidden')//esta en estado oculto
    */

/*});*/