package ar.edu.unlam.eva02;

public class Moto extends Vehiculo {

	private Integer cilindradas;

	public Moto(TipoVehiculo tipoDeVehiculo, Integer numeroDeSerie, String modelo, Fabricante fabricante, Integer año, Boolean ceroKm, Double precio,
			Integer cilindradas) {
		super(tipoDeVehiculo, numeroDeSerie, modelo, fabricante, año, ceroKm, precio);
		this.cilindradas = cilindradas;
	}
	
	public Moto(TipoVehiculo tipoDeVehiculo, Integer numeroDeSerie, String modelo, Fabricante fabricante, Integer año, Boolean ceroKm, Double precio,
			Integer cilindradas, Integer kilometraje) {
		super(tipoDeVehiculo, numeroDeSerie, modelo, fabricante, año, ceroKm, precio, kilometraje);
		this.cilindradas = cilindradas;
	}

	public Integer getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(Integer cilindradas) {
		this.cilindradas = cilindradas;
	}

}