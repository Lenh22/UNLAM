public class Automovil {
	//Atributos
		private int velocidad;
		private double horas;
		private int aceleracion;
		private int tiempo=0;
	//Constructor
		public Automovil (int velocidad, double horas){
			
			this.horas = horas;
			this.velocidad = velocidad;
		}
		public Automovil (int velocidad, int horas){
			this.velocidad = velocidad;
			this.horas = (double) horas /60;
		}
		//Metodo
		public double getDistancia (){
		return velocidad * horas;
		}
		public double getVelocidad(){
		return velocidad;
		}
		public String getDatos() {
			return ("Se transporta " + getDistancia() +  " Kmh a una velocidad de " 
			+getVelocidad() + "Kmh en " + horas + "horas");
		}
		public int alcanzarVelocidadMaxima(int aceleracion, int velocidadMax){
			int i;
			int velocidadAux;
			
			while(velocidad<=velocidadMax) {
			for(i=0;i<100;i++) {
				velocidadAux=0+aceleracion*i;
				tiempo++;
				i++;
				velocidad=+velocidadAux;
				if(velocidad<=velocidadMax) {
					System.out.println("Velocidad: "+velocidad+ " \nEl tiempo en acelerar fue:" + i);
					}
				}
			}
			return tiempo;
			
		}
	}