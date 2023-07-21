public class MRU {
	public static void main (String [] arg){
	Automovil mini = new Automovil (120, 20);
	
		System.out.println (mini.getDatos());
	Automovil ferrari = new Automovil (200, 40);
	
		System.out.println (ferrari.getDatos());
	Automovil fitito = new Automovil (40, 2.25 );
	
		System.out.println (fitito.getDatos());
		
		System.out.println("Velocidad max en mini");
		mini.alcanzarVelocidadMaxima(15, 200);
		System.out.println("Velocidad max en ferrari");
		ferrari.alcanzarVelocidadMaxima(40, 350);
		System.out.println("Velocidad max en fitito");
		fitito.alcanzarVelocidadMaxima(4, 90);
	}
}