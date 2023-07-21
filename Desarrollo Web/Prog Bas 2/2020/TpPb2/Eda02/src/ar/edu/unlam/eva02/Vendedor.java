package ar.edu.unlam.eva02;

import java.util.ArrayList;
import java.util.HashSet;

public class Vendedor {

	private String nombre;
	private String apellido;
	private Integer codigoEmpleado;
	private Integer antigüedad;
	private Integer sueldo;
	private HashSet<Vehiculo>ListaDelGarageDeUsadosDeLaEmpresa;
	private HashSet<Vehiculo>ListaDelGarageDeNuevosDeLaEmpresa;
	private HashSet<Vehiculo> ListaVehiculosVendidos;
	private ArrayList<Cliente> ListaDeClientesQueCompraron;

	public Vendedor(String nombre, String apellido, Integer codigoEmpleado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigoEmpleado = codigoEmpleado;
		this.ListaDelGarageDeUsadosDeLaEmpresa = new HashSet<Vehiculo>();
		this.ListaDelGarageDeNuevosDeLaEmpresa = new HashSet<Vehiculo>();
		this.ListaVehiculosVendidos = new HashSet<Vehiculo>();
		this.ListaDeClientesQueCompraron = new ArrayList<Cliente>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(Integer codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public Integer getAntigüedad() {
		return antigüedad;
	}

	public void setAntigüedad(Integer antigüedad) {
		this.antigüedad = antigüedad;
	}

	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}

	public Boolean obtenerListaDelGarageDeVehiculosUsados(HashSet<Auto> autosUsados) {
		return this.ListaDelGarageDeUsadosDeLaEmpresa.addAll(autosUsados);
	}
	
	public Boolean obtenerListaGarageDeVehiculosNuevos(HashSet<Auto> autosnuevos) {
		return this.ListaDelGarageDeNuevosDeLaEmpresa.addAll(autosnuevos);
	}

	public Integer obtenerCantidadVehiculosEnLaListaDeUsados() {
		return this.ListaDelGarageDeUsadosDeLaEmpresa.size();
	}

	public Integer obtenerCantidadVehiculosEnLaListaDeNuevos() {
		return this.ListaDelGarageDeNuevosDeLaEmpresa.size();
	}
//
	public Boolean vender(Vehiculo tipoVehiculo, Cliente nuevoCliente) {
		if(buscarVehiculo(tipoVehiculo)) {
			if(!buscarVehiculosEnListaDeVendidos(tipoVehiculo))
				if(aniadirClienteNuevo(nuevoCliente))
					if(aniadirVehiculoAlaListaDeVendidos(tipoVehiculo))
				return true;
		}
			
		return false;
	}

	private boolean aniadirVehiculoAlaListaDeVendidos(Vehiculo tipoVehiculo) {
		return this.ListaVehiculosVendidos.add(tipoVehiculo);
	}

	private boolean aniadirClienteNuevo(Cliente nuevoCliente) {
		return this.ListaDeClientesQueCompraron.add(nuevoCliente);
	}

	private boolean buscarVehiculosEnListaDeVendidos(Vehiculo tipoVehiculo) {
		for (Vehiculo nuevo : ListaVehiculosVendidos) {
			if (nuevo.getNumeroDeSerie().equals(tipoVehiculo.getNumeroDeSerie()))
				return true;
		}
		for (Vehiculo usado : ListaVehiculosVendidos) {
			if(usado.getNumeroDeSerie().equals(tipoVehiculo.getNumeroDeSerie()))
				return true;
		}
		return false;
	}

	private boolean buscarVehiculo(Vehiculo tipoVehiculo) {
		for (Vehiculo nuevo : ListaDelGarageDeNuevosDeLaEmpresa) {
			if(nuevo.getNumeroDeSerie().equals(tipoVehiculo.getNumeroDeSerie())) {
				return true;
			}
		}
		for (Vehiculo usado : ListaDelGarageDeUsadosDeLaEmpresa) {
			if(usado.getNumeroDeSerie().equals(tipoVehiculo.getNumeroDeSerie())) {
				return true;
			}
		}
		return false;
	}
	
	
	
}

