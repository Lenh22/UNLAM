window.onload=function(){
    document.getElementById("agregar").onclick = function() {
        var textoItem=document.getElementById("item").value;
        var itemLista=document.createElement("li");
        var contenido=document.createTextNode(textoItem);
        itemLista.appendChild(contenido);
        document.getElementById("lenguajes").appendChild(itemLista);
    }
    document.getElementById("eliminar").onclick = function() {
        var nodo = document.getElementById("provisional"); 
        nodo.parentNode.removeChild(nodo);
    }
     

    /*Otra manera
   document.getElementById("agregar").addEventListener('click',function(e){
        alert("algo");
   });*/
}