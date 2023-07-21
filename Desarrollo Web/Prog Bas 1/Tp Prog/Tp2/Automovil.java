public class Automovil {
//Atributos
	private int velocidad;
	private double horas;
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
}