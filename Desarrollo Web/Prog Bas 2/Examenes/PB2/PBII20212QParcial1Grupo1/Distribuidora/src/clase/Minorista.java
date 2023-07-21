package clase;

public class Minorista extends Cliente {

	public Minorista(String nombre, Integer cuil) {
		super(nombre, cuil);
		this.setMayorista(false);
	}
	

}
