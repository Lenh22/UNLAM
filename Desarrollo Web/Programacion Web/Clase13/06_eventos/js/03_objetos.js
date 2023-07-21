function Personaje(x,y,nombre){
    this.x=x;
    this.y=y;
    this.nombre=nombre;

    this.hablar=function(){
        console.log('Hola!! soy '+this.nombre);
    }
    this.abajo=function(){
        this.y+=10;
    }
    this.derecha=function(){
        this.x+=10;
    }
}
var personaje1=new Personaje(2,10,'Fernando');
personaje1.abajo();