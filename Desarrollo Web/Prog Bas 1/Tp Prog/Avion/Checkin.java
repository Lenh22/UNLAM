package ar.edu.unlam.modelo;

import java.util.Scanner;

public class Checkin {

	public static void main(String[] args) {
		
		System.out.println("Bienvenido ");
		
		int CantidadPasajero = 192;
		
		Vuelo vuelo = new Vuelo("Buenos Aires", "Bariloche", CantidadPasajero);
		 
		int opcion = 0; 
			do {
				opcion = seleccionarOpcion(); 
				
				switch (opcion) {
					case 1:
						registrarPasajero(vuelo);
						break;
					case 2:
						elegirAsiento(vuelo);
						break; 
					case 3:
						listarPasajeros(vuelo);
						break;
					default:
						System.out.println("Opción Invalida");
						break;
				}
			} while (opcion != 9);
	}

	private static int seleccionarOpcion() {
		
		Scanner teclado = new Scanner(System.in);
		
		int opcionSeleccionada=0;
		
		System.out.println("************************");
		System.out.println("Menu de opciones\n"); 
		System.out.println("1 - Registrar pasajero"); 
		System.out.println("2 - Elegir Asiento"); 
		System.out.println("3 - Listar pasajeros"); 
		System.out.println("9 - Salir"); 
		System.out.println("************************"); 
		System.out.println("Ingrese una opcion");
		
		opcionSeleccionada = teclado.nextInt();
		
		return opcionSeleccionada;
	}
	
	public static void registrarPasajero(Vuelo actual) {

		Scanner teclado = new Scanner(System.in);
		String nombre, apellido;
		int dni;

		System.out.println("Ingrese el nombre del pasajero");
		nombre=teclado.next();
		System.out.println("Ingrese el apellido del pasajero");
		apellido=teclado.next();
		System.out.println("Ingrese el dni del pasajero");
		dni=teclado.nextInt();
		
		Pasajero pasajero=new Pasajero(dni, nombre, apellido);
		boolean exito = actual.agregarPasajero(pasajero);
		
		if(exito==true) {
			System.out.println("Carga de pasajero exitosa");
		}else {
			System.out.println("Carga fallida");
		}
	}
	
	private static void elegirAsiento(Vuelo actual) {
	
		Scanner teclado = new Scanner(System.in);
		int dni, fila, columna;
		Pasajero pasajeroASentar;
		
		System.out.println("Ingrese el dni del pasajero");
		dni=teclado.nextInt();
		System.out.println("Ingrese la fila del asiento deseado");
		fila=teclado.nextInt();
		System.out.println("Ingrese la columna del asiento deseado");
		columna=teclado.nextInt();
		
		
		
		pasajeroASentar= actual.buscarPasajero(dni);
		
		boolean exito=actual.asignarAsiento(pasajeroASentar, fila, columna);

		if(exito==true) {
			System.out.println("Asiento asignado correctamente");
		}else {
			System.out.println("Asiento no asignado");
		}

	}
	
	private static void listarPasajeros(Vuelo actual) {
	
		actual.ordenarListaDePasajerosPorDNI();
		
		for(int i=0; i<actual.espacio();i++) {
			System.out.println(actual.getPasajeros()[i]);
		}
		
	}
}


	
	
	
	
	
	
	
	
	
	
	
	
