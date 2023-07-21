$(document).ready(function(){
    $("#nombre").keyup(function(){
        $("#texto").text($(this).val());
    });
    $("input[name='color']").change(function(){
        //console.log($(this).val());
        $("#texto").removeClass("negro blanco");
        $("#texto").addClass($(this).val());
    });
    $("#tipografia").change(function(){
        //console.log($(this).val());
        $("#texto").removeClass("fuente-yanone fuente-roboto");
        $("#texto").addClass("fuente-"+$(this).val());
    });
    $("input[name='fondo']").change(function(){
        //console.log($(this).val());
        $(".vista-previa").removeClass("fondo1 fondo2 fondo3");
        $(".vista-previa").addClass("fondo"+$(this).val());
    });
    $("#alineacion").change(function(){
        $(".vista-previa").removeClass("texto-centrado texto-derecha texto-izquierda");
        $(".vista-previa").addClass("texto-"+$(this).val());
    });
});