public class PruebaDistancia{

	public static void main(String args[]){
		
		Distancia prueba = new Distancia(17.0);
		
	prueba.setValor(10.5);
	System.out.println("Valor en metros: " + prueba.getValor());
	
	prueba.setValor(prueba.getValor(), prueba.DECAMETRO);
	System.out.println("Metros a Decametros : " + prueba.getValor());
	
	prueba.setValor(prueba.getValor(), prueba.HECTOMETRO);
	System.out.println("Metros a Hectometros : " + prueba.getValor());
	
	prueba.setValor(prueba.getValor(), prueba.KILOMETRO);
	System.out.println("Metros a Kilometros : " + prueba.getValor());
	
	System.out.println("");	
		
	prueba.convertir(prueba.DECAMETRO);	
	System.out.println("Decametros a Metros: " + prueba.getValor());		
	
	prueba.convertir(prueba.HECTOMETRO);	
	System.out.println("Hectometros a Metros: " + prueba.getValor());			
	
	prueba.convertir(prueba.KILOMETRO);	
	System.out.println("Kilometros a Metros: " + prueba.getValor());		
		
		
	}

}