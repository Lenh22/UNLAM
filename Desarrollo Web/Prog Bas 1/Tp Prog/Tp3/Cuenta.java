public class Cuenta{
	private int saldo=0;
	private int importar;
	private int extraer;
	
	public Cuenta (int saldo){
		this.saldo=saldo;
	}
	public int importe (int importar) {
	return (saldo+=importar);
	}
	public int extraerlo (int extraer){
	if (this.saldo>=importar){
	return (this.saldo-=importar);}
		else{
		System.out.println ("No se puede extraer");}
		return this.saldo ;}	
	}
	





