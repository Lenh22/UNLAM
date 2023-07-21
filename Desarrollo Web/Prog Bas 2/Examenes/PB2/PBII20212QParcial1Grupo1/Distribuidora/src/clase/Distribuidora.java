package clase;

public class Distribuidora {

	private String nombre;
	private Producto[] productos;
	private Cliente[] clientes;
	private Producto[] productosVendidos;
	private Empleado[] empleados;
	private Empleado[] empleadosDespedidos;

	public Distribuidora(String nombre) {
		this.nombre = nombre;
		this.productos = new Producto[100];
		this.clientes = new Cliente[100];
		this.productosVendidos = new Producto[100];
		this.empleados = new Empleado[100];
		this.empleadosDespedidos = new Empleado[100];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Producto[] getProductos() {
		return productos;
	}

	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}

	public Producto[] getProductosVendidos() {
		return productosVendidos;
	}

	public void setProductosVendidos(Producto[] productosVendidos) {
		this.productosVendidos = productosVendidos;
	}

	public Empleado[] getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Empleado[] empleados) {
		this.empleados = empleados;
	}

	public Empleado[] getEmpleadosDespedidos() {
		return empleadosDespedidos;
	}

	public Boolean agregarLote(Producto producto) {
		Boolean seAgrego = false;
		if (this.buscarLote(producto.getnLote()) == null) {
			for (int i = 0; i < productos.length; i++) {
				if (productos[i] == null) {
					productos[i] = producto;
					seAgrego = true;
					break;
				}
			}
		}
		return seAgrego;
	}

	public Boolean agregarCLiente(Cliente cliente) {
		Boolean seAgrego = false;
		if (this.buscarCliente(cliente.getCuil()) == null) {
			for (int i = 0; i < clientes.length; i++) {
				if (clientes[i] == null) {
					clientes[i] = cliente;
					seAgrego = true;
					break;
				}
			}
		}
		return seAgrego;
	}

	public Boolean eliminarCliente(Cliente cliente) {
		Boolean seElimino = false;
		for (int i = 0; i < clientes.length; i++) {

			if (clientes[i] != null) {

				if (clientes[i].getCuil().equals(cliente.getCuil())) {
					clientes[i] = null;
					seElimino = true;
					break;
				}
			}

		}

		return seElimino;
	}

	public Boolean agregarEmpleado(Empleado empleado) {

		Boolean seAgrego = false;

		if (this.comprobarSiExisteUnEmpleado(empleado).equals(Boolean.FALSE)) {
			for (int i = 0; i < empleados.length; i++) {
				if (empleados[i] == null) {

					empleados[i] = empleado;

					seAgrego = true;
					break;
				}
			}

		}
		return seAgrego;
	}

	public Boolean agregarEmpleadoDespedido(Empleado empleado) {
		Boolean seAgrego = false;
		for (int i = 0; i < empleadosDespedidos.length; i++) {
			if (empleadosDespedidos[i] == null) {
				empleadosDespedidos[i] = empleado;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}

	public Producto buscarLote(Integer numeroLote) {
		Producto loteBuscado = null;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] != null) {
				if (productos[i].getnLote().equals(numeroLote)) {
					loteBuscado = productos[i];
					break;
				}
			}
		}
		return loteBuscado;
	}

	public Cliente buscarCliente(Integer cuil) {
		Cliente clienteBuscado = null;
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] != null) {
				if (clientes[i].getCuil().equals(cuil)) {
					clienteBuscado = clientes[i];
					break;
				}
			}
		}
		return clienteBuscado;
	}

//	Dudo que lo usemos pero lo hice buscando vender a empleado un lote
//Spoiler, si lo usamos
	public Empleado buscarEmpleado(Integer cuil) {
		Empleado empleadoBuscado = null;
		for (int i = 0; i < empleados.length; i++) {
			if (empleados[i] != null) {
				if (empleados[i].getCuil().equals(cuil)) {
					empleadoBuscado = empleados[i];
					break;
				}
			}
		}
		return empleadoBuscado;
	}

	public Boolean venderProductoPorUnidad(Integer numeroLote, Integer cuilCliente, Integer cantProductoAComprar) {
		Boolean seVendio = false;
		// if (this.buscarCliente(cliente.getCuil() )!= null)
		if (verificarMinorista(cuilCliente)) {
			for (int j = 0; j < productos.length; j++) {
				if (productos[j] != null) {
					if (productos[j].getnLote().equals(numeroLote)) {
						if (productos[j].getCantidadDeProductosEnLaCaja() >= cantProductoAComprar) { // verifica que
																										// haya mas de 1
																										// solo producto
																										// en el lote
							productos[j].setCantidadDeProductosEnLaCaja(
									productos[j].getCantidadDeProductosEnLaCaja() - cantProductoAComprar);
							seVendio = true;
							break;
						}
					}
				}
			}
		}
		return seVendio;

	}

	public Boolean venderLote(Integer numeroLote, Integer cuilCliente) {
		Boolean seVendio = false;
		if (this.buscarCliente(cuilCliente) != null) {
			for (int i = 0; i < productos.length; i++) {
				if (productos[i] != null) {
					if (productos[i].getnLote().equals(numeroLote)) {
						agregarLoteVendido(productos[i]);
						productos[i] = null;
						seVendio = true;
						break;
					}
				}
			}
		}
		return seVendio;
	}

	public Boolean verificarMinorista(Cliente cliente) {
		Boolean esMinorista = false;
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] != null) {
				if (clientes[i].equals(cliente)) {
					if (clientes[i].isMayorista() == false) {
						esMinorista = true;
						break;
					}
				}
			}
		}
		return esMinorista;
	}

