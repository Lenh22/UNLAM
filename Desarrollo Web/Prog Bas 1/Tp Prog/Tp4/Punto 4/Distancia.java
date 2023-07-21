public class Distancia{
	
	// en metros:
	public final byte DECAMETRO = 0;
	public final byte HECTOMETRO = 1;
	public final byte KILOMETRO = 2;
	
	private final int DECAMETRO_A_METRO = 10;
	private final int HECTOMETRO_A_METRO = 100;
	private final int KILOMETRO_A_METRO = 1000;
	private double valor;
	
	public Distancia(double valor){
		this.valor=valor;
	}
	public void setValor(double valor){
		this.valor=valor;
	}
	public void setValor(double valor, byte unidad){
		switch(unidad){
			case DECAMETRO:
				this.valor = valor*DECAMETRO_A_METRO;
				break;
			case HECTOMETRO:
				this.valor = valor*HECTOMETRO_A_METRO;
				break;
			case KILOMETRO:
				this.valor = valor*KILOMETRO_A_METRO;
				break;
		}
	}
	public double getValor(){
		return this.valor;
	}
	public double convertir(byte unidad){
		switch(unidad){
			case DECAMETRO:
				this.valor=valor/DECAMETRO_A_METRO;
			case HECTOMETRO:
				this.valor=valor/HECTOMETRO_A_METRO;
			case KILOMETRO:
				this.valor=valor/KILOMETRO_A_METRO;
	}return this.valor;
	}
}