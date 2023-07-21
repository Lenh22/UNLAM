public class ManejoAscensor{
	
	public static void main(String args[]){
	
		Ascensor consorcioCallePeron;
		consorcioCallePeron = new Ascensor(4, 150.0);
	
		consorcioCallePeron.getPisoActual();
		
		System.out.println(consorcioCallePeron.getPisoActual());
		// se encuentra en el piso 0
		
		consorcioCallePeron.subir();
		consorcioCallePeron.subir();
		consorcioCallePeron.subir();
	
		System.out.println(consorcioCallePeron.getPisoActual());
		// se encuentra en el piso 3 porque le di la orden de subir
		
		// lo debo hacer subir directamente al 3
		
		consorcioCallePeron.irAlPiso(3);
		
		System.out.println(consorcioCallePeron.getPisoActual());
		
		Persona alf = new Persona("Alf", "Hombre", 35345631, 60, 1.0);
		Persona willy = new Persona ("Willy", "Hombre", 9347111, 80, 1.75);
		Persona benjiGregory = new Persona ("Benja", "Hombre", 2222111, 90, 1.20);
		
		consorcioCallePeron.abrirPuerta();
		
		consorcioCallePeron.ingresar(alf);
		consorcioCallePeron.ingresar(willy);
		consorcioCallePeron.ingresar(benjiGregory);
		
		consorcioCallePeron.cerrarPuerta();
		
		System.out.println(consorcioCallePeron.toString());
		// hay una sobrecarga en el ascensor
		
		consorcioCallePeron.bajar();
		
		System.out.println(consorcioCallePeron.getPisoActual());
		// debido a la sobrearga, no pude ir al piso de abajo.
		
		consorcioCallePeron.abrirPuerta();
		consorcioCallePeron.salir(benjiGregory);
		consorcioCallePeron.cerrarPuerta();
		
		consorcioCallePeron.bajar();
		
		System.out.println(consorcioCallePeron.getPisoActual());
		
		// tuve que abrir la puerta y hacer q benjiGregory bajara, y 
		// con posterioridad, volver a cerrar la puerta. 
		
		
	
	}

}