//	Duda con este metodo, me tira false en test al agregar otro empleado a comprar
//Arreglado: Problemas tecnicos sobre las llaves	

	public Boolean venderLoteAEmpleado(Integer numeroLote, Empleado empleado) {
		Boolean seVendio = false;
		if (this.buscarEmpleado(empleado.getCuil()) != null) {
			for (int i = 0; i < productos.length; i++) {
				if (productos[i] != null) {
					if (productos[i].getnLote().equals(numeroLote)) {
						productos[i].setPrecio(productos[i].getPrecio() * empleado.valorConDescuento());
						agregarLoteVendido(productos[i]);
						productos[i] = null;
						seVendio = true;
						break;
					}
				}
			}
		}
		return seVendio;
	}

	public Boolean verificarMinorista(Integer cuilCliente) {
		Boolean esMinorista = false;
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] != null) {
				if (clientes[i].getCuil().equals(cuilCliente)) {
					if (clientes[i].isMayorista() == false) {
						esMinorista = true;
						break;
					}
				}
			}
		}
		return esMinorista;
	}

	public Boolean despedirEmpleado(Empleado empleado) {
		Boolean seDespidio = false;
		for (int i = 0; i < empleados.length; i++) {
			if (empleados[i] != null) {

				if (empleados[i].equals(empleado)) {
					agregarEmpleadoDespedido(empleados[i]);
					empleados[i] = null;
					seDespidio = true;
					break;
				}
			}
		}
		return seDespidio;
	}

	public Boolean agregarLoteVendido(Producto lote) {
		Boolean seAgrego = false;
		for (int i = 0; i < productosVendidos.length; i++) {
			if (productosVendidos[i] == null) {
				productosVendidos[i] = lote;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}

	public Producto[] lotesVendidos() {
		return productosVendidos;

	}

	public Producto[] lotesEnStock() {
		return productos;
	}

	public Empleado[] empleadosContratados() {
		return empleados;
	}

	public Empleado[] empleadosDespedidos() {
		return empleadosDespedidos;
	}

	public Cliente[] clientes() {
		return clientes;
	}

//	Problemas con llaves arreglados

	public Boolean comprobarSiExisteUnEmpleado(Empleado empleado) {

		Boolean existe = false;

		for (int i = 0; i < empleados.length; i++) {
			if (empleados[i] != null) {
				if (empleados[i].equals(empleado)) {

					existe = true;

					break;
				}

			}

		}
		return existe;

	}

	public Double calcularSueldoTotalDeEmpleados() {
		Double sueldoTotal = 0.0;
		for (int i = 0; i < empleados.length; i++) {
			if (empleados[i] != null) {
				sueldoTotal += empleados[i].calcularSueldo();
			}
		}
		return sueldoTotal;
	}

	public void ordenarClientesSegunSuCuil() {
		Cliente auxiliarOrdenamiento;
		for (int i = 1; i < clientes.length; i++) {
			for (int j = 0; j < (clientes.length - 1); j++) {
				if (clientes[j] != null && clientes[j + 1] != null) {
					if (clientes[j].getCuil() > clientes[j + 1].getCuil()) {
						auxiliarOrdenamiento = clientes[j + 1];
						clientes[j + 1] = clientes[j];
						clientes[j] = auxiliarOrdenamiento;
					}
				}
			}
		}
	}

	public void ordenarEmpleadosContratados() {
		Empleado auxiliarOrdenamiento;
		for (int i = 1; i < empleados.length; i++) {
			for (int j = 0; j < (empleados.length - 1); j++) {
				if (empleados[j] != null && empleados[j + 1] != null) {
					if (empleados[j].getCuil() > empleados[j + 1].getCuil()) {
						auxiliarOrdenamiento = empleados[j + 1];
						empleados[j + 1] = empleados[j];
						empleados[j] = auxiliarOrdenamiento;
					}
				}
			}
		}
	}

}