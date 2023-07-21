import java.util.Scanner;

public class TablaAscii {
	public static void main (String[]arg) {
	 Scanner entrada=new Scanner (System.in);
		
	 char numero;
	 
	 System.out.println("Digite un numero (Entre 33 a 255) para Ascii: ");
	 numero=(char) entrada.nextInt();
	 
	 System.out.println("El numero ingresado es: "+ (int)numero);
	 
	 while(33<(int)numero&&numero<=255) {
		 
		 if(48<=numero&&numero<=57) {
			 System.out.print("\nEn ASCII es un numero ingresado:  ");
			 System.out.print(numero);
			 }else {
				 if (65<=numero&&numero<=90) {
					 System.out.print("\nEn ASCII es una letra mayuscula ingresada:  ");
					 System.out.print(numero);
					 }else {
						 if(97<=numero&&numero<=122) {
							 System.out.print("\nEn ASCII es una letra mayuscula ingresada:  ");
							 System.out.print(numero);
						 }else { System.out.println("\nEn ASCII es un caracter especial:  ");
						 		System.out.print(numero);
							 
						 }
						 
					 }
			 }
		 System.out.println("\nDigite un nuevo numero (Entre 33 a 255) para Ascii: ");
		 numero=(char) entrada.nextInt();
		 System.out.println("El numero ingresado es: "+ (int)numero);
	 }
	
	
	}
}
