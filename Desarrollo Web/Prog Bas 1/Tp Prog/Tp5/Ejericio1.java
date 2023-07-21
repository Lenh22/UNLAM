package TrabajoPractico5;

import java.util.Scanner;

public class Ejericio1 {
	private String nombre;
	private String genero;
	private int edad;
	
	public Ejericio1(String nombre, String genero) {
		this.edad = 0;
		this.genero = genero;
		this.nombre = nombre;
	}
		
	public void cumplirAños() {
		Scanner edad = new Scanner(System.in);
		System.out.println("ingrese la edad: ");
		int cumple = edad.nextInt();

		for(int años = 0; años<=cumple;años++) {
			this.edad = cumple;
			
			System.out.println("Feliz Cumple: "+años);
		}
		System.out.println("la edad es: "+this.edad+" años");
	}
	
	
	public String toString() {
		return this.nombre+" es un/a "+this.genero+" edad: "+this.edad+" años";
	}
	
	
}
