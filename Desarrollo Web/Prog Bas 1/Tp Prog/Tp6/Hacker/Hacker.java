import java.util.Scanner;

public class Hacker {
	private String cuent="";
	private int plata;
	private int deposito;
	
	public Hacker (String nombre, int saldoInicial, int depositoPorMes) {
		cuent=nombre;
		plata=saldoInicial;
		deposito=depositoPorMes;
		System.out.println("Saldo Inicial: "+plata+ "   Depositado al mes:  " +deposito);
	}
	
	public static void main (String[]arg) {
		
		Scanner teclado=new Scanner (System.in);
		System.out.println("Ponga nombre de la cuenta/Saldo inicial/Y el deposito por mes");
		String cue1=teclado.nextLine();
		int ini = teclado.nextInt();
		int mes= teclado.nextInt();
		
		Hacker cuenta= new Hacker (cue1, ini, mes);
		int dineroRobado = 0;
		int extraccion;
		int actual=cuenta.deposito+cuenta.plata;
		int inicial=cuenta.plata;
		int porMEs=cuenta.deposito;
		
		System.out.println("¿Y cuanto dinero desea robarle aproximadamente?");
		int robomax=teclado.nextInt();
		
		while(dineroRobado<robomax) {
		
			if(actual>inicial/2)
		{	System.out.println("Se puede hacer la extraccion");
			extraccion=actual/10;
			System.out.println("Robaste "+ extraccion);
			actual=actual-extraccion;
			System.out.println("El saldo en cuenta "+actual);
			inicial=actual;
			System.out.println("Su nuevo saldo inicial es: " +inicial);
			actual=actual+porMEs;
			System.out.println("El saldo con su deposito del mes: "+cuenta.deposito+" Entonces es: "+actual);
		 	dineroRobado=+extraccion;
			System.out.println("Total del dinero robado: "+dineroRobado);
		}else {
			System.out.println("No se puede robar");
			dineroRobado=robomax;
			  }	
		}	
	}
}
