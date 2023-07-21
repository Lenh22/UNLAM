public class Temperatura{

	public final byte CELSIUS = 0;
	public final byte KELVIN = 1;
	public final byte FARENHEIT = 2;
	
	private double valor;
	
	public Temperatura(double valor){
		this.valor=valor;
	}

	public void setValor(double valor){
		this.valor=valor;
	}
	public double getValor(){
		return this.valor;
	}
	
		public double convertirA(double valor, byte unidad){
		final double CELSIUS_A_KELVIN = 273.15;
		final double CELSIUS_A_FARENHEIT = (this.valor *9/5) + 32;
	switch(unidad){
		case FARENHEIT:
			this.valor= this.valor + CELSIUS_A_FARENHEIT;
			break;
		case KELVIN:
			this.valor=this.valor+CELSIUS_A_KELVIN;
			break;
		}
		return this.valor;
	}	
	public void setValor(double valor, byte unidad){
		final double FARENHEIT_A_CELSIUS = ((valor - 32) * (5/9)); 
		final double KELVIN_A_CELSIUS = (valor - 273.15);
	switch(unidad){
		case CELSIUS:
			this.valor=valor;
			break;
		case KELVIN:
			this.valor=KELVIN_A_CELSIUS;	
			break;
		case FARENHEIT:
			this.valor=FARENHEIT_A_CELSIUS;
			break;
	}}
}