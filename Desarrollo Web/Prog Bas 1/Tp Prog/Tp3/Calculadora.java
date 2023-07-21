public class Calculadora
{
//Atributos
	private double operador1;
	private double operador2;
	private double resultador;
//Constructores
	public Calculadora (){
	operador1=0;
	operador2=0;
	}
	public Calculadora (double operador1, double operador2){
	this.operador1 = operador1;
	this.operador2 = operador2;
	}
//Metodos
	public double sumar(){
		return this.operador1 + this.operador2;
	}
	public double sumar (double operador1, double operador2){
		return operador1 + operador2;
	}
	public double restar(){
		return this.operador1 - this.operador2;
	}
	public double restar (double operador1 , double operador2){
		return operador1 - operador2;
	}
	public double multiplicar(){
		return this.operador1 * this.operador2;
	}
	public double  multiplicar (double operador1 , double operador2){
		return operador1 * operador2;
	}
	public double dividir (){
		double resultador=0;
	if (this.operador2!= 0)
	{resultador= this.operador1 / this.operador2;}
		else
	{System.out.println("No se puede hacer la division");}
		return resultador;
	}
	
	public double dividir (double operador1 , double operador2){
		double resultador=0;
	if (operador2!= 0)
	{resultador= operador1 / operador2;}
		else
	{System.out.println("No se puede hacer la divicion");}
		return resultador;
	}
	public double esPositivo (){
		
	if (this.resultador >= 0)
	{System.out.println ("El resultado es positivo");}
		else
	{System.out.println("El resultado es negativo");}
	return this.resultador;
	}
}
