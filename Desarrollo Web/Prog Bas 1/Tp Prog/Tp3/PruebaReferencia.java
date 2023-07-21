public class PruebaReferencia{
	public static void main (String args[]){
		String texto1=new String ("Hola");
		String texto2= new String ("Hola");
		
				if (texto1==texto2){
				System.out.println("Los textos son iguales");
				}
				else{
				System.out.println("Los textos son distintos");
				}
	
	}
}

//13.Las cadenas no son iguales, ya que son dos instancias (dos news) distintos.