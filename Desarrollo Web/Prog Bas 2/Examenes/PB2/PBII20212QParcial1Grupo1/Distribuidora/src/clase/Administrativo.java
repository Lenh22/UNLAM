package clase;

public class Administrativo extends Empleado {

	public Administrativo(String nombre, Integer cuil, Departamento departamento) {
		super(nombre, cuil, departamento);
		setPorcentajeExtraSueldo(0.05);
		setPorcentajeDescuento(0.1);

	}

	@Override
	public Double calcularSueldo() {


		Double sueldoFinal = 0.0;
		sueldoFinal += getSueldoBase() + (getSueldoBase() * super.getPorcentajeExtraSueldo());
		return sueldoFinal;

		// Otra manera quitandole el "final" a sueldoBase
		// this.setSueldoBase(getSueldoBase()+getSueldoBase()*super.getPorcentajeExtraSueldo());
	}

	@Override
	public Double valorConDescuento() {
		Double valorTotal = 0.0;
		valorTotal = 1.0 - this.getPorcentajeDescuento();
		return valorTotal;

	}

}
