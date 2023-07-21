package ar.edu.unlam.eva02;

public class Auto extends Vehiculo {

	private Integer cantidadDePuertas;

	public Auto(TipoVehiculo tipoDeVehiculo, Integer numeroDeSerie, String modelo, Fabricante fabricante, Integer año,
			Boolean ceroKm, Double precio, Integer cantidadDePuertas) {
		super(tipoDeVehiculo, numeroDeSerie, modelo, fabricante, año, ceroKm, precio);
		this.cantidadDePuertas = cantidadDePuertas;
	}

	public Auto(TipoVehiculo tipoDeVehiculo, Integer numeroDeSerie, String modelo, Fabricante fabricante, Integer año,
			Boolean ceroKm, Double precio, Integer cantidadDePuertas, Integer kilometraje) {
		super(tipoDeVehiculo, numeroDeSerie, modelo, fabricante, año, ceroKm, precio, kilometraje);
		this.cantidadDePuertas = cantidadDePuertas;
	}

	public Integer getCantidadDePuertas() {
		return cantidadDePuertas;
	}

	public void setCantidadDePuertas(Integer cantidadDePuertas) {
		this.cantidadDePuertas = cantidadDePuertas;
	}

}