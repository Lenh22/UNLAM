package ar.edu.unlam.modelo;

public class Vuelo {


	private final int CANTIDAD_DE_FILAS = 32;
	private final int CANTIDAD_DE_ASIENTOS_POR_FILA = 6;
	private String origen;
	private String destino;
	private Pasajero[] pasajeros;
	private Pasajero[][] asientos;
	
	public Vuelo ( String origen, String destino, int cantidadPasajero) {
		
		this.origen=origen;
		this.destino=destino;
		this.pasajeros =new Pasajero [cantidadPasajero];
		this.asientos = new Pasajero [CANTIDAD_DE_FILAS][CANTIDAD_DE_ASIENTOS_POR_FILA];
	}
	
	public boolean agregarPasajero(Pasajero pasajero) {
		
		boolean exito=false;
		int posicion=0;
		if(espacio()<this.pasajeros.length) {
			do {
				if(this.pasajeros[posicion]==null) {
					this.pasajeros[posicion]=pasajero;
					posicion=this.pasajeros.length;
					exito=true;
				}else {
					posicion++;
				}
			}while(posicion<this.pasajeros.length);
			
		}
	
		return exito;
	}
	
	public int espacio() {
		
		int espacio=0;
		
		for(int i=0; i<this.pasajeros.length;i++) {
			if(this.pasajeros[i]!=null){
				espacio++;
			}
		}
		
		return espacio;
	}

	public boolean verificarDisponibilidadAsiento(int fila, int columna) {
		
		if(this.asientos[fila][columna]==null) {
			return true;
		}else {
			return false;
		}
		
		
		
	}
	
	public Pasajero buscarPasajero(int dni) {
		
		Pasajero buscado=null;
		
		for(int i=0; i<this.pasajeros.length;i++) {
			if (this.pasajeros[i]!=null) {
				if (this.pasajeros[i].getDni() == dni) {
					buscado = this.pasajeros[i];
				} 
			}
		}
		return buscado;
		
	}
	
	public boolean asignarAsiento(Pasajero pasajero, int fila, int columna) {
		
		if(verificarDisponibilidadAsiento(fila, columna)==true) {
			this.asientos[fila][columna]=pasajero;
			return true;
		}else {
			return false;
		}
		
	}
	
	public void ordenarListaDePasajerosPorDNI() {
		
		int comp;
		Pasajero n;
		do {
			comp=0;
			
			for(int i=0;i<espacio()-1;i++) {
				if(this.pasajeros[i].getDni()>this.pasajeros[i+1].getDni()) {
					n=this.pasajeros[i];
					this.pasajeros[i]=this.pasajeros[i+1];
					this.pasajeros[i+1]=n;
					comp++;
				}
					
				}
			
		}while(comp!=0);
		
	}
	
	public Pasajero[] getPasajeros() {
		
		return this.pasajeros;
		
	}
	
	public String toString() {
		
		String asiento="";
		
		for(int i=0; i<CANTIDAD_DE_FILAS;i++) {
			for(int l=0;l <CANTIDAD_DE_ASIENTOS_POR_FILA;l++) {
				if(this.asientos[i][l]==null) {
					asiento+="L";
				}else {
					asiento+="O";
				}
			}
			asiento+="\n";
		}
		
		return asiento;
	}
	
	
}
