public class PruebaAlarma{
		
		public static void main(String[]args) {
		Alarma pentagono = new Alarma(1234);
		//codigo de seguridad
		pentagono.encender(1234);
		System.out.println(pentagono.getEncender());
		
		//sensores
		pentagono.activarSensores();
		System.out.println(pentagono.getSensor1());
		System.out.println(pentagono.getSensor2());
		System.out.println(pentagono.getSensor3());
		
		//sirena 
		pentagono.sonarSirena();
		System.out.println(pentagono.getSirena());
		
		//apagar todo
		pentagono.apagar(1234);
		System.out.println(pentagono.getSensor1());
		System.out.println(pentagono.getSensor2());
		System.out.println(pentagono.getSensor3());
		System.out.println(pentagono.getSirena());
		
		}


}