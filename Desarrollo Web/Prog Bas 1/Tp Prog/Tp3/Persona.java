public class Persona {
	
		//atributos
		private String nombre;
		private String genero;
		private long dni;
		private double peso;
		private double altura;
		private int edad;
		private boolean viva;
		private boolean mayor;
		private double imc;
		
		//constructor
		public Persona(String nombre ,String genero ,long  dni ,double peso , double altura){

		this.nombre = nombre;	
		this.genero = genero;
		this.dni = dni;
		this.peso = peso; 
		this.altura = altura;
		this.edad = 0; 
		this.viva = true;
		this.mayor = false;
		this.imc = 0;
		}
		

	//metodos
		public boolean esMayorDeEdad(int edad){
			if (edad>=18){
				this.mayor = true;
			}
			else{
				this.mayor = false;
			}
			return this.mayor;
		}
		public boolean getEdad() {
			return this.mayor;
		}
		public String toString(){
		return	nombre+" es un "+genero+" dni "+dni+" que pesa "+peso+" y mide "+altura+" y tiene "+this.edad+" años";
	}
		
		public void alimentar(double kilos){
		this.peso += kilos;
	}
		public double pesar(){
			return this.peso;
		}
		
		public void crecer(double metros){
		this.altura += metros;
	}
		public double getCrecer() {
			return this.altura;
		}
		public void cumplirAnos(){
				this.edad++;
	
	}
		public int getCantidadAnos() {
			return this.edad;
		}
		
		public void morir(){
		this.viva = true;
	}
		public boolean getMorir() {
			return this.viva;
		}
		
		public double calcularIMC() {
			this.imc = (this.peso/ (this.altura*this.altura));
			
			if (this.imc>25){
				return 1;
			}
			else {
				if(this.imc>=20 && this.imc<=25) {
					return 0;
				}
				else {
					return  -1;
				}
			}
			
			
		
		}
}