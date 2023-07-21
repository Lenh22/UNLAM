import java.util.Scanner;

public class TipoMath {
	
	public static void main (String arg[]) {
		double numero;
		double numero2;
		
		Scanner teclado=new Scanner(System.in);
		System.out.println("Elija un numero");
		numero=teclado.nextDouble();
		
		System.out.println("La raiz cuadrada es:"+Math.sqrt((double)numero));
	
		System.out.println("El log neperiano es:"+Math.log (numero));
	
		System.out.println("Agrege otro numero");
		numero2=teclado.nextDouble();
		
		System.out.println("El minimo entro los dos es: "+Math.min(numero, numero2));
		
		System.out.println("El numero "+numero+" Elevado a "+numero2+ " es " +Math.pow(numero, numero2));
	}

}