package clase;

public class Departamento {
	private String nombre;
	private Empleado empleado;


	public String getNombre() {
		return nombre;
	}

	public Departamento(String nombre) {
		this.nombre = nombre;

	}
		//Se agrego este constructor por si queremos meter un empleado al departamento.
	public Departamento(String nombre, Empleado empleado) {
		this.nombre = nombre;
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Departamento [nombre=" + nombre + "]";
	}


}
