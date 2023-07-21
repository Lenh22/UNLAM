import java.util.Scanner;

public class TipoString {
	
	public static void main (String arg[]) {
		String nombre;
		char inicial;
		int longitud;
		String mayuscula;
		String minuscula;
		
		Scanner teclado=new Scanner(System.in);
		System.out.println("Ingrese un nombre: ");
		nombre=teclado.nextLine();
		System.out.println("Nombre ingresado: "+nombre);
		inicial=nombre.charAt(0);
		System.out.println("Inicial del nombre: "+inicial);
		longitud=nombre.length();
		System.out.println("Su longitud: " +longitud);
		mayuscula=nombre.toUpperCase();
		System.out.println("En mayuscula: "+mayuscula);
		minuscula=nombre.toLowerCase();
		System.out.println("En minuscula: "+minuscula);
	}

}