package ar.edu.unlam.eva02;

public class Camion extends Vehiculo {

	private Integer cantidadDeRuedas;
	private Integer altura;
	private Double capacidadDeCarga;

	public Camion(TipoVehiculo tipoDeVehiculo, Integer numeroDeSerie, String modelo, Fabricante fabricante, Integer capacidadDePersonas,
			Integer año, Boolean ceroKm, Double precio, Integer cantidadDeRuedas, Integer altura,
			Double capacidadDeCarga) {
		super(tipoDeVehiculo, numeroDeSerie, modelo, fabricante, año, ceroKm, precio);
		this.cantidadDeRuedas = cantidadDeRuedas;
		this.altura = altura;
		this.capacidadDeCarga = capacidadDeCarga;
	}
	
	public Camion(TipoVehiculo tipoDeVehiculo, Integer numeroDeSerie, String modelo, Fabricante fabricante, Integer capacidadDePersonas,
			Integer año, Boolean ceroKm, Double precio, Integer cantidadDeRuedas, Integer altura,
			Double capacidadDeCarga, Integer kilometraje) {
		super(tipoDeVehiculo, numeroDeSerie, modelo, fabricante, año, ceroKm, precio, kilometraje);
		this.cantidadDeRuedas = cantidadDeRuedas;
		this.altura = altura;
		this.capacidadDeCarga = capacidadDeCarga;
	}

	public Double getCapacidadDeCarga() {
		return capacidadDeCarga;
	}

	public void setCapacidadDeCarga(Double capacidadDeCarga) {
		this.capacidadDeCarga = capacidadDeCarga;
	}

	public Integer getCantidadDeRuedas() {
		return cantidadDeRuedas;
	}

	public void setCantidadDeRuedas(Integer cantidadDeRuedas) {
		this.cantidadDeRuedas = cantidadDeRuedas;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	
}