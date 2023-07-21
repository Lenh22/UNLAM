document.addEventListener("keydown",function(e){
    var posicionX=document.getElementById("imagen").offsetLeft;
    var posicionY=document.getElementById("imagen").offsetTop;
    switch(e.key){
        case 'w':
            document.getElementById("imagen").style.top=posicionY-20+"px";
        break;
        case 's':
            document.getElementById("imagen").style.top=posicionY+20+"px";
        break;
        case 'a':
            document.getElementById("imagen").style.left=posicionX-20+"px";
        break;
        case 'd':
            document.getElementById("imagen").style.left=posicionX+20+"px";
        break;
    }
});