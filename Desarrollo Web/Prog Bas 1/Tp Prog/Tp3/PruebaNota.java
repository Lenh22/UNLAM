public class PruebaNota{
	public  static void main (String [] arg){
		Nota nro = new Nota (3);
		Nota nro2 = new Nota (7);
		Nota nro3 = new Nota (2);
		//1
			System.out.println("El valor" + nro.getValor());
			System.out.println("Aprobado: " + nro.aprobado());
		//2
			System.out.println("El valor" + nro2.getValor());
			System.out.println("Aprobado " + nro2.aprobado());
		//3
			nro3.recuperar(8);
			System.out.println("El valor" + nro3.getValor());
			System.out.println("Aprobado " + nro3.aprobado());
	}	
}