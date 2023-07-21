public class DiscoRigido {
//Atributos
	private double tamano;
	private String marca;
//Construcciones
	public DiscoRigido(String marca, double tamano){
		this.marca=marca;
		this.tamano=tamano;
	}
	public String getMarca(){
		return this.marca;
	}
	public double getTamano(){
		return this.tamano;
	}
	public int cantidadDeDvd () {
		double dvd =0;
		double gb = 0;
		gb= tamano *1024;
		dvd =gb /4.5;
		return (int)dvd;
	}
	public int capacidadDeBlue (){
		double blue=0 , gb = 0;
		gb= tamano * 1024;
		blue = gb/15;
		return (int)blue;
	}
}