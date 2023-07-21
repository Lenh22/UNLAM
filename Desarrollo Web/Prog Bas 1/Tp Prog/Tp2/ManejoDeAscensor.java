public class ManejoDeAscensor
{
	public static void main (String [] args)
	{
		Ascensor consorcioCallePeron = new Ascensor ( 4 , 150.0);
	System.out.println(consorcioCallePeron.getPisoActual());
			//Se encuentra en el piso 0
		consorcioCallePeron.subir();
		consorcioCallePeron.subir();
		consorcioCallePeron.subir();
	System.out.println(consorcioCallePeron.getPisoActual() );
	//Se encuentra en el piso 3 ya que lo hice subir 3 veces desde 0
		consorcioCallePeron.irAlPiso( 3 );
	System.out.println(consorcioCallePeron.getPisoActual() );
	//Se deberia poner el comando para ir al piso directamente
		Persona pepe = new Persona ("Pepe" , "Hombre" , 123456 , 60 , 1.75);
		Persona moni = new Persona ("Moni" , "Mujer" , 123457 , 80 , 1.60);
		Persona koki = new Persona ("Koki" , "Hombre" , 123458 , 90 , 1.79);
		
		consorcioCallePeron.abrirPuerta();
		consorcioCallePeron.ingresar(pepe);
		consorcioCallePeron.ingresar(moni);
		consorcioCallePeron.ingresar(koki);
		consorcioCallePeron.subir();
	System.out.println(consorcioCallePeron.getPisoActual() );
	//Se obvserva que supera el maximo peso permito en el ascensor, ademas
	//la puerta esta abierta
		consorcioCallePeron.salir(koki);
		consorcioCallePeron.cerrarPuerta();
		consorcioCallePeron.subir();
	//Deberia sacar al mas pesado de 90 kilos, asi el ascensor sube
	System.out.println(consorcioCallePeron.getPisoActual() );
	}
}