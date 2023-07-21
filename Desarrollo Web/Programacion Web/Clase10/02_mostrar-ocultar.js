function mostrarOcultar(){
    if(document.getElementById("boton").value=="ocultar"){
    //1.Ocultar parrafo
    document.getElementById("texto").style.display="none";
    //2.Cambiar el valor de input a mostrar
    document.getElementById("boton").value="mostrar";
    }else{
        document.getElementById("texto").style.display="block";
        document.getElementById("boton").value="ocultar";
    }
}
function cambiarColor(color){
    document.getElementById("texto").style.backgroundColor=color;
}