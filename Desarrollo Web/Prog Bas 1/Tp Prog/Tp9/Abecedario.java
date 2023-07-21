import java.util.Scanner;

public class Abecedario{
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final byte MAX_ABC = 26;
		
		char abcd[] = new char[MAX_ABC];
		byte pos = 65;
		
		for(int i = 0; i < abcd.length; i++){
			abcd[i] = (char) pos;
			pos++;
		}
		
		int lop = 0;
		String cadena = "";
		
		System.out.println("Ingresar -1 para terminar el programa.");
		while(lop != -1){
			
			System.out.print("Ingrese un numero de la posicion del abcedario (0-25): ");
			lop = scan.nextInt();
			
			if(lop >= 0 && lop <= 25)
				cadena += abcd[lop];
			else
				System.out.println("Valor ingresado no esta entre el rango");
			
			System.out.println(lop);
		}
		
		System.out.println("La cadena que se formo fue: ");
		System.out.println(cadena);
		
		
		
		

	}

}
