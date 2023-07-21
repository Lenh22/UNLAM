import java.util.Scanner;

public class Notas{
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		
		final byte N_ALUMNOS = 4;
		
		String[] alumnos = new String[N_ALUMNOS];
		float[] notas = new float[N_ALUMNOS];
		
		for(int i = 0; i < notas.length; i++){
			System.out.print("Ingrese el nombre del alumno: ");
			alumnos[i] = scan.nextLine();
			
			System.out.print("Ingrese la nota de ese alumno: ");
			notas[i] = scan.nextFloat();
			
			scan.nextLine();
		}
		
		for(int i = 0; i < notas.length; i++){
			System.out.print("Nombre: " +alumnos[i]);
			System.out.print(" | Nota: " + notas[i]);
			
			if(notas[i] >= 7 && notas[i] <= 10)
				System.out.println(" | APROBADO.");
			else if(notas[i] >= 4 && notas[i] <= 6)
				System.out.println(" | PROMOCIONADO.");
			else if(notas[i] >= 1 && notas[i] <= 3)
				System.out.println(" | DESAPROBADO.");
			else 
				System.out.println(" | Ingreso una nota erronea");
		}
		
		
	}

}