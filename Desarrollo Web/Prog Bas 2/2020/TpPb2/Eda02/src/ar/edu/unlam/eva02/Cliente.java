package ar.edu.unlam.eva02;

import java.util.ArrayList;

public class Cliente {

	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer cuota=0;
	private Integer cuotaTotales=24;
	private Integer mesesUsados=0;
	private Integer comprado=0;
	
	private ArrayList<Vehiculo>comprados;
	private ArrayList<Vehiculo>alquilado;
	private ArrayList<Vehiculo>reservado;
	

	public Cliente(String nombre, String apellido, Integer dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.comprados=new ArrayList<Vehiculo>();
		this.alquilado=new ArrayList<Vehiculo>();
		this.reservado=new ArrayList<Vehiculo>();
	}
//Get y set del nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//Get y set del apellido
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
//Get y set del DNI
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
//Get y set de Vehiculos comprados
	public ArrayList<Vehiculo> getComprados() {
		return comprados;
	}
	public void setComprados(ArrayList<Vehiculo> Vcomprados) {
		comprados = Vcomprados;
	}
//Cant de Vehiculos
	public Integer getCantidadVehiculos() {
		return comprado;
	}

//Metodo comprar vehiculo
	public boolean comprarContado(Vehiculo tipoDeVehiculo, Vendedor vendedor) {
		Cliente nuevoCliente = new Cliente(nombre, apellido, dni); 
		if(this.comprado<=2) { 
			if(vendedor.vender(tipoDeVehiculo, nuevoCliente)) {
				if(aniadirVehiculoAlaListaDeComprados(tipoDeVehiculo))
					this.comprado++;
				return true;
		}
				}
					return false;
	}
	
	
	//Compra a cuotas
	public boolean comprarCuotas(Vehiculo tipoDeVehiculo, Vendedor vendedor) {
		
		if(getCantidadVehiculos()<2) {
			Cliente nuevoCliente = new Cliente(nombre, apellido, dni);
			
			if(vendedor.vender(tipoDeVehiculo, nuevoCliente)) {
				if(aniadirVehiculoReservado(tipoDeVehiculo))
					if(cuota>=6)
					this.reservado.remove(tipoDeVehiculo);
				if(aniadirVehiculoAlaListaDeComprados(tipoDeVehiculo))
					
					return true;
				}
			}
		return false;
	}

////Pagar cuotas
	
	Integer aniadirCuotaPagada() {
		this.cuota++;
		return cuota;
		
	}
//Get de cuota
	private Integer getCuotas() {
		return this.cuota;
	}

//Coches comprados 
	private boolean aniadirVehiculoAlaListaDeComprados(Vehiculo obtenido) {
		return this.comprados.add(obtenido);
	}
//Mostrar comprados
	public void mostrarListaDeVehiculosComprados() {
		for (Vehiculo actual : comprados) {
			System.out.println(actual.toString());
		}
	}

//Coche reservados
	private boolean aniadirVehiculoReservado(Vehiculo obtenido){
		return this.reservado.add(obtenido);
		
	}
//Mostrar reservados
	public void mostrarListaDeVehiculosReservados() {
		for (Vehiculo actual : reservado) {
			System.out.println(actual.toString());
		}
	}
//Overrides para que el cliente no se repita
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Cliente other = (Cliente) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
}
