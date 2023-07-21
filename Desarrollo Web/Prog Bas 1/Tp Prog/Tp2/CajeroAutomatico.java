public class CajeroAutomatico
{
	public static void main (String [] arg)
	{
		Cuenta miCuenta = new Cuenta ( "Leandro" );
	System.out.println(miCuenta.toString() );
	//Observo el nombre del usuario y el saldo actual
		miCuenta.depositar( 100.0 );
	System.out.println(miCuenta.toString() );
	//El nuevo saldo es de 100, funciona bien
		miCuenta.retirar (50.0 );
	System.out.println(miCuenta.toString() );
	//Ahora el saldo es de 50. Funciona bien
	//Con ellos veo el saldo y el titular de la cuenta
	}
}