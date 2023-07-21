public class Alarma {
	private boolean sensor1;
	private boolean sensor2;
	private boolean sensor3;
	private boolean encendido;
	private int codigoDeSeguridad;
	private boolean sonarSirena;
	
	//constructor
	public Alarma(int codigoDeSeguridad) {
		this.codigoDeSeguridad = codigoDeSeguridad;
		this.encendido = false;
		this.sensor1= false;
		this.sensor2=false;
		this.sensor3= false;
		this.sonarSirena =false;
	}
	
// metodo 
		public void encender(int codigo) {
			if(this.codigoDeSeguridad==codigo) {
				this.encendido = true; 
			}
			else {
				this.encendido = false;
			}
		
		}
		public boolean getEncender() {
			return this.encendido;
		}

		public void apagar(int codigo) {
			if(this.codigoDeSeguridad==codigo) {
				this.encendido = false;
				this.sensor1 = false;
				this.sensor2 = false;
				this.sensor3 = false;
				this.sonarSirena = false;
			}
			
		}
		public void activarSensores() {
			if(this.encendido==true) {
			this.sensor1 = true;
			this.sensor2 = true;
			this.sensor3 = true;
		}
			else {
				this.sensor1 = false;
				this.sensor2 = false;
				this.sensor3 = false;
			}
		}
		public boolean getSensor1() {
			return this.sensor1;
		}
		public boolean getSensor2() {
			return this.sensor2;
		}

		public boolean getSensor3() {
			return this.sensor3;
		}
		public void sonarSirena() {
			if (this.sensor1==true&&this.sensor2==true&&this.sensor3==true) {
				this.sonarSirena= true;
			}
			else {
				this.sonarSirena= false;
			}
		}

		public boolean getSirena() {
			return this.sonarSirena;
		}
}