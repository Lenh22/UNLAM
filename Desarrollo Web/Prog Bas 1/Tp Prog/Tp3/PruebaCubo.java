public class PruebaCubo{
	public static void main(String[]args){
		Cubo ob1 = new Cubo(9);
		
		ob1.setLongitudLado(-5);
		System.out.println(ob1.getLado());
			if (ob1.getLado()>0){
				System.out.println(ob1.getSuperficieCara());
				System.out.println(ob1.getVolumen());
			}
			else{
			System.out.println("La longitud no puede ser negativa");
			}
		
		
		
			
		
		
		
	}
	







}