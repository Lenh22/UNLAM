import java.util.Scanner;

public class Vector {
	public static void main (String [] arg) {
		int vector[]= new int [5];
		int numero;
		
		for(int i=0;i<vector.length;i++) {
		System.out.print("Ingrese numero: ");
		Scanner teclado= new Scanner(System.in);
		numero=teclado.nextInt();
		vector[i]=numero;
		}
		for(int i=0;i<vector.length;i++) {
			System.out.println("En posicion "+i+" los numeros son: "+vector[i]);
			
		}
	}

}