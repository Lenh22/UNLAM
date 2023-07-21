public class Calculadora
{
//Atributos
	private double operador1;
	private double operador2;
//Constructores
	public Calculadora (){
	operador1=0;
	operador2=0;
	}
	public Coche (double operador1, double operador2){
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
	public double restar (double operador1 - double operador2){
		return operador1 - operador2;
	}
	public double multiplicar(){
		return this.operador1 * this.operador2;
	}
	public double  multiplicar (double operador1 * double operador2){
		return operador1 * operador2;
	}
	public double dividir (){
		double resultador=0;
	if (this.operador2!= 0)
	{resultador= this.operador1 / this.operador2;}
		else
	{System.out.println("No se puede hacer la divicion");}
		return resultador;
	}
	
	public double dividir (double operador1 / double operador2){
		double resultador=0;
	if (operador2!= 0)
	{resultador= operador1 / operador2;}
		else
	{System.out.println("No se puede hacer la divicion");}
		return resultador;
	}
}
