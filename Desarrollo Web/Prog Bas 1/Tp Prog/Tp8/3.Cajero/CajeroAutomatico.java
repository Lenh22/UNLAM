import java.util.Scanner;

public class CajeroAutomatico
{
	public static void main (String [] arg)
	{
		Scanner teclado= new Scanner(System.in);
		Cuenta miCuenta = new Cuenta ( "Leandro" );
	
		char opcion;
		
		
		System.out.println("Bienvenido");
		do {System.out.println("Elija una opcion");
		System.out.println("a.DEPOSITAR \n b.EXTRAER \n c.CONSULTAR \n d.SALIR");
		opcion=teclado.next().charAt(0);
			switch(opcion) {
			case 'a':
				System.out.println("Cuanto quiere depositar?");
				int deposito=teclado.nextInt();
				miCuenta.depositar( deposito );
				
			break;
			case'b':
				System.out.println("Cuanto quiere extraer?");
				int extraer=teclado.nextInt();
				miCuenta.retirar (extraer);
				
				break;
			case'c':
				System.out.println(miCuenta.toString() );
				break;
			case'd':
				System.out.println("Adios, que tenga buen dia");
				break;
			default:
				System.out.println("No se encontro la opcion, vuelva a intentar");
				break;
			}
		}while(opcion!='d');
	}
}
