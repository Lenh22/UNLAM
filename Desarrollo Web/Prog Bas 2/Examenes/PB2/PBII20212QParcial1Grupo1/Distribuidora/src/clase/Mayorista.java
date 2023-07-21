package clase;

public class Mayorista extends Cliente {

	public Mayorista(String nombre, Integer cuil) {
		super(nombre, cuil);
		this.setMayorista(true);
	}

	
}
