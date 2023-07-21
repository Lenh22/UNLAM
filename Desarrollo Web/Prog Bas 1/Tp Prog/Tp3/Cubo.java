public class Cubo{
	private float LongitudLado;
	
	public Cubo(float lado){
	this.LongitudLado = lado;
	}

	public float getLado(){
		return this.LongitudLado;
	
	}
	
	
	public void setLongitudLado(float lado){
		 this.LongitudLado = lado;
	}
	
	public float getSuperficieCara(){
		return this.LongitudLado = (this.LongitudLado * this.LongitudLado) * 6;
		}
	
	
	public float getVolumen(){
		float volumen = this.LongitudLado * this.LongitudLado * this.LongitudLado;  
		return volumen;
	}

}