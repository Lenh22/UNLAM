import java.util.Scanner;

public class Juego {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String pj1 = "", pj2 = "", palabra1 = "", palabra2 = "";
		
		System.out.print("Ingrese el nombre del player1: ");
		pj1 = scan.nextLine();
		
		System.out.print("Ingrese la palabra del player1: ");
		palabra1 = scan.nextLine();
		
		System.out.print("Ingrese el nombre del player2: ");
		pj2 = scan.nextLine();
		
		System.out.print("Ingrese la palabra del player2: ");
		palabra2 = scan.nextLine();
		
		
		String palabra = "";
		char ingreso = 'q';
		
		Ahorcado ar = new Ahorcado(pj1, pj2, palabra1, palabra2);
		
		while(!ar.ganador() || ingreso == '9'){
			
			ar.juego();
			 
			System.out.print("Ingrese una opcion: [0] Ingresar una letra ");
			System.out.println("| [1] Arriesgar | [9] salir");
			
			ingreso = scan.next().charAt(0);
			
			scan.nextLine();
			
			switch(ingreso){
			case '0':
				System.out.print("Ingrese una letra: ");
				
				palabra = scan.nextLine();
				
				ar.ingresarLetra(palabra.charAt(0));
				
				break;
			case '1':
				System.out.print("Ingrese la palabra por la cual desea arriesgarse: ");
				
				palabra = scan.nextLine();	
				
				if(ar.arriesgar(palabra)){
					System.out.println(ar.getJ1()+" acerto la palabra.");
					System.out.println("Ahora, "+ ar.getJ2()+" tambien debe de adivinar la palabra para empatar.");
					System.out.println("Palabra adivinar para " + ar.getJ2() + ": "+ar.getPalabraA());
					
					System.out.print("Ingrese la palabra por la cual desea arriesgarse: ");
					
					palabra = scan.nextLine();
					
					ar.cambiarTurno();
					
					if(!ar.arriesgar(palabra))
						System.out.println(ar.getJ1()+" no acerto en la palabra...");
				}else
					System.out.println(ar.getJ1()+" no acerto en la palabra...");
				
				break;
			case '9':
				System.out.println("BAIS");
				break;
			default:
				System.out.println("Valor incorrecto");
			}
		}
		
		if(ar.getGanador() == 0)
			System.out.println(ar.getNombre(ar.getGanador())+" GANO");
		if(ar.getGanador() == 1)
			System.out.println(ar.getNombre(ar.getGanador())+" GANO");
		if(ar.getGanador() == 2)
			System.out.println("EMPATE.");

	}

}