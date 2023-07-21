package ar.edu.unlam.eva02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Empresa {

	private String nombre;
	private Set<Vendedor> vendedores;
	private ArrayList<Cliente> clientes;
	private HashSet<Vehiculo> garajeNuevos;
	private HashSet<Vehiculo> garajeUsados;
	private HashSet<Auto> autosNuevos = new HashSet<Auto>();
	private HashSet<Auto> autosUsados = new HashSet<Auto>();
	private HashSet<Moto> motosNuevas = new HashSet<Moto>();
	private HashSet<Moto> motosUsadas = new HashSet<Moto>();
	private HashSet<Camion> camionesNuevos = new HashSet<Camion>();
	private HashSet<Camion> camionesUsados = new HashSet<Camion>();

	public Empresa(String nombre) {
		this.nombre = nombre;
		this.vendedores = new HashSet<Vendedor>();
		this.clientes = new ArrayList<Cliente>();
		this.garajeNuevos = new HashSet<Vehiculo>();
		this.garajeUsados = new HashSet<Vehiculo>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(Set<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public HashSet<Vehiculo> getGarajeNuevos() {
		return garajeNuevos;
	}

	public void setGarajeNuevos(HashSet<Vehiculo> garajeNuevos) {
		this.garajeNuevos = garajeNuevos;
	}

	public HashSet<Vehiculo> getGarajeUsados() {
		return garajeUsados;
	}

	public void setGarajeUsados(HashSet<Vehiculo> garajeUsados) {
		this.garajeUsados = garajeUsados;
	}

	public Boolean ingresarVehiculo(Vehiculo vehiculo) {
		switch (vehiculo.getTipoDeVehiculo()) {
		case AUTO:
			if (!vehiculo.getCeroKm()) {
				if (vehiculo.getKilometraje() < vehiculo.CANT_MAX_KILOMETRAJE) {
					autosUsados.add((Auto) vehiculo);
					return true;
				}
			} else {
				autosNuevos.add((Auto) vehiculo);
				return true;
			}
		case CAMION:
			if (!vehiculo.getCeroKm()) {
				if (vehiculo.getKilometraje() < vehiculo.CANT_MAX_KILOMETRAJE) {
					camionesUsados.add((Camion) vehiculo);
					return true;
				}
			} else {
				camionesNuevos.add((Camion) vehiculo);
				return true;
			}
		case MOTO:
			if (!vehiculo.getCeroKm()) {
				if (vehiculo.getKilometraje() < vehiculo.CANT_MAX_KILOMETRAJE) {
					motosUsadas.add((Moto) vehiculo);
					return true;
				}
			} else {
				motosNuevas.add((Moto) vehiculo);
				return true;
			}
		default:
			System.out.println("Tipo inválido");
		}
		return false;
	}
	
	public int getCantidadDeAutosNuevos() {
		return autosNuevos.size();
	}

	public int getCantidadDeAutosUsados() {
		return autosUsados.size();
	}

	public HashSet<Auto> getAutosNuevos() {
		return autosNuevos;
	}

	public void setAutosNuevos(HashSet<Auto> nuevos) {
		this.autosNuevos = nuevos;
	}

	public HashSet<Auto> getAutosUsados() {
		return autosUsados;
	}

	public void setAutosUsados(HashSet<Auto> usados) {
		this.autosUsados = usados;
	}

	public HashSet<Moto> getMotosNuevas() {
		return motosNuevas;
	}

	public void setMotosNuevas(HashSet<Moto> motosNuevas) {
		this.motosNuevas = motosNuevas;
	}

	public HashSet<Moto> getMotosUsadas() {
		return motosUsadas;
	}

	public void setMotosUsadas(HashSet<Moto> motosUsadas) {
		this.motosUsadas = motosUsadas;
	}

	public int cantidadDeMotosNuevas() {
		return motosNuevas.size();
	}

	public int cantidadDeMotosUsadas() {
		return motosUsadas.size();
	}

	public HashSet<Camion> getCamionesNuevos() {
		return camionesNuevos;
	}

	public void setCamionesNuevos(HashSet<Camion> camionesNuevos) {
		this.camionesNuevos = camionesNuevos;
	}

	public HashSet<Camion> getCamionesUsados() {
		return camionesUsados;
	}

	public void setCamionesUsados(HashSet<Camion> camionesUsados) {
		this.camionesUsados = camionesUsados;
	}

	public int cantidadDeCamionesUsados() {
		return camionesUsados.size();
	}

	public int cantidadDeCamionesNuevos() {
		return camionesNuevos.size();
	}

	public void agregarVehiculosNuevos() {
		garajeNuevos.addAll(autosNuevos);
		garajeNuevos.addAll(camionesNuevos);
		garajeNuevos.addAll(motosNuevas);
	}

	public void agregarVehiculosUsados() {
		garajeUsados.addAll(autosUsados);
		garajeUsados.addAll(camionesUsados);
		garajeUsados.addAll(motosUsadas);
	}

	public int cantidadDeVehiculosNuevos() {
		return garajeNuevos.size();
	}

	public int cantidadDeVehiculosUsados() {
		return garajeUsados.size();
	}

	public void quitarMotoDelGaraje(Integer numeroDeSerie) {
		for (Vehiculo actual : motosNuevas) {
			if (actual.getNumeroDeSerie().equals(numeroDeSerie)) {
				garajeNuevos.remove(actual);
			}
		}
		for (Vehiculo actual : motosUsadas) {
			if (actual.getNumeroDeSerie().equals(numeroDeSerie)) {
				garajeUsados.remove(actual);
			}
		}
	}

	public void quitarCamionDelGaraje(Integer numeroDeSerie) {
		for (Vehiculo actual : camionesNuevos) {
			if (actual.getNumeroDeSerie().equals(numeroDeSerie)) {
				garajeNuevos.remove(actual);
			}
		}
		for (Vehiculo actual : camionesUsados) {
			if (actual.getNumeroDeSerie().equals(numeroDeSerie)) {
				garajeUsados.remove(actual);
			}
		}
	}

	public void quitarAutoDelGaraje(Integer numeroDeSerie) {
		for (Vehiculo actual : autosNuevos) {
			if (actual.getNumeroDeSerie().equals(numeroDeSerie)) {
				garajeNuevos.remove(actual);
			}
		}
		for (Vehiculo actual : autosUsados) {
			if (actual.getNumeroDeSerie().equals(numeroDeSerie)) {
				garajeUsados.remove(actual);
			}
		}
	}

	public ArrayList<Vehiculo> obtenerVehiculoSegunFabricante(Fabricante fabricante) {
		ArrayList<Vehiculo> encontrados = new ArrayList<>();
		for (Vehiculo actual : garajeNuevos) {
			if (actual.getFabricante().equals(fabricante)) {
				encontrados.add(actual);
			}
		}
		for (Vehiculo actual : garajeUsados) {
			if (actual.getFabricante().equals(fabricante)) {
				encontrados.add(actual);
			}
		}
		return encontrados;
	}

	public Boolean buscarVehiculo(Vehiculo aBuscar) {
		if(buscarVehiculoEnGarageDeNuevos(aBuscar)) 
			return true;
		else
			if(buscarVehiculoEnGarageDeUsados(aBuscar))
				return true;
		return false;
	}

	private boolean buscarVehiculoEnGarageDeUsados(Vehiculo aBuscar) {
		for (Vehiculo usado : garajeUsados) {
			if(usado.getNumeroDeSerie().equals(aBuscar.getNumeroDeSerie()))
				return true;
		}
		return false;
	}

	private boolean buscarVehiculoEnGarageDeNuevos(Vehiculo aBuscar) {
		for (Vehiculo nuevo : garajeNuevos) {
			if (nuevo.getNumeroDeSerie().equals(aBuscar.getNumeroDeSerie()))
				return true;
		}
		return false;
	}

}