var contador=0;
var intervalo;
setTimeout(function(){
    console.log("termine");
},3000);

function crearIntervalo(){
    intervalo=setInterval(function(){
        console.log(contador++);
    },1000);
}

function frenar(){
    clearInterval(intervalo);
}