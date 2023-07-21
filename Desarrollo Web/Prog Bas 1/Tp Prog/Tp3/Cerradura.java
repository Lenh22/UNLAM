public class Cerradura{
	private int claveDeApertura=1234;
	private boolean bloqueada;
	private int cantidadDeIntentos;
	private int cantFallida;
	private int cantExito;
	private int cantDeFallosQueBloquean;
	private boolean estaAbierta; 
	
	
	
	public Cerradura (int claveDeApertura, int cantFallida){
		this.claveDeApertura=claveDeApertura;
		this.cantDeFallosQueBloquean=cantDeFallosQueBloquean;
		
		
	}
	public  boolean abrir (int clave){
	if (this.claveDeApertura==clave) {
		this.estaAbierta=true;}
		else{
		cantDeFallosQueBloquean++;
		this.estaAbierta=false;}
		return estaAbierta;
	}
	public void cerrar(){
		this.estaAbierta=false;
	}
	public boolean abierta(){
		return estaAbierta;
	}

	public boolean bloqueada(){
	if (this.cantDeFallosQueBloquean>this.cantFallida){
		this.bloqueada=true;
		System.out.println("Se bloqueo bro");}
		else{
			this.bloqueada=false;
			System.out.println("No se bloqueo");
		}
		return bloqueada;
	}
}