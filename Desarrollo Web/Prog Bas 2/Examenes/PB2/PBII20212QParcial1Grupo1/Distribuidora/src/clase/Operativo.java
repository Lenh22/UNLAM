package clase;

public class Operativo extends Empleado {

	public Operativo(String nombre, Integer cuil, Departamento departamento) {
		super(nombre, cuil, departamento);
		setPorcentajeExtraSueldo(0.1);
		setPorcentajeDescuento(0.05);
	}

	@Override
	public Double calcularSueldo() {


		Double sueldoFinal = 0.0;
		sueldoFinal += getSueldoBase() + (getSueldoBase() * super.getPorcentajeExtraSueldo());
		return sueldoFinal;

	}

	@Override
	public Double valorConDescuento() {
		Double valorTotal = 0.0;
		valorTotal = 1.0 - this.getPorcentajeDescuento();
		return valorTotal;
	}
}
