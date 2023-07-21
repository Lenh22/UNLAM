package Excepciones;

public class Cuenta {
	private double saldo;
	private String titular;
	
	public CuentaBancaria(double saldoInicial, String titular) {
		this.saldo = saldoInicial;
		this.titular = titular;
	}
	
	public String getConsulta() {
		return this.titular+" saldo de la cuenta: "+getSaldo();
	}
	public double getSaldo() {
		return this.saldo;
	}
	
	public void depositar(double deposito) {
		this.saldo = saldo + deposito;
	}
	
	public void Extraer(double cantidadDeExtraccion) {
		if (cantidadDeExtraccion<saldo) 
		this.saldo = this.saldo - cantidadDeExtraccion;
		
	}
	
}
