public class Tornillo{
	private final char TIPO_DE_CABEZA;
	private final int LONGITUD;
	private final int CANTIDAD_DE_ROSCA;
	
	private int posicionActual;
	
	public Tornillo (final char tipoDeCabeza,final int longitud,final int cantidadDeRosca){
		this.CANTIDAD_DE_ROSCA=cantidadDeRosca;
		this.LONGITUD=longitud;
		this.TIPO_DE_CABEZA=tipoDeCabeza;
		this.posicionActual=0;
	}
	public int getLongitud(){
	return this.LONGITUD;
	}
	public char getTipodeCabeza(){
	return this.TIPO_DE_CABEZA;
	}
	
	public boolean girar (char sentido){
	char sentidoDeGiro=sentido;
	boolean girar=false;
	this.posicionActual=0;
	while (posicionActual<CANTIDAD_DE_ROSCA){
		switch (sentido){
		case 'A': posicionActual++;
		girar=true;
		System.out.println("Cantidad giros antihorario "+posicionActual);
		break;
		case 'H':
		girar=true;
		System.out.println("Cantidad giros antihorario "+posicionActual);
		break;
		
		
			}
		}
	return girar;
	}
	
	
}
