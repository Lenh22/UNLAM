import java.util.Scanner;

public class Capicua{
	
	static public boolean esCapicua(String num){

		byte numfinal =  (byte) (num.length() - 1);
		
		for(int i = 0; i < num.length(); i++){
			if(num.charAt(i) != num.charAt(numfinal-i)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String numero = "";
		int num = 1;
				
		System.out.println("Ingrese 0 para salir del programa.");
		while(num != 0){
			System.out.println("Ingrese un numero para saber si es capicua: ");
			num = scan.nextInt();
			
			numero = ""+num;
			
			if(esCapicua(numero))
				System.out.println("El numero: " + numero + " es capicua");
			else
				System.out.println("El numero: "+numero+" no es capicua");
			
		}	
	}
}