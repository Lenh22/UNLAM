function multiplicar(){
    var num1=document.getElementById("num1").value;
    var num2=document.getElementById("num2").value;
    if(isNaN(num1)||isNaN(num2)){
        document.getElementById("mensaje").innerHTML="Tienen que ser ambos numeros";
    }else{
        document.getElementById("mensaje").innerHTML=num1*num2;
    }

    return false;
}