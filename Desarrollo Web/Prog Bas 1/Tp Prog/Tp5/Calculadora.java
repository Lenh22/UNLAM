package TrabajoPractico5;

import java.util.Scanner;

public class Calculadora{
		//atributos
		private double operador1;
		private double operador2;
		//constructores
		public Calculadora(){
		}
		public Calculadora(double operador1 , double operador2){
		this.operador1 = operador1;
		this.operador2 = operador2;
		}
		//metodos
		public double sumar(){
			double total = this.operador1 + this.operador2;
			return total;
		}
		public double sumar(double operador1, double operador2){
			double total = operador1 + operador2;
			return total;
		}
		public double resta(){
			double total = this.operador1 - this.operador2;
			return total;
		}
		public double resta(double operador1, double operador2){
			double total = operador1 - operador2;
			return total;
		}

		public double multiplicar(){
			double total = operador1 * operador2;
			return total;
		}
		
		public double dividir(){
				if (operador2==0.0){
			System.out.println("No se puede dividir por 0 capo!");
			return 0;
			}
			
			return operador1 / operador2;
		}
		
		
		public double dividir(double operador1,double operador2){
			if (operador2==0.0){
			System.out.println("No se puede dividir por 0");
			return 0;
			}
			return operador1/operador2;
			}
		
		//TRABAJO PRACTICO 5 MODIFICACIONES:
		//PUNTO 2 :
		public void potencia(double base, double exponente ) {
			this.operador1 = base;
			this.operador2 = exponente;
			int resultado = 0;
			for(int i = 0;i<=this.operador2;i++)  {
					resultado = (int)Math.pow(this.operador1, i);
					System.out.println("el operador: "+this.operador1+" elevado a : "+i+" es igual a: "+resultado);
					}
				
					System.out.println("el resultado es: "+resultado);
					}
		
			
		//PUNTO 3:
		public void sumatoria(int limite) {
			
			int resultado = 0;
			for(int i=0;i<=limite;i++ ) {
				resultado = resultado + i; 
				System.out.println("sumatoria: "+i+" resultado: "+resultado);
				}
			System.out.println("el resultado es: "+resultado);
		}
		//PUNTO 4 :
		public void sumatoria(int limiteInferior, int limiteSuperior) {
			int resultado = 0;
			for(int i=limiteInferior;i<=limiteSuperior;i++) {
				
				resultado =resultado +i;
				
				System.out.println("la sumatoria es:"+i+" resultado es: "+resultado);
			
			}
			System.out.println("resultado: "+resultado);
		}
		//PUNTO 5;
		public void productoria(int limite) {
			int resultado = 1;
			for(int i=1;i<=limite;i++) {
				resultado =resultado * i;
				
				System.out.println("la sumatoria es:"+i+" resultado es: "+resultado);
			
			}
			System.out.println("resultado: "+resultado);
			
		}
		//PUNTO 6 ;
		public void productoria(int limiteInferior, int limiteSuperior) {
			
			int resultado = 1;
		for(int i=limiteInferior;i<=limiteSuperior;i++) {
			
			resultado =resultado * i;
			
			System.out.println("la sumatoria es:"+i+" resultado es: "+resultado);
		
		}
		System.out.println("resultado: "+resultado);
		}
		
		//punto 7:
		public void contarDiveores(int numero) {
			int resultado = 0;
			for(int i = 1; i<=numero;i++) {
				if(numero%i == 0) {
					resultado = i;
					System.out.println("divisores: "+resultado);
				}
				
				
			}
		}
}