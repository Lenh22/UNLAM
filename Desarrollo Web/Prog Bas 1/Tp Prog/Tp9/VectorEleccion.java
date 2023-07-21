import java.util.Scanner;

	public class VectorEleccion {
		public static void main (String [] arg) {
			Scanner teclado= new Scanner(System.in);
			System.out.print("De cuanto sera el Vector?");
			int max=teclado.nextInt();
			
			int vector[]= new int [max];
			int numero;
			
			for(int i=0;i<vector.length;i++) {
			System.out.print("Ingrese numero: ");
			
			numero=teclado.nextInt();
			vector[i]=numero;
			}
			for(int i=0;i<vector.length;i++) {
				System.out.println("En la posicion "+i+" Los numeros son: "+vector[i]);
				
			}
		}

	}
