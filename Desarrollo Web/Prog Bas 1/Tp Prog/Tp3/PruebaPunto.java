public class PruebaPunto{
	public static void main(String[]args){
		Punto ob1 = new Punto(4 , 8);
		 
		 System.out.println("eje x= "+ob1.getCoordenadasX());
		 System.out.println("eje y= "+ob1.getCoordenadasY());
	
		 ob1.setCoordenadas( -1 ,0 );
		 System.out.println("eje x= "+ob1.getCoordenadasX());
		 System.out.println("eje y= "+ob1.getCoordenadasY());
		 
		 System.out.println(ob1.ConsultaPunto());
		
		
	}



}