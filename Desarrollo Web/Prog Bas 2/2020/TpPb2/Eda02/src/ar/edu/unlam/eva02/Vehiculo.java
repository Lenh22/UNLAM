package ar.edu.unlam.eva02;

public abstract class Vehiculo {

	private Integer numeroDeSerie;
	private String modelo;
	private Fabricante fabricante;
	private String capacidadDePersonas;
	private Integer año;
	private Boolean ceroKm;
	private String tipoMotor;
	private Integer caballosDeFuerza;
	private String tipoCombustible;
	private String color;
	private Double precio;
	private Integer kilometraje;
	private TipoVehiculo tipoDeVehiculo;
	protected final Integer CANT_MAX_KILOMETRAJE;

	public Vehiculo(TipoVehiculo tipoDeVehiculo, Integer numeroDeSerie, String modelo, Fabricante fabricante,
			Integer año, Boolean ceroKm, Double precio) {
		this.tipoDeVehiculo = tipoDeVehiculo;
		this.numeroDeSerie = numeroDeSerie;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.año = año;
		this.ceroKm = ceroKm;
		this.precio = precio;
		this.CANT_MAX_KILOMETRAJE = 100000;
	}

	public Vehiculo(TipoVehiculo tipoDeVehiculo, Integer numeroDeSerie, String modelo, Fabricante fabricante,
			Integer año, Boolean ceroKm, Double precio, Integer kilometraje) {
		this.tipoDeVehiculo = tipoDeVehiculo;
		this.numeroDeSerie = numeroDeSerie;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.año = año;
		this.ceroKm = ceroKm;
		this.precio = precio;
		this.kilometraje = kilometraje;
		this.CANT_MAX_KILOMETRAJE = 100000;
	}

	public Integer getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(Integer numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public String getCapacidadDePersonas() {
		return capacidadDePersonas;
	}

	public void setCapacidadDePersonas(String capacidadDePersonas) {
		this.capacidadDePersonas = capacidadDePersonas;
	}

	public Integer getAño() {
		return año;
	}

	public void setAño(Integer año) {
		this.año = año;
	}

	public Boolean getCeroKm() {
		return ceroKm;
	}

	public void setCeroKm(Boolean ceroKm) {
		this.ceroKm = ceroKm;
	}

	public String getTipoMotor() {
		return tipoMotor;
	}

	public void setTipoMotor(String tipoMotor) {
		this.tipoMotor = tipoMotor;
	}

	public Integer getCaballosDeFuerza() {
		return caballosDeFuerza;
	}

	public void setCaballosDeFuerza(Integer caballosDeFuerza) {
		this.caballosDeFuerza = caballosDeFuerza;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(Integer kilometraje) {
		this.kilometraje = kilometraje;
	}

	public TipoVehiculo getTipoDeVehiculo() {
		return tipoDeVehiculo;
	}

	public void setTipoDeVehiculo(TipoVehiculo tipoDeVehiculo) {
		this.tipoDeVehiculo = tipoDeVehiculo;
	}

	@Override
	public String toString() {
		return "Vehiculo [numeroDeSerie=" + numeroDeSerie + ", modelo=" + modelo + ", fabricante=" + fabricante
				+ ", capacidadDePersonas=" + capacidadDePersonas + ", año=" + año + ", ceroKm=" + ceroKm
				+ ", tipoMotor=" + tipoMotor + ", caballosDeFuerza=" + caballosDeFuerza + ", tipoCombustible="
				+ tipoCombustible + ", color=" + color + ", precio=" + precio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDeSerie == null) ? 0 : numeroDeSerie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (numeroDeSerie == null) {
			if (other.numeroDeSerie != null)
				return false;
		} else if (!numeroDeSerie.equals(other.numeroDeSerie))
			return false;
		return true;
	}

}