public class Objeto{
//Metodo
	private int VEL_INI = 0 ;
	private double tiempo;
	private double gravedad;
//Construccion
	public Objeto (double tiempo, double gravedad){
		this.tiempo=tiempo;
		this.gravedad=gravedad;
	}
	
//Metodo
	public double getAltura(){
		double altura = (VEL_INI*tiempo + (gravedad* (tiempo*tiempo)))/2;
		return altura;
	}
	public String getDatos(){
	return ("La altura H es: " + getAltura());
	}
	
}