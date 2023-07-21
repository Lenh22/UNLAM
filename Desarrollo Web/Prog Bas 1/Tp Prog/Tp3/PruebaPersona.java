public class PruebaPersona {
	public static void main(String[]args) {
	Persona p1 = new Persona("Esteban","Hombre", 324234l,80.0, 1.80);

	p1.alimentar(0.5);
	System.out.println(p1.pesar());
	
	p1.crecer(0.60);
	System.out.println(p1.getCrecer());
	
	p1.cumplirAnos();
	p1.cumplirAnos();
	System.out.println(p1.getCantidadAnos());
	
	p1.esMayorDeEdad(15);
	System.out.println(p1.getEdad());
	p1.esMayorDeEdad(18);
	System.out.println(p1.getEdad());
	
	p1.morir();
	System.out.println(p1.getMorir());
	
	
	System.out.println(p1.toString());
	
	System.out.println(p1.calcularIMC());
	
	
	
	
	
	}
}