public class PruebaTemperatura{
	
	public static void main(String args[]){
		
	Temperatura prueba = new Temperatura(0.0);
		
	prueba.setValor(5.0);
	System.out.println("Temperatura CELSIUS: " + prueba.getValor());
	
	prueba.convertirA(prueba.getValor(), prueba.KELVIN);
	System.out.println(" CELSIUS A KELVIN: " + prueba.getValor());
	
	prueba.convertirA(prueba.getValor(), prueba.FARENHEIT);
	System.out.println(" CELSIUS A FARENHEIT: " + prueba.getValor());
	
	System.out.println("");
	
	prueba.setValor(32.0);
	prueba.setValor(prueba.getValor(), prueba.KELVIN);
	System.out.println(" KELVIN A CELSIUS : " + prueba.getValor());
	
	prueba.setValor(prueba.getValor(), prueba.FARENHEIT);
	System.out.println(" FARENHEIT A CELSIUS : " + prueba.getValor());
	
	}

}
