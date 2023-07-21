/*for(var i=0;i<4;i++){
    var num=prompt("Ingrese un numero");
    if(num%2==0){
        document.write(num+" es par");
    }else{
        document.write(num+" es impar");
    }
}*/
function validarPares(){
    var mensajes="";
    var num1=document.getElementById("num1").value;
    if(num1%2==0){
        mensajes+="El numero "+num1+" es par";
    }else{
        mensajes+="El numero "+num1+" es impar";
    }
    document.getElementById("mensaje").innerHTML=mensajes;
    return false;
}