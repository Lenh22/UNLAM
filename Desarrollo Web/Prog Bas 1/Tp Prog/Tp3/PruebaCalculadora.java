public class PruebaCalculadora{
	public static void main(String [] args){
	Calculadora nr1= new Calculadora(20, 5);
		System.out.println("Suma" + nr1.sumar()+"Restar"+nr1.restar()+"Multiplicar"+nr1.multiplicar()+"Dividir"+nr1.dividir());
		System.out.println(nr1.esPositivo());
	
	
	
	}

}